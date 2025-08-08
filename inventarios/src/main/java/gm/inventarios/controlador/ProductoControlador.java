package gm.inventarios.controlador;


import gm.inventarios.exception.RecursoNoEncontradoException;
import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app")
@CrossOrigin( value = "http://localhost:4200" )
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger( ProductoControlador.class );

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping( "/productos" )
    public List<Producto> obtenerProducto(){
        List<Producto> productos =  this.productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach( producto -> logger.info(producto.toString()) );
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto( @RequestBody Producto producto ){
        logger.info("Producto a agregar " + producto);
        return this.productoServicio.guardarProducto(producto);
    }


    @GetMapping( "/productos/{idProducto}" )
    public ResponseEntity<Producto> obtenerProductoPorId( @PathVariable int idProducto ){
        logger.info("Id " + idProducto);
        Producto producto = this.productoServicio.buscarProductoPorId(idProducto);
        logger.info("Producto a buscar " + producto);
        if (producto != null)
        return ResponseEntity.ok( producto ) ;
        else
            throw new RecursoNoEncontradoException("No se encontro el producto con el id: " + idProducto);
    }


    @PutMapping("/productos/{idProducto}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int idProducto,
            @RequestBody Producto productoRecibido){
        logger.info("Id " + idProducto);
        Producto producto = this.productoServicio.buscarProductoPorId(idProducto);
        logger.info("Producto a agregar " + producto);
        producto.setDescripcion( productoRecibido.getDescripcion() );
        producto.setPrecio( productoRecibido.getPrecio() );
        producto.setExistencia( productoRecibido.getExistencia() );

        this.productoServicio.guardarProducto(producto);

        if (producto != null)
            return ResponseEntity.ok( producto ) ;
        else
            throw new RecursoNoEncontradoException("No se logro actualizar el producto con el id: " + idProducto);
    }



    @DeleteMapping( "/productos/{idProducto}" )
    public ResponseEntity<Map<String, Boolean>> eliminarProductoPorId(@PathVariable int idProducto ) {
        logger.info("Id " + idProducto);
        Producto producto = this.productoServicio.buscarProductoPorId(idProducto);
        logger.info("Producto a buscar " + producto);
        if (producto == null)
            throw new RecursoNoEncontradoException("No se encontro el producto con el id: " + idProducto);
        else
            this.productoServicio.eliminarProducto(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }
}
