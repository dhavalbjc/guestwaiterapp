package com.example.astics.qrscannetinbuilt;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.astics.qrscannetinbuilt.Model.CartItem;
import com.example.astics.qrscannetinbuilt.Model.Category;
import com.example.astics.qrscannetinbuilt.fragment.OneFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

       // toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        int count=0;
        for (Category cat:MainActivity.ExpListItems) {


                Log.e("one","called");
                int id = cat.get_id();
                Bundle bundle = new Bundle();
                bundle.putString("ID", String.valueOf(id));
                Log.e("Id sent", String.valueOf(id));
                OneFragment swipeTabFragment = new OneFragment();
                swipeTabFragment.setArguments(bundle);
                adapter.addFrag(swipeTabFragment, cat.get_name());


        }
       // adapter.addFrag(new OneFragment(), "ONE");
       // adapter.addFrag(new TwoFragment(), "TWO");
       /* adapter.addFrag(new ThreeFragment(), "THREE");
        adapter.addFrag(new FourFragment(), "FOUR");
        adapter.addFrag(new FiveFragment(), "FIVE");
        adapter.addFrag(new SixFragment(), "SIX");
        adapter.addFrag(new SevenFragment(), "SEVEN");
        adapter.addFrag(new EightFragment(), "EIGHT");
        adapter.addFrag(new NineFragment(), "NINE");
        adapter.addFrag(new TenFragment(), "TEN");*/

        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grid_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // About option clicked.
                Log.e("called", "Send");
                StringBuilder order = new StringBuilder();
                String msg="";
                order.append(System.getProperty("line.separator"));
                order.append(System.getProperty("line.separator"));
                order.append("Restaurant Order");
                order.append(System.getProperty("line.separator"));
                for (HashMap.Entry<String, CartItem> entry : MainActivity.cartItems.entrySet()) {
                    String key = entry.getKey();
                    CartItem value = entry.getValue();
                    order.append(value.get_quantity()+" ");
                    order.append(value.get_name()+" ");

                    order.append(value.get_size()+" ");
                    order.append(System.getProperty("line.separator"));
                    Log.e("Added " + key, value.get_name());
                    msg="true";
                }
                if (!msg.toString().equals("")) {
                    if (Build.VERSION.SDK_INT >= 11) {
                       // new serverRequest().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, android.os.Build.MANUFACTURER,order.toString());
                    }
                    //task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,pass.getText().toString(),textSSID.getText().toString());
                    else {
                       // new serverRequest().execute(android.os.Build.MANUFACTURER, order.toString());
                    }
                    MainActivity.cartItems.clear();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Select Item", Toast.LENGTH_LONG).show();
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
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

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
   /* private class serverRequest extends AsyncTask<String, String, JSONObject> {
        @Override
        protected void onPreExecute() {


        }
        @Override
        protected JSONObject doInBackground(String... args) {
            JSONParser json = new JSONParser();
            Log.e("inserver", "inserver");
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("from", args[0]));
            params.add(new BasicNameValuePair("msg", args[1]));



            //JSONObject jObj = json.getJSONFromUrl("http://192.168.0.231:3000/validateDevice",params);
            JSONObject jObj = json.getJSONFromUrl("http://52.9.194.136:3000/sendMessage", params);

            Log.e("Validate jobj", String.valueOf(jObj));
            return jObj;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
//if90
            // Toast.makeText(getApplicationContext(),"Sent", Toast.LENGTH_SHORT).show();
            if(json==null){
                json=new JSONObject();
                // progress.dismiss();
                // Toast.makeText(Login.this,"Server not responding", Toast.LENGTH_SHORT).show();
            }
            if (json != null) {

            }
        }


    }*/
}
