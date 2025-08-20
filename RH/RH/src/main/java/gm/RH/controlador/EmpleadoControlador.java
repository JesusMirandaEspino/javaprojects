package gm.RH.controlador;

import gm.RH.controlador.excepcion.RecursoNoEncontradoExcepcion;
import gm.RH.modelo.Empleado;
import gm.RH.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/empleados/{idEmpleado}")
    public ResponseEntity<Empleado> obtenerEmpleadosPorId( @PathVariable Integer idEmpleado ){
        logger.info("Empleado buscado " + idEmpleado);
        Empleado empleado = empleadoServicio.BuscarEmpleadoPorId(idEmpleado);

        if( empleado == null )
            throw new RecursoNoEncontradoExcepcion("No se encontro empleado con id: " + idEmpleado);
        logger.info("Empleado buscado " + empleado);
        return ResponseEntity.ok(empleado);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/empleados/{idEmpleado}")
    public ResponseEntity<Empleado> actualizarEmpleadoPorId( @PathVariable Integer idEmpleado,
                                                             @RequestBody Empleado empleadoRecibido){
        logger.info("Empleado buscado " + idEmpleado);
        Empleado empleado = empleadoServicio.BuscarEmpleadoPorId(idEmpleado);

        if( empleado == null )
            throw new RecursoNoEncontradoExcepcion("No se encontro empleado con id: " + idEmpleado);

        empleado.setNombre(empleadoRecibido.getNombre());
        empleado.setDepartamento(empleadoRecibido.getDepartamento());
        empleado.setSueldo(empleadoRecibido.getSueldo());
        empleadoServicio.guardarEmpleado(empleado);

        logger.info("Empleado buscado " + empleado);
        return ResponseEntity.ok(empleado);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/empleados/{idEmpleado}")
    public ResponseEntity<Map<String, Boolean >> elimnarEmpleado(@PathVariable Integer idEmpleado ){
        logger.info("Empleado a eliminar " + idEmpleado);
        Empleado empleado = empleadoServicio.BuscarEmpleadoPorId(idEmpleado);

        if( empleado == null )
            throw new RecursoNoEncontradoExcepcion("No se encontro empleado con id: " + idEmpleado);
        logger.info("Empleado a eliminar " + empleado);
        empleadoServicio.elimarEmpleado(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();

        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}