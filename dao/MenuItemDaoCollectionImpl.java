package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
//import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao 
{
	private List<MenuItem> menuItemList;
	public ArrayList<MenuItem> a;//update
	public void setMenuItemList(List<MenuItem> menuItemList)
	{
		this.menuItemList=menuItemList;
		//this.menuItemList.addAll(menuItemList);
	}
	public List<MenuItem> getMenuItemList()
	{
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		a=new ArrayList<>();
		//Iterator<MenuItem> itr=menuItemList.iterator();
		for(MenuItem m:getMenuItemList()) {//update 
			if(m.getDateOfLaunch().equals(new Date())) {
				if(m.isActive()) {
					a.add(m);
				}
			}
		}
		return a;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) 
	{
		//List<MenuItem> list=new ArrayList<>();
		for(MenuItem m:menuItemList)//update
		{
			if(m.equals(menuItem)) {
				a.add(m);
			}
		}	
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) 
	{
		MenuItem m1=null;
		for(MenuItem m:menuItemList) {//update
		if(m.getId()==menuItemId) {
		   m1=m;
		}
	  }
		return m1;
	}
	

}
