//========================================================================================================

package kltn.client.android_client.engine.adapter;

import android.app.Activity;
import android.database.Cursor;
import android.widget.BaseAdapter;

//========================================================================================================

public abstract class MCursorAdapter extends BaseAdapter
{
	//========================================================================================================
	
	protected Activity mActivity;
	protected Cursor mCursor;	
	
	//========================================================================================================
	
	public MCursorAdapter(Activity _activity)
	{
		this.mActivity = _activity;
	}
	
	//========================================================================================================
	
	protected abstract String GetQuery();
	
	public void InitCursor()
	{
//		this.mCursor = MainEngine.GetInstance().Content().GetData(this.GetQuery());
		
		if(this.mCursor != null)
			this.mActivity.startManagingCursor(this.mCursor);
	}
	
	public Cursor GetCursor()
	{
		return this.mCursor;
	}
	
	public void Close()
	{
		if(this.mCursor != null)
		{
			if(!this.mCursor.isClosed())
			{
				this.mActivity.stopManagingCursor(this.mCursor);
				this.mCursor.close();
			}
			
			this.mCursor = null;
		}
	}
		
	@Override
	public int getCount() 
	{		
		if(this.mCursor == null)
			return 2;
		
		return this.mCursor.getCount();
	}
	
	@Override
	public long getItemId(int position)
	{
		if(this.mCursor == null)
			return -1;
		
		this.mCursor.moveToPosition(position);
		return this.mCursor.getInt(0);
	}	
	
	//========================================================================================================	
}
