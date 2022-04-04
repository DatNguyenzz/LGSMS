<%@page import="Model.Provider"%>
<%@page import="Model.Product"%>
<%@page import="Model.Importation"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/styles/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="assets/styles/table_header.css" rel="stylesheet">
        <link href="assets/styles/custom_box.css" rel="stylesheet">
    </head>
    <%
        ArrayList<Importation> listImport = (ArrayList<Importation>) request.getAttribute("listImportation");
        ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
        ArrayList<Provider> listProvider = (ArrayList<Provider>) request.getAttribute("listProvider");
    %>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <div include-html="components/sidebar.jsp" id="sidebar" style="display: contents;"></div>
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
            <!-- End of Sidebar -->
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">
                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                        <!-- Topbar Navbar -->
                        <div include-html="components/topnavbar.jsp" id="topnavbar" class="ml-auto"></div>
                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Quản lý kho</h1>
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal"
                                    data-target="#exampleModal" data-whatever="@getbootstrap"><i
                                    class="fas fa-plus fa-sm text-white-50"></i> Nhập hàng</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thông tin nhập hàng</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="<%=request.getContextPath()%>/ManageImport" method="POST" id="form" onsubmit="confirmFunction()">
                                                <div class="row" style="width: 100%;">
                                                    <div class="col-sm-12">
                                                        <div class="row">
                                                            <div class="col-8 col-sm-12 ">
                                                                <div class="form-group">
                                                                    <label for="product-name">Tên sản phẩm:</label>
                                                                    <select name="product-id" id="product-name"
                                                                            class="border border-secondary w-100 label_box rounded">
                                                                        <%for(Product pro : listProduct){%>
                                                                        <option value="<%=pro.getProductID()%>"><%=pro.getProductName()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="provider-name" class="col-form-label">Tên
                                                                        nhà cung cấp:</label>
                                                                    <select name="provider-id" id="product-status"
                                                                            class="border border-secondary w-100 label_box rounded">
                                                                        <%for(Provider provider : listProvider){%>
                                                                        <option value="<%=provider.getProviderID()%>"><%=provider.getProviderName()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-quantity">Số lượng:</label>
                                                                    <input type="number" id="product-quantity"
                                                                           name="product-quantity" min="1"
                                                                           class="form-control" required oninvalid="this.setCustomValidity('Xin hãy số lượng sản phẩm.')" oninput="this.setCustomValidity('')" />
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-price" class="col-form-label">Giá
                                                                        nhập:</label>
                                                                    <input type="number" class="form-control" min="100" name="product-import-price"
                                                                           id="product-price" required oninvalid="this.setCustomValidity('Xin hãy nhập tiền sản phẩm.')" oninput="this.setCustomValidity('')" />
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-note" class="col-form-label">Ghi
                                                                        chú:</label>
                                                                    <textarea class="form-control" name="import-note"
                                                                              id="product-note"></textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input type="checkbox" id="import-type" name="import-from-customer">
                                                                    <label for="import-type" class="col-form-label">Nhập hàng từ khách</label>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <input type="submit" class="btn btn-primary"
                                                                           value="Nhập"></input>
                                                                    <button type="button" class="btn btn-secondary"
                                                                            data-dismiss="modal">Hủy</button>
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
                                <h6 class="m-0 font-weight-bold text-primary">Danh sách hàng nhập</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Nhà cung cấp</th>
                                                <th>Số lượng</th>
                                                <th>Ngày nhập</th>
                                                <th>Giá nhập lẻ</th>
                                                <th>Tổng tiền</th>
                                                <th>Người nhập</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Importation importation : listImport) {%>
                                            <tr>
                                                <td><%=importation.getProductName()%></td>
                                                <td><%=importation.getProviderName()%></td>
                                                <td><%=importation.getProductImportQuantity()%></td>
                                                <td><%=importation.getImportDate()%></td>
                                                <td><%=(importation.getImportAmount() / importation.getProductImportQuantity())%></td>
                                                <td><%=importation.getImportAmount()%></td>
                                                <td><%=importation.getStaffName()%></td>
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
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>
        <script src="js/table_header.js"></script>
        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/include-html.min.js"></script>
        <script src="js/confirm.js"></script>
    </body>

</html>