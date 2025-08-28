/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.conectar.*;
import domain.Persona;
import java.sql.*;
import java.util.*;

/**
 *
 * @author jesus
 */
public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM test.persona";
    
    public List<Persona> seleccionar(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            res = stmt.executeQuery();
            
            while( res.next() ){
                int idPersona = res.getInt("idPersona");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String telefono = res.getString("telefono");
                
                persona = new Persona(idPersona,nombre, apellido,email, telefono);
                
                personas.add(persona);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(res);
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
        
    }
}
