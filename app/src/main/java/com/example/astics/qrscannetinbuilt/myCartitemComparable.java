package com.example.astics.qrscannetinbuilt;

import java.util.Comparator;


public class myCartitemComparable implements Comparator<CartItems> {

	@Override
	public int compare(CartItems arg0, CartItems arg1) {
		// TODO Auto-generated method stub
		return (arg0.get_course()<arg1.get_course()? -1:1);
	}

}
