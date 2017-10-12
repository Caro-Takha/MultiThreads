/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systememultitache;

/**
 *
 * @author Caro
 */
public class Chauffage extends Thread{
    private boolean go_chauffage;
    
    public void run(){
    }
    
    public Chauffage(){
        go_chauffage=false;
    }   

    public boolean isGo_chauffage() {
        return go_chauffage;
    }

    public void setGo_chauffage(boolean go_chauffage) {
        this.go_chauffage = go_chauffage;
    }
    
}
