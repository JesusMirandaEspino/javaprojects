/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import mx.com.gm.domain.Domicilio;

/**
 *
 * @author jesus
 */
public class DomicilioDAO extends GenericDAO{
    
    public List<Domicilio> listar(){
        String consulta = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
    public void insertar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void actualizar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void remover(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(domicilio);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public Object buscarPorId(Domicilio domicilio){
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
    
}
