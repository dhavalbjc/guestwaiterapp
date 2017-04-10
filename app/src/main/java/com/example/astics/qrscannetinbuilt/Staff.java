package com.example.astics.qrscannetinbuilt;

public class Staff {
	
	private int _staff_id;
	private String _staff_fname;
	private String _staff_lname;
	private String _staff_email;
	private String _staff_password;
	private String _staff_roll;
	public Staff(String name, String email)
	{
		this._staff_fname=name;
		this._staff_lname="";
		this._staff_email=email;
		this._staff_password="";
		this._staff_roll="";
		
	}
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	public Staff(int id, String fname, String lname, String roll) {
		this._staff_fname=fname;
		this._staff_lname=lname;		
		this._staff_roll=roll;
	}
	public int get_staff_id() {
		return _staff_id;
	}
	public void set_staff_id(int _staff_id) {
		this._staff_id = _staff_id;
	}
	public String get_staff_fname() {
		return _staff_fname;
	}
	public void set_staff_fname(String _staff_fname) {
		this._staff_fname = _staff_fname;
	}
	public String get_staff_lname() {
		return _staff_lname;
	}
	public void set_staff_lname(String _staff_lname) {
		this._staff_lname = _staff_lname;
	}
	public String get_staff_email() {
		return _staff_email;
	}
	public void set_staff_email(String _staff_email) {
		this._staff_email = _staff_email;
	}
	public String get_staff_password() {
		return _staff_password;
	}
	public void set_staff_password(String _staff_password) {
		this._staff_password = _staff_password;
	}
	public String get_staff_roll() {
		return _staff_roll;
	}
	public void set_staff_roll(String _staff_roll) {
		this._staff_roll = _staff_roll;
	}

}
