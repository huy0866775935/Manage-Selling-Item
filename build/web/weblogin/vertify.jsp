

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="icon/dd.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="weblogin/css/style_forgotpassword.css" rel="stylesheet" >

        <style>
            input[type=text] {
                width: 90%;
                padding: 15px;
                margin: 10px 0 ;
                border: 1px solid wheat;
                outline:none;
            }
        </style>
    </head>

    <body>
        <div class="contrainer">
            <h1>Confirm Vertify:</h1>
            <%
                String str = (String) session.getAttribute("vertify"); 
                if( str != null){
            %>
            <span style="color: greenyellow">We already send a verification code to your email</span>

            <% } %>
            <form action="vertifycode" method="post" >
                <input type="text" name="code" placeholder="Enter code">
                <h6>${enzo}</h6>
                <button type="submit">Confirm </button>

            </form>

        </div>
    </body>
</html>
