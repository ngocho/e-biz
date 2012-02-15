/**
 * 
 */
package kltn.client.android_client.engine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

import kltn.client.android_client.model.best_food_item;
import kltn.client.android_client.model.date_food_item;

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
public class engine {
	private String URL_Login;
	private String URL_Register;
	private String URL_Get_Date_Food;
	private String URL_get_Best_Food;
	
	//lay danh sách sản phẩm theo khoảng cách gần nhất
	//lấy danh sách sản phẩm theo bestfood
	public Vector<best_food_item> get_best_food(){
		Vector<best_food_item> result=new Vector<best_food_item>();
		try {
			JSONArray JsonArray_phone = new JSONArray(Query_URL(URL_get_Best_Food));
			int i;
			for(i=0;i<JsonArray_phone.length();i++){
				JSONObject item=(JSONObject)JsonArray_phone.get(i);
				best_food_item node=new best_food_item(item.getString("id"), item.getString("name"),item.getString("introduction"),item.getString("price"),item.getString("buyprice"),item.getString("imageurl"),item.getString("startdate"),item.getString("enddate"),item.getInt("buycount"),item.getInt("minbuyer"),item.getInt("maxbuyer"),item.getInt("rate"));
				result.add(node);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	//lấy danh sách sản phẩm theo thời gian 
	public Vector<date_food_item> get_date_food(){
		Vector<date_food_item> result=new Vector<date_food_item>();
		try {
			JSONArray JsonArray_phone = new JSONArray(Query_URL(URL_Get_Date_Food));
			int i;
			for(i=0;i<JsonArray_phone.length();i++){
				JSONObject item=(JSONObject)JsonArray_phone.get(i);
				date_food_item node=new date_food_item(item.getString("id"), item.getString("name"),item.getString("price"),item.getString("buyprice"),item.getString("imageurl"),item.getString("startdate"),item.getString("enddate"),item.getInt("buycount"),item.getInt("countmin"),item.getInt("countmax"));
				result.add(node);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//đăng ký tài khoản người dùng
	public boolean register(String username,String password,String fullname,String sex,String email,String phone,String address,String birthday){
		boolean result=false;
		try {
			JSONArray JsonArray_phone = new JSONArray(Query_URL(URL_Register));
			JSONObject item=JsonArray_phone.getJSONObject(0);
			if(item.getString("flag").equals("true"))
				result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//login vào hệ thống
	public boolean login(String username,String password){
		return ParseJSON_login(username, password);
	}
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
	public String Query_URL(String q){
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
}
