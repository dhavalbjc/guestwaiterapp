package com.example.astics.qrscannetinbuilt;

import java.util.Comparator;


public class myItemComparable implements Comparator<Item> {

	@Override
	public int compare(Item arg0, Item arg1) {
		// TODO Auto-generated method stub
		return (arg0.get_sequence()<arg1.get_sequence()? -1:1);
	}

}