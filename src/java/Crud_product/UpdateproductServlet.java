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
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class UpdateproductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("pid");
        ProductDao pdb = new ProductDao();
        CategoryDao cdb = new CategoryDao();
        SupplierDao sdb = new SupplierDao();

        //check id to select info product
        Product p = pdb.getCheckIdProduct(id_raw);


        request.setAttribute("dataunit", pdb.getAllUnit());
        request.setAttribute("datastatus", pdb.getAllStatus());
        request.setAttribute("datacategory", cdb.getAll());
        request.setAttribute("datasupplier", sdb.getAll());
        request.setAttribute("pro", p); //info lay dc khi co id
        request.getRequestDispatcher("view/updateproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("pid");
        String p_name = request.getParameter("pname");
        String quantity = request.getParameter("pquan");
        String unit = request.getParameter("unit");
        String status = request.getParameter("status");
        String sup_id = request.getParameter("suid");
        String price = request.getParameter("price");
        String cat = request.getParameter("cat");
        String desc = request.getParameter("desc");
        String photo = request.getParameter("photo");
        Date update;
        
        LocalDate currentDate = LocalDate.now();
        
        // Chuyển đổi sang kiểu dữ liệu DATE trong SQL
        update = Date.valueOf(currentDate);
        
        int qua, ca;
        float pr;

        try {
            pr = Float.parseFloat(price);
            qua = Integer.parseInt(quantity);
            ca = Integer.parseInt(cat);
            ProductDao pdb = new ProductDao();
            CategoryDao cdb = new CategoryDao();
            SupplierDao sdb = new SupplierDao();
            Product p1 = new Product(id_raw, p_name,qua, unit, status, sup_id, desc, photo, pr, update, ca);
            pdb.updateProduct(p1);
            response.sendRedirect("lps");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean ischeck(String dynamicEnter, List<String> staticSelect, int step) {
        if (staticSelect == null) {
            return false;
        } else {
            for (int i = 0; i < step; i++) {
                if (staticSelect.get(i) == dynamicEnter) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
