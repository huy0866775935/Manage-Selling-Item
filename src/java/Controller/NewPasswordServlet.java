/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Dal.UsersDao;
import Model.Users;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class NewPasswordServlet extends HttpServlet {
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("weblogin/newpsw.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        UsersDao udb = new UsersDao();
        
        HttpSession session = request.getSession();
        //check xem co email tu thang forgotpassword
        Users u = (Users) session.getAttribute("user");
        if(u!= null && pass.equals(cpass)){
            //update password moi
            udb.updatePass(u.getUser_id(), pass);
            request.getRequestDispatcher("weblogin/login.jsp").forward(request, response);
        }
        else{
            request.setAttribute("error3", "Confirm password not matched!");
            request.getRequestDispatcher("weblogin/newpsw.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
