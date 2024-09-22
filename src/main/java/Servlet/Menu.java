package Servlet;

import java.io.IOException;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.DAOImpl.MenuDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class Menu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MenuDAO menuDAO;
    
    public void init() {
        menuDAO = new MenuDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String restaurantID = request.getParameter("restaurantId");

        if (restaurantID != null) {
            try {
                int id = Integer.parseInt(restaurantID);
                List<com.food.model.Menu> menuList = menuDAO.getAllMenuByRestaurant(id);
                request.setAttribute("menuList", menuList);
                
            } catch (NumberFormatException e) {
            }
        }			
        	RequestDispatcher dispatcher=request.getRequestDispatcher("Menu.jsp");
        	dispatcher.forward(request, response);
    }
}
