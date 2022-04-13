<%-- 
    Document   : manager_view_infomation_voucher
    Created on : Apr 6, 2022, 9:31:53 PM
    Author     : Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LGS - Admin</title>

    <!-- Custom fonts for this template -->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../assets/styles/sb-admin-2.min.css" rel="stylesheet">
    <link href="../css/view_list_account.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="../assets/styles/custom_box.css" rel="stylesheet">
</head>


<body id="page-top">
    <%
                
        
        
        
    %>
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <div include-html="components/sidebar.html" id="sidebar" style="display: contents;"></div>
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>
        <!-- End of Sidebar -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column" class="img js-fullheight"
            style="background-image: url(../assets/image/fac2.jpg); background-size: cover;">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <div include-html="components/topnavbar.html" id="topnavbar" class="ml-auto"></div>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-white">Chi tiết phiếu thu</h1>
                    </div>

                    <!-- DataTales Example -->
                    <div class="row" style="width: 100%;">
                        <div class="col-8 col-sm-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    
                                    <!--Tôi giữ nguyên class với
                                    link đúng id với nhau nhé -->
                                    <span class="m-0 font-weight-bold text-primary">Phiếu thu</span>
                                    <a href="manager_view_information_order.jsp" class="order-voucher">Chuyển đơn hàng</a>
                                </div>
                                <form id="form" action="business_new_order.jsp">
                                    <div class="card-body">
                                        <!-- <div class="table-responsive"> -->
                                        <div class="row">
                                            <div class="col-8 col-sm-1"></div>
                                            <div class="col-8 col-sm-5">
                                                <label for="order-code" class="col-form-label">Mã đơn
                                                    hàng:</label>
                                                <input type="text" class="border border-secondary w-100 p-2 rounded"
                                                    id="order-code" required value="LG240" />
                                                <br><br>
                                                <label for="order-price" class="col-form-label">Tổng giá
                                                    tiền (VNĐ):</label>
                                                <input type="number" readonly
                                                    class="border border-secondary w-100 p-2 rounded" id="order-price"
                                                    value="6589000" />
                                                <br><br>
                                                <label for="order-deposit" class="col-form-label">Tiền cọc vỏ
                                                    bình (VNĐ):</label>
                                                <input type="number" readonly
                                                    class="border border-secondary w-100 p-2 rounded" id="order-deposit"
                                                    value="500000" />
                                                <br><br>
                                            
                                            <label for="staff-order" class="col-form-label">Nhân viên nhận
                                                đơn:</label>
                                            <input type="text" readonly
                                                class="border border-secondary w-100 p-2 rounded" id="staff-order"
                                                value="Truong Quang Phuoc" />
                                            <br><br>
                                            <label for="order-date" class="col-form-label">Ngày nhận
                                                đơn:</label>
                                            <input type="text" readonly
                                                class="border border-secondary w-100 p-2 rounded" id="order-date"
                                                value="10/03/2022" />
                                        </div>
                                        <div class="col-8 col-sm-5">
                                            <label for="voucher-code" class="col-form-label">Mã phiếu thu:</label>
                                            <input type="text" readonly
                                                class="border border-secondary w-100 p-2 rounded" id="voucher-code"
                                                value="LG240" />
                                            <br><br>
                                            <label for="customer-name" class="col-form-label">Tên khách
                                                hàng:</label>
                                            <input type="text" readonly
                                                class="border border-secondary w-100 p-2 rounded" id="customer-name"
                                                value="Truong Gia Viet Anh" />
                                            <br><br>
                                            <label for="order-status" class="col-form-label">Trạng
                                                thái:</label><br>
                                            <select name="order-status" id="order-status"
                                                class="border border-secondary w-100 p-2 rounded">
                                                <option selected value="0" <%   %>>Đang xử lí</option>
                                                <option disabled value="1" <%   %>>Hoàn thành</option>
                                            </select>
                                            <!-- tôi không biết để select box kiểu disabled từng lựa chọn thế kia được không, không dc thì dùng label box ở dưới nhé -->
                                            <!-- <label for="order-status" class="col-form-label">Trạng
                                                thái:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                id="order-status">Đang xử lí</label> -->
                                            <br><br>
                                            <label for="order-note" class="col-form-label">Ghi chú:</label>
                                            <textarea class="border border-secondary w-100 p-2 rounded" readonly
                                                id="order-note" style="resize: none; overflow: auto;"></textarea>
                                        </div>
                                    </div>
                                    <div class="row justify-content-around">
                                        <div class="col-4"></div>
                                        <div class="col-4">
                                            <div class="form-group">
                                                <label for="cus-pay" style="float: right;" class="col-form-label">Tổng
                                                    tiền khách phải trả (VNĐ):</label>
                                                <input type="number" style="text-align: right;font-size: 36px;" readonly
                                                    class="form-control bg-white border-0" id="cus-pay" />
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
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../js/sb-admin-2.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="../js/include-html.min.js"></script>
    <script>
        var deposit = document.getElementById('order-deposit'),
            total = document.getElementById('order-price'),
            payment = document.getElementById('cus-pay');
        const num = 0;
        payment.value = total.value - deposit.value;
//        deposit.onchange = function () {
//            if (deposit.value == "") {
//                var result = parseFloat(total.value) - parseFloat(num);
//                payment.value = result;
//            } else {
//                var result = parseFloat(total.value) - parseFloat(deposit.value);
//                payment.value = !isNaN(result) ? result : '';
//            }
//        };
    </script>
</body>

</html>