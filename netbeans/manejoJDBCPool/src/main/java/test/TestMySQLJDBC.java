/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;


/**
 *
 * @author jesus
 */
public class TestMySQLJDBC {
    public static void main(String[] args){
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while( resultado.next() ){
                System.out.print("Id Persona: " + resultado.getInt("idPersona"));
                System.out.print(" Nombre: " + resultado.getString("nombre"));
                System.out.print(" Apellido: " + resultado.getString("apellido"));
                System.out.print(" Email: " + resultado.getString("email"));
                System.out.println(" Telefono: " + resultado.getString("telefono"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } 
        //catch (ClassNotFoundException ex) {
        //    ex.printStackTrace(System.out);
        //}
         catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
