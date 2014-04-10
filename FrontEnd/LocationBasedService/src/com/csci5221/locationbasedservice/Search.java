package com.csci5221.locationbasedservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.csci5221.locationbasedservice.R;

public class Search extends Activity implements OnClickListener{

	
	private String distance;
	private Button search;
	private EditText distanceBox;
	public static final String URL = "http://"+IContants.IPADDRESS+":8080/LocationServices/HomeServlet?";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		distanceBox = (EditText)findViewById(R.id.category);
		//cityBox = (EditText)findViewById(R.id.city);
		//maxNumEventsBox = (EditText)findViewById(R.id.Events);
		search = (Button)findViewById(R.id.searchEvent);
		search.setOnClickListener(this);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	public void onClick(View v) {
		distance = distanceBox.getText().toString();
		//city = cityBox.getText().toString();
		//maxNumEvents = maxNumEventsBox.getText().toString();
		View focusView = null;
		boolean cancel = false;
		if (TextUtils.isEmpty(distance)) {
			distanceBox.setError(getString(R.string.error_field_required));
			focusView = distanceBox;
			cancel = true;
		} 
		
		if (cancel) {
			//System.out.println("::::::::::::::");
			focusView.requestFocus();
		}
		
		Intent j = new Intent(this, PrintNearEvents.class);
		//String user = getIntent().getExtras().getString("userName");
		//System.out.println("AddlistEvent class userID : "+ user);
		System.out.println("1111");
		j.putExtra("distance", distance);
		startActivity(j);
		System.out.println("2222");
    }
	
	/**
     * This function will convert response stream into json string
     * @param is respons string
     * @return json string
     * @throws IOException
     */
    public String streamToString(final InputStream is) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
         
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        }
        catch (IOException e) {
            throw e;
        }
        finally {          
            try {
                is.close();
            }
            catch (IOException e) {
                throw e;
            }
        }
         
        return sb.toString();
    }


	
	public void getEvents(View view) {
		
		
		class HttpGetAsyncTask extends AsyncTask<String, Void, String>{

			@Override
			protected String doInBackground(String... params) {
				
				StringBuilder stringBuilder = new StringBuilder();
				try{
					DefaultHttpClient httpClient = new DefaultHttpClient();
					
					LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
					Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					double longitude, latitude;
					//if(location != null){
						longitude = location.getLongitude();
						latitude = location.getLatitude();
					//} else {
						
					//}
					
					
					
					//HttpGet httpGet = new HttpGet(URL+"?request=GetEvent&Distance=100&Latitude=70&Longitude=25");
					System.out.println("http request sent..");
					//HttpResponse httpResponse = httpClient.execute(httpGet);
					//String parameter = streetName+" "+cityName+" "+zipCode+" "+eState;
					String url = Uri.parse(URL).buildUpon()
							.appendQueryParameter("request","GetEvent")
						    .appendQueryParameter("Distance", distance)
						    .appendQueryParameter("Latitude", Double.toString(latitude))
						    .appendQueryParameter("Longitude", Double.toString(longitude))
						    .build().toString();
					
					
					
					HttpGet httpGetEvent = new HttpGet(url); 
					HttpResponse httpResp = httpClient.execute(httpGetEvent);
					InputStream inputStream = httpResp.getEntity().getContent();
					InputStreamReader inputStreamReader = new InputStreamReader(
							inputStream);
					BufferedReader bufferedReader = new BufferedReader(
							inputStreamReader);

					String bufferedStrChunk = null;
					while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
						stringBuilder.append(bufferedStrChunk);
					}
					System.out.println("The response for the GetOrganizerEvent :"
							+ stringBuilder.toString());
					String events = stringBuilder.toString();
					List<Event> listEvent = this.getEventList(events);
					String[] eventNames = new String[listEvent.size()];
					for (int i = 0; i < listEvent.size(); i++) {
						eventNames[i] = listEvent.get(i).getEventName();
					}
					/*setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
							R.id.label, eventNames));
					*/
					
					
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
				//return stringBuilder.toString();
			}

			public List<Event> getEventList(String ListofEvents) {
				List<Event> eventList = new ArrayList<Event>();
				Event event = null;
				try {
					JSONObject obj = new JSONObject(ListofEvents);
					new ArrayList<String>();
					JSONArray array = obj.getJSONArray("events");
					for (int i = 0; i < array.length(); i++) {
						event = new Event();
						event.setEventId(Integer.parseInt(array.getJSONObject(i)
								.getString("eventId")));
						event.setEventName(array.getJSONObject(i)
								.getString("eventName"));
						event.setCategoryId(Integer.parseInt(array.getJSONObject(i)
								.getString("categoryId")));
						event.setStreet(array.getJSONObject(i).getString("street"));
						event.setCity(array.getJSONObject(i).getString("city"));
						event.setState(array.getJSONObject(i).getString("state"));
						event.setZipCode(array.getJSONObject(i).getString("zipCode"));
						event.setLatitude(Double.parseDouble(array.getJSONObject(i)
								.getString("latitude")));
						event.setLongitude(Double.parseDouble(array.getJSONObject(i)
								.getString("longitude")));
						event.setStart_Date(array.getJSONObject(i).getString(
								"Start_Date"));
						event.setEndDate(array.getJSONObject(i).getString("endDate"));
						eventList.add(event);
					}
					System.out.println("Printing the parsed list of events");
					for (int i = 0; i < eventList.size(); i++) {
						System.out.println(eventList.get(i).getEventName());
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return eventList;
			}
			
			@Override
			protected void onPostExecute(String sJson) {
					System.out.println(sJson);
					try{
					JSONArray obj = new JSONArray(sJson);
					System.out.println("Length = "+ obj.length());
					//Intent i = new Intent(getApplicationContext(), AddListEvent.class);
					//Intent i = new Intent(getApplicationContext(), ListActivity.class);
					System.out.println("11111111");
					//startActivity(i);
					System.out.println("22222222");
					}catch(Exception e) {
						
						
					}
					
		        }  
			}		
		HttpGetAsyncTask httpGetAsyncTask = new HttpGetAsyncTask();
		httpGetAsyncTask.execute(); 
	}
	
	

}
