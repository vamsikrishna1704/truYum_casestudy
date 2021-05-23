package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class Main {

	public static void main(String[] args) 
	{
		MenuItemDaoSqlImpl m=new MenuItemDaoSqlImpl();
		List<MenuItem> list=null,list1=null;
		list=m.getMenuItemListAdmin();
		MenuItem m1=m.getMenuItem(1);
		//list1=m.getMenuItemListCustomer();
		//m.modifyMenuItem(MenuItem menuItem);
		//m.getMenuItem(long menuItemId);
		MenuItem menuItem=new MenuItem(4,"Egg puff",20,true,DateUtil.convertToDate("20/10/2020"),"Snacks",false);
		m.modifyMenuItem(menuItem);
		list1=m.getMenuItemListAdmin();
		list.addAll(list1);

	}

}
