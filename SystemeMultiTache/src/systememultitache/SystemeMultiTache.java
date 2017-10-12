/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

import java.util.Timer;

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
        Timer timer = new Timer();
        CapteurTemperature CT=new CapteurTemperature();
        CapteurPression CP=new CapteurPression();
        Chauffage C=new Chauffage();
        Pompe P=new Pompe();       
        timer.schedule(new FonctionTemps(CT,C,CP,P),20,2000);
        timer.schedule(new Controleur(C,P,CT,CP,23,1.2),20,2000);
        timer.schedule(new Ecran(CT,CP,C,P),20,2000);
    }
    
}
