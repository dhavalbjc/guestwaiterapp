package com.example.astics.qrscannetinbuilt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//import android.widget.Toast;


public class DBAdapter {
	
	/******************** if debug is set true then it will show all Logcat message ************/
	public static final boolean DEBUG = true;
	
	/******************** Logcat TAG ************/
	public static final String LOG_TAG = "DBAdapter";
	
	/******************** Table Fields ************/
	public static final String KEY_ID = "_id";
	public static final String KEY_USER_IMEI    = "user_imei";
	public static final String KEY_USER_NAME    = "user_name";
	public static final String KEY_USER_MESSAGE = "user_message";
	public static final String KEY_DEVICE_IMEI  = "device_imei";
	public static final String KEY_DEVICE_NAME  = "device_name";
	public static final String KEY_DEVICE_EMAIL = "device_email";
	public static final String KEY_DEVICE_REGID = "device_regid";
	
	public static final String KEY_RESTRO_ID = "restro_id";
	public static final String KEY_RESTRO_NAME    = "restro_name";
	public static final String KEY_RESTRO_DESCRIPTION    = "restro_description";
	public static final String KEY_RESTRO_PHONE = "restro_phone";
	public static final String KEY_RESTRO_WEBSITE = "restro_website";
	public static final String KEY_RESTRO_EMAIL  = "restro_email";
	public static final String KEY_RESTRO_STREET  = "restro_street";
	public static final String KEY_RESTRO_CIVICNUMBER = "restro_civicnumber";
	public static final String KEY_RESTRO_ZIPCODE = "restro_zipcode";
	public static final String KEY_RESTRO_CITY    = "restro_city";
	public static final String KEY_RESTRO_STATE    = "restro_state";
	public static final String KEY_RESTRO_COUNTRY = "restro_country";
	public static final String KEY_RESTRO_LATITUDE    = "restro_latitude";
	public static final String KEY_RESTRO_intITUDE = "restro_intitude";
	
	public static final String KEY_STAFF_ID = "staff_id";
	public static final String KEY_STAFF_FNAME    = "staff_fname";
	public static final String KEY_STAFF_LNAME    = "staff_lname";
	public static final String KEY_STAFF_EMAIL = "staff_email";
	public static final String KEY_STAFF_PASSWORD  = "staff_password";
	public static final String KEY_STAFF_ROLL  = "staff_roll";
		
	public static final String KEY_CAT_ID = "category_id";
	public static final String KEY_CAT_NAME = "category_name";
	public static final String KEY_CAT_SEQUENCE = "category_seq";
	
	public static final String KEY_ITEM_ID = "item_id";
	public static final String KEY_ITEM_NAME = "item_name";
	public static final String KEY_ITEM_PRICE = "item_price";
	public static final String KEY_ITEM_CAT = "item_category";
	public static final String KEY_ITEM_SEQUENCE = "item_seq";
	public static final String KEY_ITEM_FLAG = "item_flag";
	
	public static final String KEY_EXTRA_ID = "extra_id";
	public static final String KEY_EXTRA_NAME = "extra_name";
	public static final String KEY_EXTRA_PRICE = "extra_price";
	public static final String KEY_EXTRA_ITEM = "extra_item";
	public static final String KEY_EXTRA_SEQUENCE = "extra_seq";
	/*
	public static final String KEY_CEXTRA_ID = "cextra_id";
	public static final String KEY_CEXTRA_NAME = "cextra_name";
	public static final String KEY_CEXTRA_PRICE = "cextra_price";
	public static final String KEY_CEXTRA_ITEM = "cextra_item";
	public static final String KEY_CEXTRA_SEQUENCE = "cextra_seq";*/
	
	public static final String KEY_CARTITEMS_ID = "cartitems_id";
	public static final String KEY_CARTITEMS_ITEMID = "cartitems_itemid";
	public static final String KEY_CARTITEMS_NAME = "cartitems_name";
	public static final String KEY_CARTITEMS_PRICE = "cartitems_price";
	public static final String KEY_CARTITEMS_QUANTITY = "cartitems_quantity";
	public static final String KEY_CARTITEMS_NOTE = "cartitems_note";
	public static final String KEY_CARTITEMS_COURSE = "cartitems_course";
	public static final String KEY_CARTITEMS_MARK = "cartitems_mark";
	public static final String KEY_CARTITEMS_STATUS = "cartitems_status";
	public static final String KEY_CARTITEMS_FLAG = "cartitems_flag";
	public static final String KEY_CARTITEMS_FID = "cartitems_fid";
	
	
	public static final String KEY_CART_ID = "cart_id";
	public static final String KEY_CART_TABLE = "cart_table";
	public static final String KEY_CART_TOTAL = "cart_total";
	public static final String KEY_CART_USER = "cart_user";
	public static final String KEY_CART_PAID = "cart_paid";
	public static final String KEY_CART_TIME = "cart_time";
		
	public static final String KEY_ECHARGE_ID = "echarge_id";
	public static final String KEY_ECHARGE_CATEGORY = "echarge_category";
	public static final String KEY_ECHARGE_NAME = "echarge_name";
	public static final String KEY_ECHARGE_QUANTITY = "echarge_quantity";
	public static final String KEY_ECHARGE_PARAM = "echarge_param";
	public static final String KEY_ECHARGE_NUM = "echarge_num";
	
	public static final String KEY_PRINTER_ID = "printer_id";
	public static final String KEY_PRINTER_PROTOCOL = "printer_protocol";
	public static final String KEY_PRINTER_CONNECTION = "printer_connection";
	public static final String KEY_PRINTER_MAC = "printer_mac";
	public static final String KEY_PRINTER_IP = "printer_ip";
	public static final String KEY_PRINTER_MODEL = "printer_model";
	public static final String KEY_PRINTER_PAPERWIDTH = "printer_paperwidth";
	public static final String KEY_PRINTER_NAME = "printer_name";
	public static final String KEY_PRINTER_PRINTORDER = "printer_printorder";
	public static final String KEY_PRINTER_ENABLE = "printer_enable";
	public static final String KEY_PRINTER_STATUS = "printer_status";
	
	/******************** Database Name ************/
	public static final String DATABASE_NAME = "DB_sqllite";
	
	/******************** Database Version (Increase one if want to also upgrade your database) ************/
	public static final int DATABASE_VERSION =8;// started at 1

	/** Table names */
	public static final String USER_TABLE = "tbl_user";
	public static final String DEVICE_TABLE = "tbl_device";
	
	public static final String RESTAURANT_TABLE = "tbl_restaurant";
	public static final String STAFF_TABLE = "tbl_staff";
	
	public static final String CATEGORY_TABLE = "tbl_category";
	public static final String ITEM_TABLE = "tbl_item";
	
	public static final String EXTRA_TABLE = "tbl_extra";
	//public static final String CEXTRA_TABLE = "tbl_cextra";
	
	public static final String CART_TABLE = "tbl_cart";
	public static final String CARTITEMS_TABLE = "tbl_cartitems";

	public static final String ECHARGE_TABLE = "tbl_echarge";
	
	public static final String PRINTER_TABLE = "tbl_printer";
	/******************** Set all table with comma seperated like USER_TABLE,ABC_TABLE ************/
	private static final String[] ALL_TABLES = { USER_TABLE,DEVICE_TABLE,RESTAURANT_TABLE,STAFF_TABLE,EXTRA_TABLE,ITEM_TABLE,CATEGORY_TABLE,CART_TABLE,CARTITEMS_TABLE,ECHARGE_TABLE,PRINTER_TABLE};
	
	/** Create table syntax */
	//private static final String USER_MAIN_CREATE = "create table tbl_user_main(_id integer primary key autoincrement, user_name text not null, user_imei text not null);";
	private static final String USER_CREATE = "create table tbl_user(_id integer primary key autoincrement, user_name text not null, user_imei text not null, user_message text not null);";
	private static final String DEVICE_CREATE = "create table tbl_device(_id integer primary key autoincrement, device_name text not null, device_email text not null, device_regid text not null, device_imei text not null);";
	

	private static final String RESTAURANT_CREATE =
			"create table tbl_restaurant(" +
					"restro_id integer primary key, " +
					"restro_name text not null," +
					"restro_description text," +
					"restro_phone text," +
					"restro_website text," +
					"restro_email text," +
					"restro_street text," +
					"restro_civicnumber text," +
					"restro_zipcode text ," +
					"restro_city text," +
					"restro_state text ," +
					"restro_country text," +
					"restro_latitude text," +
					"restro_intitude text);";	
		
	private static final String STAFF_CREATE =
			"create table tbl_staff(" +
					"staff_id integer primary key, " +
					"staff_fname text not null," +
					"staff_lname text," +
					"staff_email text," +
					"staff_password text," +
					"staff_roll text);";					
					
	private static final String CATEGORY_CREATE =
			"create table tbl_category(" +
					"category_id integer primary key, " +
					"category_name text not null," +
					"category_seq integer);";
	private static final String ITEM_CREATE =
			"create table tbl_item(" +
					"item_id integer primary key, " +
					"item_name text not null, " +
					"item_price text, " +
					"item_category integer," +
					"item_seq integer, " +
					"item_flag text);" +
					"FOREIGN KEY(item_category) REFERENCES tbl_category(category_id));";
	private static final String EXTRA_CREATE =
			"create table tbl_extra(" +
					"extra_id integer primary key, " +
					"extra_name text not null, " +
					"extra_price text, " +
					"extra_item integer," +
					"extra_seq integer);" +
					"FOREIGN KEY(extra_item) REFERENCES tbl_item(item_id));";
	private static final String CART_CREATE =
			"create table tbl_cart(" +
					"cart_id integer primary key, " +
					"cart_table text , " +
					"cart_total text, " +
					"cart_user text," +
					"cart_paid text," +
					"cart_time DATETIME DEFAULT CURRENT_TIMESTAMP);" ;
	private static final String CARTITEMS_CREATE =
			"create table tbl_cartitems(" +
					"cartitems_id integer primary key, " +
					"cartitems_name text not null, " +
					"cartitems_price text, " +
					"cartitems_quantity integer, " +
					"cartitems_flag text," +
					"cartitems_note text," +
					"cartitems_course integer, " +
					"cartitems_mark integer, " +
					"cartitems_status text," +
					"cartitems_fid integer," +					
					"cartitems_itemid integer);" ;
	private static final String ECHARGE_CREATE =
			"create table tbl_echarge(" +
					"echarge_id integer primary key, " +
					"echarge_category text not null, " +
					"echarge_name text, " +
					"echarge_quantity text, " +
					"echarge_param text, " +
					"echarge_num text);" ;
					
	private static final String PRINTER_CREATE =
			"create table tbl_printer(" +
					"printer_id integer primary key, " +
					"printer_protocol text," +
					"printer_connection text," +
					"printer_mac text," +
					"printer_ip text," +
					"printer_model text," +
					"printer_paperwidth text," +
					"printer_name text," +
					"printer_printorder text," +
					"printer_enable text," +
					"printer_status text);";			
					
	/*private static final String CEXTRA_CREATE = 
			"create table tbl_cextra(" +
					"cextra_id integer primary key autoincrement, " +
					"cextra_name text not null, " +
					"cextra_price text, " +
					"cextra_item integer," +
					"cextra_seq integer);" +
					"FOREIGN KEY(cextra_item) REFERENCES tbl_category(category_id));";*/
	
	
	/******************** Used to open database in syncronized way ************/
	private static DataBaseHelper DBHelper = null;

	protected DBAdapter() {
	}
    /******************* Initialize database *************/
	public static void init(Context context) {
		if (DBHelper == null) {
			if (DEBUG)
				Log.i("DBAdapter", context.toString());
			DBHelper = new DataBaseHelper(context);
		}
	}
	
	/********************** Open database for insert,update,delete in syncronized manner ********************/
	private static synchronized SQLiteDatabase open() throws SQLException {
		return DBHelper.getWritableDatabase();
	}
	
	private static synchronized SQLiteDatabase openForRead() throws SQLException {
		return DBHelper.getWritableDatabase();
	}

	// Insert installing device data
	public static void addDeviceData(String DeviceName, String DeviceEmail, String DeviceRegID, String DeviceIMEI) {

		final SQLiteDatabase db = open();
		try{

	    	String imei  = sqlEscapeString(DeviceIMEI);
	    	String name  = sqlEscapeString(DeviceName);
			String email = sqlEscapeString(DeviceEmail);
			String regid = sqlEscapeString(DeviceRegID);

			ContentValues cVal = new ContentValues();
			cVal.put(KEY_DEVICE_IMEI, imei);
			cVal.put(KEY_DEVICE_NAME, name);
			cVal.put(KEY_DEVICE_EMAIL, email);
			cVal.put(KEY_DEVICE_REGID, regid);

			db.insertOrThrow(DEVICE_TABLE, null, cVal);
	        //dhaval..    //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	//dhaval..    //dhaval..    db.close(); // Closing database connection
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    }

    public static void addUserData(UserData uData) {
    	final SQLiteDatabase db = open();
    	try{
		    	String imei  = sqlEscapeString(uData.getIMEI());
		    	String name  = sqlEscapeString(uData.getName());
		    	String message  = sqlEscapeString(uData.getMessage());

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_USER_IMEI, imei);
				cVal.put(KEY_USER_NAME, name);
				cVal.put(KEY_USER_MESSAGE, message);
				db.insertOrThrow(USER_TABLE, null, cVal);
		        //dhaval..    //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	 //dhaval..    //dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    }
	
	
	// Adding new user
 
    public static void addRestaurantData(Restaurant restroData) {
    	final SQLiteDatabase db = open();
    	try{

		    	int restro_id= restroData.get_restro_id();
		    	String restro_name  = sqlEscapeString(restroData.get_restro_name());
		    	String restro_description  = sqlEscapeString(restroData.get_restro_description());
		    	String restro_phone  = sqlEscapeString(restroData.get_restro_phone());
		    	String restro_website  = sqlEscapeString(restroData.get_restro_website());
		    	String restro_email  = sqlEscapeString(restroData.get_restro_email());
		    	String restro_street  = sqlEscapeString(restroData.get_restro_street());
		    	String restro_civicnumber  = sqlEscapeString(restroData.get_restro_civicnumber());
		    	String restro_zipcode  = sqlEscapeString(restroData.get_restro_zipcode());
		    	String restro_city  = sqlEscapeString(restroData.get_restro_city());
		    	String restro_state  = sqlEscapeString(restroData.get_restro_state());
		    	String restro_country  = sqlEscapeString(restroData.get_restro_country());
		    	String restro_latitude  = sqlEscapeString(restroData.get_restro_latitude());
		    	String restro_intitude  = sqlEscapeString(restroData.get_restro_longitude());

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_RESTRO_ID, restro_id);
				cVal.put(KEY_RESTRO_NAME, restro_name);
				cVal.put(KEY_RESTRO_DESCRIPTION, restro_description);
				cVal.put(KEY_RESTRO_PHONE, restro_phone);
				cVal.put(KEY_RESTRO_WEBSITE, restro_website);
				cVal.put(KEY_RESTRO_EMAIL, restro_email);
				cVal.put(KEY_RESTRO_STREET, restro_street);
				cVal.put(KEY_RESTRO_CIVICNUMBER, restro_civicnumber);
				cVal.put(KEY_RESTRO_ZIPCODE, restro_zipcode);
				cVal.put(KEY_RESTRO_CITY, restro_city);
				cVal.put(KEY_RESTRO_STATE, restro_state);
				cVal.put(KEY_RESTRO_COUNTRY, restro_country);
				cVal.put(KEY_RESTRO_LATITUDE, restro_latitude);
				cVal.put(KEY_RESTRO_intITUDE, restro_intitude);

				db.insertOrThrow(RESTAURANT_TABLE, null, cVal);
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	//dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    }

    public static int getNewStaffId(){

  	  int id=1;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + STAFF_TABLE +" ORDER BY "+KEY_STAFF_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            	  id= Integer.parseInt(cursor.getString(0));
        id++;
        }
        cursor.close();
  	  return id;
    }

    public static int addStaffData(Staff staffData) {
    	int a=0;
    	final SQLiteDatabase db = open();
    	try{
    			a=DBAdapter.getNewStaffId();

		    	int staff_id= a;
		    	String staff_fname  = sqlEscapeString(staffData.get_staff_fname());
		    	String staff_lname  = sqlEscapeString(staffData.get_staff_lname());
		    	String staff_email  = sqlEscapeString(staffData.get_staff_email());
		    	String staff_password  = sqlEscapeString(staffData.get_staff_password());
		    	String staff_roll  = sqlEscapeString(staffData.get_staff_roll());

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_STAFF_ID, staff_id);
				cVal.put(KEY_STAFF_FNAME, staff_fname);
				cVal.put(KEY_STAFF_LNAME, staff_lname);
				cVal.put(KEY_STAFF_EMAIL, staff_email);
				cVal.put(KEY_STAFF_PASSWORD, staff_password);
				cVal.put(KEY_STAFF_ROLL, staff_roll);


				db.insertOrThrow(STAFF_TABLE, null, cVal);
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	 //dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    	return a;
    }

    public static int getNewCatId(){
  	  int id=0;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + CATEGORY_TABLE +" ORDER BY "+KEY_CAT_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            	  id= Integer.parseInt(cursor.getString(0));
        id++;
        }
        else {
  		id=1;
  	}
        cursor.close();
  	  return id;
    }

    public static int addCategoryData(Category gData) {
    	int a=0;
    	boolean server=false;
    	final SQLiteDatabase db = open();
    	try{

		    	if(gData.get_id()<=0){
		    		a=DBAdapter.getNewCatId();

		    	}
		    	else{
		    		a=gData.get_id();
		    		server=true;
		    	}
		    	String name  = sqlEscapeString(gData.get_name());
		    	int seq  = gData.get_sequence();

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_CAT_ID,a );
				cVal.put(KEY_CAT_NAME, name);
				if(server){
				cVal.put(KEY_CAT_SEQUENCE, seq);}
				else{
					cVal.put(KEY_CAT_SEQUENCE, a);
				}
				//cVal.put(KEY_CAT_SEQUENCE, KEY_CAT_ID);

				db.insertOrThrow(CATEGORY_TABLE, null, cVal);

		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	//dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    return a;
    }

    public static int getNewItemId(){
    	  int id=1;

          // Select All Query
          String selectQuery = "SELECT  * FROM " + ITEM_TABLE +" ORDER BY "+KEY_ITEM_ID+" ";

          final SQLiteDatabase db = open();
          Cursor cursor = db.rawQuery(selectQuery, null);

          // looping through all rows and adding to list
          if (cursor.moveToLast()) {
              	  id= Integer.parseInt(cursor.getString(0));
          id++;
          }
          cursor.close();
    	  return id;
      }

    public static int addItemData(Item iData) {
    	int a=0;
    	boolean server=false;
    	final SQLiteDatabase db = open();
    	try{

		    	if(iData.get_id()<=0){
		    		a=DBAdapter.getNewItemId();

		    	}
		    	else{
		    		a=iData.get_id();
		    		server=true;
		    	}
		    	String name  = sqlEscapeString(iData.get_name());
		    	//int pr=Integer.parseInt(iData.get_price().toString());
		    	String price  = sqlEscapeString(iData.get_price());
		    	int seq  = iData.get_sequence();

		    	int cat_id  = iData.get_category().get_id();
		    	String flag=sqlEscapeString(iData.get_flag());

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_ITEM_ID, a);
				cVal.put(KEY_ITEM_NAME, name);
				cVal.put(KEY_ITEM_PRICE, price);
				cVal.put(KEY_ITEM_CAT, cat_id);
				cVal.put(KEY_ITEM_FLAG, flag);
				if(flag.equals("I")){
					if(server){
						cVal.put(KEY_ITEM_SEQUENCE,seq);
					}else{
					cVal.put(KEY_ITEM_SEQUENCE,1000+a);
					}
				}
				else{
					if(server){
						cVal.put(KEY_ITEM_SEQUENCE,seq);
					}else{
					cVal.put(KEY_ITEM_SEQUENCE,a);
					}
				}

				db.insertOrThrow(ITEM_TABLE, null, cVal);
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	//dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    	return a;
    }
    
    public static int getNewExtraId(){
  	  int id=1;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + EXTRA_TABLE +" ORDER BY "+KEY_EXTRA_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            	  id= Integer.parseInt(cursor.getString(0));
        id++;
        }

        cursor.close();
  	  return id;
    }

    public static int addExtraData(Extra iData) {
    	int a=0;
    	boolean server=false;
    	final SQLiteDatabase db = open();
    	try{

		    	if(iData.get_id()<=0){
		    		a=DBAdapter.getNewExtraId();
		    	}
		    	else{
		    		a=iData.get_id();
		    		server=true;
		    	}
		    	String name  = sqlEscapeString(iData.get_name());
		    	String price  = sqlEscapeString(iData.get_price());
		    	int item_id  = iData.get_item().get_id();

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_EXTRA_ID, a);
				cVal.put(KEY_EXTRA_NAME, name);
				cVal.put(KEY_EXTRA_PRICE, price);
				cVal.put(KEY_EXTRA_ITEM, item_id);
				if(server){
				cVal.put(KEY_EXTRA_SEQUENCE,iData.get_sequence());}
				else{
					cVal.put(KEY_EXTRA_SEQUENCE,a);
				}

				db.insertOrThrow(EXTRA_TABLE, null, cVal);
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	//dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    	return a;
    }

    public static int getNewCartId(){
  	  int id=1;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + CART_TABLE +" ORDER BY "+KEY_CART_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            	  id= Integer.parseInt(cursor.getString(0));
        id++;
        }
        cursor.close();
  	  return id;
    }

    public static long addCartData(ModelCart iData) {
    	long a=0;
    	final SQLiteDatabase db = open();
    	try{


		    	if(iData.getId()<=0){
		    		a=DBAdapter.getNewCartId();
		    	}
		    	else{
		    		a=iData.getId();
		    	}
		    	String table  = sqlEscapeString(iData.getTableName());
		    	String total  = sqlEscapeString(iData.getTotal());
		    	String user  = sqlEscapeString(iData.getUser());
		    	String paid  = sqlEscapeString(iData.getPaid());
		    	//String total  = sqlEscapeString("");
		    	//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		    	//String timeStamp = "";
		    	//String time  = sqlEscapeString(timeStamp);
		    	//int item_id  = iData.get_item().get_id();

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_CART_ID, a);
				cVal.put(KEY_CART_TABLE, table);
				cVal.put(KEY_CART_TOTAL, total);
				cVal.put(KEY_CART_USER, user);
				cVal.put(KEY_CART_PAID, paid);
				if(!iData.getTime().trim().equals(""))
				{
					cVal.put(KEY_CART_TIME, iData.getTime());
				}
				//cVal.put(KEY_CART_TIME, time);

				db.insertOrThrow(CART_TABLE, null, cVal);
				/*if(!iData.getTime().trim().equals(""))
				{
					 ContentValues values = new ContentValues();
			    	    values.put(KEY_CART_TIME, iData.getTime());

			    	     db.update(CART_TABLE, values, KEY_CART_ID + "=" + iData.getId(), null);
					//UPDATE products SET former_date=2011-12-18 13:17:17 WHERE id=1
				}*/
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	 //dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    	return a;
    }

    public static int getNewCartItemsId(){
    	  int id=1;

          // Select All Query
          String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE +" ORDER BY "+KEY_CARTITEMS_ID+" ";

          final SQLiteDatabase db = open();
          Cursor cursor = db.rawQuery(selectQuery, null);

          // looping through all rows and adding to list
          if (cursor.moveToLast()) {
              	  id= Integer.parseInt(cursor.getString(0));
          id++;
          }
          cursor.close();
    	  return id;
      }

    public static long addCartitems(CartItems iData,long l) {
    	long a=0;
    	final SQLiteDatabase db = open();
    	try{


		    	if(iData.get_id()<=0){
		    		a=DBAdapter.getNewCartItemsId();
		    	}
		    	else{
		    		a=iData.get_id();
		    	}
		    	String name  = sqlEscapeString(iData.get_item().get_name());
		    	String price  = sqlEscapeString(iData.get_item().get_price());
		    	String note  = sqlEscapeString(iData.get_note());
		    	String status  = sqlEscapeString(iData.get_status());
		    	//String flag = sqlEscapeString("I");
		    	String flag = sqlEscapeString(iData.get_item().get_flag());
		    	int quantity  = iData.get_quantity();
		    	int course  = iData.get_course();
		    	int mark  = iData.get_mark();
		    	//int fid  = cartid;
		    	int itemId  = iData.get_item().get_id();
		    	//int item_id  = iData.get_item().get_id();

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_CARTITEMS_ID, a);
				cVal.put(KEY_CARTITEMS_NAME, name);
				cVal.put(KEY_CARTITEMS_PRICE, price);
				cVal.put(KEY_CARTITEMS_QUANTITY, quantity);
				cVal.put(KEY_CARTITEMS_FLAG, flag);
				cVal.put(KEY_CARTITEMS_NOTE, note);
				cVal.put(KEY_CARTITEMS_COURSE,course);
				cVal.put(KEY_CARTITEMS_MARK, mark);
				cVal.put(KEY_CARTITEMS_STATUS, status);
				cVal.put(KEY_CARTITEMS_FID, l);
				cVal.put(KEY_CARTITEMS_ITEMID, itemId);

				db.insertOrThrow(CARTITEMS_TABLE, null, cVal);
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	 //dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    	return a;
    }

    public static int addCartitemsExtra(Extra iData,long l,int _itemid) {
    	int a=0;
    	final SQLiteDatabase db = open();
    	try{


		    	if(iData.get_id()<=0){
		    		a=DBAdapter.getNewCartItemsId();
		    	}
		    	else{
		    		a=iData.get_id();
		    	}
		    	String name  = sqlEscapeString(iData.get_name());
		    	String price  = sqlEscapeString(iData.get_price());
		    	String flag = sqlEscapeString("E");
		    	String note  = "null";
		    	String status  = "null";
		    	//int _extra_id=iData.get_id();
		    	int quantity  = 1;
		    	int course  = 0;
		    	int mark  = 0;
		    	long fid  = l;
		    	//int item_id  = iData.get_item().get_id();

				ContentValues cVal = new ContentValues();
				cVal.put(KEY_CARTITEMS_ID, a);
				cVal.put(KEY_CARTITEMS_NAME, name);
				cVal.put(KEY_CARTITEMS_PRICE, price);
				cVal.put(KEY_CARTITEMS_QUANTITY, quantity);
				cVal.put(KEY_CARTITEMS_FLAG, flag);
				cVal.put(KEY_CARTITEMS_NOTE, note);
				cVal.put(KEY_CARTITEMS_COURSE,course);
				cVal.put(KEY_CARTITEMS_MARK, mark);
				cVal.put(KEY_CARTITEMS_STATUS, status);
				cVal.put(KEY_CARTITEMS_FID, fid);
				cVal.put(KEY_CARTITEMS_ITEMID, _itemid);

				db.insertOrThrow(CARTITEMS_TABLE, null, cVal);
		        //dhaval..    db.close(); // Closing database connection
	    } catch (Exception t) {
	    	//dhaval..    db.close();
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
    	return a;
    }

    public static int getEchargeId(){
    	  int id=0;

          // Select All Query
          String selectQuery = "SELECT  * FROM " + ECHARGE_TABLE +" ORDER BY "+KEY_ECHARGE_ID+" ";

          final SQLiteDatabase db = open();
          Cursor cursor = db.rawQuery(selectQuery, null);

          // looping through all rows and adding to list
          if (cursor.moveToLast()) {
              	  id= Integer.parseInt(cursor.getString(0));
          id++;
          }
          else {
    		id=1;
    	}
          cursor.close();
    	  return id;
      }

      public static int addEChargeData(ECharge echarge) {
      	int a=0;
      	//boolean server=false;
      	final SQLiteDatabase db = open();
      	try{

  		    	if(echarge.get_id()<=0){
  		    		a=DBAdapter.getEchargeId();

  		    	}
  		    	else{
  		    		a=echarge.get_id();
  		    		//server=true;
  		    	}
  		  	String cat  = sqlEscapeString(echarge.get_category());
	    	String name  = sqlEscapeString(echarge.get_name() );
	    	String qty  = sqlEscapeString(echarge.get_quantity());
	    	String param  = sqlEscapeString(echarge.get_param());


  				ContentValues cVal = new ContentValues();
  				cVal.put(KEY_ECHARGE_ID,a );
  				cVal.put(KEY_ECHARGE_CATEGORY,cat);
				cVal.put(KEY_ECHARGE_NAME,name);
				cVal.put(KEY_ECHARGE_QUANTITY,qty);
				cVal.put(KEY_ECHARGE_PARAM,param);

				//cVal.put(KEY_CAT_SEQUENCE, KEY_CAT_ID);

				db.insertOrThrow(ECHARGE_TABLE, null, cVal);

		        //dhaval..    db.close();  // Closing database connection
  	    } catch (Exception t) {
  	    	//dhaval..    db.close();
  			Log.i("Database", "Exception caught: " + t.getMessage(), t);
  		}
      return a;
      }

      public static int getNewPrinterId(){
      	  int id=0;

            // Select All Query
            String selectQuery = "SELECT  * FROM " + PRINTER_TABLE +" ORDER BY "+KEY_PRINTER_ID+" ";

            final SQLiteDatabase db = open();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToLast()) {
                	  id= Integer.parseInt(cursor.getString(0));
            id++;
            }
            else {
      		id=1;
      	}
            cursor.close();
      	  return id;
        }
   
        public static int addPrinterData(Printer gData) {
        	int a=0;
        	boolean server=false;
        	final SQLiteDatabase db = open();
        	try{

    		    	if(gData.get_id()<=0){
    		    		a=DBAdapter.getNewPrinterId();

    		    	}
    		    	else{
    		    		a=gData.get_id();

    		    	}
    		    	String protocol  = sqlEscapeString(gData.get_protocol());
    		    	String connection  = sqlEscapeString(gData.get_connection());
    		    	String mac  = sqlEscapeString(gData.get_mac());
    		    	String ip  = sqlEscapeString(gData.get_ip());
    		    	String model  = sqlEscapeString(gData.get_model());
    		    	String paperwidth  = sqlEscapeString(gData.get_paperwidth());
    		    	String name  = sqlEscapeString(gData.get_name());
    		    	String printorder  = sqlEscapeString(gData.get_printorder());
    		    	String enable  = sqlEscapeString(gData.get_enable());
    		    	String status  = sqlEscapeString(gData.get_status());


    				ContentValues cVal = new ContentValues();
    				cVal.put(KEY_PRINTER_ID,a );
    				cVal.put(KEY_PRINTER_PROTOCOL, protocol);
    				cVal.put(KEY_PRINTER_CONNECTION, connection);
    				cVal.put(KEY_PRINTER_MAC, mac);
    				cVal.put(KEY_PRINTER_IP, ip);
    				cVal.put(KEY_PRINTER_MODEL,model );
    				cVal.put(KEY_PRINTER_PAPERWIDTH,paperwidth );
    				cVal.put(KEY_PRINTER_NAME,name );
    				cVal.put(KEY_PRINTER_PRINTORDER,printorder );
    				cVal.put(KEY_PRINTER_ENABLE,enable );
    				cVal.put(KEY_PRINTER_STATUS,status );
    				//cVal.put(KEY_CAT_SEQUENCE, KEY_CAT_ID);

    				db.insertOrThrow(PRINTER_TABLE, null, cVal);

    		        //dhaval..    db.close(); // Closing database connection
    	    } catch (Exception t) {
    	    	//dhaval..    db.close();
    			Log.i("Database", "Exception caught: " + t.getMessage(), t);
    		}
        return a;
        }

    // Getting single user data
    public static UserData getUserData(int id) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(USER_TABLE, new String[] { KEY_ID,
        		KEY_USER_NAME, KEY_USER_IMEI,KEY_USER_MESSAGE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        UserData data = new UserData(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        cursor.close();
        // return contact
        return data;
    }

    public static String getStaffName(String email){
  	  String name="";

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DEVICE_TABLE +" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
        	name=cursor.getString(1).toString();

        }
        cursor.close();
  	  return name;
    }

    public static Staff getStaffData(String email) {
    	Cursor cursor = null;
    	Staff data=null;
    	try
    	{
    	final SQLiteDatabase db = open();

        cursor = db.query(STAFF_TABLE, new String[] { KEY_STAFF_ID,
        		KEY_STAFF_FNAME,KEY_STAFF_LNAME,KEY_STAFF_ROLL}, KEY_STAFF_EMAIL + "=?",
                new String[] { String.valueOf(email) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();

         data = new Staff(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3));}
        cursor.close();
    	}catch(Exception e)
    	{
    		//cursor.close();
    	}
        // return contact
        return data;
    }

    /*public static int getRestaurantId(){
    	  int id=0;

          // Select All Query
          String selectQuery = "SELECT  * FROM " + RESTAURANT_TABLE +" ORDER BY "+KEY_RESTRO_ID+" ";

          final SQLiteDatabase db = open();
          Cursor cursor = db.rawQuery(selectQuery, null);

          // looping through all rows and adding to list
          if (cursor.moveToFirst()) {
              	  id= Integer.parseInt(cursor.getString(0).toString());

          }
          cursor.close();
    	  return id;
      }*/
    public static String getRestaurantName(){
  	  String name="";

        // Select All Query
        String selectQuery = "SELECT  * FROM " + RESTAURANT_TABLE +" ORDER BY "+KEY_RESTRO_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            	  name=cursor.getString(1);

        }
        cursor.close();
  	  return name;
    }

    public static int getRestaurant(){
  	  int id=0;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + RESTAURANT_TABLE +" ORDER BY "+KEY_RESTRO_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            	  id= Integer.parseInt(cursor.getString(0).toString());

        }
        cursor.close();
  	  return id;
    }

    public static Restaurant getRestaurant(int a) {
    	Cursor cursor = null;
    	Restaurant data=null;
    	try
    	{
    	final SQLiteDatabase db = open();

        cursor = db.query(RESTAURANT_TABLE, new String[] { KEY_RESTRO_ID,
        		 KEY_RESTRO_NAME, KEY_RESTRO_DESCRIPTION, KEY_RESTRO_PHONE, KEY_RESTRO_WEBSITE, KEY_RESTRO_EMAIL,
        		 KEY_RESTRO_STREET, KEY_RESTRO_CIVICNUMBER, KEY_RESTRO_ZIPCODE, KEY_RESTRO_CITY, KEY_RESTRO_STATE,
        		 KEY_RESTRO_COUNTRY},  KEY_RESTRO_ID + "=?",
                new String[] { String.valueOf(a) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

         data = new Restaurant(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                cursor.getString(6),cursor.getString(7),cursor.getString(8),
                cursor.getString(9),cursor.getString(10),cursor.getString(11));

        cursor.close();
    	}catch(Exception e)
    	{
    		cursor.close();
    	}
        // return contact
        return data;
    }

    // Getting single user data
    public static Category getCategoryData(int a) {
    	Cursor cursor = null;
    	Category data=null;
    	try
    	{
    	final SQLiteDatabase db = open();

        cursor = db.query(CATEGORY_TABLE, new String[] { KEY_CAT_ID,
        		KEY_CAT_NAME,KEY_CAT_SEQUENCE}, KEY_CAT_ID + "=?",
                new String[] { String.valueOf(a) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

         data = new Category(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        cursor.close();
    	}catch(Exception e)
    	{
    		cursor.close();
    	}
        // return contact
        return data;
    }

    public static Category getCategoryData(String id) {
    	Cursor cursor = null;
    	Category data=null;
    	try
    	{
    	final SQLiteDatabase db = open();

        cursor = db.query(CATEGORY_TABLE, new String[] { KEY_CAT_ID,
        		KEY_CAT_NAME,KEY_CAT_SEQUENCE}, KEY_CAT_NAME + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        data = new Category(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        cursor.close();
    	}
    	catch(Exception e)
    	{
    		cursor.close();
    	}
        // return contact
        return data;
    }

    public static Item getItemData(int id) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(ITEM_TABLE, new String[] { KEY_ITEM_ID,
        		KEY_ITEM_NAME,KEY_ITEM_PRICE,KEY_ITEM_CAT,KEY_ITEM_SEQUENCE,KEY_ITEM_FLAG}, KEY_ITEM_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Item data = new Item(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),getCategoryData(Integer.parseInt(cursor.getString(3))), Integer.parseInt(cursor.getString(4)),cursor.getString(5));
        cursor.close();
        // return contact
        return data;
    }

    public static Item getItemData(String id) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(ITEM_TABLE, new String[] { KEY_ITEM_ID,
        		KEY_ITEM_NAME,KEY_ITEM_PRICE,KEY_ITEM_CAT,KEY_ITEM_SEQUENCE,KEY_ITEM_FLAG}, KEY_ITEM_NAME + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Item data = new Item(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),getCategoryData(Integer.parseInt(cursor.getString(3))), Integer.parseInt(cursor.getString(4)),cursor.getString(5));
        cursor.close();
        // return contact
        return data;
    }

    public static Boolean hasItemData(String id) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(ITEM_TABLE, new String[] { KEY_ITEM_ID,
        		KEY_ITEM_NAME,KEY_ITEM_PRICE,KEY_ITEM_CAT,KEY_ITEM_SEQUENCE,KEY_ITEM_FLAG}, KEY_ITEM_NAME + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if(cursor.moveToFirst())

            return true; //row exists
           else
            return false;
    }

    public static ArrayList<Printer> getAllPrinterData() {
    	ArrayList<Printer> contactList = new ArrayList<Printer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + PRINTER_TABLE+" ORDER BY "+KEY_PRINTER_ID+" desc";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Printer data = new Printer();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_protocol(cursor.getString(1).toString());
            	data.set_connection(cursor.getString(2).toString());
            	data.set_mac(cursor.getString(3).toString());
            	data.set_ip(cursor.getString(4).toString());
            	data.set_model(cursor.getString(5).toString());
            	data.set_paperwidth(cursor.getString(6).toString());
            	data.set_name(cursor.getString(7).toString());
            	data.set_printorder(cursor.getString(8).toString());
            	data.set_enable(cursor.getString(9).toString());
            	data.set_status(cursor.getString(10).toString());
                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }
   
    public static ArrayList<Printer> getKitchenPrinterData() {
    	ArrayList<Printer> contactList = new ArrayList<Printer>();
        // Select All Query
        String printorder="yes";
        String selectQuery = "SELECT  * FROM " + PRINTER_TABLE+" WHERE printer_printorder='"+ printorder +"' ORDER BY "+KEY_PRINTER_ID+" desc";
       // String selectQuery = "SELECT  * FROM " + PRINTER_TABLE+" WHERE item_flag='"+ flag +"' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Printer data = new Printer();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_protocol(cursor.getString(1));
            	data.set_connection(cursor.getString(2));
            	data.set_mac(cursor.getString(3));
            	data.set_ip(cursor.getString(4));
            	data.set_model(cursor.getString(5));
            	data.set_paperwidth(cursor.getString(6));
            	data.set_name(cursor.getString(7));
            	data.set_printorder(cursor.getString(8));
            	data.set_enable(cursor.getString(9));
            	data.set_status(cursor.getString(10));
                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static Extra getExtraData(int id) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(EXTRA_TABLE, new String[] { KEY_EXTRA_ID,
        		KEY_EXTRA_NAME,KEY_EXTRA_PRICE,KEY_EXTRA_SEQUENCE,KEY_EXTRA_ITEM}, KEY_EXTRA_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Extra data = new Extra(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),getItemData(Integer.parseInt(cursor.getString(4))));
        cursor.close();
        // return contact
        return data;
    }

    public static Printer getPrinter(int a) {
    	Cursor cursor = null;
    	Printer data=null;
    	try
    	{
    	final SQLiteDatabase db = open();

        cursor = db.query(PRINTER_TABLE, new String[] { KEY_PRINTER_ID,
        		KEY_PRINTER_MAC,KEY_PRINTER_NAME,KEY_PRINTER_PRINTORDER}, KEY_PRINTER_ID + "=?",
                new String[] { String.valueOf(a) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

         data = new Printer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3));
        cursor.close();
    	}catch(Exception e)
    	{
    		cursor.close();
    	}
        // return contact
        return data;
    }

    public static ModelCart getCartData(long l) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(CART_TABLE, new String[] { KEY_CART_ID,
        		KEY_CART_TABLE,KEY_CART_TOTAL,KEY_CART_USER,KEY_CART_PAID,KEY_CART_TIME}, KEY_CART_ID + "=?",
                new String[] { String.valueOf(l) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ModelCart data = new ModelCart(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        cursor.close();
        // return contact
        return data;
    }

    public static CartItems getCartItemsData(long id) {
    	final SQLiteDatabase db = open();

        Cursor cursor = db.query(CARTITEMS_TABLE, new String[] { KEY_CARTITEMS_ID,
        		KEY_CARTITEMS_NAME,KEY_CARTITEMS_PRICE,KEY_CARTITEMS_QUANTITY,KEY_CARTITEMS_FLAG,KEY_CARTITEMS_NOTE,KEY_CARTITEMS_COURSE,KEY_CARTITEMS_MARK,KEY_CARTITEMS_STATUS,KEY_CARTITEMS_FID,KEY_CARTITEMS_ITEMID}, KEY_CART_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));
        cursor.close();
        // return contact
        return data;
    }

    public static CartItems getCartItemsDataCartitemId(long id) {
    	final SQLiteDatabase db = open();

    	 Cursor cursor = db.query(CARTITEMS_TABLE, new String[] { KEY_CARTITEMS_ID,
         		KEY_CARTITEMS_NAME,KEY_CARTITEMS_PRICE,KEY_CARTITEMS_QUANTITY,KEY_CARTITEMS_FLAG,KEY_CARTITEMS_NOTE,KEY_CARTITEMS_COURSE,KEY_CARTITEMS_MARK,KEY_CARTITEMS_STATUS,KEY_CARTITEMS_FID,KEY_CARTITEMS_ITEMID}, KEY_CART_ID + "=?",
                 new String[] { String.valueOf(id) }, null, null, null, null);
         if (cursor != null)
             cursor.moveToFirst();

         CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                 cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));
         cursor.close();
        // return contact
        return data;
    }

    // Getting All user data
    public static List<UserData> getAllUserData() {
        List<UserData> contactList = new ArrayList<UserData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + USER_TABLE+" ORDER BY "+KEY_ID+" desc";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	UserData data = new UserData();
            	data.setID(Integer.parseInt(cursor.getString(0)));
            	data.setName(cursor.getString(1));
            	data.setIMEI(cursor.getString(2));
            	data.setMessage(cursor.getString(3));
                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }
   
   /* public static CartItems getCartItemsDataByCartId1(int id) {
    	final SQLiteDatabase db = open();
 
        Cursor cursor = db.query(CARTITEMS_TABLE, new String[] { KEY_CARTITEMS_ID,
        		KEY_CARTITEMS_NAME,KEY_CARTITEMS_PRICE,KEY_CARTITEMS_QUANTITY,KEY_CARTITEMS_FLAG}, KEY_CARTITEMS_FID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),Integer.parseInt(cursor.getString(3)),cursor.getString(4));
        cursor.close();
        // return contact
        return data;
    }
    */
    
    public static ECharge getEChargeData(String a) {
    	Cursor cursor = null;
    	ECharge data=null;
    	try
    	{
    	final SQLiteDatabase db = open();

        cursor = db.query(ECHARGE_TABLE, new String[] { KEY_ECHARGE_ID,
        		KEY_ECHARGE_CATEGORY,KEY_ECHARGE_NAME,KEY_ECHARGE_QUANTITY,KEY_ECHARGE_PARAM}, KEY_ECHARGE_CATEGORY + "=?",
                new String[] { String.valueOf(a) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

         data = new ECharge(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
        cursor.close();
    	}catch(Exception e)
    	{
    		cursor.close();
    	}
        // return contact
        return data;
    }

    public static Cursor fetchGroup() {
        String query = "SELECT * FROM  "+ CATEGORY_TABLE +" ";
        final SQLiteDatabase db = open();
        return db.rawQuery(query, null);
    }

    public static List<Staff> getAllStaff() {
    	List<Staff> contactList = new ArrayList<Staff>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + STAFF_TABLE +" ORDER BY "+KEY_STAFF_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

            	Staff data = new Staff();
            	data.set_staff_id(Integer.parseInt(cursor.getString(0)));
            	data.set_staff_fname(cursor.getString(1));
            	data.set_staff_lname(cursor.getString(2));
            	data.set_staff_email(cursor.getString(3));
            	data.set_staff_password(cursor.getString(4));
            	data.set_staff_roll(cursor.getString(5));

                contactList.add(data);

            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
	}

    public static List<Category> getAllCategoryData() {
    	List<Category> contactList = new ArrayList<Category>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + CATEGORY_TABLE +" ORDER BY "+KEY_CAT_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Category data = new Category();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_sequence(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                contactList.add(data);

            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<Item> getAllItemData() {
    	ArrayList<Item> contactList = new ArrayList<Item>();
        // Select All Query
    	String flag="I";
        String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" WHERE item_flag='"+ flag +"' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        //String selectQuery = "SELECT  * FROM " + ITEM_TABLE + " ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Item data = new Item();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                data.set_flag(cursor.getString(5));
                data.set_extra(getExtrasbyItemId(Integer.parseInt(cursor.getString(0))));
                ArrayList<Item> _extra=DBAdapter.getItemsbyCatIdnFlagOff(data.get_category().get_id());
                for(Item x:_extra)
                {
                	data.addExtra(x);
                }
            	// Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }
    
    public static ArrayList<Item> getAllItemDatas() {
    	ArrayList<Item> contactList = new ArrayList<Item>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        //String selectQuery = "SELECT  * FROM " + ITEM_TABLE + " ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Item data = new Item();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                data.set_flag(cursor.getString(5));

            	// Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<Extra> getAllExtraData() {
    	ArrayList<Extra> contactList = new ArrayList<Extra>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + EXTRA_TABLE + " ORDER BY "+KEY_EXTRA_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Extra data = new Extra();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_item(getItemData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }/*
    public static ArrayList<CartItems> getAllCartItemsData() {
    	ArrayList<CartItems> contactList = new ArrayList<CartItems>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE + " ORDER BY "+KEY_CARTITEMS_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	CartItems data = new CartItems();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	Item i=DBAdapter.getItemData(cursor.getString(1));
            	data.set_item(i);
            	data.set_quantity(Integer.parseInt(cursor.getString(3)));

                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }*/

    public static ArrayList<Extra> getCartItemsExtraData(int Itemid) {
    	ArrayList<Extra> contactList = new ArrayList<Extra>();
        // Select All Query
    	String flag="E";
        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + Itemid + "' and cartitems_flag='"+ flag +"' ORDER BY "+KEY_CARTITEMS_FID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Extra data=new Extra();
            	data.set_id(Integer.parseInt(cursor.getString(10)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
                data.set_refId(Integer.parseInt(cursor.getString(0)));

                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<CartItems> getCartItemsExtraforDeleteData(long l) {
    	ArrayList<CartItems> contactList = new ArrayList<CartItems>();
        // Select All Query
    	try{
    	String flag="E";
        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + l + "' and cartitems_flag='"+ flag +"' ORDER BY "+KEY_CARTITEMS_FID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	  CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                          cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));
             	//data.get_item().set_extra(DBAdapter.getCartItemsExtraData(Integer.parseInt(cursor.getString(0))));
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
    	}catch(Exception e)
    	{
    		// cursor.close();
    	}
      //  //dhaval..    db.close();

        // return contact list
        return contactList;
    }

    public static ArrayList<CartItems> getCartItemsDataByCartId(long l) {
    	ArrayList<CartItems> contactList = new ArrayList<CartItems>();
        // Select All Query
    	String flag="I";
        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + l + "' and cartitems_flag='"+ flag +"' ORDER BY "+KEY_CARTITEMS_FID+" ";
 ModelCart mcart=new ModelCart();
        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	  CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                          cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));

            	data.get_item().set_extra(DBAdapter.getCartItemsExtraData(Integer.parseInt(cursor.getString(0))));
                contactList.add(data);
                mcart.setProduct(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
       // return contactList;
        return mcart.getAllSameStatusProducts();
    }

    public static ArrayList<CartItems> getAllCartItemsDataByCartId(long l) {
    	ArrayList<CartItems> contactList = new ArrayList<CartItems>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + l + "' ORDER BY "+KEY_CARTITEMS_FID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	  CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                          cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));

            	data.set_cartid(Integer.parseInt(cursor.getString(9)));
            	//data.get_item().set_extra(DBAdapter.getCartItemsExtraData(Integer.parseInt(cursor.getString(0))));
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<CartItems> getAllCartItemsDataByCartIdnFlag(int Cartid) {
    	ArrayList<CartItems> contactList = new ArrayList<CartItems>();
        // Select All Query
    	String flag="E";
        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + Cartid + "' and cartitems_flag='"+ flag +"' ORDER BY "+KEY_CARTITEMS_FID+" ";

        //String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + Cartid + "'  and cartitems_flag='E' ORDER BY "+KEY_CARTITEMS_FID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	  CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                          cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));

            	data.set_cartid(Integer.parseInt(cursor.getString(9)));
            	//data.get_item().set_extra(DBAdapter.getCartItemsExtraData(Integer.parseInt(cursor.getString(0))));
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<CartItems> getAllCartItemsData() {
    	ArrayList<CartItems> contactList = new ArrayList<CartItems>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE + " ORDER BY "+KEY_CARTITEMS_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	  CartItems data = new CartItems(Integer.parseInt(cursor.getString(0)),
                          cursor.getString(1),cursor.getString(2), Integer.parseInt(cursor.getString(3)),cursor.getString(4),cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),cursor.getString(8), Integer.parseInt(cursor.getString(10)));

            	//data.set_cart(DBAdapter.getCartData(Integer.parseInt(cursor.getString(5))));
            	data.set_cartid(Integer.parseInt(cursor.getString(9)));
            	//data.get_item().set_extra(DBAdapter.getCartItemsExtraData(Integer.parseInt(cursor.getString(0))));
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<ModelCart> getAllCartData() {
    	ArrayList<ModelCart> contactList = new ArrayList<ModelCart>();
    	try{
        // Select All Query
    		String paid="false";
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Calendar c = Calendar.getInstance();
    	c.setTimeInMillis(System.currentTimeMillis());
    	c.add(Calendar.HOUR_OF_DAY, -8);
    	//String query = "SELECT * from daily_mood WHERE mooddate >= " + "'" + dateFormat.format(c.getTime()) + "'";
       // String selectQuery = "SELECT  * FROM " + CART_TABLE + "  WHERE "+KEY_CART_TIME+" >= " + "'" + dateFormat.format(c.getTime()) + "' ORDER BY "+KEY_CART_TIME+" ";
       // String selectQuery = "SELECT  * FROM " + CART_TABLE + "  WHERE "+KEY_CART_PAID+" = '" + paid + "'  ORDER BY "+KEY_CART_TIME+" ";
    	  String selectQuery = "SELECT  * FROM " + CART_TABLE + "  WHERE "+KEY_CART_PAID+" = '" + paid + "'  ORDER BY "+KEY_CART_ID+" ";

        //String selectQuery = "SELECT  * FROM " + CART_TABLE + "  ORDER BY "+KEY_CART_ID+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	ModelCart data = new ModelCart();
            	data.setId(Integer.parseInt(cursor.getString(0)));
            	data.setTableName(cursor.getString(1));
            	data.setTotal(cursor.getString(2));
            	data.setProducts(DBAdapter.getCartItemsDataByCartId(Integer.parseInt(cursor.getString(0))));
            	//data.set_sequence(Integer.parseInt(cursor.getString(4)));
            	data.setUser(cursor.getString(3));
            	data.setPaid(cursor.getString(4));
            	data.setTime(cursor.getString(5).toString());
                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
    	}catch(Exception e)
    	{

    	}

        // return contact list
        return contactList;
    }
    
    public static void deleteItem(int l) {
    	try{
        	final SQLiteDatabase db = open();

         List<Extra> items=DBAdapter.getExtrasbyItemId(l);
     	for(Extra x : items){
     		DBAdapter.deleteExtra(x.get_id());
     	}
     	 db.delete(ITEM_TABLE, KEY_ITEM_ID + "=" + l, null);
     	 ////dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
    }
   
    public static void deleteExtra(int l) {
    	try{
        	final SQLiteDatabase db = open();
         db.delete(EXTRA_TABLE, KEY_EXTRA_ID + "=" + l, null);
         ////dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
  }

    public static void deletePrinter(int l) {
    	try{
        	final SQLiteDatabase db = open();
         db.delete(PRINTER_TABLE, KEY_PRINTER_ID + "=" + l, null);
         ////dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
  }

    public static void deleteCartitem(long l) {
    	try{
        	final SQLiteDatabase db = open();

         List<CartItems> items=DBAdapter.getCartItemsExtraforDeleteData(l);
     	for(CartItems x : items){
     		DBAdapter.deleteCartitemExtra(x.get_id());
     	}
     	 db.delete(CARTITEMS_TABLE, KEY_CARTITEMS_ID + "=" + l, null);
     	////dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
    }

    public static void deleteCartitemExtra(long l) {
    	try{
        	final SQLiteDatabase db = open();
         db.delete(CARTITEMS_TABLE, KEY_CARTITEMS_ID + "=" + l, null);
       //  //dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
  }
   
    public static void deleteAllRestro() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ RESTAURANT_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
  }

    public static void deleteAllCategory() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ CATEGORY_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllItem() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ ITEM_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllExtra() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ EXTRA_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllStaff() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ STAFF_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllcartItem() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ CARTITEMS_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllcart() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ CART_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllEcharge() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ ECHARGE_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteAllPrinter() {
    	try{
    		SQLiteDatabase db = open();
            db.execSQL("DELETE FROM "+ PRINTER_TABLE+" "); //delete all rows in a table
    //dhaval..    db.close();

    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

  }

    public static void deleteCart(long l) {
    	try{
        	final SQLiteDatabase db = open();
         db.delete(CART_TABLE, KEY_CART_ID + "=" + l, null);
        // //dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}

	}

    	/*public static void deleteCextra(int l) {
        	try{
            	final SQLiteDatabase db = open();
             db.delete(CEXTRA_TABLE, KEY_CEXTRA_ID + "=" + l, null);

        	}
            catch (Exception exception) {
       		if (DEBUG)
       			Log.i(LOG_TAG, "Delete not Complited");
       	}
      }*/
    public static void deleteStaff(int id) {
    	try{
        	final SQLiteDatabase db = open();

         db.delete(STAFF_TABLE, KEY_STAFF_ID + "=" + id, null);
        // //dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
      }
   
    public static int deleteServiceTax(String name) {
    	int eid=0;
    	try{
        	final SQLiteDatabase db = open();
        	final String id = "'Service'";

        	eid= db.delete(ECHARGE_TABLE, KEY_ECHARGE_CATEGORY + "=" + id, null);
        // //dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
		return eid;
      }

    public static void deleteCategory(int id) {
    	try{
        	final SQLiteDatabase db = open();
        	List<Item> items=DBAdapter.getItemsbyCatId(id);
        	for(Item x : items){
        		DBAdapter.deleteItem(x.get_id());
        	}

         db.delete(CATEGORY_TABLE, KEY_CAT_ID + "=" + id, null);
         //dhaval..    db.close();
    	}
        catch (Exception exception) {
   		if (DEBUG)
   			Log.i(LOG_TAG, "Delete not Complited");
   	}
      }

    public static void updateItemName(int l,String _name)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_ITEM_NAME, _name);

    	     db.update(ITEM_TABLE, values, KEY_ITEM_ID + "=" + l, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, " Item name not update");
	}

    }
    
    public static void updateCart(long l, String table, String total)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_CART_TABLE, table);
    	    values.put(KEY_CART_TOTAL, total);

    	     db.update(CART_TABLE, values, KEY_CART_ID + "=" + l, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, " Item name not update");
	}
    }

    public static void updateItemcategory(int id,int l)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_ITEM_CAT, l);

    	     db.update(ITEM_TABLE, values, KEY_ITEM_ID + "=" + id, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, " Item category not update");
	}
    }
    
    public static void updateExtraName(int id,String _name)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_EXTRA_NAME, _name);

    	     db.update(EXTRA_TABLE, values, KEY_EXTRA_ID + "=" + id, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Extra name not update");
	}

    }

    public static void updateCartTTT(long l, String dbfield, String fieldValue) {
    	try{
        	final SQLiteDatabase db = open();
        	 ContentValues values = new ContentValues();
        	    values.put(dbfield, fieldValue);

        	     db.update(CART_TABLE, values, KEY_CART_ID + "=" + l, null);
        	     //dhaval..    db.close();
        	}
         catch (Exception exception) {
    		if (DEBUG)
    			Log.i(LOG_TAG, "Cart table not update");
    	}

     }

    public static void updateCartItemStatus(long l, String fieldValue) {
    	try{
    		String status="3";
    		String status4="4";
    		String status5="5";
        	final SQLiteDatabase db = open();
        	 ContentValues values = new ContentValues();
        	    values.put(KEY_CARTITEMS_STATUS, fieldValue);

        	    if(fieldValue.equals("3")){
        	    // db.update(CARTITEMS_TABLE, values, KEY_CARTITEMS_FID + "=" + l, null);
        	    	String strSQL = "UPDATE " + CARTITEMS_TABLE+" SET " + KEY_CARTITEMS_STATUS+" = '" + fieldValue + "' WHERE cartitems_fid = "+ l+" AND cartitems_status != '"+status4+"' AND cartitems_status != '"+status5+"'";
        	    	// db.update(CARTITEMS_TABLE, values, KEY_CARTITEMS_FID + "=" + l +" AND "+ KEY_CARTITEMS_STATUS + "="+status , null);
        	    db.execSQL(strSQL);
        	    }else{
       // String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" WHERE item_category = '" + id + "' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        	    	String strSQL = "UPDATE " + CARTITEMS_TABLE+" SET " + KEY_CARTITEMS_STATUS+" = '" + fieldValue + "' WHERE cartitems_fid = "+ l+" AND cartitems_status= '"+status+"'";
        	    	// db.update(CARTITEMS_TABLE, values, KEY_CARTITEMS_FID + "=" + l +" AND "+ KEY_CARTITEMS_STATUS + "="+status , null);
        	    db.execSQL(strSQL);
        	    }

        	     //dhaval..    db.close();
        	  /*  String strSQL = "UPDATE myTable SET Column1 = someValue WHERE columnId = "+ someValue;

        	    myDataBase.execSQL(strSQL);*/
        	}
         catch (Exception exception) {
    		if (DEBUG)
    			Log.i(LOG_TAG, "Cartitem table not update");
    	}

     }

    public static void updateCartItemNPF(long l, String dbfield, String fieldValue) {
    	try{
        	final SQLiteDatabase db = open();
        	 ContentValues values = new ContentValues();
        	    values.put(dbfield, fieldValue);

        	     db.update(CARTITEMS_TABLE, values, KEY_CARTITEMS_ID + "=" + l, null);
        	     //dhaval..    db.close();
        	}
         catch (Exception exception) {
    		if (DEBUG)
    			Log.i(LOG_TAG, "Cartitem table not update");
    	}

     }

    public static void updateCartItemQFID(long l, String dbfield, long m) {
    	try{
        	final SQLiteDatabase db = open();
        	 ContentValues values = new ContentValues();
        	    values.put(dbfield, m);

        	     db.update(CARTITEMS_TABLE, values, KEY_CARTITEMS_ID + "=" + l, null);
        	     //dhaval..    db.close();
        	}
         catch (Exception exception) {
    		if (DEBUG)
    			Log.i(LOG_TAG, "Cartitem table not update");
    	}

     }

    public static void updateStaffNEPR(int id, String dbfield, String fieldValue) {
    	try{
        	final SQLiteDatabase db = open();
        	 ContentValues values = new ContentValues();
        	    values.put(dbfield, fieldValue);

        	     db.update(STAFF_TABLE, values, KEY_STAFF_ID + "=" + id, null);
        	     //dhaval..    db.close();
        	}
         catch (Exception exception) {
    		if (DEBUG)
    			Log.i(LOG_TAG, "Staff table not update");
    	}

     }

    public static void updateCartItemQuantity(int l,int q)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_CARTITEMS_QUANTITY, q);

    	     db.update(CARTITEMS_TABLE, values, KEY_CARTITEMS_ID + "=" + l, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, " Cart Item Quantity not update");
	}
    }
   
  /*  public static void updateCextraName(int id,String _name)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_CEXTRA_NAME, _name);

    	     db.update(CEXTRA_TABLE, values, KEY_CEXTRA_ID + "=" + id, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Cextra name not update");
	}

    }*/
    public static void updateCatName(int id,String _name)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_CAT_NAME, _name);

    	     db.update(CATEGORY_TABLE, values, KEY_CAT_ID + "=" + id, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Category name not update");
	}

    }

    public static int updateECharge(String cat, String name, String qty, String param)
    {
    	int id=0;
    	try{
    		//final String cat = "'Service'";
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_ECHARGE_NAME, name);
    	    values.put(KEY_ECHARGE_QUANTITY, qty);
    	    values.put(KEY_ECHARGE_PARAM, param);

    	  id=   db.update(ECHARGE_TABLE, values, KEY_ECHARGE_CATEGORY + "=" + cat, null);
    	     //dhaval..    db.close();

    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, " Item name not update");
	}
    	return id;
    }

    public static int updateEChargebyId(int eid, String name, String qty, String param)
    {
    	int id=0;
    	try{
    		//final String cat = "'Service'";
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_ECHARGE_NAME, name);
    	    values.put(KEY_ECHARGE_QUANTITY, qty);
    	    values.put(KEY_ECHARGE_PARAM, param);

    	  id=   db.update(ECHARGE_TABLE, values, KEY_ECHARGE_ID + "=" + eid, null);
    	     //dhaval..    db.close();

    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, " Item name not update");
	}
    	return id;
    }

    public static void addCatSeq(int id,int sid)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_CAT_SEQUENCE, sid);

    	     db.update(CATEGORY_TABLE, values, KEY_CAT_ID + "=" + id, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "category Seq not update");
	}
    }

    	 public static void addItemSeq(int id,int sid)
    	    {
    	    	try{
    	    	final SQLiteDatabase db = open();
    	    	 ContentValues values = new ContentValues();
    	    	    values.put(KEY_ITEM_SEQUENCE, sid);

    	    	     db.update(ITEM_TABLE, values, KEY_ITEM_ID + "=" + id, null);
    	    	     //dhaval..    db.close();
    	    	}
    	     catch (Exception exception) {
    			if (DEBUG)
    				Log.i(LOG_TAG, "Item Seq not update");
    		}

    }

    	 public static void addExtraSeq(int id,int sid)
 	    {
 	    	try{
 	    	final SQLiteDatabase db = open();
 	    	 ContentValues values = new ContentValues();
 	    	    values.put(KEY_EXTRA_SEQUENCE, sid);

 	    	     db.update(EXTRA_TABLE, values, KEY_EXTRA_ID + "=" + id, null);
 	    	     //dhaval..    db.close();
 	    	}
 	     catch (Exception exception) {
 			if (DEBUG)
 				Log.i(LOG_TAG, "Extra Seq not update");
 		}

 }

    	/* public static void addCextraSeq(int id,int sid)
  	    {
  	    	try{
  	    	final SQLiteDatabase db = open();
  	    	 ContentValues values = new ContentValues();
  	    	    values.put(KEY_CEXTRA_SEQUENCE, sid);

  	    	     db.update(CEXTRA_TABLE, values, KEY_CEXTRA_ID + "=" + id, null);
  	    	     //dhaval..    db.close();
  	    	}
  	     catch (Exception exception) {
  			if (DEBUG)
  				Log.i(LOG_TAG, "Cextra Seq not update");
  		}

  }*/
    public static void updateItemPrice(int id,String _price)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_ITEM_PRICE, _price);

    	     db.update(ITEM_TABLE, values, "item_id='" + id + "'", null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Price not update");
	}
    }

    public static void updateExtraPrice(int id,String _price)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_EXTRA_PRICE, _price);

    	     db.update(EXTRA_TABLE, values, "extra_id='" + id + "'", null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Extra Price not update");
	}
    }

    public static void updateRestro(long l, String dbfield, String fieldValue) {
    	try{
        	final SQLiteDatabase db = open();
        	 ContentValues values = new ContentValues();
        	    values.put(dbfield, fieldValue);

        	     db.update(RESTAURANT_TABLE, values, KEY_RESTRO_ID + "=" + l, null);
        	     //dhaval..    db.close();
        	}
         catch (Exception exception) {
    		if (DEBUG)
    			Log.i(LOG_TAG, "Cart table not update");
    	}

     }

    public static int updatePrinter(int id, String _name, String _mac, String _ptintorder)
    {
    	int pid=0;
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_PRINTER_MAC, _mac);
    	    values.put(KEY_PRINTER_NAME, _name);
    	    values.put(KEY_PRINTER_PRINTORDER, _ptintorder);
    	    pid= db.update(PRINTER_TABLE, values, KEY_PRINTER_ID + "=" + id, null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Category name not update");
	}
		return pid;

    }

  /*  public static void updateCextraPrice(int id,String _price)
    {
    	try{
    	final SQLiteDatabase db = open();
    	 ContentValues values = new ContentValues();
    	    values.put(KEY_CEXTRA_PRICE, _price);

    	     db.update(CEXTRA_TABLE, values, "cextra_id='" + id + "'", null);
    	     //dhaval..    db.close();
    	}
     catch (Exception exception) {
		if (DEBUG)
			Log.i(LOG_TAG, "Cextra Price not update");
	}
    }*/
    // Getting users Count
    public static int getUserDataCount() {
        String countQuery = "SELECT  * FROM " + USER_TABLE;
        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    //sample
   /* public Cursor fetchGroup() {
        String query = "SELECT * FROM rooms"
        return mDb.rawQuery(query, null);
    }

    public Cursor fetchChildren(String room) {
        String query = "SELECT * FROM devices WHERE id_room = '" + room + "'";
        return mDb.rawQuery(query, null);
    }*/
    public static ArrayList<Item> getItemsbyCatId(int id) {
    	ArrayList<Item> contactList = new ArrayList<Item>();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" WHERE item_category = '" + id + "' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Item data = new Item();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                data.set_flag(cursor.getString(5));
            	// Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<Item> getItemsbyCatIdnFlag(int id) {
    	ArrayList<Item> contactList = new ArrayList<Item>();
        // Select All Query
    	String flag="I";
        String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" WHERE item_category = '" + id + "' and item_flag='"+ flag +"' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Item data = new Item();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                // Adding contact to list
            	  data.set_flag(cursor.getString(5));
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<Item> getItemsbyCatIdnFlagOff(int id) {
    	ArrayList<Item> contactList = new ArrayList<Item>();
        // Select All Query
    	String flag="E";
        String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" WHERE item_category = '" + id + "' and item_flag='"+ flag +"' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Item data = new Item();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                // Adding contact to list
            	  data.set_flag(cursor.getString(5));
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<Item> getComboItems(int id) {
    	ArrayList<Item> contactList = new ArrayList<Item>();
        // Select All Query
    	String flag="I";
        String selectQuery = "SELECT  * FROM " + ITEM_TABLE+" WHERE item_category = '" + id + "' and item_flag='"+ flag +"' ORDER BY "+KEY_ITEM_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Item data = new Item();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                data.set_flag(cursor.getString(5));
                data.set_extra(getExtrasbyItemId(Integer.parseInt(cursor.getString(0))));
                ArrayList<Item> _extra=DBAdapter.getItemsbyCatIdnFlagOff(data.get_category().get_id());
                for(Item x:_extra)
                {
                	data.addExtra(x);
                }
            	// Adding contact to list
                contactList.add(data);



            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }

    public static ArrayList<Extra> getExtrasbyItemId(int id) {
    	ArrayList<Extra> contactList = new ArrayList<Extra>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + EXTRA_TABLE+" WHERE extra_item = '" + id + "' ORDER BY "+KEY_EXTRA_SEQUENCE+" ";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Extra data = new Extra();
            	data.set_id(Integer.parseInt(cursor.getString(0)));
            	data.set_name(cursor.getString(1));
            	data.set_price(cursor.getString(2));
            	data.set_item(getItemData(Integer.parseInt(cursor.getString(3))));
            	data.set_sequence(Integer.parseInt(cursor.getString(4)));
                // Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return contactList;
    }
   
    // Getting installed device have self data or not
    public static int validateDevice() {
       // String countQuery = "SELECT  * FROM " + DEVICE_TABLE;
    	 String countQuery = "SELECT  * FROM " + RESTAURANT_TABLE;

    	final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // Getting distinct user data use in spinner
    public static List<UserData> getDistinctUser() {
    	List<UserData> contactList = new ArrayList<UserData>();
        // Select All Query
        String selectQuery = "SELECT  distinct(user_imei),user_name FROM " + USER_TABLE+" ORDER BY "+KEY_ID+" desc";

        final SQLiteDatabase db = open();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	UserData data = new UserData();

            	data.setIMEI(cursor.getString(0));
            	data.setName(cursor.getString(1));
            	// Adding contact to list
                contactList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return contactList;
    }
    
    // Getting imei already in user table or not
    public static int validateNewMessageUserData(String IMEI) {
    	 int count = 0;
    	try {
	        String countQuery = "SELECT "+KEY_ID+" FROM " + USER_TABLE + " WHERE user_imei='"+IMEI+"'";
	        final SQLiteDatabase db = open();
	        Cursor cursor = db.rawQuery(countQuery, null);

	        count = cursor.getCount();
	        cursor.close();
    	} catch (Throwable t) {
    		count = 10;
			Log.i("Database", "Exception caught: " + t.getMessage(), t);
		}
        return count;
    }
    
    public static Item[] read(String searchTerm) {
 //   ArrayList<Item> contactList = new ArrayList<Item>();
    // Select All Query

    String selectQuery = "";
    selectQuery += "SELECT * FROM " + ITEM_TABLE;
    selectQuery += " WHERE " + KEY_ITEM_NAME + " LIKE '%" + searchTerm + "%'";
    selectQuery += " ORDER BY " + KEY_ITEM_SEQUENCE + " DESC";
    selectQuery += " LIMIT 0,5";
    final SQLiteDatabase db = open();
    Cursor cursor = db.rawQuery(selectQuery, null);
    int recCount = cursor.getCount();
    Item[] ObjectItemData = new Item[recCount];
    int x = 0;
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
        	Item data = new Item();
        	data.set_id(Integer.parseInt(cursor.getString(0)));
        	data.set_name(cursor.getString(1));
        	data.set_price(cursor.getString(2));
        	data.set_category(getCategoryData(Integer.parseInt(cursor.getString(3))));
        	data.set_sequence(Integer.parseInt(cursor.getString(4)));
            data.set_flag(cursor.getString(5));
        	// Adding contact to list
            ObjectItemData[x] = data;

            x++;
        } while (cursor.moveToNext());
    }
    cursor.close();
    // return contact list
    return ObjectItemData;
    }

    public static MyObject[] read1(String searchTerm) {

        // select query
        String sql = "";
        sql += "SELECT * FROM " + ITEM_TABLE;
        sql += " WHERE " + KEY_ITEM_NAME + " LIKE '%" + searchTerm + "%'";
        sql += " ORDER BY " + KEY_ITEM_SEQUENCE + " DESC";
        sql += " LIMIT 0,5";

        SQLiteDatabase db = open();

        // execute the query
        Cursor cursor = db.rawQuery(sql, null);

        int recCount = cursor.getCount();

        MyObject[] ObjectItemData = new MyObject[recCount];
        int x = 0;

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                String objectName = cursor.getString(cursor.getColumnIndex(KEY_ITEM_NAME));
               // Log.e(TAG, "objectName: " + objectName);

                MyObject myObject = new MyObject(objectName);

                ObjectItemData[x] = myObject;

                x++;

            } while (cursor.moveToNext());
        }

        cursor.close();
        //dhaval..    db.close();

        return ObjectItemData;

    }

    public static boolean CheckIsDataAlreadyInDBorNot(String TableName,
													  String dbfield, long l) {
       // SQLiteDatabase sqldb = EGLifeStyleApplication.sqLiteDatabase;
        SQLiteDatabase db = open();
        String Query = "Select * from " + TableName + " where " + dbfield + " = " + l;
        Cursor cursor = db.rawQuery(Query, null);
            if(cursor.getCount() <= 0){
                cursor.close();
                return false;
            }
        cursor.close();
        return true;
    }

    public static boolean CheckIsCatAlreadyInDBorNot(String TableName,
													 String dbfield, String l) {
       // SQLiteDatabase sqldb = EGLifeStyleApplication.sqLiteDatabase;
		try {
			SQLiteDatabase db = open();
			//'" + r + "'"
			String Query = "Select * from " + TableName + " where " + dbfield + " = '" + l + "'";
			Cursor cursor = db.rawQuery(Query, null);
			if (cursor.getCount() <= 0) {
				cursor.close();
				return false;
			}
			cursor.close();
			return true;
		}catch (Exception e){
			return true;
		}
    }
   
    public static boolean CheckIsCatExtraAlreadyInDBorNot(String name,
            int cid) {
       // SQLiteDatabase sqldb = EGLifeStyleApplication.sqLiteDatabase;
        SQLiteDatabase db = open();
        //'" + r + "'"
       // String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + Itemid + "' and cartitems_flag='"+ flag +"' ORDER BY "+KEY_CARTITEMS_FID+" ";
        String flag="E";
        String Query = "Select * from " + ITEM_TABLE + " where item_name = '" + name + "' and item_category='"+ cid +"' and item_flag='"+ flag +"'";
        Cursor cursor = db.rawQuery(Query, null);
            if(cursor.getCount() <= 0){
                cursor.close();
                return false;
            }
        cursor.close();
        return true;
    }

    public static boolean CheckIsExtraAlreadyInDBorNot(String name,
            int Itemid) {
       // SQLiteDatabase sqldb = EGLifeStyleApplication.sqLiteDatabase;
        SQLiteDatabase db = open();
        //'" + r + "'"
       // String selectQuery = "SELECT  * FROM " + CARTITEMS_TABLE+" WHERE cartitems_fid = '" + Itemid + "' and cartitems_flag='"+ flag +"' ORDER BY "+KEY_CARTITEMS_FID+" ";

        String Query = "Select * from " + EXTRA_TABLE + " where extra_name = '" + name + "' and extra_item='"+ Itemid +"'";
        Cursor cursor = db.rawQuery(Query, null);
            if(cursor.getCount() <= 0){
                cursor.close();
                return false;
            }
        cursor.close();
        return true;
    }

	/*********************** Escape string for single quotes (Insert,Update)************/
	private static String sqlEscapeString(String aString) {
		String aReturn = "";

		if (null != aString) {
			//aReturn = aString.replace("'", "''");
			aReturn = DatabaseUtils.sqlEscapeString(aString);
			// Remove the enclosing single quotes ...
			aReturn = aReturn.substring(1, aReturn.length() - 1);
		}

		return aReturn;
	}

	/*********************** UnEscape string for single quotes (show data)************/
	@SuppressWarnings("unused")
	private static String sqlUnEscapeString(String aString) {

		String aReturn = "";

		if (null != aString) {
			aReturn = aString.replace("''", "'");
		}

		return aReturn;
	}

  /********************** Main Database creation INNER class ********************/
	private static class DataBaseHelper extends SQLiteOpenHelper {
		public DataBaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			if (DEBUG)
				Log.i(LOG_TAG, "new create");
			try {
				//db.execSQL(USER_MAIN_CREATE);
				db.execSQL(USER_CREATE);
				db.execSQL(DEVICE_CREATE);
				db.execSQL(RESTAURANT_CREATE);
				db.execSQL(STAFF_CREATE);
				db.execSQL(CATEGORY_CREATE);
				db.execSQL(ITEM_CREATE);
				db.execSQL(EXTRA_CREATE);
				db.execSQL(CART_CREATE);
				db.execSQL(CARTITEMS_CREATE);
				db.execSQL(ECHARGE_CREATE);
				db.execSQL(PRINTER_CREATE);
			//	db.execSQL(CEXTRA_CREATE);

			} catch (Exception exception) {
				if (DEBUG)
					Log.i(LOG_TAG, "Exception onCreate() exception");
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			if (DEBUG)
				Log.w(LOG_TAG, "Upgrading database from version" + oldVersion
						+ "to" + newVersion + "...");

			for (String table : ALL_TABLES) {
				db.execSQL("DROP TABLE IF EXISTS " + table);
			}
			onCreate(db);
		}

	} // Inner class closed
	
	
	
	
	
	
	/********************************************************************/
}
