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
	<link href="assets/styles/custom_box.css" rel="stylesheet">
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
                                        <form id="form" action="" onsubmit="confirmFunction()">
                                            <div class="col-8 col-sm-12" style="text-align: center ;">
                                                <img src="../assets/image/avatar.jpg" alt="..."
                                                    class="img-thumbnail"
                                                    style="height: 200px; width: 200px; border-radius: 50%;">
                                                <div><input type="file" id="user_avatar" accept="image/png, image/jpeg">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <div class="row">
                                                        <div class="col-8 col-sm-6">
                                                            <div class="form-group">
                                                                <label for="user-name" class="col-form-label">Họ và
                                                                    tên:</label>
                                                                <input type="text" class="form-control" id="user-name"
                                                                    required
                                                                    oninvalid="this.setCustomValidity('Xin hãy nhập tên nhân viên.')"
                                                                    oninput="this.setCustomValidity('')" />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="staff-phone" class="col-form-label">Số điện
                                                                    thoại:</label>
                                                                <input type="text" class="form-control"
                                                                    id="staff-phone" oninvalid="InvalidPhone(this);"
                                                                    name="phone" oninput="InvalidPhone(this);"
                                                                    required="required" />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="user-address" class="col-form-label">Họ và
                                                                    tên:</label>
                                                                <input type="text" class="form-control"
                                                                    id="user-address" required
                                                                    oninvalid="this.setCustomValidity('Xin hãy nhập địa chỉ nhân viên.')"
                                                                    oninput="this.setCustomValidity('')" />
                                                            </div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label for="user-dob"
                                                                            class="col-form-label">Ngày sinh</label>
                                                                        <input class="form-control" id="user-dob"
                                                                            name="date" placeholder="MM/DD/YYYY"
                                                                            type="date" required
                                                                            oninvalid="this.setCustomValidity('Xin hãy nhập ngày sinh của nhân viên.')"
                                                                            oninput="this.setCustomValidity('')" />
                                                                    </div>
                                                                </div>
                                                                <div class="col">
                                                                    <label for="gender" class="col-form-label">Giới tính:</label>
                                                                    <select class="form-control" name="gender" id="gender">
                                                                        <option value="male">Nam</option>
                                                                        <option value="female">Nữ</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-8 col-sm-6">
                                                            <div class="form-group">
                                                                <label for="username" class="col-form-label">Tên đăng
                                                                    nhập:</label>
                                                                <input type="text" class="form-control" id="username"
                                                                    required
                                                                    oninvalid="this.setCustomValidity('Xin hãy nhập tên tài khoản của bạn.')"
                                                                    oninput="this.setCustomValidity('')" />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="user-password" class="col-form-label">Mật khẩu:</label>
                                                                <input type="text" class="form-control" id="user-password"
                                                                    required
                                                                    oninvalid="this.setCustomValidity('Xin hãy nhập mật khẩu cho nhân viên.')"
                                                                    oninput="this.setCustomValidity('')" />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="staff-email"
                                                                    class="col-form-label">Email:</label>
                                                                <input type="email" class="form-control"
                                                                    id="staff-email" oninvalid="InvalidMsg(this);"
                                                                    name="email" oninput="InvalidMsg(this);"
                                                                    type="email" required="required" />
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="staff-roles" class="col-form-label">Vai trò:</label>
                                                                <select class="form-control" name="roles" id="roles">
                                                                    <option value="admin">Admin</option>
                                                                    <option value="manager">Manager</option>
                                                                    <option value="business">Business Staff</option>
                                                                    <option value="customer">Customer</option>
                                                                </select>
                                                            </div>
                                                        </div>  
                                                    </div>
                                                    <div class="modal-footer">
                                                        <input type="submit" class="btn btn-primary"
                                                            value="Thêm"></button>
                                                        <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Hủy</button>
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
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Chi tiết tài khoản</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="form" action="" onsubmit="confirmFunction()">
                        <div class="col-8 col-sm-12" style="text-align: center ;">
                            <img src="../assets/image/long.png" alt="..."
                                class="img-thumbnail"
                                style="height: 200px; width: 200px; border-radius: 50%;">
                            <div><input type="file" id="user_avatar" accept="image/png, image/jpeg">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-8 col-sm-6">
                                        <div class="form-group">
                                        <label for="staff-code" class="col-form-label">Mã nhân viên:</label>
                                                <label type="text" class="border border-secondary w-100 rounded label_box" 
                                                    readonly class="form-control-plaintext"
                                                    id="staff-code">AC01</label>
                                                </div>
                                        <div class="form-group">
                                            <label for="user-name" class="col-form-label">Họ và
                                                tên:</label>
                                            <input type="text" class="form-control" id="user-name" value="Phạm Quang Minh"
                                                required
                                                oninvalid="this.setCustomValidity('Xin hãy nhập tên nhân viên.')"
                                                oninput="this.setCustomValidity('')" />
                                        </div>
                                        <div class="form-group">
                                            <label for="staff-phone" class="col-form-label">Số điện
                                                thoại:</label>
                                            <input type="text" class="form-control" value="0916362047"
                                                id="staff-phone" oninvalid="InvalidPhone(this);"
                                                name="phone" oninput="InvalidPhone(this);"
                                                required="required" />
                                        </div>
                                        <div class="form-group">
                                            <label for="user-address" class="col-form-label">Địa chỉ:
                                                </label>
                                            <input type="text" class="form-control" value="118 Tây Hồ, Hoàn Kiếm, Hà Nội"
                                                id="user-address" required
                                                oninvalid="this.setCustomValidity('Xin hãy nhập địa chỉ nhân viên.')"
                                                oninput="this.setCustomValidity('')" />
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="user-dob"
                                                        class="col-form-label">Ngày sinh</label>
                                                    <input class="form-control" id="user-dob"
                                                        name="date" placeholder="MM/DD/YYYY" value="2000-10-14"
                                                        type="date" required
                                                        oninvalid="this.setCustomValidity('Xin hãy nhập ngày sinh của nhân viên.')"
                                                        oninput="this.setCustomValidity('')" />
                                                </div>
                                            </div>
                                            <div class="col">
                                                <label for="gender" class="col-form-label">Giới tính:</label>
                                                <select class="form-control" name="gender" id="gender">
                                                    <option value="male">Nam</option>
                                                    <option value="female">Nữ</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-8 col-sm-6">
                                        <div class="form-group">
                                            <label for="username" class="col-form-label">Tên đăng
                                                nhập:</label>
                                            <input type="text" class="form-control" id="username" value="minhpqdaxua"
                                                required
                                                oninvalid="this.setCustomValidity('Xin hãy nhập tên tài khoản của bạn.')"
                                                oninput="this.setCustomValidity('')" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="staff-email"
                                                class="col-form-label">Email:</label>
                                            <input type="email" class="form-control" value="minhpq@daxua"
                                                id="staff-email" oninvalid="InvalidMsg(this);"
                                                name="email" oninput="InvalidMsg(this);"
                                                type="email" required="required" />
                                        </div>
                                        <div class="form-group">
                                            <label for="user-password" class="col-form-label">Mật khẩu:</label><br>
                                            <button type="button" class="btn btn-primary" style="width: 100%;"
                                            onclick="confirmChangePass()">Gửi mật khẩu mặc định</button>
                                        </div>
                                        <div class="form-group">
                                            <label for="staff-roles" class="col-form-label">Vai trò:</label>
                                            <select class="form-control" name="roles" id="roles">
                                                <option value="admin">Admin</option>
                                                <option value="manager">Manager</option>
                                                <option value="business">Business Staff</option>
                                                <option value="customer">Customer</option>
                                            </select>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <label for="product-create" class="col-form-label">Ngày
                                                    tạo:</label>
                                                <label type="text" class="border border-secondary w-100 rounded label_box"                                                                                                            " 
                                                readonly class="form-control-plaintext" id="product-create"
                                                    >11/03/2022</label>
                                            </div>
                                            <div class="col">
                                                <label for="product-update" class="col-form-label"
                                                    style="text-align: right;">Ngày cập nhật:</label>
                                                <label type="text" class="border border-secondary w-100 rounded label_box" 
                                                readonly class="form-control-plaintext" id="product-update"
                                                    >15/03/2022</label>
                                            </div>
                                        </div>
                                    </div>  
                                </div>
                                <div class="modal-footer">
                                    <input type="submit" class="btn btn-primary"
                                        value="Lưu"></button>
                                    <button type="button" class="btn btn-secondary"
                                        data-dismiss="modal">Hủy</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
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
	<script src="js/confirm.js"></script>
    	<script src="js/staff_validate.js"></script>
    </body>

</html>