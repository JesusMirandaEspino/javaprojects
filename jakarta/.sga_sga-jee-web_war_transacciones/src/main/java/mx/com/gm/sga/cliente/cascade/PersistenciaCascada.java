/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.cascade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.cliente.cliclovidajpa.PersistirObjetoJPA;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
public class PersistenciaCascada {
    private static Logger log = LoggerFactory.getLogger(PersistenciaCascada.class);
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona1 = new Persona("bob Master", "LocoMaster", "master@gmail.com", "123456895");
        
        Usuario usario1 = new Usuario("bobloco", "4568", persona1);
        
        em.persist(usario1);
        
        tx.commit();
        
        log.info("Objeto recuperado:" + persona1);
        log.info("Objeto recuperado:" + usario1);
        
        em.close();
    }
    
}
