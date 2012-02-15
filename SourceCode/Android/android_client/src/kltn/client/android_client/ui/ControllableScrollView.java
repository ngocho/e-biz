package kltn.client.android_client.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ControllableScrollView extends ScrollView {
	public ControllableScrollView(Context context) {
		super(context);
	}

	public ControllableScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ControllableScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		//return super.onInterceptTouchEvent(ev);
		if (allowScroll) {
			return super.onInterceptTouchEvent(ev);
		} else {
			return false;
		}
	}
	
	public void setScrollingEnabled(boolean enable) {
		allowScroll = enable;
	}
	
	private boolean allowScroll = true;
}
