

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
            input[type=email] {
                width: 90%;
                padding: 15px;
                margin: 10px 0 ;
                border: 1px solid wheat;
                outline:none;
            }

            h5{
                text-align: center;
                width: 90%;
                height: 10px;
                color: red;
            }
        </style>
    </head>

    <body>
        <div class="contrainer">
            <h1>Forgot Password</h1>
            <c:if test="${not empty error2}">
                <h5>${error2}</h5>
            </c:if>
            <form action="forgotpwd" method="post" >
                <input type="email"  placeholder="abc@gmail.com" name="gmail" value="${user.email}" required>
                <button type="submit">Submit </button>
            </form>
            <footer>
                <p>Back to<a href="login"> Login</a></p>
            </footer>
        </div>
    </body>
</html>
