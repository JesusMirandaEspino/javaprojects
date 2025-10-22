/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.cliclovidajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
public class EliminarObjetojpa {
        private static Logger log = LoggerFactory.getLogger(EliminarObjetojpa.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Persona persona1 = em.find(Persona.class, 7);

        tx.commit();

        log.info("objeto encontrado:" + persona1);

        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        em.remove( em.merge(persona1));

        tx2.commit();

        log.info("objeto eliminado:" + persona1);

        em.close();

    }
}
