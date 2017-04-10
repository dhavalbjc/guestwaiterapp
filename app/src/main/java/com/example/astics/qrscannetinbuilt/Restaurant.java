package com.example.astics.qrscannetinbuilt;

public class Restaurant {
	private int _restro_id;
	private String _restro_name;
	private String _restro_description;
	private String _restro_phone;
	private String _restro_website;
	private String _restro_email;
	private String _restro_street;
	private String _restro_civicnumber;
	private String _restro_zipcode;
	private String _restro_city;
	private String _restro_state;
	private String _restro_country;
	private String _restro_latitude;
	private String _restro_longitude;
	public Restaurant(int id, String name, String email)
	{
		this._restro_id=id;
		this._restro_name=name;
		this._restro_description="";
		this._restro_phone="";
		this._restro_website="";
		this._restro_email=email;
		this._restro_street="";
		this._restro_civicnumber="";
		this._restro_zipcode="";
		this._restro_city="";
		this._restro_state="";
		this._restro_country="";
		this._restro_latitude="";
		this._restro_latitude="";
		
	}
	public Restaurant(int id, String name, String description, String phone, String website, String email, String street, String civic, String zip, String city, String state, String country)
	{
		this._restro_id=id;
		this._restro_name = (name.equals("null")) ? "" : name;			
		this._restro_description=(description.equals("null")) ? "" :description;
		this._restro_phone=(phone.equals("null")) ? "" :phone;
		this._restro_website=(website.equals("null")) ? "" :website;
		this._restro_email=(email.equals("null")) ? "" :email;
		this._restro_street=(street.equals("null")) ? "" :street;
		this._restro_civicnumber=(civic.equals("null")) ? "" :civic;
		this._restro_zipcode=(zip.equals("null")) ? "" :zip;
		this._restro_city=(city.equals("null")) ? "" :city;
		this._restro_state=(state.equals("null")) ? "" :state;
		this._restro_country=(country.equals("null")) ? "" :country;
		this._restro_latitude="";
		this._restro_latitude="";
		
	}
	public int get_restro_id() {
		return _restro_id;
	}
	public void set_restro_id(int _restro_id) {
		this._restro_id = _restro_id;
	}
	public String get_restro_name() {
		return _restro_name;
	}
	public void set_restro_name(String _restro_name) {
		this._restro_name = _restro_name;
	}
	public String get_restro_description() {
		return _restro_description;
	}
	public void set_restro_description(String _restro_description) {
		this._restro_description = _restro_description;
	}
	public String get_restro_phone() {
		return _restro_phone;
	}
	public void set_restro_phone(String _restro_phone) {
		this._restro_phone = _restro_phone;
	}
	public String get_restro_website() {
		return _restro_website;
	}
	public void set_restro_website(String _restro_website) {
		this._restro_website = _restro_website;
	}
	public String get_restro_email() {
		return _restro_email;
	}
	public void set_restro_email(String _restro_email) {
		this._restro_email = _restro_email;
	}
	public String get_restro_civicnumber() {
		return _restro_civicnumber;
	}
	public void set_restro_civicnumber(String _restro_civicnumber) {
		this._restro_civicnumber = _restro_civicnumber;
	}
	public String get_restro_zipcode() {
		return _restro_zipcode;
	}
	public void set_restro_zipcode(String _restro_zipcode) {
		this._restro_zipcode = _restro_zipcode;
	}
	public String get_restro_city() {
		return _restro_city;
	}
	public void set_restro_city(String _restro_city) {
		this._restro_city = _restro_city;
	}
	public String get_restro_state() {
		return _restro_state;
	}
	public void set_restro_state(String _restro_state) {
		this._restro_state = _restro_state;
	}
	public String get_restro_country() {
		return _restro_country;
	}
	public void set_restro_country(String _restro_country) {
		this._restro_country = _restro_country;
	}
	public String get_restro_latitude() {
		return _restro_latitude;
	}
	public void set_restro_latitude(String _restro_latitude) {
		this._restro_latitude = _restro_latitude;
	}
	public String get_restro_longitude() {
		return _restro_longitude;
	}
	public void set_restro_longitude(String _restro_longitude) {
		this._restro_longitude = _restro_longitude;
	}
	public String get_restro_street() {
		return _restro_street;
	}
	public void set_restro_street(String _restro_street) {
		this._restro_street = _restro_street;
	}

}
