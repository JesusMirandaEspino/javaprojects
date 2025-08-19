package gm.RH.servicio;

import gm.RH.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();

    public Empleado BuscarEmpleadoPorId(Integer idEmlpeado);

    public Empleado guardarEmpleado(Empleado empleado);

    public void elimarEmpleado(Empleado empleado);

}
