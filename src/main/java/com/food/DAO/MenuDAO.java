package com.food.DAO;

import java.util.List;

import com.food.model.Menu;
import com.food.model.User;

public interface MenuDAO {
	void addMenu(Menu menu);
	Menu getMenu(int menuID);
	void updateMenu(Menu menu);
	void deleteMENU(int menuID);
	List<Menu> getAllMenuByRestaurant(int restaurantID);
}
