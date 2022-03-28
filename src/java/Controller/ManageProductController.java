/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Service.ProductService;
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
        String url = request.getServletPath();
        switch (url) {
            case "/ManageProduct":
                ArrayList<Product> listProduct = productService.getAllProduct();
                request.setAttribute("listProduct", listProduct);
                request.getRequestDispatcher("view/manager_manage_product.jsp").forward(request, response);
                break;
            case "/ProductInformation":
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = productService.getProductByID(productID);
                request.setAttribute("product", product);
                request.getRequestDispatcher("view/manager_infomation_product.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getServletPath();
        switch (url) {
            case "/AddProduct": {
                String productName = request.getParameter("product-name");
                int productImage = 1; //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                int productQuantity = Integer.parseInt(request.getParameter("product-quantity"));
                double productPrice = Double.parseDouble(request.getParameter("product-price"));
                String productDescription = request.getParameter("product-des");
                if (productService.addNewProductToDB(productName, productImage, 
                        productQuantity, productPrice, productDescription)) {
                    response.sendRedirect(request.getContextPath() + "/ManageProduct");
                } else {
                    //Add failed
                    System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
                break;
            }
            case "/EditProduct":{
                int productID = Integer.parseInt(request.getParameter("productID"));
                String productName = request.getParameter("productName");
                int providerID = Integer.parseInt(request.getParameter("providerID"));
                int image = 1;
                double productPrice = Double.parseDouble(request.getParameter("productPrice"));
                boolean productStatus = Boolean.valueOf(request.getParameter("productStatus"));
                String productDescription = request.getParameter("productDescription");
                if(productService.updateProduct(productID, productName, 
                        providerID, image, productPrice, 
                        productStatus, productDescription)){
                    response.sendRedirect(request.getContextPath() + "/ManageProduct");
                }else{
                    //Update failed
                    System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
            }
        }

//        long millis=System.currentTimeMillis();
//        Date productCreatedAt = new java.sql.Date(millis);
//        Product product = new Product();
//        product.setProductName(productName);
//        product.setProductImage(productImage);
//        product.setProductInstock(productQuantity);
//        product.setProductInuse(0);
//        product.setProductPrice(productPrice);
//        product.setProductDescription(productDescription);
//        product.setProductCreatedAt(productCreatedAt);
//        product.setIsActive(true);
//        if(productService.addNewProductToDB(product)){
//            //Add success
//            response.sendRedirect(request.getContextPath()+"/ManageProduct");
//        }else{
//            //Add failed
//            System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        }
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
