<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="LGSMS.Model.Account"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>LGS - Admin</title>

<!-- Custom fonts for this template -->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../assets/styles/sb-admin-2.min.css" rel="stylesheet">
<link href="../assets/styles/slider_status.css" rel="stylesheet">
<!-- Custom styles for this page -->
<link href="../vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">
	<%
	ArrayList<Account> listAcc = (ArrayList<Account>) request.getAttribute("listAcc");
	%>


	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<div include-html="components/sidebar.html" id="sidebar"
				style="display: contents;"></div>
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
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>
					<!-- Topbar Navbar -->
					<div include-html="components/topnavbar.html" id="topnavbar"
						class="ml-auto"></div>
				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Quản lý tài khoản</h1>
						<button
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
							data-toggle="modal" data-target="#exampleModal"
							data-whatever="@getbootstrap">
							<i class="fas fa-plus fa-sm text-white-50"></i> Thêm tài khoản
						</button>
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered modal-lg"
								role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Thêm tài
											khoản</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form>
											<div class="row" style="width: 100%;">
												<div class="col-sm-12">
													<div class="row">
														<div class="col-8 col-sm-5 text-center">
															<img src="assets/image/img/undraw_posting_photo.svg"
																alt="..." class="img-thumbnail">
															<button type="button" class="btn btn-primary ">Tải
																ảnh</button>
														</div>
														<div class="col-8 col-sm-7">
															<div class="form-group">
																<label for="product-name" class="col-form-label">Tên
																	đăng nhập:</label> <input type="text" class="form-control"
																	id="product-name">
															</div>
															<div class="form-group">
																<label for="product-quantity" class="col-form-label">Email:</label>
																<input type="text" class="form-control"
																	id="product-quantity">
															</div>
															<div class="form-group">
																<label>Vai trò:</label> <select class="form-control"
																	name="roles" id="roles">
																	<option value="admin">Admin</option>
																	<option value="manager">Manager</option>
																	<option value="business">Business Staff</option>
																	<option value="customer">Customer</option>
																</select>
															</div>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-primary">Thêm</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Hủy</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Page Heading -->
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Quản lý tài
								khoản</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>ID</th>
											<th>Họ và tên</th>
											<th>Email</th>
											<th>Vai trò</th>
											<th>Trạng thái</th>
											<th>Ngày tạo</th>
											<th>Ngày chỉnh sửa</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<%
										for (Account acc : listAcc) {
										%>
										<tr>
											<td><%=acc.getAccount_id()%></td>
											<td><%=acc.getFullName()%></td>
											<td><%=acc.getEmail()%></td>
											<td><%=acc.getRole().getRoleName()%></td>
											<td><label class="switch"> <input
													type="checkbox" <%if (acc.isIs_active()) {%> checked
													<%;} else {%> check <%}%>> <span
													class="slider round"></span>
											</label></td>
											<td><%=acc.getCreated_at()%></td>
											<td><%=acc.getUpdated_at()%></td>
											<td><a href="#editAccountModal"
												onclick="handleClick('<%=acc.getFullName()%>','<%=acc.getEmail()%>','<%=acc.getRole().getRoleName()%>','<%=acc.getAccount_id()%>')"
												class="edit editBtn" data-toggle="modal">
												<i class="bi bi-pencil-square" data-toggle="tooltip"
													title="Edit"></i></a></td>

										</tr>
										<%
										}
										%>

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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Edit Modal HTML -->
	<div id="editAccountModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="admin_manage-account.jsp" method="PUT">
					<div class="modal-header">
						<h4 class="modal-title">Chỉnh sửa tài khoản</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">



						<div class="form-group">
							<label>Tên người dùng*</label> <input id="fullName"
								name="fullName" type="text" class="form-control"
								placeholder="nhập tên người dùng..." required>
						</div>
						<div class="form-group">
							<label>Email*</label> <input type="email" name="email" id="email"
								class="form-control" placeholder="nhập địa chỉ email..."
								required>
						</div>
						<div class="form-group">
							<label>Vai trò</label> <select class="form-control" name="roles"
								id="roleId">
								<option value="Admin">Admin</option>
								<option value="Manager">Manager</option>
								<option value="Business Staff">Business Staff</option>
								<option value="Customer">Customer</option>
							</select>
						</div>

						<div class="form-group">
							<input id="accountId"
								name="accountId" type="text" class="form-control" hidden="true">
						</div>
						
					

					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn btn-info"
							value="Lưu">
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
	const roles=document.getElementById("roleId");
	const fullname=document.getElementById("fullName");
	const email=document.getElementById("email");
	const accountid=document.getElementById("accountId");

	
	
    const handleClick=(fullNameInput,emailInput,roleInput,idInput)=>{
    	fullname.value=fullNameInput;
   		roles.value=roleInput;
    	email.value=emailInput;
    	accountid.value=idInput;
    	
    }
    </script>
	<!-- Bootstrap core JavaScript-->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="../vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="../vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="../js/demo/datatables-demo.js"></script>
	<script src="../js/include-html.min.js"></script>
</body>

</html>