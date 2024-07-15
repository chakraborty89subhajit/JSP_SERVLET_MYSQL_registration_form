package com.demo.registration.dao;

import com.demo.registration.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public int registerEmployee(Employee employee) throws ClassNotFoundException{
        String USER_INSERT_SQL="insert into employee"+
                               " (id,first_name,last_name,username,password,address,contact) values "+
                               "(?,?,?,?,?,?,?)";

        int result=0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection con= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydb","root","project");
            PreparedStatement pstmt= con.prepareStatement(USER_INSERT_SQL);
            pstmt.setInt(1,1);
            pstmt.setString(2,employee.getFirstName());
            pstmt.setString(3,employee.getLastName());
            pstmt.setString(4,employee.getUsername());
            pstmt.setString(5,employee.getPassword());
            pstmt.setString(6,employee.getAddress());
            pstmt.setString(7,employee.getContact());

            System.out.println(pstmt);

            result=pstmt.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }
return result;
    }
}
