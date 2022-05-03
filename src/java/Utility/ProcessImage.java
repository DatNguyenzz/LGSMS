/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author dat19
 */
public class ProcessImage {
    public final static String USER_IMAGE_PATH = "/Assets/images/avatar";
    public final static String PRODUCT_IMAGE_PATH = "/Assets/images/product";

    public String storeUserImage(FileItem item, ServletContext servletContext, String username) {
        try {
            String storePath = servletContext.getRealPath(USER_IMAGE_PATH);
            File uploadFile = new File(storePath + File.separator
                    + "avatar_image_" + username
                    + item.getContentType().replaceFirst("image/", "."));
            if (uploadFile.exists()) {
                uploadFile.delete();
            }
            item.write(uploadFile);
            String imagePath = USER_IMAGE_PATH
                    + "avatar_image_" + username
                    + item.getContentType().replaceFirst("image/", ".");
            return imagePath;
        } catch (Exception ex) {
            Logger.getLogger(ProcessImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
