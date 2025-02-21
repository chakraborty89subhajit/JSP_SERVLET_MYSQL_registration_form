package com.demo.registration.controller;

import com.demo.registration.dao.LoginDAO;
import com.demo.registration.model.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginDAO loginDAO;

    public void init(){
        loginDAO= new LoginDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        RequestDispatcher disp= request.getRequestDispatcher("/views/login.jsp");
        disp.forward(request,response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      String username=request.getParameter("username");
      String password=request.getParameter("password");

        LoginBean loginBean=new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try{
            if(loginDAO.validate(loginBean)){
                response.sendRedirect("views/loginSuccess.jsp");
            }else{
                HttpSession session= request.getSession();

                session.setAttribute("user",username);
                response.sendRedirect("views/login.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
