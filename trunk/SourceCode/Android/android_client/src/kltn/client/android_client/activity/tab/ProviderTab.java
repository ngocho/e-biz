//======================================================================================================

package kltn.client.android_client.activity.tab;

import kltn.client.android_client.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

//======================================================================================================

/**
 * @author NThanhPhong
 *
 */
public class ProviderTab extends BaseTab {
    // ======================================================================================================
    /**  . */
    private int idProvider;
    /**  . */
    private TextView mNameProvider;
    /**  . */
    private Button mAddress;
    /**  . */
    private Button mPhone;

    // ======================================================================================================

    /**
     * @param activity Activity
     * @param idprovider int
     */
    public ProviderTab(Activity activity, int idprovider) {
        super(activity);
        idProvider = idprovider;
    }

    // ======================================================================================================

    @Override
    public void Initialize() {
        this.mView = this.mParentActivity.getLayoutInflater().inflate(R.layout.tab_detail_provider, null);

        mNameProvider = (TextView) this.mView.findViewById(R.id.tab_detail_provider_name);
        mAddress = (Button) this.mView.findViewById(R.id.tab_detail_provider_address);
        mPhone = (Button) this.mView.findViewById(R.id.tab_detail_provider_phone);
        mNameProvider.setText(idProvider + " - ");
    }

    @Override
    public void Release() {
    }

    // ======================================================================================================

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
