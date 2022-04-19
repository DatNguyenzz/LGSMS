<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
    
<%
    Product product = (Product) request.getAttribute("product");
    ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("productByProvider");
    FormatNumber formatNumber = new FormatNumber();
%>
    <div class="header">
        <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
    </div>
    <!-- Feature product detail-->
    <div class="small-container single-product">
        <div class="row">
            <div class="col-2">
                <img src="Customer_LGSMS/images/gallery-1.jpg" width="100%" id="productImg">
                
            </div>
            <div class="col-2">
                <h1><%=product.getProductName()%></h1>
                <p> <%=product.getProviderName()%></p>
                <small> <% if(product.getProductInstock()>0){ %> Còn hàng<%} else{%>Hết hàng <%}%></small>
                <h4><%= formatNumber.formatDoubleToVND(product.getProductPrice()) %></h4>
                
                <a href="<%=request.getContextPath()%>/AddProductToCart?productID=<%=product.getProductID()%>" class="btn"><i class="fa fa-shopping-cart"></i> Thêm Vào Giỏ Hàng</a>
                <a href="" class="btn-buynow">Mua Ngay</a>
            </div>
        </div>

    </div>
    <!--Product detail-->
    <div id="product_detail">
        <%= product.getProductDescription()%>
    </div>
    <!-- title-->
    <div class="small-container">
        <div class="row row-2">
            <h2>Sản phẩm tương tự</h2>
            <a href="<%=request.getContextPath()%>/Product"><p>Xem thêm</p></a>
        </div>
    </div>
    <!-- Feature product-->
    <div class="small-container product_section">
        <div class="row ">
                <%for(int i=0;i<4;i++){%>
                <div class="col-4">
                    <div class="box">
                        <div class="option_container">
                            <div class="options">
                                <a href="<%=request.getContextPath()%>/AddProductToCart?productID=<%=listProduct.get(i).getProductID()%>" class="option1">
                                    Thêm vào giỏ
                                </a>
                                <a href="" class="option2">
                                    Mua ngay
                                </a>
                                <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=listProduct.get(i).getProductID()%>" class="option3">
                                    Chi tiết
                                </a>
                            </div>
                        </div>
                        <div class="img-box">
                            <img src="Customer_LGSMS/images/product-1.jpg" alt="">
                        </div>
                        <div class="detail-box">
                            <h5>
                                <%= listProduct.get(i).getProductName() %>
                            </h5>

                            <h6>
                                <%= formatNumber.formatDoubleToVND(listProduct.get(i).getProductPrice()) %>
                            </h6>
                        </div>
                    </div>
                </div>
                <%if(i == listProduct.size()-1){break;} }%>
            </div>

    </div>

    </div>
    <!-- footer-->
    <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
    <!-- footer-->

    <!-- footer-->
    <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
    <script src="Customer_LGSMS/js/include-html.min.js"></script>

</body>

</html>