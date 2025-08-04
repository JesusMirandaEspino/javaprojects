package gm.Empleados.controlador;

import gm.Empleados.modelo.Empleado;
import gm.Empleados.servicio.EmpleadoServicio;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexControlador {
    private static final Logger logger = LoggerFactory.getLogger( IndexControlador.class );

    @Autowired
    EmpleadoServicio empleadoServicio;


    @RequestMapping( value="/", method = RequestMethod.GET)
    public String inicial(ModelMap modelo){
        List<Empleado> empleados = empleadoServicio.ListarEmpleados();
        empleados.forEach( (empleado) -> logger.info(empleado.toString()) );
        modelo.put("empleados", empleados);
        return "index";
    }

    @RequestMapping( value="/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar";
    }

    @RequestMapping( value="/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma")Empleado empleado, HttpServletRequest request){
        logger.info( "Empleado a agregar " + empleado );
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }


    @RequestMapping( value="/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        logger.info( "Empleado a agregar " + empleado );

        modelo.put( "empleado", empleado );

        return "editar";
    }



    @RequestMapping( value="/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma")Empleado empleado, HttpServletRequest request){
        logger.info( "Empleado a editar " + empleado );
        empleadoServicio.guardarEmpleado(empleado);

        return "redirect:/";
    }



    @RequestMapping( value="/eliminar", method = RequestMethod.GET)
    public String mostrarEliminar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        logger.info( "Empleado a agregar " + empleado );

        modelo.put( "empleado", empleado );

        return "eliminar";
    }



    @RequestMapping( value="/eliminar", method = RequestMethod.POST)
    public String eliminar(@ModelAttribute("empleadoForma")Empleado empleado, HttpServletRequest request){
        logger.info( "Empleado a editar " + empleado );
        empleadoServicio.eliminarEmpleado(empleado);

        return "redirect:/";
    }


}
