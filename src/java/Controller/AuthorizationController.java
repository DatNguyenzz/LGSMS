package Controller;

import Model.Account;
import Service.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dat Nguyen
 */
public class AuthorizationController extends HttpServlet {

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
        if (url.equals("/login")) {
            //Get login
            if (acc == null) {
                request.getRequestDispatcher("Staff_LGSMS/view/login.jsp").forward(request, response);
            } else {
                if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equalsIgnoreCase("Khách hàng")) {
                    response.sendRedirect(request.getContextPath() + "/Home");
                }else{
                    response.sendRedirect(request.getContextPath() + "/StaffHome");
                }
            }
        } else if (url.equals("/logout")) {
            //Get logut
            if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equalsIgnoreCase("Khách hàng")) {
                request.getSession().removeAttribute("account");
                response.sendRedirect(request.getContextPath() + "/Home");
            } else {
                request.getSession().removeAttribute("account");
                response.sendRedirect(request.getContextPath() + "/login");
            }
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account acc = new AccountService().login(username, password);
        if (acc == null) {
            //Login failed
            request.setAttribute("failMessage", "Đăng nhập không thành công");
            request.getRequestDispatcher("Staff_LGSMS/view/login.jsp").forward(request, response);
        } else {
            //Login success
            HttpSession session = request.getSession();
            session.setAttribute("account", acc);
            if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equals("Khách hàng")) {
                response.sendRedirect(request.getContextPath() + "/Home");
            } else {
                response.sendRedirect(request.getContextPath() + "/StaffHome");
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
