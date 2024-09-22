package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderHistoryDAO;
import com.food.model.OrderHistory;
import com.food.util.DBConnectionUtil;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

    @Override
    public void addOrderHistory(OrderHistory orderHistory) {
        String SQL = "INSERT INTO OrderHistory (UserID, OrderID, OrderDate, TotalAmount, Status) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderHistory.getUserID());
            pstmt.setInt(2, orderHistory.getOrderID());
            pstmt.setDate(3, new Date(orderHistory.getOrderDate().getTime())); // Ensure java.sql.Date is used
            pstmt.setDouble(4, orderHistory.getTotalAmount());
            pstmt.setString(5, orderHistory.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryID) {
        String SQL = "SELECT * FROM OrderHistory WHERE OrderHistoryID = ?";
        OrderHistory orderHistory = null;
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderHistoryID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                orderHistory = extractOrderHistoryFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public void updateOrderHistory(OrderHistory orderHistory) {
        String SQL = "UPDATE OrderHistory SET UserID = ?, OrderID = ?, OrderDate = ?, TotalAmount = ?, Status = ? WHERE OrderHistoryID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderHistory.getUserID());
            pstmt.setInt(2, orderHistory.getOrderID());
            pstmt.setDate(3, new Date(orderHistory.getOrderDate().getTime()));
            pstmt.setDouble(4, orderHistory.getTotalAmount());
            pstmt.setString(5, orderHistory.getStatus());
            pstmt.setInt(6, orderHistory.getOrderHistoryID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderHistory(int orderHistoryID) {
        String SQL = "DELETE FROM OrderHistory WHERE OrderHistoryID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, orderHistoryID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> getAllOrderHistoryByUser(int userID) {
        List<OrderHistory> orderHistoryList = new ArrayList<>();
        String SQL = "SELECT * FROM OrderHistory WHERE UserID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderHistory orderHistory = extractOrderHistoryFromResultSet(rs);
                orderHistoryList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    private OrderHistory extractOrderHistoryFromResultSet(ResultSet rs) throws SQLException {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderHistoryID(rs.getInt("OrderHistoryID"));
        orderHistory.setUserID(rs.getInt("UserID"));
        orderHistory.setOrderID(rs.getInt("OrderID"));
        orderHistory.setOrderDate(rs.getDate("OrderDate"));
        orderHistory.setTotalAmount(rs.getDouble("TotalAmount"));
        orderHistory.setStatus(rs.getString("Status"));
        return orderHistory;
    }
}
