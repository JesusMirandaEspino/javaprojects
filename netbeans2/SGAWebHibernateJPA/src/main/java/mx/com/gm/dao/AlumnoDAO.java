/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Alumno;

/**
 *
 * @author jesus
 */
public class AlumnoDAO extends GenericDAO{
    
        public List<Alumno> listar(){
        String consulta = "SELECT d FROM Alumno d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
        
        

    public void insertar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void actualizar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public void remover(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(alumno);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            if(em != null)
                em.close();
        }
    }
    
    
    public Object buscarPorId(Alumno alumno){
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }
    
    
}
