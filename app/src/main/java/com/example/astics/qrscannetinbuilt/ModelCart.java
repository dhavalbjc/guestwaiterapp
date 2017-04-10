package com.example.astics.qrscannetinbuilt;

import java.util.ArrayList;

public class ModelCart {
	private long id=0;
	private int restroId=0;
	private String tableName="";
   private ArrayList<CartItems> cartProducts = new ArrayList<CartItems>();
   private ArrayList<CartItems> UniqueCartProducts = null;
	private String total="";
	private String time="";
	private String user="";
	private String paid="";

   public ModelCart(long _id, String _table, String _total, String _time) {
		this.setId(_id);
		this.tableName=_table;
		this.total=_total;
		this.setTime(_time);
				
	}
   public ModelCart(long _id, String _table, String _total, String _user, String _paid, String _time) {
		this.setId(_id);
		this.tableName=_table;
		this.total=_total;
		this.user=_user;
		this.paid=_paid;
		this.setTime(_time);
				
	}

public ModelCart() {
	// TODO Auto-generated constructor stub
}

public CartItems getProduct(int pPosition) {
		
		return cartProducts.get(pPosition);
	}
public ArrayList<CartItems> getProducts() {
	
	return cartProducts;
}

	public void setProducts(ArrayList<CartItems> Products) {

		this.cartProducts=Products;

	}

public ArrayList<CartItems> getNotCancelledProducts() {
	boolean isAdded=false;
	ArrayList<CartItems> CartitemByCourse=new ArrayList<CartItems>();
	for (CartItems cartProduct : cartProducts) {
		isAdded=false;
		if(cartProduct.get_item().get_flag().equals("I")&&cartProduct.get_mark()==0){
			for (CartItems cartItems : CartitemByCourse) {
				if(cartItems.get_item().get_flag().equals("I")&&cartItems.get_mark()==0){
					if(cartItems.get_item().get_name().equals(cartProduct.get_item().get_name()) ){
						if(cartItems.get_status().equals(cartProduct.get_status())){
						int qty=cartProduct.get_quantity()+cartItems.get_quantity();
						cartItems.set_quantity(qty);
						isAdded=true;
					}
					}
				}
				}
			}
		if(!cartProduct.get_status().equals("5")&& !isAdded){
			CartItems c=new CartItems();
			c=cartProduct;
			CartitemByCourse.add(c);
		}

	}
	return CartitemByCourse;
}

public ArrayList<CartItems> getAllSameStatusProducts() {
	boolean isAdded=false;
	ArrayList<CartItems> CartitemByCourse=new ArrayList<CartItems>();
	for (CartItems cartProduct : cartProducts) {
		isAdded=false;
		if(cartProduct.get_item().get_flag().equals("I")&&cartProduct.get_mark()==0){
		for (CartItems cartItems : CartitemByCourse) {
			if(cartItems.get_item().get_flag().equals("I")&&cartItems.get_mark()==0){
				if(cartItems.get_item().get_name().equals(cartProduct.get_item().get_name()) ){
					if(cartItems.get_status().equals(cartProduct.get_status())){
					int qty=cartProduct.get_quantity()+cartItems.get_quantity();
					cartItems.set_quantity(qty);
					isAdded=true;
				}
				}
			}
			}
		}
		if( !isAdded){
			CartItems c=new CartItems();
			c=cartProduct;
			CartitemByCourse.add(c);
		}

	}
	return CartitemByCourse;
}

public ArrayList<CartItems> getProductsOfFirstCourse() {
	ArrayList<CartItems> CartitemByCourse=new ArrayList<CartItems>();
	for (CartItems cartProduct : cartProducts) {
		if(cartProduct.get_course()==1)
			CartitemByCourse.add(cartProduct);
	}
	return CartitemByCourse;
}

public ArrayList<CartItems> getProductsOfSecondCourse() {
	ArrayList<CartItems> CartitemByCourse=new ArrayList<CartItems>();
	for (CartItems cartProduct : cartProducts) {
		if(cartProduct.get_course()==2)
			CartitemByCourse.add(cartProduct);
	}
	return CartitemByCourse;
}

public ArrayList<CartItems> getProductsOfThirdCourse() {
	ArrayList<CartItems> CartitemByCourse=new ArrayList<CartItems>();
	for (CartItems cartProduct : cartProducts) {
		if(cartProduct.get_course()==3)
			CartitemByCourse.add(cartProduct);
	}
	return CartitemByCourse;
}

	public void setProduct(CartItems Products) {
		   
		cartProducts.add(Products);
		
	}
	
	public int getCartSize() {
		   
		return cartProducts.size();
		
	}
 
	public boolean checkProductInCart(CartItems aProduct) {
		   
		return cartProducts.contains(aProduct);
		
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getRetroId() {
		return restroId;
	}

	public void setRetroId(int retroId) {
		this.restroId = retroId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}
	public ArrayList<CartItems> getUniqueCartProducts() {
		boolean isAdded=false;
		//ArrayList<CartItems> CartitemByCourse=new ArrayList<CartItems>();
		if(UniqueCartProducts==null){
			UniqueCartProducts=new ArrayList<CartItems>();
		for (CartItems cartProduct : cartProducts) {
			isAdded=false;
			if(cartProduct.get_item().get_flag().equals("I")&&cartProduct.get_mark()==0){
				for (CartItems cartItems : UniqueCartProducts) {
					if(cartItems.get_item().get_flag().equals("I")&&cartItems.get_mark()==0){
						if(cartItems.get_item().get_name().equals(cartProduct.get_item().get_name()) ){
							if(cartItems.get_status().equals(cartProduct.get_status())){
							int qty=cartProduct.get_quantity()+cartItems.get_quantity();
							cartItems.set_quantity(qty);
							isAdded=true;
						}
						}
					}
					}
				}
			if(!cartProduct.get_status().equals("5")&& !isAdded){
				CartItems c=new CartItems();
				c=cartProduct;
				UniqueCartProducts.add(c);
			}
			
		}
		}
		//return CartitemByCourse;
		return UniqueCartProducts;
	}
	public void setUniqueCartProducts(ArrayList<CartItems> uniqueCartProducts) {
		UniqueCartProducts = uniqueCartProducts;
	}

}
