/**
 * 
 */
package kltn.client.android_client.model;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author nthanhphong
 *
 */
public class nearest_foot implements BaseColumns{
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_client/best_food");

	public static final String DEFAULT_SORT_ORDER = "startdate, _id DESC";
	
}
