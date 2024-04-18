/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Crud_people;

import Dal.SupplierDao;
import Model.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UpdatesupplierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String suid = request.getParameter("suid");
        SupplierDao sudb = new SupplierDao();
        HttpSession session = request.getSession();
        Supplier s = sudb.getBySupplierId(suid);

        session.setAttribute("su", s);
        request.getRequestDispatcher("view/updatesupplier.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String suid = request.getParameter("sid");
        String suname = request.getParameter("sname");
        String suaddress = request.getParameter("saddress");
        String suphone = request.getParameter("sphone");
        String sucity = request.getParameter("scity");

        SupplierDao sudb = new SupplierDao();
        Supplier s1 = new Supplier(suid, suname, suaddress, suphone, sucity);
        sudb.updateSuplier(s1);
        response.sendRedirect("listsupplier");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
