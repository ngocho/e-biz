/**
 * 
 */
package kltn.client.android_server.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.TimerTask;
import java.util.Vector;

import kltn.client.android_server.object.activecode_object;
import kltn.client.android_server.object.happybirthday_object;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author nthanhphong
 *
 */
public class activecode_thread extends TimerTask{

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ParseJSON_Activecode(Query_URL(QueryURL_Activecode));
		for(int i=0;i<data_activecode.size();i++){
			final int pos=i;
			Thread send=new Thread(){

				@Override
				public void run() {
					sendSMS sendsms=new sendSMS();
					activecode_object item=data_activecode.get(pos);
					//sendsms.sendMessage("+841265204953", item.message);
					System.out.println("send sms activecode "+ item.code + " to "+item.phonenumber);
					System.gc();
				}};
				send.start();
				try {
					send.sleep(20000);
					send.stop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	private String ParseJSON_Activecode(String json){
		String jResult = null;
		try {
			JSONArray JsonArray_phone = new JSONArray(json);
			int i;
			data_activecode=new Vector<activecode_object>();
			for(i=0;i<JsonArray_phone.length();i++){
				JSONObject item=(JSONObject)JsonArray_phone.get(i);
				activecode_object node=new activecode_object(item.getString("phone"), item.getString("code"));
				data_activecode.add(node);
			}
			jResult=JsonArray_phone.getString(0);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jResult;
	}
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qResult;
	}
	Vector<activecode_object> data_activecode;
	public String QueryURL_Activecode="http://5.07520349-1.appspot.com/getHappyBirthday.vn";
}
