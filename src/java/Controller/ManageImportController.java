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

        Account account = (Account) request.getSession().getAttribute("account");
        String url = request.getServletPath();
        switch (url) {
            case "/ManageImport":
                if (account.getRole().getRoleID() == 2 || account.getRole().getRoleName().equalsIgnoreCase("Quản lý")) {
                    //Manage import page for manager
                    ArrayList<Importation> listImport = importationService.getAllImportation();
                    ArrayList<Product> listProduct = new ProductService().getAllProduct();
                    ArrayList<Provider> listProvider = new ProviderService().getAllProvider();
                    request.setAttribute("listImportation", listImport);
                    request.setAttribute("listProduct", listProduct);
                    request.setAttribute("listProvider", listProvider);
                    request.getRequestDispatcher("Staff_LGSMS/view/manager_import_voucher.jsp").forward(request, response);
                } else {
                    //Manage import page for bussiness staff
                    ArrayList<Importation> listImport = importationService.getAllImportationByStaff(account.getAccountID());
                    ArrayList<Product> listProduct = new ProductService().getAllProduct();
                    request.setAttribute("listImport", listImport);
                    request.setAttribute("listProduct", listProduct);
                    request.getRequestDispatcher("Staff_LGSMS/view/business_confirm_import.jsp").forward(request, response);
                }
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
        String url = request.getServletPath();
        switch (url) {
            case "/CreateNewImport": {
                int productID = Integer.parseInt(request.getParameter("product-id"));
                int providerID = Integer.parseInt(request.getParameter("provider-id"));
                int productImportQuantity = Integer.parseInt(request.getParameter("product-quantity"));
                double productImportPrice = Double.parseDouble(request.getParameter("product-import-price"));
                String importNote = request.getParameter("import-note");
                Account account = (Account) request.getSession().getAttribute("account");
                //Import from provider
                if (importationService.createNewImport(productID, providerID,
                        productImportQuantity, productImportPrice, importNote, account.getAccountID())) {
                    response.sendRedirect(request.getContextPath() + "/ManageImport");
                } else {

                }

                break;
            }
            case "/ImportFromCustomer": {
                int productID = Integer.parseInt(request.getParameter("product-id"));
                int productImportQuantity = Integer.parseInt(request.getParameter("product-quantity"));
                String importNote = request.getParameter("import-note");
                Account account = (Account) request.getSession().getAttribute("account");
                if (importationService.importFromCustomer(productID, productImportQuantity,
                        importNote, account.getAccountID())) {
                    response.sendRedirect(request.getContextPath() + "/ManageImport");
                } else {

                }
                break;
            }
            case "/ConfirmNewImport": {
                int importID = Integer.parseInt(request.getParameter("import-id").trim());
                int productImportQuantity = Integer.parseInt(request.getParameter("product-quantity").trim());
                int productImportPrice = Integer.parseInt(request.getParameter("product-price").trim());
                int importStatus = Integer.parseInt(request.getParameter("import-status").trim());
                Account account = (Account) request.getSession().getAttribute("account");
                if(importationService.confirmNewImport(importID, productImportPrice, productImportQuantity, importStatus, account.getAccountID())){
                    response.sendRedirect(request.getContextPath() + "/ManageImport");
                }else{
                    
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
