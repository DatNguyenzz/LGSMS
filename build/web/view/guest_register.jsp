<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="vi">

<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/lgin_reg_fgpw.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
</head>

<body class="img js-fullHeight" style="background-image: url(/assets/image/bg4.webp);background-attachment: fixed;">
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <a href="home.html">
                        <span class="iconify" data-icon="ic:twotone-gas-meter" style="color: white;" data-width="80" data-height="80"></span>
                        <h2 class="heading-section">LGSMS</h2>
                    </a>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4" style="background-color: rgba(28, 100, 168, 0.521); border: 5px solid rgb(117, 105, 105);">
                    <div class="login-wrap p-0">
                        <h3 class="mb-4 text-center">Đăng Ký</h3>
                        <form id="form" action="view_profile.html">
                            <!-- Nhập account -->
                            <div class="input-control">
                                <input id="account" name="account" type="text" class="form-control" placeholder="Tên tài khoản">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập email -->
                            <div class="input-control">
                                <input id="email" name="email" type="text" class="form-control" placeholder="Tài khoản email">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập mật khẩu -->
                            <div class="input-control">
                                <input id="password" name="password" type="password" class="form-control" placeholder="Mật khẩu">
                                <i class="fa fa-eye field-icon" id="togglePassword" style="margin-top: 7%;"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Xác nhận mật khẩu -->
                            <div class="input-control">
                                <input id="re_password" name="re_password" type="password" class="form-control" placeholder="Xác nhận mật khẩu">
                                <i class="fa fa-eye field-icon" id="re_togglePassword" style="margin-top: 29%"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Đăng nhập btn -->
                            <div class="form-group">
                                <input type="submit" class="form-control btn btn-primary submit px-3" value="Đăng ký"></input>
                            </div>
                        </form>
                        <!-- URL tạo tài khoản -->
                        <div class="w-100 text-center">
                            <p>Bạn đã có tài khoản? <a href="customer_login.html" style="color: #fff; text-decoration: underline;"><b>Đăng nhập ngay!</b></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
    <script src="../js/register_validate.js"></script>


</html>