package com.csci5221.locationbasedservice;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.csci5221.locationbasedservice.R;

public class AddListEvent extends Activity implements OnClickListener {
  
	Button addEvent, listEvent; 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_list_event);
		addEvent = (Button)findViewById(R.id.addEventButton);
		addEvent.setOnClickListener(this);
		listEvent = (Button)findViewById(R.id.listEventButton);
		listEvent.setOnClickListener(this);

		}
	
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_list_event, menu);
		return true;
	}
	

	@Override
	public void onClick(View v) {
		try{
			switch(v.getId()) {
				case R.id.addEventButton:
					Intent i = new Intent(this, AddEvent.class);
					String userID = getIntent().getExtras().getString("userName");
					System.out.println("AddlistEvent class userID : "+ userID);
					i.putExtra("userID",userID);
					startActivity(i);
					break;
				case R.id.listEventButton: 
					//Intent j = new Intent(this, CreateProfile.class);
					//startActivity(j);
					Intent j = new Intent(this, PrintListOfEvent.class);
					String user = getIntent().getExtras().getString("userName");
					System.out.println("AddlistEvent class userID : "+ user);
					j.putExtra("userID",user);
					startActivity(j);
		    }
		}catch(Exception e){
			System.out.println("Currently in addlistEvent class");
			e.printStackTrace();
		}
	}
}
