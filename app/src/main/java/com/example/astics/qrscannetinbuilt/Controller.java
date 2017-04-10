package com.example.astics.qrscannetinbuilt;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Controller extends Application {
    public static ArrayList<Category> ExpListItems= new ArrayList<Category>();
	private static Boolean isAdded=false;
	//mobile gcm
	private  final int MAX_ATTEMPTS = 5;
    private  final int BACKOFF_MILLI_SECONDS = 2000;
    private  final Random random = new Random();
	//waiterpad
    private ArrayList<UserData> UserDataArr = new ArrayList<UserData>();
    private ArrayList<Category> CategoryDataArr = new ArrayList<Category>();
	private ArrayList<Item> myProducts = new ArrayList<Item>();
	private  ModelCart myCart = new ModelCart();
  private PowerManager.WakeLock wakeLock;
	
  // Issue a POST request to the server.
  private static void post(String endpoint, Map<String, String> params)
          throws IOException {

      URL url;
      try {

          url = new URL(endpoint);

      } catch (MalformedURLException e) {
          throw new IllegalArgumentException("invalid url: " + endpoint);
      }

      StringBuilder bodyBuilder = new StringBuilder();
      Iterator<Entry<String, String>> iterator = params.entrySet().iterator();

      // constructs the POST body using the parameters
      while (iterator.hasNext()) {
          Entry<String, String> param = iterator.next();
          bodyBuilder.append(param.getKey()).append('=')
                  .append(param.getValue());
          if (iterator.hasNext()) {
              bodyBuilder.append('&');
          }
      }

      String body = bodyBuilder
    		  .toString();

      Log.v(Config.TAG, "Posting '" + body + "' to " + url);

      byte[] bytes = body.getBytes();

      HttpURLConnection conn = null;
      try {

      	Log.e("URL", "> " + url);

          conn = (HttpURLConnection) url.openConnection();
          conn.setDoOutput(true);
          conn.setUseCaches(false);
          conn.setFixedLengthStreamingMode(bytes.length);
          conn.setRequestMethod("POST");
          conn.setRequestProperty("Content-Type",
                  "application/x-www-form-urlencoded;charset=UTF-8");
          // post the request
          OutputStream out = conn.getOutputStream();
          out.write(bytes);
          out.close();

          // handle the response
          int status = conn.getResponseCode();
          switch(status){
          case 200:
          case 201:
        	  BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        	  StringBuilder sb=new StringBuilder();
        	  String line;
        	  while((line=br.readLine())!=null){
        		  sb.append(line+"\n");
        	  }
        	  String content=sb.toString();
        	  br.close();
        	  //JSONObject jsonResponse;

        	  try{

        	  JSONObject jObject = new JSONObject(content);
        	  String rid = jObject.getString("rid");
        	  String name = jObject.getString("r_name");
        	  String email = jObject.getString("r_email");
        	  if(Integer.parseInt(rid)>0 && !email.trim().equals("")){
        		  Restaurant restroData=new Restaurant(Integer.parseInt(rid),name,email);
        		  DBAdapter.addRestaurantData(restroData);
        		  //DBAdapter.addDeviceData(name, email, regId, IMEI);
                  //  Staff staffData=new Staff(name, email);

      			 // DBAdapter.addStaffData(new Staff(name, email));
        		  isAdded=true;
        	  }
        	  }
        	  catch (Exception e) {
				// TODO: handle exception
			}
        	 // Toast.makeText(context,"id="+ aJsonString, Toast.LENGTH_LONG).show();

        	  break;
        	  default:
        		  throw new IOException("Post failed with error code " + status);

          }
          // If response is not success
        /*  if (status != 200) {

            throw new IOException("Post failed with error code " + status);
          }*/
      } finally {
          if (conn != null) {
              conn.disconnect();
          }
      }
    }
	
	public Item getProducts(int pPosition) {

		return myProducts.get(pPosition);
	}
 
	public void setProducts(Item Products) {

		myProducts.add(Products);

	}
   
   
   //mobile gcm

	 // Register this account with the server.
 /* void register(final Context context, String name, String email, final String regId, final String IMEI) {
  	 
      Log.i(Config.TAG, "registering device (regId = " + regId + ")");
      
      
      // Server url to post gcm registration data 
    //  String serverUrl = Config.YOUR_SERVER_URL+"register.php";
      String serverUrl = Config.YOUR_SERVER_URL+"register_restro.php";
      
      Map<String, String> params = new HashMap<String, String>();
      params.put("regId", regId);
      params.put("name", name);
      params.put("email", email);
      params.put("imei", IMEI);
      
      long backoff = BACKOFF_MILLI_SECONDS + random.nextInt(1000);
      // Once GCM returns a registration id, we need to register on our server
      // As the server might be down, we will retry it a couple
      // times.
      for (int i = 1; i <= MAX_ATTEMPTS; i++) {
      	
          Log.d(Config.TAG, "Attempt #" + i + " to register");
          
          try {
          	//Send Broadcast to Show message on screen
          	displayRegistrationMessageOnScreen(context, context.getString(
                      R.string.server_registering, i, MAX_ATTEMPTS));
              
              // Post registration values to web server
              post(serverUrl, params);
              
              GCMRegistrar.setRegisteredOnServer(context, true);
              
              //Send Broadcast to Show message on screen
              String message = context.getString(R.string.server_registered);
              displayRegistrationMessageOnScreen(context, message);
              if(isAdded){
              DBAdapter.addDeviceData(name, email, regId, IMEI);
            //  Staff staffData=new Staff(name, email);
              
			  DBAdapter.addStaffData(new Staff(name, email));
              }
				// Launch Main Activity
				/*Intent i1 = new Intent(getApplicationContext(), SplashScreen.class);
				i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i1);
				//((ServerRegister)con).finish();
              
              return;
          } catch (IOException e) {
          	
              // Here we are simplifying and retrying on any error; in a real
              // application, it should retry only on unrecoverable errors
              // (like HTTP error code 503).
          	
              Log.e(Config.TAG, "Failed to register on attempt " + i + ":" + e);
              
              if (i == MAX_ATTEMPTS) {
                  break;
              }
              try {
              	
                  Log.d(Config.TAG, "Sleeping for " + backoff + " ms before retry");
                  Thread.sleep(backoff);
                  
              } catch (InterruptedException e1) {
                  // Activity finished before we complete - exit.
                  Log.d(Config.TAG, "Thread interrupted: abort remaining retries!");
                  Thread.currentThread().interrupt();
                  return;
              }
              
              // increase backoff exponentially
              backoff *= 2;
          }
      }
      
      String message = context.getString(R.string.server_register_error,
              MAX_ATTEMPTS);
      
      //Send Broadcast to Show message on screen
      displayRegistrationMessageOnScreen(context, message);
  }
  */

   // Unregister this account/device pair within the server.
 /*  void unregister(final Context context, final String regId, final String IMEI) {
  	 
      Log.i(Config.TAG, "unregistering device (regId = " + regId + ")");
      
      String serverUrl = Config.YOUR_SERVER_URL+"unregister.php";
      Map<String, String> params = new HashMap<String, String>();
      params.put("regId", regId);
      params.put("imei", IMEI);
      
      try {
           post(serverUrl, params);
          GCMRegistrar.setRegisteredOnServer(context, false);
          
          String message = context.getString(R.string.server_unregistered);
          displayRegistrationMessageOnScreen(context, message);
      } catch (IOException e) {
      	
          // At this point the device is unregistered from GCM, but still
          // registered in the our server.
          // We could try to unregister again, but it is not necessary:
          // if the server tries to send a message to the device, it will get
          // a "NotRegistered" error message and should unregister the device.
      	
          String message = context.getString(R.string.server_unregister_error,
                  e.getMessage());
          Log.i("GCM K", message);
          
          displayRegistrationMessageOnScreen(context, message);
      }
  }*/

	public ModelCart getCart() {

		return myCart;

	}
  
   public int getProductsArraylistSize() {

		return myProducts.size();
	}
	
	// Checking for all possible internet providers
  public boolean isConnectingToInternet(){

      ConnectivityManager connectivity =
      	                 (ConnectivityManager) getSystemService(
      	                  Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
  }
  
 // Notifies UI to display a message.
 void displayRegistrationMessageOnScreen(Context context, String message) {

      Intent intent = new Intent(Config.DISPLAY_REGISTRATION_MESSAGE_ACTION);
      intent.putExtra(Config.EXTRA_MESSAGE, message);

      // Send Broadcast to Broadcast receiver with message
      context.sendBroadcast(intent);

  }

//Notifies UI to display a message.
 void displayMessageOnScreen(Context context, String title, String message, String imei) {

      Intent intent = new Intent(Config.DISPLAY_MESSAGE_ACTION);
      intent.putExtra(Config.EXTRA_MESSAGE, message);
      intent.putExtra("name", title);
      intent.putExtra("imei", imei);
      // Send Broadcast to Broadcast receiver with message
      context.sendBroadcast(intent);

  }

 void MessageAction(Context context, String message) {

     Intent intent = new Intent(Config.MESSAGE_ACTION);
     intent.putExtra(Config.EXTRA_MESSAGE, message);
     //intent.putExtra("name", title);
     //intent.putExtra("imei", imei);
     // Send Broadcast to Broadcast receiver with message
     context.sendBroadcast(intent);

 }
  
void CartUpdate(Context context, String message) {

	Intent intent = new Intent(Config.CART_UPDATE);
	intent.putExtra(Config.EXTRA_MESSAGE, message);
	LocalBroadcastManager mgr = LocalBroadcastManager.getInstance(context);
	mgr.sendBroadcast(intent);
     /*Intent intent = new Intent(Config.CART_UPDATE);
     intent.putExtra(Config.EXTRA_MESSAGE, message);
     //intent.putExtra("name", title);
     //intent.putExtra("imei", imei);
     // Send Broadcast to Broadcast receiver with message
     context.sendBroadcast(intent);*/

 }
  
 //Function to display simple Alert Dialog
 public void showAlertDialog(Context context, String title, String message,
                             Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Set Dialog Title
		alertDialog.setTitle(title);

		// Set Dialog Message
		alertDialog.setMessage(message);

		if(status != null)
			// Set alert dialog icon
			alertDialog.setIcon((status) ? R.mipmap.success : R.mipmap.fail);

		// Set OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		// Show Alert Message
		alertDialog.show();
	}
  
  public  void acquireWakeLock(Context context) {
      if (wakeLock != null) wakeLock.release();

      PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
      
      wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK |
              PowerManager.ACQUIRE_CAUSES_WAKEUP |
              PowerManager.ON_AFTER_RELEASE, "WakeLock");
      
      wakeLock.acquire();
  }

  public  void releaseWakeLock() {
      if (wakeLock != null) wakeLock.release(); wakeLock = null;
  }
  
 // Get UserData model object from UserDataArrlist at specified position
 public UserData getUserData(int pPosition) {
		
		return UserDataArr.get(pPosition);
	}

	// Add UserData model object to UserDataArrlist
	public void setUserData(UserData Products) {
	   
		UserDataArr.add(Products);
		
	}
	
 //Get Number of UserData model object contains by UserDataArrlist 
 public int getUserDataSize() {
		
		return UserDataArr.size();
	}
 
// Clear all user data from arraylist
 public void clearUserData() {
		
		 UserDataArr.clear();
	}

public ArrayList<Category> getCategoryDataArr() {
	return CategoryDataArr;
}

public void setCategoryDataArr(Category Cat) {
	CategoryDataArr.add(Cat);
}
}
