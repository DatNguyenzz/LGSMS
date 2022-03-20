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
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../assets/styles/sb-admin-2.min.css" rel="stylesheet">
    <link href="../css/view_list_account.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>


<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <div include-html="../components/sidebar.html" id="sidebar" style="display: contents;"></div>
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
                    <div include-html="../components/topnavbar.html" id="topnavbar" class="ml-auto"></div>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Chi tiết đơn hàng</h1>
                    </div>

                    <!-- DataTales Example -->
                    <div class="row" style="width: 100%;">
                        <div class="col-8 col-sm-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Đơn hàng</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">

                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <div class="row" style="border: 2px solid lightgray;">
                                                <div class="col-8 col-sm-1"></div>
                                                <div class="col-8 col-sm-5">
                                                    <label for="order-code" class="col-form-label">Mã đơn
                                                        hàng:</label>
                                                    <label type="text" class="border border-secondary w-100 p-2 rounded" id="order-code">LG240</label>
                                                    <label for="order-price" class="col-form-label">Tổng giá
                                                        tiền:</label>
                                                    <label type="text" class="border border-secondary w-100 p-2 rounded" id="order-price">5.489.000đ</label>
                                                    <label for="staff-order" class="col-form-label">Nhân viên nhận
                                                        đơn:</label>
                                                    <label type="text" class="border border-secondary w-100 p-2 rounded" id="staff-order">Truong
                                                        Quang Phuoc</label>
                                                    <label for="order-date" class="col-form-label">Ngày nhận
                                                        đơn:</label>
                                                    <label type="text" class="border border-secondary w-100 p-2 rounded" id="order-date">10/03/2022</label>
                                                    <label for="cus-note" class="col-form-label">Ghi chú:</label>
                                                    <textarea class="border border-secondary w-100 p-2 rounded" readonly class="form-control-plaintext" id="order-note" style="resize: none; overflow: auto;"></textarea>

                                                </div>
                                                <div class="col-8 col-sm-5">
                                                    <label for="customer-name" class="col-form-label">Tên khách
                                                        hàng:</label>
                                                    <label type="text" class="border border-secondary w-100 p-2 rounded" id="customer-name">Truong Gia Viet Anh</label>

                                                    <label for="order-address" class="col-form-label">Địa chỉ khách
                                                        hàng:</label>
                                                    <label type="text" class="border border-secondary w-100 p-2 rounded" id="order-address">118
                                                        Hồ Tây, Hoàn Kiếm, Hà Nội</label>
                                                    </lable>
                                                    <form id="form" action="business_new_order.html">
                                                        <label for="order-status" class="col-form-label">Trạng
                                                            thái:</label><br>
                                                        <select name="order-status" id="order-status" class="border border-secondary w-100 p-2 rounded" style="margin-bottom: 8px;">
                                                            <option value="status-1">Đang xử lí</option>
                                                            <option value="status-2">Đã nhận đơn</option>
                                                            <option value="status-3">Đơn bị hủy</option>
                                                            <option value="status-4">Đang vận chuyển</option>
                                                            <option value="status-5">Hoàn thành</option>
                                                        </select>
                                                        <label for="order-note" class="col-form-label">Nhân viên ghi
                                                            chú:</label>
                                                        <textarea class="border border-secondary w-100 p-2 rounded" id="order-note" style="resize: none; overflow: auto;"></textarea>
                                                        <div style="margin-top: 3%; float: right">
                                                            <input type="submit" class="btn btn-primary submit px-3" value="Lưu"></input>
                                                            <!-- <a href="business_new_order.html"><button type="button" class="btn btn-secondary" >Hủy</button></a> -->
                                                        </div>
                                                    </form>

                                                </div>
                                            </div>
                                            <thead>
                                                <tr>
                                                    <th>Ảnh</th>
                                                    <th>Tên sản phẩm</th>
                                                    <th>Giá bán</th>
                                                    <th>Số lượng</th>
                                                    <th>Tổng giá sản phẩm</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><img src="../../"></td>
                                                    <td>Bình gas 12kg</td>
                                                    <td>5</td>
                                                    <td>499.000</td>
                                                    <td>2.495.000đ</td>

                                                </tr>
                                                <tr>
                                                    <td><img src="../../"></td>
                                                    <td>Bình gas 12kg</td>
                                                    <td>6</td>
                                                    <td>499.000</td>
                                                    <td>2.994.000đ</td>

                                                </tr>
                                                <tr>

                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <!-- <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer> -->
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="../vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="../vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="../js/demo/datatables-demo.js"></script>
    <script src="../js/include-html.min.js"></script>
</body>

</html>