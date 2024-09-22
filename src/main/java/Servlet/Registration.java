package Servlet;

import java.io.IOException;
import com.food.DAO.UserDAO;
import com.food.DAOImpl.UserDAOImpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Retrieve form data
        String userID = request.getParameter("userID");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Validate input data (optional, but recommended)
        if (userID == null || userName == null || password == null || email == null || address == null ||
            userID.isEmpty() || userName.isEmpty() || password.isEmpty() || email.isEmpty() || address.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/Registration.jsp?errorMessage=All fields are required.");
            return;
        }

        boolean registrationSuccess = false;

        // Database logic to add user
        try {
            UserDAO userDAO = new UserDAOImpl();
            User newUser = new User();
            newUser.setUserID(Integer.parseInt(userID));
            newUser.setUserName(userName);
            newUser.setPassword(password);
            newUser.setEmail(email);
            newUser.setAddress(address);

            // Assuming `addUser` method returns boolean for success
            registrationSuccess = userDAO.addUser(newUser);

        } catch (Exception e) {
            e.printStackTrace();
            registrationSuccess = false;
        }

        // Redirect based on success or failure
        if (registrationSuccess) {
            response.sendRedirect(request.getContextPath() + "/Registration.jsp?successMessage=Registration successful!");
        } else {
            response.sendRedirect(request.getContextPath() + "/Registration.jsp?errorMessage=Registration failed. Please try again.");
        }
    }
}
