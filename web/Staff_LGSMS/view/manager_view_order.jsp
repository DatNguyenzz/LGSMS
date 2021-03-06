<%@page import="Utility.FormatNumber"%>
<%@page import="Model.Orders"%>
<%@page import="java.util.ArrayList"%>
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
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/slider_status.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/icon_action.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    </head>
    <%
        ArrayList<Orders> listOrder = (ArrayList<Orders>) request.getAttribute("listOrder");
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
                    <!-- End of Topbar -->
                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-white">Theo d??i ????n h??ng</h1>
                        </div>
                        <!-- Page Heading -->
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Danh s??ch ????n h??ng</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>M?? ????n h??ng</th>
                                                <th>Ng??y t???o ????n</th>
                                                <th>Ng??y ghi nh???n</th>
                                                <th>T???ng ti???n</th>
                                                <th>Tr???ng th??i ????n h??ng</th>
                                                <th>Thao t??c</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for(Orders order : listOrder){%>
                                            <tr>
                                                <td><%=order.getOrderCode()%></td>
                                                <td><%=order.getCreatedAt()%></td>
                                                <td><%=order.getUpdatedAt()%></td>
                                                <td><%=formatNumber.formatDoubleToVND(order.getTotalPrice())%></td>
                                                <td>
                                                    <%switch (order.getOrderStatus()) {
                                                        case 0: {%>
                                                    <p id="status_pending">??ang x??? l??</p>    
                                                    <%break;
                                                        }
                                                        case 1: {%>
                                                    <p id="status_pending">???? nh???n ????n</p>
                                                    <%break;
                                                        }
                                                        case 2: {%>
                                                    <p id="status_pending">??ang v???n chuy???n</p>
                                                    <%break;
                                                        }
                                                        case 3: {%>
                                                    <p id="status_complete">Ho??n th??nh</p>
                                                    <%break;
                                                        }
                                                        case 4: {%>
                                                    <p id="status_reject">???? h???y</p>
                                                    <%break;
                                                        }
                                                    }%>
                                                </td>
                                                <td>
                                                    <a href="<%=request.getContextPath()%>/ViewDetailOrder?id=<%=order.getOrderID()%>" class="view"><i class="fas fa-eye" data-toggle="tooltip" title="view" title="view"></i></a> 
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
        <script src="Staff_LGSMS/vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="Staff_LGSMS/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="Staff_LGSMS/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="Staff_LGSMS/js/demo/datatables-demo.js"></script>
        <script src="Staff_LGSMS/js/include-html.min.js"></script>
    </body>

</html>