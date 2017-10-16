/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caro
 */
public class CapteurTemperature extends Thread{
    private double Temperature=20;
    private Chauffage C;
    private Lock lock;

    public CapteurTemperature(Chauffage C,Lock l) {
        lock=l;
        this.C = C;
    }
    

    
    @Override
    public void run(){
        while (true){
            double x=Temperature;
            int R2=ThreadLocalRandom.current().nextInt(0,2);
            if (R2==1){
                x+=0.5;}
            else{ 
                x-=0.5;}

            if (C.isGo_chauffage()==true){
                x+=0.5;}
            lock.lock();
            try {
                Temperature=x;
            } finally {
                lock.unlock();
            }
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CapteurTemperature.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public double getTemperature() {
        return Temperature;
    }

    public void setTemperature(double Temperature) {
        this.Temperature = Temperature;
    }
    
    
    
}
