/**
 * 
 */
package kltn.client.android_server.object;

import java.text.Annotation;
import java.util.ArrayList;

import kltn.client.android_server.R;
import kltn.client.android_server.activity.ChatActivity;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

/**
 * @author nthanhphong
 *
 */
public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {
    
    private ArrayList<OverlayItem> myOverlays ;
    private Context context;
    private Dialog mDialog;

    public MyItemizedOverlay(Drawable defaultMarker,Context mcontext) {
        super(boundCenterBottom(defaultMarker));
        myOverlays = new ArrayList<OverlayItem>();
        populate();
        context=mcontext;
    }
        
    public void addOverlay(OverlayItem overlay){
        myOverlays.add(overlay);
        populate();
    }

    @Override
    protected OverlayItem createItem(int i) {
        return myOverlays.get(i);
    }
        
    public void removeItem(int i){
        myOverlays.remove(i);
        populate();
    }
        
    @Override
    protected boolean onTap(int i){
            
        
        GeoPoint  gpoint = myOverlays.get(i).getPoint();
        double lat = gpoint.getLatitudeE6()/1e6;
        double lon = gpoint.getLongitudeE6()/1e6;
        String toast = "Title: "+myOverlays.get(i).getTitle();
        toast += "\nText: "+myOverlays.get(i).getSnippet();
        toast += 	"\nSymbol coordinates: Lat = "+lat+" Lon = "+lon+" (microdegrees)";
        Toast.makeText(context, toast, Toast.LENGTH_LONG).show();
        showDialog();
        return(true);
    }

    @Override
    public int size() {
        return myOverlays.size();
    }
    public void showDialog(){
    	mDialog=new Dialog(context);
    	mDialog.setTitle("");mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	mDialog.setContentView(R.layout.dialog_gps);
    	mDialog.setCancelable(true);
    	LinearLayout chat=(LinearLayout)mDialog.findViewById(R.id.line_dialog_gps_chat);
    	LinearLayout info=(LinearLayout)mDialog.findViewById(R.id.line_dialog_gps_info);
    	chat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(context, ChatActivity.class);
				context.startActivity(i);
			}
		});
    	info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(context, ChatActivity.class);
				context.startActivity(i);
			}
		});
    	mDialog.show();
    }
}