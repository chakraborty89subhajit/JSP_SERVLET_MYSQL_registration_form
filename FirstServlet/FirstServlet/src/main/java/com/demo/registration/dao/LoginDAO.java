package com.demo.registration.dao;

import com.demo.registration.model.LoginBean;

import java.sql.*;

public class LoginDAO {
    public boolean validate(LoginBean loginbean )throws Exception{
        boolean status = false;

Class.forName("com.mysql.cj.jdbc.Driver");

try{
    Connection con= DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/mydb","root","project");
    String sql="select * from employee where username=? and password=?";
    PreparedStatement pstmt= con.prepareStatement(sql);
    pstmt.setString(1, loginbean.getUsername());
    pstmt.setString(2, loginbean.getPassword());
    System.out.println(pstmt);
    ResultSet rs= pstmt.executeQuery();
    status=rs.next();
}catch(Exception e){
    e.printStackTrace();
}
return status;
    }

    public void printSQLException(SQLException ex){
        for(Throwable e: ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState:"+((SQLException)e).getSQLState());
                System.err.println("Error code:"+((SQLException)e).getErrorCode());
                System.err.println("Message:"+e.getMessage());
                Throwable t= ex.getCause();
                while(t!=null){
                    System.out.println("Cause: "+t);
                    t=t.getCause();
                }

            }
        }

    }
}
