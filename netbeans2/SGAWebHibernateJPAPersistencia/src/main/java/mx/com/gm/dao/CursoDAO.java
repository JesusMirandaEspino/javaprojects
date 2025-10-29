/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Curso;


/**
 *
 * @author jesus
 */
public class CursoDAO extends GenericDAO{


    public List<Curso> listar(){
        String consulta = "SELECT d FROM Curso d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
        
        
    public void insertar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }   
    
  
    public void actualizar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void remover(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(curso);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    public Object buscarPorId(Curso curso){
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());
    }
    
    
    
}
