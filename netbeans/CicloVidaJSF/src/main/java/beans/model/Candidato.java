/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.model;



import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */

@Named("candidato")
@SessionScoped
public class Candidato implements Serializable{
    
    private static final Logger log = LoggerFactory.getLogger( Candidato.class );
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    public Candidato(){
        log.info("Creando el objeto candidato");
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        log.info("Actualizando nombre" + apellido);
        this.apellido = apellido;
    }

    public int getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(int salarioDeseado) {
        log.info("Actualizando nombre" + salarioDeseado);
        this.salarioDeseado = salarioDeseado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        log.info("Actualizando nombre" + nombre);
        this.nombre = nombre;
    }
}
