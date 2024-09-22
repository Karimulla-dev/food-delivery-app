package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrdersDAO;
import com.food.model.Orders;
import com.food.util.DBConnectionUtil;

public class OrdersDAOImpl implements OrdersDAO {

    @Override
    public void addOrder(Orders order) {
        String SQL = "INSERT INTO Orders (UserID, RestaurantID, OrderDate, TotalAmount, Status, PaymentMethod) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, order.getUserID());
            pstmt.setInt(2, order.getRestaurantID());
            pstmt.setDate(3, new Date(order.getOrderDate().getTime())); // Ensure java.sql.Date is used
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMethod());

            pstmt.executeUpdate();
            
            // Retrieve auto-generated keys if needed
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                order.setOrderID(rs.getInt(1)); // Assuming OrderID is auto-generated
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders getOrder(int orderID) {
        String SQL = "SELECT * FROM Orders WHERE OrderID = ?";
        Orders order = null;
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                order = extractOrderFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(Orders order) {
        String SQL = "UPDATE Orders SET UserID = ?, RestaurantID = ?, OrderDate = ?, TotalAmount = ?, Status = ?, PaymentMethod = ? WHERE OrderID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, order.getUserID());
            pstmt.setInt(2, order.getRestaurantID());
            pstmt.setDate(3, new Date(order.getOrderDate().getTime()));
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMethod());
            pstmt.setInt(7, order.getOrderID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderID) {
        String SQL = "DELETE FROM Orders WHERE OrderID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> getAllOrdersByUser(int userID) {
        List<Orders> orders = new ArrayList<>();
        String SQL = "SELECT * FROM Orders WHERE UserID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {  // Use while loop to iterate over multiple rows
                Orders order = extractOrderFromResultSet(rs);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private Orders extractOrderFromResultSet(ResultSet rs) throws SQLException {
        Orders order = new Orders();
        order.setOrderID(rs.getInt("OrderID"));
        order.setUserID(rs.getInt("UserID"));
        order.setRestaurantID(rs.getInt("RestaurantID"));
        order.setOrderDate(rs.getDate("OrderDate"));
        order.setTotalAmount(rs.getDouble("TotalAmount"));
        order.setStatus(rs.getString("Status"));
        order.setPaymentMethod(rs.getString("PaymentMethod"));
        return order;
    }
}
