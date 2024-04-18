
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Customer"%>
<%@page import="Model.Order"%>
<%@page import="Dal.CustomerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="icon/dd.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="view/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="view/css/styledashboard.css">
        <script src="https://kit.fontawesome.com/fe000f9b2a.js" crossorigin="anonymous"></script>
        <style>
            .container > .row{
                background-color: whitesmoke;
                border: 1px solid rgba(228, 198, 181, 0.235);
                padding: 10px 10px 10px 10px;
            }

            i {
                font-size: 20px;
            }
            
              .pagination a.active {
                background-color: #777;
                color: white;
            }
            .pagination a:hover:not(.active) {
                background-color: #fff;
            }
            .pagination {
                display: inline-block;
            }
            .pagination a {
                color: black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }

        </style>


    </head>

    <body style="background-color: floralwhite;">
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
             <div class="border-end bg-light" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light"> <i class="fa-brands fa-docker"></i> Hourseware GoGo</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="dashbsr"> &nbsp; Dashboard</a>
                    <div class="dropdown list-group-item list-group-item-action list-group-item-light p-3">
                        <button class="dropbtn">Product</button>
                        <div class="dropdown-content">
                            <a href="lps">Product List</a>
                            <a href="adps">Add Product</a>
                            <a href="lcs">Category List</a>
                            <a href="acs">Add Category</a>
                        </div>
                    </div>

                    <div class="dropdown list-group-item list-group-item-action list-group-item-light p-3">
                        <button class="dropbtn">Orders</button>
                        <div class="dropdown-content">
                            <a href="orderlist">Order List</a>
                        </div>
                    </div>
                    <div class="dropdown list-group-item list-group-item-action list-group-item-light p-3">
                        <button class="dropbtn">People</button>
                        <div class="dropdown-content">
                            <a href="listcustomer">Customer List</a>
                            <a href="addcustomer"> Add Customer</a>
                            <a href="listsupplier">Supplier List</a>
                            <a href="addsupplier">Add Supplier</a>

                        </div>
                    </div>     
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!"> &nbsp; Charts</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">&nbsp; Account</a>
                    <div class="dropdown list-group-item list-group-item-action list-group-item-light p-3">
                        <button class="dropbtn">Users</button>
                        <div class="dropdown-content">
                            <a href="#">New User</a>
                            <a href="#">Users List</a>
                        </div>
                    </div>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">&nbsp; Sign Out</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-subtle bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle"><i class="fa-solid fa-bars"></i></button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation"><span
                                class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link" href="main">Home</a></li>
                                <li class="nav-item dropdown">
                                    
                                       <c:if test="${not empty account}">
                                           <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                                              data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Hello, &nbsp; ${sessionScope.account.displayname}</a>   
                                       </c:if>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="signout">Sign out</a>
                                        <a class="dropdown-item" href="#!">Account</a>

                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                
                <!-- content -->
                <div class="container mt-3">
                    <%
                     CustomerDao cdb = new CustomerDao();  
                     List<Order> list = (List<Order>) request.getAttribute("listorder");
                     if(list != null){
                     for(Order i: list){ 
                    %>
                        <div class="row mb-2">
                            <div class="col-lg-1 mt-2">
                                <span><%= i.getOrderid()%></span>
                            </div>
                           <%  String cusid = i.getCustomerid();
                               Customer c = cdb.getByCheckIdCustomer(cusid); %>
                            <div class="col-lg-4" >
                                <span>CustomerId: <%=i.getCustomerid()%></span> <br>
                                <span>Email: <%=c.getEmail()%></span>

                            </div>
                            <div class="col-lg-3" >
                                <span>Phone: <%= c.getPhonenumber()%></span> <br>
                                <span>Address: <%= c.getAddress()%></span>
                            </div>
                            <div class="col-lg-3" >
                                <span>Date: <%=i.getOrderdate()%></span> <br>
                                <span>Total: <%=i.getTotal()%></span>
                            </div>
                            <div class="col-lg-1 mt-2 text-end">
                                <a href="orderdetail?orderid=<%=i.getOrderid()%>&orderdate=<%=i.getOrderdate()%>"><i class="fa-solid fa-circle-info"></i></a>
                            </div>
                        </div>
                            <%
                                }}%>
                </div>

                <!-- paging -->
                 <div class="row">
                        <center>

                            <c:set var="page" value="${requestScope.page}"/>
                            <div class="pagination">
                                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                    <a href="orderlist?page=${i}" class="${i==page?"active":""}">${i}</a>
                                </c:forEach>
                            </div>
                        </center>

                    </div>

            </div>
            <!-- Bootstrap core JS-->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            <!-- Core theme JS-->
            <script src="view/js/scripts.js"></script>
    </body>

</html>