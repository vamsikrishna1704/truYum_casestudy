package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao
{
	
	private HashMap<Long,Cart> userCarts=null;
	public CartDaoCollectionImpl(HashMap<Long,Cart> userCarts) {
		if(userCarts.isEmpty()) {
		this.userCarts=new HashMap<Long,Cart>();
		}
	}
	public void setUserCarts(HashMap<Long,Cart> userCarts)
	{
		this.userCarts=userCarts;
	}
	public HashMap<Long,Cart> getUserCarts()
	{
		return this.userCarts;
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Cart c=null;
        MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
        MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
        Set<Map.Entry<Long,Cart>> set=userCarts.entrySet();
        for(Map.Entry<Long,Cart> e:set) {
        if(e.getKey()==userId) {
        	if(e.getValue().getMenuItemList().add(menuItem)) {
        		c=e.getValue();
        	}
        }
        else {
            ArrayList<MenuItem> menuItemList=new ArrayList<MenuItem>();
        	menuItemList.add(menuItem);
        	e.getValue().getMenuItemList().addAll(menuItemList);
        	userCarts.put(userId,e.getValue());
        }
        }
        userCarts.put(userId, c);	
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException 
	{
		double total=0;
		Set<Map.Entry<Long,Cart>> set=userCarts.entrySet();
		ArrayList<MenuItem> a=new ArrayList<>();
		for(Map.Entry<Long,Cart> l:set) {
			a.addAll(l.getValue().getMenuItemList());
			if(l.getKey()==userId) {
				if(l.getValue().getMenuItemList().isEmpty()) {
					throw new CartEmptyException("Cart is empty");
				}
				else {
					//a.addAll(l.getValue());
					for(MenuItem a1:l.getValue().getMenuItemList()) {
						total=total+a1.getPrice();
					}
					//Cart c=new Cart();
					l.getValue().setMenuItemList(l.getValue().getMenuItemList());
					l.getValue().setTotal(total);
				}
			}
		}
		return a;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) 
	{
		Set<Map.Entry<Long,Cart>> set=userCarts.entrySet();
		for(Map.Entry<Long,Cart> en:set) {
			if(en.getKey()==userId) {
				for(MenuItem m:en.getValue().getMenuItemList()) {
					if(m.getId()==menuItemId) {
						en.getValue().getMenuItemList().remove(m);
					}
				}
			}
		}
	}
	

}
