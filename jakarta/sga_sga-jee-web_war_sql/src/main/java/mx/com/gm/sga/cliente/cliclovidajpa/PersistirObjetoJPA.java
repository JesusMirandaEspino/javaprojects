/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.cliclovidajpa;

import jakarta.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
public class PersistirObjetoJPA {
    private static Logger log = LoggerFactory.getLogger(PersistirObjetoJPA.class);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Persona persona1 = new Persona("BobGuachimingo", "Guachimingo", "guachimingo@mail.com", "13135566");
        
        tx.begin();
        
        em.persist( persona1 );
        
        log.info("Objeto persistido - aun sin commit:" + persona1);
        
        tx.commit();
        

        log.info("Objeto persistido - estado detached:" + persona1);
        

        em.close();
        
    }
}
