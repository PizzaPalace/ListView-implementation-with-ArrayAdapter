package com.example.sqltester;

import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    
	ListView listView;
	DatabaseTools database;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		database = new DatabaseTools(getApplicationContext(),null,null,1);
		
		ArrayList<String> allData = database.getData();
		
		if(allData.isEmpty()){
			String[] a = {};
			listView = (ListView) findViewById(R.id.list_view);
		    ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.layout_file,a);
			listView.setAdapter(adapter);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void saveButton(View view){
		
		 EditText editText = (EditText) findViewById(R.id.edit_text);
		 String data = editText.getText().toString();
		 
		 database.insertData(data);
		 Log.v("DATABASE",database.getData().toString());
		 ArrayList<String> allData = database.getData();
		 
		 Iterator<String> iterator = allData.iterator();
		 int index = 0;
		 int size = allData.size();
		 String[] a = new String[size];
		 
		 while(iterator.hasNext()){
			 
			 if(index < size)
			 a[index] = iterator.next();
			 
		 }
		 ListView listView2 = (ListView) findViewById(R.id.list_view);
		 //ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
		 ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.layout_file,a);
			
		 //adapter.add((String)data);
		 //adapter.notifyDataSetChanged();
		 listView2.setAdapter(adapter);
		 
	}

}
