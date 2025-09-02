/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 *
 * @author jesus
 */
public class conectar {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    
    public static DataSource getdataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        
        //Tamaño
        ds.setInitialSize(5);
        
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getdataSource().getConnection();
    }
    
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    
    public static void close(Connection con) throws SQLException{
        con.close();
    }
}
