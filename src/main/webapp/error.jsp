<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 50px;
            text-align: center;
        }

        .error-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }

        h1 {
            color: #e74c3c;
            font-size: 2.5em;
            margin: 0;
        }

        p {
            font-size: 1.2em;
            color: #333;
        }

        .error-details {
            font-size: 0.9em;
            color: #777;
            margin-top: 20px;
            word-wrap: break-word;
        }

        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Oops!</h1>
        <p>Something went wrong. Please try again later.</p>

        <div class="error-details">
            <strong>Error:</strong> 
            <%= exception != null ? exception.getMessage() : "Unknown error" %>
        </div>

        <a href="<%= request.getContextPath() %>/Home" class="btn">Go Back to Home</a>
    </div>
</body>
</html>
