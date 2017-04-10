package com.example.astics.qrscannetinbuilt;

import java.util.Comparator;


public class myExtraComparable implements Comparator<Extra> {

	@Override
	public int compare(Extra arg0, Extra arg1) {
		// TODO Auto-generated method stub
		return (arg0.get_sequence()<arg1.get_sequence()? -1:1);
	}

}