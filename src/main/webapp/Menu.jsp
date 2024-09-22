<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Idiot's Food Delivery App - Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #000;
            color: #fff;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header .left {
            font-size: 1.5em;
            font-weight: bold;
        }
        .header .right a {
            color: #fff;
            margin-left: 20px;
            text-decoration: none;
        }
        .menu-list {
            display: flex;
            flex-wrap: wrap;
            padding: 20px;
        }
        .menu-card {
            background-color: #fff;
            margin: 10px;
            padding: 15px;
            width: 25%;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .menu-image {
            width: 100%;
            height: 150px;
            object-fit: cover;
        }
        .add-to-cart {
            background-color: #ff6600;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            margin-top: 10px;
        }
        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
            margin-top: 40px;
        }
    </style>
</head>
<body>

    <div class="header">
        <div class="left">Idiot's Food Delivery</div>
        <div class="right">
            <a href="<%= request.getContextPath() %>/Home">Home</a>
            <a href="<%= request.getContextPath() %>/About">About</a>
        </div>
    </div>

    <h2 style="text-align: center; margin-top: 20px;">Menu</h2>

    <div class="menu-list">
        <%
            // Fetch the list of menu items from the request attribute
            List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
            
            // Null-check to avoid NullPointerException
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menu : menuList) {
        %>
                    <div class="menu-card">
                        <img src="<%= request.getContextPath() + '/' + menu.getImagePath() %>" 
                             alt="<%= menu.getItemName() %>" 
                             class="menu-image"/>
                        <h2 class="menu-name"><%= menu.getItemName() %></h2>
                        <p>Price: $<%= menu.getPrice() %></p>
                        <p>Description: <%= menu.getDescription() %></p>
                        
                        <!-- Add to Cart form -->
                        <form action="name" method="post">
                            <input type="hidden" name="menuID" value="<%= menu.getMenuID() %>" />
                            <input type="hidden" name="restaurantID" value="<%= menu.getRestaurantID() %>" />
                            <input type="hidden" name="userID" value="<%= request.getSession().getAttribute("userID") %>" />
                            <input type="number" name="quantity" value="1" min="1" />
                            <button type="submit" class="add-to-cart">Add to Cart</button>
                        </form>
                    </div>
        <%
                }
            }
        %>
    </div>

    <div class="footer">
        &copy; 2024 Idiot's Food Delivery App. All rights reserved.
    </div>

</body>
</html>
