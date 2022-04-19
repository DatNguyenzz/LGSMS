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
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
    <link href="Staff_LGSMS/assets/styles/slider_status.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
    <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">

</head>

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
        <div id="content-wrapper" class="d-flex flex-column" class="img js-fullheight" style="background-image: url(Staff_LGSMS/assets/image/fac2.jpg); background-size: cover;">
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
            </div>
        </div>
    </div>
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>


    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="Staff_LGSMS/vendor/jquery/jquery.min.js "></script>
    <script src="Staff_LGSMS/vendor/bootstrap/js/bootstrap.bundle.min.js "></script>



    <!-- Custom scripts for all pages-->
    <script src="Staff_LGSMS/js/sb-admin-2.min.js "></script>

    <!-- Page level plugins -->
    <script src="Staff_LGSMS/vendor/datatables/jquery.dataTables.min.js "></script>
    <script src="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.js "></script>

    <!-- Page level custom scripts -->
    <script src="Staff_LGSMS/js/demo/datatables-demo.js "></script>
    <script src="Staff_LGSMS/js/include-html.min.js "></script>
    <script src="Staff_LGSMS/js/valdation/confirm.js "></script>
    <script src="Staff_LGSMS/js/valdation/admin_validate.js "></script>
    <script src="Staff_LGSMS/js/fnon.min.js "></script>
</body>

</html>