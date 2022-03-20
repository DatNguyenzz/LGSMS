/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dat Nguyen
 */
public class OrderDetail {
    private int orderDetailID;
    private int orderID;
    private int productID;
    private int productQuantity;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailID, int orderID, int productID, int productQuantity, double price) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.productQuantity = productQuantity;
        this.price = price;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
