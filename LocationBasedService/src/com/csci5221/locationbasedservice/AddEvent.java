package com.csci5221.locationbasedservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.csci5221.locationbasedservice.R;

public class AddEvent extends Activity implements OnClickListener{

	
	public void showDatePickerDialog(View v) {
		DatePickerDialog dialog = new DatePickerDialog(this, datePickerListener, 
                2000, 1,1);
		dialog.show();
	}
	
	
	private DatePickerDialog.OnDateSetListener datePickerListener 
    = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
	public void onDateSet(DatePicker view, int selectedYear,
    int selectedMonth, int selectedDay) {
		//Do whatever you want
		System.out.println("Hello Date..");
		dStart1.setText(selectedDay+"/"+selectedMonth+"/"+selectedYear);
	}
	};
	
	
	public void showDatePickerDialog1(View v) {
		DatePickerDialog dialog = new DatePickerDialog(this, datePickerListener1, 
                2000, 1,1);
		dialog.show();
	}
	
	
	private DatePickerDialog.OnDateSetListener datePickerListener1 
    = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
	public void onDateSet(DatePicker view, int selectedYear,
    int selectedMonth, int selectedDay) {
		//Do whatever you want
		System.out.println("Hello Date..");
		dEnd1.setText(selectedDay+"/"+selectedMonth+"/"+selectedYear);
	}
	};
	
	
	private EditText eName;
	private EditText eCategory;
	private EditText cName;
	private EditText sName, stateName;
	private EditText zCode;
	private EditText dStart1;
	private EditText dEnd1;
	private Button addEvent;
	Date dateStart, endStart;
	View focus;
	String eventName;
	String eventCategory; 
	String cityName; 
	String streetName;
	String zipCode, eState; 
	String sDate; 
	String eDate;
	String longitude = null;
	String latitude = null;
	public static final String URL = "http://"+IContants.IPADDRESS+":8080/LocationServices/HomeServlet?";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("Entering AddEvent");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_event);
		eName=(EditText)findViewById(R.id.eventAdd);
		eCategory=(EditText)findViewById(R.id.eventCategory);
		cName=(EditText)findViewById(R.id.cityEvent);
		sName = (EditText)findViewById(R.id.streetEvent);
		stateName = (EditText)findViewById(R.id.stateEvent);
		zCode = (EditText)findViewById(R.id.zipCode);
		dStart1 = (EditText)findViewById(R.id.startDate1);
		dEnd1 = (EditText)findViewById(R.id.endDate1);
		System.out.println("In addEvent class : ");
		addEvent = (Button)findViewById(R.id.addEvent);
		addEvent.setOnClickListener(this);
	    System.out.println("Initializing Done in addEvent class : ");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_event, menu);
		return true;
	}

	
	
	public void onClick(View v) { 
		eventName = eName.getText().toString();
		eventCategory = eCategory.getText().toString(); 
		cityName = cName.getText().toString(); 
		streetName = sName.getText().toString();
		zipCode = zCode.getText().toString(); 
		sDate = dStart1.getText().toString(); 
		eDate = dEnd1.getText().toString();
		eState = stateName.getText().toString();
		
		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(eventName)) {
			eName.setError(getString(R.string.error_field_required));
			focusView = eName;
			cancel = true;
		} else if(TextUtils.isEmpty(cityName)) {
			cName.setError(getString(R.string.error_field_required));
			focusView = cName;
			cancel = true;
		} else if (TextUtils.isEmpty(streetName)) {
			sName.setError(getString(R.string.error_field_required));
			focusView = sName;
			cancel = true;
		} else if (TextUtils.isEmpty(zipCode)) {
			zCode.setError(getString(R.string.error_field_required));
			focusView = zCode;
			cancel = true;
		} else if (TextUtils.isEmpty(sDate)) {
			dStart1.setError(getString(R.string.error_field_required));
			focusView = dStart1;
			cancel = true;
		}else if (TextUtils.isEmpty(eDate)) {
			dEnd1.setError(getString(R.string.error_field_required));
			focusView = dEnd1;
			cancel = true;
		}
		
		
		
		if (cancel) {
			focusView.requestFocus();
		}		
		else
		connectWithHttpGet(v);
	}
	
	private void connectWithHttpGet(final View view) {

		class HttpGetAsyncTask extends AsyncTask<String, Void, String>{

			@Override
			protected String doInBackground(String... params) {
				try{					
					DefaultHttpClient httpClient = new DefaultHttpClient();
					String parameter = streetName+" "+cityName+" "+zipCode+" "+eState;	
					String url = Uri.parse("http://maps.googleapis.com/maps/api/geocode/json?").buildUpon()
					   .appendQueryParameter("address", parameter)
					   .appendQueryParameter("sensor", "true")
					   .build().toString();
					HttpGet httpGetLatLong = new HttpGet(url); 
					System.out.println("URL : " + url);
					HttpResponse httpResp = httpClient.execute(httpGetLatLong);

					InputStream input = httpResp.getEntity().getContent();
					InputStreamReader inputStreamRead = new InputStreamReader(input);
					BufferedReader bufferedRead = new BufferedReader(inputStreamRead);
					StringBuilder stringBuild = new StringBuilder();
					String bufferedStrChunks = null;
					while((bufferedStrChunks = bufferedRead.readLine()) != null)
					{
					stringBuild.append(bufferedStrChunks);
					}
					String res = stringBuild.toString();
					System.out.println("Latitude and logitude send to url : " + url + "  :: res " +res);
					           
					String status = new JSONObject(res).getString("status");
			           if(status.equals("ZERO_RESULTS"))
			           {
			           	Toast.makeText(getApplicationContext(), "Enter valid address !", Toast.LENGTH_LONG).show();
			           	return null;
			           }
					JSONObject jSonObject = new JSONObject(res).getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
					           latitude = jSonObject.getString("lat");
					           longitude = jSonObject.getString("lng");	
					           
					System.out.println("Longitude : "+longitude+" Latitude : "+latitude);	
					
					String user = getIntent().getStringExtra("userID");
					String addEventUrl = Uri.parse(URL).buildUpon()
							   .appendQueryParameter("request", "AddEvent")
							   .appendQueryParameter("User_Id", user)
							   .appendQueryParameter("Event_Name", eventName)
							   .appendQueryParameter("Category_Id", "2")
							   .appendQueryParameter("Street", streetName)
							   .appendQueryParameter("City", cityName)
							   .appendQueryParameter("Zip_Code",zipCode)
							   .appendQueryParameter("State", eState)
							   .appendQueryParameter("Latitude", latitude)
   							   .appendQueryParameter("Longitude", longitude)
   							   .appendQueryParameter("Start_Date", sDate)
   							   .appendQueryParameter("End_Date", eDate)
							   .build().toString();
					
					HttpGet httpGet = new HttpGet(addEventUrl);
					HttpResponse httpResponse = httpClient.execute(httpGet);
					System.out.println("httpResponse" + httpResponse);
					InputStream inputStream = httpResponse.getEntity().getContent();
					InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					StringBuilder stringBuilder = new StringBuilder();
					String bufferedStrChunk = null;
					while((bufferedStrChunk = bufferedReader.readLine()) != null)
					{
						stringBuilder.append(bufferedStrChunk);
					}
					System.out.println("Returning value of doInBackground :" + stringBuilder.toString());
					focus = view;
					System.out.println(stringBuilder.toString());
					return stringBuilder.toString();
				} catch (ClientProtocolException cpe) {
					System.out.println("Exception generates caz of httpResponse :" + cpe);
					cpe.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Second exception generates caz of httpResponse :" + ioe);
					ioe.printStackTrace();
				} catch (Exception ioe){
					System.out.println("Third Exception :" + ioe);
					ioe.printStackTrace();
				}				
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				if(result == null) {
					Toast.makeText(getApplicationContext(), "Event addition fail !", Toast.LENGTH_LONG).show();
				}
				else if(result.equals("true"))
				{
				Toast.makeText(getApplicationContext(), "Event added successfully", Toast.LENGTH_LONG).show();
				finish();
				}
				else{
					Toast.makeText(getApplicationContext(), "Event addition fail !", Toast.LENGTH_LONG).show();
					
				}
			}			
		}

		HttpGetAsyncTask httpGetAsyncTask = new HttpGetAsyncTask();
		httpGetAsyncTask.execute(); 
	}
}
