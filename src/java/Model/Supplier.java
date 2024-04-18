/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Supplier {
    private String sup_id;
    private String sup_name;
    private String address;
    private String phone;  //10 chu so
    private String city;

    public Supplier() {
    }

    public Supplier(String sup_id, String sup_name, String address, String phone, String city) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

    
    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Supplier{" + "sup_id=" + sup_id + ", sup_name=" + sup_name + ", address=" + address + ", phone=" + phone + ", city=" + city + '}';
    }
    
    
}
