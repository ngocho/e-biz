//========================================================================================================

package kltn.client.android_client.activity.tab;

import kltn.client.android_client.R;

import org.json.JSONObject;

import android.app.Activity;
import android.widget.TextView;

//========================================================================================================

/**
 * @author NThanhPhong
 *
 */
public class ContentTab extends BaseTab {
    // ========================================================================================================

    /**  . */
    private JSONObject data;
    /**  . */
    private TextView content;
    /**  . */
    private TextView cooking;

    /**
     * @param activity Activity
     * @param mdata JSONObject
     */
    public ContentTab(Activity activity, JSONObject mdata) {
        super(activity);
        data = mdata;
    }

    @Override
    public void Initialize() {
        this.mView = this.mParentActivity.getLayoutInflater().inflate(R.layout.tab_detail_content, null);
        content = (TextView) this.mView.findViewById(R.id.tab_detail_content_info);
        cooking = (TextView) this.mView.findViewById(R.id.tab_detail_content_use);
        try {
            content.setText(data.getString("detail"));
            cooking.setText(data.getString("cooking"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Release() {

    }

    @Override
    public void pressBackKey() {
    }

    /*
     * (non-Javadoc)
     * @see kltn.client.android_client.activity.tab.BaseTab#whichViewDisplay()
     */
    @Override
    public int whichViewDisplay() {
        // TODO Auto-generated method stub
        return 0;
    }
}
