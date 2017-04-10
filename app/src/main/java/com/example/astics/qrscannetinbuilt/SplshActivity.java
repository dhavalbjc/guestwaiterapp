package com.example.astics.qrscannetinbuilt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplshActivity extends Activity {


    public static Controller aController;
    String id="";
    String table="";
    List<Category> cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences sharedpreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
         id = getIntent().getStringExtra("id");
         table = getIntent().getStringExtra("table");
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("id", id);
        editor.putString("table", table);
        editor.commit();
        DBAdapter.init(this);
        aController = (Controller) getApplicationContext();

        /**
         * Showing splashscreen while making network calls to download necessary
         * data before launching the app Will use AsyncTask to make http call
         */
        Bundle extras = getIntent().getExtras();

        try{

            if (Build.VERSION.SDK_INT >= 11) {
                new PrefetchData().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } else {
                new PrefetchData().execute();
            }

        }catch(Exception e)
        {



        }


    }

    private void fillData() {
        //if(GamesFragment.ExpListItems.size()<=0){
        // TODO Auto-generated method stub
        try{
            //Cursor c=DBAdapter.fetchGroup();
            cat=DBAdapter.getAllCategoryData();
            //  Toast.makeText(getBaseContext(), "ok",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            //Toast.makeText(container.getContext(), e.toString(),Toast.LENGTH_LONG).show();
        }
        // ArrayList<Item> it=DBAdapter.getAllItemData();
        for (Category a1 : cat) {
            //Toast.makeText(getBaseContext(), a1.get_name().toString(),Toast.LENGTH_SHORT).show();
            //GamesFragment.myDepartments.put(a1.get_name(), a1);
            try
            {
                ArrayList<Item> _items=DBAdapter.getItemsbyCatId(a1.get_id());

                for(Item x:_items)
                {
                    x.set_category(a1);
                    try{
                        ArrayList<Extra> _extra=DBAdapter.getExtrasbyItemId(x.get_id());

                        x.set_extra(_extra);
                        for(Extra y:_extra)
                        {
                            y.set_item(x);
                        }
                        Collections.sort(_extra,new myExtraComparable());
                    }
                    catch(Exception e){}
                }
                Collections.sort(_items,new myItemComparable());
                a1.set_items(_items);
            }
            catch(Exception e)
            {
                //	Toast.makeText(container.getContext(), e.toString(),Toast.LENGTH_SHORT).show();
            }

        }
        Collections.sort(cat,new myCateComparable());

        Controller.ExpListItems= (ArrayList<Category>) cat;
        for (Category c:Controller.ExpListItems
             ) {
            Log.e(c.get_name(), String.valueOf(c.get_id()));

        }
//	}

    }

    /**
     * Async Task to make http call
     */
    private class PrefetchData extends AsyncTask<Void, Void, Void> {

        private String Error = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // before making http calls

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            /*
             * Will make http call here This call will download required data
             * before launching the app
             * example:
             * 1. Downloading and storing in SQLite
             * 2. Downloading images
             * 3. Fetching and parsing the xml / json
             * 4. Sending device information to server
             * 5. etc.,
             */
            JSONParser jsonParser = new JSONParser();
            String serverURL = Config.YOUR_SERVER_URL+"clientSync.php";
            try {
                // String data ="&" + URLEncoder.encode("data", "UTF-8") + "="+"0";
                String data ="&" + URLEncoder.encode("data2", "UTF-8") + "="+String.valueOf(id);

                String json;

                //json = jsonParser.getJSONFromUrl2(serverURL,data);
                BufferedReader reader=null;
                String Content = "";
                URL url = new URL(serverURL);


                // Send POST data request

                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(20000);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write( data );
                wr.flush();

                // Get the server response

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    // Append server response in string
                    sb.append(line + "\n");
                }

                // Append Server Response To Content String
                json = sb.toString();



                //Error=String.valueOf(DBAdapter.getRestaurantId());

                Log.e("Response: ", "> " + json);

                if (json != null) {
                    JSONObject jsonResponse;

                    try {

                        /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                        jsonResponse = new JSONObject(json);

                        /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                        /*******  Returns null otherwise.  *******/

                        /*********** Process each JSON Node ************/

                        // Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();



                        JSONArray jsonMainNode = jsonResponse.optJSONArray("Category");

                        if(jsonMainNode!=null){
                            manager.syncCatJson(jsonMainNode);
                        }
                        jsonMainNode = jsonResponse.optJSONArray("Item");
                        if(jsonMainNode!=null){
                            manager.syncItemJson(jsonMainNode);
                        }

                        jsonMainNode = jsonResponse.optJSONArray("Extra");
                        if(jsonMainNode!=null){
                            manager.syncExtraJson(jsonMainNode);
                        }

                        jsonMainNode = jsonResponse.optJSONArray("Staff");
                        if(jsonMainNode!=null){
                            manager.syncStaffJson(jsonMainNode);
                        }


                        jsonMainNode = jsonResponse.optJSONArray("Echarge");
                        if(jsonMainNode!=null){
                            DBAdapter.deleteAllEcharge();
                            manager.syncEchargeJson(jsonMainNode);
                        }
                        jsonMainNode = jsonResponse.optJSONArray("Printer");
                        if(jsonMainNode!=null){
                            DBAdapter.deleteAllPrinter();
                            manager.syncPrinterJson(jsonMainNode);
                        }
                        jsonMainNode = jsonResponse.optJSONArray("CartItems");
                        if(jsonMainNode!=null){
                            DBAdapter.deleteAllcartItem();
                            manager.syncCartItemsJson(jsonMainNode);
                        }

                        jsonMainNode = jsonResponse.optJSONArray("Cart");
                        if(jsonMainNode!=null){
                            DBAdapter.deleteAllcart();
                            manager.syncCartJson(jsonMainNode);
                        }
                        //echarge.get_name()


                        // manager.syncEchargeJson(jsonMainNode);
                        //  aController.CartUpdate(SplashScreen.this, "Hello");
                        /****************** End Parse Response JSON Data *************/

                        //Add user data to controller class UserDataArr arraylist
                        // gridView.setAdapter(new CustomGridAdapter(getBaseContext(), aController));


                    } catch (JSONException e) {
                        Error+= "2 "+e.getMessage();
                        //	 Toast.makeText(getApplicationContext(),"2 " +e.getMessage(), Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                        //    Intent i = new Intent(SplashScreen.this, MainActivity.class);

                        //    startActivity(i);

                        // close this activity
                        //  finish();
                    }
                    catch (Exception e1) {
                        Error+="3 "+ e1.getMessage();
                        //	 Toast.makeText(getApplicationContext(),"3 " +e1.getMessage(), Toast.LENGTH_LONG).show();
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        //	Intent i = new Intent(SplashScreen.this, MainActivity.class);

                        //     startActivity(i);

                        // close this activity
                        //   finish();
                    }



                }
                else{
                    Intent i = new Intent(SplshActivity.this, MainActivity.class);

                    startActivity(i);

                    // close this activity
                    finish();
                }
            } catch (IOException e1) {
                Error+="4 "+ e1.getMessage();
                //	 Toast.makeText(getApplicationContext(),"5 " +e1.getMessage(), Toast.LENGTH_LONG).show();
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            catch (Exception e1) {
                Error+="5 "+ e1.getMessage();
                //	 Toast.makeText(getApplicationContext(),"6 " +e1.getMessage(), Toast.LENGTH_LONG).show();
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // After completing http call
            // will close this activity and lauch main activity
            if (Error != null) {

              /*  new AlertDialog.Builder(getApplicationContext())
	    		.setTitle("No Internet connection")
	           .setMessage(Error)
	          .setCancelable(false)
	           .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   Intent intent = new Intent(getApplicationContext(), Main.class);
	   	        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	   	        	Bundle mBundle = new Bundle();
	   	        	mBundle.putString("ID", "1");
	   	        	intent.putExtras(mBundle);
	   	        	startActivity(intent);
	   	        	//finish();
	                    SplashScreen.this.finish();
	               }
	           })

	           .show();*/
                Toast.makeText(getApplicationContext(),"Timeout", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SplshActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle mBundle = new Bundle();
                mBundle.putString("ID", "1");
                intent.putExtras(mBundle);
                startActivity(intent);
                finish();

            }
            else{/*
                Staff staff=DBAdapter.getStaffData(Main.getEmail(getApplicationContext()));
                if(staff!=null){
                    Intent i = new Intent(SplshActivity.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Bundle mBundle = new Bundle();
                    mBundle.putString("ID", "1");
                    i.putExtras(mBundle);
                    startActivity(i);
                    try{
                        GCMIntentService.secondTime=true;
                    }catch(Exception e)
                    {

                    }
                }else{

                    if(id==0){
                        Intent intent = new Intent(SplashScreen.this, Main.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle mBundle = new Bundle();
                        mBundle.putString("ID", "1");
                        intent.putExtras(mBundle);
                        startActivity(intent);
                        finish();}
                    else{
                        Intent i = new Intent(SplashScreen.this, MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Bundle mBundle = new Bundle();
                        mBundle.putString("ID", "1");
                        i.putExtras(mBundle);
                        startActivity(i);

                        try{
                            GCMIntentService.secondTime=true;
                        }catch(Exception e)
                        {

                        }
                    }
                }*/
            }

            //}
fillData();
            ArrayList<ModelCart> allCart=DBAdapter.getAllCartData();
            String mid="0";
            for (ModelCart cart:allCart
                 ) {
                Log.e(cart.getTableName(), String.valueOf(cart.getId()));
                if(cart.getTableName().equals(table)){
                    mid=String.valueOf(cart.getId());
                    break;
                }


            }
            if(mid.equals("0")) {
                Intent nextpage = new Intent(SplshActivity.this,
                        newOrderActivity.class);
                // nextpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                nextpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                nextpage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                nextpage.putExtra("rid", id);
                nextpage.putExtra("table", table);
                startActivity(nextpage);
            }else{
                Intent nextpage = new Intent(SplshActivity.this,
                        newOrderActivity.class);
                // nextpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                nextpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                nextpage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                nextpage.putExtra("rid", id);
                nextpage.putExtra("table", table);
                nextpage.putExtra("ID", mid);
                startActivity(nextpage);
            }
            // close this activity
            finish();
        }

    }
}
