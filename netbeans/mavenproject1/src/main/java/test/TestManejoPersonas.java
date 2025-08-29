/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonasJDBC;
import datos.conectar;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Consumer;

/**
 *
 * @author jesus
 */
public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conectando = null;
        try {
            conectando = conectar.getConnection();
            if(conectando.getAutoCommit()){
                conectando.setAutoCommit(false);
            }


            PersonasJDBC PersonasJDBC = new PersonasJDBC(conectando);
            
            List<Persona> personas =  PersonasJDBC.seleccionar();
            

            personas.forEach( persona -> {
                System.out.println(persona.toString());
            } );
        
                    
            Persona persona1 = new Persona("BobBlanco", "ElBlanco", "elgranblanco@cat.com", "45678948457"  );
            PersonasJDBC.insertar(persona1);
                    
                    
            Persona persona2 = new Persona(1,"BobSuperCat", "superloco", "elgranloco@cat.com", "46589784558"  );
            PersonasJDBC.actualizar(persona2);
            
            
            conectando.commit();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al RollBack");
            try {
                conectando.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
        

        
        

        
    }
}
