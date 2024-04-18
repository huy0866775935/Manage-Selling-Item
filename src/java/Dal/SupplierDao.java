
package Dal;

import Model.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SupplierDao extends DBContext {

    //Select all
    public List<Supplier> getAll() {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT TOP (1000) [Supplier_id]\n"
                + "      ,[Supplier_name]\n"
                + "      ,[Address]\n"
                + "      ,[Phone]\n"
                + "      ,[City]\n"
                + "  FROM [Assgin_PRJ301].[dbo].[Supplier]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSup_id(rs.getString("Supplier_id"));
                s.setSup_name(rs.getString("Supplier_name"));
                s.setAddress(rs.getString("Address"));
                s.setPhone(rs.getString("Phone"));
                s.setCity(rs.getString("City"));
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;

    }

    //select suppliername
    public List<String> getAllUnit() {
        List<String> list = new ArrayList<>();
        String sql = "  SELECT Supplier_name FROM Supplier";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String supname = rs.getString("Supplier_name");
                list.add(supname);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //paging
    public List<Supplier> getListByPage(List<Supplier> list, int start, int end) {
        ArrayList<Supplier> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    //check id
    public Supplier getBySupplierId(String id) {
        String sql = "SELECT * FROM Supplier Where Supplier_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Supplier s = new Supplier(rs.getString("Supplier_id"), rs.getString("Supplier_name"), rs.getString("Address"), rs.getString("Phone"), rs.getString("City"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    //insert into

    public void insertSupplier(Supplier s) {
        String sql = "INSERT INTO [dbo].[Supplier]\n"
                + "           ([Supplier_id]\n"
                + "           ,[Supplier_name]\n"
                + "           ,[Address]\n"
                + "           ,[Phone]\n"
                + "           ,[City])\n"
                + "     VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSup_id());
            st.setString(2, s.getSup_name());
            st.setString(3, s.getAddress());
            st.setString(4, s.getPhone());
            st.setString(5, s.getCity());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //delete 

    public void deleteSupplier(String id) {
        String sql = "DELETE FROM [dbo].[Supplier]\n"
                + "      WHERE Supplier_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //update

    public void updateSuplier(Supplier s) {
        String sql = "UPDATE [dbo].[Supplier]\n"
                + "   SET [Supplier_name] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[City] = ?\n"
                + " WHERE Supplier_id = ?";
        try {
            PreparedStatement st =  connection.prepareStatement(sql);
            st.setString(1, s.getSup_name());
            st.setString(2, s.getAddress());
            st.setString(3, s.getPhone());
            st.setString(4, s.getCity());
            st.setString(5, s.getSup_id());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SupplierDao sdb = new SupplierDao();
//        List<Supplier> list = sdb.getAll();
//        for (Supplier supplier : list) {
//            System.out.println(supplier.toString());
//        }
        List<String> lst = sdb.getAllUnit();
        for (String string : lst) {
            System.out.println(string.trim());
        }

    }
}
