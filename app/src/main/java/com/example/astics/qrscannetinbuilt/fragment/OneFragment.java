package com.example.astics.qrscannetinbuilt.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.astics.qrscannetinbuilt.Adapter.MyRecyclerViewAdapter;
import com.example.astics.qrscannetinbuilt.MainActivity;
import com.example.astics.qrscannetinbuilt.Model.DataObject;
import com.example.astics.qrscannetinbuilt.Model.Item;
import com.example.astics.qrscannetinbuilt.R;

import java.util.ArrayList;


public class OneFragment extends Fragment {

    private static String LOG_TAG = "CardViewActivity";
    private int id=0;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {    super.onCreate(savedInstanceState);    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        Bundle bundle = this.getArguments();

        try {
            id = Integer.parseInt(bundle.getString("ID"));
            Log.e("Id recived", String.valueOf(id));
        } catch (Exception var15) {
            id = 1;
            Log.e("Id ", String.valueOf(id));
        }

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    public ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
       /* for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }*/
        ArrayList<Item> items= MainActivity.ExpListItems.get(id-1).get_items();
        for (Item i1:items) {
            DataObject obj = new DataObject(i1.get_name(),
                    "Size: "+i1.getSize().get(0)+"  Price: $" + i1.get_price());
            obj.setIsChecked(false);
            obj.set_name(i1.get_name());
            obj.set_price(i1.get_price());
            obj.set_quantity(1);
            obj.set_id(i1.get_id());
            obj.set_size(i1.getSize().get(0));
            results.add(obj);

        }

        return results;
    }

}
