/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderDAO;
import Model.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
<<<<<<< Updated upstream
=======
import java.util.List;
import java.util.ListIterator;
>>>>>>> Stashed changes
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class ManageOrderController extends HttpServlet {
    OrderDAO orderDao= new OrderDAO();
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
        processRequest(request, response);       
        response.setContentType("text/html;charset=UTF-8");
<<<<<<< Updated upstream
        String url = request.getServletPath();
         
        ArrayList<Orders> listNewOrder;
        if (url.equals("/ManageNewOrder")) {
            listNewOrder= orderDao.getOrderByOrderStatus(0);
            request.setAttribute("listOrder", listNewOrder);
            request.getRequestDispatcher("view/business_new_order.jsp").forward(request, response);
=======
         Orders orderInfor= new Orders();
     
        String url = request.getServletPath();
       
        
         
        ArrayList<Orders> listNewOrder;
        if (url.equals("/ManageNewOrder")) {
            
            
            listNewOrder= orderDao.getOrderByOrderStatus(0);
            request.setAttribute("listOrder", listNewOrder);       
            request.getRequestDispatcher("view/business_new_order.jsp").forward(request, response);
            
            
             int orderId = Integer.parseInt(request.getParameter("id"));
             int orderStatus =  Integer.parseInt(request.getParameter("statusOrder"));
             int result=0;
             
                 orderInfor.setOrderStatus(orderStatus);
                 orderInfor.setOrderID(orderId);
                 result=orderDao.updateOrderStatus(orderInfor);
               if (result != 0) {
                response.sendRedirect(request.getContextPath() + "/ManageNewOrder");
            } else {
                response.sendRedirect("123123");
            }
               
               
>>>>>>> Stashed changes
        } else if(url.equals("/ManageCancelOrder")){
            listNewOrder= orderDao.getOrderByOrderStatus(4);
            request.setAttribute("listOrder", listNewOrder);
            request.getRequestDispatcher("view/business_reject_order.jsp").forward(request, response);
        } else if(url.equals("/ManageAcceptOrder")){
<<<<<<< Updated upstream
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(3);
            list.add(2);
            Iterator<Integer> iterator = list.iterator();
            listNewOrder= orderDao.getOrderByOrderStatus(iterator.next());
            request.setAttribute("listOrder", listNewOrder);
            request.getRequestDispatcher("view/business_accept_order.jsp").forward(request, response);
=======
//            ArrayList<Integer> list = new ArrayList<Integer>();
//            list.add(3);
//            list.add(1);
//            list.add(2);
//            Iterator<Integer> iterator = list.iterator();
//            listNewOrder= orderDao.getOrderByOrderStatus(iterator.next());
//            request.setAttribute("listOrder", listNewOrder);
//            request.getRequestDispatcher("view/business_accept_order.jsp").forward(request, response);
            
            
            
            
                listNewOrder= orderDao.getOrderByOrderStatus(1);
                 request.setAttribute("listOrder", listNewOrder);
          
             request.getRequestDispatcher("view/business_accept_order.jsp").forward(request, response);
            
        } else if(url.equals("/ViewDetailOrder")){
            int orderId = Integer.parseInt(request.getParameter("id"));
            orderInfor = orderDao.getOrderById(orderId);
            
            request.setAttribute("orderInfor", orderInfor);
            request.getRequestDispatcher("view/business_information_order.jsp").forward(request, response);
>>>>>>> Stashed changes
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
