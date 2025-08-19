package gm.RH.controlador;

import gm.RH.modelo.Empleado;
import gm.RH.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value="http://localhost:3000")
public class EmpleadoControlador {

    private static final Logger logger = LoggerFactory.getLogger( EmpleadoControlador.class  );

    @Autowired
    private IEmpleadoServicio empleadoServicio;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach(empleado->logger.info(empleado.toString()));
        return empleados;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("empleado a agregar " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }
}