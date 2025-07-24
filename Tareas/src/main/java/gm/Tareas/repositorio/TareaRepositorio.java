package gm.Tareas.repositorio;

import gm.Tareas.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TareaRepositorio extends JpaRepository<Tarea, Integer> {

}
