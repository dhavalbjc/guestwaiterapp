package com.example.astics.qrscannetinbuilt;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.astics.qrscannetinbuilt.Model.CartItem;
import com.example.astics.qrscannetinbuilt.Model.Category;
import com.example.astics.qrscannetinbuilt.Model.Item;

import java.util.ArrayList;
import java.util.HashMap;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class MainActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {
    /**
     * Id to identify a camera permission request.
     */
    private static final int REQUEST_CAMERA = 0;
    public static ArrayList<Category> ExpListItems = new ArrayList();
    public static HashMap<String,CartItem> cartItems=new HashMap<>();
    private ZBarScannerView mScannerView;
    // Whether the Log Fragment is currently shown.
    private boolean mLogShown;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);

        GetCategoryData();// Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        requestCameraPermission();

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v("TAG", rawResult.getContents()); // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)
       // Toast.makeText(this,  rawResult.getContents(), Toast.LENGTH_SHORT).show();
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
       // String CurrentString = "Fruit: they taste good";
        if( rawResult.getContents().trim().contains("Astics")) {
            try {
                String[] separated = rawResult.getContents().trim().split(":");
                 Intent intent = new Intent(getBaseContext(), SplshActivity.class);
                 intent.putExtra("id", separated[1]);
                intent.putExtra("table", separated[2]);
        startActivity(intent);
            } catch (Exception e) {

            }
        }
       /* Intent intent = new Intent(getBaseContext(), ScrollableTabsActivity.class);
        intent.putExtra("EXTRA_SESSION_ID", rawResult.getContents());
        startActivity(intent);*/
    }
    private void GetCategoryData() {
        cartItems.clear();
        Category c1=new Category();
        c1.set_id(1);
        c1.set_name("Drinks");

        Category c2=new Category();
        c2.set_id(2);
        c2.set_name("Junk Food");

        Item i1=new Item();
        i1.set_id(1);
        i1.set_name("Coke");
        i1.addSize("500ML");
        i1.set_price("5.00");
        i1.set_desciprion("none");
        i1.set_category(c1);

        Item i2=new Item();
        i2.set_id(2);
        i2.set_name("Pepsi");
        i2.addSize("500ML");
        i2.set_price("5.00");
        i2.set_desciprion("none");
        i2.set_category(c1);

        Item i3=new Item();
        i3.set_id(3);
        i3.set_name("Water");
        i3.addSize("500ML");
        i3.set_price("5.00");
        i3.set_desciprion("none");
        i3.set_category(c1);

        ArrayList<Item> item_list1=new ArrayList<>();
        item_list1.add(i1);
        item_list1.add(i2);
        item_list1.add(i3);
        c1.set_items(item_list1);



        Item i4=new Item();
        i4.set_id(4);
        i4.set_name("hamburger");
        i4.addSize("Small");
        i4.set_price("5.00");
        i4.set_desciprion("none");
        i4.set_category(c2);

        Item i5=new Item();
        i5.set_id(5);
        i5.set_name("fries");
        i5.addSize("Small");
        i5.set_price("5.00");
        i5.set_desciprion("none");
        i5.set_category(c2);

        Item i6=new Item();
        i6.set_id(6);
        i6.set_name("pizza");
        i6.addSize("large");
        i6.set_price("5.00");
        i6.set_desciprion("none");
        i6.set_category(c2);

        ArrayList<Item> item_list2=new ArrayList<>();
        item_list2.add(i4);
        item_list2.add(i5);
        item_list2.add(i6);
        c2.set_items(item_list2);
        ExpListItems.clear();
        ExpListItems.add(c1);
        ExpListItems.add(c2);



    }

    private void requestCameraPermission() {
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA);
        } else {
            mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
            mScannerView.startCamera();          // Start camera on resume
        }
    }



    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CAMERA) {

            // Received permission result for camera permission.est.");
            // Check if the only required permission has been granted
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Camera permission has been granted, preview can be displayed
               /* Snackbar.make(mLayout, R.string.permision_available_camera,
                        Snackbar.LENGTH_SHORT).show();*/
                mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
                mScannerView.startCamera();          // Start camera on resume

            } else {
              /*  Snackbar.make(mLayout, R.string.permissions_not_granted,
                        Snackbar.LENGTH_SHORT).show();*/
                Toast.makeText(getApplicationContext(),"unable to start camera",Toast.LENGTH_LONG).show();

            }
        }
    }

}
