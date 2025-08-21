/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import numeracion.Continentes;
import numeracion.Dias;


/**
 *
 * @author jesus
 */
public class TestEnumeracion {
    public static void main(String[] args) {
        System.out.println("Dia Lunes: " + Dias.LUNES );
        indicarDiaSemana(Dias.MARTES);
        System.out.println("Continente 1: " + Continentes.AFRICA );
        System.out.println("Poblacion Continente 1: " + Continentes.AFRICA.getHabitantes() );
    }
    
    static{
        System.out.println("Inicializando static. " );
    }
    
    {
        System.out.println("Inicializando bloque. " );
    }
    
    private static void indicarDiaSemana(Dias dias){
        
        switch (dias) {
            case LUNES:
                    System.out.println("Dia Lunes: " + Dias.LUNES );
                break;
            case MARTES:
                    System.out.println("Dia Martes: " + Dias.MARTES );
                break;
            case MIERCOLES:
                    System.out.println("Dia Mirecoles: " + Dias.MIERCOLES );
                break;
            case JUEVES:
                    System.out.println("Dia Jueves: " + Dias.JUEVES );
                break;
            default:
                throw new AssertionError();
        }
        
    }
}
