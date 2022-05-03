<%@page import="Model.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Orders"%>
<%@page import="Utility.FormatNumber"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>

        <meta charset="utf-8">
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
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
    </head>
    <%
        Orders order = (Orders) request.getAttribute("orderInfor");
        ArrayList<OrderDetail> listOrderDetail = (ArrayList<OrderDetail>) request.getAttribute("listOrderDetail");
        FormatNumber formatNumber = new FormatNumber();
        String[] listOrderStatus = {"Đang xử lý", "Đã nhận đơn", "Đang vận chuyển", "Hoàn thành", "Đơn bị hủy"};
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
                            <h1 class="h3 mb-0 text-white">Chi tiết đơn hàng</h1>
                        </div>

                        <!-- DataTales Example -->
                        <div class="row" style="width: 100%;">
                            <div class="col-8 col-sm-12">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <span class="m-0 font-weight-bold text-primary">Đơn hàng</span>
                                        <%if(order.getOrderStatus()!=0 && order.getOrderStatus()!=4 ){%>
                                        <a href="ReceiptInfoByOrderID?id=<%=order.getOrderID()%>" class="order-voucher">Xem phiếu thu</a>
                                        <%}%>
                                    </div>
                                    <div class="card-body">
                                        <!-- <div class="table-responsive"> -->
                                        <div class="row" style="padding-bottom: 10px;">
                                            <div class="col-8 col-sm-1"></div>
                                            <div class="col-8 col-sm-5">
                                                <label for="order-code" class="col-form-label">Mã đơn
                                                    hàng:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="order-code"><%=order.getOrderCode()%></label>
                                                <label for="order-price" class="col-form-label">Ngày tạo đơn:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="order-price"><%=order.getCreatedAt()%></label>
                                                <label for="staff-order" class="col-form-label">Nhân viên nhận
                                                    đơn:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="staff-order"><%=request.getAttribute("staffName")%></label>
                                                <label for="order-date" class="col-form-label">Ngày nhận
                                                    đơn:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="order-date"><%=order.getUpdatedAt()%></label>
                                                <label for="cus-note" class="col-form-label">Ghi chú của khách hàng:</label>
                                                <textarea class="border border-secondary w-100 p-2 rounded" readonly
                                                          class="form-control-plaintext" id="order-note"
                                                          style="resize: none; overflow: auto;"><%=order.getOrderNote1()%></textarea>

                                            </div>
                                            <div class="col-8 col-sm-5">
                                                <label for="customer-name" class="col-form-label">Tên khách
                                                    hàng:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="customer-name"><%=order.getCustomerName()%></label>
                                                <label for="order-phone" class="col-form-label">Điện thoại khách
                                                    hàng:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="order-phone"><%=order.getCustomerPhone()%>
                                                </label>
                                                </lable>
                                                <label for="order-address" class="col-form-label">Địa chỉ khách
                                                    hàng:</label>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="order-address"><%=order.getCustomerAddress()%></label>
                                                </lable>
                                                <label for="order-status" class="col-form-label">Trạng
                                                    thái:</label><br>
                                                <label type="text" class="border border-secondary w-100 p-2 rounded"
                                                       id="order-status"><%=listOrderStatus[order.getOrderStatus()]%>
                                                </label>
                                                <label for="order-note" class="col-form-label">Ghi chú của nhân
                                                    viên:</label>
                                                <textarea class="border border-secondary w-100 p-2 rounded" readonly
                                                          id="order-note" style="resize: none; overflow: auto;"><%=order.getOrderNote2()%></textarea>
                                                <div style="margin-top: 3%; float: right; padding:2%">
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Tên sản phẩm</th>
                                                    <th>Giá bán</th>
                                                    <th>Số lượng</th>
                                                    <th style="width: 20%">Thành tiền</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%  double sum = 0; int count = 0;
                                                    %>
                                                    <%for (OrderDetail od : listOrderDetail) {
                                                    count++;%>
                                                    <tr>
                                                        <td><%=count%></td>
                                                        <td><%=od.getProductName()%></td>
                                                        <td><%=formatNumber.formatDoubleToVND(od.getPrice()/od.getProductQuantity())%></td>
                                                        <td><%=od.getProductQuantity()%></td>
                                                        <td><%=formatNumber.formatDoubleToVND(od.getPrice())%></td>
                                                        <%sum+=od.getPrice();%>
                                                    </tr>
                                                    <%}%>
                                                <tfoot>
                                                    <tr>
                                                        <td colSpan="4" style="text-align: right;"><b>Tổng thành tiền:</b></td>
                                                        <td><%=formatNumber.formatDoubleToVND(sum)%></td>
                                                    </tr>
                                                </tfoot>
                                            </tbody>
                                        </table>
                                        <!-- </div> -->
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
    <script src="Staff_LGSMS/js/fnon.min.js"></script>
    <script src="Staff_LGSMS/js/valdation/alert.js"></script>
    <!-- <script>
        $('#dataTable').dataTable({
            "columnDefs": [
                { "width": "20%", "targets": 1 },
                { "width": "20%", "targets": 2 }
            ]
        });
    </script> -->
</body>

</html>