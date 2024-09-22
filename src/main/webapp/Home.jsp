<%@ page import="com.food.model.Restaurant" %>
<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Idiot's - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 0;
            margin: 0;
        }

        /* Header and Navigation */
        .header {
            background-color: #000;
            color: #fff;
            padding: 15px 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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
            text-decoration: none;
            margin-left: 20px;
            font-size: 1.1em;
        }

        .header .right a.btn {
            background-color: #ff6600;
            color: #fff;
            border: 1px solid #ff6600;
            padding: 10px 15px;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .header .right a.btn:hover {
            background-color: #e55d00;
        }

        /* Hero Section */
        .hero {
            background-image: url('<%= request.getContextPath() %>/images/flat-lay-arrangement-with-food-copy-space.jpg');
            background-size: cover;
            background-position: center;
            color: #fff;
            padding: 100px 20px;
            text-align: center;
            box-shadow: inset 0 0 10px rgba(0, 0, 0, 0.5);
        }

        .hero h1 {
            font-size: 3em;
            margin: 0;
            font-weight: bold;
        }

        .hero p {
            font-size: 1.4em;
            margin-top: 20px;
        }

        /* Restaurant List Styles */
        .restaurant-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            padding: 20px;
        }

        .restaurant-card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            margin: 10px;
            padding: 15px;
            width: calc(25% - 20px); /* 4 cards per row */
            box-sizing: border-box;
            text-align: center;
            transition: transform 0.3s ease;
            position: relative;
            min-height: 400px;
        }

        .restaurant-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .restaurant-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 8px 8px 0 0;
        }

        .restaurant-name {
            font-size: 1.4em;
            margin: 15px 0;
            color: #333;
        }

        .restaurant-details {
            font-size: 1em;
            color: #777;
            margin-bottom: 20px;
        }

        .restaurant-details span {
            display: block;
            margin: 5px 0;
        }

        .view-menu {
            background-color: #ff6600;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            font-size: 1em;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 10px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        .view-menu:hover {
            background-color: #e55d00;
        }

        /* Footer Styles */
        .footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
            margin-top: 40px;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <!-- Header with Navigation -->
    <div class="header">
        <div class="left">Idiot's Food Delivery</div>
        <div class="right">
            <a href="<%= request.getContextPath() %>/Home">Home</a>
            <a href="<%= request.getContextPath() %>/About">About</a>
            <% 
                Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
                if (loggedIn != null && loggedIn) {
            %>
                <a href="<%= request.getContextPath() %>/logout" class="btn">Logout</a>
            <% 
                } else {
            %>
                <a href="<%= request.getContextPath() %>/Login.jsp" class="btn">Login</a>
            <% 
                }
            %>
        </div>
    </div>

    <!-- Hero Section -->
    <div class="hero">
        <h1>Welcome to Idiot's Food Delivery App</h1>
        <p>Delicious food delivered to your doorstep.</p>
    </div>

    <h2 style="text-align: center; margin-top: 20px;">Available Restaurants</h2>
    
    <div class="restaurant-list">
        <%
            List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurantList");

            if (restaurants != null && !restaurants.isEmpty()) {
                for (Restaurant restaurant : restaurants) {
        %>
            <div class="restaurant-card">
                <a href="<%= request.getContextPath() %>/Menu?restaurantId=<%= restaurant.getRestaurantID() %>">
                    <img src="<%= request.getContextPath() + '/' + restaurant.getImagePath() %>" 
                         alt="<%= restaurant.getRestaurantName() %>" 
                         class="restaurant-image"/>
                    <h2 class="restaurant-name"><%= restaurant.getRestaurantName() %></h2>
                </a>
                <div class="restaurant-details">
                    <span>Cuisine Type: <%= restaurant.getCuisineType() %></span>
                    <span>Delivery Time: <%= restaurant.getDeliveryTime() %> mins</span>
                    <span>Rating: <%= restaurant.getRating() %> / 5</span>
                </div>
                <a href="<%= request.getContextPath() %>/Menu?restaurantId=<%= restaurant.getRestaurantID() %>" class="view-menu">View Menu</a>
            </div>
        <%
                }
            } else {
        %>
            <p style="text-align: center; width: 100%;">No restaurants available at the moment.</p>
        <%
            }
        %>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; 2024 Idiot's Food Delivery App. All rights reserved.
    </div>
</body>
</html>
