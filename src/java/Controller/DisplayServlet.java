/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.CategoryDao;
import Dal.ProductDao;
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DisplayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key");
        ProductDao pdb = new ProductDao();
        CategoryDao cdb = new CategoryDao();
        List<Product> list1 = pdb.getAll(key);
        List<Category> listcat = cdb.getAll();  
        

        //paging
        
        int page, numperpage = 18; //page so trang se tra ve // so phan tu trong trang
        int size = list1.size();

        int num = (size % numperpage == 0 ? size / numperpage : size / (numperpage) + 1);

        String xpage = request.getParameter("page"); //gia tri cua trang ben jsp
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start,end;
        start = (page - 1)*numperpage;
        end =  Math.min(page*numperpage, size); //lay gia tri vi khi do co the so ptu / so trang minh muon co the chan hoac le
        
        List<Product> list = pdb.getListByPage(list1, start, end);
        
        request.setAttribute("data", list);
        request.setAttribute("cat", listcat);
        request.setAttribute("page", page);
        request.setAttribute("num", num); //tinh so trang
        request.getRequestDispatcher("view/displaymain.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
