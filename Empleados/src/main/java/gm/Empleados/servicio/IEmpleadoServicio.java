package gm.Empleados.servicio;

import gm.Empleados.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {

    public List<Empleado> ListarEmpleados();

    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    public void guardarEmpleado( Empleado empleado );

    public void eliminarEmpleado( Empleado empleado );


}
