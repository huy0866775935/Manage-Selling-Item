/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Users;

/**
 *
 * @author Admin
 */
public class UsersDao extends DBContext {

    //getAll
    public List<Users> getAll() {
        List<Users> list = new ArrayList<>();
        String sql = "SELECT[User_id]\n"
                + "      ,[Displayname]\n"
                + "      ,[FullName]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Status]\n"
                + "      ,[Address]\n"
                + "      ,[Email]\n"
                + "      ,[Phone]\n"
                + "      ,[Role]\n"
                + "      ,[Admin_userid]\n"
                + "  FROM [Assgin_PRJ301].[dbo].[Users]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Users u = new Users();
                u.setUser_id(rs.getInt("User_id"));
                u.setDisplayname(rs.getString("Displayname"));
                u.setFullname(rs.getString("FullName"));
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setStatus(rs.getBoolean("Status"));
                u.setAddress(rs.getString("Address"));
                u.setPhone(rs.getString("Phone"));
                u.setEmail(rs.getString("Email"));
                u.setRole(rs.getString("Role"));
                u.setManager_user(rs.getInt("Admin_userid"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //check username & password
    public Users getCheckAccount(String user, String pass) {
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Users u = new Users(rs.getInt("User_id"), rs.getString("Displayname"), rs.getString("FullName"), rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Status"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Role"), rs.getInt("Admin_userid"));
                return u;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    //getname
    public Users getByCheckGmail(String name) {
        String sql = "SELECT * FROM Users Where Email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Users u = new Users(rs.getInt("User_id"), rs.getString("Displayname"), rs.getString("FullName"), rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Status"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Role"), rs.getInt("Admin_userid"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    //update password follow user_id
    public void updatePass(int id, String pass) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [Password] = ?\n"
                + " WHERE User_id = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //check role 
    

    //insert 
    //delete
    //update
    
    //count account
    public  int countAccount(){
        String sql ="SELECT COUNT(*) As count FROM Users u WHERE Status = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               return rs.getInt("count");
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public Users updatePasswordFollowEmail(String email) {
        return null;
    }

    public static void main(String[] args) {
        UsersDao udb = new UsersDao();
        List<Users> list = udb.getAll();
        for (Users users : list) {
            System.out.println(users.toString());
        }
    }

}
