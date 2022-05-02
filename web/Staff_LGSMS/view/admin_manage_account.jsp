<%@page import="Model.Role"%>
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
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/slider_status.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/icon_action.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
        
        <link href="Staff_LGSMS/css/alert.css" rel="stylesheet">
    </head>
    <body id="page-top">
        <%
            ArrayList<Account> listAccount = (ArrayList<Account>) request.getAttribute("listAccount");
            ArrayList<Role> listRole = (ArrayList<Role>) request.getAttribute("listRole");
        %>
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
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-white">Quản lý tài khoản</h1>
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
                                            <form id="form" action="<%=request.getContextPath()%>/AddAccount" method="POST">
                                                <div class="col-8 col-sm-12" style="text-align: center ;">
                                                    <img src="assets/image/avatar.jpg" alt="..."
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
                                                                        tên*:</label>
                                                                    <input type="text" class="form-control" id="user-name"
                                                                           name="fullname" maxlength="50"/>
                                                                    <div class="fail"></div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="staff-phone" class="col-form-label">Số điện
                                                                        thoại*:</label>
                                                                    <input type="text" class="form-control"
                                                                           id="staff-phone1" name="phone" maxlength="15"/>
                                                                    <div class="fail"></div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="user-address" class="col-form-label">Địa chỉ*:</label>
                                                                    <input type="text" class="form-control"
                                                                           id="user-address" name="address" maxlength="500"/>
                                                                    <div class="fail"></div>
                                                                </div>
                                                            </div>
                                                            <div class="col-8 col-sm-6">

                                                                <div class="form-group">
                                                                    <label for="staff-email"
                                                                           class="col-form-label">Email*:</label>
                                                                    <input type="email" class="form-control"
                                                                           id="staff-email" name="email" maxlength="80"/>
                                                                    <div class="fail"></div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col">
                                                                        <div class="form-group">
                                                                            <label for="user-dob"
                                                                                   class="col-form-label">Ngày sinh*</label>
                                                                            <input class="form-control" id="user-dob"
                                                                                   name="dob" placeholder="MM/DD/YYYY"
                                                                                   type="date" />
                                                                            <div class="fail"></div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col">
                                                                        <label for="gender" class="col-form-label">Giới tính:</label>
                                                                        <select class="form-control" name="gender" id="gender">
                                                                            <option value="true">Nam</option>
                                                                            <option value="false" >Nữ</option>
                                                                        </select>
                                                                    </div>
                                                                    <br>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="staff-roles" class="col-form-label">Vai trò:</label>
                                                                    <select class="form-control" name="role" id="roles">
                                                                        <%for (Role r : listRole) {%>
                                                                        <option value="<%=r.getRoleID()%>"><%=r.getRoleName()%></option>
                                                                        <%}%>
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
                                                <td>
                                                    <%if (account.isIsActive()) {%> <p id="status_complete">Đang hoạt động</p> 
                                                    <%} else {%><p id="status_reject">Ngừng hoạt động</p>
                                                    <%}%>
                                                </td>
                                                <td><%=account.getCreatedAt()%></td>
                                                <td><%=account.getUpdatedAt()%></td>
                                                <td>
                                                    <a href="#editAccountModal" class="edit"
                                                       onclick="handleClick('<%=account.getAccountID()%>', 
                                                                            '<%=account.getUsername()%>',
                                                                            '<%=account.getFullname()%>', 
                                                                            '<%=account.getEmail()%>',
                                                                            '<%=account.getPhone()%>', 
                                                                            '<%=account.getAddress()%>',
                                                                            '<%=account.getRole().getRoleID()%>', 
                                                                            '<%=account.getDOB()%>',
                                                                            '<%=account.isGender()%>', 
                                                                            '<%=account.getCreatedAt()%>',
                                                                            '<%=account.getUpdatedAt()%>', 
                                                                            '<%=account.isIsActive()%>',
                                                                            '<%=account.getImagePath()%>')"
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
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Chi tiết tài khoản</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <form id="form1" action="<%=request.getContextPath()%>/EditAccount" method="post">
                            <div class="col-8 col-sm-12" style="text-align: center ;">
                                <img src="assets/image/long.png" alt="..."
                                     class="img-thumbnail" id="profileImage"
                                     style="height: 200px; width: 200px; border-radius: 50%;">
                                <div><input type="file" id="user_avatar" accept="image/png, image/jpeg">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="row">
                                        <div class="col-8 col-sm-6">
                                            <div class="form-group" hidden>
                                                <label for="staff-code" class="col-form-label">Mã nhân viên:</label>
                                                <input type="text" class="border border-secondary w-100 rounded label_box" 
                                                       readonly class="form-control-plaintext" name="accountId"
                                                       id="accountIdEditInput">
                                            </div>
                                            <div class="form-group">
                                                <label for="user-name" class="col-form-label">Họ và
                                                    tên*:</label>
                                                <input type="text" class="form-control" id="fullnameEditInput"
                                                       name="fullname" maxlength="50"/>
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="staff-phone" class="col-form-label">Số điện
                                                    thoại*:</label>
                                                <input type="text" class="form-control"
                                                       id="staff-phone" name="phone" maxlength="15"/>
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="user-address" class="col-form-label">Địa chỉ*:
                                                </label>
                                                <input type="text" class="form-control"
                                                       id="addressEditInput" name="address" maxlength="255"/>
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="staff-status" class="col-form-label">Trạng thái:</label>
                                                <select class="form-control" name="staff-status" id="status">
                                                    <option value="true">Hoạt động</option>
                                                    <option value="false">Ngừng hoạt động</option>
                                                </select>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label for="user-dob"
                                                               class="col-form-label">Ngày sinh*</label>
                                                        <input class="form-control" id="dobEditInput"
                                                               name="dob"
                                                               type="date" />
                                                        <div class="fail"></div>
                                                    </div>
                                                </div>

                                                <div class="col">
                                                    <label for="gender" class="col-form-label">Giới tính:</label>
                                                    <select class="form-control" name="gender" id="genderEditInput">
                                                        <option value="true">Nam</option>
                                                        <option value="false">Nữ</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-8 col-sm-6">
                                            <div class="form-group">
                                                <label for="username" class="col-form-label">Tên đăng
                                                    nhập*:</label>
                                                <input type="text" class="form-control" id="usernameEditInput"
                                                       name="username" readonly maxlength="50"/>
                                                <br>
                                            </div>

                                            <div class="form-group">
                                                <label for="staff-email"
                                                       class="col-form-label">Email:</label>
                                                <input type="email" class="form-control"
                                                       id="emailEditInput" name="email" maxlength="50"/>
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="staff-roles" class="col-form-label">Vai trò:</label>
                                                <select class="form-control" name="role" id="roleEditInput">
                                                    <%for (Role r : listRole) {%>
                                                    <option value="<%=r.getRoleID()%>"><%=r.getRoleName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col">
                                                    <label for="product-create" class="col-form-label">Ngày
                                                        tạo:</label>
                                                    <input type="text" class="border border-secondary w-100 rounded label_box"                                                                                                            " 
                                                           readonly class="form-control-plaintext" id="createdAtEditInput"
                                                           >
                                                </div>
                                                <div class="col">
                                                    <label for="product-update" class="col-form-label"
                                                           style="text-align: right;">Ngày cập nhật:</label>
                                                    <input type="text" class="border border-secondary w-100 rounded label_box" 
                                                           readonly class="form-control-plaintext" id="updatedAtEditInput"
                                                           >
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
            const id = document.getElementById("accountIdEditInput");
            const fullname = document.getElementById("fullnameEditInput");
            const staffPhone = document.getElementById("staff-phone");
            const address = document.getElementById("addressEditInput");
            const dob = document.getElementById("dobEditInput");
            const gender = document.getElementById("genderEditInput");
            const username = document.getElementById("usernameEditInput");
            const email = document.getElementById("emailEditInput");
            const roleID = document.getElementById("roleEditInput");
            const createdAt = document.getElementById("createdAtEditInput");
            const updatedAt = document.getElementById("updatedAtEditInput");
            const accountStatus = document.getElementById("status");
            const profileImage = document.getElementById("profileImage");


            const handleClick = (   idInput, 
                                    usernameInput, 
                                    fullnameInput,
                                    emailInput, 
                                    phoneInput, 
                                    addressInput,
                                    roleIdInput, 
                                    dobInput, 
                                    genderInput,
                                    createdAtInput, 
                                    updatedAtInput, 
                                    statusInput,
                                    imageInput) => {
                id.value = idInput;
                fullname.value = fullnameInput;
                username.value = usernameInput;
                email.value = emailInput;
                staffPhone.value = phoneInput;
                address.value = addressInput;
                roleID.value = roleIdInput;
                dob.value = dobInput;
                gender.value = genderInput;
                createdAt.value = createdAtInput;
                updatedAt.value = updatedAtInput;
                accountStatus.value = statusInput;
                profileImage.src = imageInput;
            };
        </script>
        <script src="Staff_LGSMS/vendor/jquery/jquery.min.js"></script>
        <script src="Staff_LGSMS/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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
        <script src="Staff_LGSMS/js/valdation/admin_validate_1.js"></script>
        
        
        <script src="Staff_LGSMS/js/modal_alert.js"></script>
        <% 
            String message = (String) request.getAttribute("message");
            if(message != null){
        %>
        <script>
            ModalWindow.openModal(
                {
                    title: "Confirm",
                    content: "Pôp"
                }
            );
        </script>
        <%}%>
        

    </body>

</html>
