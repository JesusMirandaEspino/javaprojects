/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jesus
 */
public class Conversiones {
    private static final String formatoFecha = "dd-MM";
    
    public static String formato(String fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
        
        return formateador.format(fecha);
        
    }
    
}
