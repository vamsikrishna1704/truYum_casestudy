package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionTest {

	public static void testAddCartItem()
	{
		HashMap<Long,Cart> hash=new HashMap<>();
		CartDao cartDao=new CartDaoCollectionImpl(hash);
		cartDao.addCartItem(1, 1);
		List<MenuItem> list=new ArrayList<>();
		try {
			list.addAll(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
		for(MenuItem m:list) {
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",m.getName(),m.getPrice(),m.isActive(),m.getDateOfLaunch(),m.getCategory(),m.isFreeDelivery()));
			if(m.getId()==1) {
				System.out.println("Added item");
			}
		}
	}
	public static void testGetAllCartItems()
	{
		HashMap<Long,Cart> hash=new HashMap<>();
		CartDao cartDao=new CartDaoCollectionImpl(hash);
		//cartDao.addCartItem(1, 1);
		List<MenuItem> list=new ArrayList<>();
		try {
			list.addAll(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
		for(MenuItem m:list) {
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",m.getName(),m.getPrice(),m.isActive(),m.getDateOfLaunch(),m.getCategory(),m.isFreeDelivery()));
		}
	}
	public static void testRemoveCartItem()
	{
		HashMap<Long,Cart> hash=new HashMap<>();
		CartDao cartDao=new CartDaoCollectionImpl(hash);
		cartDao.removeCartItem(1, 1);
		List<MenuItem> list=new ArrayList<>();
		try {
			list.addAll(cartDao.getAllCartItems(1));
			for(MenuItem item:list)
			{
				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		testAddCartItem();
		testGetAllCartItems();
        testRemoveCartItem();
	}

}
