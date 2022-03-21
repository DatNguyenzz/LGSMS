package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Model.Product;

public final class manager_005fmanage_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>LGS - Manager</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom fonts for this template -->\r\n");
      out.write("    <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"assets/styles/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/styles/slider_status.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this page -->\r\n");
      out.write("    <link href=\"vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("    ");

        ArrayList<Product> listProduct = (ArrayList<Product>)request.getAttribute("listProduct");
    
      out.write("\r\n");
      out.write("    <!-- Page Wrapper -->\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Sidebar -->\r\n");
      out.write("        <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\r\n");
      out.write("            <div include-html=\"components/sidebar.html\" id=\"sidebar\" style=\"display: contents;\"></div>\r\n");
      out.write("            <div class=\"text-center d-none d-md-inline\">\r\n");
      out.write("                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <!-- End of Sidebar -->\r\n");
      out.write("        <!-- Content Wrapper -->\r\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("            <!-- Main Content -->\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("                <!-- Topbar -->\r\n");
      out.write("                <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\r\n");
      out.write("                    <!-- Sidebar Toggle (Topbar) -->\r\n");
      out.write("                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\r\n");
      out.write("                            <i class=\"fa fa-bars\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <!-- Topbar Navbar -->\r\n");
      out.write("                    <div include-html=\"components/topnavbar.html\" id=\"topnavbar\" class=\"ml-auto\"></div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <!-- End of Topbar -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Begin Page Content -->\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("                    <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\r\n");
      out.write("                        <h1 class=\"h3 mb-0 text-gray-800\">Quản lý sản phẩm</h1>\r\n");
      out.write("                        <button class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@getbootstrap\"><i class=\"fas fa-plus fa-sm text-white-50\"></i> Thêm sản phẩm</button>\r\n");
      out.write("                        <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("                            <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">\r\n");
      out.write("                                <div class=\"modal-content\">\r\n");
      out.write("                                    <div class=\"modal-header\">\r\n");
      out.write("                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Điền thông tin sản phẩm</h5>\r\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                            <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                        </button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <!-- Add new product -->\r\n");
      out.write("                                    <div class=\"modal-body\">\r\n");
      out.write("                                        <form action=\"\">\r\n");
      out.write("                                            <div class=\"row\" style=\"width: 100%;\">\r\n");
      out.write("                                                <div class=\"col-sm-12\">\r\n");
      out.write("                                                    <div class=\"row\">\r\n");
      out.write("                                                        <div class=\"col-8 col-sm-5 text-center\">\r\n");
      out.write("                                                            <img src=\"assets/image/img/undraw_posting_photo.svg\" alt=\"...\" class=\"img-thumbnail\">\r\n");
      out.write("                                                            <button type=\"button\" class=\"btn btn-primary \">Tải ảnh</button>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                        <div class=\"col-8 col-sm-7\">\r\n");
      out.write("                                                            <div class=\"form-group\">\r\n");
      out.write("                                                                <label for=\"product-name\" class=\"col-form-label\">Tên sản phẩm:</label>\r\n");
      out.write("                                                                <input type=\"text\" class=\"form-control\" id=\"product-name\">\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"form-group\">\r\n");
      out.write("                                                                <label for=\"product-quantity\" class=\"col-form-label\">Số lượng:</label>\r\n");
      out.write("                                                                <input type=\"text\" class=\"form-control\" id=\"product-quantity\">\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"form-group\">\r\n");
      out.write("                                                                <label for=\"product-price\" class=\"col-form-label\">Giá bán:</label>\r\n");
      out.write("                                                                <input type=\"text\" class=\"form-control\" id=\"product-price\">\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"form-group\">\r\n");
      out.write("                                                                <label for=\"product-des\" class=\"col-form-label\">Mô tả:</label>\r\n");
      out.write("                                                                <textarea class=\"form-control\" id=\"product-des\"></textarea>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"modal-footer\">\r\n");
      out.write("                                                                <input type=\"submit\" class=\"btn btn-primary\" value=\"Thêm\"></input>\r\n");
      out.write("                                                                <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Hủy</button>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- Page Heading -->\r\n");
      out.write("                    <!-- DataTales Example -->\r\n");
      out.write("                    <div class=\"card shadow mb-4\">\r\n");
      out.write("                        <div class=\"card-header py-3\">\r\n");
      out.write("                            <h6 class=\"m-0 font-weight-bold text-primary\">Danh sách sản phẩm</h6>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <div class=\"table-responsive\">\r\n");
      out.write("                                <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th>Mã sản phẩm</th>\r\n");
      out.write("                                            <th>Tên sản phẩm</th>\r\n");
      out.write("                                            <th>Thương hiệu</th>\r\n");
      out.write("                                            <th>Có thể bán</th>\r\n");
      out.write("                                            <th>Giá bán</th>\r\n");
      out.write("                                            <th>Giá nhập</th>\r\n");
      out.write("                                            <th>Trạng thái</th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        ");
for(Product product : listProduct){
      out.write("\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(product.getProductID());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(product.getProductName());
      out.write("</td>\r\n");
      out.write("                                            <td>!?</td>\r\n");
      out.write("                                            <td>");
      out.print(product.getProductInstock());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(product.getProductPrice());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(product.getProductImportPrice());
      out.write("</td>\r\n");
      out.write("                                            <td>\r\n");
      out.write("                                                <label class=\"switch\">\r\n");
      out.write("                                                <input type=\"checkbox\" ");
if(product.isIsActive()){
      out.write("checked");
}
      out.write(">\r\n");
      out.write("                                                <span class=\"slider round\"></span>\r\n");
      out.write("                                                </label>\r\n");
      out.write("                                            </td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        ");
}
      out.write("\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- End of Main Content -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End of Content Wrapper -->\r\n");
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
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Core plugin JavaScript-->\r\n");
      out.write("    <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom scripts for all pages-->\r\n");
      out.write("    <script src=\"js/sb-admin-2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page level plugins -->\r\n");
      out.write("    <script src=\"vendor/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("    <script src=\"vendor/datatables/dataTables.bootstrap4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Page level custom scripts -->\r\n");
      out.write("    <script src=\"js/demo/datatables-demo.js\"></script>\r\n");
      out.write("    <script src=\"js/include-html.min.js\"></script>\r\n");
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
