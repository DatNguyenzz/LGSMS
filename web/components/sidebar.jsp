<%@page import="Model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Title-->
        <title>sidebar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Custom fonts for this template-->
        <link src="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
        <!-- Custom styles for this template-->
        <link src="assets/styles/sb-admin-2.min.css" rel="stylesheet" type="text/css">

    </head>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
    %>
    <body id="page-top">
        <!-- Sidebar -->
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="home_staff.html">
            <div class="sidebar-brand-icon">
                <i class="iconify" data-icon="ic:twotone-gas-meter" style="color: white;" data-width="50" data-height="50"></i>
            </div>
            <div class="sidebar-brand-text mx-3">LGSMS</div>
        </a>
        <!-- Divider -->
        <hr class="sidebar-divider my-0">
        <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
            <i class="fas fa-fw fa-cog"></i>
            <span>Thống kê</span></a>
            <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="<%=request.getContextPath()%>/ManageReport">Doanh thu và lợi nhuận</a>
                <a class="collapse-item" href="<%=request.getContextPath()%>/ManageReportProduct">Hàng nhập</a>
                <a class="collapse-item" href="<%=request.getContextPath()%>/ManageReportOrder">Đơn hàng hoàn thành</a>
                
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Chức năng
    </div>

    <%if (account.getRole().getRoleID() == 1) {%>
    <!-- Nav Item - Admin Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseAuthor" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Tài khoản</span>
        </a>
        <div id="collapseAuthor" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="<%=request.getContextPath()%>/ManageAccount">Quản lý tài khoản</a>
            </div>
        </div>
    </li>
    <%}%>

    <%if (account.getRole().getRoleID() == 2) {%>
    <!-- Heading -->
    <!-- Nav Item - Manager -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseWarehouse" aria-expanded="true" aria-controls="collapse1">
            <i class="fas fa-fw fa-boxes"></i>
            <span>Sản phẩm</span></a>
    </a>
    <div id="collapseWarehouse" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageProduct">Quản lý sản phẩm</a>
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageProvider">Quản lý nhà cung cấp</a>
        </div>
    </div>
</li>
    <!-- Nav Item - Manager view Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
            <i class="bi bi-calendar-check-fill"></i>
            <span>Đơn hàng</span>
        </a>
        <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="manager_view_order.jsp">Danh sách đơn hàng</a>
            </div>
        </div>
    </li>
    <!-- Nav Item - Manager view Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
            <i class="bi bi-calendar-check-fill"></i>
            <span>Phiếu thu</span>
        </a>
        <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="Manager_view_voucher.html">Danh sách phiếu thu</a>
            </div>
        </div>
    </li>
    <!-- Nav Item - Manager order import Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" aria-controls="collapseSix">
            <i class="bi bi-calendar-check-fill"></i>
            <span>Phiếu nhập hàng</span>
        </a>
        <div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="">Danh sách phiếu nhập</a>
            </div>
        </div>
    </li>
<%}%>
<%if (account.getRole().getRoleID() == 3) {%>
<!-- Nav Item - Business Staff Menu -->
<li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
        <i class="bi bi-calendar-check-fill"></i>
        <span>Đơn hàng</span>
    </a>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageNewOrder">Danh sách đơn hàng mới</a>
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageAcceptOrder">Danh sách đơn chấp nhận</a>
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageCancelOrder">Danh sách đơn từ chối</a>
        </div>
    </div>
</li>
<!-- Nav Item - Business Staff Menu -->
<li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
        <i class="fas fa-fw fa-warehouse"></i>
        <span>Kho</span>
    </a>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionSidebar">
        <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageImport">Danh sách hàng nhập</a>
            <a class="collapse-item" href="<%=request.getContextPath()%>/ManageReceiptVoucher">Danh sách phiếu thu</a>
        </div>
    </div>
</li>
<%}%>
<!-- Divider -->
<hr class="sidebar-divider d-none d-md-block">
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/jquery-3.6.0.min.js"></script>

</body>

</html>