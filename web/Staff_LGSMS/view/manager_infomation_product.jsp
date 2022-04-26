<%@page import="Utility.FormatNumber"%>
<%@page import="Model.Provider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>LGS - Admin</title>

        <!-- Custom fonts for this template -->
        <link href="Staff_LGSMS/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/view_list_account.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
    </head>
    <%
        Product product = (Product) request.getAttribute("product");
        ArrayList<Provider> listProvider = (ArrayList<Provider>) request.getAttribute("listProvider");
        FormatNumber formatNumber = new FormatNumber();
    %>
    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <div include-html="Staff_LGSMS/components/sidebar.jsp" id="sidebar" style="display: contents;"></div>
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
            <!-- End of Sidebar -->
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column" class="img js-fullheight" 
                 style="background-image: url(Staff_LGSMS/assets/image/fac2.jpg); background-size: cover;">
                <!-- Main Content -->
                <div id="content">
                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <div include-html="Staff_LGSMS/components/topnavbar.jsp" id="topnavbar" class="ml-auto"></div>
                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-white">Chi tiết sản phẩm</h1>
                        </div>

                        <!-- DataTales Example -->
                        <div class="row" style="width: 100%;">
                            <div class="col-8 col-sm-12">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Sản phẩm</h6>
                                    </div>
                                    <div class="card-body">
                                        <!-- <div class="table-responsive"> -->

                                        <!-- <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> -->
                                        <form id="form" action="<%=request.getContextPath()%>/EditProduct" method="POST">
                                            <div class="row" style="padding: auto;">
                                                <div class="col-8 col-sm-4" style="text-align: center ;">
                                                    <img src="<%=product.getImagePath()%>" alt="..."
                                                         class="img-thumbnail" style="height: 400px; width: 400px;">
                                                    <span><input type="file" id="user_avatar"
                                                                 accept="image/png, image/jpeg"></span>
                                                </div>
                                                <div class="col-8 col-sm-4">
                                                    <div class="form-group" hidden>
                                                        <label for="product-code" class="col-form-label">Mã sản phẩm:</label>
                                                        <input type="text" class="border border-secondary w-100 rounded label_box" 
                                                               readonly class="form-control-plaintext"
                                                               id="product-code" name="productID" value="<%=product.getProductID()%>">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="product-name" class="col-form-label">Tên sản phẩm:</label>
                                                        <input type="text" class="form-control" id="product-name" name="productName"
                                                               value="<%=product.getProductName()%>" maxlength="50"/>
                                                        <p class="fail"></p>
                                                    </div>
                                                    <div class="form-group">
                                                        <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
                                                        <label for="provider-name" class="col-form-label">Tên thương
                                                            hiệu:</label>
                                                        <select name="providerID" id="product-status"
                                                                class="border border-secondary w-100 label_box rounded">
                                                            <%for (Provider pv : listProvider) {%>
                                                            <option value="<%=pv.getProviderID()%>"
                                                                                <%if(product.getProviderID() == pv.getProviderID()){%>selected<%}%>
                                                                                    ><%=pv.getProviderName()%> </option>
                                                                        <%}%>
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
                                                        <label for="product-sell" class="col-form-label">Số bình đầy:</label>
                                                        <input type="number" class="form-control" id="product-sell" min="1" readonly
                                                               value="<%=product.getProductInstock()%>" /></input>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <label for="product-stored" class="col-form-label">Số bình rỗng:</label>
                                                        <label type="text" class="border border-secondary w-100 rounded label_box" 
                                                               readonly class="form-control-plaintext" id="product-stored"
                                                               ><%=product.getProductEmpty()%></label>
                                                    </div>
                                                    <br>
                                                    <div class="row">
                                                        <div class="col">
                                                            <label for="product-create" class="col-form-label">Ngày
                                                                tạo:</label>
                                                            <label type="text" class="border border-secondary w-100 rounded label_box"                                                                                                            " 
                                                                   readonly class="form-control-plaintext" id="product-create"
                                                                   ><%=product.getProductCreatedAt()%></label>
                                                        </div>
                                                        <div class="col">
                                                            <label for="product-update" class="col-form-label"
                                                                   style="text-align: right;">Ngày cập nhật:</label>
                                                            <label type="text" class="border border-secondary w-100 rounded label_box" 
                                                                   readonly class="form-control-plaintext" id="product-update"
                                                                   ><%=product.getProductUpdatedAt()%></label>
                                                        </div>
                                                    </div>
                                                    <!-- <label for="cus-note" class="col-form-label">Ghi chú của khách hàng:</label>
                                                        <textarea class="border border-secondary w-100 p-2 rounded" readonly class="form-control-plaintext" id="order-note" style="resize: none; overflow: auto;"></textarea> -->
                                                </div>
                                                <div class="col-8 col-sm-4">
                                                    <div class="form-group">
                                                        <label for="product-price" class="col-form-label">Giá bán:</label>
                                                        <input type="number" class="form-control" id="product-price" min="1" placeholder="<%=formatNumber.formatDoubleToString(product.getProductPrice())%>"
                                                               value="<%=formatNumber.formatDoubleToNumber(product.getProductPrice())%>" name="productPrice" maxlength="25"/>
                                                        <p class="fail"></p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="product-import" class="col-form-label">Giá nhập:</label>
                                                        <label type="text" class="border border-secondary w-100 rounded label_box" 
                                                               readonly class="form-control-plaintext" id="product-import">
                                                            <%=formatNumber.formatDoubleToVND(product.getProductImportPrice())%>
                                                        </label>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <label for="product-status" class="col-form-label">Trạng
                                                            thái:</label><br>
                                                        <select name="productStatus" id="product-status"
                                                                class="border border-secondary w-100 label_box rounded">
                                                            <option value="true">Hoạt động</option>
                                                            <option value="false"<%if (!product.isIsActive()) {%>selected<%}%>>Ngừng hoạt động</option>
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <label for="product-description" class="col-form-label">Mô tả:</label>
                                                        <textarea type="text" class="form-control" name="productDescription"
                                                                  id="product-description" style="resize: none; height: 115px;"><%=product.getProductDescription()%></textarea>
                                                    </div>
                                                        <div style="margin-top: 7%; float: right ; padding:5%">
                                                        <input type="submit" class="btn btn-primary submit px-3"
                                                            value="Lưu"></input>
                                                    </div>
                                                    

                                                </div>
                                            </div>
                                        </form>
                                        <!-- </table> -->
                                        <!-- </div> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="Staff_LGSMS/vendor/jquery/jquery.min.js"></script>
    <script src="Staff_LGSMS/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="Staff_LGSMS/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="Staff_LGSMS/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="Staff_LGSMS/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="Staff_LGSMS/js/demo/datatables-demo.js"></script>
    <script src="Staff_LGSMS/js/include-html.min.js"></script>
    <script src="Staff_LGSMS/js/valdation/product_info_validation.js"></script>
    <script src="Staff_LGSMS/js/valdation/alert.js"></script>
    <script src="Staff_LGSMS/js/fnon.min.js"></script>
</body>

</html>