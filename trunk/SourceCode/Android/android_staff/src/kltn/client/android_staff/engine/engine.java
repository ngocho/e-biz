/**
 * 
 */
package kltn.client.android_staff.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import object.delivery;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.bool;

/**
 * @author nthanhphong
 *
 */
public class engine {
	
	
	
	
	
	public Vector<delivery> get_delivery(String username,String password){
		Vector<delivery> result=ParseJSON_get_delivery(Query_URL(URL_Login));
		return result;
	}
	
	public String sendMessageChat(String id,String message){
		//id bằng username của staff + @ + staff
		String result="";
		try {
			JSONArray JsonArray_chat=new JSONArray(Query_URL(URL_Chat));
			JSONObject item=JsonArray_chat.getJSONObject(0);
			result=item.getString("chat");
		} catch (Exception e) {
		}
		return result;
	}
	
	private Vector<delivery> ParseJSON_get_delivery(String json){
		Vector<delivery> data_delivery=null;
		try {
			JSONArray JsonArray_phone = new JSONArray(json);
			int i;
			data_delivery=new Vector<delivery>();
			for(i=0;i<JsonArray_phone.length();i++){
				JSONObject item=(JSONObject)JsonArray_phone.get(i);
//				delivery node=new delivery(item.getString("phone"), item.getString("code"));
//				data_activecode.add(node);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data_delivery;
	}
	
	public boolean login(String username,String password){
		return ParseJSON_login(username, password);
	}
	
	//login vào hệ thống
	private boolean ParseJSON_login(String username,String password){
		boolean jResult = false;
		try {
			JSONArray JsonArray_phone = new JSONArray(Query_URL(URL_Login));
			JSONObject item=JsonArray_phone.getJSONObject(0);
			if(item.getString("flag").equals("true"))
				jResult=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return jResult;
	}
	
	// query 1 url từ server
	private String Query_URL(String q){
		String qResult = null;
		String qString =q;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(qString);
		try {
			HttpEntity httpEntity = httpClient.execute(httpGet).getEntity();
			if (httpEntity != null){
				InputStream inputStream = httpEntity.getContent();
				Reader in = new InputStreamReader(inputStream);
				BufferedReader bufferedreader = new BufferedReader(in);
				StringBuilder stringBuilder = new StringBuilder();
				String stringReadLine = null;
				while ((stringReadLine = bufferedreader.readLine()) != null) {
					stringBuilder.append(stringReadLine + "\n");
				}
				qResult = stringBuilder.toString();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qResult;
	}
	String URL_Login="http://5.07520349-1.appspot.com/getLogin.vn";
	String URL_Chat="http://5.07520349-1.appspot.com/getLogin.vn";
}
