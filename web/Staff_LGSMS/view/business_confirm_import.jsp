<%@page import="Utility.FormatNumber"%>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Importation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>LGS - Manager</title>

        <!-- Custom fonts for this template -->
        <link href="Staff_LGSMS/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/icon_action.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
    </head>
    <%
        ArrayList<Importation> listImport = (ArrayList<Importation>) request.getAttribute("listImport");
        ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
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
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-white">Quản lý hàng nhập</h1>
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal"
                                    data-target="#exampleModal" data-whatever="@getbootstrap"><i
                                    class="fas fa-plus fa-sm text-white-50"></i> Tạo đơn nhập từ khách</button>
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
                                            <form action="<%=request.getContextPath()%>/ImportFromCustomer" method="POST" id="form1">
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <div class="row">
                                                            <div class="col-8 col-sm-12 ">
                                                                <div class="form-group">
                                                                    <label for="product-name">Tên sản phẩm:</label>
                                                                    <select name="product-id" id="product-name"
                                                                            class="border border-secondary w-100 label_box rounded">
                                                                        <%for (Product p : listProduct) {%>
                                                                        <option value="<%=p.getProductID()%>">
                                                                            <%=p.getProductName()%>
                                                                        </option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <br>
                                                                <div class="form-group">
                                                                    <label for="return-quantity">Số lượng:</label>
                                                                    <input type="number" id="return-quantity"
                                                                           name="product-quantity" class="form-control" />
                                                                    <div class="fail"></div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="return-note" class="col-form-label">Ghi
                                                                        chú:</label>
                                                                    <textarea class="form-control" name="import-note"
                                                                              style="resize: none; overflow: auto;"
                                                                              id="return-note"></textarea>

                                                                </div>
                                                                <br>
                                                                <div class="row">
                                                                    <div class="col-12">
                                                                        <div style="margin-top: 2%; float: right">
                                                                            <input type="submit" class="btn btn-primary"
                                                                                   value="Lưu"></input>
                                                                            <button type="button" class="btn btn-secondary"
                                                                                    data-dismiss="modal">Hủy</button>
                                                                        </div>
                                                                    </div>
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
                        <!-- Page Heading -->
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Danh sách đơn nhập</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Nguồn</th>
                                                <th>Số lượng</th>
                                                <th>Ngày tạo</th>
                                                <th>Tổng chi phí nhập</th>
                                                <th>Người tạo đơn</th>
                                                <th>Trạng thái</th>
                                                <th>Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Importation i : listImport) {%>
                                            <tr>
                                                <td><%=i.getProductName()%></td>
                                                <td><%=(i.getProviderName() == null) ? "Khách hàng" : i.getProviderName()%></td>
                                                <td><%=i.getProductImportQuantity()%></td>
                                                <td><%=i.getCreatedAt()%></td>
                                                <td><%=formatNumber.formatDoubleToVND(i.getImportAmount())%></td>
                                                <td><%=(i.getManagerName() == null) ? i.getStaffName() : i.getManagerName()%></td>
                                                <td>
                                                    <%switch (i.getImportStatus()) {
                                                            case 0: {%>
                                                    <p id="status_pending">Đang xử lý</p>
                                                    <%break;
                                                        }
                                                        case 1: {%>
                                                    <p id="status_complete">Đã hoàn thành</p>
                                                    <%break;
                                                        }
                                                        case 2: {%>
                                                    <p id="status_reject">Đã hủy</p>
                                                    <%break;
                                                            }
                                                        }%>
                                                </td>
                                                <!-- <td>
                                                    <a href="#viewImportModal" class="view" data-toggle="modal"><i
                                                            class="bi bi-pencil-square" data-toggle="tooltip" title="View"></i></a>
                                                </td> -->
                                                <td>
                                                    <a href="#viewImportModal" class="view" data-toggle="modal"
                                                       onclick="handleClickDetail(  '<%=i.getImportID()%>',
                                                                                    '<%=i.getProductName()%>',
                                                                                    '<%=(i.getProviderName() == null) ? "Khách hàng" : i.getProviderName()%>',
                                                                                    '<%=i.getProductImportQuantity()%>',
                                                                                    '<%=formatNumber.formatDoubleToNumber(i.getImportAmount())%>',
                                                                                    '<%=i.getNote()%>',
                                                                                    '<%=i.getImportStatus()%>')">
                                                        <i class="fas fa-eye" data-toggle="tooltip" title="View"></i></a>
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


                    <!-- End of Main Content -->

                </div>
                <!-- End of Content Wrapper -->
                <div class="modal fade" id="viewImportModal" role="dialog" aria-labelledby="viewImportModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Thông tin nhập hàng</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="<%=request.getContextPath()%>/ConfirmNewImport" id="form" method="POST">
                                    <div class="row">
                                        <div class="col-sm-12" style="margin: auto;">
                                            <div class="row">
                                                <div class="col-8 col-sm-12" style="margin: auto;">
                                                    <!--<input id="import_id" name="import-id"  value="">-->
                                                    <div class="form-group" hidden>
                                                        <!--<label for="product-name">Tên sản phẩm:</label>-->
                                                        <input id="importId" name="import-id" value="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="product-name">Tên sản phẩm:</label>
                                                        <input type="text" id="productNameInfo" name="productName" readonly
                                                               class="form-control"/>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <label for="provider-name" class="col-form-label">Nguồn</label>
                                                        <input type="text" id="providerNameInfo" name="providerNameInfo"
                                                               readonly class="form-control"/>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <label for="product-quantity">Số lượng:</label>
                                                        <input type="number" id="product-quantity" name="product-quantity"
                                                               class="form-control" readonly/>
                                                        <div class="fail"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="product-price" class="col-form-label">Giá
                                                            nhập:</label>
                                                        <input type="number" class="form-control" name="product-price"
                                                               id="product-price" readonly/>
                                                        <div class="fail"></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="importOrderStatus" class="col-form-label">Trạng
                                                            thái:</label><br>
                                                        <select name="import-status" id="import-status"
                                                                class="border border-secondary w-100 label_box rounded">
                                                            <option value="1">Duyệt đơn</option>
                                                            <option value="2">Hủy đơn</option>
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="form-group">
                                                        <label for="product-note" class="col-form-label">Ghi
                                                            chú:</label>
                                                        <textarea class="form-control" readonly id="import-note"></textarea>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="checkbox" uncheck id="import-fullfill" name="import-fullfill" onclick='handleClick(this);'
                                                               value="">
                                                        <label for="import-fullfill" class="col-form-label">Hàng nhập có chỉnh sửa</label>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-4"></div>
                                                        <div class="col-8">
                                                            <div class="form-group">
                                                                <label for="import-pay" style="float: right;"
                                                                       class="col-form-label">Tổng chi phí nhập
                                                                    hàng (VNĐ):</label>
                                                                <input type="number"
                                                                       style="text-align: right;font-size: 36px;"
                                                                       readonly
                                                                       class="form-control bg-white border-0"
                                                                       id="import-pay" value="" />
                                                            </div>
                                                            <div style="margin-top: 2%; float: right">
                                                                <input type="submit" class="btn btn-primary" id="confirm-btn"
                                                                       value="Xác nhận nhập hàng">
                                                                <button type="button" class="btn btn-secondary"
                                                                        data-dismiss="modal">Hủy</button>
                                                            </div>
                                                        </div>
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
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Bootstrap core JavaScript-->
            <script src="Staff_LGSMS/vendor/jquery/jquery.min.js"></script>
            <script src="Staff_LGSMS/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="Staff_LGSMS/vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="Staff_LGSMS/js/sb-admin-2.min.js"></script>
            <!-- Page level plugins -->
            <script src="Staff_LGSMS/vendor/datatables/jquery.dataTables.min.js"></script>
            <script src="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="Staff_LGSMS/js/demo/datatables-demo.js"></script>
            <script src="Staff_LGSMS/js/include-html.min.js"></script>
            <script src="Staff_LGSMS/js/valdation/import_confirm_validate.js"></script>
            <script src="Staff_LGSMS/js/valdation/alert.js"></script>
            <script src="Staff_LGSMS/js/fnon.min.js"></script>
            
            <script>
                const importID = document.getElementById("importId");
                const productNameImportCus = document.getElementById("productNameInfo");
                const providerNameImportCus = document.getElementById("providerNameInfo");
                const productImportQuantityImportCus = document.getElementById("product-quantity");
                const productImportPriceImportCus = document.getElementById("product-price");
                const importAmountImportCus = document.getElementById("import-pay");
                const noteImportCus = document.getElementById("import-note");
                
                const handleClickDetail = (importIdInput,
                                        productNameInput,
                                        providerNameInput,
                                        productImportQuantityInput,
                                        importAmountInput,
                                        importNoteInput,
                                        importStatusInput) => {
                        importID.value = importIdInput;
                        productNameImportCus.value = productNameInput;
                        providerNameImportCus.value = providerNameInput;
                        productImportQuantityImportCus.value = productImportQuantityInput;
                        importAmountImportCus.value = importAmountInput;
                        noteImportCus.value = importNoteInput;
                        productImportPriceImportCus.value = importAmountInput / productImportQuantityInput;
                        if(importStatusInput==0){
                            document.getElementById("confirm-btn").disabled = false;
                        }else{
                            document.getElementById("confirm-btn").disabled = true;
                        }
                    };
                
            </script>
            <script>
                var imprice = document.getElementById('product-price'),
                    imquantity = document.getElementById('product-quantity'),
                    payment = document.getElementById('import-pay');
                payment.value =handleClick imprice.value * imquantity.value;
                imquantity.onchange = function () {
                    var result = parseFloat(imquantity.value) * parseFloat(imprice.value);
                    payment.value = !isNaN(result) ? result : '';
                }

                imprice.onchange = function () {
                    var result = parseFloat(imquantity.value) * parseFloat(imprice.value);
                    payment.value = !isNaN(result) ? result : '';
                }
            </script>
    </body>
</html>
