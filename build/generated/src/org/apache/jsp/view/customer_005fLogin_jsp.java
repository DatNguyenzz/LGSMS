package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customer_005fLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"vi\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Login</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/lgin_reg_fgpw.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    <script src=\"https://code.iconify.design/2/2.1.2/iconify.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"img js-fullHeight\" style=\"background-image: url(../assets/image/bg4.webp); background-attachment: fixed;\">\r\n");
      out.write("    <section class=\"ftco-section\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row justify-content-center\">\r\n");
      out.write("                <div class=\"col-md-6 text-center mb-5\">\r\n");
      out.write("                    <a href=\"home.html\">\r\n");
      out.write("                        <span class=\"iconify\" data-icon=\"ic:twotone-gas-meter\" style=\"color: white;\" data-width=\"80\" data-height=\"80\"></span>\r\n");
      out.write("                        <h2 class=\"heading-section\">LGSMS</h2>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row justify-content-center\">\r\n");
      out.write("                <div class=\"col-md-6 col-lg-4\" style=\"background-color: rgba(28, 100, 168, 0.521); border: 5px solid rgb(117, 105, 105);\">\r\n");
      out.write("                    <div class=\"login-wrap p-0\">\r\n");
      out.write("                        <h3 class=\"mb-4 text-center\">Đăng Nhập</h3>\r\n");
      out.write("                        <!-- Form đăng nhập -->\r\n");
      out.write("                        <form id=\"form\" action=\"view_profile.html\">\r\n");
      out.write("                            <!-- Nhập email -->\r\n");
      out.write("                            <div class=\"input-control\">\r\n");
      out.write("                                <input id=\"email\" name=\"email\" type=\"text\" class=\"form-control\" placeholder=\"Tên tài khoản\" required oninvalid=\"this.setCustomValidity('Xin hãy nhập tên tài khoản của bạn.')\" oninput=\"this.setCustomValidity('')\" />\r\n");
      out.write("                                <div class=\"error\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- Nhập mật khẩu -->\r\n");
      out.write("                            <div class=\"input-control\">\r\n");
      out.write("                                <input id=\"password\" name=\"password\" type=\"password\" class=\"form-control\" placeholder=\"Mật khẩu\" required oninvalid=\"this.setCustomValidity('Xin hãy nhập mật khẩu của bạn.')\" oninput=\"this.setCustomValidity('')\" />\r\n");
      out.write("                                <i class=\"fa fa-eye field-icon\" id=\"togglePassword\" style=\"margin-top: auto;\"></i>\r\n");
      out.write("                                <div class=\"error\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- Đăng nhập btn -->\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <input type=\"submit\" class=\"form-control btn btn-primary submit px-3\" value=\"Đăng nhập\"></input>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group w-100 text-center\">\r\n");
      out.write("                                <a href=\"forgot_password.html\" style=\"color: #fff; text-decoration: underline;\">Quên mật khẩu?</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <!-- URL tạo tài khoản -->\r\n");
      out.write("                        <div class=\"w-100 text-center\">\r\n");
      out.write("                            <p>Bạn chưa có tài khoản? <a href=\"guest_register.html\" style=\"color: #fff; text-decoration: underline;\"><b>Đăng ký\r\n");
      out.write("\t\t\t\t\t\t\t\tngay!</b></a></p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"../js/popper.js\"></script>\r\n");
      out.write("    <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"../js/main.js\"></script>\r\n");
      out.write("</body>");
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
