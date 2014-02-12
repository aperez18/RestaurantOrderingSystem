<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catchy Restaurant Title</title>
    </head>
    <body>
        <h1>
            Welcome to [Insert Restaurant Name Here]!
        </h1>
        <p>
            Click below to place your order.
        </p>
        
        <div>
            <form id="orderForm" name="orderForm" method="POST" action="controller">
                <input type="submit" id="submit" name="submit" value="submit">
            </form>
        </div>
    </body>
</html>
