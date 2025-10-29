/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Asignacion;

/**
 *
 * @author jesus
 */
public class AsignacionDAO extends GenericDAO{
    
    public List<Asignacion> listar(){
        String consulta = "SELECT d FROM Asignacion d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
        
        
    public void insertar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }   
    
  
    public void actualizar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void remover(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(asignacion);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    public Object buscarPorId(Asignacion asignacion){
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }
    
    
}
