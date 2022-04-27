package Controller;

import Model.Account;
import Service.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dat Nguyen
 */
public class ProfileController extends HttpServlet {

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
        String url = request.getServletPath();
        Account acc = (Account) request.getSession().getAttribute("account");
        switch (url) {
            case "/MyProfile":
                if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equals("Customer")) {
                    request.getRequestDispatcher("Customer_LGSMS/view/profile.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/staff_view_profile.jsp").forward(request, response);
                }
                break;
            case "/ChangePassword":
                if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equals("Customer")) {
                    request.getRequestDispatcher("Customer_LGSMS/view/profile_changePassword.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/staff_view_profile.jsp").forward(request, response);
                }
                break;
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
        String url = request.getServletPath();
        Account account = (Account) request.getSession().getAttribute("account");

        switch (url) {
            case "/MyProfile": {
                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String dob = request.getParameter("dob");
                boolean gender = Boolean.valueOf(request.getParameter("gender"));
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                if (accountService.updateAccountInProfile(account.getAccountID(), fullname, phone, address, dob, gender, email, account.getRole().getRoleID())) {
                    //Update success 
                    account = accountService.getAccountByID(account.getAccountID());
                    request.getSession().setAttribute("account", account);
                    response.sendRedirect(request.getContextPath() + "/MyProfile");
                } else {
                    //Update fail
                }
                break;
            }
            case "/ChangePassword": {
                int id = account.getAccountID();
                String newPassword = request.getParameter("new-password");
                String oldPassword = request.getParameter("old-password");

                if (accountService.changePass(id, oldPassword, newPassword) != 0) {
                    response.sendRedirect(request.getContextPath() + "/MyProfile");
                } else {

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
