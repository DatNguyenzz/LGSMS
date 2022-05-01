/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.OrderDetail;
import Model.Orders;
import Service.OrderService;
import java.io.IOException;
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
public class ManageOrderController extends HttpServlet {

    OrderService orderService = new OrderService();

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
        ArrayList<Orders> listOrder;
        Account staffAccount = (Account) request.getSession().getAttribute("account");
        String url = request.getServletPath();
        int orderId = Integer.parseInt(request.getParameter("id"));
        switch (url) {
            case "/ManageNewOrder":
                //Accept new order from new order list
                int orderStatus = Integer.parseInt(request.getParameter("statusOrder"));
                if (orderService.updateOrderStatus(orderId, orderStatus, staffAccount.getAccountID(),"")) {
//                    response.sendRedirect(request.getContextPath() + "/ManageNewOrder");
                    response.sendRedirect(request.getContextPath() + "/ViewDetailOrder?id=" + orderId);
                } else {
                    response.sendRedirect("123123");
                }
                break;
            case "/ViewDetailOrder":
                Orders order = orderService.getOrderByID(orderId);
                ArrayList<OrderDetail> listOrderDetailByOrderID = orderService.getListOrderDetailByOrderID(order.getOrderID());
                request.setAttribute("listOrderDetail", listOrderDetailByOrderID);
                request.setAttribute("orderInfor", order);
                if (staffAccount.getRole().getRoleID() == 2 || staffAccount.getRole().getRoleName().equalsIgnoreCase("Quản lý")) {
                    String staffName = orderService.getStaffNameByOrderID(orderId);
                    request.setAttribute("staffName", staffName);
                    request.getRequestDispatcher("Staff_LGSMS/view/manager_view_infomation_order.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/business_information_order.jsp").forward(request, response);
                }

                break;
        }

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
        Account staffAccount = (Account) request.getSession().getAttribute("account");
        ArrayList<Orders> listOrder;
        String paramId = request.getParameter("id");
        if (paramId != null) {
            processRequest(request, response);
        } else {
            String url = request.getServletPath();
            switch (url) {
                case "/ManageNewOrder":
                    listOrder = orderService.getOrderByOrderStatus(0);
                    request.setAttribute("listOrder", listOrder);
                    request.getRequestDispatcher("Staff_LGSMS/view/business_new_order.jsp").forward(request, response);
                    break;
                case "/ManageCancelOrder":
                    listOrder = orderService.getOrderByStatusAndStaff(4, staffAccount.getAccountID());
                    request.setAttribute("listOrder", listOrder);
                    request.getRequestDispatcher("Staff_LGSMS/view/business_reject_order.jsp").forward(request, response);
                    break;
                case "/ManageAcceptOrder":
                    listOrder = orderService.getAllAcceptedOrderByStaff(staffAccount.getAccountID());
                    request.setAttribute("listOrder", listOrder);
                    request.getRequestDispatcher("Staff_LGSMS/view/business_accept_order.jsp").forward(request, response);
                    break;
                case "/ManageOrder":
                    listOrder = orderService.getAllOrders();
                    request.setAttribute("listOrder", listOrder);
                    request.getRequestDispatcher("Staff_LGSMS/view/manager_view_order.jsp").forward(request, response);
                    break;
            }
        }

//        
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
        int orderID = Integer.parseInt(request.getParameter("orderId").trim());
        String note2 = request.getParameter("order-note2");
        int orderStatus = Integer.parseInt(request.getParameter("order-status").trim());
        if (orderService.updateOrderStatus(orderID, orderStatus, account.getAccountID(), note2)) {
            response.sendRedirect(request.getContextPath() + "/ViewDetailOrder?id=" + orderID);
        } else {
            response.sendRedirect("123123");
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
