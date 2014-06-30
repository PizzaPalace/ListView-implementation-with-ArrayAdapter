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

	ArrayList<String> b = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
		b.add("Liquorice");
		b.add("Dairy Milk");
		b.add("Rice Crispies");
		b.add("Orange-Mint");
		b.add("After-Tens");
		
		
		listView = (ListView) findViewById(R.id.list_view);
		ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.layout_file,b);
	    listView.setAdapter(adapter);
	
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
		 // manipulating the data source coupled to the adapter will change the ListView
		 // in addition to adapter.add((String)data). 
		 // b.add(data);
		 ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
		 adapter.add((String)data);
		 adapter.notifyDataSetChanged();
	}

}
