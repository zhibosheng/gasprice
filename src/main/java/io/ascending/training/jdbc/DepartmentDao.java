package io.ascending.training.jdbc;

import io.ascending.training.model.Department;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class DepartmentDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/dealer";
    static final String USER = "admin";
    static final String PASS ="password";
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public List<Department> getDepartments(){
        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;
        List<Department> departments = new ArrayList();
        try {
            logger.debug("");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            logger.info("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM department";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                departments.add(department);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return departments;

    }

    public Department save(Department department){
        Connection conn;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "Insert into department(name,description) values" + "('"+department.getName()+"','"+department.getDescription()+"')" ;
            int i = stmt.executeUpdate(sql);
            while(i == 1){
                System.out.println("Created new record.");
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return department;
    }

    public Department delete(Department department){
        Connection conn;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "Insert into department(name,description) values" + "()" ;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                departments.add(department);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return department;
    }


}
