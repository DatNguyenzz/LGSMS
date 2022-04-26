<%-- 
    Document   : account
    Created on : Apr 25, 2022, 12:25:23 AM
    Author     : Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        LGSMS-acoount
    </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">
    <link href="Customer_LGSMS/css/custom_box.css" rel="stylesheet" type="text/css">
    <link href="Customer_LGSMS/css/fnon.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <!--Account-->
    <div class="account-page">
        <div class="container">
            <div class="logo">
                <a href="#"><img src="../images/logoNgang.PNG" width="125px" alt=""></a>
            </div>
            <div class="row">
                <div class="col-2">
                    <img src="../images/account.png" width="100%">
                </div>
                <div class="col-2">
                    <div class="form-container" >
                        <div class="form-btn">
                            <span onclick="login()">Đăng Nhập</span>
                            <span onclick="register()">Đăng Ký</span>
                            <hr id="indicator">
                        </div>
                        <form id="loginForm" style="width: 100%;">
                            <div class="form-group">
                                <input type="text" placeholder="Tên đăng nhập" id="username" maxlength="50">
                                <div class="fail"></div>
                            </div>
                            <div class="form-group">
                                <input type="password" placeholder="Mật khẩu" id="password" maxlength="50">
                                <div class="fail"></div>
                            </div>
                            <button type="submit" class="btn">Đăng Nhập</button>
                            <a href="forgotPassword.jsp">Quên mật khẩu?</a>
                        </form>
                        <form id="registerForm" style="width: 100%;">
                            <div class="form-group">
                                <input type="text" placeholder="Tên đăng nhập" id="refiUsername"  maxlength="50">
                                <div class="fail"></div>
                            </div>
                            <div class="form-group">
                                <input type="email" placeholder="Email" id="regiEmail" maxlength="50">
                                <div class="fail"></div>
                            </div>
                            <button type="submit" class="btn">Đăng Ký</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- footer-->
    <div include-html="footer.html" id="footer"></div>
    <!--js for toggle menu-->
    <!-- <script src="/js/header.js"></script> -->
    <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
    <script src="Customer_LGSMS/js/include-html.min.js"></script>
    <script src="Customer_LGSMS/js/fnon.min.js"></script>
    <script src="Customer_LGSMS/js/validation/login_regi_validation.js"></script>
    <script src="Customer_LGSMS/js/validation/alert.js"></script>
</body>

</html>
