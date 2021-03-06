<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="Staff_LGSMS/css/lgin_reg_fgpw.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
</head>
 <% String failMessage = (String) request.getAttribute("failMessage");
      
    %>
<body class="img js-fullHeight" style="background-image: url(Staff_LGSMS/assets/image/bg4.webp); background-attachment: fixed;">
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <a href="<%=request.getContextPath()%>/Home">
                        <span class="iconify" data-icon="ic:twotone-gas-meter" style="color: white;" data-width="80" data-height="80"></span>
                        <h2 class="heading-section">LGSMS</h2>
                    </a>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4" style="background-color: rgba(28, 100, 168, 0.521); border: 5px solid rgb(117, 105, 105);">
                    <div class="login-wrap p-0">
                        <h3 class="mb-4 text-center">Đăng Nhập</h3>
                        <!-- Form đăng nhập -->
                        <form id="form" action="login" method="post">
                            <!-- Nhập username -->
                            <div class="input-control">
                                <input id="username" name="username" type="text" class="form-control" placeholder="Tên tài khoản" required oninvalid="this.setCustomValidity('Xin hãy nhập tên tài khoản của bạn.')" oninput="this.setCustomValidity('')" />
                                <div class="error"></div>
                            </div>
                            <!-- Nhập mật khẩu -->
                            <div class="input-control">
                                <input id="password" name="password" type="password" class="form-control" placeholder="Mật khẩu" required oninvalid="this.setCustomValidity('Xin hãy nhập mật khẩu của bạn.')" oninput="this.setCustomValidity('')" />
                                <div class="error"></div>
                            </div>
                            <!-- thông báo Đăng nhập fail -->
                            <div class="form-group">
                                  <% if(failMessage != null){%>
                                    <div class="fail"  style="color:#ff3860;" >  &emsp;  <%=request.getAttribute("failMessage")%> </div>
                                    <%}%>
                                </div>
                            <!-- Đăng nhập btn -->
                            <div class="form-group">
                                <input type="submit" class="form-control btn btn-primary submit px-3" value="Đăng nhập"></input>
                            </div>
                            <div class="form-group w-100 text-center">
                                <a href="<%=request.getContextPath()%>/ForgotPassword" style="color: #fff; text-decoration: underline;">Quên mật khẩu?</a>
                            </div>
                            
                        </form>
                        <!-- URL tạo tài khoản -->
                        <div class="w-100 text-center">
                            <p>Bạn chưa có tài khoản? <a href="<%=request.getContextPath()%>/Register" style="color: #fff; text-decoration: underline;"><b>Đăng ký
								ngay!</b></a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="Staff_LGSMS/js/jquery.min.js"></script>
    <script src="Staff_LGSMS/js/popper.js"></script>
    <script src="Staff_LGSMS/js/bootstrap.min.js"></script>
    <script src="Staff_LGSMS/js/main.js"></script>
</body>