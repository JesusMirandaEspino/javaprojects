/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;


/**
 *
 * @author jesus
 */
public class HolaMundoHibernate {
    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = fabrica.createEntityManager();
        
        Query query = entityManager.createQuery(hql);
        
        List<Persona> personas = query.getResultList();
        
        for( Persona p: personas ){
            System.out.println("Persona: " + p);
        }
        
    }
}
