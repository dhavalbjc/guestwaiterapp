package com.example.astics.qrscannetinbuilt;

import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class JSONParser {
    private static final String Content = null;
	String data = "";
    JSONArray jsonArray = null;
    InputStream is = null;
    StringBuffer response = new StringBuffer();
    public JSONParser(){}

    // Method to download json data from url
    public String getJSONFromUrl(String strUrl, String data) throws IOException {
        try{
        	
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
            wr.write( data );
            wr.flush();
           
            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            is = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }
            is.close();
            data = sb.toString();

            //br.close();

         //   jsonArray = new JSONArray(data);

        }catch(Exception e){
        	
            Log.d("Exception while downloading url", e.toString());
            return null;
        }finally{
            is.close();
        }

        return data;
    }
    public String getJSONFromUrl2(String strUrl, String data) throws IOException {
        try{
        	BufferedReader reader=null;
        	String Content = "";
        	 URL url = new URL(strUrl);
         	
             
             // Send POST data request

             URLConnection conn = url.openConnection();
             conn.setDoOutput(true); 
             conn.setConnectTimeout(10000);
             conn.setReadTimeout(10000);
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
               Content = sb.toString();
              
     

            //br.close();

         //   jsonArray = new JSONArray(data);

        }catch(Exception e){
        	
            Log.d("Exception while downloading url", e.toString());
            return null;
        }finally{
            //is.close();
        }

        return Content;
    }

    public String excutePost(String targetURL, String urlParameters)
    {
      URL url;
      HttpURLConnection connection = null;
      try {
        //Create connection
        url = new URL(targetURL);
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", 
             "application/x-www-form-urlencoded");
  			
        connection.setRequestProperty("Content-Length", "" + 
                 Integer.toString(urlParameters.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");  
       connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setUseCaches (false);
        connection.setDoInput(true);
     //   connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream ());
        wr.writeBytes (urlParameters);
        wr.flush ();
        wr.close ();

        //Get Response	
         is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        
        
        while((line = rd.readLine()) != null) {
        //  response.append(line);
         // response.append('\r');
          response.append(line + "\n");
        }
        rd.close();
        return response.toString();

      } catch (java.net.SocketTimeoutException e) {
    	   return "";
      } catch (java.io.IOException e) {
         return "";
      }catch (Exception e) {
    	  
    	 
        e.printStackTrace();
        return "";

      } finally {

        if(connection != null) {
          connection.disconnect(); 
        }
      }
    }


}