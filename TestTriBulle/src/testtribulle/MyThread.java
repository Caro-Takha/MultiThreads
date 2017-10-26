/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtribulle;
import java.util.*;


/**
 *
 * @author Océane
 */
public class MyThread extends Thread {
    private double[] T;
    public MyThread(double[] t){
        T=t;
    }

    @Override
    public void run() {
        for (int i=0;i<T.length;i++){
            for (int j=i+1;j<T.length;j++){
                if (T[j]<T[i]){
                    double temp=T[i];
                    T[i]=T[j];
                    T[j]=temp;
                }
            }
        }
    }
    
    
    
}

