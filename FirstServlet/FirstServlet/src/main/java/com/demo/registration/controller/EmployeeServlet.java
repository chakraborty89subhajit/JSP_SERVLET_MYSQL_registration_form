package com.demo.registration.controller;

import com.demo.registration.dao.EmployeeDAO;
import com.demo.registration.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {


    EmployeeDAO empdao= new EmployeeDAO();
    public EmployeeServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        RequestDispatcher disp= request.getRequestDispatcher("/views/empReg.jsp");
        disp.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String first_name=request.getParameter("firstName");
        String last_name=request.getParameter("lastName");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address =request.getParameter("address");
        String contact= request.getParameter("contact");

        Employee emp= new Employee();

        emp.setFirstName(first_name);
        emp.setLastName(last_name);
        emp.setUsername(username);
        emp.setPassword(password);
        emp.setAddress(address);
        emp.setContact(contact);

        try {
            empdao.registerEmployee(emp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       // response.sendRedirect("");
        RequestDispatcher disp= request.getRequestDispatcher("/views/regsuccess.jsp");
        disp.forward(request,response);
    }
}
