package com.example.astics.qrscannetinbuilt;

public class Printer {
	private int _id;
	private String _protocol;
	private String _connection;
	private String _mac;
	private String _ip;
	private String _model;
	private String _paperwidth;
	private String _name;
	private String _printorder;
	private String _enable;
	private String _status;
	public Printer(int parseInt, String mac, String name, String printorder) {
		this.set_id(parseInt);
		this.set_mac(mac);
		this.set_name(name);
		this.set_printorder(printorder);
	}
	public Printer() {
		// TODO Auto-generated constructor stub
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_protocol() {
		return _protocol;
	}
	public void set_protocol(String _protocol) {
		this._protocol = _protocol;
	}
	public String get_connection() {
		return _connection;
	}
	public void set_connection(String _connection) {
		this._connection = _connection;
	}
	public String get_mac() {
		return _mac;
	}
	public void set_mac(String _mac) {
		this._mac = _mac;
	}
	public String get_ip() {
		return _ip;
	}
	public void set_ip(String _ip) {
		this._ip = _ip;
	}
	public String get_model() {
		return _model;
	}
	public void set_model(String _model) {
		this._model = _model;
	}
	public String get_paperwidth() {
		return _paperwidth;
	}
	public void set_paperwidth(String _paperwidth) {
		this._paperwidth = _paperwidth;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_printorder() {
		return _printorder;
	}
	public void set_printorder(String _printorder) {
		this._printorder = _printorder;
	}
	public String get_enable() {
		return _enable;
	}
	public void set_enable(String _enable) {
		this._enable = _enable;
	}
	public String get_status() {
		return _status;
	}
	public void set_status(String _status) {
		this._status = _status;
	}
}
