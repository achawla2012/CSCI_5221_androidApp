package com.csci5221.locationbasedservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.csci5221.locationbasedservice.R;

public class CreateProfile extends Activity implements OnClickListener{
	Button SignUp; 
	EditText userName, pwd, confirmpwd,phone;
	JSONObject jsonobject;
	JSONStringer vm;
	HttpPost request; 	
	String email, passwd, contact, cpwd;
	View focus;
	public static final String URL = "http://"+IContants.IPADDRESS+":8080/LocationServices/HomeServlet";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_profile);
		userName=(EditText)findViewById(R.id.emailID);
		pwd=(EditText)findViewById(R.id.pwd);
		confirmpwd=(EditText)findViewById(R.id.cpassword);
		phone = (EditText)findViewById(R.id.phone);
		SignUp = (Button)findViewById(R.id.create);
	    SignUp.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.create_profile, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("WebInvoke1","Hello");
		email = userName.getText().toString();
		passwd = pwd.getText().toString();
		contact = phone.getText().toString();
		cpwd = confirmpwd.getText().toString();
		
		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(passwd)) {
			pwd.setError(getString(R.string.error_field_required));
			focusView = pwd;
			cancel = true;
		}  else if(TextUtils.isEmpty(cpwd)) {
			confirmpwd.setError(getString(R.string.error_field_required));
			focusView = confirmpwd;
			cancel = true;
		} 

		if (TextUtils.isEmpty(email)) {
			userName.setError(getString(R.string.error_field_required));
			focusView = userName;
			cancel = true;
		} else if (!email.contains("@")) {
			userName.setError(getString(R.string.error_invalid_email));
			focusView = userName;
			cancel = true;
		}

		if (cancel) {
			focusView.requestFocus();
		}		
		else if(cpwd.equals(passwd)){
			connectWithHttpGet(v);
		}
		else{
			Toast.makeText(getApplicationContext(), "Password not matched", Toast.LENGTH_LONG).show();
		}
	}		

	private void connectWithHttpGet(final View view) {

		class HttpGetAsyncTask extends AsyncTask<String, Void, String>{

			@Override
			protected String doInBackground(String... params) {
				try{
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet(URL+"?request=Signup&Email="+email+"&Password="+passwd+"&Contact_Number="+contact);
					System.out.println(URL+"?request=Signup&Email="+email+"&Password="+passwd+"&Contact_Number="+contact);
					HttpResponse httpResponse = httpClient.execute(httpGet);
					System.out.println("httpResponse");
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
					return stringBuilder.toString();
				} catch (ClientProtocolException cpe) {
					System.out.println("Exception generates caz of httpResponse :" + cpe);
					Toast.makeText(getApplicationContext(), "Sign Up failed !", Toast.LENGTH_LONG).show();
					cpe.printStackTrace();
				} catch (IOException ioe) {
					System.out.println("Second exception generates caz of httpResponse :" + ioe);
					Toast.makeText(getApplicationContext(), "Sign Up failed !", Toast.LENGTH_LONG).show();
					ioe.printStackTrace();
				} catch (Exception ioe){
					System.out.println("Third Exception :" + ioe);
					Toast.makeText(getApplicationContext(), "Sign Up failed !", Toast.LENGTH_LONG).show();
					ioe.printStackTrace();
				}
				
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				System.out.println("after exceute :" + result);
				if(result.contains("\"checkLogin\":true")){
					Toast.makeText(getApplicationContext(), "Sign Up successful !", Toast.LENGTH_LONG).show();
					JSONObject obj;
					String userID = null; 
					try {
						obj = new JSONObject(result);
						userID = obj.getString("eventUserId");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					switch(focus.getId())
					{
						case R.id.create:
							Intent intent = new Intent(getApplicationContext(), AddListEvent.class);
							System.out.println("userID : "+userID);
							intent.putExtra("userName", userID);
							startActivity(intent);
							break;
					}
					
				}else{
					Toast.makeText(getApplicationContext(), "Sign Up failed !", Toast.LENGTH_LONG).show();
				}				
			}			
		}

		HttpGetAsyncTask httpGetAsyncTask = new HttpGetAsyncTask();
		httpGetAsyncTask.execute(); 
	}
}