/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.BookShop.PlaceOrder.model;

/**
 *
 * @author Ravishka Chandimal
 */
public class ItemOrder {

    private String itemId;
    private String OrderId;
    private int QTY;
    private double total;
    private int discount;

    public ItemOrder() {
    }

    public ItemOrder(String itemId, String OrderId, int QTY, double total, int discount) {
        this.itemId = itemId;
        this.OrderId = OrderId;
        this.QTY = QTY;
        this.total = total;
        this.discount = discount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ItemOrder{" + "itemId=" + itemId + ", OrderId=" + OrderId + ", QTY=" + QTY + ", total=" + total + ", discount=" + discount + '}';
    }
    

}