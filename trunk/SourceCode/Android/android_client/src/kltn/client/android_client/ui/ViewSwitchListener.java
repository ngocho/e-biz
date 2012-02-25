package kltn.client.android_client.ui;

import android.view.View;

/**
 * @author NThanhPhong
 *
 */
public interface ViewSwitchListener {

    /**
     * This method is called when a new View has been scrolled to.
     * @param view the {@link View} currently in focus.
     * @param position The position in the adapter of the {@link View} currently in focus.
     */
    void onSwitched(View view, int position);

}
