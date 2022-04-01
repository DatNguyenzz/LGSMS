package Service;

import DAO.ReceiptVoucherDAO;
import Model.ReceiptVoucher;
import java.util.ArrayList;

/**
 *
 * @author Dat Nguyen
 */
public class ReceiptVoucherService {
    ReceiptVoucherDAO receiptVoucherDAO = new ReceiptVoucherDAO();

    
    public ArrayList<ReceiptVoucher> getAllReceiptVoucher() {
        return receiptVoucherDAO.getAllReceiptVoucher();
    }
    
}