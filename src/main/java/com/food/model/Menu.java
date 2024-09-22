package com.food.model;

public class Menu {
	private int MenuID;
	private int RestaurantID;
	private String ItemName;
	private String Description;
	private Double Price;
	private boolean IsAvailable ;
	private String ImagePath;
	
	
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public int getMenuID() {
		return MenuID;
	}
	public void setMenuID(int menuID) {
		MenuID = menuID;
	}
	public int getRestaurantID() {
		return RestaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public boolean getIsAvailable() {
		return IsAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		IsAvailable = isAvailable;
	}
	
	
}
