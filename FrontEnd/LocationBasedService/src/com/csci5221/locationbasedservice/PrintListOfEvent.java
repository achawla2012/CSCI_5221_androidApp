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

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.csci5221.locationbasedservice.R;

public class PrintListOfEvent extends ListActivity {
	String user;
	List<Event> eventList = null;
	static List<Event> eventListStatic = null;

	// public static final String URL =
	// "http://localhost:8080/LocationServices/HomeServlet?request=GetOrganizerEvent&User_Id=";
	//public static final String URL = "http://"+IContants.IPADDRESS+":8080/LocationServices/HomeServlet?request=GetOrganizerEvent&User_Id=";
	public static final String URL = "http://"+IContants.IPADDRESS+":8080/LocationServices/HomeServlet?";
	
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();

		StrictMode.setThreadPolicy(policy);

		super.onCreate(savedInstanceState);
		/*
		 * setContentView(R.layout.activity_print_list_of_event); FrameLayout
		 * footerLayout = (FrameLayout)
		 * getLayoutInflater().inflate(R.layout.footer,null); TextView footer =
		 * (TextView) footerLayout.findViewById(R.id.footer);
		 */
		String events = this.getListofEventsFromServer();
		List<Event> listEvent = this.getEventList(events);
		eventListStatic = listEvent;
		String[] eventNames = new String[listEvent.size()];
		for (int i = 0; i < listEvent.size(); i++) {
			eventNames[i] = listEvent.get(i).getEventName();
		}
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.label, eventNames));

		ListView lv = getListView();

		// listening to single list item on click
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// selected item
				String event = ((TextView) view).getText().toString();
				Event selectedEvent = eventListStatic.get(position);
				// Launching new Activity on selecting single List Item
				Intent i = new Intent(getApplicationContext(),
						Second_Activity.class);
				// sending data to new activity
				i.putExtra("event", event);
				i.putExtra("city",selectedEvent.getCity());
				i.putExtra("state",selectedEvent.getState());
				i.putExtra("zipcode",selectedEvent.getZipCode());
				i.putExtra("street",selectedEvent.getStreet());
				i.putExtra("startdate",selectedEvent.getStart_Date());
				i.putExtra("enddate",selectedEvent.getEndDate());
				
				
				startActivity(i);

			}
		});

	}

	public String getListofEventsFromServer() {
		String user = getIntent().getStringExtra("userID");
		System.out.println("User ID : " + user);
		StringBuilder stringBuilder = new StringBuilder();

		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();

			String url = Uri
					.parse(URL)
					.buildUpon()
					.appendQueryParameter("request", "GetOrganizerEvent")
					.appendQueryParameter("User_Id", user).build().toString();
			HttpGet httpGetLatLong = new HttpGet(url);
			System.out.println("URL : " + url);
			HttpResponse httpResp = httpClient.execute(httpGetLatLong);

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
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public List<Event> getEventList(String ListofEvents) {
		List<Event> eventList = new ArrayList<Event>();
		Event event = null;
		try {
			JSONObject obj = new JSONObject(ListofEvents);
			@SuppressWarnings("unused")
			List<String> list = new ArrayList<String>();
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

	public void createListView() {
		System.out.println("Entered createListView");
		String[] eventNames = new String[eventList.size()];
		for (int i = 0; i < eventList.size(); i++) {
			eventNames[i] = eventList.get(i).getEventName();
		}

		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.label, eventNames));
		// Step 4: Create the listView
		ListView lv = getListView();

		// listening to single list item on click
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// selected item
				String event = ((TextView) view).getText().toString();

				// Launching new Activity on selecting single List Item
				Intent i = new Intent(getApplicationContext(),
						Second_Activity.class);
				// sending data to new activity
				i.putExtra("EventId", event);
				startActivity(i);

			}
		});
		System.out.println("Leaving createListView");

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.print_list_of_event, menu);
		return true;
	}

}