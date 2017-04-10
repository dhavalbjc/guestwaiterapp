package com.example.astics.qrscannetinbuilt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsOrderAdapter extends FragmentPagerAdapter {

	public TabsOrderAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		Bundle bundle = new Bundle();
		switch (index) {
		case 0:
			/* long id2=GamesFragment.ExpListItems.get(index-1).get_id();
			 bundle.putString("ID",String.valueOf(id2));
			 Item_selected iSelected=new Item_selected();
			 iSelected.setArguments(bundle); */
			return new Item_selected();
			
		case 1:
			 long id=Controller.ExpListItems.get(index-1).get_id();
			 //DBAdapter.getAllCartItemsDataByCartId(l)
	          bundle.putString("ID", String.valueOf(id));
	        Itemlist_Fragment swipeTabFragment = new Itemlist_Fragment();
	        swipeTabFragment.setArguments(bundle);  
	        return swipeTabFragment;
		default:
			 long id1=Controller.ExpListItems.get(index-1).get_id();
	          bundle.putString("ID", String.valueOf(id1));
	        ItemlistFragment swipeTabFragment1 = new ItemlistFragment();
	        swipeTabFragment1.setArguments(bundle);  
	        return swipeTabFragment1;
		}
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return Controller.ExpListItems.size()+1;
	}

}
