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
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class ManageAccountController extends HttpServlet {

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO = Charset.forName("ISO-8859-1");
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
        switch (url) {
            case "/ManageAccount":
                ArrayList<Account> listAccount = accountService.getAllAccount();
                ArrayList<Role> listRole = accountService.getAllRole();

                request.setAttribute("listRole", listRole);
                request.setAttribute("listAccount", listAccount);
                request.getRequestDispatcher("Staff_LGSMS/view/admin_manage_account.jsp").forward(request, response);
                break;
            case "/Register":
                request.getRequestDispatcher("Staff_LGSMS/view/guest_register.jsp").forward(request, response);
                break;
            case "/ForgotPassword":
                request.getRequestDispatcher("Customer_LGSMS/view/forgotPassword.jsp").forward(request, response);
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
        request.getSession().removeAttribute("messageAccountPage");
        String url = request.getServletPath();
        switch (url) {
            case "/EditAccount": {
                int accountId = Integer.parseInt(request.getParameter("accountId"));
                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String dob = request.getParameter("dob");
                Boolean gender = (request.getParameter("gender").equals("true"));
                String email = request.getParameter("email");
                int roleId = Integer.parseInt(request.getParameter("role"));
                Boolean isActive = (request.getParameter("staff-status").equals("true"));
                if (accountService.isEmailExist(email)) {
                    request.getSession().setAttribute("message", "Email n??y ???? ???????c s??? d???ng");
                    response.sendRedirect(request.getContextPath() + "/ManageAccount");
                } else {
                    if (accountService.updateAccount(accountId, fullname, phone, address, dob, gender, email, roleId, isActive)) {
                        //Update success 
                        response.sendRedirect(request.getContextPath() + "/ManageAccount");
                    } else {
                        if (accountService.updateAccount(accountId, fullname, phone, address, dob, gender, email, roleId, isActive)) {
                            //Update success 
                            request.getSession().setAttribute("message", "Thay ?????i th??ng tin th??nh c??ng");
                            response.sendRedirect(request.getContextPath() + "/ManageAccount");
                        } else {
                            //Update fail
                            request.getSession().setAttribute("message", "Thay ?????i th??ng tin th???t b???i");
                            response.sendRedirect(request.getContextPath() + "/ManageAccount");
                        }
                    }
                }
                break;
            }
            case "/AddAccount": {
                String fullname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String dob = request.getParameter("dob");
                Boolean gender = (request.getParameter("gender").equals("true"));
                String email = request.getParameter("email");
                int roleId = Integer.parseInt(request.getParameter("role"));
                if (accountService.isEmailExist(email)) {
                    System.out.println("Email exitst");
                    request.getSession().setAttribute("message", "Email n??y ???? ???????c s??? d???ng");
                    response.sendRedirect(request.getContextPath() + "/ManageAccount");
                } else {
                    if (accountService.addAccount(fullname, phone, address, dob, gender, email, roleId)) {
                        //Add success
                        request.getSession().setAttribute("message", "T???o t??i kho???n m???i th??nh c??ng");
                        response.sendRedirect(request.getContextPath() + "/ManageAccount");
                    } else {
                        //Add fail
                        request.getSession().setAttribute("message", "T???o t??i kho???n m???i th???t b???i");
                        response.sendRedirect(request.getContextPath() + "/ManageAccount");
                    }
                }
                break;
            }
            case "/Register": {
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                if (accountService.isEmailExist(email) && accountService.isUserNameExist(username)) {
                    request.setAttribute("emailMessage", "Email ???? t???n t???i!");
                    request.setAttribute("userNameMessage", "T??n ????ng nh???p ???? t???n t???i!");
                    request.getRequestDispatcher("Staff_LGSMS/view/guest_register.jsp").forward(request, response);
                } else if (accountService.isEmailExist(email)) {
                    request.setAttribute("emailMessage", "Email ???? t???n t???i! ");
                    request.getRequestDispatcher("Staff_LGSMS/view/guest_register.jsp").forward(request, response);
                } else if (accountService.isUserNameExist(username)) {
                    request.setAttribute("userNameMessage", "T??n ????ng nh???p ???? t???n t???i! ");
                    request.getRequestDispatcher("Staff_LGSMS/view/guest_register.jsp").forward(request, response);
                } else {
                    String password = accountService.randomPassword();
                    String subject = "New Account.";
                    String message = "<!DOCTYPE html>\n"
                            + "<html lang=\"en\">\n"
                            + "\n"
                            + "<head>\n"
                            + "<meta charset=\"UTF-8\">\n"
                            + "</head>\n"
                            + "\n"
                            + "<body>\n"
                            + "    <h3 style=\"color: blue;\">Your password.</h3>\n"
                            + "    <div>Password : " + password + "</div>\n"
                            + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                            + "\n"
                            + "</body>\n"
                            + "\n"
                            + "</html>";
                    if (accountService.register(username, email, password, 4)) {
                        accountService.send(email, subject, message, "lgsmsvanhsibun@gmail.com", "vanhsibun123");
//                        request.setAttribute("sucessfulMessage", "M???t kh???u ???? ???????c g???i ?????n email c???a b???n. ");
                        response.sendRedirect(request.getContextPath() + "/Register");
                    } else {

                    }
                }

                break;
            }

            case "/ForgotPassword": {

                String email = request.getParameter("email");

                if (accountService.isEmailExist(email)) {
                    String password = accountService.randomPassword();
                    String subject = "Forgot password.";
                    String message = "<!DOCTYPE html>\n"
                            + "<html lang=\"en\">\n"
                            + "\n"
                            + "<head>\n"
                            + "<meta charset=\"UTF-8\">\n"
                            + "</head>\n"
                            + "\n"
                            + "<body>\n"
                            + "    <h3 style=\"color: blue;\">Forgot password.</h3>\n"
                            + "    <div>Full t??n Name :" + accountService.getAccountByEmail(email).getUsername() + "</div>\n"
                            + "    <div>Password : " + password + "</div>\n"
                            + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                            + "\n"
                            + "</body>\n"
                            + "\n"
                            + "</html>";
                    accountService.updatePass(email, password);

                    accountService.send(email, subject, message, "lgsmsvanhsibun@gmail.com", "vanhsibun123");

                    response.sendRedirect(request.getContextPath() + "/login");

                } else {
                    request.setAttribute("emailMessage", "Email kh??ng ????ng!");

                    request.getRequestDispatcher("Customer_LGSMS/view/forgotPassword.jsp").forward(request, response);
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
