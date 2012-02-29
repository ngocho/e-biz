package kltn.client.android_client.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author NThanhPhong
 */
public class ControllableScrollView extends ScrollView {
    /**
     * @param context Context
     */
    public ControllableScrollView(Context context) {
        super(context);
    }

    /**
     * @param context Context
     * @param attrs AttributeSet
     */
    public ControllableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context Context
     * @param attrs AttributeSet
     * @param defStyle int
     */
    public ControllableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        // return super.onInterceptTouchEvent(ev);
        if (allowScroll) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }

    /**
     * [Give the description for method].
     * @param enable boolean
     */
    public void setScrollingEnabled(boolean enable) {
        allowScroll = enable;
    }

    /** . */
    private boolean allowScroll = true;
}
