
package lk.BookShop.PlaceOrder.model;

import java.util.List;

/**
 *
 * @author Ravishka Chandimal
 */
public class OrderDetail {

    private String OrderId;
    private String custId;
    private String empId;
    private double total;
    private String OrderDate;
    private List<ItemOrder> list;

    @Override
    public String toString() {
        return "OrderDetail{" + "OrderId=" + OrderId + ", custId=" + custId + ", empId=" + empId + ", total=" + total + ", OrderDate=" + OrderDate + ", list=" + list + '}';
    }

    public OrderDetail(String OrderId, String custId, String empId, double total, String OrderDate, List<ItemOrder> list) {
        this.OrderId = OrderId;
        this.custId = custId;
        this.empId = empId;
        this.total = total;
        this.OrderDate = OrderDate;
        this.list = list;
    }

    public OrderDetail() {
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public List<ItemOrder> getList() {
        return list;
    }

    public void setList(List<ItemOrder> list) {
        this.list = list;
    }

}