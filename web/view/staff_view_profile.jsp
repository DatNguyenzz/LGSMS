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

        <title>LGS - Admin</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="assets/styles/slider_status.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="css/my_account.css" rel="stylesheet">
        <link href="css/fnon.min.css" rel="stylesheet">
        <link href="assets/styles/custom_box.css" rel="stylesheet">
    </head>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
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
                        <div class="row">

                            <div class="col-md-5">
                                <div class="d-flex flex-column align-items-center">
                                    <img class="rounded-circle mt-5" src="assets/image/avatar.jpg" style="border: 2px solid lightgray;">
                                    <span class="font-weight-bold" style="color: rgb(0, 0, 0);"><%=account.getUsername()%></span>
                                    <span><input type="file" id="user_avatar" accept="image/png, image/jpeg"></span>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-right">Hồ sơ của tôi</h4>
                                    </div>
                                    <form id="form" action="<%=request.getContextPath()%>/MyProfile" method="POST">
                                        <div class="row mt-3">
                                            <div class="form-group">
                                                <label class="col-form-label">Họ và tên:</label>
                                                <input type="text" class="form-control" name="fullname"
                                                       placeholder="<%=account.getFullname()%>" value="<%=account.getFullname()%>" id="user-name" />
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels" class="col-form-label">Số điện thoại*</label>
                                                <input type="text" class="form-control" name="phone"
                                                       placeholder="<%=account.getPhone()%>" value="<%=account.getPhone()%>" id="user-phone">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels">Ngày sinh*</label>
                                                <input type="date" class="form-control" name="dob"
                                                       placeholder="<%=account.getDOB()%>" value="<%=account.getDOB()%>" id="user-dob">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels" for="gender">Giới tính*</label>
                                                <select name="gender" class="form-control">
                                                    <option value="true">Nam</option>
                                                    <option value="false"<%if (!account.isGender()) {%>selected<%}%>>Nữ</option>
                                                </select>
                                            </div>

                                            <br>
                                            <div class="form-group">
                                                <label class="labels">Địa chỉ*</label>
                                                <input type="text" class="form-control" name="address"
                                                       placeholder="nhập địa chỉ của bạn" value="<%=account.getAddress()%>" id="user-address">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels">Email*</label>
                                                <input type="text" class="form-control" name="email"
                                                       placeholder="nhập địa chỉ email của bạn" value="<%=account.getEmail()%>" id="user-email">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="col-form-label"><button class="btn btn-primary profile-button" type="submit">Lưu thông tin</button>

                                            </div>
                                        </div>
                                    </form>
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
        <script src="vendor/jquery/jquery.min.js "></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js "></script>



        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js "></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js "></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js "></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js "></script>
        <script src="js/include-html.min.js "></script>
        <script src="js/fnon.min.js"></script>
        <script src="js/valdation/profile_validation.js"></script>
    </body>

</body>

</html>
