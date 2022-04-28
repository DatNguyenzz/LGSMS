<%@page import="Model.Product"%>
<%@page import="Model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Utility.FormatNumber"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-ALl Product
        </title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="header">
            <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
        </div> 

        <%
            ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
            FormatNumber formatNumber = new FormatNumber();
            Account account = (Account) request.getSession().getAttribute("account");
            String[] listFilter = {"Tất cả sản phẩm", "Giá tăng", "Giá giảm", "Tên A-Z", "Tên Z-A", "Sản phẩm bán chạy"};
            String filterString = request.getAttribute("filter").toString();
            int filter;
            if(filterString == null){
                filter = 0;
            }else{
                filter = Integer.parseInt(filterString);
            }
        %>
        <!-- Feature product-->
        <div class="small-container product_section">
            <div class="row row-2">
                <h1 class="">Sản phẩm
                    <hr>
                </h1>
                <form action="<%=request.getContextPath()%>/Product" method="GET" class="float-right">
                    <div>
                        <label for="filter">Bộ lọc <i class="bi bi-funnel-fill"></i>:</label>
                        <select name="filter" id="filters" onChange="this.form.submit()">
                            <% for(int i=0; i<listFilter.length; i++){%>
                            <option value="<%=i%>" 
                                    <%if(filter == i){%> selected <%}%>  >

                                <%=listFilter[i]%>
                            </option>
                            <%}%>
                        </select>
                        <!--<input type="submit" value="Ấn" >-->
                    </div>
                </form>
            </div>


            <div class="row">
                <%if(listProduct.size()==0){%>
                <h2 style="padding-bottom: 45vh">Không tìm thấy sản phẩm phù hợp</h2>
                <%}else{
                    for (Product product : listProduct) {
                %>
                <div class="box">
                    <div class="option_container">
                        <div class="options">
                            <%  if(product.getProductInstock() > 0){ %>
                            <%  if(account != null){%>
                            <a href="<%=request.getContextPath()%>/AddProductToCart?productID=<%=product.getProductID()%>" class="option1">
                                Thêm vào giỏ
                            </a>
                            <%}%>
                            <a href="" class="option2">
                                Mua ngay
                            </a>
                            <% } %>
                            <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=product.getProductID()%>" class="option3">
                                Xem chi tiết
                            </a>
                        </div>
                    </div>
                    <div class="img-box">
                        <img src="<%=product.getImagePath()%>" alt="<%=product.getProductName()%>">
                    </div>
                    <div class="detail-box">
                        <h5 style="width: 160px; height: 70px">
                            <%=product.getProductName()%>
                        </h5>

                        <h6>
                            <%=formatNumber.formatDoubleToVND(product.getProductPrice())%>
                        </h6>
                    </div>
                </div>
                <%}}%>


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