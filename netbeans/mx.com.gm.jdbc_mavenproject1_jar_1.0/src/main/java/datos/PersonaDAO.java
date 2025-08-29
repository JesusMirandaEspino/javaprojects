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
    private static final String SQL_INSERT = "INSERT INTO test.persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?,  apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM test.persona  WHERE idPersona = ?";
    
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
    
    
    public int insertar(Persona persona){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int registros = 0;
        
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

        return registros;
    }
    
    
    
    public int actualizar(Persona persona){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int registros = 0;
        
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

        return registros;
    }
    
    
    
    public int delete(Persona persona){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int registros = 0;
        
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

        return registros;
    }
    
}
