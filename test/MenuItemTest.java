package com.cognizant.truyum.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemTest 
{
	MenuItem m=new MenuItem(0, null, 0, false, null, null, false);
	MenuItem m1=new MenuItem(1,"item",20,true,null,"type", true);
	@BeforeClass
	public void setup()
	{
		System.out.println("before test");
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		assertEquals(0,m.getId());
		assertNull(m.getName());
		assertEquals(0,m.getPrice());
		assertFalse(m.isActive());
		assertNull(m.getDateOfLaunch());
		assertNull(m.getCategory());
		assertFalse(m.isFreeDelivery());
	}
	@Test
	public void test1() {
		//fail("Not yet implemented");
		
		assertEquals(1,m1.getId());
		assertEquals("item",m1.getName());
		assertEquals(20,m1.getPrice());
		assertTrue(m1.isActive());
		assertNull(m1.getDateOfLaunch());
		assertEquals("type",m1.getCategory());
		assertTrue(m1.isFreeDelivery());
	}
	@AfterClass
	public void message()
	{
		System.out.println("after test");
	}

}
