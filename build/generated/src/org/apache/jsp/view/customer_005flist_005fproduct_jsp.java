package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Product;
import java.util.ArrayList;

public final class customer_005flist_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("    <meta name=\"description\" content=\"\" />\n");
      out.write("    <meta name=\"author\" content=\"\" />\n");
      out.write("    <title>Product_List</title>\n");
      out.write("    <!-- Favicon-->\n");
      out.write("    <!-- Bootstrap icons-->\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Core theme CSS (includes Bootstrap)-->\n");
      out.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js\">\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\">\n");
      out.write("    <link href=\"//cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css\">\n");
      out.write("    <link href=\"//cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js\">\n");
      out.write("    <link href=\"css/home_product_list.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");

            ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
        
      out.write("\n");
      out.write("    <header>\n");
      out.write("        <div include-html=\"components/header.html\" id=\"header\" style=\"display: contents;\"></div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container d-flex justify-content-center mt-50 mb-50\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            ");
for (Product product : listProduct) {
      out.write("\n");
      out.write("            <div class=\"col-md-4 mt-4\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"card-img-actions\"> <img src=\"https://res.cloudinary.com/dxfq3iotg/image/upload/v1562074043/234.png\" class=\"card-img img-fluid\" width=\"96\" height=\"350\" alt=\"\"> </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body bg-light text-center\">\n");
      out.write("                        <div class=\"mb-2\">\n");
      out.write("                            <h6 class=\"font-weight-semibold mb-2\">\n");
      out.write("                                <a href=\"");
      out.print(request.getContextPath());
      out.write("/ProductInformation?productID=");
      out.print(product.getProductID());
      out.write("\" \n");
      out.write("                                   class=\"text-default mb-2\" data-abc=\"true\">");
      out.print(product.getProductName());
      out.write("</a> </h6>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <h3 class=\"mb-0 font-weight-semibold\">");
      out.print(product.getProductPrice());
      out.write("</h3>\n");
      out.write("                        <button type=\"button\" class=\"bg-cart\"><i class=\"fa fa-cart-plus mr-2\"></i> Add to cart</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <footer>\n");
      out.write("        <div include-html=\"components/footer.html\" id=\"footer\" style=\"display: contents;\"></div>\n");
      out.write("    </footer>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("    <script src=\"js/include-html.min.js\"></script>\n");
      out.write("</body>\n");
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
