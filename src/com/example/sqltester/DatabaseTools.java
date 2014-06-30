package com.example.sqltester;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseTools extends SQLiteOpenHelper {

	private final String mDatabaseName = "CandyStore";
	
	public DatabaseTools(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String query = "CREATE TABLE " + mDatabaseName + " ( candy TEXT )";
		
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void insertData(String input){
		
		SQLiteDatabase database = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put("candy", input);
		
		database.insert(mDatabaseName, null, values);
		
	}
	
	public ArrayList<String> getData(){
		
		ArrayList<String> data = new ArrayList<String>();
		
		String query = "SELECT * FROM " + mDatabaseName;
		
		SQLiteDatabase database = this.getReadableDatabase();
		
		Cursor cursor = database.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			
			do{
				String mData = cursor.getString(0);
				data.add(mData);
				
			}while(cursor.moveToNext());
			
		}
		
		return data;
	}

	

}
