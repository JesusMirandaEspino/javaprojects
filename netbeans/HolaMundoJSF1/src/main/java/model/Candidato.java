/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jesus
 */

@Named
@RequestScoped
public class Candidato {
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNacimiento;
    private String codigoPostal;
    private String colonia;
    private String ciudad;
    private String comentario;
    
    Logger log = LogManager.getRootLogger();

    public Candidato() {
        log.info("Creando el objeto candidato");
        this.setNombre("Introduce tu nombre");
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        log.info("Modificando apellido");
        this.apellido = apellido;
    }

    public int getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(int salarioDeseado) {
        log.info("Modificando salario deseado");
        this.salarioDeseado = salarioDeseado;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre");
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String cuidad) {
        this.ciudad = cuidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
}
