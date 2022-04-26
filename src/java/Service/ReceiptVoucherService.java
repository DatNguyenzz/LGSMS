package Service;

import DAO.OrderDAO;
import DAO.ReceiptVoucherDAO;
import Model.Orders;
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
    
    //Create new receipt voucher when staff accept a new order
    public boolean creatNewReceiptVoucher(int orderID, int staffID){
        //Get order to get customer info and total money
        Orders order = new OrderDAO().getOrderById(orderID);
        ReceiptVoucher receiptVoucher = new ReceiptVoucher();
        receiptVoucher.setOrderID(orderID);
        receiptVoucher.setBussinessStaffID(staffID);
        receiptVoucher.setTotalMoney(order.getTotalPrice());
        receiptVoucher.setCustomerName(order.getCustomerName());
        //Set deposit as defaul 0
        receiptVoucher.setDeposit(0);
        return (receiptVoucherDAO.addNewReceiptVoucher(receiptVoucher) != 0);
    }

    public ReceiptVoucher getReceiptVoucherByID(int receiptID) {
        return receiptVoucherDAO.getReceiptVoucherByID(receiptID);
    }

    public boolean updateReceiptVoucher(int receiptID, int receiptStatus, double deposit, String note, double totalMoney) {
        ReceiptVoucher receiptVoucher = new ReceiptVoucher();
        receiptVoucher.setReceiptID(receiptID);
        receiptVoucher.setStatus(receiptStatus);
        receiptVoucher.setDeposit(deposit);
        receiptVoucher.setNote(note);
        receiptVoucher.setTotalMoney(totalMoney);
        return (receiptVoucherDAO.updateReceiptVoucher(receiptVoucher) != 0);
    }

    public ReceiptVoucher getReceiptVoucherByOrderID(int orderID) {
        return receiptVoucherDAO.getReceiptVoucherByOrderID(orderID);
    }

    public ArrayList<ReceiptVoucher> getAllReceiptVoucherByStaffID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}