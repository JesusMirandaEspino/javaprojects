/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplojdbc;

import java.sql.*;

/**
 *
 * @author jesus
 */
public class IntroduccionJDBC {
    
    public static void main(String[] args) {
           
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezoneUTC";

        try { 
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            
            Statement instruccion = conexion.createStatement();
            String SQLSELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
            
            ResultSet resultado = instruccion.executeQuery(SQLSELECT);
            
            while(resultado.next() )  {
                System.out.println("Id persona: " + resultado.getInt(1));
                System.out.println("Nombre: " + resultado.getString(2));
                System.out.println("Apellido: " + resultado.getString(3));
                System.out.println("Email: " + resultado.getString(4));
                System.out.println("Telefono: " + resultado.getString(5));
                System.out.println("-----------------------------------------------------------------");
            }
            
            
            resultado.close();
            instruccion.close();
            conexion.close();
                    
                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
    
    

    
}
