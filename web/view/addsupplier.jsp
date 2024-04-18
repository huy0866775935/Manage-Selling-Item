

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Add product</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="icon/dd.png" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="view/css/styles.css" rel="stylesheet" >
    <link href="view/css/styledashboard.css" rel="stylesheet">
    <link href="view/css/styleproduct.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/fe000f9b2a.js" crossorigin="anonymous"></script>


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
            <div class="container mt-4">
                <div class="row">
                    <div class="col-lg-6 ">
                        <h4>Supplier Add</h4>
                        <h6>Create new supplier</h6>
                    </div>

                    <hr>
                </div>
                <form action="addsupplier" method="post">
                <div class="row">
                    
                    <div class="col-lg-3">
                        <label for="">SupplierId:</label> <br>
                        <input type="text" name="sid" placeholder="sup_name" required>
                    </div>
                    <div class="col-lg-3">
                        <label for="">SupplierName:</label> <br>
                        <input type="text" name="sname"  required>
                    </div>
                    <div class="col-lg-3">
                        <label for="">Address: </label> <br>
                        <input type="text" name="saddress"  value="" required>
                    </div>
                    <div class="col-lg-3">
                        <label for="">Phone:</label> <br>
                        <input type="text" placeholder="8888888888" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" maxlength="10"  title="Ten digits code" name="sphone" required>
                    </div>
                    <div class="col-lg-3 mt-4">
                        <label for="">City: </label> <br>
                        <input type="text" name="scity" placeholder="Ha Noi"  required>
                    </div>

                </div>

                <div class="row">
                    <div class="col-lg-4 mt-4">
                        <button type="submit" class="btn btn-success">Add</button>
                        <button type="reset" class="btn btn-danger">Cancel</button>

                    </div>
                </div>
                
                </form>
                <div class="col-lg-8 mt-4">
                    <h6 style="color: red">${error}</h6>
                </div>

            </div>




        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="view/js/scripts.js"></script>
        
        
</body>

</html>
