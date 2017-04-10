package com.example.astics.qrscannetinbuilt;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemlistFragment extends Fragment {
	  static testnew adapter=null;
	 public Context context;
	MyReceiver r;
	  ExpandableListView listView;
	  ArrayList<Item> groups=null ;
	  ArrayList<CartItems> CartGroups=new ArrayList<CartItems>() ;
	private int id;
	 private int lastExpandedPosition = -1;

	 //TextView t;
	@Override
	public View onCreateView(LayoutInflater inflater, final ViewGroup container,
							 Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.no_main_elist, container, false);
		
		
		 Bundle bundle = getArguments();
	        id = Integer.parseInt(bundle.getString("ID"));
	   //   t=(TextView) rootView.findViewById(R.id.textView12);
	       listView = (ExpandableListView) rootView.findViewById(R.id.exp_list_no);
	      
	       listView.setOnGroupExpandListener(new OnGroupExpandListener() {

	    	    @Override
	    	    public void onGroupExpand(int groupPosition) {
	    	            if (lastExpandedPosition != -1
	    	                    && groupPosition != lastExpandedPosition) {
	    	            	listView.collapseGroup(lastExpandedPosition);
	    	            }
	    	            lastExpandedPosition = groupPosition;
	    	    }
	    	});
	  	  ArrayList<Extra> _extra=null;
	  	  CartGroups.clear();
	       
	  	try{
	           groups =DBAdapter.getComboItems(id);
	           for(Item i:groups)
	           {
	          	 
	          	 try{
	          		 /*
	          		 _extra=DBAdapter.getExtrasbyItemId(i.get_id());
	          		 ArrayList<Item> _extra_items=DBAdapter.getItemsbyCatIdnFlagOff(id);
	              	 for(Item i1:_extra_items)
	              	     i.addExtra(i1);
	              	 for(Extra e1:_extra)            	 
	              		 i.addExtra(e1);
	              	 
	          	// i.set_extra(_extra);
	          	 
	          	 for(Extra y:_extra)
	       			y.set_item(i);
	          	 */
	          		 CartItems cart_item=new CartItems();
	              	 cart_item.set_item(i);
	              	 cart_item.set_quantity(0);
	              	 cart_item.set_mark(0);
	              	 boolean isAdded=false;
	              	// Toast.makeText(container.getContext(),i.get_name(), Toast.LENGTH_LONG).show();
	              	 if(newOrderActivity.markHash.containsKey(i.get_name())){
	              		 int count= Integer.parseInt((newOrderActivity.markHash.get(i.get_name())));
	              		 for (int j=1;j<=count;j++) {
	              			 if(newOrderActivity.myCartItemsWithExtras.containsKey(i.get_name()+ String.valueOf(j))){
	              				CartItems cart_item2=newOrderActivity.myCartItemsWithExtras.get(i.get_name()+ String.valueOf(j));
	  	                      
	              				CartItems cart_item1=new CartItems();
	                      	 cart_item1.set_item(i);
	                      	 cart_item1.set_quantity(1);
	                      	 cart_item1.set_mark(j);
	                      	cart_item1.set_course(cart_item2.get_course());
	                      	cart_item1.set_status(cart_item2.get_status());
	                      	 CartGroups.add(cart_item1);
	                      	 isAdded=true;
	              			 }
	                      	 
	                      	// Toast.makeText(container.getContext(),i.get_name()+"1", Toast.LENGTH_LONG).show();
	      				}
	              		 
	              	 }
	              	/* if(newOrderActivity.myCartHash.containsKey(i.get_name()))
	              	 {
	              		// Toast.makeText(container.getContext(),i.get_name(), Toast.LENGTH_LONG).show();
	              		// cart_item.set_quantity(1);
	              		 CartItems citem=newOrderActivity.myCartHash.get(i.get_name());
	              		 
	              		 cart_item.set_quantity(citem.get_quantity());
	              		 cart_item.set_mark(citem.get_mark());
	              		cart_item.set_course(citem.get_course());
	              		cart_item.set_status(citem.get_status());
	              		 isAdded=true;
	              		 CartGroups.add(cart_item);
	              		// Toast.makeText(container.getContext(),i.get_name()+"2", Toast.LENGTH_LONG).show();
	              		// CartGroups.add(cart_item);
	              	 }*/
	              	 for (int j=0;j<=5;j++) {
	            		 if(newOrderActivity.myCartHash.containsKey(i.get_name()+ String.valueOf(j)))
	                  	 {
	                  		// Toast.makeText(container.getContext(),i.get_name(), Toast.LENGTH_LONG).show();
	                  		// cart_item.set_quantity(1);
	            			 CartItems citem=newOrderActivity.myCartHash.get(i.get_name()+ String.valueOf(j));
	                   		CartItems cart_item1=new CartItems();
	                      	 cart_item1.set_item(i);
	                      	cart_item1.set_quantity(citem.get_quantity());
	                      	cart_item1.set_mark(citem.get_mark());
	                      	cart_item1.set_course(citem.get_course());
	                      	cart_item1.set_status(String.valueOf(j));
	                   		 isAdded=true;
	                   		 CartGroups.add(cart_item1);
	                  		// Toast.makeText(container.getContext(),i.get_name()+"2", Toast.LENGTH_LONG).show();
	                  		// CartGroups.add(cart_item);
	                  	 }
					}
	              	 if(!isAdded ){
	              		 CartGroups.add(cart_item);
	              	 }
	          	
	          	// Toast.makeText(container.getContext(),i.get_name(), Toast.LENGTH_LONG).show();
	          	
	          
	          	 
	          	 }
	          	 catch(Exception e)
	          	 {
	          		 Toast.makeText(container.getContext(), e.toString(), Toast.LENGTH_LONG).show();
	          	 }
	           }
	          }
	          catch(Exception e)
	          {

	     		 Toast.makeText(container.getContext(), e.toString(), Toast.LENGTH_LONG).show();
	          }
	// CustomExpandableListAdapter adapter=null;
        adapter = new testnew(container.getContext(),CartGroups,getWidth(),"c");
        adapter.areAllItemsEnabled();
                listView.setAdapter(adapter);
                listView.setGroupIndicator(null);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
										int groupPosition, long id) {
				// TODO Auto-generated method stub
			/*	Item group = (Item) adapter.getGroup(groupPosition);
				Toast
	            .makeText(container.getContext(), group.get_name(), Toast.LENGTH_SHORT)
	            .show();*/
				// Item_selected.activityCallback.onButtonClick();
				return true;
			}
		
		    });
         
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
              /*  Extra child = (Extra) adapter.getChild(groupPosition, childPosition);
         
                Toast
                    .makeText(container.getContext(), child.get_name(), Toast.LENGTH_SHORT)
                    .show();
         */
           // 	 Item_selected.activityCallback.onButtonClick();
                return true;
            }
        });
       
   
		return rootView;
	}
	@Override
	public void onResume()
	{
		super.onResume(); 
		 r = new MyReceiver();
		    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(r,
		            new IntentFilter("TAG_REFRESH"));
		//CartGroups.clear();
	//t.setText("oh");
	
		//adapter.notifyDataSetChanged();
		
	}
	@Override
	public void onPause() {
	    super.onPause();
	    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(r);
	}
	public void refreshMe()
	{
	//	t.setText("Bye");
		//adapter.notifyDataSetChanged();
	}
	public  int getWidth()
	 {try 
   {
       
		 Display display = getActivity().getWindowManager().getDefaultDisplay();
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
	private class MyReceiver extends BroadcastReceiver {
	    @Override
	    public void onReceive(Context context, Intent intent) {
	    	CartGroups.clear();
	    	//Toast.makeText(getActivity(),"Refresh",Toast.LENGTH_LONG).show();
			try{
		       //  groups =DBAdapter.getItemsbyCatIdnFlag(id);
		         for(Item i:groups)
		         {	        	 
		        	 try{
		        		 CartItems cart_item=new CartItems();
		            	 cart_item.set_item(i);
		            	 cart_item.set_quantity(0);
		            	 cart_item.set_mark(0);
		            	 boolean isAdded=false;
		            	// Toast.makeText(container.getContext(),i.get_name(), Toast.LENGTH_LONG).show();
		            	 if(newOrderActivity.markHash.containsKey(i.get_name())){
		            		 int count= Integer.parseInt((newOrderActivity.markHash.get(i.get_name())));
		            		 for (int j=1;j<=count;j++) {
		            			 if(newOrderActivity.myCartItemsWithExtras.containsKey(i.get_name()+ String.valueOf(j))){
		            		
		            				 CartItems cart_item2=newOrderActivity.myCartItemsWithExtras.get(i.get_name()+ String.valueOf(j));
			  	                      
			              				CartItems cart_item1=new CartItems();
			                      	 cart_item1.set_item(i);
			                      	 cart_item1.set_quantity(1);
			                      	 cart_item1.set_mark(j);
			                      	cart_item1.set_course(cart_item2.get_course());
			                      	cart_item1.set_status(cart_item2.get_status());
			                      	 CartGroups.add(cart_item1);
			                      	 isAdded=true;
		            			 }
		                    	 
		                    	// Toast.makeText(container.getContext(),i.get_name()+"1", Toast.LENGTH_LONG).show();
		    				}
		            		 
		            	 }
		            	 for (int j=0;j<=5;j++) {
		            		 if(newOrderActivity.myCartHash.containsKey(i.get_name()+ String.valueOf(j)))
		                  	 {
		                  		// Toast.makeText(container.getContext(),i.get_name(), Toast.LENGTH_LONG).show();
		                  		// cart_item.set_quantity(1);
		            			 CartItems citem=newOrderActivity.myCartHash.get(i.get_name()+ String.valueOf(j));
		                   		CartItems cart_item1=new CartItems();
		                      	 cart_item1.set_item(i);
		                      	cart_item1.set_quantity(citem.get_quantity());
		                      	cart_item1.set_mark(citem.get_mark());
		                      	cart_item1.set_course(citem.get_course());
		                      	cart_item1.set_status(String.valueOf(j));
		                   		 isAdded=true;
		                   		 CartGroups.add(cart_item1);
		                  		// Toast.makeText(container.getContext(),i.get_name()+"2", Toast.LENGTH_LONG).show();
		                  		// CartGroups.add(cart_item);
		                  	 }
						}
		            	 if(!isAdded ){
		            		 CartGroups.add(cart_item);
		            	 }
		            	
		            
		        	 }
		        	 catch(Exception e)
		        	 {
		        		//	t.setText("prob 1");
		        		 //Toast.makeText(container.getContext(), e.toString(), Toast.LENGTH_LONG).show();
		        	 }
		         }
		        }
		        catch(Exception e)
		        {
		        //	t.setText("prob 2");
//		   		 Toast.makeText(container.getContext(), e.toString(), Toast.LENGTH_LONG).show();
		        }
			
			//CustomExpandableListAdapter adapter=null;
		      //  adapter = new CustomExpandableListAdapter(context, CartGroup);
		       // adapter.areAllItemsEnabled();
			
		         //       listView.setAdapter(adapter);
		           //     listView.setGroupIndicator(null);
		
			adapter.notifyDataSetChanged();
	    }
	}
	
}
