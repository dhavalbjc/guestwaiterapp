package com.example.astics.qrscannetinbuilt.Model;

import java.util.ArrayList;

/**
 * Created by Astics INC-08 on 04-Aug-16.
 */
public class Category {
    private int _id = 0;
    private String _name;
    private ArrayList<Item> _items = new ArrayList();

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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
}
