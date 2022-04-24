/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ShoppingCartDAO;
import Model.Product;
import Model.ShoppingCart;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ShoppingCartService {

    ShoppingCartDAO cartDao = new ShoppingCartDAO();

    public ArrayList<ShoppingCart> getCartByCusID(int id) {
        return cartDao.getCartByIdCustomer(id);
    }

    public ShoppingCart getProductByCusIdAndProID(int productID, int customerID) {
        return cartDao.getProductByCusIdAndProID(productID, customerID);
    }

    public boolean addProduct(int productID, int customerID) {

        ShoppingCart shoppingCart = cartDao.getProductByCusIdAndProID(productID, customerID);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

            shoppingCart.setCustomerID(customerID);
            shoppingCart.setProductID(productID);
            shoppingCart.setProductQuantity(1);
            int result = cartDao.addNewProductToCart(productID, customerID);
            return (result != 0);
        } else {

            int quantity = shoppingCart.getProductQuantity();
            quantity += 1;
            int result = cartDao.updateProductQuantity(productID, customerID, quantity);
            return (result != 0);
        }
    }

    public boolean isProductExist(int productID, int customerID) {
        return cartDao.isProductExist(customerID, productID);
    }

    public boolean updateQuantityProduct(int productID, int customerID) {
        ShoppingCart shoppingCart = cartDao.getProductByCusIdAndProID(productID, customerID);

        if (shoppingCart != null) {
            int quantity = shoppingCart.getProductQuantity();
            quantity += 1;
            int result = cartDao.updateProductQuantity(productID, customerID, quantity);
            return (result != 0);
        } else {
            return false;
        }
    }

    public boolean updateProductQuantityByCartID(int cartID, int quantity) {

        ShoppingCart shoppingCart = cartDao.getProductByCartID(cartID);

        if (shoppingCart != null) {
            int quantityCart = shoppingCart.getProductQuantity();
            quantityCart += quantity;

            if (quantityCart != 0) {
                int result = cartDao.updateProductQuantityByCartID(cartID, quantityCart);
                return (result != 0);
            } else {
                 int result = cartDao.deleteCartByID(cartID);
                 return result!=0;
            }
        } else {
            return false;
        }
    }

    public boolean deleteCartByID(int cartID) {

        ShoppingCart shoppingCart = cartDao.getProductByCartID(cartID);

        if (shoppingCart != null) {

            int result = cartDao.deleteCartByID(cartID);
            return (result != 0);
        } else {
            return false;
        }
    }

    public Double totalPriceInCart(ArrayList<ShoppingCart> cartList) {
        return cartDao.getTotalCartPrice(cartList);
    }

    boolean clearCartForCusByID(int accountID) {
        return (cartDao.deleteCartByCustomerID(accountID)!=0);
    }
}
