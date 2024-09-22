package com.food.DAO;

import java.util.List;

import com.food.model.OrderHistory;
import com.food.model.User;

public interface OrderHistoryDAO {
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryID);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryID);
	List<OrderHistory> getAllOrderHistoryByUser(int userID);
}
