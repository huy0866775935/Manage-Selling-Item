/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int orderid;
    private String customerid;
    private Date orderdate;
    private Date shipdate;
    private String address;
    private String shipcity;
    Customer c;
    private float total;
    public Order() {
    }

    public Order(Date orderdate, float total) {
        this.orderdate = orderdate;
        this.total = total;
    }

    
    
    public Order(int orderid, String customerid, Date orderdate, Date shipdate, String address, String shipcity) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.orderdate = orderdate;
        this.shipdate = shipdate;
        this.address = address;
        this.shipcity = shipcity;
    }

    public Order(int orderid, Date orderdate) {
        this.orderid = orderid;
        this.orderdate = orderdate;
    }

    public Order(int orderid, String customerid, Date orderdate, Date shipdate, String address, String shipcity, float total) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.orderdate = orderdate;
        this.shipdate = shipdate;
        this.address = address;
        this.shipcity = shipcity;
        this.total = total;
    }
    
    
    

    public Order(int orderid, String customerid, Date orderdate, Date shipdate, String address, String shipcity, Customer c) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.orderdate = orderdate;
        this.shipdate = shipdate;
        this.address = address;
        this.shipcity = shipcity;
        this.c = c;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", customerid=" + customerid + ", orderdate=" + orderdate + ", shipdate=" + shipdate + ", address=" + address + ", shipcity=" + shipcity + ", c=" + c + '}';
    }

   
    
    
}
