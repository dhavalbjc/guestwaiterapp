package com.example.astics.qrscannetinbuilt;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class manager {
	 /*public static void addcat(Category cat)
	 {
		 try{
			
		 GamesFragment.myDepartments.put(cat.get_name(), cat);
			GamesFragment.ExpListItems.add(cat);
			Collections.sort(GamesFragment.ExpListItems,new myCateComparable());
			GamesFragment.ExpAdapter.notifyDataSetChanged();
			
		 }
		 catch(Exception e)
		 {
			// Toast.makeText(getActivity(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
		 }
	 }
	 public static void addItem(Item item)
	 {
		 int index=0;
		 try{
			 for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
				   if (GamesFragment.ExpListItems.get(i).get_id()==item.get_category().get_id()) {
					   index=i;
					   GamesFragment.ExpListItems.get(index).addChild(item);
					  // Collections.sort(GamesFragment.ExpListItems.get(index).get_items(),new myItemComparable());
						GamesFragment.ExpAdapter.notifyDataSetChanged();
						GamesFragment.expandAll();
				    break;
				  }
				}		
				
			
				//Toast.makeText(getActivity(), String.valueOf(id), Toast.LENGTH_LONG).show();
		 }
		 catch(Exception e)
		 {
			 //Toast.makeText(getActivity(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
		 }
	 }
   	
	 public static void addExtra(Extra extra) {
		int index=0;
		Item itm=DBAdapter.getItemData(extra.get_item().get_id());
		
		 try{
			 for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
				   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
					   index=i;
					   for (Item i1 : GamesFragment.ExpListItems.get(index).get_items()) {
						if(i1.get_id()==itm.get_id()){
							i1.addExtra(extra);
							Collections.sort(i1.get_extra(),new myExtraComparable());
							GamesFragment.ExpAdapter.notifyDataSetChanged();
							GamesFragment.expandAll();
							 break;
						}
					}
					   
						
				    break;
				  }
				}
			
			
				
			
				//Toast.makeText(getActivity(), String.valueOf(id), Toast.LENGTH_LONG).show();
		 }
		 catch(Exception e)
		 {
			// Toast.makeText(getActivity(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
		 }
	}
	
	public static void UpdateCatName(int id, String name) {
		// TODO Auto-generated method stub
		try{
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==id) {					  
				   GamesFragment.ExpListItems.get(i).set_name(name);
					GamesFragment.ExpAdapter.notifyDataSetChanged();
					GamesFragment.expandAll();
			    break;
			  }
			}	
		}catch(Exception e)
		{
			
		}
	}
	public static void addCatSeq(int id, int seq) {
		// TODO Auto-generated method stub
		try{
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==id) {					  
				   GamesFragment.ExpListItems.get(i).set_sequence(seq);
				   Collections.sort(GamesFragment.ExpListItems,new myCateComparable());
					GamesFragment.ExpAdapter.notifyDataSetChanged();
					GamesFragment.expandAll();
			    break;
			  }
			}	
		
	}catch(Exception e)
	{
		
	}
		
		
	}
	public static void updateItemName(int id, String name) {
		// TODO Auto-generated method stub
		try{
		Item itm=DBAdapter.getItemData(id);
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
					if(i1.get_id()==itm.get_id()){
						i1.set_name(name);
						GamesFragment.ExpAdapter.notifyDataSetChanged();
						GamesFragment.expandAll();
						breakFlag = true;
						 break;
					}
				}
			
			  }
			   if(breakFlag){break;} 
			}	
		}catch(Exception e)
		{
	
		}
		
	}
	public static void updateItemPrice(int id, String price) {
		// TODO Auto-generated method stub
		try{
		Item itm=DBAdapter.getItemData(id);
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
					if(i1.get_id()==itm.get_id()){
						i1.set_price(price);
						GamesFragment.ExpAdapter.notifyDataSetChanged();
						GamesFragment.expandAll();
						 break;
					}
				}
				   
			
			  }
			   if(breakFlag){break;}
			}	
		}catch(Exception e)
		{
			
		}
		
	}
	public static void addItemSeq(int id, int seq) {
		// TODO Auto-generated method stub
		try{
		Item itm=DBAdapter.getItemData(id);
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
					if(i1.get_id()==itm.get_id()){
						i1.set_sequence(seq);
						Collections.sort(GamesFragment.ExpListItems.get(i).get_items(),new myItemComparable());
						GamesFragment.ExpAdapter.notifyDataSetChanged();
						GamesFragment.expandAll();
						breakFlag = true;
						 break;
					}
				}
				   										   
			  }
			   if(breakFlag){break;}
			}	
		}catch(Exception e)
		{
			
		}
	}
	public static void updateItemcategory(int id, int cid) {
		// TODO Auto-generated method stub
try{
		Item itm=DBAdapter.getItemData(id);
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
					if(i1.get_id()==itm.get_id()){
						i1.set_category(DBAdapter.getCategoryData(cid));
						GamesFragment.ExpAdapter.notifyDataSetChanged();
						GamesFragment.expandAll();
						breakFlag = true;
						 break;
					}
				}
			
			  }
			   if(breakFlag){break;}
			}	
}catch(Exception e)
{
	
}
		
	}
	public static void updateExtraName(int id, String name) {
		// TODO Auto-generated method stub
		try{
		Extra extra=DBAdapter.getExtraData(id);
		
		Item itm=DBAdapter.getItemData(extra.get_item().get_id());
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
										   
					  
					   if(i1.get_id()==itm.get_id()){
						   for (Extra ex : i1.get_extra()) {
							if(ex.get_id()==extra.get_id())
							{
								ex.set_name(name);
								GamesFragment.ExpAdapter.notifyDataSetChanged();
								GamesFragment.expandAll();
								 breakFlag = true;
								break ;
								 
							}
							if(breakFlag){break;}
						}
						   if(breakFlag){break;}			
						
					}
					   if(breakFlag){break;}			   
			    
			  }
			}
			   if(breakFlag){break;}
			  
		}
		}catch(Exception e)
		{
			
		}
	}
	public static void updateExtraPrice(int id, String price) {
		// TODO Auto-generated method stub
		try{
		Extra extra=DBAdapter.getExtraData(id);
		boolean breakFlag=false;
		Item itm=DBAdapter.getItemData(extra.get_item().get_id());
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
										   
					  
					   if(i1.get_id()==itm.get_id()){
						   for (Extra ex : i1.get_extra()) {
							if(ex.get_id()==extra.get_id())
							{
								ex.set_price(price);
								
								GamesFragment.ExpAdapter.notifyDataSetChanged();
								GamesFragment.expandAll();
								 breakFlag = true;
								break ;
								 
							}
							if(breakFlag){break;}
						}
						   if(breakFlag){break;}			
						
					}
					   if(breakFlag){break;}			   
			    
			  }
			}
			   if(breakFlag){break;}
			  
		}
		}catch(Exception e)
		{
			
		}
		
	}
	public static void addExtraSeq(int id, int seq) {
		// TODO Auto-generated method stub
		try{
		Extra extra=DBAdapter.getExtraData(id);
		
		Item itm=DBAdapter.getItemData(extra.get_item().get_id());
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
										   
					  
					   if(i1.get_id()==itm.get_id()){
						   for (Extra ex : i1.get_extra()) {
							if(ex.get_id()==extra.get_id())
							{
								ex.set_sequence(seq);
								Collections.sort(i1.get_extra(),new myExtraComparable());
								GamesFragment.ExpAdapter.notifyDataSetChanged();
								GamesFragment.expandAll();
								 breakFlag = true;
								break ;
								 
							}
							if(breakFlag){break;}
						}
						   if(breakFlag){break;}			
						
					}
					   if(breakFlag){break;}			   
			    
			  }
			}
			   if(breakFlag){break;}
			  
		}
		}catch(Exception e)
		{
			
		}
	}
	public static void deleteCategory(int id) {
		// TODO Auto-generated method stub
		try{
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==id) {	
				   GamesFragment.myDepartments.remove(GamesFragment.ExpListItems.get(i).get_name());
				   GamesFragment.ExpListItems.remove(GamesFragment.ExpListItems.get(i));					   
					GamesFragment.ExpAdapter.notifyDataSetChanged();
					GamesFragment.expandAll();
			    break;
			  }
			}
		}catch(Exception e)
		{
			
		}
	}
	public static void deleteItem(int id) {
		// TODO Auto-generated method stub
		try{
		Item itm=DBAdapter.getItemData(id);
		 boolean breakFlag = false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				 		int r=0;			  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
					 
					if(i1.get_id()==itm.get_id()){
						GamesFragment.ExpListItems.get(i).removeChild(r);
						//GamesFragment.ExpListItems.get(i).set_items(DBAdapter.geti)
						GamesFragment.ExpAdapter.notifyDataSetChanged();
						GamesFragment.expandAll();
						breakFlag = true;
						 break;
					}
					++r;
				}
				   
						   
			  }
			   if(breakFlag){break;}
				}
	}catch(Exception e)
	{
		
	}
		
	}
	public static void deleteExtra(int id) {
		// TODO Auto-generated method stub
		try{
		//group.set_name(price1.toString());
		Extra extra=DBAdapter.getExtraData(id);
			
		Item itm=DBAdapter.getItemData(extra.get_item().get_id());
		boolean breakFlag=false;
		for (int i = 0; i < GamesFragment.ExpListItems.size(); i++) {
			   if (GamesFragment.ExpListItems.get(i).get_id()==itm.get_category().get_id()) {
				  
				   for (Item i1 : GamesFragment.ExpListItems.get(i).get_items()) {
										   
					  
					   if(i1.get_id()==itm.get_id()){
						  int r=0;
						   for (Extra ex : i1.get_extra()) {
							  
							if(ex.get_id()==extra.get_id())
							{
								i1.removeChild(r);
								GamesFragment.ExpAdapter.notifyDataSetChanged();
								GamesFragment.expandAll();
								 breakFlag = true;
								break ;
								 
							}
							++r;
							if(breakFlag){break;}
						}
						   if(breakFlag){break;}			
						
					}
					   if(breakFlag){break;}			   
			    
			  }
			}
			   if(breakFlag){break;}
			  
		}
		}catch(Exception e)
		{
			
		}
	}
	/*public static void addCartData(ModelCart cart) {
		// TODO Auto-generated method stub
		 try{
			 cart.setProducts(DBAdapter.getAllCartItemsDataByCartId(cart.getId()));
			 TopRatedFragment.mCart.add(cart);
	    	  TopRatedFragment.mAdapter.notifyDataSetChanged();		
			 }
			 catch(Exception e)
			 {
				// Toast.makeText(getActivity(), String.valueOf(e.getMessage()), Toast.LENGTH_LONG).show();
			 }
	}
	public static void updateCartTime(int id, String time) {
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
     		if(TopRatedFragment.mCart.get(i).getId()==id)
     		{

             	TopRatedFragment.mCart.get(i).setTime(time);
             	TopRatedFragment.mAdapter.notifyDataSetChanged();
     			break;
     		}
     		
     	}
		
	}
	public static void updateCarttotal(int id, String total) {
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
     		if(TopRatedFragment.mCart.get(i).getId()==id)
     		{

             	TopRatedFragment.mCart.get(i).setTotal(total);
             	TopRatedFragment.mAdapter.notifyDataSetChanged();
     			break;
     		}
     		
     	}
		
	}
	public static void updateCartName(int id, String tableName) {
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
     		if(TopRatedFragment.mCart.get(i).getId()==id)
     		{

             	TopRatedFragment.mCart.get(i).setTableName(tableName);
             	TopRatedFragment.mAdapter.notifyDataSetChanged();
     			break;
     		}
     		
     	}
		
	}
	public static void deleteCart(int id) {
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
     		if(TopRatedFragment.mCart.get(i).getId()==id)
     		{

             	TopRatedFragment.mCart.remove(i);
             	TopRatedFragment.mAdapter.notifyDataSetChanged();
     			break;
     		}
     		
     	}
		
	}
	public static void updateCartItemCartid(int get_id, int get_cartid) {
		 boolean breakFlag = false;
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
			
     		if(TopRatedFragment.mCart.get(i).getId()==get_id)
     		{
     			for (CartItems citem: TopRatedFragment.mCart.get(i).getProducts()) {
     				citem.set_cartid(get_cartid);
                 	TopRatedFragment.mAdapter.notifyDataSetChanged();
                 	breakFlag = true;
         			break;
    			}             	
     		}
     		if(breakFlag){break;}
     		
     	}
		
	}
	public static void updateCartItemFlag(int get_id, String get_flag) {
		 boolean breakFlag = false;
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				
	     		if(TopRatedFragment.mCart.get(i).getId()==get_id)
	     		{
	     			for (CartItems citem: TopRatedFragment.mCart.get(i).getProducts()) {
	     				citem.get_item().set_flag(get_flag);
	                 	TopRatedFragment.mAdapter.notifyDataSetChanged();
	                 	breakFlag = true;
	         			break;
	    			}             	
	     		}
	     		if(breakFlag){break;}
	     		
	     	}
		
	}
	public static void updateCartItemQty(int get_id, int get_quantity) {
		 boolean breakFlag = false;
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				
	     		if(TopRatedFragment.mCart.get(i).getId()==get_id)
	     		{
	     			for (CartItems citem: TopRatedFragment.mCart.get(i).getProducts()) {
	     				citem.set_quantity(get_quantity);
	                 	TopRatedFragment.mAdapter.notifyDataSetChanged();
	                 	breakFlag = true;
	         			break;
	    			}             	
	     		}
	     		if(breakFlag){break;}
	     		
	     	}
	}
	public static void updateCartItemPrice(int get_id, String get_price) {
		 boolean breakFlag = false;
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				
	     		if(TopRatedFragment.mCart.get(i).getId()==get_id)
	     		{
	     			for (CartItems citem: TopRatedFragment.mCart.get(i).getProducts()) {
	     				citem.get_item().set_price(get_price);
	                 	TopRatedFragment.mAdapter.notifyDataSetChanged();
	                 	breakFlag = true;
	         			break;
	    			}             	
	     		}
	     		if(breakFlag){break;}
	     		
	     	}
		
	}
	public static void updateCartItemName(int get_id, String get_name) {
		 boolean breakFlag = false;
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				
	     		if(TopRatedFragment.mCart.get(i).getId()==get_id)
	     		{
	     			for (CartItems citem: TopRatedFragment.mCart.get(i).getProducts()) {
	     				citem.get_item().set_name(get_name);
	                 	TopRatedFragment.mAdapter.notifyDataSetChanged();
	                 	breakFlag = true;
	         			break;
	    			}             	
	     		}
	     		if(breakFlag){break;}
	     		
	     	}
		
	}
	public static void updateCartItemId(int get_id, int get_id2) {
		 boolean breakFlag = false;
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				
	     		if(TopRatedFragment.mCart.get(i).getId()==get_id)
	     		{
	     			for (CartItems citem: TopRatedFragment.mCart.get(i).getProducts()) {
	     				citem.get_item().set_id(get_id2);
	                 	TopRatedFragment.mAdapter.notifyDataSetChanged();
	                 	breakFlag = true;
	         			break;
	    			}             	
	     		}
	     		if(breakFlag){break;}
	     		
	     	}
		
	}
	public static void addCartitems(CartItems e) {
		 if(e.get_item().get_flag().equals("I")){
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{				
	     		if(TopRatedFragment.mCart.get(i).getId()==e.get_cartid())
	     		{
	     			TopRatedFragment.mCart.get(i).setProduct(e);
	     			TopRatedFragment.mAdapter.notifyDataSetChanged();                 
         			break;	     			            	
	     		}	     		
	     	}	}
		 else{
			 boolean breakFlag = false;
			 //CartItems itm=DBAdapter.getCartItemsExtraData(e.get_id());
			 for (int i=0;i<TopRatedFragment.mCart.size();i++)
		     	{				
				 if(TopRatedFragment.mCart.get(i).getId()==e.get_cartid())
		     		{
					 for(int m=0;m<TopRatedFragment.mCart.get(i).getProducts().size();m++)
					 {
						 if(TopRatedFragment.mCart.get(i).getProducts().get(m).get_id()==e.get_cartid())
						 {
							 Extra e1=new Extra();
							 e1.set_id(e.get_item().get_id());
							 e1.set_name(e.get_item().get_name());
							 e1.set_price(e.get_item().get_price());
							 TopRatedFragment.mCart.get(i).getProducts().get(m).get_item().addExtra(e1);
							 TopRatedFragment.mAdapter.notifyDataSetChanged();                 
							 breakFlag = true;	
							 break;
						 }
					 }
					
		     		}
				 if(breakFlag){break;}     		
		     	}
		 }
	}
	public static void deleteCartitemExtra(int get_id) {
		 boolean breakFlag = false;
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
			//TopRatedFragment.mCart.get(i)
			for (CartItems item : TopRatedFragment.mCart.get(i).getProducts()) {
				for(int j=0;j<item.get_item().get_extra().size();j++)
				{
				//for (Extra extra : item.get_item().get_extra()) {
					if(item.get_item().get_extra().get(j).get_id()==get_id)
					{
						item.get_item().get_extra().remove(j);
						TopRatedFragment.mAdapter.notifyDataSetChanged();                 
						breakFlag = true;
		     			break;	
					}
				//}
				}
				if(breakFlag){break;}
			}
			if(breakFlag){break;}
     	}
		
	}
	public static void deleteCartItem(int get_id) {
		 boolean breakFlag = false;
		for (int i=0;i<TopRatedFragment.mCart.size();i++)
     	{
			//TopRatedFragment.mCart.get(i)
			for (CartItems item : TopRatedFragment.mCart.get(i).getProducts()) {
				if(item.get_id()==get_id){
					item.set_item(null);
					TopRatedFragment.mAdapter.notifyDataSetChanged();  
					breakFlag = true;
     			break;	
     			
				}
			}
			if(breakFlag){break;}
     	}
		
		
	}
	public static void deleteCartitem(int get_id) {
		 boolean breakFlag = false;
		//CartItems citem=DBAdapter.getCartItemsDataCartitemId(get_id);
		if(DBAdapter.CheckIsDataAlreadyInDBorNot("tbl_cartitems","cartitems_id",get_id))
		{
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				//TopRatedFragment.mCart.get(i)
				for (CartItems item : TopRatedFragment.mCart.get(i).getProducts()) {
					if(item.get_id()==get_id){
						item.set_item(null);
						TopRatedFragment.mAdapter.notifyDataSetChanged();  
						breakFlag = true;
	     			break;	
	     			
					}
				}
				if(breakFlag){break;}
	     	}
			
		}
		else{
			for (int i=0;i<TopRatedFragment.mCart.size();i++)
	     	{
				//TopRatedFragment.mCart.get(i)
				for (CartItems item : TopRatedFragment.mCart.get(i).getProducts()) {
					for(int j=0;j<item.get_item().get_extra().size();j++)
					{
					//for (Extra extra : item.get_item().get_extra()) {
						if(item.get_item().get_extra().get(j).get_id()==get_id)
						{
							item.get_item().get_extra().remove(j);
							TopRatedFragment.mAdapter.notifyDataSetChanged();                 
							breakFlag = true;
			     			break;	
						}
					//}
					}
					if(breakFlag){break;}
				}
				if(breakFlag){break;}
	     	}
		}
		
		
		
	}*/
	public static void syncCatJson(JSONArray jsonMainNode) {
		// TODO Auto-generated method stub
		/*********** Process each JSON Node ************/
		  try{
        int lengthJsonArr = jsonMainNode.length();  
        HashMap<String, Category> entryMap = new HashMap<String, Category>();
        for(int i=0; i < lengthJsonArr; i++) 
        {
       	 /****** Get Object for each JSON node.***********/
            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
             
            /******* Fetch node values **********/
            String cid       = jsonChildNode.optString("cid").toString();
            String name       = jsonChildNode.optString("cat_name").toString();
            String seq       = jsonChildNode.optString("cat_seq").toString();
          
           Category cat=new Category();
           cat.set_id(Integer.parseInt(cid));
           cat.set_name(name);
           cat.set_sequence(Integer.parseInt(seq));
            entryMap.put(String.valueOf(cid), cat);
         //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
          	                         
       }
        List<Category> allCat=DBAdapter.getAllCategoryData();
        for (Category e : allCat) {
       	// Toast.makeText(getApplicationContext(),e.get_name(), Toast.LENGTH_LONG).show();
	             
       	 Category match = entryMap.get(String.valueOf(e.get_id()));
       	  
               if (match != null) {
              // 	 Toast.makeText(getApplicationContext(),"if match!=null"+ match.get_name(), Toast.LENGTH_LONG).show();
 	               
               	 entryMap.remove(String.valueOf(e.get_id()));
               	 /*if ((match.get_name() != null && !match.get_name().equals(e.get_name())) ||			    	                                     
                            (match.get_sequence() != e.get_sequence())) {
               		 
               	 }*/
               	 if ((match.get_name() != null && !match.get_name().equals(e.get_name())))	{		    	                                     
                           
               		 DBAdapter.updateCatName(e.get_id(),match.get_name());
               		// manager.UpdateCatName(e.get_id(),match.get_name());
               		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
         	               
               	 }
               	                                   
               	 if(match.get_sequence() != e.get_sequence()) {
               		 DBAdapter.addCatSeq(e.get_id(),match.get_sequence());
               		// manager.addCatSeq(e.get_id(),match.get_sequence());
               		// Toast.makeText(getApplicationContext(),"Update"+ match.get_sequence(), Toast.LENGTH_LONG).show();
         	               
               		 
               	 }
               }
               else
               {
               	
               	DBAdapter.deleteCategory(e.get_id());
              // 	manager.deleteCategory(e.get_id());
             //  	Toast.makeText(getApplicationContext(),"Delete", Toast.LENGTH_LONG).show();
  	               
               }
        }
        for (Category e : entryMap.values()) {
            
           DBAdapter.addCategoryData(e);
           //manager.addcat(e);
           //Toast.makeText(getApplicationContext(),"Add", Toast.LENGTH_LONG).show();
	           
           
        }
		  }
		  catch(Exception e)
		  {}
    /****************** End Parse Response JSON Data *************/
        
     //Add user data to controller class UserDataArr arraylist
    // gridView.setAdapter(new CustomGridAdapter(getBaseContext(), aController));
       
		
	}
	public static void syncItemJson(JSONArray jsonMainNode) {
		// TODO Auto-generated method stub
		/*********** Process each JSON Node ************/
		  try{
      int lengthJsonArr = jsonMainNode.length();  
      HashMap<String, Item> entryMap = new HashMap<String, Item>();
      for(int i=0; i < lengthJsonArr; i++) 
      {
     	 /****** Get Object for each JSON node.***********/
          JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
           
          /******* Fetch node values **********/
          String item_id       = jsonChildNode.optString("item_id").toString();
          String item_name       = jsonChildNode.optString("item_name").toString();
          String item_price       = jsonChildNode.optString("item_price").toString();
          String item_flag       = jsonChildNode.optString("item_flag").toString();
          String item_seq       = jsonChildNode.optString("item_seq").toString();
          String cid       = jsonChildNode.optString("cid").toString();
        
          Item item=new Item();
          item.set_id(Integer.parseInt(item_id));
          item.set_name(item_name);
          item.set_price(item_price);
          item.set_flag(item_flag);
          item.set_sequence(Integer.parseInt(item_seq));
          item.set_category(DBAdapter.getCategoryData(Integer.parseInt(cid)));
                   
          entryMap.put(String.valueOf(item_id), item);
       //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
        	                         
     }
      List<Item> allCat=DBAdapter.getAllItemDatas();
      for (Item e : allCat) {
     	// Toast.makeText(getApplicationContext(),e.get_name(), Toast.LENGTH_LONG).show();
	             
     	 Item match = entryMap.get(String.valueOf(e.get_id()));
     	  
             if (match != null) {
            // 	 Toast.makeText(getApplicationContext(),"if match!=null"+ match.get_name(), Toast.LENGTH_LONG).show();
	               
             	 entryMap.remove(String.valueOf(e.get_id()));
             	 /*if ((match.get_name() != null && !match.get_name().equals(e.get_name())) ||			    	                                     
                          (match.get_sequence() != e.get_sequence())) {
             		 
             	 }*/
             	 if ((match.get_name() != null && !match.get_name().equals(e.get_name())))	{		    	                                     
                         
             		 DBAdapter.updateItemName(e.get_id(),match.get_name());
             		 //manager.updateItemName(e.get_id(),match.get_name());
             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
       	               
             	 }
             	if (match.get_price() != e.get_price())	{		    	                                     
                    
            		 DBAdapter.updateItemPrice(e.get_id(),match.get_price());
            		// manager.updateItemPrice(e.get_id(),match.get_price());
            		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
      	               
            	 }
             	                                   
             	 if(match.get_sequence() != e.get_sequence()) {
             		 DBAdapter.addItemSeq(e.get_id(),match.get_sequence());
             		// manager.addItemSeq(e.get_id(),match.get_sequence());
             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_sequence(), Toast.LENGTH_LONG).show();
       	               
             		  }
             	 if(match.get_category().get_id() != e.get_category().get_id()) {
             		 DBAdapter.updateItemcategory(e.get_id(),match.get_sequence());
             		// manager.updateItemcategory(e.get_id(),match.get_sequence());
             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_sequence(), Toast.LENGTH_LONG).show();
       	               
             		 	 }
             }
             else
             {
             	             	
             //	manager.deleteItem(e.get_id());
             	DBAdapter.deleteItem(e.get_id());
           //  	Toast.makeText(getApplicationContext(),"Delete", Toast.LENGTH_LONG).show();
	               
             }
      }
      for (Item e : entryMap.values()) {
          
         DBAdapter.addItemData(e);
         //manager.addItem(e);
         //Toast.makeText(getApplicationContext(),"Add", Toast.LENGTH_LONG).show();
	               
      }
		  }
		  catch(Exception e)
		  {}
  /****************** End Parse Response JSON Data *************/
      
		
	}
	public static void syncExtraJson(JSONArray jsonMainNode) {
		// TODO Auto-generated method stub
		  try{
		      int lengthJsonArr = jsonMainNode.length();  
		      HashMap<String, Extra> entryMap = new HashMap<String, Extra>();
		      for(int i=0; i < lengthJsonArr; i++) 
		      {
		     	 /****** Get Object for each JSON node.***********/
		          JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		           
		          /******* Fetch node values **********/
		          String extra_id       = jsonChildNode.optString("extra_id").toString();
		          String extra_name       = jsonChildNode.optString("extra_name").toString();
		          String extra_price       = jsonChildNode.optString("extra_price").toString();
		          String extra_seq       = jsonChildNode.optString("extra_seq").toString();
		          String itemid       = jsonChildNode.optString("item_id").toString();
		          
		        
		          Extra Extraitem=new Extra();
		          Extraitem.set_id(Integer.parseInt(extra_id));
		          Extraitem.set_name(extra_name);
		          Extraitem.set_price(extra_price);
		         
		          Extraitem.set_sequence(Integer.parseInt(extra_seq));
		          Extraitem.set_item(DBAdapter.getItemData(Integer.parseInt(itemid)));
		                   
		          entryMap.put(String.valueOf(extra_id), Extraitem);
		       //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
		        	                         
		     }
		      List<Extra> allCat=DBAdapter.getAllExtraData();
		      for (Extra e : allCat) {
		     	// Toast.makeText(getApplicationContext(),e.get_name(), Toast.LENGTH_LONG).show();
			             
		     	 Extra match = entryMap.get(String.valueOf(e.get_id()));
		     	  
		             if (match != null) {
		            // 	 Toast.makeText(getApplicationContext(),"if match!=null"+ match.get_name(), Toast.LENGTH_LONG).show();
			               
		             	 entryMap.remove(String.valueOf(e.get_id()));
		             	 /*if ((match.get_name() != null && !match.get_name().equals(e.get_name())) ||			    	                                     
		                          (match.get_sequence() != e.get_sequence())) {
		             		 
		             	 }*/
		             	 if ((match.get_name() != null && !match.get_name().equals(e.get_name())))	{		    	                                     
		                         
		             		 DBAdapter.updateExtraName(e.get_id(),match.get_name());
		             		// manager.updateExtraName(e.get_id(),match.get_name());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		       	               
		             	 }
		             	if (match.get_price() != e.get_price())	{		    	                                     
		                    
		            		 DBAdapter.updateExtraPrice(e.get_id(),match.get_price());
		            		// manager.updateExtraPrice(e.get_id(),match.get_price());
		            		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		      	               
		            	 }
		             	                                   
		             	 if(match.get_sequence() != e.get_sequence()) {
		             		 DBAdapter.addExtraSeq(e.get_id(),match.get_sequence());
		             		// manager.addExtraSeq(e.get_id(),match.get_sequence());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_sequence(), Toast.LENGTH_LONG).show();
		       	               
		             		  }
		             	
		             }
		             else
		             {
		             	             	
		             	//manager.deleteExtra(e.get_id());
		             	DBAdapter.deleteExtra(e.get_id());
		           //  	Toast.makeText(getApplicationContext(),"Delete", Toast.LENGTH_LONG).show();
			               
		             }
		      }
		      for (Extra e : entryMap.values()) {
		          
		         DBAdapter.addExtraData(e);
		        // manager.addExtra(e);
		         //Toast.makeText(getApplicationContext(),"Add", Toast.LENGTH_LONG).show();
			               
		      }
				  }
				  catch(Exception e)
				  {}
		  /****************** End Parse Response JSON Data *************/
		      
		
	}
	public static void syncCartJson(JSONArray jsonMainNode) {
		// TODO Auto-generated method stub
		 try{
		      int lengthJsonArr = jsonMainNode.length();  
		      HashMap<String, ModelCart> entryMap = new HashMap<String, ModelCart>();
		      for(int i=0; i < lengthJsonArr; i++) 
		      {
		     	 /****** Get Object for each JSON node.***********/
		          JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		           
		          /******* Fetch node values **********/
		          String cart_id       = jsonChildNode.optString("id").toString();
		          String cart_table       = jsonChildNode.optString("cart_table").toString();
		          String cart_total       = jsonChildNode.optString("cart_total").toString();
		          String cart_user       = jsonChildNode.optString("cart_user").toString();
		          String cart_paid       = jsonChildNode.optString("cart_paid").toString();
		          String created_at       = jsonChildNode.optString("created_at").toString();
		          //String itemid       = jsonChildNode.optString("itemid").toString();
		          
		        ModelCart cart=new ModelCart();
		        cart.setId(Integer.parseInt(cart_id));
		        cart.setTableName(cart_table);
		        cart.setTotal(cart_total);
		        cart.setUser(cart_user);
		        cart.setPaid(cart_paid);
		        cart.setTime(created_at);
		         		                   
		          entryMap.put(String.valueOf(cart_id), cart);
		       //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
		        	                         
		     }
		      List<ModelCart> allCat=DBAdapter.getAllCartData();
		      for (ModelCart e : allCat) {
		     	          
		     	 ModelCart match = entryMap.get(String.valueOf(e.getId()));
		     	  
		             if (match != null) {
		                  
		             	 entryMap.remove(String.valueOf(e.getId()));
		             	 
		             	 if ((match.getTableName() != null && !match.getTableName().equals(e.getTableName())))	{		    	                                     
		                         
		             		 DBAdapter.updateCartTTT(e.getId(),"cart_table",match.getTableName());
		             		//manager.updateCartName(e.getId(),match.getTableName());
		             		     
		             	 }
		             	if ((match.getTableName() != null && !match.getTotal().equals(e.getTotal())))	{		    	                                     
		                    
		            		 DBAdapter.updateCartTTT(e.getId(),"cart_total",match.getTotal());
		            		// manager.updateCarttotal(e.getId(),match.getTotal());
		            		     
		            	 }
		             	
		             	if ((match.getTime() != null && !match.getTime().equals(e.getTime())))	{
		             		 DBAdapter.updateCartTTT(e.getId(),"cart_time",match.getTime());
		             		//manager.updateCartTime(e.getId(),match.getTime());
			                	  
		             		  }
		             	
		             }
		             else
		             {
		             	             	
		           
		            //	manager.deleteCart(e.getId());
		             	DBAdapter.deleteCart(e.getId());
		         
		             }
		      }
		      for (ModelCart e : entryMap.values()) {
		          
		    
		    	  DBAdapter.addCartData(e);
		    	//  manager.addCartData(e);
		         
		    	 
		      }
				  }
				  catch(Exception e)
				  {}
		  /****************** End Parse Response JSON Data *************/
		
	}
	public static void syncCartItemsJson(JSONArray jsonMainNode) {
		/*********** Process each JSON Node ************/
		  try{
    int lengthJsonArr = jsonMainNode.length();  
    HashMap<String, CartItems> entryMap = new HashMap<String, CartItems>();
    for(int i=0; i < lengthJsonArr; i++) 
    {
   	 /****** Get Object for each JSON node.***********/
        JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
         
        /******* Fetch node values **********/
        String cartitem_id       = jsonChildNode.optString("id").toString();
        String cartitem_itemid       = jsonChildNode.optString("cartitem_itemid").toString();
        String cartitem_name       = jsonChildNode.optString("cartitem_name").toString();
        String cartitem_price       = jsonChildNode.optString("cartitem_price").toString();
        String cartitem_quantity       = jsonChildNode.optString("cartitem_quantity").toString();
        String cartitem_flag       = jsonChildNode.optString("cartitem_flag").toString();
        String cartitem_note       = jsonChildNode.optString("cartitem_note").toString();
        String cartitem_course       = jsonChildNode.optString("cartitem_course").toString();
        String cartitem_mark       = jsonChildNode.optString("cartitem_mark").toString();
        String cartitem_status       = jsonChildNode.optString("cartitem_status").toString();
        String cart_id       = jsonChildNode.optString("cart_id").toString();
      
        Item item=new Item();
        item.set_id(Integer.parseInt(cartitem_itemid));
        item.set_name(cartitem_name);
        item.set_price(cartitem_price);
        item.set_flag(cartitem_flag);
        CartItems citem=new CartItems();
        citem.set_id(Integer.parseInt(cartitem_id));
        citem.set_quantity(Integer.parseInt(cartitem_quantity));
        citem.set_note(cartitem_note);
        citem.set_course(Integer.parseInt(cartitem_course));
        citem.set_mark(Integer.parseInt(cartitem_mark));
        citem.set_status(cartitem_status);
        citem.set_item(item);
       // ModelCart cart=DBAdapter.getCartData(Integer.parseInt(cart_id));
        citem.set_cartid(Integer.parseInt(cart_id));
        //item.set_sequence(Integer.parseInt(item_seq));
        //item.set_category(DBAdapter.getCategoryData(Integer.parseInt(cid)));
                 
        entryMap.put(String.valueOf(cartitem_id), citem);
     //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
      	                         
   }
    List<CartItems> allCat=DBAdapter.getAllCartItemsData();
    for (CartItems e : allCat) {
   	// Toast.makeText(getApplicationContext(),e.get_name(), Toast.LENGTH_LONG).show();
	             
   	 CartItems match = entryMap.get(String.valueOf(e.get_id()));
   	  
           if (match != null) {
          // 	 Toast.makeText(getApplicationContext(),"if match!=null"+ match.get_name(), Toast.LENGTH_LONG).show();
	               
           	 entryMap.remove(String.valueOf(e.get_id()));
           	 /*if ((match.get_name() != null && !match.get_name().equals(e.get_name())) ||			    	                                     
                        (match.get_sequence() != e.get_sequence())) {
           		 
           	 }*/
           	 if ((match.get_item().get_id() !=match.get_item().get_id()))	{		    	                                     
                 
           		 DBAdapter.updateCartItemQFID(e.get_id(),"cartitems_itemid",match.get_item().get_id());
           		//manager.updateCartItemId(e.get_id(),match.get_item().get_id());
           	//	 manager.updateItemName(e.get_id(),match.get_item().get_name());
           		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
     	               
           	 }
           	 if ((match.get_item().get_name() != null && !match.get_item().get_name().equals(e.get_item().get_name())))	{		    	                                     
                       
           		 DBAdapter.updateCartItemNPF(e.get_id(),"cartitems_name",match.get_item().get_name());
           	//	manager.updateCartItemName(e.get_id(),match.get_item().get_name());
           	//	 manager.updateItemName(e.get_id(),match.get_item().get_name());
           		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
     	               
           	 }
           	if (match.get_item().get_price() != e.get_item().get_price())	{		    	                                     
                  
          		 DBAdapter.updateCartItemNPF(e.get_id(),"cartitems_price",match.get_item().get_price());
          	//	manager.updateCartItemPrice(e.get_id(),match.get_item().get_price());
          		// manager.updateItemPrice(e.get_id(),match.get_item().get_price());
          		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
    	               
          	 }
           	                                   
           	 if(match.get_quantity() != e.get_quantity()) {
           		 DBAdapter.updateCartItemQFID(e.get_id(),"cartitems_quantity",match.get_quantity());           		 
           	//	manager.updateCartItemQty(e.get_id(),match.get_quantity());
           		// manager.addItemSeq(e.get_id(),match.get_sequence());
           		// Toast.makeText(getApplicationContext(),"Update"+ match.get_sequence(), Toast.LENGTH_LONG).show();
     	               
           		  }
           	 if ((match.get_item().get_flag() != null && !match.get_item().get_flag().equals(e.get_item().get_flag())))	{		    	                                     
                 
           		 DBAdapter.updateCartItemNPF(e.get_id(),"cartitems_flag",match.get_item().get_flag());
           	//	manager.updateCartItemFlag(e.get_id(),match.get_item().get_flag());
           	//	 manager.updateItemName(e.get_id(),match.get_item().get_name());
           		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
     	               
           	 }
        	 if(match.get_cartid() != e.get_cartid()) {
           		 DBAdapter.updateCartItemQFID(e.get_id(),"cartitems_fid",match.get_cartid());
           	//	manager.updateCartItemCartid(e.get_id(),match.get_cartid());
           		// manager.addItemSeq(e.get_id(),match.get_sequence());
           		// Toast.makeText(getApplicationContext(),"Update"+ match.get_sequence(), Toast.LENGTH_LONG).show();
     	               
           		  }
           }
           else
           {
           	             	
           //	manager.deleteItem(e.get_id());
        	  // manager.deleteCartitem(e.get_id());
        	   if(e.get_item().get_flag().equals("I"))
        	   {
        		//   manager.deleteCartItem(e.get_id());
        	   }
        	   else{
        		 //  manager.deleteCartitemExtra(e.get_id());
        	   }
           	DBAdapter.deleteCartitem(e.get_id());
         //  	Toast.makeText(getApplicationContext(),"Delete", Toast.LENGTH_LONG).show();
	               
           }
    }
    for (CartItems e : entryMap.values()) {
        
       DBAdapter.addCartitems(e,e.get_cartid());
      // manager.addCartitems(e);
     //  manager.addItem(e);
       //Toast.makeText(getApplicationContext(),"Add", Toast.LENGTH_LONG).show();
	               
    }
		  }
		  catch(Exception e)
		  {}
/****************** End Parse Response JSON Data *************/
    
		
		
	}
	
	
	
	public static void syncStaffJson(JSONArray jsonMainNode) {
		 try{
		      int lengthJsonArr = jsonMainNode.length();  
		      HashMap<String, Staff> entryMap = new HashMap<String, Staff>();
		      for(int i=0; i < lengthJsonArr; i++) 
		      {
		     	 /****** Get Object for each JSON node.***********/
		          JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		           
		          /******* Fetch node values **********/
		          String sid       = jsonChildNode.optString("sid").toString();
		          String s_fname       = jsonChildNode.optString("s_fname").toString();
		          String s_lname       = jsonChildNode.optString("s_lname").toString();
		          String s_email       = jsonChildNode.optString("s_email").toString();
		          String s_password       = jsonChildNode.optString("s_password").toString();
		          String s_roll       = jsonChildNode.optString("s_roll").toString();
		          
		        Staff staff=new Staff();
		        staff.set_staff_id(Integer.parseInt(sid));
		        staff.set_staff_fname(s_fname);
		        staff.set_staff_lname(s_lname);
		        staff.set_staff_email(s_email);
		        staff.set_staff_password(s_password);
		        staff.set_staff_roll(s_roll);
		        		                   
		          entryMap.put(String.valueOf(sid), staff);
		       //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
		        	                         
		     }
		      List<Staff> allCat=DBAdapter.getAllStaff();
		      for (Staff e : allCat) {
		     	// Toast.makeText(getApplicationContext(),e.get_name(), Toast.LENGTH_LONG).show();
			             
		    	  Staff match = entryMap.get(String.valueOf(e.get_staff_id()));
		     	  
		             if (match != null) {
		            // 	 Toast.makeText(getApplicationContext(),"if match!=null"+ match.get_name(), Toast.LENGTH_LONG).show();
			               
		             	 entryMap.remove(String.valueOf(e.get_staff_id()));
		             	 /*if ((match.get_name() != null && !match.get_name().equals(e.get_name())) ||			    	                                     
		                          (match.get_sequence() != e.get_sequence())) {
		             		 
		             	 }*/
		             	 if ((match.get_staff_fname() != null && !match.get_staff_fname().equals(e.get_staff_fname())))	{		    	                                     
		                         
		             		 DBAdapter.updateStaffNEPR(e.get_staff_id(),"staff_fname",match.get_staff_fname());
		             		// manager.updateExtraName(e.get_id(),match.get_name());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		       	               
		             	 }
		             	 
		             	if ((match.get_staff_lname() != null && !match.get_staff_lname().equals(e.get_staff_lname())))	{		    	                                     
	                         
		             		 DBAdapter.updateStaffNEPR(e.get_staff_id(),"staff_lname",match.get_staff_lname());
		             		// manager.updateExtraName(e.get_id(),match.get_name());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		       	               
		             	 }
		             	if ((match.get_staff_email() != null && !match.get_staff_email().equals(e.get_staff_email())))	{		    	                                     
	                         
		             		 DBAdapter.updateStaffNEPR(e.get_staff_id(),"staff_email",match.get_staff_email());
		             		// manager.updateExtraName(e.get_id(),match.get_name());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		       	               
		             	 }
		             	if ((match.get_staff_password() != null && !match.get_staff_password().equals(e.get_staff_password())))	{		    	                                     
	                         
		             		 DBAdapter.updateStaffNEPR(e.get_staff_id(),"staff_password",match.get_staff_password());
		             		// manager.updateExtraName(e.get_id(),match.get_name());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		       	               
		             	 }
		             	if ((match.get_staff_roll() != null && !match.get_staff_roll().equals(e.get_staff_roll())))	{		    	                                     
	                         
		             		 DBAdapter.updateStaffNEPR(e.get_staff_id(),"staff_roll",match.get_staff_roll());
		             		// manager.updateExtraName(e.get_id(),match.get_name());
		             		// Toast.makeText(getApplicationContext(),"Update"+ match.get_name(), Toast.LENGTH_LONG).show();
		       	               
		             	 }
		             	
		             	
		             }
		             else
		             {
		             	             	
		             	//manager.deleteExtra(e.get_id());
		             	DBAdapter.deleteStaff(e.get_staff_id());
		           //  	Toast.makeText(getApplicationContext(),"Delete", Toast.LENGTH_LONG).show();
			               
		             }
		      }
		      for (Staff e : entryMap.values()) {
		          
		         DBAdapter.addStaffData(e);
		        // manager.addExtra(e);
		         //Toast.makeText(getApplicationContext(),"Add", Toast.LENGTH_LONG).show();
			               
		      }
				  }
				  catch(Exception e)
				  {}
		  /****************** End Parse Response JSON Data *************/
		      
		
	}
	
	
	public static void syncEchargeJson(JSONArray jsonMainNode) {
		try{
		      int lengthJsonArr = jsonMainNode.length();  
		      HashMap<String, ECharge> entryMap = new HashMap<String, ECharge>();
		      for(int i=0; i < lengthJsonArr; i++) 
		      {
		     	 /****** Get Object for each JSON node.***********/
		          JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		           
		          /******* Fetch node values **********/
		          String echarge_id       = jsonChildNode.optString("echarge_id").toString();
		          String echarge_category       = jsonChildNode.optString("echarge_category").toString();
		          String echarge_name       = jsonChildNode.optString("echarge_name").toString();
		          String echarge_quantity       = jsonChildNode.optString("echarge_quantity").toString();
		          String echarge_param       = jsonChildNode.optString("echarge_param").toString();
		         
		          
		        ECharge echarge=new ECharge();
		        echarge.set_id(Integer.parseInt(echarge_id));
		        echarge.set_category(echarge_category);
		        echarge.set_name(echarge_name);
		        echarge.set_quantity(echarge_quantity);
		        echarge.set_param(echarge_param);
		        
		         		                   
		          entryMap.put(String.valueOf(echarge_id), echarge);
		       //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
		        	                         
		     }
		     
		      
		      for (ECharge e : entryMap.values()) {
		          
		    
		    	  DBAdapter.addEChargeData(e);
		    	//  manager.addCartData(e);
		         
		    	 
		      }
				  }
				  catch(Exception e)
				  {}
		  /****************** End Parse Response JSON Data *************/
		
	}
	public static void syncPrinterJson(JSONArray jsonMainNode) {
		try{
		      int lengthJsonArr = jsonMainNode.length();  
		      HashMap<String, Printer> entryMap = new HashMap<String, Printer>();
		      for(int i=0; i < lengthJsonArr; i++) 
		      {
		     	 /****** Get Object for each JSON node.***********/
		          JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
		           
		          /******* Fetch node values **********/
		          String printer_id       = jsonChildNode.optString("printer_id").toString();
		          String printer_protocol       = jsonChildNode.optString("printer_protocol").toString();
		          String printer_connection       = jsonChildNode.optString("printer_connection").toString();
		          String printer_mac       = jsonChildNode.optString("printer_mac").toString();
		          String printer_ip       = jsonChildNode.optString("printer_ip").toString();
		          String printer_model       = jsonChildNode.optString("printer_model").toString();
		          String printer_paperwidth       = jsonChildNode.optString("printer_paperwidth").toString();
		          String printer_name       = jsonChildNode.optString("printer_name").toString();
		          String printer_printorder       = jsonChildNode.optString("printer_printorder").toString();
		          String printer_enable       = jsonChildNode.optString("printer_enable").toString();
		          String printer_status       = jsonChildNode.optString("printer_status").toString();
		         
		         
		          
		        Printer printer=new Printer();
		        printer.set_id(Integer.parseInt(printer_id));
		        printer.set_protocol(printer_protocol);
		        printer.set_connection(printer_connection);
		        printer.set_mac(printer_mac);
		        printer.set_ip(printer_ip);
		        printer.set_model(printer_model);
		        printer.set_paperwidth(printer_paperwidth);
		        printer.set_name(printer_name);
		        printer.set_printorder(printer_printorder);
		        printer.set_enable(printer_enable);
		        printer.set_status(printer_status);
		       
		        
		         		                   
		          entryMap.put(String.valueOf(printer_id), printer);
		       //   Toast.makeText(getApplicationContext(), cat.get_name(), Toast.LENGTH_LONG).show();
		        	                         
		     }
		     
		      
		      for (Printer p : entryMap.values()) {
		          
		    
		    	  DBAdapter.addPrinterData(p);
		    	//  manager.addCartData(e);
		         
		    	 
		      }
				  }
				  catch(Exception e)
				  {}
		  /****************** End Parse Response JSON Data *************/
		
	}
	

}
