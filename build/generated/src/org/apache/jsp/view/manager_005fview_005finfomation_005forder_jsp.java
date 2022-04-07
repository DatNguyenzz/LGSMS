package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>LGS - Admin</title>\n");
      out.write("\n");
      out.write("    <!-- Custom fonts for this template -->\n");
      out.write("    <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"assets/styles/sb-admin-2.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/view_list_account.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Custom styles for this page -->\n");
      out.write("    <link href=\"vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"assets/styles/custom_box.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");

//            Orders order= (Orders)request.getAttribute("orderInfor");
//    
//        ArrayList<OrderDetail> listOrderDetail = (ArrayList<OrderDetail>)request.getAttribute("listOrderDetail");
//        
//        ArrayList<Orders> listNewOrder = (ArrayList<Orders>)request.getAttribute("listNewOrder");
    
      out.write("\n");
      out.write("    <!-- Page Wrapper -->\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\n");
      out.write("            <div include-html=\"components/sidebar.jsp\" id=\"sidebar\" style=\"display: contents;\"></div>\n");
      out.write("            <div class=\"text-center d-none d-md-inline\">\n");
      out.write("                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\n");
      out.write("            </div>\n");
      out.write("        </ul>\n");
      out.write("        <!-- End of Sidebar -->\n");
      out.write("        <!-- Content Wrapper -->\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\" class=\"img js-fullheight\" style=\"background-image: url(assets/image/fac2.jpg); background-size: cover;\">\n");
      out.write("            <!-- Main Content -->\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <!-- Topbar -->\n");
      out.write("                <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\n");
      out.write("                    <!-- Sidebar Toggle (Topbar) -->\n");
      out.write("                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <!-- Topbar Navbar -->\n");
      out.write("                    <div include-html=\"components/topnavbar.jsp\" id=\"topnavbar\" class=\"ml-auto\"></div>\n");
      out.write("                </nav>\n");
      out.write("                <!-- End of Topbar -->\n");
      out.write("\n");
      out.write("                <!-- Begin Page Content -->\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                    <!-- Page Heading -->\n");
      out.write("                    <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\n");
      out.write("                        <h1 class=\"h3 mb-0 text-white\">Chi tiết đơn hàng</h1>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- DataTales Example -->\n");
      out.write("                    <div class=\"row\" style=\"width: 100%;\">\n");
      out.write("                        <div class=\"col-8 col-sm-12\">\n");
      out.write("                            <div class=\"card shadow mb-4\">\n");
      out.write("                                <div class=\"card-header py-3\">\n");
      out.write("                                    \n");
      out.write("                                    <!--Tôi giữ nguyên class với\n");
      out.write("                                    link đúng id với nhau nhé -->\n");
      out.write("                                    <span class=\"m-0 font-weight-bold text-primary\">Đơn hàng</span>\n");
      out.write("                                    <a href=\"manager_view_information_voucher.html\" class=\"order-voucher\">Chuyển phiếu thu</a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"table-responsive\">\n");
      out.write("\n");
      out.write("                                        <table  class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("                                            <div class=\"row\" style=\"border: 2px solid lightgray;\">\n");
      out.write("                                                <div class=\"col-8 col-sm-1\"></div>\n");
      out.write("                                                <div class=\"col-8 col-sm-5\">\n");
      out.write("                                                    <label for=\"order-code\" class=\"col-form-label\">Mã đơn\n");
      out.write("                                                        hàng:</label>\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-code\" ></label>\n");
      out.write("                                                    <label for=\"order-price\" class=\"col-form-label\">Tổng giá\n");
      out.write("                                                        tiền:</label>\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-price\"></label>\n");
      out.write("                                                    <label for=\"staff-order\" class=\"col-form-label\">Nhân viên nhận\n");
      out.write("                                                        đơn:</label>\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"staff-order\">Truong\n");
      out.write("                                                        Quang Phuoc</label>\n");
      out.write("                                                    <label for=\"order-date\" class=\"col-form-label\">Ngày nhận\n");
      out.write("                                                        đơn:</label>\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-date\"></label>\n");
      out.write("                                                    <label for=\"cus-note\" class=\"col-form-label\">Ghi chú:</label>\n");
      out.write("                                                    <textarea class=\"border border-secondary w-100 p-2 rounded\" readonly class=\"form-control-plaintext\" id=\"order-note\" name=\"order-note1\" style=\"resize: none; overflow: auto;\"></textarea>\n");
      out.write("                                                    \n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-8 col-sm-5\">\n");
      out.write("                                                    <label for=\"customer-name\" class=\"col-form-label\">Tên khách\n");
      out.write("                                                        hàng:</label>\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"customer-name\"></label>\n");
      out.write("\n");
      out.write("                                                    <label for=\"order-address\" class=\"col-form-label\">Địa chỉ khách\n");
      out.write("                                                        hàng:</label>\n");
      out.write("                                                    <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\" id=\"order-address\">118\n");
      out.write("                                                        Hồ Tây, Hoàn Kiếm, Hà Nội</label>\n");
      out.write("                                                    </lable>\n");
      out.write("                                                    \n");
      out.write("                                                    \n");
      out.write("                                                        <label for=\"order-status\" class=\"col-form-label\">Trạng\n");
      out.write("                                                            thái:</label><br>\n");
      out.write("                                                            \n");
      out.write("                                                            <input type=\"text\" class=\"form-control\" hidden=\"true\" name=\"orderId\" value=\"\"  />\n");
      out.write("                                                            \n");
      out.write("                                                        <select name=\"order-status\" id=\"order-status\" class=\"border border-secondary w-100 p-2 rounded\" style=\"margin-bottom: 8px;\">\n");
      out.write("                                                            \n");
      out.write("                                                            <option disabled value=\"0\" >Đang xử lí</option>\n");
      out.write("                                                            <option selected value=\"1\" >Đã nhận đơn</option>\n");
      out.write("                                                            <option disabled value=\"2\" >Đang vận chuyển</option>\n");
      out.write("                                                            <option disabled value=\"3\" >Hoàn thành</option>\n");
      out.write("                                                            <option disabled value=\"4\" >Đơn bị hủy</option>s\n");
      out.write("                                                        </select>\n");
      out.write("                                                        <!-- tôi không biết để select box kiểu disabled từng lựa chọn thế kia được không, không dc thì dùng label box ở dưới nhé -->\n");
      out.write("                                                        <!-- <label for=\"order-status\" class=\"col-form-label\">Trạng\n");
      out.write("                                                         thái:</label>\n");
      out.write("                                                        <label type=\"text\" class=\"border border-secondary w-100 p-2 rounded\"\n");
      out.write("                                                        id=\"order-status\">Đang vận chuyển</label> -->\n");
      out.write("                                                        <label for=\"order-note\" class=\"col-form-label\">Nhân viên ghi\n");
      out.write("                                                            chú:</label>\n");
      out.write("                                                        <textarea class=\"border border-secondary w-100 p-2 rounded\" readonly id=\"order-note\" name=\"order-note2\" style=\"resize: none; overflow: auto;\"></textarea>\n");
      out.write("                                                        <div style=\"margin-top: 3%; float: right\">\n");
      out.write("                                                        </div>\n");
      out.write("                                                    \n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                   \n");
      out.write("                                                    <th>Tên sản phẩm</th>\n");
      out.write("                                                    <th>Số lượng</th>\n");
      out.write("                                                    <th>Giá bán</th>\n");
      out.write("                                                    <th>Tổng giá sản phẩm</th>\n");
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                \n");
      out.write("                                                <tr>\n");
      out.write("                                                    \n");
      out.write("                                                    \n");
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("                                               ");
}
      out.write("\n");
      out.write("                                            </tbody>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- End of Main Content -->\n");
      out.write("\n");
      out.write("        <!-- Footer -->\n");
      out.write("        <!-- <footer class=\"sticky-footer bg-white\">\n");
      out.write("                <div class=\"container my-auto\">\n");
      out.write("                    <div class=\"copyright text-center my-auto\">\n");
      out.write("                        <span>Copyright &copy; Your Website 2020</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer> -->\n");
      out.write("        <!-- End of Footer -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- End of Page Wrapper -->\n");
      out.write("\n");
      out.write("    <!-- Scroll to Top Button-->\n");
      out.write("    <a class=\"scroll-to-top rounded\" href=\"#page-top\">\n");
      out.write("        <i class=\"fas fa-angle-up\"></i>\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript-->\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Core plugin JavaScript-->\n");
      out.write("    <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Custom scripts for all pages-->\n");
      out.write("    <script src=\"js/sb-admin-2.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Page level plugins -->\n");
      out.write("    <script src=\"vendor/datatables/jquery.dataTables.min.js\"></script>\n");
      out.write("    <script src=\"vendor/datatables/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Page level custom scripts -->\n");
      out.write("    <script src=\"js/demo/datatables-demo.js\"></script>\n");
      out.write("    <script src=\"js/include-html.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
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
