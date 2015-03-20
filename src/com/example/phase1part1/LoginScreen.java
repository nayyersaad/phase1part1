package com.example.phase1part1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class LoginScreen extends Activity {

	TextView linktoregister;
	Intent gotoregister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);				
		
		linktoregister = (TextView) findViewById(R.id.link_to_register);
		linktoregister.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				gotoregister = new Intent(LoginScreen.this,RegisterScreen.class);
				startActivity(gotoregister);
				//Toast.makeText(getBaseContext(), "This", Toast.LENGTH_SHORT).show();
			}
		});		
	}
}
