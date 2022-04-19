/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.OrderDetail;
import Model.Orders;
import Model.Product;
import Model.ReceiptVoucher;
import Service.OrderService;
import Service.ProductService;
import Service.ReceiptVoucherService;
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
public class TrackOrderController extends HttpServlet {

    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
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
        Account account = (Account) request.getSession().getAttribute("account");

        String url = request.getServletPath();
        switch (url) {
            case "/TrackOrder":
                ArrayList<Orders> listOrder = orderService.getListOrdersByCusId(account.getAccountID());
                request.setAttribute("listOrder", listOrder);
                request.getRequestDispatcher("Customer_LGSMS/view/order_list.jsp").forward(request, response);
                break;

            case "/OrderDetail":
                int orderID = Integer.parseInt(request.getParameter("orderID"));
                Orders order = orderService.getOrderByID(orderID);
                if(order.getOrderStatus() > 0){
                    ReceiptVoucher receiptVoucher = receiptVoucherService.getReceiptVoucherByOrderID(orderID);
                    request.setAttribute("receiptVoucher", receiptVoucher);
                }
                ArrayList<OrderDetail> listOrderDetail = orderService.getOrderDetailByOrderID(orderID);
                request.setAttribute("listOrderDetail", listOrderDetail);
                request.setAttribute("order", order);

                
                request.getRequestDispatcher("Customer_LGSMS/view/order_detail.jsp").forward(request, response);

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
        processRequest(request, response);
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
