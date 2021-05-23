package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

public class Cart 
{
	private List<MenuItem> menuItemList;
	private double total;
	public Cart(ArrayList<MenuItem> menuItemList,double total)
	{
		this.menuItemList=menuItemList;
		this.total=total;
	}
	public void setMenuItemList(List<MenuItem> menuItemList)
	{
		this.menuItemList=menuItemList;
	}
	public List<MenuItem> getMenuItemList()
	{
		return this.menuItemList;
	}
	public void setTotal(double total)
	{
		this.total=total;
	}
	public double getTotal()
	{
		return this.total;
	}

}
