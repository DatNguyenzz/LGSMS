<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page import="Model.Account"%>
<%@page import="Utility.FormatNumber"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-Product Detail
        </title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap"
              rel="stylesheet">
        <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="Customer_LGSMS/css/product_slider.css" rel="stylesheet">
    </head>

    <body>

        <%
            Product product = (Product) request.getAttribute("product");
            ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("productByProvider");
            FormatNumber formatNumber = new FormatNumber();
            Account account = (Account) request.getSession().getAttribute("account");
        %>
        <div class="header">
            <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
        </div>
        <!-- Feature product detail-->
        <div class="small-container single-product">
            <div class="row">
                <div class="col-2">
                    <img src="<%=product.getImagePath()%>" width="100%" id="productImg">

                </div>
                <div class="col-2 ">
                    <h1 class="product_detail"><b><%=product.getProductName()%></b></h1>
                    <p class="p1">Thương hiệu: <%=product.getProviderName()%></p>
                    <p>Tình trạng: <% if(product.getProductInstock()>0){ %> <strong style="color:green;">Còn hàng</strong><%} else{%><strong style="color:red;">Hết hàng </strong><%}%></p>
                    <h4><%= formatNumber.formatDoubleToVND(product.getProductPrice()) %></h4>
                    <% if(product.getProductInstock() > 0){%>
                    <a href="<%=request.getContextPath()%>/AddProductToCart?productID=<%=product.getProductID()%>" class="btn-add"><i class="fa fa-shopping-cart"></i> Thêm Vào Giỏ Hàng</a>
                    <a href="" class="btn-buynow">Mua Ngay</a>
                    <%}%>
                </div>
            </div>

        </div>
        <!--Product detail-->
        <div class="container" id="product_detail">
            <%= product.getProductDescription()%>
        </div>
        <!-- title-->
        <div class="small-container">
            <div class="row-1 row-2">
                <h2><b>Sản phẩm tương tự</b></h2>
                <!--<a href="<%=request.getContextPath()%>/Product"><p>Xem thêm</p></a>-->
            </div>
        </div>
        <!-- Feature product-->

        <!-- Item slider-->
        <div class="container">
            <div class="row ">

                <div class="col-xs-12 col-sm-12 col-md-12" style="padding-bottom: 20px;">
                    <div class="carousel carousel-showmanymoveone slide" id="itemslider">
                        <div class="carousel-inner">
                            <%for(int i=0;i<listProduct.size()-1;i++){%>
                            <div class="item <% if(i==0){ %> active <%}%>">
                                <div class="box"> 
                                    <div class="col-xs-12 col-sm-6 col-md-2">
                                        <div class="option_container">
                                            <div class="options">
                                                <%  if(listProduct.get(i).getProductInstock() > 0){ %>
                                                <%  if(account != null){%>
                                                <a href="<%=request.getContextPath()%>/AddProductToCart?productID=<%=listProduct.get(i).getProductID()%>" class="option1">
                                                    Thêm vào giỏ
                                                </a>
                                                <%}%>
<!--                                                <a href="" class="option2">
                                                    Mua ngay
                                                </a>-->
                                                <% } %>
                                                <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=listProduct.get(i).getProductID()%>" class="option3">
                                                    Chi tiết
                                                </a>
                                            </div>
                                        </div>
                                        <img src="<%= listProduct.get(i).getImagePath() %>" alt="" style="height: 250px; width: 150px">
                                        <h5 style="text-align: center">
                                            <%= listProduct.get(i).getProductName() %>
                                        </h5>

                                        <h6 style="text-align: center">
                                            <%= formatNumber.formatDoubleToVND(listProduct.get(i).getProductPrice()) %>
                                        </h6>
                                    </div>
                                </div>

                            </div> <%if(i == listProduct.size()-1){break;} }%>   
                        </div>
                        <div id="slider-control">
                            <a class="left carousel-control" href="#itemslider" data-slide="prev"><img
                                    src="http://pixsector.com/cache/81183b13/avcc910c4ee5888b858fe.png" alt="Left"
                                    class="img-responsive" style="transform: scaleX(-1);"></a>
                            <a class="right carousel-control" href="#itemslider" data-slide="next"><img
                                    src="http://pixsector.com/cache/81183b13/avcc910c4ee5888b858fe.png" alt="Right"
                                    class="img-responsive"></a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- footer-->
        <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
        <!-- footer-->

        <!-- footer-->
        <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
        <script src="Customer_LGSMS/js/include-html.min.js"></script>

        <script src="Customer_LGSMS/js/slider_product.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

    </body>

</html>