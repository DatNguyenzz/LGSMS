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
        <link href="Staff_LGSMS/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/slider_status.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/my_account_1.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
    </head>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
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
                        <div class="row" style="background-color: rgba(28, 100, 168, 0.521); border: 1px solid rgb(117, 105, 105); color: #f2f2f2">
                            <form id="form" action="<%=request.getContextPath()%>/MyProfile" method="POST" enctype="multipart/form-data">
                            <div class="col-md-5" >
                                <div class="d-flex flex-column align-items-center">
                                    <img class="rounded-circle mt-5" src="<%=account.getImagePath()%>" style="border: 2px solid lightgray;">
                                    <span class="font-weight-bold" style="color: rgb(255, 255, 255);"><%=account.getUsername()%></span>
                                    <span><input type="file" id="user_avatar" accept="image/png, image/jpeg" form="form" name="image"></span>
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-right">Hồ sơ của tôi</h4>
                                    </div>
                                    
                                        <div class="row mt-3">
                                            <div class="form-group">
                                                <label class="col-form-label">Họ và tên*:</label>
                                                <input type="text" class="form-control" name="fullname"
                                                       placeholder="<%=account.getFullname()%>" value="<%=account.getFullname()%>" id="user-name" maxlength="50"/>
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels" class="col-form-label">Số điện thoại*</label>
                                                <input type="number" class="form-control" name="phone"
                                                       placeholder="<%=account.getPhone()%>" value="<%=account.getPhone()%>" id="user-phone" maxlength="15">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels">Ngày sinh*</label>
                                                <input type="date" class="form-control" name="dob"
                                                       placeholder="<%=account.getDOB()%>" value="<%=account.getDOB()%>" id="user-dob">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels" for="gender">Giới tính</label>
                                                <select name="gender" class="form-control">
                                                    <option value="true">Nam</option>
                                                    <option value="false"<%if (!account.isGender()) {%>selected<%}%>>Nữ</option>
                                                </select>
                                            </div>

                                            <br><br><br><br>
                                            <div class="form-group">
                                                <label class="labels">Địa chỉ*</label>
                                                <input type="text" class="form-control" name="address"
                                                       placeholder="nhập địa chỉ của bạn" value="<%=account.getAddress()%>" id="user-address" maxlength="500">
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="labels">Email*</label>
                                                <input type="text" class="form-control" name="email"
                                                       placeholder="nhập địa chỉ email của bạn" value="<%=account.getEmail()%>" id="user-email" maxlength="80">
                                                <div class="fail"></div>
                                            </div>

                                        </div>
                                        <div style="display: flex; justify-content: flex-end">

                                            <input class="btn btn-primary profile-button" type="submit"
                                                   value="Lưu thông tin" form="form">



                                            
                                            
                                        </div>
                                </div>
                            </div>
                            </form>
                                                <input class="btn btn-primary profile-button" style="margin-left: 5%;"
                                                   type="button"data-toggle="modal" data-target="#changePassModal" value="Đổi mật khẩu">
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- End of Main Content -->
            </div>
            <!-- End of Content Wrapper -->
            <div class="modal fade" id="changePassModal" tabindex="-1" role="dialog"
                 aria-labelledby="changePassLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Đổi mật khẩu</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="<%=request.getContextPath()%>/ChangePassword" method="POST" id="form1">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="row">
                                            <div class="col-8 col-sm-12 ">
                                                <input type="text" class="form-control"
                                                       id="accid" name="accid" hidden="true" value="<%=account.getAccountID()%>" />

                                                <div class="form-group">
                                                    <label for="old-password">Mật khẩu cũ:</label>
                                                    <input type="text" id="old-password"
                                                           name="old-password" class="form-control" maxlength="25"/>
                                                    <div class="fail"></div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="new-password" class="col-form-label">Mật khẩu mới:</label>
                                                    <input type="text" class="form-control"
                                                           id="new-password" name="new-password" maxlength="25"/>
                                                    <div class="fail"></div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="re-password" class="col-form-label">Xác nhận mật khẩu mới:</label>
                                                    <input type="text" class="form-control"
                                                           id="re-password" name="re-password" maxlength="25"/>
                                                    <div class="fail"></div>

                                                </div>
                                                <br>
                                                <!-- <br> -->
                                                <div class="modal-footer">
                                                    <input type="submit" class="btn btn-primary"
                                                           value="Nhập"form="form1">
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
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>



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
        <script src="Staff_LGSMS/js/fnon.min.js"></script>
        <script src="Staff_LGSMS/js/valdation/alert.js"></script>
        <script src="Staff_LGSMS/js/valdation/profile_validation_1.js"></script>
    </body>

</body>

</html>
