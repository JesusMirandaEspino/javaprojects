/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public class PersonsJDBC {
    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE idPersona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";
    
    
    public List<Persona> seleccionar(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        
        try {
            con = ConexionJDBC.getConexion();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next() ){
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                persona = new Persona();
                persona.setIdPersona(idPersona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionJDBC.cerrar(rs);
            ConexionJDBC.cerrar(stmt);
            ConexionJDBC.cerrar(con);

        }
        return personas;
    
    }
    
}
