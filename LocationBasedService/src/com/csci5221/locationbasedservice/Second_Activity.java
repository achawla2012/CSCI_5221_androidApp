package com.csci5221.locationbasedservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.csci5221.locationbasedservice.R;

public class Second_Activity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_);
		this.setContentView(R.layout.single_list_item_view);
        
        TextView txtProduct = (TextView) findViewById(R.id.eventName);
         
        Intent i = getIntent();
        @SuppressWarnings("unused")
		String product = i.getStringExtra("event");
        String result = "Event Name\n" + i.getStringExtra("event") + "\n" + "\n\n Address\n" +
        		i.getStringExtra("street") + "\n" +
        		i.getStringExtra("city") + "\n" + 
        		i.getStringExtra("state") + "\n" +
        		i.getStringExtra("zipcode") + "\n\n" + "Start Date \n" + 
        		i.getStringExtra("startdate") + "\n\n" +  "End Date \n" + 
        		i.getStringExtra("enddate") ; 
        txtProduct.setText(result );

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_, menu);
		return true;
	}

}