<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page import="Model.Account"%>
<%@page import="Utility.FormatNumber"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-Home
        </title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">

    </head>
    <%
        ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
        FormatNumber formatNumber = new FormatNumber();
        Account account = (Account) request.getSession().getAttribute("account");
    %>
    <body>
        <div class="header">
            <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
            <div class="banner" style="background-image: url(Customer_LGSMS/images/bg4.webp);">
            </div>
        </div>

        <!-- Feature Why Section -->
        <div include-html="Customer_LGSMS/view/why_us.html" id="whyus"></div>
        <!-- Feature product-->
        <div class="small-container product_section ">
            <h2 class="title ">Sản phẩm</h2>
            <div class="row ">
                <%for(int i=0;i<4;i++){%>
                <div class="col-4">
                    <div class="box">
                        <div class="option_container">
                            <div class="options">
                                <%if(account!=null){%>
                                <a href="<%=request.getContextPath()%>/AddProductToCart?productID=<%=listProduct.get(i).getProductID()%>" class="option1">
                                    Thêm vào giỏ
                                </a>
                                <%}%>
                                <a href="" class="option2">
                                    Mua ngay
                                </a>
                                <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=listProduct.get(i).getProductID()%>" class="option3">
                                    Chi tiết
                                </a>
                            </div>
                        </div>
                        <div class="img-box">
                            <img src="<%= listProduct.get(i).getImagePath()%>" 
                                 alt="<%= listProduct.get(i).getProductName() %>">
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
        <!-- Feature offer-->
        <div class="offer ">
            <div class="small-container ">
                <div class="row ">
                    <div class="col-2 ">
                        <img src="Customer_LGSMS/images/gashong.png " class="offer-img ">
                    </div>
                    <div class="col-2 ">
                        <p>Sản phẩm được lựa chọn nhiều nhất</p>
                        <h1>Bình gas 12kg</h1>
                        <small>Là loại bình gas phổ biến trong mỗi gia đình, cho chất lượng lửa xanh, tiết kiệm nhiên liệu, độ bền cao, chống cháy nổ tốt</small><br>
                        <a href=" " class="btn ">Mua Ngay</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer-->
        <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
        <!--js for toggle menu-->
        <!-- <script src="/js/header.js"></script> -->
        <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
        <script src="Customer_LGSMS/js/include-html.min.js"></script>

    </body>

</html>