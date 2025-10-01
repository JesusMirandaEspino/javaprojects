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
    
    private Connection conexionTransaccional;
    
    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE idPersona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";
    
    public PersonsJDBC(){
    
    }
    
    
    public PersonsJDBC(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Persona> seleccionar()throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionJDBC.getConexion();
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
        }finally{
            ConexionJDBC.cerrar(rs);
            ConexionJDBC.cerrar(stmt);
            
            if( this.conexionTransaccional == null ){
              ConexionJDBC.cerrar(con);
            }


            
            
        }
        return personas;
    
    }
    
    public int insertar(Persona persona)throws SQLException{
    
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionJDBC.getConexion();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
            System.out.println("Ejecutando query");
            
            rows = stmt.executeUpdate();
            
            System.out.println("Registros afectados" + rows);
       
        }finally{
            ConexionJDBC.cerrar(stmt);
            if( this.conexionTransaccional == null ){
              ConexionJDBC.cerrar(con);
            }
        }
        
        return rows;

    }
    
    
    
    public int actualizar(Persona persona)throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionJDBC.getConexion();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            
            System.out.println("Ejecutando query");
            
            rows = stmt.executeUpdate();
            
            System.out.println("Registros afectados" + rows);
        }finally{
            ConexionJDBC.cerrar(stmt);
            if( this.conexionTransaccional == null ){
              ConexionJDBC.cerrar(con);
            }
        }
        
        return rows;
        
        
        
    }
    
    
    
    public int borrar(Persona persona)throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionJDBC.getConexion();
            stmt = con.prepareStatement(SQL_DELETE);

            stmt.setInt(1, persona.getIdPersona());
            System.out.println("Ejecutando query");
            
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados" + rows);
        
        }finally{
            ConexionJDBC.cerrar(stmt);
            if( this.conexionTransaccional == null ){
              ConexionJDBC.cerrar(con);
            }
        }
        
        return rows;
        
        
        
    }
    
}
