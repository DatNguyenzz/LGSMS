/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.ShoppingCart;
import Service.AccountService;
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
public class CheckOutController extends HttpServlet {

    AccountService accountService = new AccountService();
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
//        request.getRequestDispatcher("Customer_LGSMS/view/checkout.jsp").forward(request, response);

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
            case "/CheckOut":
                Account account = (Account) request.getSession().getAttribute("account");
                ArrayList<ShoppingCart> listCart = new ArrayList<>();
                int customerID = account.getAccountID();
                listCart = cartService.getCartByCusID(customerID);
                Double total = cartService.totalPriceInCart(listCart);

                request.setAttribute("listCart", listCart);
                request.setAttribute("total", total);

                request.getRequestDispatcher("Customer_LGSMS/view/checkout.jsp").forward(request, response);
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
        Account account = (Account) request.getSession().getAttribute("account");
        String fullname = request.getParameter("name");
        String phone = request.getParameter("phone");

        String address = request.getParameter("address");
        String email = request.getParameter("email");

//        if (accountService.updateAccountForCheckOut(account.getAccountID(), fullname, phone, address, email, account.getRole().getRoleID())) {
//            //Update success 
//            account = accountService.getAccountByID(account.getAccountID());
//            request.getSession().setAttribute("account", account);
//            response.sendRedirect(request.getContextPath() + "/CheckOut");
//        } else {
//            //Update fail
//        }
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
