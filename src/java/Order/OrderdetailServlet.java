/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Order;

import Dal.OrderDao;
import Dal.OrderdetailDao;
import Model.Order;
import Model.Orderdetail;
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
public class OrderdetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderid_raw = Integer.parseInt(request.getParameter("orderid"));
        String orderdate_raw = request.getParameter("orderdate");
        int ordid;
            OrderdetailDao oddb = new OrderdetailDao();
            List<Orderdetail> listod = oddb.getTwotableOdandP(orderid_raw);
            OrderDao odb= new OrderDao();
            Order o = odb.getOrderList(orderid_raw);
            
            request.setAttribute("numor",orderid_raw);
            request.setAttribute("total", odb.totalOne(orderid_raw, orderdate_raw));
            request.setAttribute("op", listod);
            request.setAttribute("odd", o);
            request.getRequestDispatcher("view/listorderdetail.jsp").forward(request, response);
//        response.sendRedirect("orderlist");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
