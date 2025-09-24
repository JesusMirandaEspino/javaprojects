/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.cliente;

import javax.naming.*;

/**
 *
 * @author jesus
 */
public class ClientePersonaServices {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada");
        try {
            Context jndi = new InitialContext();
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
