package com.example.astics.qrscannetinbuilt;

public class ECharge {
	private int _id=0;
	private String _category;
	private String _name;
	private String _quantity;
	private String _param;
	public ECharge(int parseInt, String cat, String name, String qty, String param) {
		this._id=parseInt;
		this._category=cat;
		this._name=name;
		this._quantity=qty;
		this._param=param;
		
	}
	public ECharge() {
		// TODO Auto-generated constructor stub
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_category() {
		return _category;
	}
	public void set_category(String _category) {
		this._category = _category;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_quantity() {
		return _quantity;
	}
	public void set_quantity(String _quantity) {
		this._quantity = _quantity;
	}
	public String get_param() {
		return _param;
	}
	public void set_param(String _param) {
		this._param = _param;
	}
}
