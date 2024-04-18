/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Users {
    private int user_id;
    private String displayname;
    private String fullname;
    private String username;
    private String password;
    private boolean status;
    private String address;
    private String email;
    private String phone;
    private String role;
    private int manager_user;

    public Users() {
    }

    public Users(int user_id, String displayname, String fullname, String address, String email, String phone, String role, int manager_user) {
        this.user_id = user_id;
        this.displayname = displayname;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.manager_user = manager_user;
    }

    public Users(int user_id, String displayname, String fullname, String username, String password, boolean status, String address, String email, String phone, String role, int manager_user) {
        this.user_id = user_id;
        this.displayname = displayname;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.status = status;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.manager_user = manager_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    public Users(String role) {
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getManager_user() {
        return manager_user;
    }

    public void setManager_user(int manager_user) {
        this.manager_user = manager_user;
    }

    @Override
    public String toString() {
        return "Users{" + "user_id=" + user_id + ", displayname=" + displayname + ", fullname=" + fullname + ", address=" + address + ", email=" + email + ", phone=" + phone + ", role=" + role + ", manager_user=" + manager_user + '}';
    }
    
    
}
