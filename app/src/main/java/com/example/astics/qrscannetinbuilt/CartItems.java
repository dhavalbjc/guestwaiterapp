package com.example.astics.qrscannetinbuilt;




public class CartItems {
    // This is the unique id given by the server
  
    // This is a regular field
	private long _id;	  
	private Item _item;
	private int _quantity;
	private int _itemidAscid=0;
	private String _note;
	private int _course=1;
	private int _mark=0;
	private String _status="0";
	private long _cartid;
		    
	public CartItems(long id, Item item, int quantity) {
		this._id=id;
		this.set_item(item);
		this.set_quantity(quantity);			
	}
	
	public CartItems() {
		
	}
	
	public CartItems(long id, String itemName, String itemPrice, int quantity, String _flag, String note, int course, int mark, String status, int itemId) {
		Item item=new Item();
		item.set_name(itemName);
		item.set_price(itemPrice);
		item.set_flag(_flag);
		item.set_id(itemId);
		this._id=id;
		this.set_item(item);
		this.set_quantity(quantity);
		this.set_note(note);
		this.set_course(course);
		this.set_mark(mark);
		this.set_status(status);
	}

	public long get_id() {
		return _id;
	}
	public void set_id(long a) {
		this._id = a;
	}
			
	public int get_quantity() {
		return _quantity;
	}

	public void set_quantity(int _quantity) {
		this._quantity = _quantity;
	}

	public Item get_item() {
		return _item;
	}

	public void set_item(Item _item) {
		this._item = _item;
	}

	public int get_itemidAscid() {
		return _itemidAscid;
	}

	public void set_itemidAscid(int _itemidAscid) {
		this._itemidAscid = _itemidAscid;
	}

	

	public long get_cartid() {
		return _cartid;
	}

	public void set_cartid(long _cartid) {
		this._cartid = _cartid;
	}

	public String get_note() {
		return _note;
	}

	public void set_note(String _note) {
		this._note = _note;
	}

	

	public int get_mark() {
		return _mark;
	}

	public void set_mark(int _mark) {
		this._mark = _mark;
	}

	public String get_status() {
		return _status;
	}

	public void set_status(String _status) {
		this._status = _status;
	}

	public int get_course() {
		return _course;
	}

	public void set_course(int _course) {
		this._course = _course;
	}

   
}
