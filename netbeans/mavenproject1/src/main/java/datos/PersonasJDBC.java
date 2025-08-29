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
public class PersonasJDBC {
    
    private Connection conexionTransacion;
    
    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO test.persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?,  apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM test.persona  WHERE idPersona = ?";

    public PersonasJDBC() {
    }
    
    public PersonasJDBC(Connection conexionTransacion) {
         this.conexionTransacion = conexionTransacion;
    }
    
    public List<Persona> seleccionar() throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        
        try {
            con = this.conexionTransacion != null ? this.conexionTransacion: getConnection();
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
        }
        finally{
            try {
                close(res);
                close(stmt);
                
                if(this.conexionTransacion == null)
                    close(con);

                
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
        
    }
    
    
    public int insertar(Persona persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int registros = 0;
        
        try {
            con = this.conexionTransacion != null ? this.conexionTransacion: getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            registros = stmt.executeUpdate();
        }finally{
            try {
                close(stmt);
                if(this.conexionTransacion == null)
                    close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

        return registros;
    }
    
    
    
    public int actualizar(Persona persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int registros = 0;
        
        try {
            con = this.conexionTransacion != null ? this.conexionTransacion: getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            registros = stmt.executeUpdate();
        }finally{
            try {
                close(stmt);
                if(this.conexionTransacion == null)
                    close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

        return registros;
    }
    
    
    
    public int delete(Persona persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int registros = 0;
        
        try {
            con = this.conexionTransacion != null ? this.conexionTransacion: getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            registros = stmt.executeUpdate();
        }finally{
            try {
                close(stmt);
                if(this.conexionTransacion == null)
                    close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

        return registros;
    }
    
}
