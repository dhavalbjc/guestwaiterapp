package com.example.astics.qrscannetinbuilt;

public interface Config {

	// When you are using two simulator for testing this application.
	// Make SECOND_SIMULATOR value true when opening/installing application in second simulator
	// Actually we are validating/saving device data on IMEI basis.
	// if it is true IMEI number change for second simulator
	
	static final boolean SECOND_SIMULATOR = false;
	
	// CONSTANTS
	
	// Server Url absolute url where php files are placed.
   // static final String YOUR_SERVER_URL   =  "http://waiterapps.netii.net/";
	// static final String YOUR_SERVER_URL   =  "http://Dhaval-PC1/d2dgcm/";
	// static final String YOUR_SERVER_URL   =  "http://10.0.0.6/d2dgcm/"; 
	// static final String YOUR_SERVER_URL   =  "http://10.0.0.5/feeder/";
	 
		// static final String YOUR_SERVER_URL   =  "http://amazonapi.site90.com/";
		 static final String YOUR_SERVER_URL   =  "http://waiterapp.in/";
	// Google project id
    static final String GOOGLE_SENDER_ID = "708152966865";

    /**
     * Tag used on log messages.
     */
    static final String TAG = "GCM Android Example";

    // Broadcast reciever name to show gcm registration messages on screen 
    static final String DISPLAY_REGISTRATION_MESSAGE_ACTION =
            "info.androidhive.tabsswipe.DISPLAY_REGISTRATION_MESSAGE";
    
    // Broadcast reciever name to show user messages on screen
    static final String DISPLAY_MESSAGE_ACTION =
        "info.androidhive.tabsswipe.DISPLAY_MESSAGE";
    
    static final String CART_UPDATE =
            "info.androidhive.tabsswipe.CART_UPDATE";
    
    static final String MESSAGE_ACTION =
            "info.androidhive.tabsswipe.MESSAGE";

    // Parse server message with this name
    static final String EXTRA_MESSAGE = "message";
    
    
		
	
}
