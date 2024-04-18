

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/dd.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link  rel="stylesheet" href="webhead/css/styles.css" />
        <link  rel="stylesheet" href="webhead/css/styledashboard.css" />
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
                <div class="container mt-3">

                    <div class="row">
                        <div class="col-lg-3 col-sm-6 col-12">
                            <div class="dash-widget">
                                <div class="dash-widgetimg">
                                    <span><i class="fa-solid fa-hashtag"></i></span>
                                </div>
                                <div class="dash-widgetcontent">
                                    <h5>$<span class="counters" data-count="307144.00">${numpro}</span></h5>
                                    <h6>Number Of Product</h6>
                                </div>
                            </div>

                        </div>
                        <div class="col-lg-3 col-sm-6 col-12 d-flex">
                            <div class="dash-widget dash1">
                                <div class="dash-widgetimg">
                                    <span><i class="fa-solid fa-user-tie"></i></span>
                                </div>
                                <div class="dash-widgetcontent">
                                    <h5>$<span class="counters" data-count="4385.00">${numuser}</span></h5>
                                    <h6>Account List</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-12 d-flex">
                            <div class="dash-widget dash2">
                                <div class="dash-widgetimg">
                                    <span><i class="fa-solid fa-file-circle-minus"></i></span>
                                </div>
                                <div class="dash-widgetcontent">
                                    <h5>$<span class="counters" >${numorder}</span></h5>
                                    <h6>Order List</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-12 d-flex">
                            <div class="dash-widget dash3">
                                <div class="dash-widgetimg">
                                    <span><i class="fa-solid fa-file-circle-minus"></i></span>
                                </div>
                                <div class="dash-widgetcontent">
                                    <h5><span class="counters" data-count="385656.50">${numsupplier}</span></h5>
                                    <h6>Supplier</h6>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Page content2 - chart and top product-->
<!--                    <div class="row">
                        <div class="col-lg-7 col-sm-12 col-12 d-flex">
                            <div class="card flex-fill">
                                <div class="card-header pb-0 d-flex justify-content-between align-items-center">
                                    <h5 class="card-title mb-0">Purchase & Sales</h5>
                                    <div class="graph-sets">
                                        <ul>
                                            <li>
                                                <span>Sales</span>
                                            </li>
                                            <li>
                                                <span>Purchase</span>
                                            </li>
                                        </ul>
                                        <div class="dropdown">
                                            <button class="btn btn-white btn-sm dropdown-toggle" type="button"
                                                    id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                                                2022 <img src="assets/img/icons/dropdown.svg" alt="img" class="ms-2">
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <li>
                                                    <a href="javascript:void(0);" class="dropdown-item">2022</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:void(0);" class="dropdown-item">2021</a>
                                                </li>
                                                <li>
                                                    <a href="javascript:void(0);" class="dropdown-item">2020</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div id="sales_charts"></div>
                                </div>
                            </div>
                        </div>

-->                        <div class="col-lg-5 col-sm-12 col-12 d-flex">
                            <div class="card flex-fill">
                                <div class="card-header pb-0 d-flex justify-content-between align-items-center">
                                    <h4 class="card-title mb-0">Recently Added Products</h4>
                                    <div class="dropdown">
                                        <a href="javascript:void(0);" data-bs-toggle="dropdown" aria-expanded="false"
                                           class="dropset">
                                            <i class="fa fa-ellipsis-v"></i>
                                        </a>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <li>
                                                <a href="productlist.html" class="dropdown-item">Product List</a>
                                            </li>
                                            <li>
                                                <a href="addproduct.html" class="dropdown-item">Product Add</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive dataview">
                                        <table class="table datatable ">
                                            <thead>
                                                <tr>
                                                    <th>Product_id</th>
                                                    <th>Product_name</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>4</td>
                                                    <td class="productimgname">
                                                        <a href="productlist.html" class="product-img">
                                                            <img src="assets/img/product/product6.jpg" alt="product">
                                                        </a>
                                                        <a href="productlist.html">Macbook Pro</a>
                                                    </td>
                                                    <td>$291.01</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div><!--
-->                            </div>
                        </div><!--

                         Page content3 - table list product out of stock
                        <div class="row">
                            <div class="card-body">
                                <h4 class="card-title">Expired Products</h4>
                                <div class="table-responsive dataview">
                                    <table class="table datatable ">
                                        <thead>
                                            <tr>
                                                <th>SNo</th>
                                                <th>Product Code</th>
                                                <th>Product Name</th>
                                                <th>Brand Name</th>
                                                <th>Category Name</th>
                                                <th>Expiry Date</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td><a href="javascript:void(0);">IT0001</a></td>
                                                <td class="productimgname">
                                                    <a class="product-img" href="productlist.html">
                                                        <img src="assets/img/product/product2.jpg" alt="product">
                                                    </a>
                                                    <a href="productlist.html">Orange</a>
                                                </td>
                                                <td>N/D</td>
                                                <td>Fruits</td>
                                                <td>12-12-2022</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td><a href="javascript:void(0);">IT0002</a></td>
                                                <td class="productimgname">
                                                    <a class="product-img" href="productlist.html">
                                                        <img src="assets/img/product/product3.jpg" alt="product">
                                                    </a>
                                                    <a href="productlist.html">Pineapple</a>
                                                </td>
                                                <td>N/D</td>
                                                <td>Fruits</td>
                                                <td>25-11-2022</td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td><a href="javascript:void(0);">IT0003</a></td>
                                                <td class="productimgname">
                                                    <a class="product-img" href="productlist.html">
                                                        <img src="assets/img/product/product4.jpg" alt="product">
                                                    </a>
                                                    <a href="productlist.html">Stawberry</a>
                                                </td>
                                                <td>N/D</td>
                                                <td>Fruits</td>
                                                <td>19-11-2022</td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td><a href="javascript:void(0);">IT0004</a></td>
                                                <td class="productimgname">
                                                    <a class="product-img" href="productlist.html">
                                                        <img src="assets/img/product/product5.jpg" alt="product">
                                                    </a>
                                                    <a href="productlist.html">Avocat</a>
                                                </td>
                                                <td>N/D</td>
                                                <td>Fruits</td>
                                                <td>20-11-2022</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>-->

                </div>
            </div>
            <!-- Bootstrap core JS-->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            <!-- Core theme JS-->
            <script src="webhead/js/scripts.js"></script>
    </body>

</html>
