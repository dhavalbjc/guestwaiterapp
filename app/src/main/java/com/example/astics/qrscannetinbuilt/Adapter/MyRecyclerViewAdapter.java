package com.example.astics.qrscannetinbuilt.Adapter;

/**
 * Created by Astics INC-08 on 04-Aug-16.
 */


import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astics.qrscannetinbuilt.MainActivity;
import com.example.astics.qrscannetinbuilt.Model.CartItem;
import com.example.astics.qrscannetinbuilt.Model.DataObject;
import com.example.astics.qrscannetinbuilt.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private static MyClickListener myClickListener;
    private ArrayList<DataObject> mDataset;

    public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {
        holder.label.setText(mDataset.get(position).getmText1());
        holder.dateTime.setText(mDataset.get(position).getmText2());
        holder.mSolvedCheckBox.setChecked(mDataset.get(position).getIsChecked());

        holder.mSolvedCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDataset.get(position).getIsChecked()){
                    mDataset.get(position).setIsChecked(false);

                }else {
                    mDataset.get(position).setIsChecked(true);
                }
                final Boolean value=holder.mSolvedCheckBox.isChecked();
                Log.e("Cllaed", String.valueOf(value));
                if(value){
                    if( !MainActivity.cartItems.containsKey(String.valueOf(mDataset.get(position).get_id()))) {
                        Log.e("Item","Added");
                        CartItem ci = new CartItem();
                        ci.set_id(mDataset.get(position).get_id());
                        ci.set_name(mDataset.get(position).get_name());
                        ci.set_price(mDataset.get(position).get_price());
                        ci.set_quantity(mDataset.get(position).get_quantity());
                        ci.set_size(mDataset.get(position).get_size());
                        MainActivity.cartItems.put(String.valueOf(mDataset.get(position).get_id()), ci);
                    }
                }
                else{
                    if (MainActivity.cartItems.containsKey(String.valueOf(mDataset.get(position).get_id()))) {
                        Log.e("Item","Removed");
                        MainActivity.cartItems.remove(String.valueOf(mDataset.get(position).get_id()));
                    }
                }
            }
        });
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        AppCompatCheckBox mSolvedCheckBox;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
             mSolvedCheckBox = (AppCompatCheckBox) itemView
                    .findViewById(R.id.tintcheckbox);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
