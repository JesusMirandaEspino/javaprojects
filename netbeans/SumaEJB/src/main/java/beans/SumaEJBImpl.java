/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import jakarta.ejb.Stateless;

/**
 *
 * @author jesus
 */

@Stateless
public class SumaEJBImpl implements SumaEJBRemote{

    @Override
    public int sumar(int base, int altura) {
        System.out.println("Ejecutando la suma en el servidor");
        return base + altura;
    }
    
}
