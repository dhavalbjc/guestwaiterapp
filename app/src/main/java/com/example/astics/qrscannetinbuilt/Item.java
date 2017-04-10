package com.example.astics.qrscannetinbuilt;

import java.util.ArrayList;


public class Item {
    // This is the unique id given by the server
  
public ArrayList<Extra> _extra=new ArrayList<Extra>();
    // This is a regular field
	private int _id=0;
	private String _name;
	private String _price;
	private int _sequence;
	private Category _category;
	 	private String _flag;;
	    
	public Item(int id, String name, String price, Category categoryData,
				int sequence, String flag) {
		this._id=id;
		this._name=name;
		//this._price=price;
		Float Rprice= Float.parseFloat(price);
		this._price = String.format("%.2f", Rprice );
		this._sequence=sequence;
		//set_sequence(sequence);
		this._category=categoryData;
		this.set_flag(flag);
		//this._extra = new ArrayList<Extra>();
	}
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	 public void removeChild(int childPosition) {
		   _extra.remove(childPosition);
		 }
	 public void removeChild(Extra childPosition) {
		   _extra.remove(childPosition);
		 }
	public int get_id() {
		return _id;
	}
	public void set_id(int a) {
		this._id = a;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_price() {
		return _price;
	}
	public void set_price(String _price) {
		try{
		Float Rprice= Float.parseFloat(_price);
		this._price = String.format("%.2f", Rprice );
		}catch(Exception e)
		{
			Float Rprice=0f;
			this._price = String.format("%.2f", Rprice );
		}
	}
	public Category get_category() {
		return _category;
	}
	public void set_category(Category _category) {
		this._category = _category;
	}
	public ArrayList<Extra> get_extra() {
		return _extra;
	}
	public void set_extra(ArrayList<Extra> _extra) {
		this._extra = _extra;
	}
	public int get_sequence() {
		return _sequence;
	}
	
	public void set_sequence(int _sequence) {
		this._sequence = _sequence;
	}
	 public void addExtra(Extra extraItem) {
		   _extra.add(extraItem);
		 }
	 public void addExtra(Item extraItem) {
		 //This extra is category extra so we set id to 0 because this indicates category  extra 
		 // and we find price by in item taable by ref id.
		 Extra e=new Extra();
		 e.set_id(0);
		// e.set_refId(extraItem.get_id());
		 e.set_name(extraItem.get_name());
		 e.set_price(extraItem.get_price());
		 e.set_item(this);
		   _extra.add(e);
		 }

	public String get_flag() {
		return _flag;
	}

	public void set_flag(String _flag) {
		this._flag = _flag;
	}

   
}
