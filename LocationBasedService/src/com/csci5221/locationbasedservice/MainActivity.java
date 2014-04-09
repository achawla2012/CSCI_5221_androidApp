package com.csci5221.locationbasedservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.csci5221.locationbasedservice.R;

public class MainActivity extends Activity implements OnClickListener {
	Button user, eventOrganizer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		user = (Button)findViewById(R.id.user);
		user.setOnClickListener(this);
		eventOrganizer = (Button)findViewById(R.id.eventOrg);
		eventOrganizer.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.user:
				Intent i = new Intent(this, Search.class);
				startActivity(i);
				break;
			case R.id.eventOrg: 
				Intent j = new Intent(this, SignInUp.class);
				startActivity(j);
			}
		//finish();
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
