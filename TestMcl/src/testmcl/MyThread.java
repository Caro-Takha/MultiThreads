/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmcl;

import java.util.Random;

/**
 *
 * @author Océane
 */
public class MyThread extends Thread {
    private double resultat;
    private int numTir;
    
    
    public MyThread(int nT){
        numTir=nT;
    }
    
    @Override
    public void run(){
        double sousTot=0;
        Random rnd=new Random();
        for (int j=0;j<numTir;j++){
            double xr=rnd.nextDouble();
            double yr=rnd.nextDouble();
            if (Math.sqrt(xr*xr+yr*yr)<1){
                sousTot+=1;
            }
        }
        resultat=sousTot/numTir;
        //System.out.println(resultat);
        
    }
    

    public double getResultat() {
        return resultat;
    }
}

