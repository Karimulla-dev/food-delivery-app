package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.model.Menu;
import com.food.util.DBConnectionUtil;

public class MenuDAOImpl implements MenuDAO{

	@Override
	public void addMenu(Menu menu) {
		String SQL = "INSERT INTO Menu (RestaurantID, ItemName, Description, Price, IsAvailable, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, menu.getRestaurantID());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.getIsAvailable());
            pstmt.setString(6, menu.getImagePath());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Menu getMenu(int menuID) {
		String SQL = "SELECT * FROM Menu WHERE MenuID = ?";
        Menu menu = null;
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, menuID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                menu = extractMenuFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		String SQL = "UPDATE Menu SET RestaurantID = ?, ItemName = ?, Description = ?, Price = ?, IsAvailable = ?, ImagePath=? WHERE MenuID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, menu.getRestaurantID());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setBoolean(5, menu.getIsAvailable());
            pstmt.setString(7, menu.getImagePath());
            pstmt.setInt(6, menu.getMenuID());
            

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteMENU(int menuID) {
		String SQL = "DELETE FROM Menu WHERE MenuID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, menuID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Menu> getAllMenuByRestaurant(int restaurantID) {
		List<Menu> menus = new ArrayList<>();
        String SQL = "SELECT * FROM Menu WHERE RestaurantID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, restaurantID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Menu menu = extractMenuFromResultSet(rs);
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
	}
	private Menu extractMenuFromResultSet(ResultSet rs) throws SQLException {
        Menu menu = new Menu();
        menu.setMenuID(rs.getInt("MenuID"));
        menu.setRestaurantID(rs.getInt("RestaurantID"));
        menu.setItemName(rs.getString("ItemName"));
        menu.setDescription(rs.getString("Description"));
        menu.setPrice(rs.getDouble("Price"));
        menu.setImagePath(rs.getString("ImagePath"));
        menu.setIsAvailable(rs.getBoolean("IsAvailable"));
        return menu;
    }

}
