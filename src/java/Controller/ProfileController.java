package Controller;

import Model.Account;
import Service.AccountService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class ProfileController extends HttpServlet {

    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO = Charset.forName("ISO-8859-1");
    AccountService accountService = new AccountService();

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
            case "/MyProfile":
                if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equals("Customer")) {
                    request.getRequestDispatcher("Customer_LGSMS/view/profile.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/staff_view_profile.jsp").forward(request, response);
                }
                break;
            case "/ChangePassword":
                if (acc.getRole().getRoleID() == 4 || acc.getRole().getRoleName().equals("Customer")) {
                    request.getRequestDispatcher("Customer_LGSMS/view/profile_changePassword.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Staff_LGSMS/view/staff_view_profile.jsp").forward(request, response);
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
        Account acc = (Account) request.getSession().getAttribute("account");

        switch (url) {
            case "/MyProfile": {
                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // Configure a repository (to ensure a secure temp location is used)
                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(repository);

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);

                try {
                    // Parse the request
                    List<FileItem> items = upload.parseRequest(request);
                    // Process the uploaded items
                    Iterator<FileItem> iter = items.iterator();
                    String filename = "";
                    String fullname  = acc.getFullname();
                    String phone  = acc.getPhone();
                    String dob  = acc.getDOB().toString();
                    boolean gender = acc.isGender();
                    String address = acc.getAddress();
                    String email = acc.getEmail();
                    String imagePath = acc.getImagePath();
                    while (iter.hasNext()) {
                        FileItem item = iter.next();
                        if (!item.isFormField()) {
                            //Process uploaded file
                            System.out.println("Process uploaded file");
                            filename = item.getName();
                            if (filename == null || filename.equals("")) {
                                break;
                            } else {
                                String storePath = servletContext.getRealPath("/Assets/images/avatar");
                                File uploadFile = new File(storePath + File.separator 
                                        + "avatar_image_" + acc.getUsername() 
                                        + item.getContentType().replaceFirst("image/", ".")); 
                                if(uploadFile.exists()){
                                    uploadFile.delete();
                                }
                                item.write(uploadFile);
                                imagePath = "Assets/images/avatar/" 
                                        + "avatar_image_" + acc.getUsername() 
                                        + item.getContentType().replaceFirst("image/", ".");
                            }
                        } else {
                            //Process form field
                            switch (item.getFieldName()) {
                                case "fullname":
                                    fullname = new String(item.getString().getBytes(ISO), UTF_8);
                                    break;
                                case "phone":
                                    phone = new String(item.getString().getBytes(ISO), UTF_8);
                                    break;
                                case "dob":
                                    dob = new String(item.getString().getBytes(ISO), UTF_8);
                                    break;
                                case "gender":
                                    gender = Boolean.valueOf(item.getString());
                                    break;
                                case "address":
                                    address = new String(item.getString().getBytes(ISO), UTF_8);
                                    break;
                                case "email":
                                    email = item.getString();
                                    break;

                            }
                            System.out.println(item.getFieldName() + "\t" + item.getString());
                        }
                    }
                    if (accountService.updateAccountInProfile(acc.getAccountID(), fullname, phone, 
                            address, dob, gender, email, acc.getRole().getRoleID(), imagePath)) {
                    //Update success 
                    acc = accountService.getAccountByID(acc.getAccountID());
                    request.getSession().setAttribute("account", acc);
                    response.sendRedirect(request.getContextPath() + "/MyProfile");
                } else {
                    //Update fail
                }
                } catch (FileUploadException ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "/ChangePassword": {
                int id = acc.getAccountID();
                String newPassword = request.getParameter("new-password");
                String oldPassword = request.getParameter("old-password");

                if (accountService.changePass(id, oldPassword, newPassword) != 0) {
                    response.sendRedirect(request.getContextPath() + "/MyProfile");
                } else {

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
