<%@page import="Model.Orders"%>
<%@page import="Model.ReceiptVoucher"%>
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
        LGSMS-Order-detail
    </title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <link href="Customer_LGSMS/css/order_detail.css" rel="stylesheet" type="text/css">
    <link href="Customer_LGSMS/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
    
    <%
    Orders order =(Orders)request.getAttribute("order");
    ArrayList<OrderDetail> listOrderDetail = (ArrayList<OrderDetail>)request.getAttribute("listOrderDetail");
    ReceiptVoucher receiptVoucher=  (ReceiptVoucher)request.getAttribute("receiptVoucher");
    FormatNumber formatNumber = new FormatNumber();
    %>
    <div class="header">
        <div include-html="Customer_LGSMS/view/header.jsp" id="header"></div>
    </div>
    <div class="container mt-4">
        <!-- DataTales Example -->
        <div class="row">
            <div class="col-8 col-sm-12">
                <div class="card mb-4">
                    <div class="card-header py-3">
                        <h5>Thông tin đơn hàng
                            <label type="text" class="float-right" id="order-code">Mã đơn
                            hàng: <%=order.getOrderCode()%> <span> | </span> 
                            <span class="order-status">
                                <%switch(order.getOrderStatus()){
                                case 0:{%> Đang xử lý <% break;}
                                case 1:{%> Đã xác nhận <%break;}
                                case 2:{%> Đang vận chuyển <%break;}
                                case 3:{%> Đã giao <%break;}
                                case 4:{%> Đã hủy <%break;}}%></span>
                            </label>
                        </h5>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-8 col-sm-5 ml-3 border-right">
                                <label type="text" class="w-100 " id="customer-name">Họ tên: <%=order.getCustomerName()%></label>
                                <label type="text" class="w-100 " id="order-phone">Điện thoại: <%=order.getCustomerPhone()%></label>
                                <label type="text" class="w-100 " id="order-address">Địa chỉ: <%=order.getCustomerAddress()%></label>
                                <label type="text" class="w-100 " id="order-note">Ghi chú: <span><%=order.getOrderNote1()%></span></label>
                            </div>
                            <div class="col-8 col-sm-5 ml-3">
                            </div>

                            <div class="table-responsive mt-4">
                                <table class="table table-bordered" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th width="8%">#</th>
                                            <th width="10%"></th>
                                            <th width="20%">Tên sản phẩm</th>
                                            <th width="8%">Số lượng</th>
                                            <th width="10%">Giá </th>
                                            <th width="10%">Thành tiền</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            int count = 0;
                                            for(OrderDetail od : listOrderDetail ){
                                                count++;
                                        %>
                                        <tr>
                                            <td><%=count%></td>
                                            <td><img src="<%=od.getProductImagePath()%>" width="70" height="70"></td>
                                            <td><%=od.getProductName()%></td>
                                            <td><%=od.getProductQuantity()%></td>
                                            <td><%=formatNumber.formatDoubleToString(od.getPrice() / od.getProductQuantity())%></td>
                                            <td><%=formatNumber.formatDoubleToString(od.getPrice())%></td>
                                            
                                        </tr>
                                        <%}%>
                                        
                                        <tfoot>
                                            <tr>
                                                <td colSpan="5" style="text-align: right;">Tổng tiền hàng</td>
                                                <td><%=formatNumber.formatDoubleToString(order.getTotalPrice())%></td>
                                            </tr>
                                            <%if(receiptVoucher!=null){%>
                                            <tr>
                                                <td colSpan="5" style="text-align: right;">Chiết khấu</td>
                                                <td><%=formatNumber.formatDoubleToString(receiptVoucher.getDeposit())%></td>
                                            </tr>
                                            <tr>
                                                <td colSpan="5" style="text-align: right;">Tổng số tiền</td>
                                                <td><%=formatNumber.formatDoubleToVND(receiptVoucher.getTotalMoney())%></td>
                                            </tr>
                                            <%}%>
                                        </tfoot>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <a href="<%=request.getContextPath()%>/TrackOrder" class="fa fa-chevron-left">Trở lại</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div include-html="Customer_LGSMS/view/footer.jsp" id="footer"></div>
    <!-- footer-->

    <!-- footer-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
    <script src="Customer_LGSMS/js/include-html.min.js"></script>
    <script src="Customer_LGSMS/js/jquery.min.js"></script>


</body>

</html>