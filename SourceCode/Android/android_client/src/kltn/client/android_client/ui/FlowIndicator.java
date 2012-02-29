package kltn.client.android_client.ui;

/**
 * @author NThanhPhongs
 */
public interface FlowIndicator extends ViewSwitchListener {
    /**
     * [Give the description for method].
     * @param view ViewFlow
     */
    public void setViewFlow(ViewFlow view);

    /**
     * The scroll position has been changed. A FlowIndicator may implement this method to reflect the current position
     * @param h int
     * @param v int
     * @param oldh int
     * @param oldv int
     */
    public void onScrolled(int h, int v, int oldh, int oldv);
}
