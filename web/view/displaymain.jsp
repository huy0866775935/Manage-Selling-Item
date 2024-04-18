
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Home</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="icon/lloo.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link rel="stylesheet" href="view/css/styleself.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/fe000f9b2a.js" crossorigin="anonymous"></script>

        <style>

            
            .pagination a.active {
                background-color: #000;
                color: white;
            }
            .pagination a:hover:not(.active) {
                background-color: #fff;
            }
        </style>

    </head>

    <body>
       <jsp:include page="header.jsp"></jsp:include>

        <section class="content mt-3">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3" style="background-color: floralwhite;">
                        <section class="fiter">
                            <section class="panel">
                                <header class="panel-heading">
                                    Category
                                </header>
                                <div class="panel-body">
                                    <ul class="nav prod-cat">
                                        <c:forEach items="${requestScope.cat}" var="i">
                                            <li>
                                                <a href="#" class="active"><i class="fa fa-angle-right"></i> ${i.category_name}</a>
                                            </li>
                                            <hr>
                                        </c:forEach>

                                    </ul>
                                </div>
                            </section>

                         

                        </section>
                    </div>



                    <div class="col-lg-9">
                        <div class="row">
                            <section class="panel mb-2" style="background-color: floralwhite;">
                                <div class="panel-body">
                                    <div class="pull-right">
                                        <c:set var="page" value="${requestScope.page}" /> 
                                        <ul class="pagination pagination-sm pro-page-list">
                                            <c:forEach begin="${1}" end="${requestScope.num}" var="i">

                                                <li>  <a href="main?page=${i}" class="${i==page?"active":""}">${i}</a> </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </section>
                        </div>

                        <div class="row product-list" style="background-color: floralwhite;">
                            <c:forEach var="i" items="${requestScope.data}"> 
                                <div class="col-lg-4 mb-2">
                                    <div class="card bg-warning" style="width: 16rem;">
                                        <img src="img_product/${i.photo}" class="card-img-top" alt="${i.product_id}" width="286px" height="190px">
                                        <div class="card-body">
                                            <h5 class="card-title">${i.product_name}</h5>
                                            <p class="card-text"><strong>${i.status}</strong></p>
                                            <a href="displaydetail?pid=${i.product_id}" class="btn btn-primary" target="_blank">Detail</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                </div>
        </section>


        <jsp:include page="footer.jsp"></jsp:include>

        
              <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
                integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
                integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
    </body>
</html>
