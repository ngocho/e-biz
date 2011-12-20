/**
 * 
 */
package kltn.client.android_staff.activity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import kltn.client.android_staff.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

/**
 * @author nthanhphong
 *
 */
public class mapActivity extends MapActivity{
	MapView mapView; 
	MapController mc;
	GeoPoint p;

	class MapOverlay extends com.google.android.maps.Overlay
	{
		@Override
		public boolean draw(Canvas canvas, MapView mapView, 
				boolean shadow, long when) 
		{
			super.draw(canvas, mapView, shadow);                   

			Point screenPts = new Point();
			mapView.getProjection().toPixels(p, screenPts);

			Bitmap bmp = BitmapFactory.decodeResource(
					getResources(), R.drawable.icon_person);            
			canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
			return true;
		}
		@Override
		public boolean onTouchEvent(MotionEvent event, MapView mapView) 
		{   
			if (event.getAction() == 1) {                
				GeoPoint p = mapView.getProjection().fromPixels(
						(int) event.getX(),
						(int) event.getY());

				Geocoder geoCoder = new Geocoder(
						getBaseContext(), Locale.getDefault());
				try {
					List<Address> addresses = geoCoder.getFromLocation(
							p.getLatitudeE6()  / 1E6, 
							p.getLongitudeE6() / 1E6, 1);

					String add = "";
					if (addresses.size() > 0) 
					{
						for (int i=0; i<addresses.get(0).getMaxAddressLineIndex(); 
								i++)
							add += addresses.get(0).getAddressLine(i) + "\n";
					}

					Toast.makeText(getBaseContext(), add, Toast.LENGTH_SHORT).show();
				}
				catch (IOException e) {                
					e.printStackTrace();
				}   
				return true;
			}
			else                
				return false;
		}
		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			// TODO Auto-generated method stub
			Toast.makeText(getBaseContext(), "erer", Toast.LENGTH_SHORT).show();
			return super.onTap(p, mapView);
		}    
	} 
	@Override
	protected void onCreate(Bundle icicle) {
		// TODO Auto-generated method stub
		super.onCreate(icicle);
		setContentView(R.layout.content_gps);
		mapView=(MapView)findViewById(R.id.mapview);
		LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
		View zoomView = mapView.getZoomControls(); 

		zoomLayout.addView(zoomView, 
				new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, 
						LayoutParams.WRAP_CONTENT)); 
		mapView.displayZoomControls(true);
		mc = mapView.getController();
        String coordinates[] = {"10.7910576", "106.696861"};
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
 
        p = new GeoPoint(
            (int) (lat * 1E6), 
            (int) (lng * 1E6));
 
        mc.animateTo(p);
        mc.setZoom(17); 
        mapView.invalidate();

		//---Add a location marker---
//		MapOverlay mapOverlay = new MapOverlay();
//		List<Overlay> listOfOverlays = mapView.getOverlays();
//		listOfOverlays.clear();
//		listOfOverlays.add(mapOverlay);
		//setOverlay1();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	} 

    private List<Overlay> mapOverlays;
    private Drawable drawable1, drawable2;
//    private MyItemizedOverlay itemizedOverlay1, itemizedOverlay2;
    private boolean foodIsDisplayed = false;
    
    // Define an array containing the food overlay items
    
    private OverlayItem [] foodItem = {
        new OverlayItem( new GeoPoint(35952967,-83929158), "Food Title 1", "Food snippet 1"), 
        new OverlayItem( new GeoPoint(35953000,-83928000), "Food Title 2", "Food snippet 2"),
        new OverlayItem( new GeoPoint(35955000,-83929158), "Food Title 3", "Food snippet 3") 
    };
    
    // Define an array containing the  access overlay items
    
    private OverlayItem [] accessItem = {
        new OverlayItem( new GeoPoint(35953700,-83926158), "Access Title 1", "Access snippet 1"),
        new OverlayItem( new GeoPoint(35954000,-83928200), "Access Title 2", "Access snippet 2"),
        new OverlayItem( new GeoPoint(35955000,-83927558), "Access Title 3", "Access snippet 3"),
        new OverlayItem( new GeoPoint(35954000,-83927158), "Access Title 4", "Access snippet 4") 
    };
//    public void setOverlay1(){	
//        int foodLength = foodItem.length;
//        if(! foodIsDisplayed){
//        mapOverlays = mapView.getOverlays();	
//        drawable1 = this.getResources().getDrawable(R.drawable.pushpin); 
//        itemizedOverlay1 = new MyItemizedOverlay(drawable1,this); 
//        for(int i=0; i<foodLength; i++){
//            itemizedOverlay1.addOverlay(foodItem[i]);
//        }
//        mapOverlays.add(itemizedOverlay1);
//        foodIsDisplayed = !foodIsDisplayed;
//        } else {			
//            itemizedOverlay1.removeItem(itemizedOverlay1.size()-1);
//            if((itemizedOverlay1.size() < 1))  foodIsDisplayed = false;
//        }    
//        mapView.postInvalidate(); 
//    }
}
