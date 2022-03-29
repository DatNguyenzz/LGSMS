/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.Role;
import Service.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class ManageAccountController extends HttpServlet {

    AccountService accountService = new AccountService();

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        ArrayList<Account> listAccount = accountService.getAllAccount();
        ArrayList<Role> listRole = accountService.getAllRole();

        request.setAttribute("listRole", listRole);
        request.setAttribute("listAccount", listAccount);
        request.getRequestDispatcher("view/admin_manage_account.jsp").forward(request, response);
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
            case "/EditAccount": {
                int accountId = Integer.parseInt(request.getParameter("accountId"));
                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String dob = request.getParameter("dob");
                Boolean gender = (request.getParameter("gender").equals("true"));
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                int roleId = Integer.parseInt(request.getParameter("role"));
                if (accountService.updateAccount(accountId, fullname, phone, address, dob, gender, username, email, roleId)) {
                    //Update success 
                    response.sendRedirect(request.getContextPath() + "/ManageAccount");
                } else {
                    //Update fail
                }
                break;
            }
            case "/AddAccount": {
                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String dob = request.getParameter("dob");
                Boolean gender = (request.getParameter("gender").equals("true"));
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                int roleId = Integer.parseInt(request.getParameter("role"));
                if (accountService.addAccount(fullname, phone, address, dob, gender, username, email, roleId)) {
                    //Add success
                    response.sendRedirect(request.getContextPath() + "/ManageAccount");
                } else {
                    //Add fail
                }
                break;
            }

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
