/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Model.Provider;
import Service.ProductService;
import Service.ProviderService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dat Nguyen
 */
public class ManageProductController extends HttpServlet {

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO = Charset.forName("ISO-8859-1");
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
        ArrayList<Product> listProduct = productService.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("Staff_LGSMS/view/manager_manage_product.jsp").forward(request, response);
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
        ArrayList<Provider> listProvider = new ProviderService().getAllProvider();
        request.setAttribute("listProvider", listProvider);
        String url = request.getServletPath();
        switch (url) {
            case "/ManageProduct":
                ArrayList<Product> listProduct = productService.getAllProduct();
                request.setAttribute("listProduct", listProduct);
                request.getRequestDispatcher("Staff_LGSMS/view/manager_manage_product.jsp").forward(request, response);
                break;
            case "/ProductInformation":
                int productID = Integer.parseInt(request.getParameter("productID"));
                Product product = productService.getProductByID(productID);
                request.setAttribute("product", product);
                request.getRequestDispatcher("Staff_LGSMS/view/manager_infomation_product.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        switch (url) {
            case "/AddProduct": {
                try {
                    // Parse the request
                    List<FileItem> items = upload.parseRequest(request);
                    // Process the uploaded items
                    Iterator<FileItem> iter = items.iterator();
                    
                    String productName = "";
                    int productQuantity = 0;
                    double productPrice = 0;
                    String productDescription = "";
                    int providerID = 0;
                    while(iter.hasNext()){
                        FileItem item = iter.next();
                        if (!item.isFormField()) {
                            //Process uploaded file
                        }else{
                            //Process form field
                            switch(item.getFieldName()){
                                case "product-name":
                                    productName = new String(item.getString().getBytes(ISO), UTF_8);
                                    break;
                                case "product-quantity":
                                    productQuantity = Integer.parseInt(item.getString().trim());
                                    break;
                                case "product-price":
                                    productPrice = Double.parseDouble(item.getString().trim());
                                    break;
                                case "product-des":
                                    productDescription = new String(item.getString().getBytes(ISO), UTF_8);
                                    break;
                                case "provider-id":
                                    providerID = Integer.parseInt(item.getString().trim());
                                    break;
                                    
                            }
                        }
                    }
                } catch (FileUploadException ex) {
                    Logger.getLogger(ManageProductController.class.getName()).log(Level.SEVERE, null, ex);
                }

                String productName = request.getParameter("product-name");
                int productImage = 1; //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                int productQuantity = Integer.parseInt(request.getParameter("product-quantity"));
                double productPrice = Double.parseDouble(request.getParameter("product-price"));
                String productDescription = request.getParameter("product-des");
                int providerID = Integer.parseInt(request.getParameter("provider-id"));
                if (productService.addNewProductToDB(productName, productImage,
                        productQuantity, productPrice, productDescription, providerID)) {
                    response.sendRedirect(request.getContextPath() + "/ManageProduct");
                } else {
                    //Add failed
                    System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
                break;
            }
            case "/EditProduct": {
                int productID = Integer.parseInt(request.getParameter("productID"));
                String productName = request.getParameter("productName");
                int providerID = Integer.parseInt(request.getParameter("providerID"));
                int image = 1;
                double productPrice = Double.parseDouble(request.getParameter("productPrice"));
                boolean productStatus = Boolean.valueOf(request.getParameter("productStatus"));
                String productDescription = request.getParameter("productDescription");
                if (productService.updateProduct(productID, productName,
                        providerID, image, productPrice,
                        productStatus, productDescription)) {
                    response.sendRedirect(request.getContextPath() + "/ManageProduct");
                } else {
                    //Update failed
                    System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                }
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
