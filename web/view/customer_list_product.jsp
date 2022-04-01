<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Product_List</title>
    <!-- Favicon-->
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link href="//cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link href="//cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js">
    <link href="css/home_product_list.css" rel="stylesheet" type="text/css">

</head>


<body>
    <header>
        <div include-html="components/header.jsp" id="header" style="display: contents;"></div>
    </header>
  <%
            ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
        %>
    <div class="container d-flex justify-content-center mt-50 mb-50">
        <div class="row">
            <div class="col-md4 mt-4 ">
                <form action="CustomerProduct" method="get" class="float-right">
                    <label for="filter">Bộ lọc <i class="bi bi-funnel-fill"></i>:</label>
                    <select name="filter" id="filters">
                      <option value="0">Tất cả sản phẩm</option>
                      <option value="1">Thấp dến cao</option>
                      <option value="2">Cao đến thấp</option>
                      <option value="3">Từ A-Z</option>
                      <option value="4">Từ Z-A</option>
                    </select>
                    <input type="submit" value="Ấn"> 
                </form>
            </div>
            
             <%for (Product product : listProduct) {%>
            <div class="col-md-4 mt-4">
                <div class="card">
                    <div class="card-body">
                        <div class="card-img-actions"> <img src="assets/image/gastank12kg_vanchuc.jpg" class="card-img img-fluid" width="96" height="350" alt=""> </div>
                    </div>
                    <div class="card-body bg-light text-center">
                        <div class="mb-2">
                            <h6 class="font-weight-semibold mb-2">
                                <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=product.getProductID()%>" 
                                   class="text-default mb-2" data-abc="true"><%=product.getProductName()%></a> </h6>
                            
                        </div>
                        <h3 class="mb-0 font-weight-semibold"><%=product.getProductPrice()%></h3>
                        <button type="button" class="bg-cart"><i class="fa fa-cart-plus mr-2"></i> Add to cart</button>
                    </div>
                </div>
            </div>
            <%}%>
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