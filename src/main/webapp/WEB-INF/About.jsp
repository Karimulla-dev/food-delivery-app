<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us - Janu's Food Delivery App</title>
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
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header .right a {
            color: #fff;
            text-decoration: none;
            margin-left: 20px;
            font-size: 1.1em;
        }

        .header .right a.btn {
            background-color: #fff;
            color: #000;
            border: 1px solid #000;
            padding: 10px 15px;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }

        .header .right a.btn:hover {
            background-color: #000;
            color: #fff;
        }

        .content {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .content h1 {
            font-size: 2em;
            color: #333;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 1.1em;
            color: #777;
            line-height: 1.6;
            margin-bottom: 20px;
        }

        .content .mission {
            font-size: 1.3em;
            font-weight: bold;
            color: #ff6600;
            margin-bottom: 20px;
        }

        .content .team {
            margin-top: 30px;
            color: #333;
        }

        .content .team h2 {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        .content .team p {
            font-size: 1.1em;
            color: #555;
            line-height: 1.4;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="right">
            <a href="home.jsp">Home</a>
            <a href="Login.jsp" class="btn">Login</a>
        </div>
    </div>

    <div class="content">
        <h1>About Janu's Food Delivery App</h1>
        <p>
            Welcome to Janu's Food Delivery App! We are committed to bringing you the best food from your favorite local restaurants right to your doorstep. Our mission is to make it easy for you to enjoy delicious meals in the comfort of your own home.
        </p>
        <p>
            Whether you're craving a quick bite or looking to explore new cuisines, our app connects you with a wide variety of restaurants, offering everything from fast food to gourmet dishes. We pride ourselves on fast delivery, exceptional customer service, and a user-friendly experience.
        </p>
        <p class="mission">
            Our mission is to revolutionize the way you experience food delivery by offering top-notch services and a seamless ordering process.
        </p>

        <div class="team">
            <h2>Meet Our Team</h2>
            <p>
                Janu's Food Delivery App is powered by a dedicated team of food enthusiasts, tech experts, and customer service professionals who work tirelessly to bring you the best possible experience.
            </p>
            <p>
                From our developers who create and maintain the app, to our delivery partners who ensure your food arrives hot and fresh, every member of our team is passionate about what they do. We are here to serve you, and we take pride in every order we deliver.
            </p>
        </div>
    </div>
</body>
</html>
