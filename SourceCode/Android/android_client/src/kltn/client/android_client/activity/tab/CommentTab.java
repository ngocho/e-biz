//======================================================================================================

package kltn.client.android_client.activity.tab;

import kltn.client.android_client.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;

//======================================================================================================

/**
 * @author NThanhPhong
 *
 */
public class CommentTab extends BaseTab {
    // ======================================================================================================

    /**  . */
    private ListView mListView;
    /**  . */
    private Button mEditButton;

    // ======================================================================================================

    /**
     * @param activity Activity
     */
    public CommentTab(Activity activity) {
        super(activity);
    }

    // ======================================================================================================

    @Override
    public void Initialize() {
        this.mView = this.mParentActivity.getLayoutInflater().inflate(R.layout.tab_detail_content, null);
    }

    @Override
    public void Release() {
    }

    @Override
    public void pressBackKey() {
        // TODO Auto-generated method stub

    }

    @Override
    public int whichViewDisplay() {
        // TODO Auto-generated method stub
        return 0;
    }
}
