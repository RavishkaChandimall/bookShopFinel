/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.BookShop.PlaceOrder.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.BookShop.PlaceOrder.DBConnection.DBConnection;
import lk.BookShop.PlaceOrder.model.*;

/**
 *
 * @author Ravishka Chandimal
 */
public class MainFormController {

    public List<String> LoadAllItemIds() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select itemid from item";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery(sql);

        List<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }

        return list;

    }

    public Item getItem(String Id) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * from item where ITEMID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, Id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Item(
                    set.getString("itemid"),
                    set.getString("itemname"),
                    set.getInt("itemQTY"),
                    set.getString("itemDate"),
                    set.getString("descr"),
                    set.getString("brand"),
                    set.getDouble("unitprice")
            );

        }
        return null;

    }

    public String getOrderId() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT orderid FROM Orderdetail ORDER BY orderid DESC LIMIT 1";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    public boolean placeOrder(OrderDetail order) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "insert into orderDetail(OrderId,custId,empId,total) values(?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, order.getOrderId());
            stm.setString(2, order.getCustId());
            stm.setString(3, order.getEmpId());
            stm.setDouble(4, order.getTotal());

            boolean isAdded = stm.executeUpdate() > 0;

            if (isAdded) {
                boolean addItemOrder = addItemOrder(order.getList());
                if (!addItemOrder) {
                } else {
                    boolean isUpdate=new MainFormController().updateQty(order.getList());
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addItemOrder(List<ItemOrder> itemdetail) throws ClassNotFoundException, SQLException {
        for (ItemOrder tem : itemdetail) {
            boolean isAdded = InsertItemOrder(tem);
            if (!isAdded) {
                return false;
            }
        }
        return true;

    }

    public boolean updateQty(List<ItemOrder> list) throws ClassNotFoundException, SQLException {
        for (ItemOrder itemOrder : list) {
            
                PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update item set itemQty=(itemQty-?)where itemid=?");
                stm.setObject(1, itemOrder.getQTY());
                stm.setObject(2, itemOrder.getItemId());
                if(!(stm.executeUpdate()>0)){ return false;}   
        }
        return true;
    }

    public boolean InsertItemOrder(ItemOrder order) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO itemOrder(itemId,OrderId,QTY,total,discount) VALUES(?,?,?,?,?)");
        stm.setObject(1, order.getItemId());
        stm.setObject(2, order.getOrderId());
        stm.setObject(3, order.getQTY());
        stm.setObject(4, order.getTotal());
        stm.setObject(5, order.getDiscount());
        return stm.executeUpdate() > 0;
    }

}
