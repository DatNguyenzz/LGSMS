package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class alertModal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Alert Modal</title>\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"../assets/styles/sb-admin-2.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Custom styles for this page -->\n");
      out.write("    <link href=\"../assets/styles/alert.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Confirm Modal window</h1>\n");
      out.write("    <!--N?u không comment script m? comment ph?n này là 1 modal alert-->\n");
      out.write("<!--     <div class=\"modal_overlay\">\n");
      out.write("        <div class=\"modal_window\">\n");
      out.write("            <div class=\"modal_titlebar\">\n");
      out.write("                <span class=\"modal_title\">Confirm title</span>\n");
      out.write("                <button class=\"modal_close material-icons\" onclick=\"this.parentElement.parentElement.parentElement.style.display='none';\">&times;</button>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal_content\">\n");
      out.write("                lul mao poop peepo\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div> -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"../js/modal_alert.js\"></script>\n");
      out.write("<!--Dùng script này ?? g?i 1 modal xu?t hi?n thay ??i title content theo ý mu?n-->\n");
      out.write("<script>\n");
      out.write("    ModalWindow.openModal({\n");
      out.write("    title:\"Confirm\",\n");
      out.write("    content:\"Pôp\"\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
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
