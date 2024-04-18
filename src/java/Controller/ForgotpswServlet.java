/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.UsersDao;
import Model.Users;
import Vertify.SendMail;
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
public class ForgotpswServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("weblogin/forgetpassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ugmail = request.getParameter("gmail");
        HttpSession session = request.getSession();
        
        UsersDao udb = new UsersDao();
        Users u = udb.getByCheckGmail(ugmail);
        
       
        if (u != null) {
            //set code sau khi send to email
            session.setAttribute("vertify",CheckEmail(ugmail));
            session.setAttribute("user", u);
            response.sendRedirect("vertifycode");

        } else {
            request.setAttribute("error2", "This email address does not exist!");
            request.getRequestDispatcher("weblogin/forgetpassword.jsp").forward(request, response);
        }

    }
    
    //xu ly send email
    public String CheckEmail(String email){
        SendMail s = new SendMail();
        String radomcode = s.createCaptcha();
        s.sentEmail(email, "Vertity Code Now: ", radomcode);
        return radomcode;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
