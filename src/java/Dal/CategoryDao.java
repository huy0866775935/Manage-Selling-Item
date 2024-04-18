/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryDao extends DBContext{
    
    public List<Category> getAll(){
        List<Category> list  = new ArrayList<>();
        
        String sql = "SELECT * FROM Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Category c = new Category();
                c.setCategory_id(rs.getInt("CategoryID"));
                c.setCategory_name(rs.getString("CategoryName"));
                c.setDescr(rs.getString("Descr"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
        //paging
        
   public List<Category> getListByPage(List<Category> list, int start, int end){
       ArrayList<Category> arr = new ArrayList<>();
       for (int i = start; i < end; i++) {
           arr.add(list.get(i));
       }
       return arr;
   }
    
    //insert category
    public void insertCategory(Category c){
        String sql = "INSERT INTO [dbo].[Category]\n" +
"           ([CategoryName]\n" +
"           ,[Descr])\n" +
"     VALUES\n" +
"           (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategory_name());
            st.setString(2, c.getDescr());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //delete category
    public void deleteCategory(int id){
        String sql =  "DELETE FROM [dbo].[Category]\n"  +
"      WHERE CategoryID = ?" ;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    //update category
    public void updateCategory(Category c){
        String sql = "UPDATE [dbo].[Category]\n" +
"   SET [CategoryName] = ?" +
"      ,[Descr] = ?" +
" WHERE CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategory_name());
            st.setString(2, c.getDescr());
            st.setInt(3, c.getCategory_id());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
        //select categoryname
    public List<String> getAllUnit(){
        List<String> list = new ArrayList<>();
        String sql = "SELECT DIStinct CategoryName FROM Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               String catname = rs.getString("CategoryName");
               list.add(catname);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    //checkid category
    public Category getCheckIdCategory(int id){
        String sql = "SELECT * FROM Category WHERE CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Category c = new Category();
                c.setCategory_id(rs.getInt("CategoryID"));
                c.setCategory_name(rs.getString("CategoryName"));
                c.setDescr((rs.getString("Descr")));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        CategoryDao cdb = new CategoryDao();
//        List<Category> listc = cdb.getAll();
//        
//        for (Category category : listc) {
//            System.out.println(category.toString());
//        }

        List<String> lst = cdb.getAllUnit();
        for (String string : lst) {
            System.out.println(string.trim());
        }
    }
}
