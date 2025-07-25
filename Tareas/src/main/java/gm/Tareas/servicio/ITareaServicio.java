package gm.Tareas.servicio;

import gm.Tareas.modelo.Tarea;

import java.util.List;

public interface ITareaServicio {
    public List<Tarea> listarTarea();

    public List<Tarea> listarTareas();

    public Tarea buscarTareaPorId(Integer idTarea);

    public void guardarTarea( Tarea tarea );

    public void eliminarTarea( Tarea tarea );
}
