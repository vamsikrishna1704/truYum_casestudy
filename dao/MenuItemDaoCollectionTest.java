package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
//import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionTest 
{
	public void testModifyMenuItem()
	{
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItemDaoCollectionImpl m=(MenuItemDaoCollectionImpl)menuItemDao;
		m.modifyMenuItem(null);
		MenuItem menuItem=menuItemDao.getMenuItem(1);
		if(m.a.contains(menuItem)) {
			System.out.println("modified");
		}
	}
	public void testGetMenuItemListCustomer()
	{
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList=new ArrayList<>();
		menuItemList.addAll(menuItemDao.getMenuItemListCustomer());
		for(MenuItem m:menuItemList) {
			System.out.println(m.getId()+" "+m.getName()+" "+m.getPrice()+" "+m.isActive()+" "+m.getDateOfLaunch()+" "+m.getCategory()+" "+m.isFreeDelivery());
		}
	}

	public static void main(String[] args) {
       MenuItemDaoCollectionTest m=new MenuItemDaoCollectionTest();
       MenuItemDaoSqlImpl m1=new MenuItemDaoSqlImpl();
       m1.getMenuItemListAdmin();
       m.testGetMenuItemListCustomer();
       m.testModifyMenuItem();
	}
	

}
