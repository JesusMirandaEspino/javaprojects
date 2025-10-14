package beans;

import jakarta.ejb.Remote;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jesus
 */

@Remote
public interface SumaEJBRemote {
    public int sumar(int base, int altura);
    
}
