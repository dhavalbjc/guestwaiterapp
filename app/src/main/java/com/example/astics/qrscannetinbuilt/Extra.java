package com.example.astics.qrscannetinbuilt;



public class Extra {
    // This is the unique id given by the server
  
    // This is a regular field
	private int _id=0;
	private String _name;
	private String _price;
	private int _refId;
	private int _sequence;
	private Item _item;
	
	    
	public Extra(int id, String name, String price, int sequence,
				 Item itemData) {
		this._id=id;
		this._name=name;
		//this._price=price;
		Float Rprice= Float.parseFloat(price);
		this._price = String.format("%.2f", Rprice );
		set_sequence(sequence);
		this.set_item(itemData);
		//this._extra = new ArrayList<Extra>();
	}
	public Extra() {
		//_extra = new ArrayList<Extra>();
		// TODO Auto-generated constructor stub
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
		//this._price = _price;
		try{
		Float Rprice= Float.parseFloat(_price);
		this._price = String.format("%.2f", Rprice );
		}catch(Exception e){
			this._price = "0.00";
		}
	}
	
	
	public int get_sequence() {
		return _sequence;
	}
	public void set_sequence(int _sequence) {
		this._sequence = _sequence;
	}
	public Item get_item() {
		return _item;
	}
	public void set_item(Item _item) {
		this._item = _item;
	}
	public int get_refId() {
		return _refId;
	}
	public void set_refId(int _refId) {
		this._refId = _refId;
	}
    
   
}
