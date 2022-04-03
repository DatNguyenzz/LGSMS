<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <title>header</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="assets/styles/header.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://code.jquery.com/jquery-3.3.1.slim.min.js">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />


</head>

<body>
    <!-- Navbar-->
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a href="#" class="navbar-brand "><img class="logo-image-header" src="assets/image/logophuoc-02.PNG"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
            <div id="navbarSupportedContent" class="collapse navbar-collapse">
                <div class="col">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a href="#" class="nav-link text-uppercase ">Trang chủ <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a href="#" class="nav-link text-uppercase ">Sản phẩm</a></li>
                        <li class="nav-item"><a href="#" class="nav-link text-uppercase ">Liên hệ</a></li>

                    </ul>
                </div>
                <form class="d-flex " action="CustomerProduct" method="post">
                    <input class="form-control mr-sm-2" type="text" name="searchName" placeholder="Nhập từ khóa...">
                    <button class="btn btn-search nav-link nav-right" type="submit"><i class="bi bi-search me-1"></i></button>
                </form>
                <div class="d-flex ">
                    <a href="Login.html"><i class="bi-cart-fill me-1  nav-link"></i></a>

                </div>
                <div class="d-flex ">
                    <a class="nav-link text-uppercase" href="Login.html">Đăng nhập</a>
                </div>

                <div class="d-flex">
                    <a class="nav-link text-uppercase" href="Register.html">Đăng ký</a>
                </div>
                <form class="">
                    <button class="btn  bg-transparent" type="submit">
                    <li class="nav-item dropdown" style="list-style-type: none;">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-square me-1"></i></a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="list-style: none;">
                            <li><a class="dropdown-item" href="view_profile.html">Hồ sơ của tôi</a></li>
                            <li><a class="dropdown-item" href="#!">Theo dõi đơn hàng</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="Login.html">Đăng xuất</a></li>
                        </ul>
                    </li>
                    </button>
                </form>
            </div>
        </div>
    </nav>

</body>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
    <!-- <script src="../js/include-html.min.js"></script> -->
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script> -->
<!-- Core theme JS-->
<script src="js/header.js"></script>

</html>