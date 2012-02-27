//======================================================================================================

package kltn.client.android_client.activity.tab;

import android.app.Activity;
import android.view.View;

//======================================================================================================

/**
 * @author NThanhPhong
 *
 */
public abstract class BaseTab {
    // ======================================================================================================

    /**  . */
    protected View mView;
    /**  . */
    protected Activity mParentActivity;

    // ======================================================================================================

    /**
     * @param activity Activity
     */
    public BaseTab(Activity activity) {
        this.mParentActivity = activity;
    }
    /**
     * [Give the description for method].
     */
    public abstract void pressBackKey();
    /**
     * [Give the description for method].
     * @return int
     */
    public abstract int whichViewDisplay();
    // ======================================================================================================

    /**
     * [Give the description for method].
     */
    public abstract void Initialize();

    /**
     * [Give the description for method].
     */
    public abstract void Release();

    /**
     * [Give the description for method].
     * @return View
     */
    public View GetView() {
        return this.mView;
    }

    // ======================================================================================================
}
