package gm.RH.servicio;

import gm.RH.modelo.Empleado;
import gm.RH.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado BuscarEmpleadoPorId(Integer idEmlpeado) {
        return  empleadoRepositorio.findById(idEmlpeado).orElse(null);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public void elimarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
