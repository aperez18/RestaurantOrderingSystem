<%@page import="java.util.List"%>
<%@page import="model.Menu"%>
<%@page import ="model.MenuItem" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Form</title>
    </head>
    <body>
        <h2>
            Place your order
        </h2>
        <div id="content">
            <form name="orderForm" method="POST" action=""
            <%
                Menu menu = (Menu)request.getAttribute("menu");
                List<MenuItem> items = menu.getItems();
                for(MenuItem i: items){
                    String item = i.getName();
                    double price = i.getPrice();
            %>

            <input type="checkbox" name="menuItems" value="<%= item %>" /> 
            <%= (item + ", " + price) %>
            <br><br>

            <%        
                }
            %>
            <input type="submit" name="submit" id="submit" value="Place Order">
        </div>
    </body>
</html>
