<%-- 
    Document   : detailproduct
    Created on : 05-Mar-2023, 16:12:07
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="icon/dd.png" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link rel="stylesheet" href="view/css/styleself.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/fe000f9b2a.js" crossorigin="anonymous"></script>


    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <c:set var="p" value="${requestScope.data}"/>
        <section class="body mb-3">
            <div class="container mt-3">
                <div class="row">
                    <div class="col-lg-6 p-3" style="background-color: floralwhite;">
                        <a href="#" class="gallery-link"><img src="img_product/${p.photo}"
                                                              alt="" class="img-responsive push-bit" width="550px" height="350px"/></a>
                    </div>
                    <div class="col-lg-6" style="background-color: floralwhite;">
                        <div class="clearfix">
                            <div class="float-end">
                                <span class="h2"><strong>$ ${p.price}</strong></span>
                            </div>
                            <span class="h4">
                                <strong class="text-success">${p.product_name}</strong><br />
                                <small>${p.quantify} Available</small>
                            </span>
                        </div>
                        <hr />
                        <blockquote>
                            ${p.describe}
                        </blockquote>
                        <hr />
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
