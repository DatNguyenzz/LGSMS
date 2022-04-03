<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Product detail</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/productdetail.css" rel="stylesheet">
</head>

<body>
    <%
    Product product = (Product) request.getAttribute("product");
%>
    <header>
        <div include-html="components/header.jsp" id="header" style="display: contents;"></div>
    </header>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3 class="text-title text-uppercase"><%=product.getProductName()%></h3>
                <div class="row">
                    <div class="col-lg-5 col-md-5 col-sm-6">
                        <div class="white-box text-center"><img src="assets/image/gastank12kg_vanngang.jpg" class="img-responsive img-border"></div>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-6">
                        <h4 class="box-title mt-5"><%=product.getProductName()%></h4>
                        <ul class="list-info">
                            <li>Giá bán: <%=product.getProductPrice()%></li>
                            <li style="color: #ff1313;">Giá khuyến mại: </li>
                            <li>Thương hiệu: Gas Petrolimex</li>
                            <li>Tình trạng: <% if(product.getProductInstock()>0){ %> Còn hàng<%} else{%>Hết hàng <%}%></li>
                            <li>Bảo hành: Có sổ bảo hiểm bình gas</li>
                        </ul>
                        <button class="btn btn-dark btn-rounded mr-1" data-toggle="tooltip" title="" data-original-title="Add to cart">
                                <i class="fa fa-shopping-cart"> Thêm vào giỏ hàng</i>
                            </button>
                        <button class="btn btn-primary btn-rounded">Mua ngay</button>
                    </div>
                    <h3 class="box-title mt-5" style="border-top:1px solid rgb(194, 180, 180)">Mô tả sản phẩm</h3>
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="table-responsive">
                            <% if(product.getProductName().equalsIgnoreCase("Bình Ga 12kg Van Ngang")){%>
                            <div include-html="assets/view_product_des/gas12kgvanngang.html" id="product_description" style="display:contents"></div>
                            <%} else if(product.getProductName().equalsIgnoreCase("Bình Ga 12kg Van Chụp")){%>
                            <div include-html="assets/view_product_des/gas12kgvanchup.html" id="product_description" style="display:contents"></div>
                            <%} else if(product.getProductName().equalsIgnoreCase("Bình Ga 13kg")){%>
                             <div include-html="assets/view_product_des/gas13kg.html" id="product_description" style="display:contents"></div>
                            <%}else if(product.getProductName().equalsIgnoreCase("Bình Công Nghiệp 48kg")){%>
                            <div include-html="assets/view_product_des/gas48kgcongnghiep.html" id="product_description" style="display:contents"></div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div include-html="components/footer.jsp" id="footer" style="display: contents;"></div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/include-html.min.js"></script>
</body>

</html>