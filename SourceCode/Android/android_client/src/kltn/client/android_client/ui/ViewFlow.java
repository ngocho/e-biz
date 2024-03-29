package kltn.client.android_client.ui;

import java.util.ArrayList;
import java.util.LinkedList;

import kltn.client.android_client.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Scroller;

/**
 * @author NThanhPhong
 */
public class ViewFlow extends AdapterView<Adapter> {
    /** . */
    private static final int SNAP_VELOCITY = 1000;
    /** . */
    private static final int INVALID_SCREEN = -1;
    /** . */
    private final static int TOUCH_STATE_REST = 0;
    /** . */
    private final static int TOUCH_STATE_SCROLLING = 1;
    /** . */
    private LinkedList<View> mLoadedViews;
    /** . */
    private int mCurrentBufferIndex;
    /** . */
    private int mCurrentAdapterIndex;
    /** . */
    private int mSideBuffer = 0;
    /** . */
    private Scroller mScroller;
    /** . */
    private VelocityTracker mVelocityTracker;
    /** . */
    private int mTouchState = TOUCH_STATE_REST;
    /** . */
    private float mLastMotionX;
    /** . */
    private int mTouchSlop;
    /** . */
    private int mMaximumVelocity;
    /** . */
    public int mCurrentScreen;
    /** . */
    private int mNextScreen = INVALID_SCREEN;
    /** . */
    private boolean mFirstLayout = true;
    /** . */
    private ViewSwitchListener mViewSwitchListener;
    /** . */
    private Adapter mAdapter;
    /** . */
    private int mLastScrollDirection;
    /** . */
    private AdapterDataSetObserver mDataSetObserver;
    /** . */
    private FlowIndicator mIndicator;

    /**
     * [Give the description for method].
     */
    public void next() {
        if (mCurrentScreen < getChildCount() - 1) {
            snapToScreen(mCurrentScreen + 1);
        }
    }

    /**
     * [Give the description for method].
     */
    public void pre() {
        if (mCurrentScreen > 0) {
            snapToScreen(mCurrentScreen - 1);
        }
    }

    /** . */
    private OnGlobalLayoutListener orientationChangeListener = new OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            getViewTreeObserver().removeGlobalOnLayoutListener(orientationChangeListener);
            setSelection(mCurrentAdapterIndex);
        }
    };

    /**
     * @param context Context
     */
    public ViewFlow(Context context) {
        super(context);
        mSideBuffer = 1;
        init();
    }

    /**
     * @param context Context
     * @param sideBuffer int
     */
    public ViewFlow(Context context, int sideBuffer) {
        super(context);
        mSideBuffer = sideBuffer;
        init();
    }

    /**
     * @param context Context
     * @param attrs AttributeSet
     */
    public ViewFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.ViewFlow);
        mSideBuffer = styledAttrs.getInt(R.styleable.ViewFlow_sidebuffer, 1);
        init();
    }

    /**
     * [init].
     */
    private void init() {
        mLoadedViews = new LinkedList<View>();
        mScroller = new Scroller(getContext());
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
    }

    /**
     * [getViewsCount].
     * @return int
     */
    public int getViewsCount() {
        return mAdapter.getCount();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int width = MeasureSpec.getSize(widthMeasureSpec);
        // final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        // if (widthMode != MeasureSpec.EXACTLY) {
        // throw new IllegalStateException(
        // "ViewFlow can only be used in EXACTLY mode.");
        // }

        // final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        // if (heightMode != MeasureSpec.EXACTLY) {
        // throw new IllegalStateException(
        // "ViewFlow can only be used in EXACTLY mode.");
        // }

        // The children are given the same width and height as the workspace
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
        }

        if (mFirstLayout) {
            scrollTo(mCurrentScreen * width, 0);
            mFirstLayout = false;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;

        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                final int childWidth = child.getMeasuredWidth();
                child.layout(childLeft, 0, childLeft + childWidth, child.getMeasuredHeight());
                childLeft += childWidth;
            }
        }
    }

    /**
     * [Explain the description for this method here].
     * @param ev MotionEvent
     * @return boolean
     * @see android.view.ViewGroup#onInterceptTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (getChildCount() == 0) {
            return false;
        }

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        final int action = ev.getAction();
        final float x = ev.getX();

        switch (action) {
            case MotionEvent.ACTION_DOWN :
                /*
                 * If being flinged and user touches, stop the fling. isFinished will be false if being flinged.
                 */
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }

                // Remember where the motion event started
                mLastMotionX = x;

                mTouchState = mScroller.isFinished() ? TOUCH_STATE_REST : TOUCH_STATE_SCROLLING;

                break;

            case MotionEvent.ACTION_MOVE :
                final int xDiff = (int) Math.abs(x - mLastMotionX);

                boolean xMoved = xDiff > mTouchSlop;

                if (xMoved) {
                    // Scroll if the user moved far enough along the X axis
                    mTouchState = TOUCH_STATE_SCROLLING;
                }

                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    // Scroll to follow the motion event
                    final int deltaX = (int) (mLastMotionX - x);
                    mLastMotionX = x;

                    final int scrollX = getScrollX();
                    if (deltaX < 0) {
                        if (scrollX > 0) {
                            scrollBy(Math.max(-scrollX, deltaX), 0);
                        }
                    } else if (deltaX > 0) {
                        final int availableToScroll = getChildAt(getChildCount() - 1).getRight() - scrollX - getWidth();
                        if (availableToScroll > 0) {
                            scrollBy(Math.min(availableToScroll, deltaX), 0);
                        }
                    }
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP :
                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                    int velocityX = (int) velocityTracker.getXVelocity();

                    if (velocityX > SNAP_VELOCITY && mCurrentScreen > 0) {
                        // Fling hard enough to move left
                        snapToScreen(mCurrentScreen - 1);
                    } else if (velocityX < -SNAP_VELOCITY && mCurrentScreen < getChildCount() - 1) {
                        // Fling hard enough to move right
                        snapToScreen(mCurrentScreen + 1);
                    } else {
                        snapToDestination();
                    }

                    if (mVelocityTracker != null) {
                        mVelocityTracker.recycle();
                        mVelocityTracker = null;
                    }
                }

                mTouchState = TOUCH_STATE_REST;

                break;
            case MotionEvent.ACTION_CANCEL :
                mTouchState = TOUCH_STATE_REST;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (getChildCount() == 0) {
            return false;
        }

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        final int action = ev.getAction();
        final float x = ev.getX();

        switch (action) {
            case MotionEvent.ACTION_DOWN :
                /*
                 * If being flinged and user touches, stop the fling. isFinished will be false if being flinged.
                 */
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }

                // Remember where the motion event started
                mLastMotionX = x;

                mTouchState = mScroller.isFinished() ? TOUCH_STATE_REST : TOUCH_STATE_SCROLLING;

                break;

            case MotionEvent.ACTION_MOVE :
                final int xDiff = (int) Math.abs(x - mLastMotionX);

                boolean xMoved = xDiff > mTouchSlop;

                if (xMoved) {
                    // Scroll if the user moved far enough along the X axis
                    mTouchState = TOUCH_STATE_SCROLLING;
                }

                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    // Scroll to follow the motion event
                    final int deltaX = (int) (mLastMotionX - x);
                    mLastMotionX = x;

                    final int scrollX = getScrollX();
                    if (deltaX < 0) {
                        if (scrollX > 0) {
                            scrollBy(Math.max(-scrollX, deltaX), 0);
                        }
                    } else if (deltaX > 0) {
                        final int availableToScroll = getChildAt(getChildCount() - 1).getRight() - scrollX - getWidth();
                        if (availableToScroll > 0) {
                            scrollBy(Math.min(availableToScroll, deltaX), 0);
                        }
                    }
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP :
                if (mTouchState == TOUCH_STATE_SCROLLING) {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                    int velocityX = (int) velocityTracker.getXVelocity();

                    if (velocityX > SNAP_VELOCITY && mCurrentScreen > 0) {
                        // Fling hard enough to move left
                        snapToScreen(mCurrentScreen - 1);
                    } else if (velocityX < -SNAP_VELOCITY && mCurrentScreen < getChildCount() - 1) {
                        // Fling hard enough to move right
                        snapToScreen(mCurrentScreen + 1);
                    } else {
                        snapToDestination();
                    }

                    if (mVelocityTracker != null) {
                        mVelocityTracker.recycle();
                        mVelocityTracker = null;
                    }
                }

                mTouchState = TOUCH_STATE_REST;

                break;
            case MotionEvent.ACTION_CANCEL :
                mTouchState = TOUCH_STATE_REST;
        }
        return true;
    }

    @Override
    protected void onScrollChanged(int h, int v, int oldh, int oldv) {
        super.onScrollChanged(h, v, oldh, oldv);
        if (mIndicator != null) {
            /*
             * The actual horizontal scroll origin does typically not match the perceived one. Therefore, we need to
             * calculate the perceived horizontal scroll origin here, since we use a view buffer.
             */
            int hPerceived = h + (mCurrentAdapterIndex - mCurrentBufferIndex) * getWidth();
            mIndicator.onScrolled(hPerceived, v, oldh, oldv);
        }
    }

    /**
     * [snapToDestination].
     */
    private void snapToDestination() {
        final int screenWidth = getWidth();
        final int whichScreen = (getScrollX() + (screenWidth / 2)) / screenWidth;

        snapToScreen(whichScreen);
    }

    /**
     * [snapToScreen].
     * @param whichScreen int
     */
    private void snapToScreen(int whichScreen) {
        mLastScrollDirection = whichScreen - mCurrentScreen;
        if (!mScroller.isFinished()) {
            return;
        }

        whichScreen = Math.max(0, Math.min(whichScreen, getChildCount() - 1));

        mNextScreen = whichScreen;

        final int newX = whichScreen * getWidth();
        final int delta = newX - getScrollX();
        mScroller.startScroll(getScrollX(), 0, delta, 0, Math.abs(delta) * 2);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        } else if (mNextScreen != INVALID_SCREEN) {
            mCurrentScreen = Math.max(0, Math.min(mNextScreen, getChildCount() - 1));
            mNextScreen = INVALID_SCREEN;
            postViewSwitched(mLastScrollDirection);
        }
    }

    /**
     * [setVisibleView].
     * @param indexInBuffer int
     * @param uiThread boolean
     */
    private void setVisibleView(int indexInBuffer, boolean uiThread) {
        mCurrentScreen = Math.max(0, Math.min(indexInBuffer, getChildCount() - 1));
        int dx = (mCurrentScreen * getWidth()) - mScroller.getCurrX();
        mScroller.startScroll(mScroller.getCurrX(), mScroller.getCurrY(), dx, 0, 0);
        if (uiThread) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    /**
     * Set the listener that will receive notifications every time the {code ViewFlow} scrolls.
     * @param l the scroll listener
     */
    public void setOnViewSwitchListener(ViewSwitchListener l) {
        mViewSwitchListener = l;
    }

    @Override
    public Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }

        mAdapter = adapter;

        if (mAdapter != null) {
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);

        }
        if (mAdapter.getCount() == 0) {
            return;
        }

        for (int i = 0; i < Math.min(mAdapter.getCount(), mSideBuffer + 1); i++) {
            mLoadedViews.addLast(makeAndAddView(i, true, null));
        }

        mCurrentAdapterIndex = 0;
        mCurrentBufferIndex = 0;
        requestLayout();
        setVisibleView(mCurrentBufferIndex, false);
        if (mViewSwitchListener != null) {
            mViewSwitchListener.onSwitched(mLoadedViews.get(0), 0);
        }
    }

    @Override
    public View getSelectedView() {
        return (mCurrentAdapterIndex < mLoadedViews.size() ? mLoadedViews.get(mCurrentBufferIndex) : null);
    }
    /**
     * [setFlowIndicator]
     * @param flowIndicator FlowIndicator
     */
    public void setFlowIndicator(FlowIndicator flowIndicator) {
        mIndicator = flowIndicator;
        mIndicator.setViewFlow(this);
    }

    /**
     * [Explain the description for this method here].
     * @param position int
     * @see android.widget.AdapterView#setSelection(int)
     */
    @Override
    public void setSelection(int position) {
        if (mAdapter == null || position >= mAdapter.getCount()) {
            return;
        }

        ArrayList<View> recycleViews = new ArrayList<View>();
        View recycleView;
        while (!mLoadedViews.isEmpty()) {
            recycleViews.add(recycleView = mLoadedViews.remove());
            detachViewFromParent(recycleView);
        }

        for (int i = Math.max(0, position - mSideBuffer); i < Math.min(mAdapter.getCount(), position + mSideBuffer + 1); i++) {
            mLoadedViews.addLast(makeAndAddView(i, true, (recycleViews.isEmpty() ? null : recycleViews.remove(0))));
            if (i == position) {
                mCurrentBufferIndex = mLoadedViews.size() - 1;
            }
        }
        mCurrentAdapterIndex = position;

        for (View view : recycleViews) {
            removeDetachedView(view, false);
        }
        requestLayout();
        setVisibleView(mCurrentBufferIndex, false);
        if (mViewSwitchListener != null) {
            if (mIndicator != null) {
                mIndicator.onSwitched(mLoadedViews.get(mCurrentBufferIndex), mCurrentAdapterIndex);
            }
            mViewSwitchListener.onSwitched(mLoadedViews.get(mCurrentBufferIndex), mCurrentAdapterIndex);
        }
    }

    /**
     * [resetFocus].
     */
    private void resetFocus() {
        logBuffer();
        mLoadedViews.clear();
        removeAllViewsInLayout();

        for (int i = Math.max(0, mCurrentAdapterIndex - mSideBuffer); i < Math.min(mAdapter.getCount(),
                mCurrentAdapterIndex + mSideBuffer + 1); i++) {
            mLoadedViews.addLast(makeAndAddView(i, true, null));
            if (i == mCurrentAdapterIndex) {
                mCurrentBufferIndex = mLoadedViews.size() - 1;
            }
        }
        logBuffer();
        requestLayout();
    }

    /**
     * [postViewSwitched].
     * @param direction int
     */
    private void postViewSwitched(int direction) {
        if (direction == 0) {
            return;
        }

        if (direction > 0) { // to the right
            mCurrentAdapterIndex++;
            mCurrentBufferIndex++;

            View recycleView = null;

            // Remove view outside buffer range
            if (mCurrentAdapterIndex > mSideBuffer) {
                recycleView = mLoadedViews.removeFirst();
                detachViewFromParent(recycleView);
                // removeView(recycleView);
                mCurrentBufferIndex--;
            }

            // Add new view to buffer
            int newBufferIndex = mCurrentAdapterIndex + mSideBuffer;
            if (newBufferIndex < mAdapter.getCount()) {
                mLoadedViews.addLast(makeAndAddView(newBufferIndex, true, recycleView));
            }

        } else { // to the left
            mCurrentAdapterIndex--;
            mCurrentBufferIndex--;
            View recycleView = null;

            // Remove view outside buffer range
            if (mAdapter.getCount() - 1 - mCurrentAdapterIndex > mSideBuffer) {
                recycleView = mLoadedViews.removeLast();
                detachViewFromParent(recycleView);
            }

            // Add new view to buffer
            int newBufferIndex = mCurrentAdapterIndex - mSideBuffer;
            if (newBufferIndex > -1) {
                mLoadedViews.addFirst(makeAndAddView(newBufferIndex, false, recycleView));
                mCurrentBufferIndex++;
            }

        }

        requestLayout();
        setVisibleView(mCurrentBufferIndex, true);
        if (mIndicator != null) {
            mIndicator.onSwitched(mLoadedViews.get(mCurrentBufferIndex), mCurrentAdapterIndex);
        }
        if (mViewSwitchListener != null) {
            mViewSwitchListener.onSwitched(mLoadedViews.get(mCurrentBufferIndex), mCurrentAdapterIndex);
        }
        logBuffer();
    }

    /**
     * [Give the description for method].
     * @param child View
     * @param addToEnd boolean
     * @param recycle boolean
     * @return View
     */
    private View setupChild(View child, boolean addToEnd, boolean recycle) {
        ViewGroup.LayoutParams p = (ViewGroup.LayoutParams) child.getLayoutParams();
        if (p == null) {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        }
        if (recycle) {
            attachViewToParent(child, (addToEnd ? -1 : 0), p);
        } else {
            addViewInLayout(child, (addToEnd ? -1 : 0), p, true);
        }
        return child;
    }

    /**
     * [Give the description for method].
     * @param position int
     * @param addToEnd boolean
     * @param convertView View
     * @return View
     */
    private View makeAndAddView(int position, boolean addToEnd, View convertView) {
        View view = mAdapter.getView(position, convertView, this);
        return setupChild(view, addToEnd, convertView != null);
    }

    /**
     * @author NThanhPhong
     */
    class AdapterDataSetObserver extends DataSetObserver {

        @Override
        public void onChanged() {
            View v = getChildAt(mCurrentBufferIndex);
            if (v != null) {
                for (int index = 0; index < mAdapter.getCount(); index++) {
                    if (v.equals(mAdapter.getItem(index))) {
                        mCurrentAdapterIndex = index;
                        break;
                    }
                }
            }
            resetFocus();
        }

        @Override
        public void onInvalidated() {
            // Not yet implemented!
        }

    }

    /**
     * [logBuffer].
     */
    private void logBuffer() {

        Log.d("viewflow", "Size of mLoadedViews: " + mLoadedViews.size() + "X: " + mScroller.getCurrX() + ", Y: "
                + mScroller.getCurrY());
        Log.d("viewflow", "IndexInAdapter: " + mCurrentAdapterIndex + ", IndexInBuffer: " + mCurrentBufferIndex);
    }
}
