/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.Product;
import Model.ShoppingCart;
import Service.ProductService;
import Service.ShoppingCartService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class CustomerProductController extends HttpServlet {

    ProductService productService = new ProductService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Product> listProduct = productService.getAllProductIsActive();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("Customer_LGSMS/view/product_list.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        switch (url) {
            case "/Product":
                ArrayList<Product> listProduct = new ArrayList<>();
                String filter = request.getParameter("filter");
                // filter product
                if (filter == null) {
                    listProduct = productService.getAllProductIsActive();
                    request.setAttribute("listProduct", listProduct);
                    request.getRequestDispatcher("Customer_LGSMS/view/product_list.jsp").forward(request, response);
                } else {
                    int filterID = Integer.parseInt(filter);
                    listProduct = productService.getAllProductFilter(filterID);
                    request.setAttribute("listProduct", listProduct);
                    request.getRequestDispatcher("Customer_LGSMS/view/product_list.jsp").forward(request, response);
                }

                // add product to cart
                Account account = (Account) request.getSession().getAttribute("account");
                ShoppingCartService cartService = new ShoppingCartService();
                ShoppingCart shoppingCart = new ShoppingCart();
                
                int productId = Integer.parseInt(request.getParameter("productID"));
                int customerID = account.getAccountID();
            if (cartService.addProduct(productId, customerID)) {

                        response.sendRedirect(request.getContextPath() + "/Product");
                    } else {
                       
                    }

                break;

            case "/CustomerProductInformation":
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = productService.getProductByID(productID);
                request.setAttribute("product", product);
                request.getRequestDispatcher("view/customer_product_detail.jsp").forward(request, response);
                break;
            default:
                processRequest(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getServletPath();

        switch (url) {
            case "/Product":

                String search = request.getParameter("searchName");
                ArrayList<Product> listProduct = productService.getSearchProduct(search);
                request.setAttribute("listProduct", listProduct);
                request.getRequestDispatcher("Customer_LGSMS/view/product_list.jsp").forward(request, response);
                break;

            default:
                processRequest(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
