package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao
{

	@Override
	public List<MenuItem> getMenuItemListAdmin()
	{
		Connection myCon=null;
		PreparedStatement p=null;
		ResultSet r=null;
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MenuItem> ar=new ArrayList<>();
		String s="select * from menu_item";
		try {
		   p=myCon.prepareStatement(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			r=p.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(r.next()) {
				long l=(long)r.getInt(1);
				String n=r.getString(2);
				float fl=r.getFloat(3);
				boolean b=Boolean.parseBoolean(r.getString(4));
				Date d=r.getDate(5);
				String s1=r.getString(6);
				boolean b1=Boolean.parseBoolean(r.getString(7));
				System.out.println(l+n+fl+b+d+s1+b1);
				ar.add(new MenuItem(l,n,fl,b,d,s1,b1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() 
	{
		Connection myCon=null;
		PreparedStatement p=null;
		ResultSet r=null;
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MenuItem> ar=new ArrayList<>();
		String s="select * from menu_item where active=? and date_of_launch<'2018-12-02'";
		try {
		   p=myCon.prepareStatement(s);
		   p.setString(1,"true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			r=p.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(r.next()) {
				long l=(long)r.getInt(1);
				String n=r.getString(2);
				float fl=r.getFloat(3);
				boolean b=Boolean.parseBoolean(r.getString(4));
				Date d=r.getDate(5);
				String s1=r.getString(6);
				boolean b1=Boolean.parseBoolean(r.getString(7));
				System.out.println(l+n+fl+b+d+s1+b1);
				ar.add(new MenuItem(l,n,fl,b,d,s1,b1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) 
	{
		Connection myCon=null;
		PreparedStatement p=null;
		int i=(int)menuItem.getId();
		String st=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(menuItem.getDateOfLaunch());
		String[] su=st.split(" ");
		System.out.println(su[0]);
		Date d1=Date.valueOf(su[0]);
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="update menu_item set id=?,name=?,price=?,active=?,date_of_launch=?,catagory=?,free_delivery=? where id=?";
		try {
		   p=myCon.prepareStatement(s);
		   p.setInt(1,i);
		   p.setString(2,menuItem.getName());
		   p.setFloat(3,menuItem.getPrice());
		   p.setString(4,Boolean.toString(menuItem.isActive()));
		   p.setDate(5, d1);
		   p.setString(6,menuItem.getCategory());
		   p.setString(7,Boolean.toString(menuItem.isFreeDelivery()));
		   p.setInt(8,i);
		   p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) 
	{
		Connection myCon=null;
		PreparedStatement p=null;
		ResultSet r=null;
		MenuItem m=null;
		try {
			myCon=ConnectionHandler.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="select * from menu_item where id=?";
		try {
		   p=myCon.prepareStatement(s);
		   p.setInt(1,(int)menuItemId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			r=p.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(r.next()) {
				long l=(long)r.getInt(1);
				String n=r.getString(2);
				float fl=r.getFloat(3);
				boolean b=Boolean.parseBoolean(r.getString(4));
				Date d=r.getDate(5);
				String s1=r.getString(6);
				boolean b1=Boolean.parseBoolean(r.getString(7));
				System.out.println(l+n+fl+b+d+s1+b1);
				m=new MenuItem(l,n,fl,b,d,s1,b1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	

}
