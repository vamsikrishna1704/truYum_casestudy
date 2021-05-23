package com.cognizant.truyum.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.cognizant.truyum.model.*;

class CartTest {
	Cart c=new Cart(null, 0);
	ArrayList<MenuItem> i=new ArrayList<>();
	Cart c1=new Cart(i,50);
	@BeforeClass
	public void setup()
	{
		System.out.println("before");
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		assertNull(c.getMenuItemList());
		assertEquals(0,c.getTotal());
	}
	@Test
	public void test1()
	{
		assertEquals(i,c1.getMenuItemList());
		assertEquals(51,c1.getTotal(),1);
	}

}
