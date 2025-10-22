/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.sga.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
public class PruebaAPICriteria {
     private static Logger log = LoggerFactory.getLogger(PruebaAPICriteria.class);
     
     
     
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
         CriteriaBuilder cb = null;
         CriteriaQuery<Persona> criteriaQuery = null;
         Root<Persona> fromPersona = null;
         TypedQuery<Persona> query = null;
         Persona persona = null;
         
         List<Persona> personas = null;
         
         cb = em.getCriteriaBuilder();
         criteriaQuery = cb.createQuery(Persona.class);
         fromPersona = criteriaQuery.from(Persona.class);
         
         criteriaQuery.select(fromPersona);
         
         query = em.createQuery(criteriaQuery);
         
         personas = query.getResultList();
         
         mostrarPersonas(personas);
         
         
        log.info("\n2-a. Consulta de la Persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.info("Persona: " + persona);
        

        log.info("\n2-b. Consulta de la Persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);

        List<Predicate> criterios = new ArrayList<Predicate>();

        Integer idPersonaParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add( cb.equal(fromPersona.get("idPersona"), parameter));
        

        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        }
        else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        }
        else{
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        //Se ejecuta el query
        persona = query.getSingleResult();
        log.info("Persona: " + persona);
         
         
         
         
         
    }
     
     
    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p: personas){
            log.info("Persona: " + p);
        }
    }
     
}
