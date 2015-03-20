package com.example.phase1part1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterScreen extends Activity{		
	
	Spinner acounttypeSpinner,stateSpinner,citySpinner;
	TextView linktologin;
	EditText fieldPassword,fieldConfirmPassword;
	
	Intent gotologin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_screen);
		
		/* Setting of All EditText */
		
		fieldPassword = (EditText) findViewById(R.id.field_password);
		fieldPassword.setOnFocusChangeListener(storePasswordField);
		
		fieldConfirmPassword = (EditText) findViewById(R.id.field_confirm_password);
		
		/* Setting ended for all EditText */
		
		/* Setting All Spinners (Multiple Choices) */
		acounttypeSpinner = (Spinner) findViewById(R.id.acount_type_spinner);
		stateSpinner = (Spinner) findViewById(R.id.state_spinner);
		citySpinner = (Spinner) findViewById(R.id.city_spinner);
		
		ArrayAdapter<CharSequence> accounttypeArrayAdapter = ArrayAdapter.createFromResource(getBaseContext(),
				R.array.account_type_array,
				android.R.layout.simple_spinner_dropdown_item);
		acounttypeSpinner.setAdapter(accounttypeArrayAdapter);
		acounttypeSpinner.setOnItemSelectedListener(accounttypeListener);
		
		ArrayAdapter<CharSequence> stateArrayAdapter = ArrayAdapter.createFromResource(getBaseContext(), 
				R.array.states_array, 
				android.R.layout.simple_spinner_dropdown_item);		
		stateSpinner.setAdapter(stateArrayAdapter);
		stateSpinner.setOnItemSelectedListener(stateListener);
		
		ArrayAdapter<CharSequence> cityArrayAdapter = ArrayAdapter.createFromResource(getBaseContext(), 
				R.array.city_array, 
				android.R.layout.simple_spinner_dropdown_item);
		citySpinner.setAdapter(cityArrayAdapter);
		citySpinner.setOnItemSelectedListener(cityListener);
		/* Spinners Settings ended */
		
		/*********************************************************************/
		linktologin = (TextView) findViewById(R.id.link_to_login);		
		linktologin.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {	
				gotologin = new Intent(RegisterScreen.this,LoginScreen.class);
				startActivity(gotologin);
			}
		});
		/*********************************************************************/
		
	}
	
	private OnItemSelectedListener accounttypeListener = new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};
	
	private OnItemSelectedListener stateListener = new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};
	
	private OnItemSelectedListener cityListener = new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		}
	};
	
	private OnFocusChangeListener storePasswordField = new OnFocusChangeListener() {		
		@Override
		public void onFocusChange(View view, boolean hasFocus) {
			if(!hasFocus) {
				String firstPassword = fieldPassword.getText().toString();
				if(!firstPassword.equals("")){
					fieldConfirmPassword.setOnFocusChangeListener(storeConfirmPasswordField);
					//Toast.makeText(getBaseContext(), firstPassword, Toast.LENGTH_LONG).show();
				}
			}
		}
	};
	
	private OnFocusChangeListener storeConfirmPasswordField = new OnFocusChangeListener() {
		@Override
		public void onFocusChange(View view, boolean hasFocus) {
			if(!hasFocus){
				String firstPassword = fieldPassword.getText().toString();
				String confirmPassword = fieldConfirmPassword.getText().toString();
				if(!firstPassword.equals(confirmPassword)){
					fieldConfirmPassword.setError("Passwords do not match.");
				}
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register_screen, menu);
		return true;
	}

}
