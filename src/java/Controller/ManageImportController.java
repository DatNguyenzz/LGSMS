package Controller;

import Model.Account;
import Model.Importation;
import Model.Product;
import Model.Provider;
import Service.ImportationService;
import Service.ProductService;
import Service.ProviderService;
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
public class ManageImportController extends HttpServlet {

    ImportationService importationService = new ImportationService();

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

        ArrayList<Importation> listImport = importationService.getAllImportation();
        ArrayList<Product> listProduct = new ProductService().getAllProduct();
        ArrayList<Provider> listProvider = new ProviderService().getAllProvider();

        request.setAttribute("listImportation", listImport);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listProvider", listProvider);
        request.getRequestDispatcher("view/business_manage_import.jsp").forward(request, response);
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
        int productID = Integer.parseInt(request.getParameter("product-id"));
        int providerID = Integer.parseInt(request.getParameter("provider-id"));
        int productImportQuantity = Integer.parseInt(request.getParameter("product-quantity"));
        double importAmount = Double.parseDouble(request.getParameter("import-amount"));
        String importNote = request.getParameter("import-note");
        Account account = (Account) request.getSession().getAttribute("account");
        if (request.getParameter("import-from-customer") != null) {
            //Import from customer
            if(importationService.importFromCustomer(productID, providerID, 
                    productImportQuantity, importAmount, importNote, account.getAccountID())){
                response.sendRedirect(request.getContextPath() + "/ManageImport");
            }else{
                
            }
        } else {
            //Import from provider
            if(importationService.importFromProvider(productID, providerID, 
                    productImportQuantity, importAmount, importNote, account.getAccountID())){
                response.sendRedirect(request.getContextPath() + "/ManageImport");
            }else{
                
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