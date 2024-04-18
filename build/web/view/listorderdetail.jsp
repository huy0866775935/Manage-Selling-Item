<%-- 
    Document   : listorderdetail
    Created on : 20-Mar-2023, 04:35:16
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">


        <title>order details</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="icon/dd.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body {
                background: #eee;
            }

            .card {
                box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid rgba(0, 0, 0, .125);
                border-radius: 1rem;
            }

            .text-reset {
                --bs-text-opacity: 1;
                color: inherit !important;
            }

            a {
                color: #5465ff;
                text-decoration: none;
            }
        </style>
    </head>

    <body style="background-color: floralwhite;">
        <div class="container-fluid">
            <div class="container">
                <div class="d-flex justify-content py-3">
                    <a href="orderlist">Orders List &nbsp;  </a>/ &nbsp;
                    <a href="#">Order Detail</a>
                </div>
                <div class="d-flex justify-content-between align-items-center py-3">
                    <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Order #${numor}</h2>
                </div>

                <div class="row">
                    <div class="col-lg-8">

                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="mb-3 d-flex justify-content-between">
                                    <div>
                                        <span class="me-3">${odd.shipdate}</span>
                                        <span class="badge rounded-pill bg-info">SHIPPING</span>
                                    </div>
                                    <div class="d-flex">
                                        <button class="btn btn-link p-0 me-3 d-none d-lg-block btn-icon-text"><i
                                                class="bi bi-download"></i> <span class="text">Invoice</span></button>
                                        <div class="dropdown">
                                            <button class="btn btn-link p-0 text-muted" type="button"
                                                    data-bs-toggle="dropdown">
                                                <i class="bi bi-three-dots-vertical"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                                <li><a class="dropdown-item" href="#"><i class="bi bi-pencil"></i> Edit</a>
                                                </li>
                                                <li><a class="dropdown-item" href="#"><i class="bi bi-printer"></i>
                                                        Print</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-borderless">
                                    <c:set var="x" value="0"/>
                                    <c:forEach var="i" items="${op}">
                                        <tr>
                                            <td>
                                                <div class="d-flex mb-2">
                                                    <div class="flex-shrink-0">
                                                        <img src="img_product/${i.p.photo}"
                                                             alt="" width="35" class="img-fluid">
                                                    </div>
                                                    <div class="flex-lg-grow-1 ms-3">
                                                        <h6 class="small mb-0">${i.p.product_name}</h6>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>${i.quantity}</td>
                                            <td class="text-end">${i.price}</td>
                                            <c:set var="c" value="${x + i.price}" />
                                            <c:set var="x" value="${c}"/>
                                        </tr>
                                    </c:forEach>

                                    <tfoot>
                                        <tr>
                                            <td colspan="2">Subtotal</td>
                                            <c:set var="myFormattedNumber">
                                                <fmt:formatNumber value="${x}" type="number" pattern="#0.00" />
                                            </c:set>

                                            <td class="text-end">$${myFormattedNumber}</td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">Discount</td>
                                            <td class="text-danger text-end">-$0</td>
                                        </tr>
                                        <tr class="fw-bold">
                                            <td colspan="2">TOTAL</td>
                                            <td class="text-end">$${total}</td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>

                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <h3 class="h6">Payment Method</h3> 
                                        <p>Cash <br>
                                            Total: $${total} <span class="badge bg-success rounded-pill">PAID</span></p>
                                    </div>
                                    <div class="col-lg-6">
                                        <h3 class="h6">Billing address</h3>
                                        <address>
                                            <strong>${odd.c.firstname}${odd.c.lastname}</strong><br>
                                            ${odd.address}<br>
                                            <abbr title="Phone">P:</abbr> ${odd.c.phonenumber}
                                        </address>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">

                        <div class="card mb-4">
                            <div class="card-body">
                                <h3 class="h6">Staff Notes</h3>
                                <p>Staff</p>
                            </div>
                        </div>
                        <div class="card mb-4">

                            <div class="card-body">
                                <h3 class="h6">Shipping Information</h3>
                                <hr>
                                <h3 class="h6">Address</h3>
                                <address>
                                    <strong>${odd.c.firstname}${odd.c.lastname}</strong><br>
                                    ${odd.address}<br>
                                    <abbr title="Phone">P:</abbr> ${odd.c.phonenumber}
                                </address>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
