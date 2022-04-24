<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        LGSMS-Home
    </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">

</head>

<body>
    <!-- footer-->
    <div class="footer ">
        <div class="container">
            <div class="row">
                <div class="footer-col-1 ">
                    <img src="Customer_LGSMS/images/logoDoc.PNG " alt=" ">
                </div>
                <div class="footer-col-2 ">
                    <h3>Sản phẩm</h3>
                    <ul>
                        <li> <a href="<%=request.getContextPath()%>/Product" class=" ">Tất cả sản phẩm</a></li>
                        <li> <a href="<%=request.getContextPath()%>/Product" class=" ">Sản phẩm bán chạy</a></li>
                        <li> <a href="<%=request.getContextPath()%>/Product" class=" ">Sản phẩm mới</a></li>


                    </ul>
                </div>
                <div class="footer-col-3 ">
                    <h3>Liên hệ</h3>
                    <ul>
                        <li>
                            <p class="fa fa-home "> 412 Ngọc Thụy, Long Biên, Hà Nội</p>
                        </li>
                        <li>
                            <p class="fa fa-envelope "> vanhsibungas@petro.com</p>
                        </li>
                        <li>
                            <p class="fa fa-phone-square  "> +01 234 567 88</p>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <hr>
        <div class="copyright">@copyright</div>
    </div>
</body>

</html>