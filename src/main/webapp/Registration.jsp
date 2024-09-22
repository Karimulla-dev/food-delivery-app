<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Online Food Delivery App</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@200;300;400;500;600;700&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Open Sans", sans-serif;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            width: 100%;
            padding: 0 10px;
            margin: 0;
            position: relative;
        }

        body::before {
            content: "";
            position: absolute;
            width: 100%;
            height: 100%;
            background: url("images/front-view-female-courier-red-uniform-holding-little-food-package-yellow-background-covid-job-service-delivery-uniform-worker.jpg"), #000;
            background-position: center;
            background-size: cover;
            z-index: -1;
        }

        .wrapper {
            width: 400px;
            border-radius: 8px;
            padding: 30px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.5);
            backdrop-filter: blur(8px);
            -webkit-backdrop-filter: blur(8px);
            background: rgba(255, 255, 255, 0.2);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        h2 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #fff;
        }

        .input-field {
            position: relative;
            border-bottom: 2px solid #ccc;
            margin: 15px 0;
        }

        .input-field label {
            position: absolute;
            top: 50%;
            left: 0;
            transform: translateY(-50%);
            color: #fff;
            font-size: 16px;
            pointer-events: none;
            transition: 0.15s ease;
        }

        .input-field input {
            width: 100%;
            height: 40px;
            background: transparent;
            border: none;
            outline: none;
            font-size: 16px;
            color: #fff;
        }

        .input-field input:focus~label,
        .input-field input:valid~label {
            font-size: 0.8rem;
            top: 10px;
            transform: translateY(-120%);
        }

        button {
            background: #fff; /* White background */
            color: #000; /* Black text */
            font-weight: 600;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 3px;
            font-size: 16px;
            border: 2px solid transparent;
            transition: 0.3s ease;
            margin-top: 20px;
        }

        button:hover {
            color: #fff;
            border-color: #fff;
            background: rgba(255, 255, 255, 0.15);
        }

        .login-link {
            text-align: center;
            margin-top: 30px;
            color: #fff;
        }

        .error {
            color: red;
            font-size: 14px;
        }

        .register-message {
            color: green;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <h2>Register</h2>
        <form action="registerServlet" method="post">
            <div class="input-field">
                <input type="text" id="userId" name="userID" required>
                <label for="userId">User ID</label>
            </div>
            <div class="input-field">
                <input type="text" id="userName" name="userName" required>
                <label for="userName">User Name</label>
            </div>
            <div class="input-field">
                <input type="password" id="password" name="password" required>
                <label for="password">Password</label>
            </div>
            <div class="input-field">
                <input type="email" id="email" name="email" required>
                <label for="email">Email</label>
            </div>
            <div class="input-field">
                <input type="text" id="address" name="address" required>
                <label for="address">Address</label>
            </div>
            <button type="submit">Register</button>
            <% 
                String errorMessage = request.getParameter("errorMessage");
                if (errorMessage != null && !errorMessage.isEmpty()) { 
            %>
            <div class="error"><%= errorMessage %></div>
            <% } %>
            <% 
                String successMessage = request.getParameter("successMessage");
                if (successMessage != null && !successMessage.isEmpty()) { 
            %>
            <div class="register-message"><%= successMessage %></div>
            <% } %>
        </form>
        <div class="login-link">
            <p>Already have an account? <a href="<%= request.getContextPath() %>/Login.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>
