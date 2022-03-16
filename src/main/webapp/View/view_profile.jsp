<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>View Profile</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/view_profile.css" rel="stylesheet" />
    <link href="css/home.css" rel="stylesheet" />
</head>

<body class="img js-fullHeight" style="background-image: url(assets/image/bg4.webp); background-attachment: fixed;">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(28, 100, 168, 0.521); border-bottom: 1px solid white;">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="">LGSMS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.jsp">Trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="#!">Liên hệ</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Cửa hàng</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#!">Tất cả sản phẩm</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="#!">Sản phẩm bán chạy</a></li>
                            <li><a class="dropdown-item" href="#!">Sản phẩm mới</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- Navbar-nav with FORM -->
                <form class="d-flex" action="/somepage">
                    <input class="form-control mr-sm-2" type="text" placeholder="Nhập từ khóa...">
                    <button class="btn btn-search" type="submit"><i class="bi bi-search me-1"></i></button>
                </form>
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                    <i class="bi-cart-fill "></i>         
                    </button>
                    </a>
                </form>
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                    <i class="bi bi-bell-fill"></i>
                    </button>
                </form>
                <form class="">
                    <button class="btn  bg-transparent" type="submit">
                    <li class="nav-item dropdown" style="list-style-type: none;">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-square me-1"></i></a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="list-style: none;">
                            <li><a class="dropdown-item" href="view_profile.jsp">Hồ sơ của tôi</a></li>
                            <li><a class="dropdown-item" href="#!">Theo dõi đơn hàng</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="Login.jsp">Đăng xuất</a></li>
                        </ul>
                    </li>
                    </button>
                </form>
            </div>
        </div>
    </nav>
    <div class="container_profile" style="background-color: rgb(255, 255, 255);">
        <div class="row">
            <div class="col-md-3 profile_frame">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle mt-5" width="150px" src="assets/image/long.png" style="border: 2px solid black;">
                    <span class="font-weight-bold" style="color: rgb(0, 0, 0);">Nguyễn Quốc Long</span>
                </div>
            </div>
            <div class="col-md-5">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Hồ sơ của tôi</h4>
                    </div>
                    <div class="row mt-3">
                        <p>Quản lý thông tin để bảo mật tài khoản</p>
                        <div class="col-md-12"><label class="labels">Họ và tên*</label><input type="text" class="form-control" placeholder="Nguyen Van A" value=""></div>
                        <div class="col-md-12"><label class="labels">Số điện thoại*</label><input type="text" class="form-control" placeholder="098******9" value=""></div>
                        <div class="col-md-12"><label class="labels">Ngày sinh*</label><input type="date" class="form-control" placeholder="" value=""></div>
                        <div class="col-md-12"><label class="labels" for="gender">Giới tính*</label>
                            <select name="gender" class="form-control">
	                            <option value="male">Nam</option>
	                            <option value="female">Nữ</option>
	                            <option value="other">Khác...</option>
                            </select>
                        </div>
                        <div class="col-md-12"><label class="labels">Địa chỉ*</label><input type="text" class="form-control" placeholder="nhập địa chỉ của bạn" value=""></div>
                        <div class="col-md-12"><label class="labels">Email*</label><input type="text" class="form-control" placeholder="nhập địa chỉ email của bạn" value=""></div>
                        <div class="col-md-12 "><button class="btn btn-primary profile-button" type="submit" onclick="confirmFunction()">Lưu thông tin</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <footer class="text-center text-muted">
        <!-- Section: Links  -->
        <section class="footer_info" style="padding-top: 1%;">
            <div class="container text-center text-md-start mt-5">
                <!-- Grid row -->
                <div class="row mt-3">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            <i class="fas fa-gem me-3"></i>LGSMS
                        </h6>
                        <p>
                            Đại lý phân phối các sản phẩm khí gas hóa lỏng của công ty Petrolimex.
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4 ">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Sản phẩm
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Tất cả sản phẩm</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Sản phẩm bán chạy</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Sản phẩm mới</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Sản phẩm khuyến mại</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Thông tin
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Giá gas</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Cẩm nang</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Đặt hàng</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Hỗ trợ</a>
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4" style="color: rgb(255, 255, 255);">
                            Liên hệ
                        </h6>
                        <p style="color: rgb(255, 255, 255);"><i class="bi bi-house-door-fill"></i> 412 Ngọc Thụy, Long Biên, Hà Nội</p>
                        <p style="color: rgb(255, 255, 255);">
                            <i class="bi bi-envelope"></i> vanhsibungas@petro.com
                        </p>
                        <p style="color: rgb(255, 255, 255);"><i class="bi bi-telephone"></i> + 01 234 567 88</p>
                        <p><i class="bi bi-briefcase"></i> + 01 234 567 89</p>
                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
        </section>
        <!-- Section: Links  -->
    </footer>
    <!-- Footer -->
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <script src="js/main.js"></script>
    <script>
        function confirmFunction() {
            if (confirm("Bạn có chắc chắn với những thông tin này?")) {
                location.reload();
                alert("Lưu thành công!");
            } else {
                location.reload();
            }
        }
    </script>
</body><body class="img js-fullHeight" style="background-image: url(assets/image/bg4.webp); background-attachment: fixed;">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(28, 100, 168, 0.521); border-bottom: 1px solid white;">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="">LGSMS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.jsp">Trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="#!">Liên hệ</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Cửa hàng</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#!">Tất cả sản phẩm</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="#!">Sản phẩm bán chạy</a></li>
                            <li><a class="dropdown-item" href="#!">Sản phẩm mới</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- Navbar-nav with FORM -->
                <form class="d-flex" action="/somepage">
                    <input class="form-control mr-sm-2" type="text" placeholder="Nhập từ khóa...">
                    <button class="btn btn-search" type="submit"><i class="bi bi-search me-1"></i></button>
                </form>
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                    <i class="bi-cart-fill "></i>         
                    </button>
                    </a>
                </form>
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                    <i class="bi bi-bell-fill"></i>
                    </button>
                </form>
                <form class="">
                    <button class="btn  bg-transparent" type="submit">
                    <li class="nav-item dropdown" style="list-style-type: none;">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-square me-1"></i></a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="list-style: none;">
                            <li><a class="dropdown-item" href="view_profile.jsp">Hồ sơ của tôi</a></li>
                            <li><a class="dropdown-item" href="#!">Theo dõi đơn hàng</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="Login.jsp">Đăng xuất</a></li>
                        </ul>
                    </li>
                    </button>
                </form>
            </div>
        </div>
    </nav>
    <div class="container_profile" style="background-color: rgb(255, 255, 255);">
        <div class="row">
            <div class="col-md-3 profile_frame">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle mt-5" width="150px" src="assets/image/long.png" style="border: 2px solid black;">
                    <span class="font-weight-bold" style="color: rgb(0, 0, 0);">Nguyễn Quốc Long</span>
                </div>
            </div>
            <div class="col-md-5">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Hồ sơ của tôi</h4>
                    </div>
                    <div class="row mt-3">
                        <p>Quản lý thông tin để bảo mật tài khoản</p>
                        <div class="col-md-12"><label class="labels">Họ và tên*</label><input type="text" class="form-control" placeholder="Nguyen Van A" value=""></div>
                        <div class="col-md-12"><label class="labels">Số điện thoại*</label><input type="text" class="form-control" placeholder="098******9" value=""></div>
                        <div class="col-md-12"><label class="labels">Ngày sinh*</label><input type="date" class="form-control" placeholder="" value=""></div>
                        <div class="col-md-12"><label class="labels" for="gender">Giới tính*</label>
                            <select name="gender" class="form-control">
	                            <option value="male">Nam</option>
	                            <option value="female">Nữ</option>
	                            <option value="other">Khác...</option>
                            </select>
                        </div>
                        <div class="col-md-12"><label class="labels">Địa chỉ*</label><input type="text" class="form-control" placeholder="nhập địa chỉ của bạn" value=""></div>
                        <div class="col-md-12"><label class="labels">Email*</label><input type="text" class="form-control" placeholder="nhập địa chỉ email của bạn" value=""></div>
                        <div class="col-md-12 "><button class="btn btn-primary profile-button" type="submit" onclick="confirmFunction()">Lưu thông tin</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <footer class="text-center text-muted">
        <!-- Section: Links  -->
        <section class="footer_info" style="padding-top: 1%;">
            <div class="container text-center text-md-start mt-5">
                <!-- Grid row -->
                <div class="row mt-3">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            <i class="fas fa-gem me-3"></i>LGSMS
                        </h6>
                        <p>
                            Đại lý phân phối các sản phẩm khí gas hóa lỏng của công ty Petrolimex.
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4 ">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Sản phẩm
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Tất cả sản phẩm</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Sản phẩm bán chạy</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Sản phẩm mới</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Sản phẩm khuyến mại</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4">
                            Thông tin
                        </h6>
                        <p>
                            <a href="#!" class="text-reset">Giá gas</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Cẩm nang</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Đặt hàng</a>
                        </p>
                        <p>
                            <a href="#!" class="text-reset">Hỗ trợ</a>
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4" style="color: rgb(255, 255, 255);">
                            Liên hệ
                        </h6>
                        <p style="color: rgb(255, 255, 255);"><i class="bi bi-house-door-fill"></i> 412 Ngọc Thụy, Long Biên, Hà Nội</p>
                        <p style="color: rgb(255, 255, 255);">
                            <i class="bi bi-envelope"></i> vanhsibungas@petro.com
                        </p>
                        <p style="color: rgb(255, 255, 255);"><i class="bi bi-telephone"></i> + 01 234 567 88</p>
                        <p><i class="bi bi-briefcase"></i> + 01 234 567 89</p>
                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
        </section>
        <!-- Section: Links  -->
    </footer>
    <!-- Footer -->
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <script src="js/main.js"></script>
    <script>
        function confirmFunction() {
            if (confirm("Bạn có chắc chắn với những thông tin này?")) {
                location.reload();
                alert("Lưu thành công!");
            } else {
                location.reload();
            }
        }
    </script>
</body>
</html>