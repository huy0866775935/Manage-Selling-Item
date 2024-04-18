/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.UsersDao;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        request.getRequestDispatcher("weblogin/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {

            //-----------------------------------------------
            String user = request.getParameter("username");
            String pass = request.getParameter("psw");
            String r = request.getParameter("remember");

            Cookie cu = new Cookie("cuser", user);
            Cookie cp = new Cookie("cpass", pass);
            Cookie cr = new Cookie("crem", r);

            //kiem tra xem cline co chon hay ko
            if (r != null) {
                //yes choose
                cu.setMaxAge(60 * 60);
                cp.setMaxAge(60 * 60);
                cr.setMaxAge(60 * 60);
            } else {
                //not choose
                cu.setMaxAge(0);
                cp.setMaxAge(0);
                cr.setMaxAge(0);
            }

            //luu ve browser
            response.addCookie(cu);
            response.addCookie(cp);
            response.addCookie(cr);

            //-----------------------------------------------
            HttpSession session = request.getSession();

            UsersDao udb = new UsersDao();
            Users u = udb.getCheckAccount(user, pass);
            if (u == null) {
                request.setAttribute("error1", "It's look like you're not a yet member!");
                request.getRequestDispatcher("weblogin/login.jsp").forward(request, response);
            } else {
                //checkrole staff or admin

                session.setAttribute("account", u);
                response.sendRedirect("dashbsr");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
