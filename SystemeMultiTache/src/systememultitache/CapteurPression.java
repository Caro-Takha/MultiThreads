/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.*;

/**
 *
 * @author Caro
 */
public class CapteurPression extends Thread{
    private double Pression=1;
    private Pompe P;
    private Lock lock;
    

    public CapteurPression(Pompe P,Lock l) {
        lock=l;
        this.P = P;
    }
    
    @Override
    public void run(){
        while (true){
        double x=Pression;
        int R1=ThreadLocalRandom.current().nextInt(0,2);
        if (R1==1){
            x+=0.05;
        }
        else{
            x-=0.05;}
        if (P.isGo_pompe()==true){
            x-=0.05;
        }
        lock.lock();
        try {
            Pression=x;
        } finally {
            lock.unlock();
        }
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CapteurPression.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public double getPression() {
        return Pression;
    }


    
    
    
}
