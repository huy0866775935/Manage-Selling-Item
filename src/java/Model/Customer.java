
package Model;

import java.io.Serializable;
import java.sql.Date;

public class Customer {
    private String customer_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String address;
    private Date dob;
    private String gender;
    private int membership_id;
    private String network;
    Memberlevel m;

    public Customer() {
    }

    public Customer(String customer_id, String firstname, String lastname, String email, String phonenumber, String address, Date dob, String gender, int membership_id, String network) {
        this.customer_id = customer_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.membership_id = membership_id;
        this.network = network;
    }

    public Customer(String customer_id, String firstname, String lastname, String email, String phonenumber, String address, Date dob, String gender, int membership_id, Memberlevel m) {
        this.customer_id = customer_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.membership_id = membership_id;
        this.m = m;
    }

    public Customer(String customer_id, String firstname, String lastname, String email, String phonenumber, String address, Date dob, String gender, int membership_id,  Memberlevel m,String network) {
        this.customer_id = customer_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.membership_id = membership_id;
        this.m = m;
        this.network = network;
    }

    
    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    
    public Memberlevel getM() {
        return m;
    }

    public void setM(Memberlevel m) {
        this.m = m;
    }
    
    

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        if(gender.equals("female")){
            return gender;
        }
        if(gender.equals("male")){
            return gender;
        }
        return null;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phonenumber=" + phonenumber + ", address=" + address + ", dob=" + dob + ", gender=" + gender + ", membership_id=" + membership_id + '}' + ", network=" + network + '}';
    }
    
    
}
