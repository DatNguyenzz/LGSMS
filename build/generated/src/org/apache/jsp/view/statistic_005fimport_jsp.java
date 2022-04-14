package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class statistic_005fimport_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>LGS - Manager</title>\n");
      out.write("\n");
      out.write("    <!-- Custom fonts for this template -->\n");
      out.write("    <link href=\"../vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link\n");
      out.write("        href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"../assets/styles/sb-admin-2.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../assets/styles/icon_action.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this page -->\n");
      out.write("    <link href=\"../vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../assets/styles/custom_box.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../css/statistic.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("\n");
      out.write("    <!-- Page Wrapper -->\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\n");
      out.write("            <div include-html=\"../components/sidebar.html\" id=\"sidebar\" style=\"display: contents;\"></div>\n");
      out.write("            <div class=\"text-center d-none d-md-inline\">\n");
      out.write("                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\n");
      out.write("            </div>\n");
      out.write("        </ul>\n");
      out.write("        <!-- End of Sidebar -->\n");
      out.write("        <!-- Content Wrapper -->\n");
      out.write("        <div id=\"content-wrapper\" class=\"d-flex flex-column\" class=\"img js-fullheight\"\n");
      out.write("            style=\"background-image: url(../assets/image/fac2.jpg); background-size: cover;\">\n");
      out.write("            <!-- Main Content -->\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <!-- Topbar -->\n");
      out.write("                <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\n");
      out.write("                    <!-- Sidebar Toggle (Topbar) -->\n");
      out.write("                    <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                    </button>\n");
      out.write("                    <!-- Topbar Navbar -->\n");
      out.write("                    <div include-html=\"../components/topnavbar.html\" id=\"topnavbar\" class=\"ml-auto\"></div>\n");
      out.write("                </nav>\n");
      out.write("                <!-- End of Topbar -->\n");
      out.write("                <!-- Begin Page Content -->\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\n");
      out.write("                        <h1 class=\"h3 mb-0 text-white\">Thống kê hàng nhập</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Page Heading -->\n");
      out.write("                    <!-- Page Heading -->\n");
      out.write("                    <!-- DataTales Example -->\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xl-8 col-lg-8\">\n");
      out.write("                            <div class=\"card shadow mb-4\">\n");
      out.write("                                <div class=\"card-header py-3\">\n");
      out.write("                                    <h6 class=\"m-0 font-weight-bold text-primary\">Danh sách hàng nhập</h6>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"table-responsive\">\n");
      out.write("                                        <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("                                            <thead>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th>Mã sản phẩm</th>\n");
      out.write("                                                    <th>Tên sản phẩm</th>\n");
      out.write("                                                    <th>Ngày nhập</th>\n");
      out.write("                                                    <th>Nhà cung cấp</th>\n");
      out.write("                                                    <th class=\"payment\">Số lượng</th>\n");
      out.write("                                                    <th class=\"payment\">Tổng tiền</th>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </thead>\n");
      out.write("                                            <tbody>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>LG101</td>\n");
      out.write("                                                    <td>Bình gas 12 kg</td>\n");
      out.write("                                                    <td>06/04/2022</td>\n");
      out.write("                                                    <td>Petrolimex gas</td>\n");
      out.write("                                                    <td class=\"payment\">20</td>\n");
      out.write("                                                    <td class=\"payment\">5.489.000</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tbody>\n");
      out.write("                                            <tfoot>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td colSpan=\"4\" style=\"font-size: 18px; color: #4e73df;\">\n");
      out.write("                                                        <b>Tổng:</b>\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td class=\"payment\">20</td>\n");
      out.write("                                                    <td class=\"payment\">5.489.000</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </tfoot>\n");
      out.write("                                        </table>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- <div class=\"col-xl-6 col-lg-8\"> -->\n");
      out.write("                        <!-- Pie Chart -->\n");
      out.write("                        <div class=\"col-xl-4 col-lg-8\">\n");
      out.write("                            <div class=\"card shadow mb-4\">\n");
      out.write("                                <!-- Card Header - Dropdown -->\n");
      out.write("                                <div\n");
      out.write("                                    class=\"card-header py-3 d-flex flex-row align-items-center justify-content-between\">\n");
      out.write("                                    <h6 class=\"m-0 font-weight-bold text-primary\">Nguồn nhập hàng</h6>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Card Body -->\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"chart-pie pt-4 pb-2\">\n");
      out.write("                                        <canvas id=\"myPieChart\"></canvas>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"mt-4 text-center small\">\n");
      out.write("                                        <span class=\"mr-2\">\n");
      out.write("                                            <i class=\"fas fa-circle text-primary\"></i> Petrolimex\n");
      out.write("                                        </span>\n");
      out.write("                                        <span class=\"mr-2\">\n");
      out.write("                                            <i class=\"fas fa-circle text-success\"></i> Khách hàng\n");
      out.write("                                        </span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- End of Main Content -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End of Page Wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Scroll to Top Button-->\n");
      out.write("        <a class=\"scroll-to-top rounded\" href=\"#page-top\">\n");
      out.write("            <i class=\"fas fa-angle-up\"></i>\n");
      out.write("        </a>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript-->\n");
      out.write("        <script src=\"../vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"../vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Core plugin JavaScript-->\n");
      out.write("        <script src=\"../vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Custom scripts for all pages-->\n");
      out.write("        <script src=\"../js/sb-admin-2.min.js\"></script>\n");
      out.write("        <!-- Page level plugins -->\n");
      out.write("        <script src=\"../vendor/datatables/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"../vendor/datatables/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("        <script src=\"../vendor/chart.js/Chart.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Page level custom scripts -->\n");
      out.write("        <script src=\"../js/demo/datatables-demo.js\"></script>\n");
      out.write("        <script src=\"../js/include-html.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            // Set new default font family and font color to mimic Bootstrap's default styling\n");
      out.write("            Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,\"Segoe UI\",Roboto,\"Helvetica Neue\",Arial,sans-serif';\n");
      out.write("            Chart.defaults.global.defaultFontColor = '#858796';\n");
      out.write("\n");
      out.write("            // Pie Chart Example\n");
      out.write("            var ctx = document.getElementById(\"myPieChart\");\n");
      out.write("            var myPieChart = new Chart(ctx, {\n");
      out.write("                type: 'doughnut',\n");
      out.write("                data: {\n");
      out.write("                    labels: [\"Petrolimex\", \"Khách hàng\"],\n");
      out.write("                    datasets: [{\n");
      out.write("                        data: [85, 15],\n");
      out.write("                        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],\n");
      out.write("                        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],\n");
      out.write("                        hoverBorderColor: \"rgba(234, 236, 244, 1)\",\n");
      out.write("                    }],\n");
      out.write("                },\n");
      out.write("                options: {\n");
      out.write("                    maintainAspectRatio: false,\n");
      out.write("                    tooltips: {\n");
      out.write("                        backgroundColor: \"rgb(255,255,255)\",\n");
      out.write("                        bodyFontColor: \"#858796\",\n");
      out.write("                        borderColor: '#dddfeb',\n");
      out.write("                        borderWidth: 1,\n");
      out.write("                        xPadding: 15,\n");
      out.write("                        yPadding: 15,\n");
      out.write("                        displayColors: false,\n");
      out.write("                        caretPadding: 10,\n");
      out.write("                    },\n");
      out.write("                    legend: {\n");
      out.write("                        display: false\n");
      out.write("                    },\n");
      out.write("                    cutoutPercentage: 80,\n");
      out.write("                },\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
