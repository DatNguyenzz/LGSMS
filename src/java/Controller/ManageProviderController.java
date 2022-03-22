/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Provider;
import Service.ProviderService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.util.Duration.millis;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class ManageProviderController extends HttpServlet {

    ProviderService providerService = new ProviderService();

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
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Provider> listProvider = providerService.getAllProvider();
        request.setAttribute("listProvider", listProvider);
        request.getRequestDispatcher("view/manager_manage_provider.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try {

            String url = request.getServletPath();
            if (url.equals("/EditProvider")) {
                int providerId = Integer.parseInt(request.getParameter("providerID"));
                String providerName = request.getParameter("providerName");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String phone = request.getParameter("providerPhone");

                Provider provider = new Provider();

                provider.setProviderID(providerId);
                provider.setProviderName(providerName);
                provider.setProviderEmail(email);
                provider.setProviderAddress(address);
                provider.setProviderPhone(phone);

                int result = providerService.getPoviderUpdate(provider);
                if (result != 0) {
                    response.sendRedirect(request.getContextPath() + "/ManageProvider");
                } else {
                    response.sendRedirect("123123");
                }
            } else if (url.equals("/AddProvider")) {

                String providerName = request.getParameter("provider-name");
                String providerPhone = request.getParameter("provider-phone");
                String providerAddress = request.getParameter("provider-address");
                String providerEmail = request.getParameter("provider-email");
                
                Provider provider = new Provider();
                provider.setProviderName(providerName);
                provider.setProviderPhone(providerPhone);
                provider.setProviderEmail(providerEmail);
                provider.setProviderAddress(providerAddress);
                provider.setIsActive(true);
                if (providerService.addNewProviderToDB(provider)) {
                    //Add success
                    response.sendRedirect(request.getContextPath() + "/ManageProvider");
                } else {
                    //Add failed
                    System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(ManageProviderController.class.getName()).log(Level.SEVERE, null, ex);
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
