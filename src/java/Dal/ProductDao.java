package Dal;

import Model.Category;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends DBContext {

    //select getAll
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getString("Product_id"));
                p.setProduct_name(rs.getNString("Product_name"));
                p.setQuantify(rs.getInt("Quantity"));
                p.setUnit(rs.getString("Unit"));
                p.setStatus(rs.getString("Status"));
                p.setSupplier_id(rs.getString("Supplier_id"));
                p.setDescribe(rs.getString("Describe"));
                p.setPhoto(rs.getString("photo"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreate_at(rs.getDate("Created_at"));
                p.setUpdated_at(rs.getDate("Updated_at"));
                p.setCategory_id(rs.getInt("CategoryID"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    //search
    public List<Product> getAll(String key) {
        List<Product> list = new ArrayList<>();
         //Phần điều kiện WHERE 1 = 1 làm cho truy vấn trở nên linh hoạt hơn.mở rộng bằng cách thêm các điều kiện khác nếu cần thiết, mà không cần phải kiểm tra xem WHERE đã được thêm hay chưa.
        String sql = " SELECT * FROM Product p INNER JOIN Category c ON p.CategoryID = c.CategoryID WHERE 1 = 1";
        if (key != null && !key.equals("")) {
            sql += "AND c.CategoryName LIKE '%" + key + "%' OR p.Product_name LIKE '%" + key + "%'";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getString("Product_id"));
                p.setProduct_name(rs.getString("Product_name"));
                p.setQuantify(rs.getInt("Quantity"));
                p.setUnit(rs.getString("Unit"));
                p.setStatus(rs.getString("Status"));
                p.setSupplier_id(rs.getString("Supplier_id"));
                p.setDescribe(rs.getString("Describe"));
                p.setPhoto(rs.getString("photo"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreate_at(rs.getDate("Created_at"));
                p.setUpdated_at(rs.getDate("Updated_at"));
                p.setCategory_id(rs.getInt("CategoryID"));
                p.setCate(new Category(rs.getInt("CategoryID"), rs.getString("CategoryName")));
                list.add(p);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //select unit
    public List<String> getAllUnit() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DIStinct Unit FROM Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String supname = rs.getString("Unit");
                list.add(supname);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    //select status

    public List<String> getAllStatus() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DIStinct Status FROM Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String staname = rs.getString("Status");
                list.add(staname);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //select following id
    public List<Product> getByProductId(String id) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.Product_id,p.Product_name,p.Quantity,p.Unit,p.Status,p.Supplier_id,p.Describe,p.photo,p.Price,p.Created_at,p.Updated_at,p.CategoryID,c.CategoryID,c.CategoryName "
                + "FROM Product p INNER JOIN Category c ON p.CategoryID = c.CategoryID Where p.Product_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getString("Product_id"));
                p.setProduct_name(rs.getString("Product_name"));
                p.setQuantify(rs.getInt("Quantity"));
                p.setUnit(rs.getString("Unit"));
                p.setStatus(rs.getString("Status"));
                p.setSupplier_id(rs.getString("Supplier_id"));
                p.setDescribe(rs.getString("Describe"));
                p.setPhoto(rs.getString("photo"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreate_at(rs.getDate("Created_at"));
                p.setUpdated_at(rs.getDate("Updated_at"));
                p.setCategory_id(rs.getInt("CategoryID"));
                p.setCate(new Category(rs.getInt("CategoryID"), rs.getString("CategoryName")));
                list.add(p);
                return list;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    //paging
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    //insert product
    public void Insertproduct(Product p) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([Product_id]\n"
                + "           ,[Product_name]\n"
                + "           ,[Quantity]\n"
                + "           ,[Unit]\n"
                + "           ,[Status]\n"
                + "           ,[Supplier_id]\n"
                + "           ,[Describe]\n"
                + "           ,[photo]\n"
                + "           ,[Price]\n"
                + "           ,[CategoryID])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, p.getProduct_id());
            st.setString(2, p.getProduct_name());
            st.setInt(3, p.getQuantify());
            st.setString(4, p.getUnit());
            st.setString(5, p.getStatus());
            st.setString(6, p.getSupplier_id());
            st.setString(7, p.getDescribe());
            st.setString(8, p.getPhoto());
            st.setFloat(9, p.getPrice());
            st.setInt(10, p.getCategory_id());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //check id
    public Product getCheckIdProduct(String id) {
        String sql = " SELECT * FROM Product WHERE Product_id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getString("Product_id"));
                p.setProduct_name(rs.getString("Product_name"));
                p.setQuantify(rs.getInt("Quantity"));
                p.setStatus(rs.getString("Status"));
                p.setSupplier_id(rs.getString("Supplier_id"));
                p.setDescribe(rs.getString("Describe"));
                p.setPhoto(rs.getString("photo"));
                p.setPrice(rs.getFloat("Price"));
                p.setCreate_at(rs.getDate("Created_at"));
                p.setUpdated_at(rs.getDate("Updated_at"));
                p.setCategory_id(rs.getInt("CategoryID"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //delete product following id
    public void deleteProduct(String id) {
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE Product_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update product
    public void updateProduct(Product p) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [Product_name] = ?"
                + "      ,[Quantity] = ?"
                + "      ,[Unit] = ?"
                + "      ,[Status] = ?"
                + "      ,[Supplier_id] = ?"
                + "      ,[Describe] = ?"
                + "      ,[photo] = ?"
                + "      ,[Price] = ?"
                + "      ,[Updated_at] = ?"
                + "      ,[CategoryID] = ?"
                + " WHERE Product_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getProduct_name());
            st.setInt(2, p.getQuantify());
            st.setString(3, p.getUnit());
            st.setString(4, p.getStatus());
            st.setString(5, p.getSupplier_id());
            st.setString(6, p.getDescribe());
            st.setString(7, p.getPhoto());
            st.setFloat(8, p.getPrice());
            st.setDate(9, p.getUpdated_at());
            st.setInt(10, p.getCategory_id());
            st.setString(11, p.getProduct_id());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductDao pdb = new ProductDao();
        //  List<Product> listp = pdb.getAll();
        List<String> lists = pdb.getAllStatus();
        for (String list : lists) {
            System.out.println(list.trim());
//        for (int i = 0; i < 2; i++) {
//            System.out.println(listp.get(i).toString());
        }

//        for (String list : lists) {
//            System.out.println(list.trim());
//        }
        //      List<Product> listp = pdb.getAll();
        //     System.out.println(listp.size());
    }
}
