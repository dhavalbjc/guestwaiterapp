package com.example.astics.qrscannetinbuilt;

import java.util.ArrayList;


public class Category {

	private int _id=0;
	private String _name;
	private int _sequence;
   
    private ArrayList<Item> _items= new ArrayList<Item>();
   
    public Category(int id, String name, int sequence) {

    	_id=id;
    	_name=name;
    	set_sequence(sequence);
	}

	public Category() {
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

	public ArrayList<Item> get_items() {
		return _items;
	}

	public void set_items(ArrayList<Item> _items) {
		this._items = _items;
	}
	public Item getChild(int childPosition) {
		  return _items.get(childPosition);
		 }
	
	

		 public void addChild(Item childItem) {
		   _items.add(childItem);
		 }
		

		 public void removeChild(int childPosition) {
		   _items.remove(childPosition);
		 }
		 public void removeChild(Item childPosition) {
			   _items.remove(childPosition);
			 }
		

		public int get_sequence() {
			return _sequence;
		}

		public void set_sequence(int a) {
			this._sequence = a;
		}

		public ArrayList<Item> get_extras() {
			ArrayList<Item> ext=new ArrayList<Item>();
			for (Item item : this._items) {
				if(item.get_flag().toString().equals("E"))
				{ext.add(item);}
							}
			return ext;
		}

		

}