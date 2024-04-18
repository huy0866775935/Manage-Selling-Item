package Crud_people;

import Dal.SupplierDao;
import Model.Supplier;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class AddsupplierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/addsupplier.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String suid = request.getParameter("sid");
        String suname = request.getParameter("sname");
        String suaddress = request.getParameter("saddress");
        String suphone = request.getParameter("sphone");
        String sucity = request.getParameter("scity");
        HttpSession session = request.getSession();

        //check id duplicate
        SupplierDao sudb = new SupplierDao();
        Supplier s = sudb.getBySupplierId(suid);

        if (s != null) {
            String ms = suid + " exsited!!";
            session.setAttribute("error", ms);
            
            response.sendRedirect("addsupplier");
        } else {
            Supplier s1 = new Supplier(suid, suname, suaddress, suphone, sucity);
            sudb.insertSupplier(s1);
            response.sendRedirect("listsupplier");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
