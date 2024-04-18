<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="Model.Product" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Simple Sidebar - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="icon/dd.png" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="view/css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="view/css/styledashboard.css">

    <script src="https://kit.fontawesome.com/fe000f9b2a.js" crossorigin="anonymous"></script>
    <style>
        table,
        th,
        td {
            border: 1px solid;
        }

        th {
            height: 40px;
            width: 20%;
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
            <!-- Page content-->
            <div class="contatiner mt-4">
                <div class="row">
                    <div class="col-lg-4 mb-3 ms-3">
                        <h5>Product Details</h5>
                        <h6>Full detail of a product</h6>
                    </div>
                </div>
                <div class="row">
                   <%
                       List<Product> list = (List<Product>) request.getAttribute("data");
                      if(list != null)
                        for(Product i : list){
                   %>
                    <div class="col-lg-7 ms-3">
                        <table>
                            <tr>
                                <th>Product_id</th>
                                <td><p><%=i.getProduct_id()%></p></td>
                            </tr>
                            <tr>
                                <th>Product_name</th>
                                <td><%=i.getProduct_name()%></td>
                            </tr>
                            <tr>
                                <th>Quantity</th>
                                <td><%=i.getQuantify()%></td>
                            </tr>
                            <tr>
                                <th>Unit</th>
                                <td><%=i.getUnit()%></td>
                            </tr>
                            <tr>
                                <th>Status</th>
                                <td><%=i.getStatus()%></td>
                            </tr>
                            <tr>
                                <th>Supplier_id</th>
                                <td><%=i.getSupplier_id()%></td>
                            </tr>
                            <tr>
                                <th>Describe</th>
                                <td>
                                    <p><%=i.getDescribe()%></p>
                                </td>
                            </tr>
                            <tr>
                                <th>Create_at</th>
                                <td><%=i.getCreate_at()%></td>
                            </tr>
                            <tr>
                                <th>Update_at</th>
                                <td><%=i.getUpdated_at()%></td>
                            </tr>
                            <tr>
                                <th>CategoryName</th>
                                <td><%=i.getCate().getCategory_name()%></td>
                            </tr>
                   
                        </table>
                    </div>
                    <div class="col-lg-4">

                        <div class="slider-product-is" style="text-align: center;">
                            <div class="contatiner ">
                                <div class="slider-product">
                        
                                    <img src="img_product/<%=i.getPhoto()%>" alt=""alt="img" width="349px" height="220px">                
                                    
                                     <%
                                         }
                                     %>
                                </div>

                            </div>
                        </div>
 
                    </div>
                </div>
            </div>


        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="view/js/scripts.js"></script>
</body>

</html>