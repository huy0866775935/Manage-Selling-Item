/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Dal.OrderDao;
import Dal.OrderdetailDao;
import Dal.ProductDao;
import Dal.SupplierDao;
import Dal.UsersDao;
import Model.Order;
import Model.Orderdetail;
import Model.Product;
import Model.Supplier;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductDao pdb = new ProductDao();
        List<Product> list = pdb.getAll();
        
        UsersDao udb = new UsersDao();
        int countu = udb.countAccount();
        
        OrderDao odb = new OrderDao();
        List<Order> listo = odb.getAll();
        
        SupplierDao sdb = new SupplierDao();
        List<Supplier> lists = sdb.getAll();
        
        //table top 10 product best seller
        OrderdetailDao oddb = new OrderdetailDao();
        List<Orderdetail> listod = oddb.top10product();
        
        request.setAttribute("numpro", list.size());
        request.setAttribute("numuser", countu);
        request.setAttribute("numorder", listo.size());
        request.setAttribute("numsupplier", lists.size());
        request.setAttribute("top10od", listod);
        
        request.getRequestDispatcher("view/dashboard.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
