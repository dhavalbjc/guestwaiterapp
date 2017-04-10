package com.example.astics.qrscannetinbuilt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteCustomArrayAdapter extends ArrayAdapter<Item> implements Filterable {
     private List<Item> entries;
     private ArrayList<Item> orig;
     private Activity activity;
     private ArrayFilter myFilter;

     public AutocompleteCustomArrayAdapter(Context context, int textViewResourceId, ArrayList<Item> entries) {
      super(context, textViewResourceId, entries);
      this.entries = entries;
      this.activity = (Activity) context;
    }

    @Override
    public int getCount(){
        return entries!=null ? entries.size() : 0;
    }

    @Override
    public Item getItem(int index) {
      return entries.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


      View v = convertView;
      ViewHolder holder;
      if (v == null) {
          LayoutInflater vi =
              (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          v = vi.inflate(R.layout.list_view_row, null);
          holder = new ViewHolder();
          holder.tv_ac_name = (TextView) v.findViewById(R.id.textViewItem);
         // holder.tv_ac_desg = (TextView) v.findViewById(R.id.ac_desg);
          //holder.tv_ac_org = (TextView) v.findViewById(R.id.ac_org);
          //holder.tv_ac_dept = (TextView) v.findViewById(R.id.ac_dept);
          //holder.tv_ac_name.setBackgroundColor(Color.YELLOW);
          v.setTag(holder);
      }
      else
          holder=(ViewHolder)v.getTag();

      final Item custom = entries.get(position);
      if (custom != null) {
          holder.tv_ac_name.setText(custom.get_name());

      }
      return v;
    }

    @Override
    public Filter getFilter() {
      if (myFilter == null){
          myFilter = new ArrayFilter();
      }
      return myFilter;
    }

    @Override
    public String toString() {
      String temp = getClass().getName();
      return temp;
    }

    public static class ViewHolder{
      public TextView tv_ac_name;
      public TextView tv_ac_desg;
      public TextView tv_ac_org;
      public TextView tv_ac_dept;
    }

    private class ArrayFilter extends Filter {
      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
           FilterResults results = new FilterResults();
          try{

          if (orig == null)
              orig = new ArrayList<Item>(entries);
          if (constraint != null && constraint.length() != 0) {
              ArrayList<Item> resultsSuggestions = new ArrayList<Item>();
              for (int i = 0; i < orig.size(); i++) {
                 /* if(orig.get(i).get_name().toLowerCase().startsWith(constraint.toString().toLowerCase())){
                      resultsSuggestions.add(orig.get(i));
                  }*/
                  if(orig.get(i).get_name().toLowerCase().contains(constraint.toString().toLowerCase())){
                      resultsSuggestions.add(orig.get(i));
                  }
              }

              results.values = resultsSuggestions;
              results.count = resultsSuggestions.size();

          }
          else {
              ArrayList<Item> list = new ArrayList<Item>(orig);
              results.values = list;
              results.count = list.size();
          }
          }
          catch(Exception e)
          {

          }
          return results;

      }

      @Override
      @SuppressWarnings("unchecked")
      protected void publishResults(CharSequence constraint, FilterResults results) {
          clear();
          ArrayList<Item> newValues = (ArrayList<Item>) results.values;
          if(newValues !=null) {
              for (int i = 0; i < newValues.size(); i++) {
                  add(newValues.get(i));
              }
              if(results.count>0) {
                  notifyDataSetChanged();
              } else {
                  notifyDataSetInvalidated();
              }
          }

      }

    }
}
