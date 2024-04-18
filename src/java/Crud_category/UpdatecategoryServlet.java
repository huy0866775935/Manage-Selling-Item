/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Crud_category;

import Dal.CategoryDao;
import Model.Category;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class UpdatecategoryServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("cid");
        int id;
        try {
            id = Integer.parseInt(id_raw);
            CategoryDao cdb = new CategoryDao();

            //check id
            Category c = cdb.getCheckIdCategory(id);
            request.setAttribute("cat", c);
            request.getRequestDispatcher("view/updatecategory.jsp").forward(request, response);
            
        } catch (Exception e) {
            request.setAttribute("message", "No CategoryID!!");
            request.getRequestDispatcher("view/updatecategory.jsp").forward(request, response);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String desc = request.getParameter("desc");
        int cid;
        try {
            cid = Integer.parseInt(id_raw);
            CategoryDao cdb = new CategoryDao();
            Category c1 = new Category(cid, cname, desc);
            cdb.updateCategory(c1);
            response.sendRedirect("lcs");
            
        } catch (Exception e) {
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
