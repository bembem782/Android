package com.example.contact;

import java.net.URI;
import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView lv;
	ArrayList<Contact> list = new ArrayList<Contact>();
	ItemAdapter adapter;
	AdapterView.AdapterContextMenuInfo info;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv = (ListView)this.findViewById(R.id.listView1);
        this.adapter = new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        
        list.add(new Contact(R.drawable.img10, "Val Yennah", "1 555-521-5554","1 555-521-5554"));
        list.add(new Contact(R.drawable.img4, "Charize Pipino", "1 555-521-5556","1 555-521-5556"));
    
        this.registerForContextMenu(lv);	
    }

    

    @Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	int id = item.getItemId();
    	
    	switch(id){
    	
    	case R.id.view: 
    		
    		LinearLayout layout = new LinearLayout(this);
    		ImageView iv = new ImageView(this);
    		TextView lblName = new TextView(this);
    		TextView lblTel = new TextView(this);
    		
    		iv.setImageResource(list.get(info.position).getImage());
    		lblName.setText(list.get(info.position).getName());
    		lblTel.setText(list.get(info.position).getTel());
    		
    		layout.setOrientation(LinearLayout.VERTICAL);
    		layout.addView(iv);
    		layout.addView(lblName);
    		layout.addView(lblTel);
    		
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Selected Contact");
    		builder.setView(layout);
    		builder.setNeutralButton("Okey", null);
    		
    		AlertDialog dialog = builder.create();
    		dialog.show();
    		
    		break;
    	
    	case R.id.call: 
    		
    		String telephone = list.get(info.position).getTel();
    		Uri uri = Uri.parse("tel: " + telephone);
    		Intent intent = new Intent(Intent.ACTION_CALL,uri);
    		this.startActivity(intent);
    		
    		break;
    		
    	case R.id.sendsms:
    		
    		String message = list.get(info.position).getSms();
    		Uri uri2 = Uri.parse("sms: " + message);
    		Intent intent2 = new Intent(Intent.ACTION_SENDTO, uri2);
    		
    		this.startActivity(intent2);
    		
    		break;
    	}
    	
		return super.onContextItemSelected(item);
	}



	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		this.getMenuInflater().inflate(R.menu.contextmenu, menu);
		info = (AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(list.get(info.position).getName());
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
