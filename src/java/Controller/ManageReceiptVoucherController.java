package Controller;

import Model.Account;
import Model.Orders;
import Model.ReceiptVoucher;
import Service.OrderService;
import Service.ReceiptVoucherService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dat Nguyen
 */
public class ManageReceiptVoucherController extends HttpServlet {

    ReceiptVoucherService receiptVoucherService = new ReceiptVoucherService();

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
            case "/ManageReceiptVoucher": {
                if (acc.getRole().getRoleID() == 2 || acc.getRole().getRoleName() == "Quản lý") {
                    ArrayList<ReceiptVoucher> listReceiptVoucher = receiptVoucherService.getAllReceiptVoucher();
                    request.setAttribute("listReceiptVoucher", listReceiptVoucher);
                    request.getRequestDispatcher("Staff_LGSMS/view/manager_view_voucher.jsp").forward(request, response);
                } else {
                    ArrayList<ReceiptVoucher> listReceiptVoucher = receiptVoucherService.getAllReceiptVoucherByStaffID();
                    request.setAttribute("listReceiptVoucher", listReceiptVoucher);
                    request.getRequestDispatcher("Staff_LGSMS/view/business_manage_voucher.jsp").forward(request, response);
                }
                break;
            }
            case "/ReceiptInfo": {
                int receiptID = Integer.parseInt(request.getParameter("id").trim());
                ReceiptVoucher receiptVoucher = receiptVoucherService.getReceiptVoucherByID(receiptID);
                Orders order = new OrderService().getOrderByID(receiptVoucher.getOrderID());
                String orderCode = order.getOrderCode();
                double orderTotalMoney = order.getTotalPrice();
                request.setAttribute("receiptVoucher", receiptVoucher);
                request.setAttribute("orderCode", orderCode);
                request.setAttribute("orderTotalMoney", orderTotalMoney);
                if (acc.getRole().getRoleID() == 2 || acc.getRole().getRoleName() == "Quản lý") {
                    request.getRequestDispatcher("Staff_LGSMS/view/manager_view_infomation_voucher.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/business_information_voucher.jsp").forward(request, response);
                }
                break;
            }
            case "/ReceiptInfoByOrderID": {
                int orderID = Integer.parseInt(request.getParameter("id").trim());
                ReceiptVoucher receiptVoucher = receiptVoucherService.getReceiptVoucherByOrderID(orderID);
                Orders order = new OrderService().getOrderByID(orderID);
                String orderCode = order.getOrderCode();
                double orderTotalMoney = order.getTotalPrice();
                request.setAttribute("receiptVoucher", receiptVoucher);
                request.setAttribute("orderCode", orderCode);
                request.setAttribute("orderTotalMoney", orderTotalMoney);
                if (acc.getRole().getRoleID() == 2 || acc.getRole().getRoleName() == "Quản lý") {
                    request.getRequestDispatcher("Staff_LGSMS/view/manager_view_infomation_voucher.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/business_information_voucher.jsp").forward(request, response);
                }
                break;
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
        request.setCharacterEncoding("UTF-8");

        String url = request.getServletPath();
        switch (url) {
            case "/UpdateReceipt": //Update receipt voucher
                double deposit = Double.parseDouble(request.getParameter("deposit"));
                int receiptID = Integer.parseInt(request.getParameter("receipt-id"));
                int receiptStatus = Integer.parseInt(request.getParameter("receipt-status"));
                String note = request.getParameter("note");
                double totalMoney = Double.parseDouble(request.getParameter("total-money"));
                if (receiptVoucherService.updateReceiptVoucher(receiptID, receiptStatus, deposit, note, totalMoney)) {
                    response.sendRedirect(request.getContextPath() + "/ReceiptInfo?id=" + receiptID);
                } else {
                    System.out.println("sssssssssssssssssssssssssssssssssss");
                }
                break;
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
