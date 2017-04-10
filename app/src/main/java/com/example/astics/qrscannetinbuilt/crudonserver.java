package com.example.astics.qrscannetinbuilt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class crudonserver {

	public static void addCartData(ModelCart mycart) {

		 try
		 {
				/* ArrayList<HashMap<String, String>> wordList;
		        wordList = new ArrayList<HashMap<String, String>>();
		        HashMap<String, String> map = new HashMap<String, String>();
		        map.put("oprn","Insert");
		        map.put("table", "Cart");
		        map.put("id",String.valueOf(id));
		        map.put("table1",mycart.getTableName());
		        map.put("total",mycart.getTotal());
		        map.put("rid", String.valueOf(DBAdapter.getRestaurantId()));
		       wordList.add(map);*/
		        Gson gson = new GsonBuilder().create();
			 crudonserver crudop=new crudonserver();
			// crudop.callserverforcrudopern(gson.toJson(mycart));
			// crudop.callserverforreceiveorder(gson.toJson(mycart));

		 }catch(Exception e)
		 {
			// error=String.valueOf(e.getMessage());
			 //Toast.makeText(context,Toast.LENGTH_LONG).show();
		 }

	}

	public void callserverforcrudopern(final String jsonvalue, final Context con)
	{
		 try
		 {



	            	 ConnectivityManager cm =
	 				        (ConnectivityManager)con.getSystemService(Context.CONNECTIVITY_SERVICE);

	 				NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
	 				boolean isConnected = activeNetwork != null &&
	 				                      activeNetwork.isConnectedOrConnecting();
	 				if(isConnected){
	 					 Thread t1=new Thread(new Runnable() {
	 			             @Override
	 			             public void run() {
	            	   AsyncHttpClient client = new AsyncHttpClient();
	   		        RequestParams params = new RequestParams();

	   		                params.put("usersJSON", jsonvalue);
	   		                client.post(Config.YOUR_SERVER_URL+"/crudonserver.php",params ,new AsyncHttpResponseHandler() {
	   		                    @Override
	   		                    public void onSuccess(String response) {
	   		                    }

	   		                    @Override
	   		                    public void onFailure(int statusCode, Throwable error,
	   		                        String content) {

	   		                    //	callserverforcrudopern( jsonvalue,con);
	   		                        // TODO Auto-generated method stub
	   		                    //	Toast.makeText(con, "Slow Internet Connection", Toast.LENGTH_LONG).show();

	   		                    }
	   		                }
	   		            );

	 			             }
	 			         });
	 		    		t1.start();
	 				}
	 				else{

	 					Toast.makeText(con, "No Internet Connection", Toast.LENGTH_LONG).show();
	 				}



			//Create AsycHttpClient object

		 }catch(Exception e)
		 {
			// Toast.makeText(,e.getMessage(),Toast.LENGTH_LONG).show();

			// callserverforcrudopern( jsonvalue);
		 }
	}

	public void callClientSync(String jsonvalue, final Context con )
	{
		 try
		 {

			//Create AsycHttpClient object
		        AsyncHttpClient client = new AsyncHttpClient();
		        RequestParams params = new RequestParams();

		                params.put("usersJSON", jsonvalue);
		                client.post(Config.YOUR_SERVER_URL+"/clientSync.php",params ,new AsyncHttpResponseHandler() {
		                    @Override
		                    public void onSuccess(String response) {
		                    	JSONObject jsonResponse;

		    	                try {

		    	                     /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
		    	                     jsonResponse = new JSONObject(response);

		    	                     /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
		    	                     /*******  Returns null otherwise.  *******/
		    	                     JSONArray jsonMainNode = jsonResponse.optJSONArray("Category");

		    	                     /*********** Process each JSON Node ************/

		    	                     int lengthJsonArr = jsonMainNode.length();
		    	                     HashMap<String, Category> entryMap = new HashMap<String, Category>();
		    	                     for(int i=0; i < lengthJsonArr; i++)
		    	                     {
		    	                         /****** Get Object for each JSON node.***********/
		    	                         JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

		    	                         /******* Fetch node values **********/
		    	                         String cid       = jsonChildNode.optString("cid").toString();
		    	                         String name       = jsonChildNode.optString("name").toString();
		    	                         String seq       = jsonChildNode.optString("seq").toString();

		    	                         //Log.i("GCM","---"+Name);

		    	                         //UserData userdata = new UserData();
		    	                        // userdata.setIMEI(IMEI);
		    	                         //userdata.setName(Name);
		    	                        Category cat=new Category();
		    	                        cat.set_id(Integer.parseInt(cid));
		    	                        cat.set_name(name);
		    	                        cat.set_sequence(Integer.parseInt(seq));

		    	                       //Add user data to controller class UserDataArr arraylist
		    	                         //aController.setUserData(userdata);
		    	                      //  List<Category> allCat=DBAdapter.getAllCategoryData();


		    	                       // for (Category e : allCat) {
		    	                            entryMap.put(String.valueOf(cid), cat);
		    	                       // }

		    	                       // DBAdapter.addCategoryData(cat);

		    	                    }

		    	                     List<Category> allCat=DBAdapter.getAllCategoryData();
		    	                     for (Category e : allCat) {
		    	                    	 Category match = entryMap.get(String.valueOf(e.get_id()));
			    	                        if (match != null) {
			    	                        	 entryMap.remove(String.valueOf(e.get_id()));
			    	                        	 /*if ((match.get_name() != null && !match.get_name().equals(e.get_name())) ||
			    	                                     (match.get_sequence() != e.get_sequence())) {

			    	                        	 }*/
			    	                        	 if ((match.get_name() != null && !match.get_name().equals(e.get_name())))	{

			    	                        		 DBAdapter.updateCatName(e.get_id(),match.get_name());
			    	                        	 }

			    	                        	 if(match.get_sequence() != e.get_sequence()) {
			    	                        		 DBAdapter.addCatSeq(e.get_id(),match.get_sequence());

			    	                        	 }
			    	                        }
			    	                        else
			    	                        {
			    	                        	DBAdapter.deleteCategory(e.get_id());
			    	                        }
		    	                     }
		    	                     for (Category e : entryMap.values()) {

		    	                        DBAdapter.addCategoryData(e);
		    	                     }


		    	                 /****************** End Parse Response JSON Data *************/

		    	                  //Add user data to controller class UserDataArr arraylist
		    	                //  gridView.setAdapter(new CustomGridAdapter(getBaseContext(), aController));


		    	                 } catch (JSONException e) {

		    	                     e.printStackTrace();
		    	                 }

		                    }

		                    @Override
		                    public void onFailure(int statusCode, Throwable error,
		                        String content) {
		                    	if (statusCode == 404) {
		                             Toast.makeText(con, "Requested resource not found", Toast.LENGTH_LONG).show();
		                         } else if (statusCode == 500) {
		                             Toast.makeText(con, "Something went wrong at server end", Toast.LENGTH_LONG).show();
		                         } else {
		                             Toast.makeText(con, "Device might not be connected to Internet",
		                                     Toast.LENGTH_LONG).show();
		                         }

		                    }
		                }
		            );
		 }catch(Exception e)
		 {

		 }
	}

	public void callserverforreceiveorder(String jsonvalue, final Context con) {
		// TODO Auto-generated method stub
		 try
		 {
			 /*final ProgressDialog Dialog = new ProgressDialog(con);
		 Dialog.setMessage("Sending order to all device of your venue");
			 Dialog.show();*/
			//Create AsycHttpClient object
		        AsyncHttpClient client = new AsyncHttpClient();
		        client.setTimeout(3000);
		        RequestParams params = new RequestParams();
		      	       
		                params.put("usersJSON", jsonvalue);
		               // GCMIntentService.received=false;
		                client.post(Config.YOUR_SERVER_URL+"/taborder.php",params ,new AsyncHttpResponseHandler() {
		                    @Override
		                    public void onSuccess(String response) {
		                    	//try{
		                    		
		                    	/*	Dialog.dismiss();
		                        	newOrderActivity.myCartHash.clear();
		                        	newOrderActivity.itemExtra.clear();
		                        	if(newOrderActivity.newitemExtra!=null)
		                        		newOrderActivity.newitemExtra.clear();
		                            	if(newOrderActivity.mynewCartHash!=null)
		                            		newOrderActivity.mynewCartHash.clear();
		                            	newOrderActivity.tableName="";
		                            	newOrderActivity.mycart=null;
		                            	newOrderActivity.changed=false;
		                            	
		                    	}
		                    		 catch(Exception e)
		                    		 {}
		                      //  total=0;
		                            //Toast.makeText(getSherlockActivity(), "Tapped home", Toast.LENGTH_SHORT).show();
		                           // onHomeSelectedListener.onHomeSelected();
		                        	
		                        	Intent intent11 = new Intent(con, MainActivity.class);  
		                        	intent11.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		                        	Bundle mBundle1 = new Bundle();
		                    		mBundle1.putString("ID", "1");
		                    		intent11.putExtras(mBundle1);
		                        	con.startActivity(intent11);*/
		                    	/*try{
		                    		int jsonStart = response.indexOf("{");
		    	                	int jsonEnd = response.lastIndexOf("}");

		    	                	if (jsonStart >= 0 && jsonEnd >= 0 && jsonEnd > jsonStart) {
		    	                		response = response.substring(jsonStart, jsonEnd + 1);
		    	                	} else {
		    	                	    // deal with the absence of JSON content here
		    	                	}
		                    		JSONObject jsonResponse;
		  	                      
		        	               
		        	                     /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
		        	                /*     jsonResponse = new JSONObject(response);
		        	                      
		        	                     /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
		        	                     /*******  Returns null otherwise.  *******/
		        	                    
		        	                     /*********** Process each JSON Node ************/
		        	                  /*   Log.i("E1", response.toString());
		        	                     
		        	                     JSONArray  jsonMainNode = jsonResponse.optJSONArray("Cart");
		        	                     Log.i("E2", jsonMainNode.toString());
		                    		//String a=jsonMainNode.toString();
		        	                     int lengthJsonArr = jsonMainNode.length();  
		        	                     for(int i=0; i < lengthJsonArr; i++) 
		        	                     {
		        	                    	 /****** Get Object for each JSON node.***********/
		        	                    /*     JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		        	                          
		        	                         /******* Fetch node values **********/
		        	                      /*   String id       = jsonChildNode.optString("id").toString();
		        	                         String tableName       = jsonChildNode.optString("tableName").toString();
		        	                         String total       = jsonChildNode.optString("total").toString();
		        	                         String time       = jsonChildNode.optString("time").toString();
		        	                         ModelCart cart=new ModelCart();
		        	                         cart.setId(Integer.parseInt(id));
		        	                         cart.setTableName(tableName);
		        	                         cart.setTotal(total);
		        	                         cart.setTime(time);
		        	                         DBAdapter.addCartData(cart);
		        	                       
		        	                    }
		                    	//Gson gson = new GsonBuilder().create();
		                    	//ModelCart cart=gson.fromJson(response,ModelCart.class);
		                	
		        	                 jsonMainNode = jsonResponse.optJSONArray("CartItem");
		        	                lengthJsonArr = jsonMainNode.length();  
	        	                     for(int i=0; i < lengthJsonArr; i++) 
	        	                     {
	        	                    	 /****** Get Object for each JSON node.***********/
	        	                    /*     JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
	        	                          
	        	                         /******* Fetch node values **********/
	        	                        /* String id       = jsonChildNode.optString("id").toString();
	        	                         String item_id       = jsonChildNode.optString("item_id").toString();
	        	                         String item_name       = jsonChildNode.optString("item_name").toString();
	        	                         String item_price       = jsonChildNode.optString("item_price").toString();
	        	                         String item_quant       = jsonChildNode.optString("item_quant").toString();
	        	                         String item_flag       = jsonChildNode.optString("item_flag").toString();
	        	                         String cid       = jsonChildNode.optString("cid").toString();
	        	                        Item i1=new Item();
	        	                        i1.set_id(Integer.parseInt(item_id));
	        	                        i1.set_name(item_name);
	        	                        i1.set_price(item_price);
	        	                        i1.set_flag(item_flag);
	        	                        
	        	                        CartItems cartitem=new CartItems();
	        	                        cartitem.set_id(Integer.parseInt(id));
	        	                        cartitem.set_item(i1);
	        	                        cartitem.set_quantity(Integer.parseInt(item_quant));
	        	                        cartitem.set_cartid(Integer.parseInt(cid));
	        	                        
	        	                        
	        	                        DBAdapter.addCartitems(cartitem, Integer.parseInt(cid));
	        	                       
	        	                    }
		                		//items.append(cart.getTableName());
		                		
		                		
		                		Dialog.dismiss();
		                    	}
		                    	catch(Exception e)
		                    	{
		                    		Dialog.dismiss();
		                    		Log.i("E", String.valueOf(e.getMessage()));
		                    	}
		                    	
		                		*/
		                	//	aController.CartUpdate(context, "Hello");
		                    }
		                		
		 
		                    @Override
		                    public void onFailure(int statusCode, Throwable error,
		                        String content) {
		                    //	Dialog.dismiss();
		                         if (statusCode == 404) {
		                             Toast.makeText(con, "Requested resource not found", Toast.LENGTH_LONG).show();
		                         } else if (statusCode == 500) {
		                             Toast.makeText(con, "Something went wrong at server end", Toast.LENGTH_LONG).show();
		                         } else {
		                             Toast.makeText(con, "Device might not be connected to Internet",
		                                     Toast.LENGTH_LONG).show();
		                             
		                         }
		                         //str=false;
		                        // TODO Auto-generated method stub
		                    	//Dialog.dismiss();
		                       
		                    }
		                }
		            );
		 }catch(Exception e)
		 {
			
		 }
	}
	public void callserverforUpdateorder(String json, final Context con) {
		 try
		 {/*
			 final ProgressDialog Dialog = new ProgressDialog(con);
		 Dialog.setMessage("Sending order to all device of your venue");
		 Dialog.show();*/
			 
			//Create AsycHttpClient object
		        AsyncHttpClient client = new AsyncHttpClient();
		        client.setTimeout(3);
		        
		        RequestParams params = new RequestParams();
		        
		         boolean  returnString=false;
		                params.put("usersJSON", json);
		               
		                client.post(Config.YOUR_SERVER_URL+"/updateCart.php",params ,new AsyncHttpResponseHandler() {
		                	boolean str=false;
		                	
		                    @Override
		                    public void onSuccess(String response) {
		                    	
		                    	Log.i("E", response.toString());
		                    	//Dialog.hide();
		                    	/*try{
		                    		
		                    		Dialog.dismiss();
		                        	newOrderActivity.myCartHash.clear();
		                        	newOrderActivity.itemExtra.clear();
		                        	if(newOrderActivity.newitemExtra!=null)
		                        		newOrderActivity.newitemExtra.clear();
		                            	if(newOrderActivity.mynewCartHash!=null)
		                            		newOrderActivity.mynewCartHash.clear();
		                            	newOrderActivity.tableName="";
		                            	newOrderActivity.mycart=null;
		                            	newOrderActivity.changed=false;
		                            	
		                    		 }
		                    		 catch(Exception e)
		                    		 {}
		                      //  total=0;
		                            //Toast.makeText(getSherlockActivity(), "Tapped home", Toast.LENGTH_SHORT).show();
		                           // onHomeSelectedListener.onHomeSelected();
		                        	
		                        	Intent intent11 = new Intent(con, MainActivity.class);  
		                        	intent11.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		                        	Bundle mBundle1 = new Bundle();
		                    		mBundle1.putString("ID", "1");
		                    		intent11.putExtras(mBundle1);
		                        	con.startActivity(intent11);
		                        	*/
		                        //	String a="finish";
		                        	//str=true;
		                        	//return true;
		                        	//returnString=a;
		                        		        	//newOrderActivity.finish();
		                    	/*try{
		                    		int jsonStart = response.indexOf("{");
		    	                	int jsonEnd = response.lastIndexOf("}");

		    	                	if (jsonStart >= 0 && jsonEnd >= 0 && jsonEnd > jsonStart) {
		    	                		response = response.substring(jsonStart, jsonEnd + 1);
		    	                	} else {
		    	                	    // deal with the absence of JSON content here
		    	                	}
		                    		JSONObject jsonResponse;
		  	                      
		        	               
		        	                      jsonResponse = new JSONObject(response);
		        	                      
		        	                     
		        	                     Log.i("E1", response.toString());
		        	                     
		        	                     JSONArray  jsonMainNode = jsonResponse.optJSONArray("Cart");
		        	                     Log.i("E2", jsonMainNode.toString());
		                    		//String a=jsonMainNode.toString();
		        	                     int lengthJsonArr = jsonMainNode.length();  
		        	                     for(int i=0; i < lengthJsonArr; i++) 
		        	                     {
		        	                    	
		        	                         JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		        	                          
		        	                        
		        	                         String id       = jsonChildNode.optString("id").toString();
		        	                         String tableName       = jsonChildNode.optString("tableName").toString();
		        	                         String total       = jsonChildNode.optString("total").toString();
		        	                         String time       = jsonChildNode.optString("time").toString();
		        	                         ModelCart cart=new ModelCart();
		        	                         cart.setId(Integer.parseInt(id));
		        	                         cart.setTableName(tableName);
		        	                         cart.setTotal(total);
		        	                         cart.setTime(time);
		        	                         DBAdapter.updateCart(cart.getId(),cart.getTableName(),cart.getTotal());
		        	                         for (CartItems citem : DBAdapter.getAllCartItemsDataByCartId(cart.getId())) {
				        	         				DBAdapter.deleteCartitem(citem.get_id());
				        	         			}
		        	                    }
		        	                     
		                    	//Gson gson = new GsonBuilder().create();
		                    	//ModelCart cart=gson.fromJson(response,ModelCart.class);
		                	
		        	                 jsonMainNode = jsonResponse.optJSONArray("CartItem");
		        	                lengthJsonArr = jsonMainNode.length();  
	        	                     for(int i=0; i < lengthJsonArr; i++) 
	        	                     {
	        	                    	 
	        	                         JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
	        	                          
	        	                        
	        	                         String id       = jsonChildNode.optString("id").toString();
	        	                         String item_id       = jsonChildNode.optString("item_id").toString();
	        	                         String item_name       = jsonChildNode.optString("item_name").toString();
	        	                         String item_price       = jsonChildNode.optString("item_price").toString();
	        	                         String item_quant       = jsonChildNode.optString("item_quant").toString();
	        	                         String item_flag       = jsonChildNode.optString("item_flag").toString();
	        	                         String cid       = jsonChildNode.optString("cid").toString();
	        	                        Item i1=new Item();
	        	                        i1.set_id(Integer.parseInt(item_id));
	        	                        i1.set_name(item_name);
	        	                        i1.set_price(item_price);
	        	                        i1.set_flag(item_flag);
	        	                        
	        	                        CartItems cartitem=new CartItems();
	        	                        cartitem.set_id(Integer.parseInt(id));
	        	                        cartitem.set_item(i1);
	        	                        cartitem.set_quantity(Integer.parseInt(item_quant));
	        	                        cartitem.set_cartid(Integer.parseInt(cid));
	        	                        
	        	                        
	        	                        DBAdapter.addCartitems(cartitem, Integer.parseInt(cid));
	        	                       
	        	                    }
		                		//items.append(cart.getTableName());
		                		
		                		
		                		Dialog.dismiss();
		                    	}
		                    	catch(Exception e)
		                    	{
		                    		Dialog.dismiss();
		                    		Log.i("E", String.valueOf(e.getMessage()));
		                    	}
		                    	*/
		                		
		                	//	aController.CartUpdate(context, "Hello");
		                    
		                		
		                    }
		                  
		                    @Override
		                    public void onFailure(int statusCode, Throwable error,
		                        String content) {
		                    	//super.onFailure(statusCode, error, content);
		                    	Log.i("E", String.valueOf(statusCode));
		                        // TODO Auto-generated method stub
		                    	// Dialog.dismiss();
		                         if (statusCode == 404) {
		                             Toast.makeText(con, "Requested resource not found", Toast.LENGTH_LONG).show();
		                         } else if (statusCode == 500) {
		                             Toast.makeText(con, "Something went wrong at server end", Toast.LENGTH_LONG).show();
		                         } else {
		                             Toast.makeText(con, "Device might not be connected to Internet",
		                                     Toast.LENGTH_LONG).show();
		                         }
		                         str=false;
		                    }
		                     
		                }
		                
		               
		            );
		                
		                
		 }catch(Exception e)
		 {
			
		 }
	//	return null;
		
	}
	/*public static void addCartitems(int iid, CartItems value, int id,Context con) {
		// TODO Auto-generated method stub
		 try
		 {
				 ArrayList<HashMap<String, String>> wordList;
		        wordList = new ArrayList<HashMap<String, String>>();
		        HashMap<String, String> map = new HashMap<String, String>();
		        map.put("oprn","Insert");
		        map.put("table", "CartItem");
		        map.put("id", String.valueOf(iid));
		        map.put("itemid", String.valueOf(value.get_item().get_id()));
		        map.put("name", String.valueOf(value.get_item().get_name()));
		        map.put("price", String.valueOf(value.get_item().get_price()));
		        map.put("quantity", String.valueOf(value.get_quantity()));
		        map.put("flag","I");		        
		        map.put("cartid", String.valueOf(id));
		        map.put("rid", String.valueOf(DBAdapter.getRestaurantId()));
		       wordList.add(map);
		        Gson gson = new GsonBuilder().create();
			 crudonserver crudop=new crudonserver();
			 crudop.callserverforcrudopern(gson.toJson(wordList),con);
			 
		 }catch(Exception e)
		 {
			// error=String.valueOf(e.getMessage());
			 //Toast.makeText(context,Toast.LENGTH_LONG).show();
		 }
	}*/
/*	public static void addCartitemsExtra(int cIEid, Extra value,int itemid, int cartId,Context con) {
		// TODO Auto-generated method stub
		 try
		 {
				 ArrayList<HashMap<String, String>> wordList;
		        wordList = new ArrayList<HashMap<String, String>>();
		        HashMap<String, String> map = new HashMap<String, String>();
		        map.put("oprn","Insert");
		        map.put("table", "CartItem");
		        map.put("id", String.valueOf(cIEid));
		        map.put("itemid", String.valueOf(itemid));
		        map.put("name", String.valueOf(value.get_name()));
		        map.put("price", String.valueOf(value.get_price()));
		        map.put("quantity", "1");
		        map.put("flag","E");		        
		        map.put("cartid", String.valueOf(cartId));
		        map.put("rid", String.valueOf(DBAdapter.getRestaurantId()));
		       wordList.add(map);
		        Gson gson = new GsonBuilder().create();
			 crudonserver crudop=new crudonserver();
			 crudop.callserverforcrudopern(gson.toJson(wordList),con);
			 
		 }catch(Exception e)
		 {
			// error=String.valueOf(e.getMessage());
			 //Toast.makeText(context,Toast.LENGTH_LONG).show();
		 }
	}*/
	/*public static void deleteCartitem(int get_id,Context con) {
		
		 try
		 {
				 ArrayList<HashMap<String, String>> wordList;
		        wordList = new ArrayList<HashMap<String, String>>();
		        HashMap<String, String> map = new HashMap<String, String>();
		        map.put("oprn","Delete");
		        map.put("table", "CartItem");
		        map.put("id", String.valueOf(get_id));
		        map.put("rid", String.valueOf(DBAdapter.getRestaurantId()));
		       wordList.add(map);
		        Gson gson = new GsonBuilder().create();
			 crudonserver crudop=new crudonserver();
			 crudop.callserverforcrudopern(gson.toJson(wordList),con);
			 
		 }catch(Exception e)
		 {
			// error=String.valueOf(e.getMessage());
			 //Toast.makeText(context,Toast.LENGTH_LONG).show();
		 }
	}*/
	/*public static void updateCartItemQuantity(int get_id, int get_quantity,Context con) {
		 try
		 {
				 ArrayList<HashMap<String, String>> wordList;
		        wordList = new ArrayList<HashMap<String, String>>();
		        HashMap<String, String> map = new HashMap<String, String>();
		        map.put("oprn","Update");
		        map.put("table", "CartItem");
		        map.put("field","Qty");
		        map.put("id", String.valueOf(get_id));
		        map.put("qty", String.valueOf(get_quantity));
		        map.put("rid", String.valueOf(DBAdapter.getRestaurantId()));
		       wordList.add(map);
		        Gson gson = new GsonBuilder().create();
			 crudonserver crudop=new crudonserver();
			 crudop.callserverforcrudopern(gson.toJson(wordList),con);
			 
		 }catch(Exception e)
		 {
			// error=String.valueOf(e.getMessage());
			 //Toast.makeText(context,Toast.LENGTH_LONG).show();
		 }
	}*/
	/*public static void updateCart(int id, String tableName, String total, Context con) {
		 try
		 {
				 ArrayList<HashMap<String, String>> wordList;
		        wordList = new ArrayList<HashMap<String, String>>();
		        HashMap<String, String> map = new HashMap<String, String>();
		        map.put("oprn","Update");
		        map.put("table", "Cart");
		        map.put("field","Table");
		        map.put("id", String.valueOf(id));
		        map.put("table1",tableName);
		        map.put("total",total);
		        map.put("rid", String.valueOf(DBAdapter.getRestaurantId()));
		       wordList.add(map);
		        Gson gson = new GsonBuilder().create();
			 crudonserver crudop=new crudonserver();
			 crudop.callserverforcrudopern(gson.toJson(wordList),con);
			 
		 }catch(Exception e)
		 {
			// error=String.valueOf(e.getMessage());
			 //Toast.makeText(context,Toast.LENGTH_LONG).show();
		 }
		
	}*/
	public void sendOrder(String jsonvalue, final Context con) {
		// TODO Auto-generated method stub
		 try
		 {
			 /*final ProgressDialog Dialog = new ProgressDialog(con);
		 Dialog.setMessage("Sending order to all device of your venue");
			 Dialog.show();*/
			//Create AsycHttpClient object
		        AsyncHttpClient client = new AsyncHttpClient();
		        client.setTimeout(10000);
		        RequestParams params = new RequestParams();
		      	       
		                params.put("usersJSON", jsonvalue);	
		               // GCMIntentService.received=false;
		                client.post(Config.YOUR_SERVER_URL+"/sendorder.php",params ,new AsyncHttpResponseHandler() {
		                    @Override
		                    public void onSuccess(String response) {
		                    	
		                    }
		                		
		 
		                    @Override
		                    public void onFailure(int statusCode, Throwable error,
		                        String content) {
		                    //	Dialog.dismiss();
		                         if (statusCode == 404) {
		                             Toast.makeText(con, "Requested resource not found", Toast.LENGTH_LONG).show();
		                         } else if (statusCode == 500) {
		                             Toast.makeText(con, "Something went wrong at server end", Toast.LENGTH_LONG).show();
		                         } else {
		                             Toast.makeText(con, "Device might not be connected to Internet",
		                                     Toast.LENGTH_LONG).show();
		                             
		                         }
		                         //str=false;
		                        // TODO Auto-generated method stub
		                    	//Dialog.dismiss();
		                       
		                    }
		                }
		            );
		 }catch(Exception e)
		 {
			
		 }
	}
	

}
