package com.example.studentinfo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

	EditText txtIdno, txtName;
	Spinner cboCourse;
	RadioGroup mygender;
	Button btnOk;
	private String selected_course;
	private String selected_gender;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtIdno = (EditText)this.findViewById(R.id.editText1);
        this.txtName = (EditText)this.findViewById(R.id.editText2);
        this.cboCourse = (Spinner)this.findViewById(R.id.spinner1);
        this.mygender = (RadioGroup)this.findViewById(R.id.radioGroup1);
        this.btnOk = (Button)this.findViewById(R.id.button1);
        
        this.btnOk.setOnClickListener(this);
        this.cboCourse.setOnItemSelectedListener(this);
        
        
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String idno = this.txtIdno.getText().toString();
		String name = this.txtName.getText().toString();
		
		int genderindex = mygender.getCheckedRadioButtonId();
		
        RadioButton btnGender = (RadioButton)this.findViewById(genderindex);
        selected_gender = btnGender.getText().toString();
		
		
		if(!idno.equals("") && !name.equals("")){
			
			String message = "ID number: " + idno + "\n"
					+ "Person name: " + name + "\n"
					+ "Course: " + selected_course + "\n"
					+ "Gender: " + selected_gender;
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Student Information");
			builder.setMessage(message);
			builder.setNeutralButton("OK", null);
			
			AlertDialog dialog = builder.create();
			dialog.show();
			
		}else{
			
		Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
			
		}
			
	}
		
	

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		selected_course = this.cboCourse.getItemAtPosition(arg2).toString();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
