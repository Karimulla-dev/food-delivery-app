<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
</head>
<body>

<h2>Your Cart</h2>

<!-- Display the cart items -->
<table border="1">
    <thead>
        <tr>
            <th>Item ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.itemId}</td>
                <td>${item.name}</td>
                <td>${item.quantity}</td>
                <td>${item.price}</td>
                <td>${item.quantity * item.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Link to go back to the menu -->
<a href="addToCart.jsp">Continue Shopping</a>

</body>
</html>
