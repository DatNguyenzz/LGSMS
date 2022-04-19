<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

</head>

<body>

    <!--Account-->
    <div class="account-page">
        <div class="container">
            <div class="logo">
                <a href="#"><img src="Customer_LGSMS/images/logoNgang.PNG" width="125px" alt=""></a>
            </div>
            <div class="row">
                <div class="col-2">
                    <img src="Customer_LGSMS/images/account.png" width="100%">
                </div>
                <div class="col-2">
                    <div class="form-container-forgot">
                        <div class="form-btn">
                            <span>Đặt Lại Mật Khẩu</span>
                            <hr id="indicator-forgot">
                        </div>
                        <form action="<%=request.getContextPath()%>/ForgotPassword" method="post">
                            <input type="email" name="email" placeholder="Nhập địa chỉ email của bạn">
                            <button type="submit"  class="btn">Gửi Email</button>
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

</body>

</html>