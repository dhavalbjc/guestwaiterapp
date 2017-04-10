package com.example.astics.qrscannetinbuilt;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class testnew extends BaseExpandableListAdapter {
	 
   // private boolean checkSelected=false;
   // public static LinkedHashMap<String,Boolean> checkSelected = new LinkedHashMap< String,Boolean>();
//    LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(mContext);
     Intent i = new Intent("TAG_REFRESH");
    private Context mContext;
    private ArrayList<CartItems> mGroups;
    private LayoutInflater mInflater;
    private int count=0;
    private String conVal;
    private int dialogwidth=450;
  //  public static LinkedHashMap<String, Boolean> myCartHash = new LinkedHashMap<String, CartItems>();
    public testnew(Context context, ArrayList<CartItems> groups, int dWidth, String conValue) {
        mContext = context;
        mGroups = groups;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dialogwidth=dWidth;
        conVal=conValue;
        
    }
 
    @Override
    public int getGroupCount() {
        return mGroups.size();
    }
 
    @Override
    public int getChildrenCount(int groupPosition) {
        
       
        	return mGroups.get(groupPosition).get_item().get_extra().size()+1;
    	
    }
 
    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }
 
    @Override
    public Object getChild(int groupPosition, int childPosition) {
    	
     return mGroups.get(groupPosition).get_item().get_extra().get(childPosition);
    	
        
    }
 
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }
 
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }
 
    @Override
    public boolean hasStableIds() {
        return false;
    }
 
    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, final ViewGroup parent) {
    	 final CartItems group = (CartItems) getGroup(groupPosition);
    	 convertView = mInflater.inflate(R.layout.no_item, parent,false);
    	 final View viewcopy=convertView;
    	 ListView lv_sextra=(ListView) convertView.findViewById(R.id.lv_sextra);
    	 ArrayList<Extra> extrasArrayList =new ArrayList<Extra>();
    	 for (Extra extra : mGroups.get(groupPosition).get_item().get_extra()) {
    		 if(newOrderActivity.itemExtra.containsKey(mGroups.get(groupPosition).get_item().get_name()+mGroups.get(groupPosition).get_status()+ String.valueOf(mGroups.get(groupPosition).get_mark())+extra.get_name())){
    			 if(!isExpanded){
    			 extrasArrayList.add(extra);
    			 }
    		 }
		}
    	 showExtraAdapterSecond adapter=new showExtraAdapterSecond(mContext, extrasArrayList,mGroups.get(groupPosition),parent,groupPosition,mGroups);
    	 lv_sextra.setAdapter(adapter);
    	 Helper.getListViewSize(lv_sextra);
    	/* if(isExpanded){
    		 lv_sextra.setVisibility(View.GONE); 
    	 }
    	 else{
    		 lv_sextra.setVisibility(View.VISIBLE); 
    		 Helper.getListViewSize(lv_sextra);
    	 }*/
    	// Toast.makeText(mContext, isExpanded.toString(),Toast.LENGTH_LONG).show();
       /* if (convertView == null) {
            if(group.get_quantity()>0)
            {
            	 convertView = mInflater.inflate(R.layout.is_selecteditem_layout, parent,false);
            	
            }
            else{
            convertView = mInflater.inflate(R.layout.no_item, parent,false);
            }
            
        }*/
    	
         
        // Get the group item
       
    	/* ArrayList<Extra> es =group.get_item().get_extra();
 		//ArrayList<Extra> es1=new ArrayList<Extra>();
 		for (Extra extra : es) {
 			if(newOrderActivity.itemExtra.containsKey(extra))
 			{
 				checkSelected=true;
 			//	es1.add(extra); 					
 				
 			}						
 		}
 		if(checkSelected)
 		{
 			if(!isExpanded)
				 ((ExpandableListView) parent).expandGroup(groupPosition);
		}
 			
 		checkSelected=false;*/
 		
        // Set group name
    	 
        final TextView textView = (TextView) convertView.findViewById(R.id.tv_no_itemname);
        final TextView plusebtn = (TextView) convertView.findViewById(R.id.tv_no_pluse);
      //  final TextView minusbtn = (TextView) convertView.findViewById(R.id.tv_no_minus);
        textView.setText(group.get_item().get_name());
        if(group.get_status().equals("5"))
        	textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        final RelativeLayout expandcollesp =(RelativeLayout) convertView.findViewById(R.id.Rel_no_item_click);
        final RelativeLayout pluse=(RelativeLayout)convertView.findViewById(R.id.Rel_Item_plus);
       // final RelativeLayout rel_item_name=(RelativeLayout)convertView.findViewById(R.id.Rel_no_item_click);
        
        final RelativeLayout minus=(RelativeLayout)convertView.findViewById(R.id.Rel_Item_minus);
        minus.setVisibility(View.GONE);
        final ImageView imgView = (ImageView) convertView.findViewById(R.id.no_add_button_imag);
        //minus.setEnabled(false);
       // minus.setVisibility(100);
        //RelativeLayout
        LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
      //  childParam1.setMargins(0, 0, 2, 2);
        childParam1.weight = 85f;
        expandcollesp.setLayoutParams(childParam1);
        final Resources res = convertView.getResources();
        
        LinearLayout.LayoutParams childParam12 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
		//childParam12.setMargins(0, 0, 0, 2);
        childParam12.weight = 15f;
        minus.setLayoutParams(childParam12);
        
        LinearLayout.LayoutParams childParam121 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
	//	childParam121.setMargins(0, 0, 2, 2);
        childParam121.weight = 15f;
        pluse.setLayoutParams(childParam121);
        ImageView imgminus=(ImageView) convertView.findViewById(R.id.tv_no_minus);
        
        int status= Integer.parseInt(group.get_status());
        int resId;
        
		switch(status){
        
        case 0:
        	 resId=viewcopy.getResources().getIdentifier("com.example.astics.qrscannetinbuilt:drawable/minus_arrow",null,null);
			imgminus.setImageResource(resId);
			imgminus.setAlpha(0.5f);
        	break;
        case 1:
        	 resId=viewcopy.getResources().getIdentifier("com.example.astics.qrscannetinbuilt:drawable/status_cookhat",null,null);
			imgminus.setImageResource(resId);
        	break;
        case 2:
        	 resId=viewcopy.getResources().getIdentifier("com.example.astics.qrscannetinbuilt:drawable/status_coking",null,null);
			imgminus.setImageResource(resId);
        	break;
        case 3:
        	 resId=viewcopy.getResources().getIdentifier("com.example.astics.qrscannetinbuilt:drawable/status_ready",null,null);
			imgminus.setImageResource(resId);
        	break;
        case 4:
        	 resId=viewcopy.getResources().getIdentifier("com.example.astics.qrscannetinbuilt:drawable/status_served",null,null);
			imgminus.setImageResource(resId);
        	break;
        case 5:
        	 resId=viewcopy.getResources().getIdentifier("com.example.astics.qrscannetinbuilt:drawable/status_cancelled",null,null);
			imgminus.setImageResource(resId);
        	break;
        	
        }
        
        
        
       // Toast.makeText(mContext,"ok",Toast.LENGTH_LONG).show();
        if(group.get_quantity()>0)
        {
        	//Drawable drawable = res.getDrawable(R.drawable.is_background_selector); //new Image that was added to the res folder
			 minus.setVisibility(View.VISIBLE);
			 imgView.setVisibility(View.GONE);
			// expandcollesp.setBackgroundDrawable(drawable);
			// expandcollesp.setBackgroundColor(Color.rgb(25, 222,178));
			// Drawable drawable1 = res.getDrawable(R.drawable.newbackground_small_corners);
			 expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
			 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
			 
			 //pluse.setBackgroundDrawable(drawable);
			 //expandcollesp.setBackgroundDrawable(drawable);
			plusebtn.setText(String.valueOf(group.get_quantity()));
			//(group.get_item().get_category().get_id());
			LinearLayout.LayoutParams childParam11 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
			//childParam11.setMargins(0, 0, 2, 2);
	        childParam11.weight = 70f;	        
	        expandcollesp.setLayoutParams(childParam11);
	        
	  ArrayList<Extra> ex=group.get_item().get_extra();
        	for(Extra e:ex)
        	{
        		if(newOrderActivity.itemExtra.containsKey(e.get_item().get_name()+e.get_name()))
        		{
        		//Extra e1=(Extra)	getChild(groupPosition, 0);
        			 
        		
        		//v.findViewById(id)
        		//	ExpandableListView mExpandableListView = (ExpandableListView) parent;
        		  //  mExpandableListView.expandGroup(groupPosition);
        		    
        		}
        		else
        		{

        			//ExpandableListView mExpandableListView = (ExpandableListView) parent;
        		    //mExpandableListView.collapseGroup(groupPosition);
        		}
        	}
        }
        pluse.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				final Dialog dialog = new Dialog(mContext);
				 dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				 dialog.setContentView(R.layout.add_x);
				 TextView add_x=(TextView) dialog.findViewById(R.id.tv_add_x);
				 add_x.setText("Add x "+group.get_item().get_name());
				 RelativeLayout _1=(RelativeLayout) dialog.findViewById(R.id.Rel_is_1);
				 RelativeLayout _2=(RelativeLayout) dialog.findViewById(R.id.Rel_is_2);
				 RelativeLayout _3=(RelativeLayout) dialog.findViewById(R.id.Rel_is_3);
				 RelativeLayout _4=(RelativeLayout) dialog.findViewById(R.id.Rel_is_4);
				 RelativeLayout _5=(RelativeLayout) dialog.findViewById(R.id.Rel_is_5);
				 RelativeLayout _6=(RelativeLayout) dialog.findViewById(R.id.Rel_is_6);
				 RelativeLayout _7=(RelativeLayout) dialog.findViewById(R.id.Rel_is_7);
				 RelativeLayout _8=(RelativeLayout) dialog.findViewById(R.id.Rel_is_8);
				 RelativeLayout _9=(RelativeLayout) dialog.findViewById(R.id.Rel_is_9);
				 RelativeLayout _10=(RelativeLayout) dialog.findViewById(R.id.Rel_is_10);
				 RelativeLayout _11=(RelativeLayout) dialog.findViewById(R.id.Rel_is_11);
				 RelativeLayout _12=(RelativeLayout) dialog.findViewById(R.id.Rel_is_12);
				 RelativeLayout _13=(RelativeLayout) dialog.findViewById(R.id.Rel_is_13);
				 RelativeLayout _14=(RelativeLayout) dialog.findViewById(R.id.Rel_is_14);
				 RelativeLayout _15=(RelativeLayout) dialog.findViewById(R.id.Rel_is_15);
				 RelativeLayout _16=(RelativeLayout) dialog.findViewById(R.id.Rel_is_16);
				 RelativeLayout _17=(RelativeLayout) dialog.findViewById(R.id.Rel_is_17);
				 RelativeLayout _18=(RelativeLayout) dialog.findViewById(R.id.Rel_is_18);
				 RelativeLayout _19=(RelativeLayout) dialog.findViewById(R.id.Rel_is_19);
				 RelativeLayout _20=(RelativeLayout) dialog.findViewById(R.id.Rel_is_20);
				 RelativeLayout _21=(RelativeLayout) dialog.findViewById(R.id.Rel_is_21);
				/* RelativeLayout _22=(RelativeLayout) dialog.findViewById(R.id.Rel_is_22);
				 RelativeLayout _23=(RelativeLayout) dialog.findViewById(R.id.Rel_is_23);
				 RelativeLayout _24=(RelativeLayout) dialog.findViewById(R.id.Rel_is_24);*/
				 RelativeLayout rel_cancel=(RelativeLayout) dialog.findViewById(R.id.Rel_cancel);
				 rel_cancel.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
					dialog.dismiss();	
					}
				});
				 RelativeLayout.OnClickListener tableSelected
				 = new RelativeLayout.OnClickListener(){

				 @Override
				 public void onClick(View arg0) {
				  // TODO Auto-generated method stub
					
					 //Toast.makeText(getBaseContext(), "Colosed", Toast.LENGTH_SHORT).show();
					 RelativeLayout rl = (RelativeLayout) arg0;
	                    TextView tv = (TextView) rl.getChildAt(0);
					int qty= Integer.parseInt(tv.getText().toString());
	                	try{
	    					//checkSelected=true;
	    				//Drawable drawable = res.getDrawable(R.drawable.is_background_selector); //new Image that was added to the res folder
	    					 minus.setVisibility(View.VISIBLE);
	    					 imgView.setVisibility(View.GONE);
	    					 
	    					// pluse.setBackgroundDrawable(drawable);
	    					 expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
	    					 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
	    					 
	    					// expandcollesp.setBackgroundDrawable(drawable);
	    					// group.get_item().get_name();
	    					//Boolean b= newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status());
	    				//	 Toast.makeText(mContext,String.valueOf(b),Toast.LENGTH_LONG).show();
	    					
	    	                    if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
	    	                    	
	    	                    	int _quantity;
	    	        	        	_quantity=group.get_quantity();
	    	        	        	_quantity+=qty;
	    	        	        	//newOrderActivity.cartItems.remove(group);
	    	        	        	group.set_quantity(_quantity);
	    	        	        	newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status()).set_quantity(_quantity);
	    	        	        	//newOrderActivity.cartItems.add(group);
	    	        	        	newOrderActivity.changed=true;
	    	        	        	Item_selected.Payment_option.setVisibility(View.GONE);
	    	        	        	// newOrderActivity.cartItems.
	    	        	        	
	    	        	        	 plusebtn.setText(String.valueOf(_quantity));
	    	        	        	// reload(group.get_item().get_category().get_id());
	    	        		       // Item_selected.cartItemadapter1.notifyDataSetChanged();
	    	        	        	//GamesFragment.ExpAdapter.notifyDataSetChanged();
	    	        		        
	    	                 
	    	                    }
	    	                    else {
	    	                    	Item i1=new Item();
	    	                    	i1=group.get_item();
	    	                    	//i1.set_id()
	    	                    	 CartItems c=new CartItems();	                    	 
	    	                         c.set_item(i1);
	    	                		
	    	                         group.set_quantity(qty);
	    	                         
	    	                         c.set_quantity(qty);
	    	                         c.set_mark(0);
	    	                        
	    	                    	 newOrderActivity.myCartHash.put(group.get_item().get_name()+group.get_status(), c);
	    	                    	 newOrderActivity.changed=true;
	    	                    	 Item_selected.Payment_option.setVisibility(View.GONE);
	    	                    	 newOrderActivity.cartItems.add(c);
	    	                    	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
	    	                    	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
	    	                    	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
	    	                    	// Helper.getListViewSize(Item_selected.listView);
	    	                    	// newOrderActivity.mycart.setProducts(c);
	    	                    	 plusebtn.setText(String.valueOf(qty));
	    	                    
	    	                    	 LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
	    	                         childParam1.weight = 70f;
	    	                         //childParam1.setMargins(0, 0, 2, 2);
	    	                         expandcollesp.setLayoutParams(childParam1);
	    	                         
	    	                          
	    	                        	// lbm.sendBroadcast(i);
	    	                         ((ExpandableListView) parent).collapseGroup(groupPosition);
		                        	  ((ExpandableListView) parent).expandGroup(groupPosition);
	    	                         
	    						}
	    	                    
	    	                    Item_selected.cartItemadapter1.notifyDataSetChanged();
	    	                    
	                        	 
	                        	ItemlistFragment.adapter.notifyDataSetChanged();
	                        	 Helper.getListViewSize(Item_selected.listView);
	    		
	    				}catch(Exception e)
	    				{
	    					Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
	    				}
					// tableName.setText(tv.getText().toString());
					// newOrderActivity.mycart.setTableName("Table "+tv.getText().toString());
					 //newOrderActivity.tableName=tv.getText().toString();
					 
					// GamesFragment.closeDialogs();
					 
					  // closeDialogs();
					   dialog.dismiss();
					 
					 
				 }
				 };
				
				_1.setOnClickListener(tableSelected);
				_2.setOnClickListener(tableSelected);				
				_3.setOnClickListener(tableSelected);
				_4.setOnClickListener(tableSelected);
				_5.setOnClickListener(tableSelected);				
				_6.setOnClickListener(tableSelected);
				_7.setOnClickListener(tableSelected);
				_8.setOnClickListener(tableSelected);				
				_9.setOnClickListener(tableSelected);
				_10.setOnClickListener(tableSelected);
				_11.setOnClickListener(tableSelected);				
				_12.setOnClickListener(tableSelected);
				_13.setOnClickListener(tableSelected);
				_14.setOnClickListener(tableSelected);				
				_15.setOnClickListener(tableSelected);				
				_16.setOnClickListener(tableSelected);
				_17.setOnClickListener(tableSelected);				
				_18.setOnClickListener(tableSelected);
				
				_19.setOnClickListener(tableSelected);
				_20.setOnClickListener(tableSelected);				
				_21.setOnClickListener(tableSelected);				
				/*_22.setOnClickListener(tableSelected);
				_23.setOnClickListener(tableSelected);				
				_24.setOnClickListener(tableSelected);*/
				
				
				
				 //GamesFragment.dialogs.add(dialog);
				// GamesFragment.closeDialogs();
				 dialog.getWindow().setLayout(dialogwidth-10, LayoutParams.WRAP_CONTENT);
				 if(group.get_mark()==0 && group.get_status().equals("0")){
				 dialog.show();	}
				return false;
			}
		});
        pluse.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 //resource handle
				try{
					//checkSelected=true;
				//Drawable drawable = res.getDrawable(R.drawable.is_background_selector); //new Image that was added to the res folder
					 minus.setVisibility(View.VISIBLE);
					 imgView.setVisibility(View.GONE);
					 
					// pluse.setBackgroundDrawable(drawable);
					 expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
					 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
					 
					// expandcollesp.setBackgroundDrawable(drawable);
					// group.get_item().get_name();
					Boolean b= newOrderActivity.myCartHash.containsKey(group.get_item().get_name());
				//	 Toast.makeText(mContext,String.valueOf(b),Toast.LENGTH_LONG).show();
					
					 if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+"0")){
	                    	int _quantity;
	                    	if(group.get_mark()==0){
	                    		
	                    		 _quantity=newOrderActivity.myCartHash.get(group.get_item().get_name()+"0").get_quantity();
	                    		  _quantity++;
	  	                    	//group.set_quantity(_quantity);
	  	                    //	plusebtn.setText(String.valueOf(_quantity));
	  	                    	newOrderActivity.myCartHash.get(group.get_item().get_name()+"0").set_quantity(_quantity);
	  	                    	
	                    	}else{
	                    		  _quantity=newOrderActivity.myCartHash.get(group.get_item().get_name()+"0").get_quantity();
	                    		  _quantity++;
	                    		  newOrderActivity.myCartHash.get(group.get_item().get_name()+"0").set_quantity(_quantity);
	                    	}
	                    	
	                    	reload(group.get_item().get_category().get_id());
	        	        	
	                    	newOrderActivity.changed=true;
	        	        	Item_selected.Payment_option.setVisibility(View.GONE);
	        		        
	                 
	                    }
	                    else {
	                    	Item i1=new Item();
	                    	i1=group.get_item();
	                    	//i1.set_id()
	                    	 CartItems c=new CartItems();	                    	 
	                         c.set_item(i1);
	                		
	                        // group.set_quantity(1);
	                         
	                         c.set_quantity(1);
	                         c.set_mark(0);
	                         c.set_status("0");
	                        
	                    	 newOrderActivity.myCartHash.put(group.get_item().get_name()+"0", c);
	                    	 newOrderActivity.changed=true;
	                    	 Item_selected.Payment_option.setVisibility(View.GONE);
	                    	 int pos=0;
	                    	 Iterator itr = newOrderActivity.cartItems.iterator();
          		            CartItems strElement = null;
          		            
          		            while(itr.hasNext()){
          		            	pos++;
          		            	 strElement = (CartItems)itr.next();
                 		              if(strElement.get_item().get_name().equals(c.get_item().get_name()))
                 		              {
                 		            	  break;
                 		              }
          		            }
          		            if(pos==0){
	                    	 newOrderActivity.cartItems.add(c);}
          		            else{
          		            	 newOrderActivity.cartItems.add(pos,c);
          		            }
          		          Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
          		          Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
          		   //     Helper.getListViewSize(Item_selected.listView);
	                    	// newOrderActivity.mycart.setProducts(c);
	                    	 plusebtn.setText(String.valueOf(1));
	                    	// reload(group.get_item().get_category().get_id());
	                    	 LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
	                         childParam1.weight = 70f;
	                         //childParam1.setMargins(0, 0, 2, 2);
	                         expandcollesp.setLayoutParams(childParam1);
	                         
	                          reload(group.get_item().get_category().get_id());
	                        	// lbm.sendBroadcast(i);
	                        
	                    	 
						}
	                    
	                    Item_selected.cartItemadapter1.notifyDataSetChanged();
	                    
	                    if(isExpanded){	        	        		
                        	((ExpandableListView) parent).collapseGroup(groupPosition);
                        	 ((ExpandableListView) parent).expandGroup(groupPosition);
    	        	}else{
    	        	
                   	 ((ExpandableListView) parent).expandGroup(groupPosition);
                 	((ExpandableListView) parent).collapseGroup(groupPosition);
    	        	}
                    	ItemlistFragment.adapter.notifyDataSetChanged();
                    	 Helper.getListViewSize(Item_selected.listView);
		
				}catch(Exception e)
				{
					Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
				}
				
			}
		});
        minus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//minus.setVisibility(0);
				if(group.get_status().equals("0")){
				try
				{
					int _quantity;
					_quantity=group.get_quantity();
		        	_quantity--;
				if(group.get_mark()!=0)
				{
									
					newOrderActivity.myCartItemsWithExtras.remove(group.get_item().get_name()+ String.valueOf(group.get_mark()));
					 ArrayList<Extra> e=group.get_item().get_extra();
				        for(Extra x:e)
				        {
				        	//Toast.makeText(mContext, x.get_name(), Toast.LENGTH_LONG).show();
				        	
				        	if(newOrderActivity.itemExtra.containsKey(x.get_item().get_name()+ String.valueOf(group.get_mark())+x.get_name()))
				        	{
				        		newOrderActivity.itemExtra.remove(x.get_item().get_name()+ String.valueOf(group.get_mark())+x.get_name());
				        		
				        		//Toast.makeText(mContext, x.get_name()+ "Removed", Toast.LENGTH_LONG).show();
				        	}
				        	else{
				        		//Toast.makeText(mContext, x.get_name()+ "Not Removed", Toast.LENGTH_LONG).show();
				        	}
				        					        
				}
				       
				        if(isExpanded) ((ExpandableListView) parent).collapseGroup(groupPosition);
	        		Iterator itr = newOrderActivity.cartItems.iterator();
		            CartItems strElement = null;
		            while(itr.hasNext()){

		              strElement = (CartItems)itr.next();
		              if(strElement.get_item().get_name().equals(group.get_item().get_name()))
		              {
		            	  if(strElement.get_mark()==group.get_mark()){
       		                itr.remove();
       		            	  }
		                
		              }
		            }
		          
		            Drawable drawable = res.getDrawable(R.drawable.btn_back_selector); //new Image that was added to the res folder
		        	imgView.setVisibility(View.VISIBLE);
					//pluse.setBackgroundDrawable(drawable);
					 expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
					 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
					 
					//expandcollesp.setBackgroundDrawable(drawable);
					minus.setVisibility(View.GONE);
					LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
			        childParam1.weight = 85f;
			        //childParam1.setMargins(0, 0, 2, 2);
			        expandcollesp.setLayoutParams(childParam1);
			        reload(group.get_item().get_category().get_id());
				}
			        	
			        if(group.get_mark()==0){	
			        	if(_quantity<=0){
			        		group.set_quantity(_quantity);
			        		plusebtn.setText("");
			        	//newOrderActivity.cartItems.remove(group);
			        		
						        if(isExpanded) ((ExpandableListView) parent).collapseGroup(groupPosition);
			        		Iterator itr = newOrderActivity.cartItems.iterator();
				            CartItems strElement = null;
				            while(itr.hasNext()){

				              strElement = (CartItems)itr.next();
				              if(strElement.get_item().get_name().equals(group.get_item().get_name()))
				              {
				            	  if(strElement.get_mark()==group.get_mark()&&strElement.get_status().equals(group.get_status())){
	             		                itr.remove();
	             		            	  }
				               
				              }
				            }
			        	
				            //checkSelected=false;
			        	newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
			        	
			        	
			        	 //newOrderActivity.mycart.setProducts(c);
			        	//Toast.makeText(mContext,group.get_item().get_name(),Toast.LENGTH_LONG).show();
			        	Drawable drawable = res.getDrawable(R.drawable.btn_back_selector); //new Image that was added to the res folder
			        	imgView.setVisibility(View.VISIBLE);
						//pluse.setBackgroundDrawable(drawable);
						 expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
						 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
						 
						//expandcollesp.setBackgroundDrawable(drawable);
						minus.setVisibility(View.GONE);
						LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
				        childParam1.weight = 85f;
				        //childParam1.setMargins(0, 0, 2, 2);
				        expandcollesp.setLayoutParams(childParam1);
				        reload(group.get_item().get_category().get_id());
			           // else ((ExpandableListView) parent).expandGroup(groupPosition);
			        	}
			        	else{
			        	plusebtn.setText(String.valueOf(_quantity));
			        	// reload(group.get_item().get_category().get_id());
			        	group.set_quantity(_quantity);
			        	newOrderActivity.myCartHash.get(group.get_item().get_name()).set_quantity(_quantity);
			        
			           // newOrderActivity.cartItems.add(group);
			        	}
			        				        }
			        	newOrderActivity.changed=true;
			        	Item_selected.Payment_option.setVisibility(View.GONE);
				        Item_selected.cartItemadapter1.notifyDataSetChanged();
				         
				        ItemlistFragment.adapter.notifyDataSetChanged();
				   	    Helper.getListViewSize(Item_selected.listView);
			        	//GamesFragment.ExpAdapter.notifyDataSetChanged();
				         
				       	// lbm.sendBroadcast(i);
				       //  _item.calltocallback();
				   	    if(isExpanded){
				   	 ((ExpandableListView) parent).collapseGroup(groupPosition);
               	  ((ExpandableListView) parent).expandGroup(groupPosition);
               	if(_quantity<=0){
               		((ExpandableListView) parent).collapseGroup(groupPosition);
               	}
               	  }
				   	    else{
				   	    	
			               	  ((ExpandableListView) parent).expandGroup(groupPosition);
			               	((ExpandableListView) parent).collapseGroup(groupPosition);
				   	    }
				}
				catch(Exception e)
				{
					//Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
				}
				}else{
					//edit order selection
					// show mak dialog
					
					 final Dialog dialog = new Dialog(mContext);
					 dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					 dialog.setContentView(R.layout.select_status);
					
					
					 LinearLayout lin_cooking=(LinearLayout) dialog.findViewById(R.id.lin_cooking);
					 LinearLayout lin_ready=(LinearLayout) dialog.findViewById(R.id.lin_ready);
					 LinearLayout lin_served=(LinearLayout) dialog.findViewById(R.id.lin_served);
					 LinearLayout lin_cancelled=(LinearLayout) dialog.findViewById(R.id.lin_cancelled);
					 
					 ImageView img_cooking=(ImageView) dialog.findViewById(R.id.img_status_cooking);
					 ImageView img_status_ready=(ImageView) dialog.findViewById(R.id.img_status_ready);
					 ImageView img_status_served=(ImageView) dialog.findViewById(R.id.img_status_served);
					 ImageView img_status_cancelled=(ImageView) dialog.findViewById(R.id.img_status_cancelled);
					 
					 TextView txt_cooking=(TextView) dialog.findViewById(R.id.txt_cooking);
					 TextView txt_ready=(TextView) dialog.findViewById(R.id.txt_ready);
					 TextView txt_served=(TextView) dialog.findViewById(R.id.txt_served);
					 TextView txt_cancelled=(TextView) dialog.findViewById(R.id.txt_cancelled);
					 
					 TextView txt_status_itemname=(TextView) dialog.findViewById(R.id.txt_status_itemname);
					 txt_status_itemname.setText(group.get_item().get_name());						 
					 if(group.get_status().equals("2")){
						 img_cooking.setAlpha(1f);
						 txt_cooking.setAlpha(1f);
					 }
					 if(group.get_status().equals("3")){
						 img_status_ready.setAlpha(1f);
						 txt_ready.setAlpha(1f);
						 
					 }
					 if(group.get_status().equals("4")){
						 img_status_served.setAlpha(1f);
						 txt_served.setAlpha(1f);
					 }
					 if(group.get_status().equals("5")){
						 img_status_cancelled.setAlpha(1f);
						 txt_cancelled.setAlpha(1f);
						 
					 }
					 lin_cooking.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							if(group.get_mark()==0){
								if(!newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+"2")){		
							if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
								 CartItems replace=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
								 newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
								 replace.set_status("2");
								 newOrderActivity.myCartHash.put(group.get_item().get_name()+"2", replace);
							 }
							
							group.set_status("2");
								}else{
									CartItems oldcItem =newOrderActivity.myCartHash.get(group.get_item().get_name()+"2");
									if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
									 CartItems newcItem=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
									 int qty=oldcItem.get_quantity()+newcItem.get_quantity();
									 
									 newOrderActivity.myCartHash.get(group.get_item().get_name()+"2").set_quantity(qty);
									
									 Iterator itr = newOrderActivity.cartItems.iterator();
							            CartItems strElement = null;
							            while(itr.hasNext()){

							              strElement = (CartItems)itr.next();
							              if(strElement.get_item().get_name().equals(group.get_item().get_name()))
							              {
							            	  if(strElement.get_mark()==group.get_mark() &&strElement.get_status().equals(group.get_status())){
					       		                itr.remove();
					       		            	  }
							                
							              }
							            }
							            newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
									}
									 //newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
								}
								
							
							
							}else{
								 CartItems cart_item2=newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark()));
								 cart_item2.set_status("2");
								 for (Extra iterable_element : group.get_item().get_extra()) {
						          		//	Toast.makeText(getApplicationContext(),iterable_element.get_name(), Toast.LENGTH_LONG).show();
												
												for(int j=0;j<=5;j++){
													if(newOrderActivity.itemExtra.containsKey(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name())){
														 Extra extra=newOrderActivity.itemExtra.get(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
														 newOrderActivity.itemExtra.remove(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
														 newOrderActivity.itemExtra.put(group.get_item().get_name()+"2"+ String.valueOf(group.get_mark())+iterable_element.get_name(), extra);
														
														}
												}
											
											}
							 }
									 Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
    	                        	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
								 Item_selected.cartItemadapter1.notifyDataSetChanged();
				 	              ItemlistFragment.adapter.notifyDataSetChanged();
				 	          
				 	             dialog.dismiss();
						}
					});
					 lin_ready.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								if(group.get_mark()==0){
									if(!newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+"3")){		
								if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
									 CartItems replace=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
									 newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
									 replace.set_status("3");
									 newOrderActivity.myCartHash.put(group.get_item().get_name()+"3", replace);
								 }
								
								group.set_status("3");
									}else{
										CartItems oldcItem =newOrderActivity.myCartHash.get(group.get_item().get_name()+"3");
										if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
										 CartItems newcItem=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
										 int qty=oldcItem.get_quantity()+newcItem.get_quantity();
										 
										 newOrderActivity.myCartHash.get(group.get_item().get_name()+"3").set_quantity(qty);
										
										 Iterator itr = newOrderActivity.cartItems.iterator();
								            CartItems strElement = null;
								            while(itr.hasNext()){

								              strElement = (CartItems)itr.next();
								              if(strElement.get_item().get_name().equals(group.get_item().get_name()))
								              {
								            	  if(strElement.get_mark()==group.get_mark() &&strElement.get_status().equals(group.get_status())){
						       		                itr.remove();
						       		            	  }
								                
								              }
								            }
								            newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
										}
										 //newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
									}
									
								
								
								}else{
									 CartItems cart_item2=newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark()));
									 cart_item2.set_status("3");
									 for (Extra iterable_element : group.get_item().get_extra()) {
							          		//	Toast.makeText(getApplicationContext(),iterable_element.get_name(), Toast.LENGTH_LONG).show();
													
													for(int j=0;j<=5;j++){
														if(newOrderActivity.itemExtra.containsKey(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name())){
															 Extra extra=newOrderActivity.itemExtra.get(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
															 newOrderActivity.itemExtra.remove(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
															 newOrderActivity.itemExtra.put(group.get_item().get_name()+"3"+ String.valueOf(group.get_mark())+iterable_element.get_name(), extra);
															
															}
													}
												
												}
								 }
									Helper.getListViewSize(Item_selected.listView);
										 Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
	    	                        	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
									 Item_selected.cartItemadapter1.notifyDataSetChanged();
					 	              ItemlistFragment.adapter.notifyDataSetChanged();
					 	          
					 	             dialog.dismiss();
							}
						});
					 lin_served.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								if(group.get_mark()==0){
									if(!newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+"4")){		
								if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
									 CartItems replace=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
									 newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
									 replace.set_status("4");
									 newOrderActivity.myCartHash.put(group.get_item().get_name()+"4", replace);
								 }
								
								group.set_status("4");
									}else{
										CartItems oldcItem =newOrderActivity.myCartHash.get(group.get_item().get_name()+"4");
										if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
										 CartItems newcItem=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
										 int qty=oldcItem.get_quantity()+newcItem.get_quantity();											 
										 newOrderActivity.myCartHash.get(group.get_item().get_name()+"4").set_quantity(qty);											
										 Iterator itr = newOrderActivity.cartItems.iterator();
								            CartItems strElement = null;
								            while(itr.hasNext()){
								              strElement = (CartItems)itr.next();
								              if(strElement.get_item().get_name().equals(group.get_item().get_name())){
								               if(strElement.get_mark()==group.get_mark() &&strElement.get_status().equals(group.get_status())){
						       		                itr.remove();
						       		            }}
								            }
								            newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
										}}
								
								}else{
									 CartItems cart_item2=newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark()));
									 cart_item2.set_status("4");
									 for (Extra iterable_element : group.get_item().get_extra()) {
							          		//	Toast.makeText(getApplicationContext(),iterable_element.get_name(), Toast.LENGTH_LONG).show();
													
													for(int j=0;j<=5;j++){
														if(newOrderActivity.itemExtra.containsKey(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name())){
															 Extra extra=newOrderActivity.itemExtra.get(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
															 newOrderActivity.itemExtra.remove(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
															 newOrderActivity.itemExtra.put(group.get_item().get_name()+"4"+ String.valueOf(group.get_mark())+iterable_element.get_name(), extra);
															
															}
													}
												
												}
								 }
									Helper.getListViewSize(Item_selected.listView);
										 Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
	    	                        	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
									 Item_selected.cartItemadapter1.notifyDataSetChanged();
					 	              ItemlistFragment.adapter.notifyDataSetChanged();
					 	          
					 	             dialog.dismiss();
							}
						});
					 lin_cancelled.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								if(group.get_mark()==0){
									if(!newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+"5")){		
								if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
									 CartItems replace=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
									 newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
									 replace.set_status("5");
									 newOrderActivity.myCartHash.put(group.get_item().get_name()+"5", replace);
								 }
								
								
									}else{
										CartItems oldcItem =newOrderActivity.myCartHash.get(group.get_item().get_name()+"5");
										if(newOrderActivity.myCartHash.containsKey(group.get_item().get_name()+group.get_status())){
										 CartItems newcItem=newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status());
										 int qty=oldcItem.get_quantity()+newcItem.get_quantity();											 
										 newOrderActivity.myCartHash.get(group.get_item().get_name()+"5").set_quantity(qty);											
										 Iterator itr = newOrderActivity.cartItems.iterator();
								            CartItems strElement = null;
								            while(itr.hasNext()){
								              strElement = (CartItems)itr.next();
								              if(strElement.get_item().get_name().equals(group.get_item().get_name())){
								               if(strElement.get_mark()==group.get_mark() &&strElement.get_status().equals(group.get_status())){
						       		                itr.remove();
						       		            }}
								            }
								            newOrderActivity.myCartHash.remove(group.get_item().get_name()+group.get_status());
										}}
									group.set_status("5");
									 
							        if(group.get_status().equals("5"))
							        	textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
								
								}else{
									 CartItems cart_item2=newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark()));
									 cart_item2.set_status("5");
									 for (Extra iterable_element : group.get_item().get_extra()) {
							          		//	Toast.makeText(getApplicationContext(),iterable_element.get_name(), Toast.LENGTH_LONG).show();
													
													for(int j=0;j<=5;j++){
														if(newOrderActivity.itemExtra.containsKey(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name())){
															 Extra extra=newOrderActivity.itemExtra.get(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
															 newOrderActivity.itemExtra.remove(group.get_item().get_name()+ String.valueOf(j)+ String.valueOf(group.get_mark())+iterable_element.get_name());
															 newOrderActivity.itemExtra.put(group.get_item().get_name()+"5"+ String.valueOf(group.get_mark())+iterable_element.get_name(), extra);
															
															}
													}
												
												}
								 }
									Helper.getListViewSize(Item_selected.listView);
									
										 Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
	    	                        	 Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
									 Item_selected.cartItemadapter1.notifyDataSetChanged();
					 	              ItemlistFragment.adapter.notifyDataSetChanged();
					 	          
					 	             dialog.dismiss();
							}
						});
					
					 dialog.getWindow().setLayout(dialogwidth, LayoutParams.WRAP_CONTENT);
					 dialog.show();
					//End
				}
			}
		});
        expandcollesp.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//Toast.makeText(mContext, String.valueOf(isExpanded), Toast.LENGTH_SHORT).show();
			//((ExpandableListView) parent).collapseGroup(groupPosition);
			
			 if(isExpanded) {
				 ((ExpandableListView) parent).collapseGroup(groupPosition);
				/* if(!checkSelected.containsKey(String.valueOf(groupPosition))){
				 checkSelected.put(String.valueOf(groupPosition), true);
				 }*/
				// ((ExpandableListView) parent).expandGroup(groupPosition);
				 Helper.getListViewSize(Item_selected.listView);
				 }
			 else{
				 String str=group.get_item().get_name()+group.get_status();
				// Toast.makeText(mContext,str,Toast.LENGTH_SHORT).show();
			  if(newOrderActivity.myCartHash.containsKey(str) || group.get_mark()!=0){
				 // ((ExpandableListView) parent).expandGroup(groupPosition);
				/*  if(checkSelected.containsKey(group.get_item().get_name()))
				  {
					 // Boolean f=checkSelected.get(group.get_item().get_name());
					 
						 
						  checkSelected.remove(group.get_item().get_name());
					  
				  }
				  else{
				  checkSelected.put(group.get_item().get_name(),true);
				  }*/
			 ((ExpandableListView) parent).expandGroup(groupPosition);
			 Helper.getListViewSize(Item_selected.listView);
			// Toast.makeText(mContext,String.valueOf(isExpanded),Toast.LENGTH_SHORT).show();
			  }
			  else
			  {
				//  ((ExpandableListView) parent).expandGroup(groupPosition);
				  Toast.makeText(mContext,"Tap + before", Toast.LENGTH_SHORT).show();
					
			  }
			  

		}
		}
	});
        return convertView;
    }
 
    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, final ViewGroup parent) {
 
    	 /* if (childPosition == 0) {
    		  convertView = mInflater.inflate(R.layout.course,parent, false);
    	  }*/
    	//Toast.makeText(mContext,"not Contains",Toast.LENGTH_SHORT).show();
    	  if (childPosition == getChildrenCount(groupPosition)-1) {
    		  final CartItems group = (CartItems) getGroup(groupPosition);
    		  convertView = mInflater.inflate(R.layout.course,parent, false);
    		  final TextView tvone=(TextView) convertView.findViewById(R.id.tv_one);
    		  final TextView tvtwo=(TextView) convertView.findViewById(R.id.tv_two);
    		  final TextView tvthree=(TextView) convertView.findViewById(R.id.tv_three);
    		  RelativeLayout one =(RelativeLayout) convertView.findViewById(R.id.one);
    		  RelativeLayout two =(RelativeLayout) convertView.findViewById(R.id.two);
    		  RelativeLayout three =(RelativeLayout) convertView.findViewById(R.id.three);
    		  
    		  if(group.get_course()==1){
    			  tvone.setAlpha(1.0f);
					tvone.setTextSize(24.0f);
					//tvone.setTypeface(null,Typeface.BOLD);
					tvtwo.setAlpha(0.5f);
					tvthree.setAlpha(0.5f);
					 
    		  }
    		  if(group.get_course()==2){
    			  tvtwo.setAlpha(1.0f);
					tvtwo.setTextSize(24.0f);
					//tvtwo.setTypeface(null,Typeface.BOLD);
					tvone.setAlpha(0.5f);
					 
					tvthree.setAlpha(0.5f);
					 
    		  }
    		  if(group.get_course()==3){
    			  tvthree.setAlpha(1.0f);
					tvthree.setTextSize(24.0f);
					//tvthree.setTypeface(null,Typeface.BOLD);
					tvone.setAlpha(0.5f);
					 
					tvtwo.setAlpha(0.5f);
					 
    		  }
    		  one.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					group.set_course(1);
					tvone.setAlpha(1.0f);
					tvone.setTextSize(24.0f);
					//tvone.setTypeface(null,Typeface.BOLD);
					tvtwo.setAlpha(0.5f);
					 
					tvthree.setAlpha(0.5f);
					if(group.get_mark()==0){
						newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status()).set_course(1);
						}else{
							newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark())).set_course(1);
						}
					Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
                    Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
                    Helper.getListViewSize(Item_selected.listView);
					 Item_selected.cartItemadapter1.notifyDataSetChanged();
	 	               
	 	             ItemlistFragment.adapter.notifyDataSetChanged();
	 	               
	 	            	// lbm.sendBroadcast(i);
	 	            ((ExpandableListView) parent).collapseGroup(groupPosition);
              	  ((ExpandableListView) parent).expandGroup(groupPosition);
					
				}
			});
    		  two.setOnClickListener(new View.OnClickListener() {
  				
  				@Override
  				public void onClick(View arg0) {
  					group.set_course(2);
  					tvtwo.setAlpha(1.0f);
  					tvtwo.setTextSize(24.0f);
  					//tvtwo.setTypeface(null,Typeface.BOLD);
  					tvone.setAlpha(0.5f);  					 
					tvthree.setAlpha(0.5f);
					if(group.get_mark()==0){
						newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status()).set_course(2);
						}else{
							newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark())).set_course(2);
						}
					Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
                    Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
                    
                    Helper.getListViewSize(Item_selected.listView);
					 Item_selected.cartItemadapter1.notifyDataSetChanged();
	 	               
	 	             ItemlistFragment.adapter.notifyDataSetChanged();
	 	               
	 	            	// lbm.sendBroadcast(i);
  					
  				}
  			});
    		  three.setOnClickListener(new View.OnClickListener() {
  				
  				@Override
  				public void onClick(View arg0) {
  					group.set_course(3);
  					tvthree.setAlpha(1.0f);
  					tvthree.setTextSize(24.0f);
  					//tvthree.setTypeface(null,Typeface.BOLD);
  					tvone.setAlpha(0.5f);  					 
  					tvtwo.setAlpha(0.5f);
  					if(group.get_mark()==0){
						newOrderActivity.myCartHash.get(group.get_item().get_name()+group.get_status()).set_course(3);
						}else{
							newOrderActivity.myCartItemsWithExtras.get(group.get_item().get_name()+ String.valueOf(group.get_mark())).set_course(3);
						}
  					Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
                    Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
                    Helper.getListViewSize(Item_selected.listView);
  					 Item_selected.cartItemadapter1.notifyDataSetChanged();
	 	               
	 	             ItemlistFragment.adapter.notifyDataSetChanged();
	 	               
	 	            	// lbm.sendBroadcast(i);
	 	            ((ExpandableListView) parent).collapseGroup(groupPosition);
              	  ((ExpandableListView) parent).expandGroup(groupPosition);
  				}
  			});
    	  }
        if ((childPosition>=0 && childPosition<getChildrenCount(groupPosition)-1)) {
        	
            convertView = mInflater.inflate(R.layout.no_extra_item_selecteed,parent, false);
            
        
      //  LayoutInflater infalInflater = (LayoutInflater) context
        //        .getSystemService(context.LAYOUT_INFLATER_SERVICE);
       
        
        final CartItems c = (CartItems) getGroup(groupPosition);
        LinearLayout l=(LinearLayout) convertView.findViewById(R.id.lin_layout_noExtra);
       
       // Toast.makeText(mContext,"In child",Toast.LENGTH_SHORT).show();
        final Extra children = (Extra) getChild(groupPosition, childPosition);
        // Set group name
        final Resources res = convertView.getResources();
        TextView textView = (TextView) convertView.findViewById(R.id.tv_no_extraname);
        final TextView plusebtn = (TextView) convertView.findViewById(R.id.tv_noextra_pluse);
      //  final TextView minusbtn = (TextView) convertView.findViewById(R.id.tv_no_minus);
       
       // final RelativeLayout expandcollesp =(RelativeLayout) convertView.findViewById(R.id.Rel_no_extra_click);
        final RelativeLayout pluse=(RelativeLayout)convertView.findViewById(R.id.Rel_Extra_plus);
       
        // final RelativeLayout rel_item_name=(RelativeLayout)convertView.findViewById(R.id.Rel_no_item_click);
        
        final RelativeLayout minus=(RelativeLayout)convertView.findViewById(R.id.Rel_Extra_minus);
        minus.setVisibility(View.GONE);
       // expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
		 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
        final ImageView imgView = (ImageView) convertView.findViewById(R.id.no_extra_imag);
        LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
      //  childParam1.setMargins(0, 0, 0, 2);
        childParam1.weight =85f;
        pluse.setLayoutParams(childParam1);
       
        
        LinearLayout.LayoutParams childParam12 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
		//childParam12.setMargins(0, 0, 0, 2);
        childParam12.weight = 15f;
        minus.setLayoutParams(childParam12);
        
        LinearLayout.LayoutParams childParam121 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
		//childParam121.setMargins(2, 0, 0, 2);
        childParam121.weight = 15f;
       // pluse.setLayoutParams(childParam121);
        // Set child name
        TextView text = (TextView) convertView.findViewById(R.id.tv_no_extraname);
        text.setText(children.get_name());
        boolean value=false;
        if(c.get_mark()==0){
        	if(newOrderActivity.myCartHash.containsKey(children.get_item().get_name()+c.get_status())){
        		value=true;
       	 }
        }else{
        	 if(newOrderActivity.myCartItemsWithExtras.containsKey(children.get_item().get_name()+ String.valueOf(c.get_mark()))){
        		 value=true;
        	 }
        }
        if(value){
        	 textView.setText(children.get_name());
        	 
        	if(newOrderActivity.itemExtra.containsKey(children.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+children.get_name())){
        		// Toast.makeText(mContext,children.get_item().get_name()+children.get_name() +"Contains",Toast.LENGTH_SHORT).show();
        		 minus.setVisibility(View.VISIBLE);
				 imgView.setVisibility(View.GONE);
				// expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
				 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
				
				 plusebtn.setText("1");
				// reload(children.get_item().get_category().get_id());
                    LinearLayout.LayoutParams childParam11 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                     childParam11.weight = 70f;
                  //   childParam11.setMargins(0, 0, 2, 2);
                     pluse.setLayoutParams(childParam11);
        	}
        	else
        	{
        		//Toast.makeText(mContext,children.get_item().get_name()+children.get_name() +"not Contains",Toast.LENGTH_SHORT).show();
         		
        		// expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
				 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
				 plusebtn.setText("");
				 imgView.setVisibility(View.VISIBLE);
				 /*if(!checkSelected.containsKey(c.get_item().get_name()))
			        {
			        l.setVisibility(View.GONE);
			        }*/
        	
        	}
        	/*if(newOrderActivity.itemExtra.containsKey(children.get_item().get_name()+children.get_name())){
        	if(!checkSelected.containsKey(String.valueOf(groupPosition))){
        		// l.setVisibility(View.GONE);
        		// minus.setVisibility(View.VISIBLE);
        		// imgView.setVisibility(View.GONE);
 				// pluse.setVisibility(View.GONE);
        	}else{
        		//convertView=null;
        	//	 l.setVisibility(View.GONE);
				// imgView.setVisibility(View.GONE);
				// pluse.setVisibility(View.GONE);
        	}}*/
        	//Item_selected.cartItemadapter1.notifyDataSetChanged();
        // Get child name
       
       
        //minus.setEnabled(false);
       // minus.setVisibility(50);
        //RelativeLayout
       
 
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
            	 
                try{
                	
    					 minus.setVisibility(View.VISIBLE);
    					 imgView.setVisibility(View.GONE);
    				//	 expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
    					 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));
    					
    					 plusebtn.setText("1");
    	                   
    	                    LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
	                         childParam1.weight = 70f;
	                       //  childParam1.setMargins(0, 0, 2, 2);
	                         pluse.setLayoutParams(childParam1);
	                         String markValue="0";
    	                    if(newOrderActivity.markHash.containsKey(children.get_item().get_name())){
    	                    	markValue=newOrderActivity.markHash.get(children.get_item().get_name());
    	                    //	Toast.makeText(mContext,  markValue, Toast.LENGTH_SHORT).show();
    	                    }
    	                    if(markValue.equals("0")){
    	                    	markValue="1";
    	                    }else{
    	                    	int value= Integer.parseInt(markValue)+1;
    	                    	markValue= String.valueOf(value);
    	                    }
    	                    
    	                   // Item_selected.cartItemadapter1.notifyDataSetChanged();
	                         if(!newOrderActivity.itemExtra.containsKey(children.get_item().get_name()+c.get_status()+markValue+children.get_name())){
	                        	 //if()
	                        	 //dhaval
	                        	 if(c.get_mark()>0){
	                        		 newOrderActivity.itemExtra.put(children.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+children.get_name(), children);
			    	                    
	                        	 }else{
	                        		 int pos=0;
	                        		 if(c.get_quantity()==1){
	                        			 newOrderActivity.myCartHash.remove(children.get_item().get_name()+c.get_status());
	                        			 Iterator itr = newOrderActivity.cartItems.iterator();
		                 		            CartItems strElement = null;
		                 		            
		                 		            while(itr.hasNext()){
		                 		            	pos++;
		                 		              strElement = (CartItems)itr.next();
		                 		              if(strElement.get_item().get_name().equals(children.get_item().get_name()))
		                 		              {
		                 		            	 if(strElement.get_mark()==c.get_mark() && strElement.get_status().equals(c.get_status())){
		                      		                itr.remove();
		                      		                break;
		                      		            	  }
		                 		                
		                 		              }
		                 		            }
	                        		 }else{
	                        			 int _quantity= newOrderActivity.myCartHash.get(children.get_item().get_name()+c.get_status()).get_quantity();
		                        		 newOrderActivity.myCartHash.get(children.get_item().get_name()+c.get_status()).set_quantity(_quantity-1);
		                        		 c.set_quantity(_quantity);
	                        		 }
	                        		
	                        		 CartItems citem=new CartItems();	                    	 
	                        		 citem.set_item(c.get_item());    	                         
	                        		 citem.set_quantity(1);
	                        		 citem.set_mark(Integer.parseInt(markValue));
	                        		 citem.set_course(c.get_course());
	                        		 citem.set_status(c.get_status());
	                        		 newOrderActivity.myCartItemsWithExtras.put(children.get_item().get_name()+markValue,citem);
	    	                         newOrderActivity.itemExtra.put(children.get_item().get_name()+c.get_status()+markValue+children.get_name(), children); 
	    	                         newOrderActivity.markHash.put(children.get_item().get_name(), markValue);
	    	                         if(pos==0){
	    	                        	 Iterator itr = newOrderActivity.cartItems.iterator();
		                 		            CartItems strElement = null;
		                 		            
		                 		            while(itr.hasNext()){
		                 		            	pos++;
		                 		            	 strElement = (CartItems)itr.next();
			                 		              if(strElement.get_item().get_name().equals(children.get_item().get_name()))
			                 		              {
			                 		            	  break;
			                 		              }
		                 		            }
	    	                         }
	    	                         
	    	                         newOrderActivity.cartItems.add(citem);
	    	                         Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
	    	                         Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
	    	                         Helper.getListViewSize(Item_selected.listView);
	                        	 }
	                        	  ((ExpandableListView) parent).collapseGroup(groupPosition);
	                        	  ((ExpandableListView) parent).expandGroup(groupPosition);
	                        	 //newOrderActivity.itemExtra.put(children.get_item().get_name()+children.get_name(), children);  
	                        	 newOrderActivity.changed=true;
	                        	 Item_selected.Payment_option.setVisibility(View.GONE);
	                        	 // newOrderActivity.itemExtra.put(children,children);
	                        	 //Toast.makeText(mContext,  children.get_name()+ " Added", Toast.LENGTH_SHORT).show();
	                        	
	                        	 Item_selected.cartItemadapter1.notifyDataSetChanged();
	                        	 reload(children.get_item().get_category().get_id());
	                        	 ItemlistFragment.adapter.notifyDataSetChanged();
	                        	 Helper.getListViewSize(Item_selected.listView);
	                        	
	                        	//	// lbm.sendBroadcast(i);
	                        	 ((ExpandableListView) parent).collapseGroup(groupPosition);
	                        	  ((ExpandableListView) parent).expandGroup(groupPosition);
	                        	 
	 	                    }
	 	                    
	 	                    
	 	                 //   Item_selected.cartItemadapter1.notifyDataSetChanged();
    		
    				}catch(Exception e)
    				{
    					Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
    				}
    				               
                
            }
        });
        
        
  minus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//minus.setVisibility(0);
				try
				{
			        
			        //	Drawable drawable = res.getDrawable(R.drawable.btn_back_selector); //new Image that was added to the res folder
			        	imgView.setVisibility(View.VISIBLE);
						//pluse.setBackgroundDrawable(drawable);
						// expandcollesp.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
						 pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground));
						 plusebtn.setText("");
						//expandcollesp.setBackgroundDrawable(drawable);
						minus.setVisibility(View.GONE);
						LinearLayout.LayoutParams childParam1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
				        childParam1.weight = 85f;
				     //   childParam1.setMargins(0, 0, 2, 2);
				        pluse.setLayoutParams(childParam1);
				        if(newOrderActivity.itemExtra.containsKey(children.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+children.get_name())){
         	   		        //dhaval
		 	                 newOrderActivity.itemExtra.remove(children.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+children.get_name());
		 	               boolean isContain=false;
		 	                 for (Extra extra : c.get_item().get_extra()) {
							if(newOrderActivity.itemExtra.containsKey(children.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+extra.get_name())){
							isContain=true;
								break;
							}							
							}
		 	                 if(!isContain){
		 	                //	if(c.get_status().equals("0")){
		 	                	newOrderActivity.myCartItemsWithExtras.remove(children.get_item().get_name()+ String.valueOf(c.get_mark()));
		 	                	Iterator itr = newOrderActivity.cartItems.iterator();
             		            CartItems strElement = null;
             		            while(itr.hasNext()){

             		              strElement = (CartItems)itr.next();
             		              if(strElement.get_item().get_name().equals(children.get_item().get_name()))
             		              {
             		            	 if(strElement.get_mark()==c.get_mark() && strElement.get_status().equals(c.get_status())){
 	             		                itr.remove();
 	             		            	  }
             		                
             		              }
             		            }
								if(newOrderActivity.myCartHash.containsKey(children.get_item().get_name()+c.get_status())){
									 int _quantity= newOrderActivity.myCartHash.get(children.get_item().get_name()+c.get_status()).get_quantity();
	                        		 newOrderActivity.myCartHash.get(children.get_item().get_name()+c.get_status()).set_quantity(_quantity+1);
	                        		 newOrderActivity.myCartHash.get(children.get_item().get_name()+c.get_status()).set_mark(0);
								}else{
									c.set_mark(0);
									newOrderActivity.myCartHash.put(children.get_item().get_name()+c.get_status(), c);
									if(Item_selected.lastExpandedPosition>=0){
										newOrderActivity.cartItems.add(Item_selected.lastExpandedPosition,c);
										}else{
											newOrderActivity.cartItems.add(c);
										}
							
									Collections.sort(newOrderActivity.cartItems,new myCartitemComparableStatus());
									Collections.sort(newOrderActivity.cartItems,new myCartitemComparable());
								}
								  ((ExpandableListView) parent).expandGroup(groupPosition);
								 ((ExpandableListView) parent).collapseGroup(groupPosition);
			                   
		 	                 /*}else{
		 	                	 ((ExpandableListView) parent).collapseGroup(groupPosition);
		 	                   	  ((ExpandableListView) parent).expandGroup(groupPosition);
		 	                 }*/
		 	                 newOrderActivity.changed=true;
		 	               Item_selected.Payment_option.setVisibility(View.GONE);
		 	              //  Toast.makeText(mContext,  children.get_name()+ " Removed", Toast.LENGTH_SHORT).show();
			 	               
		 	               Item_selected.cartItemadapter1.notifyDataSetChanged();
		 	               
		 	            //  ItemlistFragment i= 
		 	             ItemlistFragment.adapter.notifyDataSetChanged();
		 	        	 Helper.getListViewSize(Item_selected.listView);
		 	               
		 	            
		 	           	// lbm.sendBroadcast(i);
		 	              //  
		 	        	 reload(children.get_item().get_category().get_id());
		 	        	
		 	        	
		 	                    }
		 	                 }
			        	
				}
				catch(Exception e)
				{
					Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
				}
				
			}
		});
        }
        else{
        	Toast.makeText(mContext, "Tap + before", Toast.LENGTH_SHORT).show();
        	// return null;
        }
        
       
        }
        return convertView;
    }
 
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    public void reload(int id){
    	 ArrayList<Item> groups=null ;
    	 mGroups.clear();
    	  groups =DBAdapter.getComboItems(id);
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
		                      	mGroups.add(cart_item1);
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
	                   		mGroups.add(cart_item1);
	                  		// Toast.makeText(container.getContext(),i.get_name()+"2", Toast.LENGTH_LONG).show();
	                  		// CartGroups.add(cart_item);
	                  	 }
					}
	              	 if(!isAdded ){
	              		mGroups.add(cart_item);
	              	 }
	          	
	          	 }
	          	 catch(Exception e)
	          	 {
	          		// Toast.makeText(container.getContext(), e.toString(), Toast.LENGTH_LONG).show();
	          	 }
          }
          
    }
}