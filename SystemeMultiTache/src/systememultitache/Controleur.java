/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.*;

/**
 *
 * @author Caro
 */
public class Controleur extends Thread{
    private Chauffage C;
    private Pompe P;
    private CapteurPression CP;
    private CapteurTemperature CT;
    private double Seuil_T;
    private double Seuil_P;
    private Lock lock;
    
    
    public Controleur (Chauffage Cha, Pompe Pom, CapteurTemperature CapT, CapteurPression CapP, double SeuilT, double SeuilP,Lock l){
        lock=l;
        C=Cha;
        P=Pom;
        CP=CapP;
        CT=CapT;
        Seuil_T=SeuilT;
        Seuil_P=SeuilP;
    }

    @Override
    public void run() {
        while (true){
            double pression=1;
            double temperature=20;
            lock.lock();
            try {
                pression=CP.getPression();
                temperature=CT.getTemperature();
            } finally {
                lock.unlock();
            }
            if (temperature>Seuil_T){
                C.setGo_chauffage(false);}
            else 
                C.setGo_chauffage(true);
            if (pression>Seuil_P){
                P.setGo_pompe(true);}
            else{
                P.setGo_pompe(false);
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
