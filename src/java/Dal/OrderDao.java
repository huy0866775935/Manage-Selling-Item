package Dal;

import Model.Customer;
import Model.Order;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends DBContext {

    //getAll
    public List<Order> getAll() {
        String sql = "SELECT * FROM [Order]";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("Order_id"), rs.getString("Customer_id"), rs.getDate("Orderdate"), rs.getDate("Shipdate"), rs.getString("Address"), rs.getString("Shipcity"));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //JOIN customer and order
    public List<Order> getOrderList() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM [Order] o JOIN Customers c ON o.Customer_id = c.Customer_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer c = new Customer(rs.getString("Customer_id"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"), rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getInt("Membership_id"), rs.getString("Network"));
                Order o = new Order(rs.getInt("Order_id"), rs.getString("Customer_id"), rs.getDate("Orderdate"), rs.getDate("Shipdate"), rs.getString("Address"), rs.getString("Shipcity"), c);
                list.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }

//    //total each
    public Float totalOne(int orid, String ordate) {
        String sql = "SELECT (SUM(Price)-SUM(Discount) )AS total FROM [Order detail] od JOIN [Order] o ON od.Order_id = o.Order_id WHERE od.Order_id = ? AND o.Orderdate = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orid);
            st.setDate(2, Date.valueOf(ordate));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getFloat("total");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    //join customer and order where
    public Order getOrderList(int ordid) {
        String sql = " SELECT * FROM [Order] o JOIN Customers c ON o.Customer_id = c.Customer_id WHERE o.Order_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ordid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getString("Customer_id"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Address"), rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getInt("Membership_id"), rs.getString("Network"));
                Order o = new Order(rs.getInt("Order_id"), rs.getString("Customer_id"), rs.getDate("Orderdate"), rs.getDate("Shipdate"), rs.getString("Address"), rs.getString("Shipcity"), c);
                return o;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //total 
    public List<Order> totalEachOrder() {
        List<Order> list = new ArrayList<>();
        // ko dc
        String sql = "SELECT o.*, (SUM(Price)-SUM(Discount) )AS total FROM [Order detail] od JOIN [Order] o ON od.Order_id = o.Order_id GROUP BY o.Order_id,o.Orderdate,o.Customer_id,o.Shipdate,o.Address,o.Shipcity HAVING  o.Order_id IN(SELECT Order_id  FROM [Order]) AND o.Orderdate IN (SELECT Orderdate FROM [Order])";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("Order_id"), rs.getString("Customer_id"), rs.getDate("Orderdate"), rs.getDate("Shipdate"), rs.getString("Address"), rs.getString("Shipcity"), rs.getFloat("total"));
                list.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }
    
    


//    //total + date
//    public String totalPlusdate() {
//
//        JsonArray js = new JsonArray();
//        String sql = "SELECT o.Orderdate, (SUM(Price)-SUM(Discount) )AS total FROM [Order detail] od JOIN [Order] o ON od.Order_id = o.Order_id GROUP BY o.Order_id,o.Orderdate HAVING  o.Order_id IN(SELECT Order_id  FROM [Order])";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("Orderdate", rs.getString("Orderdate"));
//                jsonObject.addProperty("Income", rs.getFloat("total"));
//                js.add(jsonObject);
//            }
//        } catch (SQLException e) {
//           System.out.println("Error connecting to SQL Server: " + e.getMessage());
//        }
//        String jsonData = new Gson().toJson(js);
//        return jsonData;
//    }

    //paging
    public List<Order> getListByPage(List<Order> list, int start, int end) {
        ArrayList<Order> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    //json chars
    public static void main(String[] args) {
        OrderDao odb = new OrderDao();
        List<Order> list = odb.getAll();
        System.out.println(list.size());


    }
}
