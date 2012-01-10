/**
 * 
 */
package kltn.client.android_client.model;

import android.net.Uri;

/**
 * @author nthanhphong
 *
 */
public class comment_item {
	public static final Uri CONTENT_URI = Uri
			.parse("content://kltn.client.android_client/comment_item");

	public static final String DEFAULT_SORT_ORDER = "datetime, _id DESC";
	public static final String IDGOODS="idgoods";
	public static final String USERNAME="username";
	public static final String IMAGE="image";
	public static final String CONTENT="content";
	public static final String DATETIME="datetime";
	public static final String OWNER="owner";
	public static final String COUNTUSER="countuser";
	
	public String getIdgoods(){
		return Idgoods;
	}
	public String getUsername(){
		return Username;
	}
	public byte[] getImage(){
		return Image;
	}
	public String getContent(){
		return Content;
	}
	public String getDatetime(){
		return Datetime;
	}
	public String getOwner(){
		 return Owner;
	}
	public int getCountuser(){
		return Countuser;
	}
	public comment_item(String idgoods,String username,byte[] image,String content,String datetime,String owner,int countuser){
		setIdgoods(idgoods);
		setUsername(username);
		setImage(image);
		setContent(content);
		setDatetime(datetime);
		setOwner(owner);
		setCountuser(countuser);
	}
	public void setIdgoods(String idgoods){
		Idgoods=idgoods;
	}
	public void setUsername(String username){
		Username=username;
	}
	public void setImage(byte[] image){
		Image=image;
	}
	public void setContent(String content){
		Content=content;
	}
	public void setDatetime(String datetime){
		Datetime=datetime;
	}
	public void setOwner(String owner){
		Owner=owner;
	}
	public void setCountuser(int countuser){
		Countuser=countuser;
	}
	
	private String Idgoods,Username,Content,Datetime,Owner;
	private int Countuser;
	private byte[] Image;
}
