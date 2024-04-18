/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Crud_product;

import Dal.CategoryDao;
import Dal.ProductDao;
import Dal.SupplierDao;
import Model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class AddproductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao pdb = new ProductDao();
        CategoryDao cdb = new CategoryDao();
        SupplierDao sdb = new SupplierDao();

        request.setAttribute("dataunit", pdb.getAllUnit());
        request.setAttribute("datacategory", cdb.getAll());
        request.setAttribute("datasupplier", sdb.getAll());
        request.getRequestDispatcher("view/addproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String p_id = request.getParameter("pid");
        String p_name = request.getParameter("pname");
        String quantity = request.getParameter("pquan");
        String unit = request.getParameter("unit");
        String status = "stocking";
        String sup_id = request.getParameter("suid");
        String price = request.getParameter("price");
        String cat = request.getParameter("cat");
        String desc = request.getParameter("desc");
        String photo = request.getParameter("photo");
        int qua, ca;
        float pr;
        
        try {
            pr = Float.parseFloat(price);
            qua = Integer.parseInt(quantity);
            ca = Integer.parseInt(cat);
            ProductDao pdb = new ProductDao();
            CategoryDao cdb = new CategoryDao();
            SupplierDao sdb = new SupplierDao();

            Product p = pdb.getCheckIdProduct(p_id);

            if (p != null) {
                String ms = p_id + " exsited!!";
                request.setAttribute("error", ms);
                

                request.setAttribute("dataunit", pdb.getAllUnit());
                request.setAttribute("datacategory", cdb.getAll());
                request.setAttribute("datasupplier", sdb.getAll());
                request.getRequestDispatcher("view/addproduct.jsp").forward(request, response);
            } else{
                Product p1 = new Product(p_id, p_name, qua, unit, status, sup_id, desc, photo, pr, ca);
                pdb.Insertproduct(p1);
                response.sendRedirect("lps");
            }
        } catch (Exception e) {
            response.sendRedirect("adps");
        }

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
