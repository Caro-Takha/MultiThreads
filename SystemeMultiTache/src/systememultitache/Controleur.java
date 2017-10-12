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
public class Controleur extends TimerTask{
    private Chauffage C;
    private Pompe P;
    private CapteurPression CP;
    private CapteurTemperature CT;
    private double Seuil_T;
    private double Seuil_P;
    
    public Controleur (Chauffage Cha, Pompe Pom, CapteurTemperature CapT, CapteurPression CapP, double SeuilT, double SeuilP){
        C=Cha;
        P=Pom;
        CP=CapP;
        CT=CapT;
        Seuil_T=SeuilT;
        Seuil_P=SeuilP;
    }

    @Override
    public void run() {
        if (CT.getTemperature()>Seuil_T){
            C.setGo_chauffage(false);}
        else 
            C.setGo_chauffage(true);
        if (CP.getPression()>Seuil_P){
            P.setGo_pompe(true);}
        else
            P.setGo_pompe(false);   
    }
}
