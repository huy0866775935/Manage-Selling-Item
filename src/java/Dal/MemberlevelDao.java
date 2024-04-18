/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Memberlevel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MemberlevelDao extends DBContext{
    
    //get All
        //select member_name
    public List<Memberlevel> getAll(){
        String sql = "SELECT * FROM  MemberLevel";
        List<Memberlevel> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Memberlevel ml = new Memberlevel(rs.getInt("Membership_id"), rs.getString("Membership_name"));
                list.add(ml);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    
}
