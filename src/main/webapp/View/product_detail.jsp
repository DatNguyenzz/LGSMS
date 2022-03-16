<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Product Detail</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/productdetail.css" rel="stylesheet" />
    <link href="css/view_profile.css" rel="stylesheet" />
    <link href="css/home.css" rel="stylesheet" />
</head>

<body class="img js-fullheight" style="background-image: url(assets/image/bg4.webp); background-attachment: fixed;">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(28, 100, 168, 0.521); border-bottom: 2px solid white;">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="home.jsp">LGSMS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Trang chủ</a></li>
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
                    <a href="Login.jsp">
                        <button class="btn bg-transparent" type="submit" on>
                            <i class="bi-cart-fill me-1"></i>  
                        </button>
                    </a>
                </form>
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                        <a href="Login.jsp">Đăng nhập</a>
                        </button>
                </form>
                <form class="d-flex">
                    <button class="btn bg-transparent" type="submit">
                        <a href="Register.jsp">Đăng ký</a>
                        </button>
                </form>

            </div>
        </div>
    </nav>
    <!-- Product section-->
    <section class="py-5">
        <div class="container" style="border: 2px solid rgb(117, 105, 105);">
            <div class="row gx-4 gx-lg-5 align-items-center">
                <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="" /></div>
                <div class="col-md-6">
                    <div class="small mb-1">Mã sản phẩm: LG12</div>
                    <h1 class="display-5 fw-bolder">Bình Gas petrolimex 12kg van ngang</h1>
                    <div class="fs-5 mb-5">
                        Giá bán:<span class="text-decoration-line-through"> 499.000 VNĐ</span><br> Giá KM:<span> 399.000 VNĐ</span><br> Thương hiệu:<span> Gas Petrolimex</span><br> Tình trạng:<span> Còn hàng</span><br> Bảo hành:<span> Có bảo hiểm bình gas</span><br>                        Mô tả sản phẩm:<span>
                                <p class="lead">-Khí gas hóa lỏng trong bình có trọng lượng là 12kg.</p>
                                <p class="lead">-Sản phẩm khí gas được chiết nạp bằng máy nên có độ chính xác cao.</p>
                                <p class="lead">-Chất lượng khí gas nhập khẩu được kiểm định bởi công ty.</p>
                            </span>
                    </div>
                    <div class="d-flex">
                        <input class="form-control text-center" id="inputQuantity" type="num" value="1" style="border:1px solid black; max-width: 4rem;" />
                        <button class="btn btn-outline-dark flex-shrink-0" type="button" style="color:white; background-color: rgba(190, 190, 190, 0.425);">
                                <i class="bi-cart-fill"></i>
                                Add to cart
                            </button>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Related items section-->
    <section class="py-5" style="border-bottom: 2px solid white; border-top: 2px solid white;">
        <div class="container px-4 px-lg-5 mt-5 ">
            <h2 class="fw-bolder mb-4 ">Sản phẩm tương tự</h2>
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center ">
                <div class="col mb-5 ">
                    <div class="card h-100 ">
                        <!-- Product image-->
                        <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg " alt="... " />
                        <!-- Product details-->
                        <div class="card-body p-4 ">
                            <div class="text-center ">
                                <!-- Product name-->
                                <h5 class="fw-bolder ">Fancy Product</h5>
                                <!-- Product price-->
                                $40.00 - $80.00
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent ">
                            <div class="text-center "><a class="btn btn-outline-dark mt-auto " href="# ">View options</a></div>
                        </div>
                    </div>
                </div>
                <div class="col mb-5 ">
                    <div class="card h-100 ">
                        <!-- Sale badge-->
                        <div class="badge bg-dark text-white position-absolute " style="top: 0.5rem; right: 0.5rem ">Sale</div>
                        <!-- Product image-->
                        <img class="card-img-top " src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg " alt="... " />
                        <!-- Product details-->
                        <div class="card-body p-4 ">
                            <div class="text-center ">
                                <!-- Product name-->
                                <h5 class="fw-bolder ">Special Item</h5>
                                <!-- Product reviews-->
                                <div class="d-flex justify-content-center small text-warning mb-2 ">
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                </div>
                                <!-- Product price-->
                                <span class="text-muted text-decoration-line-through ">$20.00</span> $18.00
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent ">
                            <div class="text-center "><a class="btn btn-outline-dark mt-auto " href="# ">Add to cart</a></div>
                        </div>
                    </div>
                </div>
                <div class="col mb-5 ">
                    <div class="card h-100 ">
                        <!-- Sale badge-->
                        <div class="badge bg-dark text-white position-absolute " style="top: 0.5rem; right: 0.5rem ">Sale</div>
                        <!-- Product image-->
                        <img class="card-img-top " src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg " alt="... " />
                        <!-- Product details-->
                        <div class="card-body p-4 ">
                            <div class="text-center ">
                                <!-- Product name-->
                                <h5 class="fw-bolder ">Sale Item</h5>
                                <!-- Product price-->
                                <span class="text-muted text-decoration-line-through ">$50.00</span> $25.00
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent ">
                            <div class="text-center "><a class="btn btn-outline-dark mt-auto " href="# ">Add to cart</a></div>
                        </div>
                    </div>
                </div>
                <div class="col mb-5 ">
                    <div class="card h-100 ">
                        <!-- Product image-->
                        <img class="card-img-top " src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg " alt="... " />
                        <!-- Product details-->
                        <div class="card-body p-4 ">
                            <div class="text-center ">
                                <!-- Product name-->
                                <h5 class="fw-bolder ">Popular Item</h5>
                                <!-- Product reviews-->
                                <div class="d-flex justify-content-center small text-warning mb-2 ">
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                    <div class="bi-star-fill "></div>
                                </div>
                                <!-- Product price-->
                                $40.00
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent ">
                            <div class="text-center "><a class="btn btn-outline-dark mt-auto " href="# ">Add to cart</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Footer-->
    <!-- Footer -->
    <footer class="text-center text-muted ">
        <!-- Section: Links  -->
        <section class="footer_info " style="padding-top: 1%; ">
            <div class="container text-center text-md-start mt-5 ">
                <!-- Grid row -->
                <div class="row mt-3 ">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4 ">
                        <!-- Content -->
                        <h6 class="text-uppercase fw-bold mb-4 ">
                            <i class="fas fa-gem me-3 "></i>Vanh Sibun Gas
                        </h6>
                        <p>
                            Đại lý phân phối các sản phẩm khí gas hóa lỏng của công ty Petrolimex.
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4 ">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4 ">
                            Sản phẩm
                        </h6>
                        <p>
                            <a href="#! " class="text-reset ">Tất cả sản phẩm</a>
                        </p>
                        <p>
                            <a href="#! " class="text-reset ">Sản phẩm bán chạy</a>
                        </p>
                        <p>
                            <a href="#! " class="text-reset ">Sản phẩm mới</a>
                        </p>
                        <p>
                            <a href="#! " class="text-reset ">Sản phẩm khuyến mại</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4 ">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4 ">
                            Thông tin
                        </h6>
                        <p>
                            <a href="#! " class="text-reset ">Giá gas</a>
                        </p>
                        <p>
                            <a href="#! " class="text-reset ">Cẩm nang</a>
                        </p>
                        <p>
                            <a href="#! " class="text-reset ">Đặt hàng</a>
                        </p>
                        <p>
                            <a href="#! " class="text-reset ">Hỗ trợ</a>
                        </p>
                    </div>
                    <!-- Grid column -->
                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4 ">
                        <!-- Links -->
                        <h6 class="text-uppercase fw-bold mb-4 ">
                            Liên hệ
                        </h6>
                        <p><i class="bi bi-house-door-fill "></i> 412 Ngọc Thụy, Long Biên, Hà Nội</p>
                        <p>
                            <i class="bi bi-envelope "></i> vanhsibungas@petro.com
                        </p>
                        <p><i class="bi bi-telephone "></i> + 01 234 567 88</p>
                        <p><i class="bi bi-briefcase "></i> + 01 234 567 89</p>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js "></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js "></script>
</body>


</html>