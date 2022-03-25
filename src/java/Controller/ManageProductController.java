/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Service.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dat Nguyen
 */
public class ManageProductController extends HttpServlet {
    ProductService productService = new ProductService();
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Product> listProduct = productService.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("view/manager_manage_product.jsp").forward(request, response);
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
        String productName = request.getParameter("product-name");
        String productImage = "null";
        int productQuantity = Integer.parseInt(request.getParameter("product-quantity"));
        double productPrice = Double.parseDouble(request.getParameter("product-price"));
        String productDescription = request.getParameter("product-des");
        long millis=System.currentTimeMillis();
        Date productCreatedAt = new java.sql.Date(millis);
        Product product = new Product();
        product.setProductName(productName);
        product.setProductImage(productImage);
        product.setProductInstock(productQuantity);
        product.setProductInuse(0);
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setProductCreatedAt(productCreatedAt);
        product.setIsActive(true);
        if(productService.addNewProductToDB(product)){
            //Add success
            response.sendRedirect(request.getContextPath()+"/ManageProduct");
        }else{
            //Add failed
            System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
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
