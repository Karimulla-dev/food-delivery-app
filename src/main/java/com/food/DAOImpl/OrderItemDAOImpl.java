package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderItem;
import com.food.util.DBConnectionUtil;

public class OrderItemDAOImpl implements OrderItemDAO {

	@Override
	public void addOrderItem(OrderItem orderItem) {
		String SQL = "INSERT INTO OrderItem (OrderID, MenuID, Quantity, ItemTotal) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderItem.getOrderID());
            pstmt.setInt(2, orderItem.getMenuID());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public OrderItem getOrderItem(int orderItemID) {
		String SQL = "SELECT * FROM OrderItem WHERE OrderItemID = ?";
        OrderItem orderItem = null;
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderItemID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                orderItem = extractOrderItemFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String SQL = "UPDATE OrderItem SET OrderID = ?, MenuID = ?, Quantity = ?, ItemTotal = ? WHERE OrderItemID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderItem.getOrderID());
            pstmt.setInt(2, orderItem.getMenuID());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setDouble(4, orderItem.getItemTotal());
            pstmt.setInt(5, orderItem.getOrderItemID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteOrderItem(int orderItemID) {
		String SQL = "DELETE FROM OrderItem WHERE OrderItemID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderItemID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<OrderItem> getAllOrderItemByOrders(int orderID) {
		List<OrderItem> orderItems = new ArrayList<>();
        String SQL = "SELECT * FROM OrderItem WHERE OrderID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderItem orderItem = extractOrderItemFromResultSet(rs);
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
	}
	private OrderItem extractOrderItemFromResultSet(ResultSet rs) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemID(rs.getInt("OrderItemID"));
        orderItem.setOrderID(rs.getInt("OrderID"));
        orderItem.setMenuID(rs.getInt("MenuID"));
        orderItem.setQuantity(rs.getInt("Quantity"));
        orderItem.setItemTotal(rs.getDouble("ItemTotal"));
        return orderItem;
    }
}