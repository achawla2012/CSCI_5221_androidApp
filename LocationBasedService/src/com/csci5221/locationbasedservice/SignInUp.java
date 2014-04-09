package com.csci5221.locationbasedservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.csci5221.locationbasedservice.R;

public class SignInUp extends Activity implements OnClickListener {
	Button signin, signup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in_up);
		signin = (Button)findViewById(R.id.signIn);
		signin.setOnClickListener(this);
		signup = (Button)findViewById(R.id.signUp);
		signup.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.signIn:
				Intent i = new Intent(this, SignIn.class);
				startActivity(i);
				break;
			case R.id.signUp: 
				Intent j = new Intent(this, CreateProfile.class);
				startActivity(j);
			}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_in_up, menu);
		return true;
	}
}
