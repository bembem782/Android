package com.example.listview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener {

	ListView lv;
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	AlertDialog dialog;	
	AlertDialog builder;
	EditText txtName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv = (ListView)this.findViewById(R.id.listView1);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.lv.setAdapter(adapter);
        
        this.lv.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		txtName = new EditText(this);
		txtName.setPadding(10, 10, 10, 10);
		txtName.setHint("Enter name");
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Add item");
		builder.setView(txtName);
		builder.setPositiveButton("Save", this);
		builder.setNegativeButton("Cancel", this);
		
		dialog = builder.create();
		dialog.show();
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		
		case DialogInterface.BUTTON_POSITIVE:
			
			String s = this.txtName.getText().toString();
			list.add(s);
			adapter.notifyDataSetChanged();
			
			break;
			
		case DialogInterface.BUTTON_NEGATIVE:
			dialog.dismiss();
		
		}
		
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selected Item");
		builder.setMessage(list.get(arg2));
		builder.setNeutralButton("OK", null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
		
	}
    
    
}
