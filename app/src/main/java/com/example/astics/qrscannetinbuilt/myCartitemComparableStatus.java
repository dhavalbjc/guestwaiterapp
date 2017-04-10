
package com.example.astics.qrscannetinbuilt;

import java.util.Comparator;


public class myCartitemComparableStatus implements Comparator<CartItems> {

	@Override
	public int compare(CartItems arg0, CartItems arg1) {
		// TODO Auto-generated method stub
		return (Integer.parseInt(arg0.get_status())< Integer.parseInt(arg1.get_status())? -1:1);
	}

}
