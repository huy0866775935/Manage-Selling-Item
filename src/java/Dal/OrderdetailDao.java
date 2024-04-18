/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;
import Model.Orderdetail;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderdetailDao extends DBContext {

    //getAll
    public List<Orderdetail> getAll() {
        List<Orderdetail> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[Order_id]\n"
                + "      ,[Product_id]\n"
                + "      ,[Quantity]\n"
                + "      ,[Price]\n"
                + "      ,[Discount]\n"
                + "      ,[User_id]\n"
                + "  FROM [Assgin_PRJ301].[dbo].[Order detail]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Orderdetail od = new Orderdetail(rs.getInt("id"), rs.getInt("Order_id"), rs.getString("Product_id"), rs.getInt("Quantity"), rs.getFloat("Price"), rs.getFloat("Discount"), rs.getInt("User_id"));
                list.add(od);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //join 2 table orderdetail and product
    public List<Orderdetail> getTwotableOdandP(int oid) {
        List<Orderdetail> list = new ArrayList<>();
        String sql = "SELECT od.*,p.Product_name,p.photo,p.Price FROM [Order detail] od INNER JOIN Product p ON od.Product_id = p.Product_id Where od.Order_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, oid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("Product_name"), rs.getString("photo"), rs.getFloat("Price"));
                Orderdetail od = new Orderdetail(rs.getInt("id"), rs.getInt("Order_id"), rs.getString("Product_id"), rs.getInt("Quantity"), rs.getFloat("Price"), rs.getFloat("Discount"), rs.getInt("User_id"), p);
                list.add(od);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    //top 10 product 
    public List<Orderdetail> top10product() {
        String sql = "SELECT TOP(10) p.Product_id,p.Product_name, od.*  FROM [Order detail] od RIGHT JOIN Product p ON od.Product_id = p.Product_id ORDER BY od.Quantity DESC";
        List<Orderdetail> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString("Product_id"), rs.getString("Product_name"));
                Orderdetail od = new Orderdetail(rs.getInt("id"), rs.getInt("Order_id"), rs.getString("Product_id"), rs.getInt("Quantity"), rs.getFloat("Price"), rs.getFloat("Discount"), rs.getInt("User_id"), p);
                list.add(od);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        OrderdetailDao oddb = new OrderdetailDao();
        List<Orderdetail> list = oddb.top10product();
        for (Orderdetail orderdetail : list) {
            System.out.println(orderdetail.getProduct_id());
        }
    }

}
