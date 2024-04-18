<%-- 
    Document   : newjsp
    Created on : 13-Feb-2023, 16:29:01
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="icon/dd.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="weblogin/css/style_signup.css" rel="stylesheet" >

        <style>
            body{
                background: url(image/cooking-kitchen-appliance-utensils.jpg);
                background-size: cover;
                background-position-y: -110px;
                font-family: "Inter", sans-serif;
            }
        </style>
    </head>

    <body>
        <div class="contrainer">

            <form action="newpassword" id="form-signup" method="POST">
                <div class="login-header">
                    <h1>New Password</h1>
                    <p>Please fill in this form to create an password!</p>
                </div>
                <c:if test="${not empty error3}">
                <h5 style="text-align: center">${error3}</h5>    
                </c:if>
                <input type="password" name="pass" placeholder="Create new password" class="form-item" required>

                <input type="password" name="cpass" placeholder="Confirm your password" class="form-item" required> 

                <input type="checkbox"  checked>
                <label id="checkboxx">I accept the <a href="#">Term of Use</a> & <a href="#">Privacy
                        Policy.</a></label> <br>

                <button type="submit">Change </button>
            </form>
        </div>
    </body>

</html>
