<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Online Food Delivery App</title>
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

        .header {
            width: 100%;
            padding: 20px;
            position: absolute;
            top: 0;
            left: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: rgba(0, 0, 0, 0.5);
        }

        .header .left {
            font-size: 1.5em;
            font-weight: bold;
            color: #fff;
        }

        .header .right a {
            color: #fff;
            text-decoration: none;
            margin-left: 20px;
            font-size: 1.1em;
        }

        .header .right a:hover {
            text-decoration: underline;
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
            margin-top: 80px; /* Added margin to prevent overlap with header */
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
            background: #fff;
            color: #000;
            font-weight: 600;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 3px;
            font-size: 16px;
            border: 2px solid transparent;
            transition: 0.3s ease;
        }

        button:hover {
            color: #fff;
            border-color: #fff;
            background: rgba(255, 255, 255, 0.15);
        }

        .register {
            text-align: center;
            margin-top: 30px;
            color: #fff;
        }

        .error {
            color: red;
            font-size: 14px;
        }

        .login-message {
            color: green;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="left">Idiot's Food Delivery App</div>
        <div class="right">
            <a href="<%= request.getContextPath() %>/Home">Home</a>
            <a href="<%= request.getContextPath() %>/Registration.jsp">Register</a>
        </div>
    </div>
    <div class="wrapper">
        <h2>Login</h2>
        <form action="<%= request.getContextPath() %>/login" method="post">
            <div class="input-field">
                <input type="text" id="username" name="username" required>
                <label for="username">Username:</label>
            </div>
            <div class="input-field">
                <input type="password" id="password" name="password" required>
                <label for="password">Password:</label>
            </div>
            <button type="submit">Login</button>
            <% 
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
            <div class="error"><%= errorMessage %></div>
            <% } %>
            <% 
                String loginMessage = (String) request.getAttribute("loginMessage");
                if (loginMessage != null) {
            %>
            <div class="login-message"><%= loginMessage %></div>
            <% } %>
        </form>
        <div class="register">
            <p>Don't have an account? <a href="<%= request.getContextPath() %>/Registration.jsp">Register here</a></p>
        </div>
    </div>
</body>
</html>
