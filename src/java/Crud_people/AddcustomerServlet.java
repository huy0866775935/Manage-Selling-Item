/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Crud_people;

import Dal.CustomerDao;
import Dal.MemberlevelDao;
import Model.Customer;
import Model.Memberlevel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AddcustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDao cudb = new CustomerDao();
        List<String> genderlist = cudb.getSelectGender();
        MemberlevelDao mldb = new MemberlevelDao();
        List<Memberlevel> mnlist = mldb.getAll();

        request.setAttribute("mnlist", mnlist);
        request.setAttribute("genderlist", genderlist);
        request.getRequestDispatcher("view/addcustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cusid = request.getParameter("cuid");
        String cusfname = request.getParameter("cufname");
        String cuslname = request.getParameter("culname");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenum");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String memberId = request.getParameter("memberid");
        String  network = request.getParameter("network");
        int ml;
        HttpSession session = request.getSession();
        //check date
        // Định dạng của chuỗi ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển đổi chuỗi thành đối tượng LocalDate
        LocalDate date = LocalDate.parse(dob, formatter);

        if (!checkLimitDate(date)) {
            String mss = dob + " must be more than 20 years old and older than 1900,and less than now()";
            session.setAttribute("error2", mss);
            response.sendRedirect("addcustomer");
        } else {
            Date d = Date.valueOf(date);

            //check duplicate customer id
            CustomerDao cudb = new CustomerDao();

            try {
                ml = Integer.parseInt(memberId);
                if (cudb.getByCheckIdCustomer(cusid) != null) {
                    String ms = cusid + " exsited!!";
                    session.setAttribute("error", ms);
                    response.sendRedirect("addcustomer");
                } else {
//                    Customer c1 = new Customer(cusid, cusfname, cuslname, email, phonenumber, address, d, gender, ml);
                    Customer c1 = new Customer(cusid, cusfname, cuslname, email, phonenumber, address, d, gender, ml, network);
                    cudb.insertCustomer(c1);
                    response.sendRedirect("listcustomer");

                }
            } catch (NumberFormatException e) {
                response.sendRedirect("addcustomer");
            }
        }

    }

    public boolean checkLimitDate(LocalDate l) {
        //1. khong dc lon hon hien tai, khong dc be hon 1900
        //2. tren 20t

        LocalDate now = LocalDate.now();
        LocalDate minDate = LocalDate.of(1900, 1, 1);

        int age = Period.between(l, now).getYears();
        boolean isValid = l.isAfter(minDate) && age >= 20;
        if (isValid) {
            return true;
        }
        return false;

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
