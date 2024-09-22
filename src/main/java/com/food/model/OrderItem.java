package com.food.model;

public class OrderItem {
	private int  OrderItemID;
	private int OrderID;
	private int MenuID;
	private int Quantity;
	private Double ItemTotal;
	
	
	public int getOrderItemID() {
		return OrderItemID;
	}
	public void setOrderItemID(int orderItemID) {
		OrderItemID = orderItemID;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getMenuID() {
		return MenuID;
	}
	public void setMenuID(int menuID) {
		MenuID = menuID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Double getItemTotal() {
		return ItemTotal;
	}
	public void setItemTotal(Double itemTotal) {
		ItemTotal = itemTotal;
	}
	
	
}
