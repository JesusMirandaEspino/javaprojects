/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import domain.Persona;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
public class ClienteEntidadPersona {
    private static Logger log = LoggerFactory.getLogger(ClienteEntidadPersona.class);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        Persona persona1 = new Persona( "Bob catMan", "Cat", "catman@gmail.com", "123456987" );
        log.debug("Se agrega la persona: " + persona1);
        
        em.persist(persona1);
        tx.commit();
        log.info("Objeto persistido: " + persona1);

        em.close();
        
    }
    
}
