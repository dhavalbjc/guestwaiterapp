package com.example.astics.qrscannetinbuilt;
import java.util.Comparator;


public class myCateComparable implements Comparator<Category> {

	@Override
	public int compare(Category arg0, Category arg1) {
		// TODO Auto-generated method stub
		return (arg0.get_sequence()<arg1.get_sequence()? -1:1);
	}

}
