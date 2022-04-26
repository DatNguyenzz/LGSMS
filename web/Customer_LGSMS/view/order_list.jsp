<%@page import="Model.Orders"%>
<%@page import="Model.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Utility.FormatNumber"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-Order-List
        </title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
        <!-- <link href="/css/style.css" rel="stylesheet" type="text/css"> -->
        <link href="Customer_LGSMS/css/order.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <%
            ArrayList<Orders> listOrder = (ArrayList<Orders>)request.getAttribute("listOrder");
            FormatNumber  formatNumber = new FormatNumber();
        %>
        <div class="header">
            <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
        </div>
        <!-- cart item detail-->
        <section id="project">
            <!-- Heading -->
            <div class="project-heading">
                <h3>ĐƠN HÀNG CỦA BẠN</h3>
            </div>
            <!-- filter -->
            <ul class="project-filter">
                <li class="list project-filter-active" data-filter="all">Tất cả</li>
                <li class="list" data-filter="pending">Chờ xác nhận</li>
                <li class="list" data-filter="confirmed">Đã xác nhận</li>
                <li class="list" data-filter="shipping">Đang vận chuyển</li>
                <li class="list" data-filter="completed">Đã giao</li>
                <li class="list" data-filter="canceled">Đã hủy</li>
            </ul>
            <% if(listOrder.size() == 0){
                
            }else{
                for(Orders order : listOrder){%>
            <!-- container -->
            <div class="project-container">
                <a href="<%=request.getContextPath()%>/OrderDetail?orderID=<%=order.getOrderID()%>" class="project-box 
                   <%switch(order.getOrderStatus()){
                        case 0:{%> pending <% break;}
                        case 1:{%> confirmed <%break;}
                        case 2:{%> shipping <%break;}
                        case 3:{%> completed <%break;}
                        case 4:{%> canceled <%break;}}%>">

                    <div class="grid-container">
                        <div class="item1">
                            <h3>Mã Đơn Hàng: <%=order.getOrderCode()%> <span>|</span> <%switch(order.getOrderStatus()){
                        case 0:{%> Đang xử lý <% break;}
                        case 1:{%> Đã xác nhận <%break;}
                        case 2:{%> Đang vận chuyển <%break;}
                        case 3:{%> Đã giao <%break;}
                        case 4:{%> Đã hủy <%break;}}%></h3>
                        </div>

                        <div class="item2">
                            <img src="Customer_LGSMS/images/buy-1.jpg" alt="work">
                        </div>
                        <div class="item3">
                            <h3>Sản phẩm: <%=order.getOrderDetail().get(0).getProductName()%></h3>
                            <p>Số lượng: <%=order.getOrderDetail().get(0).getProductQuantity()%></p>
                        </div>
                        <div class="item4">
                            <p><%=formatNumber.formatDoubleToVND(order.getOrderDetail().get(0).getPrice())%></p>
                        </div>

                        <div class="item5">
                            <p>Tổng số tiền: <span><%=formatNumber.formatDoubleToVND(order.getTotalPrice())%></span></p>
                        </div>

                    </div>

                </a>
            </div>
            <%}}%>
        </section>

        <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
        <!-- footer-->

        <!-- footer-->

        <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
        <script src="Customer_LGSMS/js/include-html.min.js"></script>
        <script src="Customer_LGSMS/js/order_list.js"></script>

        <script src="Customer_LGSMS/js/jquery.min.js"></script>


    </body>

</html>