package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;
import com.food.util.DBConnectionUtil;

public class RestaurantDAOImpl implements RestaurantDAO {

    @Override
    public void addRestaurant(Restaurant restaurant) {
        String SQL = "INSERT INTO Restaurant (RestaurantID, RestaurantName, CuisineType, DeliveryTime, Address, AdminUserID, Rating, IsActive, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, restaurant.getRestaurantID()); 
            pstmt.setString(2, restaurant.getRestaurantName());
            pstmt.setString(3, restaurant.getCuisineType());
            pstmt.setInt(4, restaurant.getDeliveryTime());
            pstmt.setString(5, restaurant.getAddress());
            pstmt.setInt(6, restaurant.getAdminUserID());
            pstmt.setDouble(7, restaurant.getRating());
            pstmt.setBoolean(8, restaurant.getIsActive());
            pstmt.setString(9, restaurant.getImagePath());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantID) {
        String SQL = "SELECT * FROM Restaurant WHERE RestaurantID = ?";
        Restaurant restaurant = null;
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, restaurantID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                restaurant = extractRestaurantFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        String SQL = "UPDATE Restaurant SET RestaurantName = ?, CuisineType = ?, DeliveryTime = ?, Address = ?, AdminUserID = ?, Rating = ?, IsActive = ?, ImagePath = ? WHERE RestaurantID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, restaurant.getRestaurantName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setInt(3, restaurant.getDeliveryTime());
            pstmt.setString(4, restaurant.getAddress());
            pstmt.setInt(5, restaurant.getAdminUserID());
            pstmt.setDouble(6, restaurant.getRating());
            pstmt.setBoolean(7, restaurant.getIsActive());
            pstmt.setString(8, restaurant.getImagePath());
            pstmt.setInt(9, restaurant.getRestaurantID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantID) {
        String SQL = "DELETE FROM Restaurant WHERE RestaurantID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, restaurantID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String SQL = "SELECT * FROM Restaurant";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Restaurant restaurant = extractRestaurantFromResultSet(rs);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    private Restaurant extractRestaurantFromResultSet(ResultSet rs) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(rs.getInt("RestaurantID"));
        restaurant.setRestaurantName(rs.getString("RestaurantName"));
        restaurant.setCuisineType(rs.getString("CuisineType"));
        restaurant.setDeliveryTime(rs.getInt("DeliveryTime"));
        restaurant.setAddress(rs.getString("Address"));
        restaurant.setAdminUserID(rs.getInt("AdminUserID"));
        restaurant.setRating(rs.getDouble("Rating"));
        restaurant.setIsActive(rs.getBoolean("IsActive"));
        restaurant.setImagePath(rs.getString("ImagePath"));
        return restaurant;
    }
}
