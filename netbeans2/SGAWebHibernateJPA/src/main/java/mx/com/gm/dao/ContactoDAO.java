/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Contacto;


/**
 *
 * @author jesus
 */
public class ContactoDAO extends GenericDAO{
    
    
    public List<Contacto> listar(){
        String consulta = "SELECT d FROM Contacto d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
        
        
    public void insertar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }   
    
  
    public void actualizar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void remover(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(contacto);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    public Object buscarPorId(Contacto contacto){
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());
    }
    
    
}
