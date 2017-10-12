/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Caro
 */
public class FonctionTemps extends TimerTask{
    private CapteurTemperature CT;
    private CapteurPression CP;
    private Chauffage C;
    private Pompe P;
    
    public FonctionTemps(CapteurTemperature Capteur, Chauffage Cha, CapteurPression CapP, Pompe Pom){
        CT=Capteur;
        C=Cha;
        CP=CapP;
        P=Pom;
    }

    @Override
    public void run() {
        int R1=ThreadLocalRandom.current().nextInt(0,2);
        if (R1==1){
            CP.setPression(CP.getPression()+0.05);}
        else{
            CP.setPression(CP.getPression()-0.05);}
        if (P.isGo_pompe()==true){
            CP.setPression(CP.getPression()-0.05);}
        
        int R2=ThreadLocalRandom.current().nextInt(0,2);
        if (R2==1){
            CT.setTemperature(CT.getTemperature()+0.5);}
        else{ 
            CT.setTemperature(CT.getTemperature()-0.5);}
        
        if (C.isGo_chauffage()==true){
            CT.setTemperature(CT.getTemperature()+0.5);}
        
    }
        
}
