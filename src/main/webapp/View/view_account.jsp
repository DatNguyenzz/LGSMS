<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">

<head>
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Manage Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="css/view_list_account.css" rel="stylesheet">
    <link href="css/home.css" rel="stylesheet">
    <link href="css/notfication.css" rel="stylesheet">
    <script src="js/view_list_account.js"></script>
</head>

<body style="background-image: url(assets/image/bg4.webp); background-attachment: fixed;">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(28, 100, 168, 0.521); border-bottom: 1px solid white;">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="">LGSMS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse left_menu" id="navbarSupportedContent">
                <!-- Navbar-nav with FORM -->
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                        <i class="bi bi-bell-fill"></i>
                    </button>
                </form>
                <form class="">
                    <button class="btn bg-transparent" type="submit">
                    <li class="nav-item dropdown" style="list-style-type: none;">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-square me-1"></i></a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="list-style: none;">
                            <li><a class="dropdown-item" href="view_profile.jsp">Hồ sơ của tôi</a></li>
                            <li><a class="dropdown-item" href="Login.jsp">Đăng xuất</a></li>
                        </ul>
                    </li>
                    </button>
                </form>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Quản lý <b>tài khoản</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addAccountModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm tài khoản</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
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
                    <c:forEach  items="${listAcc}" var ="account">
                        <tr>
                            <td>${account.account_id}</td>
                            <td>${account.username}</td>
                            <td>${account.email}</td>
                            <td>${account.role.roleName}</td>
                            <td><label class="switch">
								<input type="checkbox" checked>
								<span class="slider round"></span>
							  </label></td>
                            <td>${account.created_at}</td>
                            <td>${account.updated_at}</td>
                            <td>
                                <a href="#editAccountModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            </td>
                        </tr>
                    </c:forEach>
 <%--                        <tr>
                            <td>2</td>
                            <td>minhpq</td>
                            <td>daxua@mail.com</td>
                            <td>Manager</td>
                            <td><label class="switch">
								<input type="checkbox" checked>
								<span class="slider round"></span>
							  </label></td>
                            <td>20-03-2022</td>
                            <td>28-03-2022</td>
                            <td>
                                <a href="#editAccountModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>longnq</td>
                            <td>longblackpink@mail.com</td>
                            <td>Customer</td>
                            <td><label class="switch">
								<input type="checkbox" checked>
								<span class="slider round"></span>
							  </label></td>
                            <td>20-03-2022</td>
                            <td>28-03-2022</td>
                            <td>
                                <a href="#editAccountModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>datnq</td>
                            <td>datnq@mail.com</td>
                            <td>Admin</td>
                            <td><label class="switch">
								<input type="checkbox" checked>
								<span class="slider round"></span>
							  </label></td>
                            <td>20-03-2022</td>
                            <td>28-03-2022</td>
                            <td>
                                <a href="#editAccountModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>Anhtgv</td>
                            <td>sibun2k4@mail.com</td>
                            <td>Business Staff</td>
                            <td><label class="switch">
								<input type="checkbox" checked>
								<span class="slider round"></span>
							  </label></td>
                            <td>20-03-2022</td>
                            <td>28-03-2022</td>
                            <td>
                                <a href="#editAccountModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            </td>
                        </tr> --%> 
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Hiển thị <b>5</b> trong tổng số <b>25</b> tài khoản</div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Trước</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Sau</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="addAccountModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm tài khoản</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Tên đăng nhập*</label>
                            <input type="text" class="form-control" placeholder="nhập tên người dùng..." required>
                        </div>
                        <div class="form-group">
                            <label>Email*</label>
                            <input type="email" class="form-control" placeholder="nhập địa chỉ email..." required>
                        </div>
                        <div class="form-group">
                            <label>Vai trò</label>
                            <select class="form-control" name="roles" id="roles">
                                <option value="volvo">Admin</option>
                                <option value="saab">Manager</option>
                                <option value="opel">Business Staff</option>
                                <option value="audi">Customer</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Thêm mới">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="editAccountModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h4 class="modal-title">Chỉnh sửa tài khoản</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Tên người dùng*</label>
                            <input type="text" class="form-control" placeholder="nhập tên người dùng..." required>
                        </div>
                        <div class="form-group">
                            <label>Email*</label>
                            <input type="email" class="form-control" placeholder="nhập địa chỉ email..." required>
                        </div>
                        <div class="form-group">
                            <label>Vai trò</label>
                            <select class="form-control" name="roles" id="roles">
                                <option value="volvo">Admin</option>
                                <option value="saab">Manager</option>
                                <option value="opel">Business Staff</option>
                                <option value="audi">Customer</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Trạng thái: </label>
                            <label class="switch">
								<input type="checkbox" checked>
								<span class="slider round"></span>
							  </label>

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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>


</html>