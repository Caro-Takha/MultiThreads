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
public class TestMcl {

    
    public static void main(String[] args) throws InterruptedException {
        long start=System.nanoTime();
        int numTir=100000000;
        int numThread=8;
        
        double res=0;
        MyThread Ids[]= new MyThread[numThread];
        for (int i=0;i<numThread;i++){
            Ids[i]=new MyThread(numTir/numThread);
            Ids[i].start();
        }
        for (int k=0;k<numThread;k++){
            
                Ids[k].join();
                res+=Ids[k].getResultat();
            
        }
        long end=System.nanoTime();
        System.out.println("pi="+res/numThread*4+"\nfait en:"+(end-start)/1e9+"sec");
        
    }
}
