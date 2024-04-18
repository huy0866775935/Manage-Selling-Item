package Dal;

import Model.Customer;
import Model.Memberlevel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends DBContext {
    //get all

    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customers c INNER JOIN MemberLevel m ON c.Membership_id = m.Membership_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Memberlevel m = new Memberlevel(rs.getInt("Membership_id"), rs.getString("Membership_name"));
                Customer c = new Customer(rs.getString("Customer_id"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"), rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getInt("Membership_id"), m, rs.getString("Network"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    //check id customer
    public Customer getByCheckIdCustomer(String id) {
        String sql = " SELECT * FROM Customers Where Customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getString("Customer_id"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"), rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getInt("Membership_id"), rs.getString("Network"));
                return c;
            }
        } catch (Exception e) {
        }
        return null;

    }
    
    //paging
       public List<Customer> getListByPage(List<Customer> list, int start, int end){
       ArrayList<Customer> arr = new ArrayList<>();
       for (int i = start; i < end; i++) {
           arr.add(list.get(i));
       }
       return arr;
   }

    //insert into customer
    public void insertCustomer(Customer c) {
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([Customer_id]\n"
                + "           ,[FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Email]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Address]\n"
                + "           ,[DateOfBirth]\n"
                + "           ,[Gender]\n"
                + "           ,[Membership_id])\n"
                + "           ,[Network])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, c.getCustomer_id());
            st.setString(2, c.getFirstname());
            st.setString(3, c.getLastname());
            st.setString(4, c.getEmail());
            st.setString(5, c.getPhonenumber());
            st.setString(6, c.getAddress());
            st.setDate(7, c.getDob());
            st.setString(8, c.getGender());
            st.setInt(9, c.getMembership_id());
            st.setString(10, c.getNetwork());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //delete customer
    public void deleteCustomer(String id) {
        String sql = "DELETE FROM [dbo].[Customers]\n"
                + "      WHERE Customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update customer
    public void updateCustomer(Customer c) {
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [FirstName] = ?\n"
                + "      ,[LastName] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[DateOfBirth] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[Membership_id] = ?\n"
                + " WHERE Customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getFirstname());
            st.setString(2, c.getLastname());
            st.setString(3, c.getEmail());
            st.setString(4, c.getPhonenumber());
            st.setString(5, c.getAddress());
            st.setDate(6, c.getDob());
            st.setString(7, c.getGender());
            st.setInt(8, c.getMembership_id());
            st.setString(9, c.getCustomer_id());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    //select gender
    public List<String> getSelectGender(){
        String sql = "SELECT DISTINCT  Gender FROM Customers";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String gender = rs.getString("Gender");
                list.add(gender);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }


    public static void main(String[] args) {
        CustomerDao ccdb = new CustomerDao();
        List<Customer> list = ccdb.getAll();

        for (Customer customer : list) {
            System.out.println(customer.toString());
        }

        System.out.println();
        System.out.println();
        System.out.println();

        
    }
}
