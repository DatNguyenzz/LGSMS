<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Account"%>
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

        <link href="Customer_LGSMS/css/header.css" rel="stylesheet" type="text/css">
    </head>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
    %>
    <body>
        <input type="checkbox" id="check">
        <nav>
            <div class="icon">LGS <b style="color: red;">M</b>S</div>
            <div class="search_box">
                <form action="<%=request.getContextPath()%>/Product" method="post" id="form">
                    <div class="search_box">
                        <input type="search" name="searchName" placeholder="Nhập từ khóa...." required>
                        <!--<button  type="submit" class="button-search"><i class="fas fa-search"></i></<button>-->
                        <span class="fa fa-search" class="button-search" onclick="submitForm()"></span>
                    </div>
                </form>
            </div>
            <ol>
                <li><a href="<%=request.getContextPath()%>/Home" class="fas fa-home" > Trang chủ</a></li>
                <li><a href="<%=request.getContextPath()%>/Product" class="fas fa-boxes" style="text-decoration: none;"> Sản phẩm</a></li>
                
                    <%if(account == null){%>
                <li><a href="<%=request.getContextPath()%>/login" class="fas fa-user" style="text-decoration: none;"> Đăng nhập</a></li>
                    <%}else{%>
                <li><a href="<%=request.getContextPath()%>/ShoppingCart" class="fas fa-shopping-cart" style="text-decoration: none;">Giỏ hàng </a></li>
                <li>
                    <div class="dropdown">
                        <a href="#" class="dropbtn fas fa-user-alt" onclick="toggleMenu()"></a>
                        <div id="myDropdown" class="dropdown-content">

                            <a href="<%=request.getContextPath()%>/MyProfile" style="text-decoration: none;">Tài Khoản Của Tôi</a>

                            <a href="<%=request.getContextPath()%>/TrackOrder" style="text-decoration: none;">Đơn mua</a>
                            <hr>
                            <a href="<%=request.getContextPath()%>/logout" style="text-decoration: none;">Đăng xuất</a>
                        </div>
                    </div>
                </li>
                <%}%>
            </ol>
            <label for="check" class="bar">
                <span class="fa fa-bars" id="bars"></span>
                <span class="fa fa-times" id="times"></span>
            </label>
        </nav>
        <script src="Customer_LGSMS/js/header.js">
        </script>
        <script>
            function submitForm()
            {
                document.getElementById("form").submit();
            }
        </script>
    </body>
</html>