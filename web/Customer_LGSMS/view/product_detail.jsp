<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
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

%>
    <div class="header">
        <div include-html="Customer_LGSMS//view/header.jsp" id="header"></div>
    </div>
    <!-- Feature product detail-->
    <div class="small-container single-product">
        <div class="row">
            <div class="col-2">
                <img src="Customer_LGSMS/images/gallery-1.jpg" width="100%" id="productImg">
                <div class="small-img-row">
                    <div class="small-img-col">
                        <img src="Customer_LGSMS/images/gallery-1.jpg" width="100%" class="small-image">
                    </div>
                    <div class="small-img-col">
                        <img src="Customer_LGSMS/images/gallery-2.jpg" width="100%" class="small-image">
                    </div>
                    <div class="small-img-col">
                        <img src="Customer_LGSMS/images/gallery-3.jpg" width="100%" class="small-image">
                    </div>
                    <div class="small-img-col">
                        <img src="Customer_LGSMS/images/gallery-4.jpg" width="100%" class="small-image">
                    </div>
                </div>
            </div>
            <div class="col-2">
                <p><%=product.getProductID()%></p>
                <h1><%=product.getProductName()%></h1>
                <p> <%=product.getProviderName()%></p>
                <small> <% if(product.getProductInstock()>0){ %> Còn hàng<%} else{%>Hết hàng <%}%></small>
                <h4><%=product.getProductPrice()%></h4>
                
                <a href="<%=request.getContextPath()%>/Product?productID=<%=product.getProductID()%>" class="btn"><i class="fa fa-shopping-cart"></i> Thêm Vào Giỏ Hàng</a>
                <a href="" class="btn-buynow">Mua Ngay</a>
            </div>
        </div>

    </div>
    <!--Product detail-->
    <div include-html="Customer_LGSMS/view_product_detail/gas12kgvanchup.html" id="product_detail"></div>
    <!-- title-->
    <div class="small-container">
        <div class="row row-2">
            <h2>Sản phẩm tương tự</h2>
            <p>Xem thêm</p>
        </div>
    </div>
    <!-- Feature product-->
    <div class="small-container product_section">
        <div class="row">
             <%for (Product productOfProvider : listProduct) {%>
                <div class="box">
                    <div class="option_container">
                        <div class="options">
                            <a href="<%=request.getContextPath()%>/Product?productID=<%=productOfProvider.getProductID()%>" class="option1">
                             Thêm vào giỏ
                             </a>
                            <a href="" class="option2">
                                Mua ngay
                            </a>
                            <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=productOfProvider.getProductID()%>&providerID=<%=productOfProvider.getProviderID()%>" class="option3">
                               Chi tiết
                             </a>
                        </div>
                    </div>
                    <div class="img-box">
                        <img src="Customer_LGSMS/images/product-1.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                             <%=productOfProvider.getProductName()%>
                        </h5>

                        <h6>
                            <%=productOfProvider.getProductPrice()%>
                        </h6>
                    </div>
                </div>
         <%}%>
            
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