package com.Model;

public class Item {

	private int id;
	private String name;
	private String brand;
	private int qty; 
	private String color;

	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", Name=" + name + ", Brand =" + brand + ", Quantity= "+ qty +" , Color= "+ color +"]";
	}
}
