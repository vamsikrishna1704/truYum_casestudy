package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao
{

	@Override
	public void addCartItem(long userId, long menuItemId) 
	{
		Connection myCon=null;
		PreparedStatement p=null;
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="insert into cart values(?,?)";
		try {
			p=myCon.prepareStatement(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.setInt(1,(int)userId);
			p.setInt(2,(int)menuItemId);
			int i=p.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException 
	{
		ArrayList<MenuItem> list=new ArrayList<>();
		Cart cart=new Cart(list,0);
		Connection myCon=null;
		PreparedStatement p=null;
		PreparedStatement p1=null;
		ResultSet r=null;
		ResultSet r1=null;
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="select * from menu_item m join cart c on m.id=c.menu_id where c.cart_id=?";
		try {
			p=myCon.prepareStatement(s);
			p.setInt(1,(int)userId);
			r=p.executeQuery();
			while(r.next()) {
				long l=(long)r.getInt(1);
				String n=r.getString(2);
				float fl=r.getFloat(3);
				boolean b=Boolean.parseBoolean(r.getString(4));
				Date d=r.getDate(5);
				String s1=r.getString(6);
				boolean b1=Boolean.parseBoolean(r.getString(7));
				list.add(new MenuItem(l,n,fl,b,d,s1,b1));
			}
			String s1="select sum(price) from menu_item m join cart c on m.id=c.menu_id where c.cart_id=?";
			p1=myCon.prepareStatement(s1);
			p1.setInt(1,(int)userId);
			r1=p1.executeQuery();
			while(r1.next()) {
				double d=r1.getFloat(1);
				cart.setTotal(d);
				cart.setMenuItemList(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) 
	{
		Connection myCon=null;
		PreparedStatement p=null;
		String s="delete from cart where cart_id=? and menu_id=?";
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			p=myCon.prepareStatement(s);
			p.setInt(1,(int)userId);
			p.setInt(2,(int)menuItemId);
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
