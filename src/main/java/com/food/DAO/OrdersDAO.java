package com.food.DAO;

import java.util.List;

import com.food.model.OrderItem;
import com.food.model.Orders;

public interface OrdersDAO {
	
	void addOrder(Orders order);
	Orders getOrder(int orderID);
	void updateOrder(Orders order);
	void deleteOrder(int orderID);
	List<Orders> getAllOrdersByUser(int user);
}
