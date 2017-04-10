package com.example.astics.qrscannetinbuilt;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zj.btsdk.BluetoothService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

public class newOrderActivity extends AppCompatActivity implements
		ActionBar.TabListener,Item_selected.ValueChangeListener {
public static String msg="Error";
//public FragmentCommunicator2 fragmentCommunicator2;
	//private ActionBar actionBar;
	public static ModelCart mycart;
	public static ArrayList<CartItems> cartItems;
	public static ArrayList<CartItems> EditCartItems;
	public static String tableName="";
	public static int id=0;
	//Staff staff;
	public static boolean changed=false;
	//private static final int REQUEST_CONNECT_DEVICE = 1;
	//public static ArrayList<CartItems> ModelcartItems;
	 public static LinkedHashMap<String, CartItems> myCartHash = new LinkedHashMap<String, CartItems>();
	 public static LinkedHashMap<String, CartItems> myCartItemsWithExtras = new LinkedHashMap<String, CartItems>();
	 public static LinkedHashMap<String, String> markHash = new LinkedHashMap<String, String>();
	 public static LinkedHashMap<String, CartItems> mynewCartHash =null;
	 public static LinkedHashMap<String, CartItems> mynewCartItemsWithExtras =null;
	// public static LinkedHashMap<Item, LinkedHashMap<String, Extra>> itemExtra = new LinkedHashMap<Item, LinkedHashMap<String, Extra>>();
	 public static LinkedHashMap<String,Extra> itemExtra = new LinkedHashMap< String,Extra>();
			 	private final Handler handler = new Handler() {

                    public void handleMessage(Message msg) {

                        String aResponse = msg.getData().getString("message");

                        if ((null != aResponse)) {

                            // ALERT MESSAGE
                            Toast.makeText(
                                    getBaseContext(),
                                    aResponse,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                                // ALERT MESSAGE
                                Toast.makeText(
                                        getBaseContext(),
                                        "Not Got Response From Server.",
                                        Toast.LENGTH_SHORT).show();
                        }

                    }
                };
public FragmentCommunicator fragmentCommunicator;
	//private static final int REQUEST_ENABLE_BT = 2;
	//static BluetoothService mService = null;
	//static BluetoothDevice con_dev = null;
	public String mac;
	Controller aController;
	Handler tHandler = new Handler();
	 StringBuilder buf=new StringBuilder();
	 StringBuilder buf2=new StringBuilder();
	 StringBuilder buf3=new StringBuilder();
	// public static LinkedHashMap<String,Extra> myCartItemsitemExtra = new LinkedHashMap< String,Extra>();
	 //public static LinkedHashMap<String,Extra> newitemExtra ;
boolean connected=false;
		/* @Override
		 protected void onDestroy() {

		// super.onDestroy();
		/* if (mService != null)
		 	mService.stop();
		 mService = null;
		 con_dev=null;*/
		 //}
		 private final Handler mHandler = new Handler() {
		     @Override
		     public void handleMessage(Message msg) {
		         switch (msg.what) {
		         case BluetoothService.MESSAGE_STATE_CHANGE:
		             switch (msg.arg1) {
		             case BluetoothService.STATE_CONNECTED:
		            	 connected=true;

		             	/*Toast.makeText(getApplicationContext(), "Connect successful",
		                         Toast.LENGTH_SHORT).show();*/

		     			//btnClose.setEnabled(true);
		     			//btnSend.setEnabled(true);
		     			//btnSendDraw.setEnabled(true);
		                 break;
		             case BluetoothService.STATE_CONNECTING:
		             	Log.d("��������","��������.....");
		                 break;
		             case BluetoothService.STATE_LISTEN:
		             case BluetoothService.STATE_NONE:
		             	Log.d("��������","�ȴ�����.....");
		                 break;
		             }
		             break;
		         case BluetoothService.MESSAGE_CONNECTION_LOST:
		          /*   Toast.makeText(getApplicationContext(), "Device connection was lost",
		                            Toast.LENGTH_SHORT).show();*/
		 		//	btnClose.setEnabled(false);
		 		//	btnSend.setEnabled(false);
		 		//	btnSendDraw.setEnabled(false);
		             break;
		         case BluetoothService.MESSAGE_UNABLE_CONNECT:
		         Toast.makeText(getApplicationContext(), "Unable to connect printer",
		                     Toast.LENGTH_SHORT).show();
		         	break;
		         }
		     }

		 };
//final Handler mHandler1 = new Handler();
	 // Tab titlesz
	//private String[] tabs = { "ORDERS", "MENU", "STAFF" };
String rid="";
	// public static LinkedHashMap<String, CartItems> mynewCartHashExtras =null;
	String table="";
	private Toolbar toolbar;
	private TabLayout tabLayout;
	private ViewPager viewPager;
	private TabsOrderAdapter mAdapter;
			private int id2=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.neworder_viewpager);
		rid = getIntent().getStringExtra("rid");
		table = getIntent().getStringExtra("table");
		tableName=table;
		aController = (Controller) getApplicationContext();

	         Bundle extras = getIntent().getExtras();
	         if (extras != null) {
				 try {
					 String value = extras.getString("ID");
					 // Toast.makeText(getApplicationContext(),"Neworder "+value,Toast.LENGTH_LONG).show();
					 id = Integer.parseInt(value);
				 }catch (Exception e){
					 id=0;
				 }
	         }

		if(!tableName.equals("")){
			id2=2;
		}
		if(id>0)
		{
			try{
				mynewCartHash= new LinkedHashMap<String, CartItems>();
				mynewCartItemsWithExtras=new LinkedHashMap<String, CartItems>();
				//mynewCartHashExtras= new LinkedHashMap<String, CartItems>();
				//newitemExtra= new LinkedHashMap< String,Extra>();
			mycart=DBAdapter.getCartData(id);
			//Toast.makeText(getApplicationContext(),mycart.getTableName(),Toast.LENGTH_LONG).show();
			tableName=mycart.getTableName();
			//cartItems=DBAdapter.getCartItemsDataByCartId(id);
			cartItems=DBAdapter.getCartItemsDataByCartId(mycart.getId());
			//EditCartItems=DBAdapter.getCartItemsDataByCartId(mycart.getId());
			for(CartItems x:cartItems)
			{
				//Toast.makeText(getApplicationContext(), x.get_item().get_name(),Toast.LENGTH_LONG).show();
				int mark=x.get_mark();
				for(Extra y:x.get_item().get_extra())
				{
					y.set_item(x.get_item());
				//	Toast.makeText(getApplicationContext(), y.get_item().get_name()+y.get_name(),Toast.LENGTH_LONG).show();
					//if(mark==0){
						newOrderActivity.itemExtra.put(y.get_item().get_name()+x.get_status()+ String.valueOf(mark)+y.get_name(), y);
					//}else{
					//newOrderActivity.itemExtra.put(y.get_item().get_name()+String.valueOf(mark)+y.get_name(), y);
					//}//newOrderActivity.newitemExtra.put(y.get_item().get_name()+String.valueOf(mark)+y.get_name(), y);
				}
				try{
				//	Toast.makeText(getApplicationContext(),String.valueOf(x.get_item().get_id()+" "+x.get_item().get_name()),Toast.LENGTH_LONG).show();

				Item i1=DBAdapter.getItemData(x.get_item().get_id());
				//Toast.makeText(getApplicationContext(),i1.get_name(),Toast.LENGTH_LONG).show();


				 ArrayList<Extra> _extra=null;
		       	 _extra=DBAdapter.getExtrasbyItemId(i1.get_id());
		   		 ArrayList<Item> _extra_items=DBAdapter.getItemsbyCatIdnFlagOff(i1.get_category().get_id());

		   		 for(Item i2:_extra_items)
		   			i1.addExtra(i2);
		       	 for(Extra e1:_extra)
		       		i1.addExtra(e1);
		       	 for(Extra y:_extra)
		       		 y.set_item(i1);

		       	 x.set_item(i1);
		       	 if(x.get_mark()==0){
		     //  	Toast.makeText(getApplicationContext(),String.valueOf( x.get_course()),Toast.LENGTH_LONG).show();
		      // 	newOrderActivity.myCartHash.put(i1.get_name(),x);
		       //	newOrderActivity.mynewCartHash.put(i1.get_name(),x);
		       		newOrderActivity.myCartHash.put(i1.get_name()+x.get_status(),x);
			       	newOrderActivity.mynewCartHash.put(i1.get_name()+x.get_status(),x);
		       	 }else{
		       		newOrderActivity.myCartItemsWithExtras.put(i1.get_name()+ String.valueOf(x.get_mark()),x);
			       	newOrderActivity.mynewCartItemsWithExtras.put(i1.get_name()+ String.valueOf(x.get_mark()),x);
			       	if(	newOrderActivity.markHash.containsKey(i1.get_name())){
			       		int max=0;
			       		String mark1=newOrderActivity.markHash.get(i1.get_name());
			       		if(Integer.parseInt(mark1.toString())>x.get_mark()){
			       			max= Integer.parseInt(mark1);
			       		}else{
			       			max=x.get_mark();
			       		}
			       		newOrderActivity.markHash.put(i1.get_name(), String.valueOf(max));
			       	}else{
			       		newOrderActivity.markHash.put(i1.get_name(), String.valueOf(x.get_mark()));
			       	}

		       	 }

				}catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

				}
			}



			 }
			 catch(Exception e)
			 {
				 Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
			 }


		}
		else
		{
			mycart=new ModelCart();

			cartItems =new ArrayList<CartItems>();
		}

		viewPager = (ViewPager) findViewById(R.id.pager);

	//	toolbar = (Toolbar) findViewById(R.id.toolbar);
	//	setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);


		setupViewPager(viewPager);

		tabLayout = (TabLayout) findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);

		if( id<=0){
			viewPager.setCurrentItem(1);

		}else{
			//if(Controller.ExpListItems.size()>=1) {
				viewPager.setCurrentItem(0);
			//}
		}

		/*actionBar = getActionBar();
		mAdapter = new TabsOrderAdapter(getSupportFragmentManager());
		//viewPager.setOffscreenPageLimit(100);
		viewPager.setAdapter(mAdapter);
		actionBar.setDisplayHomeAsUpEnabled(true);



		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3F92D2")));
		//actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
		getActionBar().setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#DCE1E3")));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	//	actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM |ActionBar.DISPLAY_SHOW_TITLE);
		getActionBar().setTitle("Cancel");

		actionBar.addTab(actionBar.newTab().setText("Item Selected")
				.setTabListener(this));

		for(Category cat:Controller.ExpListItems)
		{
			actionBar.addTab(actionBar.newTab().setText(cat.get_name().toUpperCase())
					.setTabListener(this));
		}
		if(Controller.ExpListItems.size()==1 && id<=0){
			actionBar.setSelectedNavigationItem(1);
		}*/

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
			//	actionBar.setSelectedNavigationItem(position);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		View focus = getCurrentFocus();
        if (focus != null) {
            hiddenKeyboard(focus);
        }
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view

		viewPager.setCurrentItem(tab.getPosition());
		View focus = getCurrentFocus();
        if (focus != null) {
            hiddenKeyboard(focus);
        }


	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		View focus = getCurrentFocus();
        if (focus != null) {
            hiddenKeyboard(focus);
        }
	}

	private void hiddenKeyboard(View v) {
        InputMethodManager keyboard = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        keyboard.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	   // myCartHash.clear();
	    return super.onCreateOptionsMenu(menu);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

	    if (keyCode == KeyEvent.KEYCODE_BACK && changed) {

	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setTitle("Save changes?");
	        builder.setMessage("Do you want to save this Order ??");
	        builder.setPositiveButton("Yes",
	                new DialogInterface.OnClickListener() {

	                    @Override
	                    public void onClick(DialogInterface dialog, int which) {
	                        // TODO Auto-generated method stub
	                    	if (!aController.isConnectingToInternet()) {

	                			// Internet Connection is not present
	                			aController.showAlertDialog(newOrderActivity.this,
	                					"Internet Connection Error",
	                					"Please connect to Internet connection", false);
	                			// stop executing code by return
	                			//return;
	                		}
	                    	else{
	                    		if(aController.isConnectingToInternet())
	                    			if(changed)
	                    	createOrder();             // do your stuff
	                    	}
	                        }
	                });

	        builder.setNegativeButton("No",
	                new DialogInterface.OnClickListener() {

	                    @Override
	                    public void onClick(DialogInterface dialog, int which) {
	                        // TODO Auto-generated method stub
	                        dialog.dismiss();
	                        try{
	                        /*	 if (mService != null)
	         					 	mService.stop();
	         					 mService = null;
	         					 con_dev=null;*/
	                        	newOrderActivity.myCartHash.clear();
	                        	newOrderActivity.itemExtra.clear();

	                            	if(newOrderActivity.mynewCartHash!=null)
	                            		newOrderActivity.mynewCartHash.clear();

	                            	newOrderActivity.tableName="";
	                            	newOrderActivity.id=0;
	                            //	newOrderActivity.id2=1;
	                            	newOrderActivity.mycart=null;
	                            	changed=false;
	                            	newOrderActivity.markHash.clear();
	                            	newOrderActivity.myCartItemsWithExtras.clear();
	                            	if(newOrderActivity.mynewCartItemsWithExtras!=null)
	                                	newOrderActivity.mynewCartItemsWithExtras.clear();
	                            	Intent intent11 = new Intent(getApplicationContext(), com.example.astics.qrscannetinbuilt.activity.MainActivity.class);
	                            	intent11.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	                            	Bundle mBundle1 = new Bundle();
		                    		mBundle1.putString("ID", String.valueOf(id2));
		                    		intent11.putExtras(mBundle1);
	                            	startActivity(intent11);


	                            	finish();
	                    		 }
	                    		 catch(Exception e)
	                    		 {}


	                        finish();
	                    }
	                });

	        AlertDialog alert = builder.create();
	       // if(myCartHash.size()>0){
	        alert.show();

	        return true;

	    }else{
	    	if(keyCode == KeyEvent.KEYCODE_BACK)
	    	{
	    	try{
        		/* if (mService != null)
					 	mService.stop();
					 mService = null;
					 con_dev=null;*/
        	myCartHash.clear();
        	itemExtra.clear();


        	if(mynewCartHash!=null)
        mynewCartHash.clear();

        	newOrderActivity.id=0;
        	//newOrderActivity.id2=1;
        tableName="";
       mycart=null;
       changed=false;

   	newOrderActivity.markHash.clear();
   	newOrderActivity.myCartItemsWithExtras.clear();
   	if(newOrderActivity.mynewCartItemsWithExtras!=null)
    	newOrderActivity.mynewCartItemsWithExtras.clear();
       	Intent intent1 = new Intent(this, com.example.astics.qrscannetinbuilt.activity.MainActivity.class);
   	intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
   	Bundle mBundle = new Bundle();
		mBundle.putString("ID", String.valueOf(id2));
		intent1.putExtras(mBundle);
   	startActivity(intent1);
   		        	finish();
        	}
        	catch (Exception e) {
				// TODO: handle exception
			}
	    }
            //Toast.makeText(getSherlockActivity(), "Tapped home", Toast.LENGTH_SHORT).show();
           // onHomeSelectedListener.onHomeSelected();
        	/*Intent intent = new Intent(this, MainActivity.class);
        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(intent);*/


	      return super.onKeyDown(keyCode, event);
	    }
	    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	    // some variable statements...

	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	try{
	        		/* if (mService != null)
						 	mService.stop();
						 mService = null;
						 con_dev=null;*/
	        	myCartHash.clear();
	        	itemExtra.clear();


	        	if(mynewCartHash!=null)
	        mynewCartHash.clear();

	        	newOrderActivity.id=0;
            	//newOrderActivity.id2=1;
	        tableName="";
	       mycart=null;
	       changed=false;
	        	}
	        	catch (Exception e) {
					// TODO: handle exception
				}
	            //Toast.makeText(getSherlockActivity(), "Tapped home", Toast.LENGTH_SHORT).show();
	           // onHomeSelectedListener.onHomeSelected();
	        	/*Intent intent = new Intent(this, MainActivity.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(intent);*/

            	newOrderActivity.markHash.clear();
            	newOrderActivity.myCartItemsWithExtras.clear();
            	if(newOrderActivity.mynewCartItemsWithExtras!=null)
                	newOrderActivity.mynewCartItemsWithExtras.clear();
	        	Intent intent1 = new Intent(this, com.example.astics.qrscannetinbuilt.activity.MainActivity.class);
	        	intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	Bundle mBundle = new Bundle();
	    		mBundle.putString("ID", String.valueOf(id2));
	    		intent1.putExtras(mBundle);
	        	startActivity(intent1);
	        		        	finish();
	            return true;


	case R.id.Done:
		// Check if Internet present
				if (!aController.isConnectingToInternet()) {

					// Internet Connection is not present
					aController.showAlertDialog(newOrderActivity.this,
							"Internet Connection Error",
							"Please connect to Internet connection", false);
					// stop executing code by return
					//return;
				}
				else{
					if(aController.isConnectingToInternet())
					createOrder();
				}

	        	//return true;


	        default:
	        	//myCartHash.clear();
	        	//itemExtra.clear();
	            return super.onOptionsItemSelected(item);

	    }
	}

	@Override
	public void onButtonClick() {
		// TODO Auto-generated method stub
		//ItemlistFragment itemlistFragment=(ItemlistFragment) getSupportFragmentManager().findFragmentById(R.id.no);
		/*
		if(itemlistFragment!=null)
		{
			itemlistFragment.refreshMe();
		}
		else{
			long id=GamesFragment.ExpListItems.get(1).get_id();
	        Bundle bundle=new Bundle();
	        bundle.putString("ID",String.valueOf(id));
	        ItemlistFragment swipeTabFragment = new ItemlistFragment();
	        swipeTabFragment.setArguments(bundle);
	        android.support.v4.app.FragmentTransaction tran=getSupportFragmentManager().beginTransaction();
	        tran.replace(R.id.no_main_elist,swipeTabFragment);
	        tran.addToBackStack(null);
	        tran.commit();
	       // return swipeTabFragment;
			//ItemlistFragment newf=new ItemlistFragment();

		}
	*/
		try{
		//itemlistFragment.refreshMe();
			//if(fragmentCommunicator!=null){
			/*
			fragmentCommunicator.passDataToFragent();
			//viewPager.setCurrentItem(1);
			viewPager.removeViewAt(1);
			viewPager.refreshDrawableState();
			//viewPager.addView(child, 1);
			mAdapter.notifyDataSetChanged();
			*/
			//}

			//View view=View)
			fragmentCommunicator.passDataToFragent();
			//fragmentCommunicator2.passDataToFragent();
		//	viewPager.setCurrentItem(0);
			//viewPager.removeViewAt(1);
			//viewPager.addView((View)swipeTabFragment, 1);
		}catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

		}
	}
		/* public static String print_total(StringBuilder buf) {

			 	//String msg = message.getText().toString();
			     //if( msg.length() > 0 ){
			      //   mService.sendMessage(String.valueOf(buf)+"\n", "GBK");
			 try{
			 if( mService.isBTopen() == true)
		 	 	{
				 if(con_dev != null){
				 if (mService != null) {
					// mService.sendMessage(String.valueOf(buf)+"\n", "GBK");
					 return "true";
					// Toast.makeText(this, "Print successful", Toast.LENGTH_LONG).show();

					 }

				 }else{
					 return "printer";
				 }

		 	 	}
			 else{
				 return "false";
			 }
			 }catch(Exception e)
			 {
				// Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

			 }
			     //}
			 return "error";
			 }*/

	public void createOrder()
	{
		Float total = 0.0f;
		buf.delete(0, buf.length());
		buf2.delete(0, buf2.length());
		buf3.delete(0, buf3.length());
    	if(myCartHash.size()>0 ||myCartItemsWithExtras.size()>0){

    if(id==0){
    	//final ProgressDialog Dialog = ProgressDialog.show(newOrderActivity.this, "Sending Order", "Sending order to all device of your venue", false);
    //	final ProgressDialog Dialog = new ProgressDialog(newOrderActivity.this);
		// Dialog.setMessage("Sending order to all device of your venue");
		//	 Dialog.show();
    	//total=0.0f;
    	if(tableName.equals(""))
    		mycart.setTableName("Order");
    	else
    	{

    	}



    	mycart.setTableName(tableName);
		mycart.setTotal(String.valueOf(total));
		//int id=DBAdapter.addCartData(mycart);
		//feedercart
		ModelCart feederCart=new ModelCart();
		feederCart.setId(17490);
		feederCart.setTableName(mycart.getTableName());
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		formatter.setLenient(false);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date oldDate;
		String oldTime="";
		try {
			oldDate = formatter.parse(formatter.format(new Date()));
			oldTime = format.format(oldDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		feederCart.setTime(oldTime);
		feederCart.setTotal(mycart.getTotal());
		feederCart.setUser("Customer");
		feederCart.setPaid("false");

		feederCart.setRetroId(Integer.parseInt(rid));
		buf.append(System.getProperty("line.separator"));
		buf.append("Order");
   	 	buf.append(System.getProperty("line.separator"));
		buf.append("Date "+oldTime);
   	 	buf.append(System.getProperty("line.separator"));
   		buf.append("Waiter "+ "Customer");
   	 	buf.append(System.getProperty("line.separator"));
   	 buf.append("Table "+mycart.getTableName());
	 	buf.append(System.getProperty("line.separator"));
	 	buf.append(System.getProperty("line.separator"));
	 	 buf.append("Items");
	 	buf.append(System.getProperty("line.separator"));



		//Toast.makeText(getApplicationContext(), id+"Mycart Added",Toast.LENGTH_LONG).show();
	 	 Iterator itr = newOrderActivity.cartItems.iterator();
          CartItems strElement  =new CartItems();
        //  CartItems strElement2  =new CartItems();
          try{
          while(itr.hasNext()){
        	  strElement = (CartItems)itr.next();

        	  CartItems feederCartitem=new CartItems();
  			Item i=new Item();
  			i.set_id(strElement.get_item().get_id());
  			i.set_name(strElement.get_item().get_name());
  			i.set_price(strElement.get_item().get_price());
  			i.set_flag(strElement.get_item().get_flag());


  			feederCartitem.set_item(i);
  			feederCartitem.set_quantity(strElement.get_quantity());
  			feederCartitem.set_course(strElement.get_course());
  			feederCartitem.set_mark(strElement.get_mark());
  			feederCartitem.set_status("1");
  			buf2.append(feederCartitem.get_quantity()+" "+i.get_name());
		 	buf2.append(System.getProperty("line.separator"));
          //	strElement2.get_item().set_extra(null);
          	if(strElement.get_mark()!=0){

          		for (Extra iterable_element : strElement.get_item().get_extra()) {
          		//	Toast.makeText(getApplicationContext(),iterable_element.get_name(), Toast.LENGTH_LONG).show();

						for(int j=0;j<=5;j++){
							if(newOrderActivity.itemExtra.containsKey(strElement.get_item().get_name()+ String.valueOf(j)+ String.valueOf(strElement.get_mark())+iterable_element.get_name())){
								 Extra feederExtra=new Extra();
								 feederExtra.set_id(iterable_element.get_id());
								 feederExtra.set_name(iterable_element.get_name());
								 feederExtra.set_price(iterable_element.get_price());
								 feederCartitem.get_item().addExtra(feederExtra)	;
								 buf2.append("   with "+iterable_element.get_name());
								 	buf2.append(System.getProperty("line.separator"));
								// feederCartitem.get_item().removeChild(iterable_element);
								}
						}

					}
          	}

          	feederCart.setProduct(feederCartitem);
          }
}catch(Exception e){
        	  Toast.makeText(getApplicationContext(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
          }
	/*	for(Map.Entry<String, CartItems> entry: myCartHash.entrySet())
		{
			//String key = entry.getKey();
			CartItems value = entry.getValue();
			//int iid=DBAdapter.addCartitems(value, id);
			CartItems feederCartitem=new CartItems();
			Item i=new Item();
			i.set_id(value.get_item().get_id());
			i.set_name(value.get_item().get_name());
			i.set_price(value.get_item().get_price());
			i.set_flag(value.get_item().get_flag());


			feederCartitem.set_item(i);
			feederCartitem.set_quantity(value.get_quantity());
			feederCartitem.set_course(value.get_course());
			buf.append(feederCartitem.get_quantity()+" "+i.get_name());
		 	buf.append(System.getProperty("line.separator"));
			value.set_cartid(id);


			//crudonserver.addCartitems(iid,value, id);
			//Toast.makeText(getApplicationContext(), value.get_item().get_name()+" Item  Added",Toast.LENGTH_LONG).show();
			for(Map.Entry<String, Extra> entry1: itemExtra.entrySet())
    		{
				Extra value1 = entry1.getValue();
				if(value1.get_item().get_name().equals(value.get_item().get_name()))
						{
					int itmid=value1.get_id();
					value1.set_id(0);
					value1.set_id(itmid);
					 value.get_item().addExtra(value1);
					// value1.set_item(null);
					 Extra feederExtra=new Extra();
					 feederExtra.set_id(value1.get_id());
					 feederExtra.set_name(value1.get_name());
					 feederExtra.set_price(value1.get_price());
					 //feederExtra.s(value1.get_id());

					 feederCartitem.get_item().addExtra(feederExtra);
					 buf.append("1"+" "+value1.get_name());
					 	buf.append(System.getProperty("line.separator"));
						}

    		}
			feederCart.setProduct(feederCartitem);
		}*/
		buf3.append("------------------------------");
		buf3.append(System.getProperty("line.separator"));
		buf3.append(System.getProperty("line.separator"));
		buf3.append(System.getProperty("line.separator"));
	/*	mycart.setId(id);
		ArrayList<CartItems> ci=DBAdapter.getAllCartItemsDataByCartId(id);
		ModelCart mCart=new ModelCart();
		mCart.setId(mycart.getId());
		mCart.setTableName(mycart.getTableName());
		mCart.setTotal(mycart.getTotal());
		 */
		//mycart.setProducts(DBAdapter.getAllCartItemsDataByCartId(id));
	/*	for (CartItems ie : ci) {

			mCart.setProduct(ie);
		//	Toast.makeText(getApplicationContext(),ie.get_item().get_name(),Toast.LENGTH_LONG).show();

			try{
				ArrayList<CartItems> c=DBAdapter.getAllCartItemsDataByCartIdnFlag(ie.get_id());
			for (CartItems cartItems : c) {
				//cartItems.get_item().set_flag(String.valueOf(ie.get_id()));
		//if(cartItems.get_cartid()!=0){
				cartItems.set_itemidAscid(ie.get_id());
				mCart.setProduct(cartItems);
				// Toast.makeText(getApplicationContext(),cartItems.get_item().get_name(),Toast.LENGTH_LONG).show();

		//}


			}}
			catch(Exception e)
			{

			}

		}
		*/
	Gson gson = new GsonBuilder().create();
		crudonserver crudop=new crudonserver();
		//Toast.makeText(getApplicationContext(), gson.toJson(feederCart) ,Toast.LENGTH_LONG).show();
		//mCart.setTime(String.valueOf(DBAdapter.getRestaurantId()));
		View focus = getCurrentFocus();
        if (focus != null) {
            hiddenKeyboard(focus);
        }



		//crudop.callserverforreceiveorder(gson.toJson(feederCart),this);
     // Get data from EditText
	//	String message = txtMessage.getText().toString();

		// WebServer Request URL
        String serverURL = Config.YOUR_SERVER_URL+"taborder.php";

        // Use AsyncTask execute Method To Prevent ANR Problem

		if (Build.VERSION.SDK_INT >= 11) {
			new LongOperation().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,serverURL,gson.toJson(feederCart),"","");
		} else {
			new LongOperation().execute(serverURL,gson.toJson(feederCart),"","");
		}
	//	mCart.setTime("");

    		}
    		else
    		{
    			//final ProgressDialog Dialog = new ProgressDialog(newOrderActivity.this);
   			// Dialog.setMessage("Sending order to all device of your venue");
   				// Dialog.show();

    			//DBAdapter.updateCart(mycart.getId(), mycart.getTableName(), mycart.getTotal());
    			ModelCart feederCart=new ModelCart();
    			feederCart.setId(mycart.getId());
    			feederCart.setTableName(newOrderActivity.tableName);
    			// Toast.makeText(getApplicationContext(),newOrderActivity.tableName,Toast.LENGTH_LONG).show();

    			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    			formatter.setLenient(false);
    			Calendar cal = Calendar.getInstance();
    			feederCart.setTime(formatter.format(new Date()));
    			feederCart.setTotal(mycart.getTotal());

    			feederCart.setUser("Customer");
    			feederCart.setPaid("false");
    			feederCart.setRetroId(Integer.parseInt(rid));
    			buf.append(System.getProperty("line.separator"));
    			buf.append("Order");
    	   	 	buf.append(System.getProperty("line.separator"));
    			buf.append("Date "+feederCart.getTime());
    	   	 	buf.append(System.getProperty("line.separator"));
    	   		buf.append("Waiter "+ "Customer");
    	   	 	buf.append(System.getProperty("line.separator"));
    	   	 	buf.append("Table "+mycart.getTableName());
    		 	buf.append(System.getProperty("line.separator"));
    		 	buf.append(System.getProperty("line.separator"));
    		 	buf.append("Items");
    		 	buf.append(System.getProperty("line.separator"));


    			for(Map.Entry<String, CartItems> entry: mynewCartHash.entrySet())
        		{
    				String key = entry.getKey();
    				//cartItems c=entry.getValue();
    				//dhaval patel
    				if(!myCartHash.containsKey(key))
    				{
    					//CartItems cartitem = entry.getValue();
    					changed=true;
    					if(entry.getValue().get_status().equals("5")){
    					buf2.append("Cancel "+entry.getValue().get_quantity()+" "+ entry.getValue().get_item().get_name());
						buf2.append(System.getProperty("line.separator"));
    					}
    				//	DBAdapter.deleteCartitem(cartitem.get_id());
    				}
        		}
    			for(Map.Entry<String, CartItems> entry: mynewCartItemsWithExtras.entrySet())
        		{
    				String key = entry.getKey();
    				if(!myCartItemsWithExtras.containsKey(key))
    				{
    					//CartItems cartitem = entry.getValue();
    					changed=true;
    					buf2.append("Cancel "+ entry.getValue().get_item().get_name());
						buf2.append(System.getProperty("line.separator"));
    				//	DBAdapter.deleteCartitem(cartitem.get_id());
    				}
        		}
    			 Iterator itr = newOrderActivity.cartItems.iterator();
    	          CartItems strElement  =new CartItems();
    			try{
    		          while(itr.hasNext()){
    		        	  strElement = (CartItems)itr.next();

    		        	  CartItems feederCartitem=new CartItems();

    		  			Item i=new Item();
    		  			i.set_id(strElement.get_item().get_id());
    		  			i.set_name(strElement.get_item().get_name());
    		  			i.set_price(strElement.get_item().get_price());
    		  			i.set_flag(strElement.get_item().get_flag());


    		  			feederCartitem.set_item(i);
    		  			feederCartitem.set_quantity(strElement.get_quantity());
    		  			feederCartitem.set_course(strElement.get_course());
    		  			feederCartitem.set_mark(strElement.get_mark());
    		  			if(strElement.get_status().equals("0")){
    		  				feederCartitem.set_status("1");
    		  			}else{
    		  				feederCartitem.set_status(strElement.get_status());
    		  			}
    		  			if(strElement.get_mark()==0){

    		  				if(myCartHash.containsKey(feederCartitem.get_item().get_name()+"1")){
    		  					CartItems c=myCartHash.get(feederCartitem.get_item().get_name()+"1");
    		  					if(strElement.get_status().equals("0")){
    		  					int qty=strElement.get_quantity()+c.get_quantity();
	  							feederCartitem.set_quantity(qty);
    		  					}
    		  				}


		  			 }
    		  		/*	if(strElement.get_mark()==0){
    		  				for(Map.Entry<String, CartItems> entry: mynewCartHash.entrySet())
    		  				{
    		  					CartItems c=entry.getValue();
    		  					if(entry.getKey().equals(feederCartitem.get_item().get_name()+"1")){
    		  							int qty=strElement.get_quantity()+c.get_quantity();
    		  							feederCartitem.set_quantity(qty);
    		  					}
    		  				}
    		  			 }*/
    		  		//	buf.append(feederCartitem.get_quantity()+" "+i.get_name());
    				 //	buf.append(System.getProperty("line.separator"));
    		          //	strElement2.get_item().set_extra(null);
    		          	if(strElement.get_mark()!=0){

    		          		for (Extra iterable_element : strElement.get_item().get_extra()) {
    		          			//Toast.makeText(getApplicationContext(),iterable_element.get_name(), Toast.LENGTH_LONG).show();
    		          			for(int j=0;j<=5;j++){
    		          			if(newOrderActivity.itemExtra.containsKey(strElement.get_item().get_name()+ String.valueOf(j)+ String.valueOf(strElement.get_mark())+iterable_element.get_name())){
    								 Extra feederExtra=new Extra();
    								 feederExtra.set_id(iterable_element.get_id());
    								 feederExtra.set_name(iterable_element.get_name());
    								 feederExtra.set_price(iterable_element.get_price());
    								 feederCartitem.get_item().addExtra(feederExtra)	;
    							//	 buf.append("1"+" "+iterable_element.get_name());
    							//	 	buf.append(System.getProperty("line.separator"));
    								// feederCartitem.get_item().removeChild(iterable_element);
    								}
    		          			}

    							}


    		          	}


    		          	boolean isExists = false;
    		          	for (CartItems citem : feederCart.getProducts()) {
							if(citem.get_item().get_name().equals(feederCartitem.get_item().get_name())){

									if(citem.get_mark()==feederCartitem.get_mark()){
										if(citem.get_status().equals(feederCartitem.get_status())){
											if(citem.get_status().equals("1")){
											isExists=true;
											break;
										}
										}
									}

							}
						}
    		          	if(!isExists){
    		          		feederCart.setProduct(feederCartitem);
    		          		isExists=false;
    		          	}

    					//cartItems=DBAdapter.getCartItemsDataByCartId(mycart.getId());

    					}
    		}catch(Exception e){
    		        	  Toast.makeText(getApplicationContext(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
    		          }
    			for(Map.Entry<String, CartItems> entry: myCartItemsWithExtras.entrySet())
        		{
    				String key = entry.getKey();
    				if(mynewCartItemsWithExtras.containsKey(key))
    				{
    					int q1=0,q=0;
    					CartItems cartitem = entry.getValue();
    					cartItems=DBAdapter.getCartItemsDataByCartId(mycart.getId());
    					for (CartItems iterable_element : cartItems) {
							if(cartitem.get_id()==iterable_element.get_id())
							{
								q1=iterable_element.get_quantity();
								 q=cartitem.get_quantity()-q1;

							}
						}

    					if(q>0){
    						if(cartitem.get_status().equals("0")){
    					buf2.append(q+" "+cartitem.get_item().get_name());
   	    			 	buf2.append(System.getProperty("line.separator"));

    						}
    						changed=true;
    					}
    				//	DBAdapter.updateCartItemQuantity(cartitem.get_id(), cartitem.get_quantity());

    				}
    				else
    				{
    					CartItems value = entry.getValue();
    					//Add new object
    				//	int iid=DBAdapter.addCartitems(value, mycart.getId());
    					buf2.append(value.get_quantity()+" "+value.get_item().get_name());
    	    		 	buf2.append(System.getProperty("line.separator"));
    					for(Map.Entry<String, Extra> entry1: itemExtra.entrySet())
                		{
            				Extra value1 = entry1.getValue();
            				String keyValue=entry1.getKey();

            				if(keyValue.equals(value.get_item().get_name()+ String.valueOf(value.get_mark())+value1.get_name())){
            					buf2.append("  with"+" "+value1.get_name());
            	    		 	buf2.append(System.getProperty("line.separator"));
            	    		 	 changed=true;
            				}

                		}
    				}
        		}
    			for(Map.Entry<String, CartItems> entry: myCartHash.entrySet())
        		{
    				String key = entry.getKey();
    				if(mynewCartHash.containsKey(key))
    				{
    					int q1=0,q=0;
    					CartItems cartitem = entry.getValue();
    					cartItems=DBAdapter.getCartItemsDataByCartId(mycart.getId());
    					for (CartItems iterable_element : cartItems) {
							if(cartitem.get_id()==iterable_element.get_id())
							{
								q1=iterable_element.get_quantity();
								 q=cartitem.get_quantity()-q1;

							}
						}

    					if(q>0){
    						if(cartitem.get_status().equals("0")){
    					buf2.append(q+" "+cartitem.get_item().get_name());
   	    			 	buf2.append(System.getProperty("line.separator"));


    					}
    						 changed=true;
    					}
    				//	DBAdapter.updateCartItemQuantity(cartitem.get_id(), cartitem.get_quantity());

    				}
    				else
    				{
    					CartItems value = entry.getValue();
    					//Add new object
    				//	int iid=DBAdapter.addCartitems(value, mycart.getId());
    					if(value.get_status().equals("0")){
    					buf2.append(value.get_quantity()+" "+value.get_item().get_name());
    	    		 	buf2.append(System.getProperty("line.separator"));
    					}
    					changed=true;

    				}
        		}
    			/*for(Map.Entry<String, CartItems> entry: myCartHash.entrySet())
        		{
    				CartItems Citem = entry.getValue();
    				CartItems feederCartitem=new CartItems();
    				Item i=new Item();
    				i.set_id(Citem.get_item().get_id());
    				i.set_name(Citem.get_item().get_name());
    				i.set_price(Citem.get_item().get_price());
    				i.set_flag(Citem.get_item().get_flag());

    				feederCartitem.set_item(i);
    				// Toast.makeText(getApplicationContext(), i.get_name() +" Item  Added",Toast.LENGTH_LONG).show();

    				feederCartitem.set_quantity(Citem.get_quantity());
    				feederCartitem.set_course(Citem.get_course());*/
    			//	buf.append(feederCartitem.get_quantity()+" "+i.get_name());
    			// 	buf.append(System.getProperty("line.separator"));
    				/*for(Map.Entry<String, Extra> entry1: itemExtra.entrySet())
            		{
        				Extra value1 = entry1.getValue();
        				if(value1.get_item().get_name().equals(Citem.get_item().get_name()))
        						{
        					int itmid=value1.get_id();
        					value1.set_id(0);
        					//int Eid= DBAdapter.addCartitemsExtra(value1,iid,itmid);
        					 value1.set_id(itmid);

        					 Extra feederExtra=new Extra();
        					 feederExtra.set_id(value1.get_id());
        					 feederExtra.set_name(value1.get_name());
        					 feederExtra.set_price(value1.get_price());
        					 //feederExtra.s(value1.get_id());
        					 changed=true;
        					 feederCartitem.get_item().addExtra(feederExtra);
        					// buf.append("1"+" "+feederExtra.get_name());
        	    			 //	buf.append(System.getProperty("line.separator"));
        					// Toast.makeText(getApplicationContext(), value1.get_name()+" "+value.get_item().get_id() +" Extra  Added",Toast.LENGTH_LONG).show();

        						}

            		}
    				//feederCart.setProduct(feederCartitem);

    				String key = entry.getKey();
    				if(mynewCartHash.containsKey(key))
    				{
    					int q1=0,q=0;
    					CartItems cartitem = entry.getValue();
    					cartItems=DBAdapter.getCartItemsDataByCartId(mycart.getId());
    					for (CartItems iterable_element : cartItems) {
							if(cartitem.get_id()==iterable_element.get_id())
							{
								q1=iterable_element.get_quantity();
								 q=cartitem.get_quantity()-q1;

							}
						}

    					if(q>0){
    					buf.append(q+" "+cartitem.get_item().get_name());
   	    			 	buf.append(System.getProperty("line.separator"));
   	    			 changed=true;
    					}
    				//	DBAdapter.updateCartItemQuantity(cartitem.get_id(), cartitem.get_quantity());

    				}
    				else
    				{
    					CartItems value = entry.getValue();
    					//Add new object
    				//	int iid=DBAdapter.addCartitems(value, mycart.getId());
    					buf.append(value.get_quantity()+" "+value.get_item().get_name());
    	    		 	buf.append(System.getProperty("line.separator"));
    						for(Map.Entry<String, Extra> entry1: itemExtra.entrySet())
                		{
            				Extra value1 = entry1.getValue();
            				if(value1.get_item().get_name().equals(value.get_item().get_name()))
            						{
            					int itmid=value1.get_id();
            					value1.set_id(0);
            			//		int Eid= DBAdapter.addCartitemsExtra(value1,iid,itmid);
            					buf.append("1"+" "+value1.get_name());
            	    		 	buf.append(System.getProperty("line.separator"));
            					 value1.set_id(itmid);
            					 changed=true;
            						}

                		}
    				}
        		}*/
    			buf3.append("------------------------------");
    			buf3.append(System.getProperty("line.separator"));
    			buf3.append(System.getProperty("line.separator"));
    			buf3.append(System.getProperty("line.separator"));
    			/*for(Map.Entry<String, CartItems> entry: myCartHash.entrySet())
        		{
        			//String key = entry.getKey();
        			CartItems cartitem = entry.getValue();
        			mycart.setProduct(cartitem);
	        		try{
	        		total+=Float.parseFloat(cartitem.get_item().get_price());
	        		}
	        		catch(Exception e){
	        		}
	        		for(Map.Entry<String, Extra> entry1: itemExtra.entrySet())
            		{
        				Extra value1 = entry1.getValue();
        				if(value1.get_item().get_name().equals(cartitem.get_item().get_name()))
        						{
        					try{
        					total+=Float.parseFloat(value1.get_price());
        					}
        	        		catch(Exception e){
        	        		}
        					}

            		}
        		}
	        	mycart.setTableName(tableName);
        		mycart.setTotal(String.valueOf(total));

        		ArrayList<CartItems> ci=DBAdapter.getAllCartItemsDataByCartId(mycart.getId());
        		ModelCart mCart=new ModelCart();
        		mCart.setId(mycart.getId());
        		mCart.setTableName(mycart.getTableName());
        		 */



        		Gson gson = new GsonBuilder().create();
   			 crudonserver crudop=new crudonserver();

   			//mCart.setTime(String.valueOf(DBAdapter.getRestaurantId()));
   			View focus = getCurrentFocus();
   	        if (focus != null) {
   	            hiddenKeyboard(focus);
   	        }
   	    //if(changed){

   	 // crudop.callserverforUpdateorder(gson.toJson(feederCart),this);
   	  String serverURL = Config.YOUR_SERVER_URL+"updateCart.php";

      // Use AsyncTask execute Method To Prevent ANR Problem

				if (Build.VERSION.SDK_INT >= 11) {
					new LongOperation().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,serverURL,gson.toJson(feederCart),"","");
				} else {
					new LongOperation().execute(serverURL,gson.toJson(feederCart),"","");
				}

   	//    }


   			//Toast.makeText(getBaseContext(),gson.toJson(feederCart), Toast.LENGTH_LONG).show();

   			//mCart.setTime("");

        	//	ModelCart cart=DBAdapter.getCartData(id);





        		//long id=DBAdapter.addCartData(mycart);
    			/*for(Map.Entry<String, CartItems> entry: myCartHash.entrySet())
        		{
        			//String key = entry.getKey();


        			CartItems cartitem = entry.getValue();
        			mycart.setProduct(cartitem);
	        		try{
	        		total+=Integer.parseInt(cartitem.get_item().get_price());
	        		}
	        		catch(Exception e){
	        		}
	        		for(Map.Entry<Extra, Extra> entry1: itemExtra.entrySet())
            		{
        				Extra value1 = entry1.getValue();
        				if(value1.get_item().get_name().equals(cartitem.get_item().get_name()))
        						{
        					try{
        					total+=Integer.parseInt(value1.get_price());
        					}
        	        		catch(Exception e){
        	        		}
        					}

            		}
        		}*/

    		}
  /*  Handler handler = new Handler();
	handler.postDelayed(new Runnable() {
	    public void run() {

	    	//Dialog.dismiss();
	    }}, 2000);
*/
    	}
    	else
    	{
    		Toast.makeText(getApplicationContext(),"Select item to create order ", Toast.LENGTH_LONG).show();
    	}


	}

	/*
		 @Override
		 public void onActivityResult(int requestCode, int resultCode, Intent data) {
		     switch (requestCode) {
		     case REQUEST_ENABLE_BT:
		         if (resultCode == Activity.RESULT_OK) {
		         	Toast.makeText(this, "Bluetooth open successful", Toast.LENGTH_LONG).show();
		         } else {
		         	finish();
		         }
		         break;
		     case  REQUEST_CONNECT_DEVICE:
		     	if (resultCode == Activity.RESULT_OK) {
		             String address = data.getExtras()
		                                  .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
		             con_dev = mService.getDevByMac(address);

		             mService.connect(con_dev);
		            // print_bt();
		         }
		         break;
		     }
		 }
*/

	/* protected void connect() {
		 try{
		 if(con_dev == null){
		 /*	SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);

		 for (Entry<String, ?> entry : pref.getAll().entrySet()) {
		      Object val = entry.getValue();
		      if (val == null) {
		          //output.append(String.format("%s = <null>%n", entry.getKey()));
		      } else {
		     	 con_dev = mService.getDevByMac(String.valueOf(entry.getValue()));


		          mService.connect(con_dev);

		      }
		  }*//*
			 ArrayList<Printer> prtrs=DBAdapter.getKitchenPrinterData();
		    int size=prtrs.size();
		    if(size==1){
		    	con_dev = mService.getDevByMac(prtrs.get(0).get_mac());
		    	//Toast.makeText(getBaseContext(),String.valueOf(con_dev.getBondState()),Toast.LENGTH_LONG).show();
		    	//mService.getPairedDev();
		        mService.connect(con_dev);

		    }else if(size>=1){
		    	 final Dialog dialog = new Dialog(newOrderActivity.this);
    			 dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    			 dialog.setContentView(R.layout.select_restro);
    			 final SelectPrinterAdapter adapter = new SelectPrinterAdapter(newOrderActivity.this,prtrs);
    			 final TextView title = (TextView) dialog.findViewById(R.id.txt_select_restro);
    			 title.setText("Select Printer");
    		        final ListView listView = (ListView) dialog.findViewById(R.id.lv_select_restro);
    		        listView.setAdapter(adapter);
    		        listView.setOnItemClickListener(new OnItemClickListener() {

    				@Override
    				public void onItemClick(AdapterView<?> parent, View v,
    						int groupPosition, long id) {
    					Printer printer=(Printer)parent.getItemAtPosition(groupPosition);
    					con_dev = mService.getDevByMac(printer.get_mac());
    			        mService.connect(con_dev);
    			        dialog.dismiss();
    				//	Toast.makeText(getBaseContext(),String.valueOf(Restro.get_restro_id()),Toast.LENGTH_LONG).show();

    				}
    			});

    			 dialog.getWindow().setLayout(getWidth(), LayoutParams.WRAP_CONTENT);
    			 dialog.show();
		    }

		 }
		 else{



		 }
		 }
			catch(Exception e)
			{
				Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
			}
		 }
	 */
		 private void print_bt() {

		 	//String msg = message.getText().toString();
		     //if( msg.length() > 0 ){
		      //   mService.sendMessage(String.valueOf(buf)+"\n", "GBK");
			/* try{
			 if (mService != null) {
				 mService.sendMessage(String.valueOf(buf)+"\n", "GBK");

		           if(mService.getState()==3){
				 Toast.makeText(this, "Print successful", Toast.LENGTH_LONG).show();
				 if (mService != null)
					 	mService.stop();
					 mService = null;
					 con_dev=null;
		           }
		           else{
		        	   if (mService != null)
						 	mService.stop();
						 mService = null;
						 con_dev=null;
		        	   Toast.makeText(this, "Print Fail", Toast.LENGTH_LONG).show();
		           }

				 }
			 }catch(Exception e)
			 {
				 Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

			 }
			  */
		     //}

		 }

			public void updatecart(String message) {
				try{
		    		StringBuffer items=new StringBuffer();
		    		Gson gson = new GsonBuilder().create();
		    		//Data d=new Data();
		    		//ModelCart m=new ModelCart();
		    		ModelCart cart=gson.fromJson(message,ModelCart.class);
		    		//generateNotification(context, cart.getTableName(),cart.getTotal(),cart.getTime());
		    		//aController.MessageAction(context, message);
		    	//ModelCart dbCart=DBAdapter.getCartData(cart.getId());
		    		if(cart.getRetroId()==Integer.parseInt(rid) ){
		    	if(!DBAdapter.CheckIsDataAlreadyInDBorNot("tbl_cart", "cart_id",cart.getId()))
		    	//if((dbCart==null))
		    		{
		    		DBAdapter.addCartData(cart);

		    		//items.append(cart.getTableName());

		    		for (CartItems cartItem : cart.getProducts()) {
		    			if(cartItem.get_item().get_flag().equals("I")){
		    				items.append("/n");
		    				items.append(cartItem.get_quantity()+" ");
		    				items.append(cartItem.get_item().get_name());

						DBAdapter.addCartitems(cartItem, cart.getId());
						for (Extra extraItem : cartItem.get_item().get_extra()) {
							int rid=extraItem.get_id();
							extraItem.set_id(extraItem.get_refId());
							DBAdapter.addCartitemsExtra(extraItem, cartItem.get_id(),rid);

						}
		    			}
		    			/*else{
		    				items.append("/n");
		    				items.append("   with");
		    				Extra e=new Extra();
		    				e.set_id(cartItem.get_id());
		    				e.set_name(cartItem.get_item().get_name());
		    				e.set_price(cartItem.get_item().get_price());
		    				items.append(cartItem.get_item().get_name());
		    				//DBAdapter.addCartitemsExtra(e, cartItem.get_itemidAscid(), cartItem.get_item().get_id());
		    			}*/
					}

		    		//aController.CartUpdate(getApplicationContext(), "Hello");
		    		//received=true;
		    		//generateNotification(context, "New Order for "+ cart.getTableName(),"New Order for"+ cart.getTableName(),cart.getTime());
		    	}
		    	else
		    	{

		    		DBAdapter.updateCart(cart.getId(), cart.getTableName(), cart.getTotal());
		    		for (CartItems citem : DBAdapter.getAllCartItemsDataByCartId(cart.getId())) {
						DBAdapter.deleteCartitem(citem.get_id());
					}
		    		for (CartItems cartItem : cart.getProducts()) {
		    			if(cartItem.get_item().get_flag().equals("I")){

						DBAdapter.addCartitems(cartItem, cart.getId());
						for (Extra extraItem : cartItem.get_item().get_extra()) {
							int rid=extraItem.get_id();
							extraItem.set_id(extraItem.get_refId());
							DBAdapter.addCartitemsExtra(extraItem, cartItem.get_id(),rid);

						}

		    			}
		    		}
		    		/*for (CartItems cartItem : cart.getProducts()) {
		    			if(cartItem.get_item().get_flag().equals("I")){
						DBAdapter.addCartitems(cartItem, cart.getId());
		    			}
		    			else{
		    				Extra e=new Extra();
		    				e.set_id(cartItem.get_id());
		    				e.set_name(cartItem.get_item().get_name());
		    				e.set_price(cartItem.get_item().get_price());

		    				DBAdapter.addCartitemsExtra(e, cartItem.get_itemidAscid(), cartItem.get_item().get_id());
		    			}
					}*/

		    	//	aController.CartUpdate(getApplicationContext(), "Hello");
		    		//received=true;
		    		//generateNotification(context, cart.getTableName(),"Update Order for "+ cart.getTableName(),cart.getTime());
		    	}
		    	}


		    	}
		    	catch(Exception e)
		    	{
		    		Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		    	}

			}
			 public  int getWidth()
			 {try
		     {

				 Display display =(newOrderActivity.this).getWindowManager().getDefaultDisplay();
			     Point screenSize = new Point();
			     display.getSize(screenSize);
			     int width = screenSize.x;
				 WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
			    // layoutParams.copyFrom(dialog.getWindow().getAttributes());
			     layoutParams.width = (int) (width - (width * 0.05) ); 
			     //layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
				return  layoutParams.width;
		     }
			 catch(Exception e)
			 {
				 //Toast.makeText(getActivity(),String.valueOf(e.getMessage()),Toast.LENGTH_LONG).show();
				 return  400; 
			 }
			 }
			 public void pairPrinter(final String macAdd)  {
			        final UUID SerialPortServiceClass_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
			        final BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
			        final String PrinterBsid = "00:19:5D:25:1B:4A"; // This is My Printer Bluetooth MAC Address
			      
			       // final Runnable showToastMessage = new Runnable()
			        Thread t = new Thread(new Runnable() {
			            @Override
			            public void run() {  
			                OutputStream sOut;
			                BluetoothSocket socket;
			                BA.cancelDiscovery();  
			  
			  
			               // BluetoothDevice BD = BA.getRemoteDevice(PrinterBsid);  
			                BluetoothDevice BD = BA.getRemoteDevice(macAdd);
			                try {  
			                    socket = BD.createInsecureRfcommSocketToServiceRecord(SerialPortServiceClass_UUID);  
			  
			  
			                    if (!socket.isConnected()) {  
			                        socket.connect();  
			                        Thread.sleep(1000); // <-- WAIT FOR SOCKET
			                    }  
			                    sOut = socket.getOutputStream();  
			                    String cpclData = "! 0 200 200 210 1\r\n"
			                            + "TEXT 4 0 30 40 This is a CPCL test.\r\n"  
			                            + "FORM\r\n"  
			                            + "PRINT\r\n";  
			                  //  sOut.write(cpclData.getBytes());  
			                    String cpclData1=buf.toString()+buf2.toString()+buf3.toString();
			                    sOut.write(cpclData1.getBytes());  
			                   // Toast.makeText(newOrderActivity.this, "Print Successfull", Toast.LENGTH_SHORT).show();
			                  
			                    sOut.close();  
			                   // msg="Print Successfull";
			                    socket.close();  
			                    BA.cancelDiscovery();  
			                   
			                   // mHandler1.post(mUpdateResults);
			                    threadMsg("Print Successfull");
			                } catch (IOException e) {
			                    Log.e("","IOException");
			                  //  msg="Print Fail "+e.getMessage();
			                    threadMsg("Retrying.. Print Fail "+e.getMessage());
			                    try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			                    pairPrinter(macAdd); 
			                    e.printStackTrace();  
			                    //return;  
			                } catch (InterruptedException e) {
			                    e.printStackTrace();  
			                    threadMsg("Retrying.. Print Fail "+e.getMessage());
			                    try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			                    pairPrinter(macAdd);
			                  //  msg="Print Fail "+e.getMessage();
			                }  
			            }  
			        });  
			  
			        t.start(); 
			       // Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	                   
			        //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	                
			    }  
			 
			/* final Runnable mUpdateResults = new Runnable() {
			 	    public void run() {
			 	    	Toast.makeText(getApplicationContext(),"Print Successfull",Toast.LENGTH_SHORT).show();
			 	    }
			 	};*/
			 	 private void threadMsg(String msg) {
			 		 
                     if (!msg.equals(null) && !msg.equals("")) {
                         Message msgObj = handler.obtainMessage();
                         Bundle b = new Bundle();
                         b.putString("message", msg);
                         msgObj.setData(b);
                         handler.sendMessage(msgObj);
                     }
                 }

	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new Item_selected(), "Item Selected");
		//adapter.addFragment(new TwoFragment(), "TWO");
		//adapter.addFragment(new ThreeFragment(), "THREE");

int i=0;
		for(Category cat:Controller.ExpListItems)
		{Log.e(String.valueOf(cat.get_id()),cat.get_name());
			if(i==0) {
				Bundle bundle = new Bundle();
				bundle.putString("ID", String.valueOf(cat.get_id()));
				Itemlist_Fragment swipeTabFragment = new Itemlist_Fragment();
				swipeTabFragment.setArguments(bundle);
				adapter.addFragment(swipeTabFragment,cat.get_name().toUpperCase());
			}else{
				Bundle bundle = new Bundle();
				bundle.putString("ID", String.valueOf(cat.get_id()));
				ItemlistFragment swipeTabFragment = new ItemlistFragment();
				swipeTabFragment.setArguments(bundle);
				adapter.addFragment(swipeTabFragment,cat.get_name().toUpperCase());
			}
			i++;


		}
		viewPager.setAdapter(adapter);
	}

		 /*
		 @SuppressLint("SdCardPath")
		 private void printImage() {
		 	byte[] sendData = null;
		 	PrintPic pg = new PrintPic();
		 	pg.initCanvas(384);
		 	pg.initPaint();
		 	pg.drawImage(0, 0, "/mnt/sdcard/icon.jpg");
		 	sendData = pg.printDraw();
		 	mService.write(sendData);
		 }
		 */
			public class LongOperation  extends AsyncTask<String, Void, String> {

		    	// Required initialization

		        //private ProgressDialog Dialog = new ProgressDialog(newOrderActivity.this);
		        final ProgressDialog Dialog = ProgressDialog.show(newOrderActivity.this, "Sending Order", "Sending order to all devices of your venue", false);
		        String data  = "";
		        int sizeData = 0;
		        //private final HttpClient Client = new DefaultHttpClient();
		       // private Controller aController = null;
		        private String Error = null;

		        protected void onPreExecute() {
		            // NOTE: You can call UI Element here.

		            //Start Progress Dialog (Message)

		          //  Dialog.setMessage("Please wait..");
		      //  	Dialog.setMessage("Sending order to all the devices of your venue");

		          //  Dialog.show();

		        }

		        // Call after onPreExecute method
		        protected String doInBackground(String... params) {

		        	/************ Make Post Call To Web Server ***********/
		        	BufferedReader reader=null;
		        	String Content = "";
			             // Send data
			            try{

			            	// Defined URL  where to send data
				            URL url = new URL(params[0]);

				            // Set Request parameter
				            if(!params[1].equals(""))
			               	   data +="&" + URLEncoder.encode("usersJSON", "UTF-8") + "="+params[1].toString();
				           /* if(!params[2].equals(""))
				               data +="&" + URLEncoder.encode("data2", "UTF-8") + "="+params[2].toString();
				            if(!params[3].equals(""))
					           data +="&" + URLEncoder.encode("data3", "UTF-8") + "="+params[3].toString();
			              */

				          // Send POST data request

			              URLConnection conn = url.openConnection();
			              conn.setDoOutput(true);
			              conn.setConnectTimeout(10000);
			              conn.setReadTimeout(10000);

			              OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			              wr.write( data );
			              wr.flush();

			              // Get the server response
			               try{
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
			               }
			               catch(Exception e)
			               {

			               }


			           //   Content="Sent";
			            }

			            catch (java.net.SocketTimeoutException e) {
			            //	Error = e.getMessage();
			            	Error = "socketTimeout";
			           } catch (java.io.IOException e) {
			        	   Error = e.getMessage();
			           }
			            catch(Exception ex)
			            {
			            	Error = ex.getMessage();
			            }
			            finally
			            {
			                try
			                {

			                    reader.close();
			                }

			                catch(Exception ex) {}
			            }

		            /*****************************************************/
		            return Content;
		        }

		        @SuppressWarnings("deprecation")
				protected void onPostExecute(String Content) {
		            // NOTE: You can call UI Element here.

		            // Close progress dialog
		        	Dialog.dismiss();


		            if (Error != null ) {

		            	Dialog.dismiss();
		            	//Toast.makeText(getBaseContext(), "Error: "+Error, Toast.LENGTH_LONG).show();
		            	final AlertDialog alertDialog = new AlertDialog.Builder(newOrderActivity.this).create();
		            	alertDialog.setTitle("Error");
		            	//alertDialog.setMessage(Error);
		            	alertDialog.setMessage("No Internet connection");
		            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		            	public void onClick(DialogInterface dialog, int which) {
		            	// here you can add functions
		            		alertDialog.dismiss();
		            	}
		            	});

		            	alertDialog.show();
		            } else {

		                	try{ ArrayList<Printer> prtrs=DBAdapter.getKitchenPrinterData();
                  		   for (final Printer printer : prtrs) {
		                		Thread t1=new Thread(new Runnable() {
		        		             @Override
		        		             public void run() {
		        		            	if(changed){
		        		            		if(!buf2.toString().isEmpty()){
		        		            	  pairPrinter(printer.get_mac());
		        		            		}
		        		            	}
		        		             }
		        		         });
		                		t1.start();

		                		//t1.join();
		                		//Thread.sleep(2000);
                  		   }
		                	}
		        			catch(Exception e)
		        			{
		        				Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
		        			}


		                /*	new Thread() {
		                	    public void run() {
		                	        mHandler1.post(mUpdateResults);
		                	    }
		                	}.start();
		                	*/
		            	  	Content = Content.replaceFirst("<font>.*?</font>", "");
	                	//Content = Content.replaceFirst("{main}()", "");
	                	int jsonStart = Content.indexOf("{");
	                	int jsonEnd = Content.lastIndexOf("}");

	                	if (jsonStart >= 0 && jsonEnd >= 0 && jsonEnd > jsonStart) {
	                	    Content = Content.substring(jsonStart, jsonEnd + 1);
	                	} else {
	                	    // deal with the absence of JSON content here
	                	}
	                	updatecart(Content);
	                	Dialog.dismiss();
		            	Gson gson = new GsonBuilder().create();
		            	crudonserver crud=new crudonserver();
		            	crud.sendOrder(Content, getApplicationContext());

		            	// Show Response Json On Screen (activity)
		            //	 Toast.makeText(getBaseContext(), "Message sent."+Content, Toast.LENGTH_LONG).show();
		            	 try{
		 					/* try {
		 							//Thread.sleep(2000);
		 							//Dialog.dismiss();
		 						} catch (InterruptedException e) {
		 							// TODO Auto-generated catch block
		 							e.printStackTrace();
		 						}*/


		 					// Thread.sleep(3000);

		 		    	myCartHash.clear();
		 		    	itemExtra.clear();


		 		        if(mynewCartHash!=null)
		 		        mynewCartHash.clear();

		 		    tableName="";
		 		    changed=false;
		 		   mycart=null;

		 		   newOrderActivity.id=0;
		        //	newOrderActivity.id2=1;
		 				 }
		 				 catch(Exception e)
		 				 {}
		 		  //  total=0;
		 		        //Toast.makeText(getSherlockActivity(), "Tapped home", Toast.LENGTH_SHORT).show();
		 		       // onHomeSelectedListener.onHomeSelected();

                     	newOrderActivity.markHash.clear();
                     	newOrderActivity.myCartItemsWithExtras.clear();
                     	if(newOrderActivity.mynewCartItemsWithExtras!=null)
                        	newOrderActivity.mynewCartItemsWithExtras.clear();
		 		    	Intent intent11 = new Intent(getApplicationContext(), com.example.astics.qrscannetinbuilt.activity.MainActivity.class);
		 		    	intent11.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 		    	Bundle mBundle1 = new Bundle();
		 				mBundle1.putString("ID", String.valueOf(id2));
		 				intent11.putExtras(mBundle1);
		 		    	startActivity(intent11);
		 		    		        	finish();
		             }
		        }

		    }

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		private final List<String> mFragmentTitleList = new ArrayList<>();

		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void addFragment(Fragment fragment, String title) {
			mFragmentList.add(fragment);
			mFragmentTitleList.add(title);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragmentTitleList.get(position);
		}
	}
}
