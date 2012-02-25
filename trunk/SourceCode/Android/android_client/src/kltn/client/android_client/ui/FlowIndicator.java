package kltn.client.android_client.ui;

public interface FlowIndicator extends ViewSwitchListener {
    public void setViewFlow(ViewFlow view);

    /**
     * The scroll position has been changed. A FlowIndicator may implement this method to reflect the current position
     * @param h
     * @param v
     * @param oldh
     * @param oldv
     */
    public void onScrolled(int h, int v, int oldh, int oldv);
}
