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

        <title>LGS - Manager</title>

        <!-- Custom fonts for this template -->
        <link href="Staff_LGSMS/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/slider_status.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/icon_action.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/alert.css" rel="stylesheet">
    </head>

    <body id="page-top">
        <%
            ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
            ArrayList<Provider> listProvider = (ArrayList<Provider>) request.getAttribute("listProvider");
            FormatNumber formatNumber = new FormatNumber();
        %>
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
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-white">Qu???n l?? s???n ph???m</h1>
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap"><i class="fas fa-plus fa-sm text-white-50"></i> Th??m s???n ph???m</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">??i???n th??ng tin s???n ph???m</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <!-- Add new product -->
                                        <div class="modal-body">
                                            <form action="<%=request.getContextPath()%>/AddProduct" method="POST" id="form" enctype="multipart/form-data">
                                                <div class="row" style="width: 100%;">
                                                    <div class="col-sm-12">
                                                        <div class="row">
                                                            <div class="col-8 col-sm-5 text-center">
                                                                <img src="Staff_LGSMS/assets/image/img/undraw_posting_photo.svg" alt="..." class="img-thumbnail">
                                                                <!--<button type="button" class="btn btn-primary ">T???i ???nh</button>-->
                                                                <span><input type="file" id="product-img" accept="image/png, image/jpeg" form="form" name="image" required></span>
                                                            </div>
                                                            <div class="col-8 col-sm-7">
                                                                <div class="form-group">
                                                                    <label for="product-name" class="col-form-label">T??n s???n ph???m:</label>
                                                                    <input type="text" class="form-control" id="product-name" name="product-name" maxlength="50">
                                                                    <p class="fail"></p>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-provider">T??n th????ng hi???u:</label>
                                                                    <select name="provider-id" id="product-provider"
                                                                            class="border border-secondary w-100 label_box rounded">
                                                                        <%for(Provider pv : listProvider){%>
                                                                        <option value="<%=pv.getProviderID()%>"><%=pv.getProviderName()%> </option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <br>
                                                                <div class="form-group">
                                                                    <label for="product-quantity" class="col-form-label">S??? l?????ng:</label>
                                                                    <input type="number" class="form-control" id="product-quantity" name="product-quantity" maxlength="4">
                                                                    <p class="fail"></p>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-price" class="col-form-label">Gi?? b??n:</label>
                                                                    <input type="number" class="form-control" id="product-price" name="product-price" maxlength="25">
                                                                    <p class="fail"></p>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-des" class="col-form-label">M?? t???:</label>
                                                                    <textarea class="form-control" id="product-des" name="product-des" maxlength="500"></textarea>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <input type="submit" class="btn btn-primary" value="Th??m"></input>
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">H???y</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Page Heading -->
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Danh s??ch s???n ph???m</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>M?? s???n ph???m</th>
                                                <th>T??n s???n ph???m</th>
                                                <th>Th????ng hi???u</th>
                                                <th>C?? th??? b??n</th>
                                                <th>Gi?? b??n</th>
                                                <th>Gi?? nh???p</th>
                                                <th>Tr???ng th??i</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Product product : listProduct) {%>
                                            <tr>
                                                <td><%=product.getProductID()%></td>
                                                <td>
                                                    <a href="<%=request.getContextPath()%>/ProductInformation?productID=<%=product.getProductID()%>">
                                                        <%=product.getProductName()%>
                                                    </a>
                                                </td>
                                                <td><%=product.getProviderName()%></td>
                                                <td><%=product.getProductInstock()%></td>
                                                <td><%=formatNumber.formatDoubleToVND(product.getProductPrice())%></td>
                                                <td><%=formatNumber.formatDoubleToVND(product.getProductImportPrice())%></td>
                                                <td>
                                                    <%if (product.isIsActive()) {%>
                                                    <p id="status_complete">Ho???t ?????ng</p>
                                                    <%}else{%>
                                                    <p id="status_reject">Ng???ng b??n</p>
                                                    <%}%>


                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

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
        <script src="Staff_LGSMS/js/valdation/product_validate.js"></script>
        <script src="Staff_LGSMS/js/valdation/alert.js"></script>
        <script src="Staff_LGSMS/js/fnon.min.js"></script>
        <script src="Staff_LGSMS/js/modal_alert.js"></script>
        <% 
            String message = (String) request.getSession().getAttribute("message") ;
            
            if(message != null){
                
        %>
        <script>
            ModalWindow.openModal(
                {
                    title: "Confirm",
                    content: "<%=message%>"
                }
            );
        </script>
        <%} request.getSession().removeAttribute("message");%>
    </body>

</html>