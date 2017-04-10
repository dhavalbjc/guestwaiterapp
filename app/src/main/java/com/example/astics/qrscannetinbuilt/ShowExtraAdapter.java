package com.example.astics.qrscannetinbuilt;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;


public class ShowExtraAdapter extends BaseAdapter {

    ArrayList<Extra> myList = new ArrayList<Extra>();
    LayoutInflater inflater;
    Context context;
    CartItems c;
    ViewGroup p;
    int position;
    ArrayList<CartItems> mGroups;

    public ShowExtraAdapter(Context context, ArrayList<Extra> myList, CartItems cartItems, ViewGroup parent, int groupPosition, ArrayList<CartItems> mGroups) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
        c=cartItems;
        p=parent;
        position=groupPosition;
        this.mGroups=mGroups;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Extra getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressWarnings("deprecation")
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.no_extra_item_selecteed, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
         Resources res = convertView.getResources();
        final Extra currentListData = getItem(position);

        mViewHolder.tvTitle.setText(currentListData.get_name());    
        mViewHolder.minus.setVisibility(View.VISIBLE);
        mViewHolder.imgView.setVisibility(View.GONE);
        mViewHolder.pluse.setBackgroundDrawable(res.getDrawable(R.drawable.newbackground_small_corners));		
        mViewHolder.plusebtn.setText("1");
          
           LinearLayout.LayoutParams childParam11 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
           childParam11.weight = 70f;         
           mViewHolder.pluse.setLayoutParams(childParam11);
           
           mViewHolder.minus.setOnClickListener(new View.OnClickListener() {
         			
         			@Override
         			public void onClick(View arg0) {
         				// TODO Auto-generated method stub
         				//minus.setVisibility(0);
         				try
         				{
         			        
         			        
         				        if(newOrderActivity.itemExtra.containsKey(currentListData.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+currentListData.get_name())){
         				        	  newOrderActivity.itemExtra.remove(currentListData.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+currentListData.get_name());
         				        	
         				        	  boolean isContain=false;
         			 	                 for (Extra extra : c.get_item().get_extra()) {
         								if(newOrderActivity.itemExtra.containsKey(currentListData.get_item().get_name()+c.get_status()+ String.valueOf(c.get_mark())+extra.get_name())){
         								isContain=true;
         									break;
         								}							
         								}
         			 	                 if(!isContain){
         			 	                //	if(c.get_status().equals("0")){
         			 	                	newOrderActivity.myCartItemsWithExtras.remove(currentListData.get_item().get_name()+ String.valueOf(c.get_mark()));
         			 	                	 int pos=0;
         			 	                	Iterator itr = newOrderActivity.cartItems.iterator();
         	             		            CartItems strElement = null;
         	             		            while(itr.hasNext()){
         	             		            	pos++;
         	             		              strElement = (CartItems)itr.next();
         	             		              if(strElement.get_item().get_name().equals(currentListData.get_item().get_name()))
         	             		              {
         	             		            	 if(strElement.get_mark()==c.get_mark() && strElement.get_status().equals(c.get_status())){
         		             		                itr.remove();
         		             		              break;
         		             		            	  }
         	             		            	
         	             		            	
         	             		              }
         	             		            }
         			 	                	
         			 	                	if(newOrderActivity.myCartHash.containsKey(currentListData.get_item().get_name()+c.get_status())){
         			 	                		c.set_mark(0);
         			 	                		int _quantity= newOrderActivity.myCartHash.get(currentListData.get_item().get_name()+c.get_status()).get_quantity();
         		                        		 newOrderActivity.myCartHash.get(currentListData.get_item().get_name()+c.get_status()).set_quantity(_quantity+1);
         		                        		 newOrderActivity.myCartHash.get(currentListData.get_item().get_name()+c.get_status()).set_mark(0);
         									}else{
         										c.set_mark(0);
         										newOrderActivity.myCartHash.put(currentListData.get_item().get_name()+c.get_status(), c);
         									   // newOrderActivity.cartItems.add(c);
         									   
         									   
         		    	                         if(pos==0){
         		    	                        	 newOrderActivity.cartItems.add(pos,c);
         		    	                         }else{
         		    	                         newOrderActivity.cartItems.add(pos-1,c);
         		    	                         }
         									}
         			 	             //    }
         			 	                 }
         			 	           	        	        		
         	try{
         		                   	 ((ExpandableListView) p).expandGroup(position);
         		                 	((ExpandableListView) p).collapseGroup(position);
         		                 	
         	}catch(Exception e){
         		
         	}
         				        	newOrderActivity.changed=true;
         		 	               Item_selected.Payment_option.setVisibility(View.GONE);
         		 	              //  Toast.makeText(mContext,  currentListData.get_name()+ " Removed", Toast.LENGTH_SHORT).show();
         			 	               
         		 	               Item_selected.cartItemadapter1.notifyDataSetChanged();
         		 	          //    Itemlist_Fragment.adapter.notifyDataSetChanged();
         		 	         //   ItemlistFragment.adapter.notifyDataSetChanged();
         		 	        	 Helper.getListViewSize(Item_selected.listView);
         		 	              Item_selected.activityCallback.onButtonClick();
         		 	           
         		 	              // Itemlist_Fragment.adapter.notifyDataSetChanged();
         		 	                    }
         			        	
         				}
         				catch(Exception e)
         				{
         					Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
         				}
         				
         			}
         		});
        return convertView;
    }

    private class MyViewHolder {
        TextView tvTitle, plusebtn;
        RelativeLayout pluse,minus;
        ImageView imgView;
        //ImageView ivIcon;

        public MyViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.tv_no_extraname);
              plusebtn = (TextView) item.findViewById(R.id.tv_noextra_pluse);
              pluse=(RelativeLayout)item.findViewById(R.id.Rel_Extra_plus);
              minus=(RelativeLayout)item.findViewById(R.id.Rel_Extra_minus);
              imgView = (ImageView) item.findViewById(R.id.no_extra_imag);
         
        }
    }
}


