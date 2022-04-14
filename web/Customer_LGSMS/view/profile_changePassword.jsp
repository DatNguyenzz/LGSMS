<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Account"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        LGSMS-Profile
    </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <link href="Customer_LGSMS/css/profile.css" rel="stylesheet" type="text/css">
</head>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
    %>
<body>
    <div class="header">
        <div include-html="Customer_LGSMS/view/header.jsp" id="header">
        </div>
    </div>
    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center">
                        <h4 class="far fa-user"> Tài Khoản Của Tôi</h4>
                    </div>
                    <div class="col-md-12 ml-3"><a href="<%=request.getContextPath()%>/MyProfile" class="d-flex justify-content-between align-items-center">Hồ Sơ</a></div>
                    <div class="col-md-12 ml-3"><a href="<%=request.getContextPath()%>/ChangePassword" class="d-flex justify-content-between align-items-center">Đổi Mật Khẩu</a></div><br>

                </div>
            </div>

            <div class="col-md-5 border-left">
                <div class="p-3 py-5">
                    <form action="<%=request.getContextPath()%>/ChangePassword" method="POST">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Hồ Sơ Của Tôi</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-12">
                            <label class="labels">Mật Khẩu Cũ</label>
                            <input type="password" name="old-password" class="form-control" placeholder="Nhập mật khẩu cũ" value="">
                        </div> 
                        <br>
                        <div class="col-md-12">
                            <label class="labels">Mật Khẩu Mới</label>
                            <input type="password" name="new-password" class="form-control" placeholder="Nhập mật khẩu mới" value="">
                        </div>
                        <br>
                        <div class="col-md-12">
                            <label class="labels">Xác Nhận Mật Khẩu Mới</label>
                            <input type="password" class="form-control" placeholder="Xác nhận mật khẩu mới" value="">
                        </div>
                    </div>
                    <div class="mt-3 float-right text-center">
                        <input class="btn btn-primary profile-button" type="submit" value="Lưu">
                    </div>
                    </form>
                </div>
            </div>
            <div class="col-md-4 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                    <span class="font-weight-bold"><%=account.getUsername()%></span>
                </div>
            </div>
        </div>


        <!-- footer-->
        <!-- <div include-html="footer.html" id="footer"></div> -->
        <!-- footer-->



        <script src="/js/jquery-3.6.0.min.js"></script>
        <script src="/js/include-html.min.js"></script>

</body>

</html>