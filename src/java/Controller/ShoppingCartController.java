/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.ShoppingCart;
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
public class ShoppingCartController extends HttpServlet {

    ShoppingCartService cartService = new ShoppingCartService();

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
        String url = request.getServletPath();
        switch (url) {
            case "/ShoppingCart": {
                Account account = (Account) request.getSession().getAttribute("account");
                int customerID = account.getAccountID();
                ArrayList<ShoppingCart> listCart = cartService.getCartByCusID(customerID);
//                Double total = cartService.totalPriceInCart(listCart);
//                request.setAttribute("listCart", listCart);
//                request.setAttribute("total", total);
                if (listCart.isEmpty()) {
                    String nonCart = "No item in cart";
                    request.setAttribute("nonCart", nonCart);
                    double total = 0;
                    request.setAttribute("total", total);
                } else {
                    double total = cartService.totalPriceInCart(listCart);
                    request.setAttribute("total", total);

                }

                request.setAttribute("listCart", listCart);

                request.getRequestDispatcher("Customer_LGSMS/view/cart.jsp").forward(request, response);
                break;
            }
            case "/EditQuantity": {
                int cartID = Integer.parseInt(request.getParameter("id"));
                int quantity = Integer.parseInt(request.getParameter("num"));
                if (cartService.updateProductQuantityByCartID(cartID, quantity)) {
                    response.sendRedirect(request.getContextPath() + "/ShoppingCart");
                } else {

                }

                break;
            }
            case "/RemoveProduct": {
                int cartId = Integer.parseInt(request.getParameter("idCart"));
                if (cartService.deleteCartByID(cartId)) {
                    response.sendRedirect(request.getContextPath() + "/ShoppingCart");
                } else {

                }
                break;
            }
            case "/AddProductToCart": { // add product to cart
                //Add for customer - Add to database
                Account account = (Account) request.getSession().getAttribute("account");
                ShoppingCartService cartService = new ShoppingCartService();
                int productId = Integer.parseInt(request.getParameter("productID"));
                int customerID = account.getAccountID();
                if (cartService.addProduct(productId, customerID)) {
                    response.sendRedirect(request.getHeader("referer"));
                } else {

                }
                break;
            }
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
        String url = request.getServletPath();
        switch (url) {

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
