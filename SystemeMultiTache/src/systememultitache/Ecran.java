/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

import java.util.TimerTask;

/**
 *
 * @author Caro
 */
public class Ecran extends TimerTask{
    private CapteurTemperature CT;
    private CapteurPression CP;
    private Chauffage C;
    private Pompe P;
    
    public Ecran(CapteurTemperature CapT, CapteurPression CapP, Chauffage Cha, Pompe Pom){
        CT=CapT;
        CP=CapP;
        C=Cha;
        P=Pom;
    }
    public void run(){
        System.out.println("La température est de "+CT.getTemperature()+" degrés et la pression est de "+CP.getPression()+" bars.");
        System.out.println("Chauffage: "+C.isGo_chauffage()+"\nPompe: "+ P.isGo_pompe());
    }   
}
