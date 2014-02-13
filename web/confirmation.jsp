<%@page import="java.util.List"%>
<%@page import="model.Menu"%>
<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Order</title>
    </head>
    <body>
        <h3>
            Order Confirmation
        </h3>
        
        <strong>Thank you for your order!</strong>
        <p>
            You've ordered:<br><br>
            <%
                Menu order = (Menu)request.getAttribute("order");
                if(order == null){
                    out.print("Your order was null :(");
                }else{
                    out.print(order.toString());
                }
                List<MenuItem> items = order.getItems();
                double total = 0;
                double tax;
                for(MenuItem i:items){
                    total+= i.getPrice();
                }
            %>
        </p>
        <div name="totalOutput">
            Subtotal:&nbsp;
            <%= total %>
            <br><br>
            <b>Tax:&nbsp;</b>
            <%= total*.06 %>
            <br><br>
            <b>Total:&nbsp;</b>
            <%= total + (total*.06) %>
            <br><br>
            <b>Tip:&nbsp;</b>
            <%= (total + (total*.06))*.15 %>
        </div>
    </body>
</html>
