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
public class Item {
     private String itemId;
     private String ItemName;
     private int ItemQTY;
     private String itemDate;
     private String Descr;
     private String Brand;
     private Double unitPrice;

    public Item() {
    }

    public Item(String itemId, String ItemName, int ItemQTY, String itemDate, String Descr, String Brand, Double unitPrice) {
        this.itemId = itemId;
        this.ItemName = ItemName;
        this.ItemQTY = ItemQTY;
        this.itemDate = itemDate;
        this.Descr = Descr;
        this.Brand = Brand;
        this.unitPrice = unitPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public int getItemQTY() {
        return ItemQTY;
    }

    public void setItemQTY(int ItemQTY) {
        this.ItemQTY = ItemQTY;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String Descr) {
        this.Descr = Descr;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", ItemName=" + ItemName + ", ItemQTY=" + ItemQTY + ", itemDate=" + itemDate + ", Descr=" + Descr + ", Brand=" + Brand + ", unitPrice=" + unitPrice + '}';
    }
     
}