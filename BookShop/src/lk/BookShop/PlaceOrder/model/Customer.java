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
public class Customer {
    private String ID;
    private String name;
    private int tel;
    private String address;

    public Customer() {
    }

    public Customer(String ID, String name, int tel, String address) {
        this.ID = ID;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
