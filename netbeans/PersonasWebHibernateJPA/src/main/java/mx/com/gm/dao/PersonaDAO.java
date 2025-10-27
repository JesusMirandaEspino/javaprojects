/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;


/**
 *
 * @author jesus
 */
public class PersonaDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersonaDAO(){
        emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        em = emf.createEntityManager();
    }
    
    public List<Persona> Listar(){
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);
        
        List<Persona> personas = query.getResultList();
        
        return personas;
    }
    
    
    public void Insertar(Persona persona){
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    
    public void Modificar(Persona persona){
        try {
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    
    public Persona BuscarPersonaPorId(Persona p){
        return em.find(Persona.class, p.getIdPersona());
    }
    
    public void Borrar(Persona persona){
        try {
            em.getTransaction().begin();
            em.remove(em.merge(persona));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
}
