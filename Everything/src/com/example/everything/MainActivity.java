package com.example.everything;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {

		GridView gv;
		ArrayList<Person>list = new ArrayList<Person>();
		GridAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        this.gv = (GridView)this.findViewById(R.id.gridView1);
        adapter = new GridAdapter(this,list);
        
        
        list.add(new Person(R.drawable.img1, "Dia", "BSCRIM"));
        list.add(new Person(R.drawable.img2, "Mia", "BSIT"));
        list.add(new Person(R.drawable.img3, "Lia", "BSHRM"));
        list.add(new Person(R.drawable.img4, "Xia", "BEED"));
        list.add(new Person(R.drawable.img5, "Bia", "BSC"));
        list.add(new Person(R.drawable.img6, "Nia", "BSCE"));
        list.add(new Person(R.drawable.img7, "Tia", "BSCRIM"));
        list.add(new Person(R.drawable.img8, "Ria", "BSIT"));
        list.add(new Person(R.drawable.img9, "Zia", "BSHRM"));
        list.add(new Person(R.drawable.img10,"Kia", "BEED"));
        list.add(new Person(R.drawable.img11,"Jia", "BSC"));
        list.add(new Person(R.drawable.img12,"Pia", "BSCE"));
        
        
        this.gv.setAdapter(adapter);
        this.gv.setOnItemClickListener(this);
        
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		ImageView iv = new ImageView(this);
			iv.setImageResource(list.get(arg2).getImage());
		TextView tv = new TextView(this);
			tv.setText(list.get(arg2).getCourse());
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.addView(iv);
		layout.addView(tv);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(list.get(arg2).getName());
			builder.setView(layout);
			builder.setNeutralButton("Ok", null);
			
		AlertDialog dialog = builder.create();
		dialog.show();
	}
    
}
