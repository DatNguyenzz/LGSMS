<%@page import="Model.Account"%>
<%@page import="Model.ShoppingCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Utility.FormatNumber"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        LGSMS-CheckOut
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
     <%
        Account account = (Account) request.getSession().getAttribute("account");
        FormatNumber formatNumber = new FormatNumber();
        ArrayList<ShoppingCart> listCart = (ArrayList<ShoppingCart>) request.getAttribute("listCart");
    %>
    <div class="header">
        <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
    </div>
    <!--Check CheckOut-->
    <div class="small-container row-checkout">
        <div class="col-75">
            <div class="container-checkout">
                <form action="<%=request.getContextPath()%>/CheckOut" method="POST" id="form">
                    <div class="row-checkout">
                        <div class="col-50">
                            <div class="form-group">
                                <label for="fname"><i class="fa fa-user"></i> Tên*</label>
                                <input type="text" id="fname" name="name" placeholder="<%=(account.getFullname()!=null)?account.getFullname():""%>"  
                                       value="<%=(account.getFullname()!=null)?account.getFullname():""%>"  maxlength="50">
                                <div class="fail"></div>
                            </div>
                            <div class="form-group">
                                <label for="phone"><i class="fa fa-phone"></i> Điện thoại*</label>
                                <input type="text" id="phone" name="phone" 
                                       placeholder="<%=(account.getPhone()!=null)?account.getPhone():""%>" 
                                       value="<%=(account.getPhone()!=null)?account.getPhone():""%>"  maxlength="15">
                                <div class="fail"></div>
                            </div>
                            <div class="form-group">
                                <label for="adr"><i class="fa fa-address-card"></i> Địa chỉ*</label>
                                <input type="text" id="adr" name="address" 
                                       placeholder="<%=(account.getAddress()!=null)?account.getAddress():""%>" 
                                       value="<%=(account.getAddress()!=null)?account.getAddress():""%>"  maxlength="500">
                                <div class="fail"></div>
                            </div>
                            <div class="form-group">
                                <label for="note"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Ghi
                                    chú<small>(tùy chọn)</small></label>
                                <input type="text" id="note" name="note" placeholder=""  maxlength="500">
                            </div>
                            <p class="checkout_note">Quý khách hàng lưu ý phần <strong>"Tiền cọc vỏ"</strong> và
                                <strong>"Tổng tiền"</strong> sẽ được cập nhật sau khi nhân viên cửa hàng liên hệ để xác
                                nhận thông tin đơn hàng.</p>
                            </div>
                    </div>
                    <input type="submit" value="Đặt hàng" class="btnCheckOut">
                </form>
            </div>
        </div>
        <div class="col-25">
           
            <div class="container-checkout">
                <h4>Giỏ hàng <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b><%=listCart.size()%></b></span></h4>
                <% 
                    double sum = 0;
                    for (ShoppingCart cart : listCart) {
                        sum += cart.getProduct().getProductPrice() * cart.getProductQuantity();
                %>
                <p>
                    <a href="<%=request.getContextPath()%>/CustomerProductInformation?productID=<%=cart.getProductID()%>">
                        <%=cart.getProduct().getProductName()%> x <%=cart.getProductQuantity()%> 
                    </a>
                    <span class="price"><%=formatNumber.formatDoubleToString(cart.getProduct().getProductPrice())%></span>
                </p>
                <hr>
                <%  }   %>
               
                <p>Tổng tạm tính <span class="price" style="color:black"><b><%=formatNumber.formatDoubleToVND(sum)%></b></span></p>
            </div>
            
        </div>
            
    </div>

    <!-- footer-->
    <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
    <!--js for toggle menu-->
    <!-- <script src="/js/header.js"></script> -->
    <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
    <script src="Customer_LGSMS/js/include-html.min.js"></script>
    <script src="Customer_LGSMS/js/fnon.min.js"></script>
    <script src="Customer_LGSMS/js/validation/checkout_validation.js"></script>
    <script src="Customer_LGSMS/js/validation/alert.js"></script>


</body>

</html>