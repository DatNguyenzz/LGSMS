<%@page import="Model.ShoppingCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-Cart
        </title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="header">
            <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
        </div>


        <%
                    ArrayList<ShoppingCart> listCart = (ArrayList<ShoppingCart>) request.getAttribute("listCart");
                    double totalMoney = 0;
                    DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        %>

        <!-- cart item detail-->
        <div class="small-container cart-page">
            <h2>GIỎ HÀNG CỦA BẠN</h2>

            <table>
                <tr>
                    <th>Sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                </tr>

                <%if(listCart.isEmpty()){%>
                <tr>

                    <td colspan="3">

                        <h3><%=request.getAttribute("nonCart")%> </h3>

                    </td> 
                </tr>    

                <%}else{%>

                <%for (ShoppingCart cart : listCart) {
                    totalMoney += (double) cart.getProduct().getProductPrice() * cart.getProductQuantity();%>
                <tr>

                    <td>
                        <div class="cart-info">
                            <img src="Customer_LGSMS/images/buy-1.jpg">
                            <div class="">
                                <p><%=cart.getProduct().getProductName()%> </p>
                                <small> <%=cart.getProduct().getProductPrice()%></small><br>
                                <a href="RemoveProduct?idCart=<%=cart.getCartID()%>">Xóa</a>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div class="quantity buttons_added">
                            <button class="minus" > <a href="EditQuantity?num=-1&id=<%=cart.getCartID()%>" >-</a></button>
                            <input type="number" step="1" min="1" max="" value="<%=cart.getProductQuantity()%>" name="quantity"  >


                            <button class="plus"><a href="EditQuantity?num=1&id=<%=cart.getCartID()%>">+</a></button> 
                        </div>
                    </td>
                    <td><%=cart.getProduct().getProductPrice() * cart.getProductQuantity()%></td>

                </tr>
                <%}}%>
            </table>
            <div class="total-price">
                <table>
                    <tr>
                        <%String money = formatter.format(totalMoney);%>
                        <td>Tổng tiền sản phẩm: <%=money%> VND</td>
                    </tr>

                    <tr>

                        <td> <button class="button-cart"<%if(listCart.isEmpty()){%>disabled<%}%>>
                                <a href="<%=request.getContextPath()%>/CheckOut" style="color: #fff"> Mua Hàng </a>
                            </button></td>
                    </tr>
                </table>
            </div>



        </div>


    </div>
    <!-- footer-->
    <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
    <!-- footer-->



    <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
    <script src="Customer_LGSMS/js/include-html.min.js"></script>
    <script src="Customer_LGSMS/js/cart.js"></script>

</body>

</html>