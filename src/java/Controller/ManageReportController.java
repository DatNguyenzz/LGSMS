/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Importation;
import Model.Orders;
import Model.Report;
import Service.ImportationService;
import Service.OrderService;
import Service.ReportService;
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
public class ManageReportController extends HttpServlet {

    ReportService reportService = new ReportService();
    ImportationService importationService = new ImportationService();
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
        response.setContentType("text/html;charset=UTF-8");

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
            case "/ManageReport":
                ArrayList<Report> listRevenues = reportService.getListRevenuesByMonth();
                ArrayList<Report> listCost = reportService.getListCostByMonth();
                ArrayList<Double> listBenefit = reportService.getListBenefitByMonth();
                Report revenuesByMonthNow = reportService.getRevenuesByMonthNow();
                Report revenuesByQuarterNow = reportService.getRevenuesByQuarterNow();
                Report costByQuarterBefore = reportService.getCostByQuarterBefore();
                Report revenuesByQuarterBefore = reportService.getRevenuesByQuarterBefore();
                Report costByQuarterNow = reportService.getCostByQuarterNow();

                request.setAttribute("listRevenues", listRevenues);
                request.setAttribute("listCost", listCost);
                request.setAttribute("revenuesByMonthNow", revenuesByMonthNow);
                request.setAttribute("revenuesByQuarterNow", revenuesByQuarterNow);
                request.setAttribute("listBenefit", listBenefit);
                request.setAttribute("costByQuarterBefore", costByQuarterBefore);
                request.setAttribute("costByQuarterNow", costByQuarterNow);
                request.setAttribute("revenuesByQuarterBefore", revenuesByQuarterBefore);
                request.getRequestDispatcher("Staff_LGSMS/view/revenue_statistic.jsp").forward(request, response);
                break;
            case "/ManageReportProduct":
                ArrayList<Importation> listImport = importationService.getAllImportation();
                request.setAttribute("listImportation", listImport);
                request.getRequestDispatcher("Staff_LGSMS/view/statistic_import.jsp").forward(request, response);
                break;
            case "/ManageReportOrder":
                ArrayList<Orders> listOrder = orderService.getOrderByOrderStatus(3);
                 request.setAttribute("listOrder", listOrder);
                 request.getRequestDispatcher("Staff_LGSMS/view/statistic_order.jsp").forward(request, response);
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
