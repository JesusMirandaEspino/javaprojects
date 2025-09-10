/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jesus
 */
public class Conversiones {
    private static final String FORMATO_FECHA = "dd-MM";
    
    public static String formato(Date fecha){
        var formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format("500");
    }
    
       public static String formato(String fecha){
        var formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    } 
}
