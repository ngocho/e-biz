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
public class happybirthday_thread extends TimerTask{

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		ParseJSON_birthday(Query_URL(QueryURL_Happybirthday));
		for(int i=0;i<data_birthday.size();i++){
			final int pos=i;
			Thread send=new Thread(){

				@Override
				public void run() {
					sendSMS sendsms=new sendSMS();
					happybirthday_object item=data_birthday.get(pos);
					sendsms.sendMessage("+841265204953", item.message);
					System.out.println("send sms happy birthday to "+item.phonenumber);
					System.gc();
				}};
				send.start();
				try {
					//co van de cho nay
					send.sleep(10000);
					send.stop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private boolean ParseJSON_birthday(String json){
		boolean jResult = false;
		try {
			JSONArray JsonArray_phone = new JSONArray(json);
			int i;
			data_birthday=new Vector<happybirthday_object>();
			for(i=0;i<JsonArray_phone.length();i++){
				JSONObject item=(JSONObject)JsonArray_phone.get(i);
				happybirthday_object node=new happybirthday_object(item.getString("phone"), item.getString("name"));
				data_birthday.add(node);
			}
			jResult=true;
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
	private Vector<happybirthday_object> data_birthday;
	private String QueryURL_Happybirthday="http://5.07520349-1.appspot.com/getHappyBirthday.vn";
}
