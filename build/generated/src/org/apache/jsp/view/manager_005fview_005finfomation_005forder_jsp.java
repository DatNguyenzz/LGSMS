package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.OrderDetail;
import java.util.ArrayList;
import Model.Orders;

public final class manager_005fview_005finfomation_005forder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>LGS - Admin</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom fonts for this template -->\r\n");
      out.write("    <link href=\"../vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"../assets/styles/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"../css/view_list_account.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Custom styles for this page -->\r\n");
      out.write("    <link href=\"../vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"../assets/styles/custom_box.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    ");

            Orders order= (Orders)request.getAttribute("orderInfor");
    
        ArrayList<OrderDetail> listOrderDetail = (ArrayList<OrderDetail>)request.getAttribute("listOrderDetail");
        
        ArrayList<Orders> listNewOrder = (ArrayList<Orders>)request.getAttribute("listNewOrder");
    
      out.write("\r\n");
      out.write("    <!-- Page Wrapper -->\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("        <!-- Sidebar -->\r\n");
      out.write("        <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\r\n");
      out.write("            <div include-html=\"components/sidebar.jsp\" id=\"sidebar\" style=\"display: contents;\"></div>\r\n");
      out.write("            <div class=\"text-center d-none d-md-inline\">\r\n");
      out.write("                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <!-- End of Sidebar -->\r\n");
      out.write("        <!-- Content Wrapper -->\r\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\" class=\"img js-fullheight\" style=\"background-image: url(assets/image/fac2.jpg); background-size: cover;\">\r\n");
      out.write("            <!-- Main Content -->\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("                <!-- Topbar -->\r\n");
      out.write("                <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\r\n");
      out.write("                    <!-- Sidebar Toggle (Topbar) -->\r\n");
      out.write("                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\r\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Topbar Navbar -->\r\n");
      out.write("                    <div include-html=\"components/topnavbar.jsp\" id=\"topnavbar\" class=\"ml-auto\"></div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <!-- End of Topbar -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Begin Page Content -->\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Page Heading -->\r\n");
      out.write("                    <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\r\n");
      out.write("                        <h1 class=\"h3 mb-0 text-white\">Chi tiết đơn hàng</h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- DataTales Example -->\r\n");
      out.write("                    <div class=\"row\" style=\"width: 100%;\">\r\n");
      out.write("                        <div class=\"col-8 col-sm-12\">\r\n");
      out.write("                            <div class=\"card shadow mb-4\">\r\n");
      out.write("                                <div class=\"card-header py-3\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    <!--Tôi giữ nguyên class với\r\n");
      out.write("                                    link đúng id với nhau nhé -->\r\n");
      out.write("                                    <span class=\"m-0 font-weight-bold text-primary\">Đơn hàng</span>\r\n");
      out.write("                                    <a href=\"manager_view_information_voucher.jsp\"<td>\r\n");
      out.write("                                                <a href=\"manager_view_information_order.jsp\" class=\"view\"><i class=\"fas fa-eye\" data-toggle=\"tooltip\" title=\"view\"></i></a>\r\n");
      out.write("                                            </td>\" class=\"order-voucher\">Chuyển phiếu thu</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <div class=\"table-responsive\">\r\n");
      out.write("\r\n");
      out.write("                                        <table  class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("                                            <div class=\"row\" style=\"border: 2px solid lightgray;\">\r\n");
      out.write("                                                <div class=\"col-8 col-sm-1\"></div>\r\n");
      out.write("                                                <div class=\"col-8 col-sm-5\">\r\n");
      out.write("                                                    <label for=\"order-code\" class=\"col-form-label\">Mã đơn\r\n");
      out.write("                                                        hàng:</label>\r\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-code\" >");
      out.print(order.getOrderCode());
      out.write("</label>\r\n");
      out.write("                                                    <label for=\"order-price\" class=\"col-form-label\">Tổng giá\r\n");
      out.write("                                                        tiền:</label>\r\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-price\">");
      out.print(order.getTotalPrice());
      out.write("</label>\r\n");
      out.write("                                                    <label for=\"staff-order\" class=\"col-form-label\">Nhân viên nhận\r\n");
      out.write("                                                        đơn:</label>\r\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"staff-order\">Truong\r\n");
      out.write("                                                        Quang Phuoc</label>\r\n");
      out.write("                                                    <label for=\"order-date\" class=\"col-form-label\">Ngày nhận\r\n");
      out.write("                                                        đơn:</label>\r\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-date\">");
      out.print(order.getCreatedAt());
      out.write("</label>\r\n");
      out.write("                                                    <label for=\"cus-note\" class=\"col-form-label\">Ghi chú:</label>\r\n");
      out.write("                                                    <textarea class=\"border border-secondary w-100 p-2 rounded\" readonly class=\"form-control-plaintext\" id=\"order-note\" name=\"order-note1\" style=\"resize: none; overflow: auto;\">");
      out.print(order.getOrderNote1());
      out.write("</textarea>\r\n");
      out.write("                                                    \r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-8 col-sm-5\">\r\n");
      out.write("                                                    <label for=\"customer-name\" class=\"col-form-label\">Tên khách\r\n");
      out.write("                                                        hàng:</label>\r\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"customer-name\">");
      out.print(order.getCustomerName());
      out.write("</label>\r\n");
      out.write("\r\n");
      out.write("                                                    <label for=\"order-address\" class=\"col-form-label\">Địa chỉ khách\r\n");
      out.write("                                                        hàng:</label>\r\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-address\">118\r\n");
      out.write("                                                        Hồ Tây, Hoàn Kiếm, Hà Nội</label>\r\n");
      out.write("                                                    </lable>\r\n");
      out.write("                                                    \r\n");
      out.write("                                                    \r\n");
      out.write("                                                        <label for=\"order-status\" class=\"col-form-label\">Trạng\r\n");
      out.write("                                                            thái:</label><br>\r\n");
      out.write("                                                            \r\n");
      out.write("                                                            <input type=\"text\" class=\"form-control\" hidden=\"true\" name=\"orderId\" value=\"");
      out.print(order.getOrderID());
      out.write("\"  />\r\n");
      out.write("                                                            \r\n");
      out.write("                                                        <select name=\"order-status\" id=\"order-status\" class=\"border border-secondary w-100 p-2 rounded\" style=\"margin-bottom: 8px;\">\r\n");
      out.write("                                                            \r\n");
      out.write("                                                            <option disabled value=\"0\" ");
if(order.getOrderStatus() == 0){
      out.write("selected");
}
      out.write(">Đang xử lí</option>\r\n");
      out.write("                                                            <option selected value=\"1\" ");
if(order.getOrderStatus() == 1){
      out.write("selected");
}
      out.write(">Đã nhận đơn</option>\r\n");
      out.write("                                                            <option disabled value=\"2\" ");
if(order.getOrderStatus() == 2){
      out.write("selected");
}
      out.write(">Đang vận chuyển</option>\r\n");
      out.write("                                                            <option disabled value=\"3\" ");
if(order.getOrderStatus() == 3){
      out.write("selected");
}
      out.write(">Hoàn thành</option>\r\n");
      out.write("                                                            <option disabled value=\"4\" ");
if(order.getOrderStatus() == 4){
      out.write("selected");
}
      out.write(">Đơn bị hủy</option>s\r\n");
      out.write("                                                        </select>\r\n");
      out.write("                                                        <!-- tôi không biết để select box kiểu disabled từng lựa chọn thế kia được không, không dc thì dùng label box ở dưới nhé -->\r\n");
      out.write("                                                        <!-- <label for=\"order-status\" class=\"col-form-label\">Trạng\r\n");
      out.write("                                                         thái:</label>\r\n");
      out.write("                                                        <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\"\r\n");
      out.write("                                                        id=\"order-status\">Đang vận chuyển</label> -->\r\n");
      out.write("                                                        <label for=\"order-note\" class=\"col-form-label\">Nhân viên ghi\r\n");
      out.write("                                                            chú:</label>\r\n");
      out.write("                                                        <textarea class=\"border border-secondary w-100 p-2 rounded\" readonly id=\"order-note\" name=\"order-note2\" style=\"resize: none; overflow: auto;\">");
      out.print(order.getOrderNote2());
      out.write("</textarea>\r\n");
      out.write("                                                        <div style=\"margin-top: 3%; float: right\">\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    \r\n");
      out.write("\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <thead>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                   \r\n");
      out.write("                                                    <th>Tên sản phẩm</th>\r\n");
      out.write("                                                    <th>Số lượng</th>\r\n");
      out.write("                                                    <th>Giá bán</th>\r\n");
      out.write("                                                    <th>Tổng giá sản phẩm</th>\r\n");
      out.write("\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                            </thead>\r\n");
      out.write("                                            <tbody>\r\n");
      out.write("                                                ");
for(OrderDetail od: listOrderDetail){
      out.write("\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    \r\n");
      out.write("                                                    <td>");
      out.print(od.getProductName());
      out.write("</td>\r\n");
      out.write("                                                    <td>");
      out.print(od.getProductQuantity());
      out.write("</td>\r\n");
      out.write("                                                    <td>");
      out.print(od.getPrice());
      out.write("</td>\r\n");
      out.write("                                                    <td>");
      out.print((Double)od.getPrice()*od.getProductQuantity());
      out.write("đ</td>\r\n");
      out.write("\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                               ");
}
      out.write("\r\n");
      out.write("                                            </tbody>\r\n");
      out.write("                                        </table>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer -->\r\n");
      out.write("        <!-- <footer class=\"sticky-footer bg-white\">\r\n");
      out.write("                <div class=\"container my-auto\">\r\n");
      out.write("                    <div class=\"copyright text-center my-auto\">\r\n");
      out.write("                        <span>Copyright &copy; Your Website 2020</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </footer> -->\r\n");
      out.write("        <!-- End of Footer -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End of Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Scroll to Top Button-->\r\n");
      out.write("    <a class=\"scroll-to-top rounded\" href=\"#page-top\">\r\n");
      out.write("        <i class=\"fas fa-angle-up\"></i>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript-->\r\n");
      out.write("    <script src=\"../vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"../vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Core plugin JavaScript-->\r\n");
      out.write("    <script src=\"../vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom scripts for all pages-->\r\n");
      out.write("    <script src=\"../js/sb-admin-2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page level plugins -->\r\n");
      out.write("    <script src=\"../vendor/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("    <script src=\"../vendor/datatables/dataTables.bootstrap4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page level custom scripts -->\r\n");
      out.write("    <script src=\"../js/demo/datatables-demo.js\"></script>\r\n");
      out.write("    <script src=\"../js/include-html.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
