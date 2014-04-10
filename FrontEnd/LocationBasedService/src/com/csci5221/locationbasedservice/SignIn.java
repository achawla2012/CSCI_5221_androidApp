package com.csci5221.locationbasedservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.csci5221.locationbasedservice.R;

public class SignIn extends Activity implements OnClickListener{
	//public static final String URL = "http://deshp055.no-ip.biz:8080/LocationServices/HomeServlet";
	public static final String URL = "http://"+IContants.IPADDRESS+":8080/LocationServices/HomeServlet";
	private UserLoginTask mAuthTask = null;

	private String mEmail;
	private String mPassword;

	private EditText mEmailView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private View focus;
	private Button signIN;
	public static String userID = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		System.out.println("In sign In");
		mEmailView = (EditText) findViewById(R.id.email);
		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);
		System.out.println("In sign listener button");
		signIN = (Button)findViewById(R.id.sign_in_button);
		System.out.println("In sign listener");
		signIN.setOnClickListener(this);
		System.out.println("In sign listener2323");
	}

	public void onClick(View view) {
		attemptLogin();
		focus = view;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return true;
	}

	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} 

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!mEmail.contains("@")) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		if (cancel) {
			focusView.requestFocus();
		} else {
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
			showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute();
		}
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	

	public class UserLoginTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			try{
				DefaultHttpClient httpClient = new DefaultHttpClient();
				System.out.println("Detail");
				System.out.println("Email :" +mEmail + "  passwd : " +mPassword);
				HttpGet httpGet = new HttpGet(URL+"?request=Login&Email="+mEmail+"&Password="+mPassword);
				System.out.println(URL+"?request=Login&Email="+mEmail+"&Password="+mPassword);
				HttpResponse httpResponse = httpClient.execute(httpGet);
				System.out.println("httpSignInResponse");
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
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ioe) {
				ioe.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(final String result) {
			mAuthTask = null;
			System.out.println("After exceute :" + result);
			if(result.contains("\"checkLogin\":true")){
				JSONObject obj;
				String userID = null; 
				
				try {
					obj = new JSONObject(result);
					userID = obj.getString("eventUserId");
					SignIn.userID = userID;
					System.out.println("This user id is " + SignIn.userID);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				System.out.println("USerID : "+userID);
				Toast.makeText(getApplicationContext(), "Sign In successful !", Toast.LENGTH_LONG).show();
				switch(focus.getId())
				{
					case R.id.sign_in_button:
						Intent intent = new Intent(getApplicationContext(), AddListEvent.class);
						intent.putExtra("userName", userID);
						startActivity(intent);
						break;
				}
			}else {
				Toast.makeText(getApplicationContext(), "Sign In failed !", Toast.LENGTH_LONG).show();
			}
			showProgress(false);
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
}