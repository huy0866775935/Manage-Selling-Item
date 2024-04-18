<%-- 
    Document   : header
    Created on : 10-Mar-2023, 01:01:15
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="Dal.CategoryDao"%>
<%@page import="Model.Category"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="view/css/styleself.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/fe000f9b2a.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <section class="header">
            <nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Hourseware GoGo</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="dashbsr">Back</a>
                            </li>
                            <!--call CategoryDao ra va dung-->
                            <%
                                CategoryDao cdb = new CategoryDao();
                                List<Category> list = cdb.getAll();
                            %>


                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                   aria-expanded="false">
                                    Category
                                </a>
                                <ul class="dropdown-menu">
                                    <%
                                   for (Category category : list) {
                                    %>
                                    <li><a class="dropdown-item" href="#"><%= category.getCategory_name()%></a></li>
                                        <%
                                    }%>   
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                   aria-expanded="false">
                                    More
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="#">Link 1</a></li>
                                    <li><a class="dropdown-item" href="#">Link 2</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Link 3</a></li>
                                </ul>
                            </li>

                        </ul>
                                <a class="back" href="">Back</a>
                        <c:if test="${empty account}">
                            <form action="login" method="get">
                                <button type="submit" value="Login" class="btn btn-success">Login</button>
                            </form>
                        </c:if>
                        <c:if test="${not empty account}">
                            <div class="btn-group danger">
                                <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                    Hello, &nbsp; ${sessionScope.account.displayname}
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="signout">Sign out</a></li>
                                </ul>
                            </div>
                        </c:if>



                    </div>
                </div>
            </nav>
        </section>
        <section class="text-bg-secondary">
            <div class="container p-2">
                <div class="row">
                    <div class="col-lg-1" style="font-size: 40px;">
                        <i class="fa-brands fa-docker"></i>
                    </div>
                    <!--xu ly search-->
                    <div class="col-lg-11">
                        <form action="main" method="GET">
                             <div class="input-group mt-2">
                                 <input type="text" class="form-control" placeholder="Searching" name="key" value="${param.key}"
                                   aria-label="Recipient's username" aria-describedby="button-addon2">
                            <button type="submit" class="btn btn-primary btn-lg"><i
                                    class="fa-solid fa-magnifying-glass"></i></button>
                        </div>
                        </form>
                       
                    </div>
                </div>
            </div>
        </section>



    </body>
</html>
