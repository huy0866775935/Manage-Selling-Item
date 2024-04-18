/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Orderdetail {
    private int idod;
    private int orderid;
    private String product_id;;
    private int quantity;
    private float price;        
    private float discoust;         
    private int user_id;
    Order o ;
    Product p;
    public Orderdetail() {
    }

    public Orderdetail(int quantity, Product p) {
        this.quantity = quantity;
        this.p = p;
    }

    public Orderdetail(int idod, int orderid, String product_id, int quantity, float price, float discoust, int user_id) {
        this.idod = idod;
        this.orderid = orderid;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.discoust = discoust;
        this.user_id = user_id;
    }

    public Orderdetail(int idod, int orderid, String product_id, int quantity, float price, float discoust, int user_id, Order o) {
        this.idod = idod;
        this.orderid = orderid;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.discoust = discoust;
        this.user_id = user_id;
        this.o = o;
    }

    public Orderdetail(int idod, int orderid, String product_id, int quantity, float price, float discoust, int user_id, Product p) {
        this.idod = idod;
        this.orderid = orderid;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.discoust = discoust;
        this.user_id = user_id;
        this.p = p;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }
    
    

    public Order getO() {
        return o;
    }

    public void setO(Order o) {
        this.o = o;
    }

    
    public int getIdod() {
        return idod;
    }

    public void setIdod(int idod) {
        this.idod = idod;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscoust() {
        return discoust;
    }

    public void setDiscoust(float discoust) {
        this.discoust = discoust;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Orderdetail{" + "idod=" + idod + ", orderid=" + orderid + ", product_id=" + product_id + ", quantity=" + quantity + ", price=" + price + ", discoust=" + discoust + ", user_id=" + user_id + '}';
    }
    
    
}
