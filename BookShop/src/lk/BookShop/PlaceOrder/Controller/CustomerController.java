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
import lk.BookShop.PlaceOrder.DBConnection.DBConnection;
import lk.BookShop.PlaceOrder.model.Customer;

/**
 *
 * @author Ravishka Chandimal
 */
public class CustomerController {

    public List<String> LoadAllCustomerIds() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select custid from customer";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery(sql);

        List<String> list = new ArrayList<>();

        while (set.next()) {
           list.add(set.getString(1));

        }

        return list;

    }
    
     public Customer getCustomer(String id) throws ClassNotFoundException, SQLException{
         Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM Customer WHERE custid=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();
        
        if (set.next()) {
            return new Customer(
                    set.getString("custId"),
                    set.getString("custname"),
                    set.getInt("tel"),
                    set.getString("address")
            );
        }
        
        return null;
    }

}
