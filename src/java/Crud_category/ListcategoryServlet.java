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
import java.util.List;

/**
 *
 * @author Admin
 */
public class ListcategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao cdb = new CategoryDao();
        List<Category> list1 = cdb.getAll();

        //paging
        int page, numperpage = 6; //page so trang se tra ve // so phan tu trong trang
        int size = list1.size();

        int num = (size % numperpage == 0 ? size / numperpage : size / (numperpage) + 1);

        String xpage = request.getParameter("page"); //gia tri cua trang ben jsp
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size); //lay gia tri vi khi do co the so ptu / so trang minh muon co the chan hoac le

        List<Category> list = cdb.getListByPage(list1, start, end);

        request.setAttribute("data", list);
        request.setAttribute("page", page);
        request.setAttribute("num", num); //tinh so trang

        request.getRequestDispatcher("view/listcategory.jsp").forward(request, response);
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
