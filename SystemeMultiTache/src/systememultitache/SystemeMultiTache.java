/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

import java.util.Timer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Caro
 */
public class SystemeMultiTache {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lock lock=new ReentrantLock();
        Timer timer = new Timer();
        Chauffage C=new Chauffage();
        Pompe P=new Pompe();   
        CapteurTemperature CT=new CapteurTemperature(C,lock);
        CapteurPression CP=new CapteurPression(P,lock);
        CT.start();
        CP.start();
            
        Controleur controleur=new Controleur(C,P,CT,CP,23,1.2,lock);
        controleur.start();
        timer.schedule(new Ecran(CT,CP,C,P),20,2000);
    }
    
}
