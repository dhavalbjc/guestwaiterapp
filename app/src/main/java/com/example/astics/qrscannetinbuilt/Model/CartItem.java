package com.example.astics.qrscannetinbuilt.Model;

/**
 * Created by Astics INC-08 on 04-Aug-16.
 */
public class CartItem {
    private int _id = 0;
    private String _name;
    private String _price;
    private int _quantity=0;
    private String _size="";

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

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

    public String get_price() {
        return _price;
    }

    public void set_price(String _price) {
        this._price = _price;
    }

    public String get_size() {
        return _size;
    }

    public void set_size(String _size) {
        this._size = _size;
    }
}
