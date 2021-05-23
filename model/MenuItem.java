package com.cognizant.truyum.model;

import java.util.Date;

public class MenuItem 
{
	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;
	public MenuItem(long id,String name,float price,boolean active,Date dateOfLaunch,String category,boolean freeDelivery)
	{
		super();
		this.active=active;
		this.id=id;
		this.category=category;
		this.dateOfLaunch=dateOfLaunch;
		this.freeDelivery=freeDelivery;
		this.name=name;
		this.price=price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public String toString()
	{
		return (name+" "+price+" "+active+"  "+dateOfLaunch+" "+category+" "+freeDelivery);
	}
	public boolean equals(MenuItem obj)
	{
		if(obj instanceof MenuItem)
		{		
		  MenuItem p3 = (MenuItem)obj;
		
	      return(this.id==p3.id);
		}
		return false;
	}
}
