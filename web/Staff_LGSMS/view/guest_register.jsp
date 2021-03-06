<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="vi">

    <head>
        <title>Register</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="Staff_LGSMS/css/lgin_reg_fgpw.css">

        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
    </head>
    <% String emailMessage = (String) request.getAttribute("emailMessage");
        String userNameMessage = (String) request.getAttribute("userNameMessage");
        String sucessfulMessage= (String) request.getAttribute("sucessfulMessage");
    %>
    <body class="img js-fullHeight" style="background-image: url(Staff_LGSMS/assets/image/bg4.webp);background-attachment: fixed;">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center">
                        <a href="<%=request.getContextPath()%>/Home">
                            <img src="Staff_LGSMS/assets/image/logophuoc-01.PNG" width="200" height="230" style="padding-bottom: 5%;">
                        </a>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4" style="background-color: rgba(28, 100, 168, 0.521); border: 5px solid rgb(117, 105, 105);">
                        <div class="login-wrap p-0">
                            <h3 class="mb-4 text-center">Đăng Ký</h3>
                            <form id="form" action="Register" method="post">
                                <!-- Nhập account -->
                                <div class="form-group">
                                    <input  id="account" name="username" type="text" class="form-control" placeholder="Tên tài khoản">

                                    <% if (userNameMessage != null) {%>
                                    <div class="fail"  style="color:#ff3860;" > &emsp; <%=request.getAttribute("userNameMessage")%> </div>
                                    <%}%>
                                    <div class="fail">
                                </div>
                                <!-- Nhập email -->
                                <div class="form-group">
                                    <input  id="email" name="email" type="text" class="form-control" placeholder="Tài khoản email">
                                    <% if (emailMessage != null) {%>
                                    <div class="fail"  style="color:#ff3860;" >  &emsp;  <%=request.getAttribute("emailMessage")%> </div>
                                    <%}%>
                                    <div class="fail">
                                    
                                </div>
                                <div class="form-group">
                                  <% if(sucessfulMessage != null){%>
                                    <div class="success"  style="color:white;" >  &emsp;  <%=request.getAttribute("sucessfulMessage")%> </div>
                                    <%}%>
                                </div>
                                    
                                <!-- Đăng nhập btn -->
                                <div class="form-group">
                                    
                                    <input type="submit" class="form-control btn btn-primary submit px-3" value="Đăng ký"></input>
                                    
                                </div>
                            </form>
                            <!-- URL tạo tài khoản -->
                            <div class="w-100 text-center">
                                <p>Bạn đã có tài khoản? <a href="login" style="color: #fff; text-decoration: underline;"><b>Đăng nhập ngay!</b></a>
                                </p>
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
        <script src="Staff_LGSMS/js/valdation/alert.js"></script>
        <script src="Staff_LGSMS/js/valdation/register_validate.js"></script>


</html>