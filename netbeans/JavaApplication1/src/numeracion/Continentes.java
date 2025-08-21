/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numeracion;

import com.sun.nio.sctp.Association;
import java.security.cert.PKIXRevocationChecker;

/**
 *
 * @author jesus
 */
public enum Continentes {
        AFRICA(53, "1.2 Billones"),
        EUROPA(46, "1.8 Billones"),
        ASIA(44, "1.5 Billones"),
        OCEANICA(14, "0.8 Billones"),
        AMERICA(34, "1.2 Billones");
        
    private final int paises;
    private final String habitantes;
    
    Continentes(int paises, String habitantes){
        this.paises = paises;
        this.habitantes = habitantes;
    }
    
    public int getPaises(){
        return this.paises;
    }
    
    public String getHabitantes(){
        return this.habitantes;
    }
}
