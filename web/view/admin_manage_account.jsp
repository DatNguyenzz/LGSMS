<%@page import="Model.Account"%>
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

        <title>LGS - Admin</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="assets/styles/slider_status.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <%
            ArrayList<Account> listAccount = (ArrayList<Account>) request.getAttribute("listAccount");
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
                        <div include-html="components/topnavbar.html" id="topnavbar" class="ml-auto"></div>
                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Quản lý tài khoản</h1>
                            <!-- Add account -->
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap"><i class="fas fa-plus fa-sm text-white-50"></i> Thêm tài khoản</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thêm tài khoản</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form id="form" action="">
                                                <div class="row" style="width: 100%;">
                                                    <div class="col-sm-12">
                                                        <div class="row">
                                                            <div class="col-8 col-sm-5 text-center">
                                                                <img src="assets/image/img/undraw_posting_photo.svg" alt="..." class="img-thumbnail">
                                                                <button type="button" class="btn btn-primary ">Tải ảnh</button>
                                                            </div>
                                                            <div class="col-8 col-sm-7">
                                                                <div class="form-group">
                                                                    <label for="product-name" class="col-form-label">Tên đăng nhập:</label>
                                                                    <input type="text" class="form-control" id="product-name">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-quantity" class="col-form-label">Email:</label>
                                                                    <input type="text" class="form-control" id="product-quantity">
                                                                </div>
                                                                <div class="form-group">
                                                                    <label>Vai trò:</label>
                                                                    <select class="form-control" name="roles" id="roles">
                                                                        <option value="admin">Admin</option>
                                                                        <option value="manager">Manager</option>
                                                                        <option value="business">Business Staff</option>
                                                                        <option value="customer">Customer</option>
                                                                    </select>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <input type="submit" class="btn btn-primary" value="Thêm"></button>
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
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
                                <h6 class="m-0 font-weight-bold text-primary">Danh sách tài khoản</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Tên đăng nhập</th>
                                                <th>Email</th>
                                                <th>Vai trò</th>
                                                <th>Trạng thái</th>
                                                <th>Ngày tạo</th>
                                                <th>Ngày chỉnh sửa</th>
                                                <th>Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Account account : listAccount) {%>
                                            <tr>
                                                <td><%=account.getAccountID()%></td>
                                                <td><%=account.getUsername()%></td>
                                                <td><%=account.getEmail()%></td>
                                                <td><%=account.getRole().getRoleName()%></td>
                                                <td><label class="switch">
                                                        <input type="checkbox" <%if (account.isIsActive()) {%>checked<%}%>>
                                                        <span class="slider round"></span>
                                                    </label>
                                                </td>
                                                <td><%=account.getCreatedAt()%></td>
                                                <td><%=account.getUpdatedAt()%></td>
                                                <td>
                                                    <a href="#editAccountModal" class="edit"
                                                       onclick="handleClick('<%=account.getUsername()%>', '<%=account.getEmail()%>', '<%=account.getRole().getRoleID()%>', '<%=account.getAccountID()%>')"
                                                       data-toggle="modal"><i class="bi bi-pencil-square" data-toggle="tooltip" title="Edit"></i></a>
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

        <!-- Edit Modal HTML -->
        <div id="editAccountModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="POST" action="ManageAccount">
                        <div class="modal-header">
                            <h4 class="modal-title">Chỉnh sửa tài khoản</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Tên người dùng*</label>
                                <input id="userName" name="userName" type="text" class="form-control" placeholder="nhập tên người dùng..." required>
                            </div>
                            <div class="form-group">
                                <label>Email*</label>
                                <input name="email" id="email" type="email" class="form-control" placeholder="nhập địa chỉ email..." required>
                            </div>
                            <div class="form-group">
                                <label>Vai trò</label>
                                <select class="form-control" name="roles" id="roles">
                                    <option value="1">Admin</option>
                                    <option value="2">Manager</option>
                                    <option value="3">Business Staff</option>

                                </select>
                            </div>

                            <div class="form-group">
                                <input id="accountId" name="accountId" type="text" class="form-control" hidden="true">
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Lưu">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->

        <script type="text/javascript">

            const roles = document.getElementById("roles");
            const userName = document.getElementById("userName");
            const email = document.getElementById("email");
            const accountid = document.getElementById("accountId");


            const handleClick = (userNameInput, emailInput, roleInput, idInput) => {
                userName.value = userNameInput;
                email.value = emailInput;
                roles.value = roleInput;
                accountid.value = idInput;

            }
        </script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/include-html.min.js"></script>
    </body>

</html>