package com.example.userlogin;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

		EditText txtUN, txtPW;
		Button btnLogin, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtUN = (EditText)this.findViewById(R.id.editText1);
        this.txtPW = (EditText)this.findViewById(R.id.editText2);
        
        this.btnLogin = (Button)this.findViewById(R.id.button1);
        this.btnCancel = (Button)this.findViewById(R.id.button2);
        
        this.btnLogin.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int	id = arg0.getId();
		switch(id){
		
		case R.id.button1:
			
			
			
			String username = this.txtUN.getText().toString();
			String password = this.txtPW.getText().toString();
			
			if((username.equals("admin") && password.equals("ccs1234"))){
				Toast.makeText(this, "Login Accepted", Toast.LENGTH_SHORT).show();
			}
			else {
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Error");
				builder.setMessage("Invalid User!");
				builder.setNeutralButton("OK", null);
			
				AlertDialog dialog = builder.create();
				dialog.show();
			}
			
			break;
			
		case R.id.button2:
			
				this.finish();
		}
		
}
    
}
