package datos;

import java.sql.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class ConexionJDBC {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezoneUTC";
    private static final String user = "root";
    private static final String password = "admin";
    
    
    
    public static Connection getConexion() throws SQLException{ 
       return DriverManager.getConnection(JDBC_URL, user, password);
    }
    
    
    public static void cerrar(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    
    public static void cerrar(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    
    public static void cerrar(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
