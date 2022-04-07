<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        LGSMS-header
    </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- <link href="/css/style.css" rel="stylesheet" type="text/css"> -->
    <link href="Customer_LGSMS/css/header.css" rel="stylesheet" type="text/css">
</head>

<body>
    <input type="checkbox" id="check">
    <nav>
        <div class="icon">LGS <b style="color: red;">M</b>S</div>
        <div class="search_box">
            <form action="Product" method="post">
            <input type="search" name="searchName" placeholder="Nhập từ khóa....">
             <button  type="submit" class="button-search"><i class="fas fa-search"></i></<button>
            
            </form>
        </div>
        <ol>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="Product">Sản phẩm</a></li>
            <li><a href="ShoppingCart"><i class="fas fa-shopping-cart"></i>Giỏ hàng </a></li>
            <li><a href="#">Tài khoản</a></li>
            <li>
                <div class="dropdown">
                    <a href="#" class="dropbtn fas fa-user-alt" onclick="toggleMenu()"></a>
                    <div id="myDropdown" class="dropdown-content">

                        <a href="#">Tài Khoản Của Tôi</a>

                        <a href="#">Đơn Mua</a>

                        <a href="#">Đăng xuất</a>
                    </div>
                </div>
            </li>
        </ol>
        <label for="check" class="bar">
			<span class="fa fa-bars" id="bars"></span>
			<span class="fa fa-times" id="times"></span>
		</label>
    </nav>
    <script src="Customer_LGSMS/js/header.js">
    </script>
</body>

</html>