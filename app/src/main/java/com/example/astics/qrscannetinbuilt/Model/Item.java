package com.example.astics.qrscannetinbuilt.Model;

import java.util.ArrayList;

/**
 * Created by Astics INC-08 on 04-Aug-16.
 */
public class Item {
    public ArrayList<String> _size = new ArrayList();
    private int _id = 0;
    private String _name;
    private String _price;
    private String _desciprion;
    private Category _category;

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

    public Category get_category() {
        return _category;
    }

    public void set_category(Category _category) {
        this._category = _category;
    }

    public String get_desciprion() {
        return _desciprion;
    }

    public void set_desciprion(String _desciprion) {
        this._desciprion = _desciprion;
    }
    public void addSize(String extraItem) {
        this._size.add(extraItem);
    }
    public ArrayList<String> getSize(){
        return this._size;
    }
}
