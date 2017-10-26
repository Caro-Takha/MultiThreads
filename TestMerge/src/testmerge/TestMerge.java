/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmerge;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Océane
 */
public class TestMerge {
    private static int nbT;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        nbT=0;
        int taille=100000;
        int[] T = new int[taille];
        Random randomGenerator = new Random();
        for (int i = 0; i < taille; ++i){
            int randomInt = randomGenerator.nextInt(1000);
            T[i]=randomInt;
        }
        long start=System.nanoTime();
        int[] T1=merge_sort(T);
        long end=System.nanoTime();
        
        System.out.println(Arrays.toString(merge_sort(T))+"\nNombre de Thread: "+nbT+"\nTps: "+(end-start)/1e6+"ms");
        
    }
    
    public static int[] merge_sort(int[] T){
        if (T.length<2){
            return T;
        }
        else{
            int l1=(int) Math.floor(T.length/2);
            int[] T1=new int[l1];
            int[] T2=new int[T.length-l1];
            for (int i=0; i<l1; i++){
                T1[i]=T[i];
            }
            for (int i=l1; i<T.length; i++){
                T2[i-l1]=T[i];
            }
            
            if (nbT<6){
                nbT++;
                MyThread myThread=new MyThread(T1);
                myThread.start();
                merge_sort(T2);
                try {
                    myThread.join();
                } catch (InterruptedException ex) {
                }
            }
            else{
                merge_sort(T1);
                merge_sort(T2);
            }
            
            merge(T1,T2,T);
            return T;
        }
    }
    
    public static void merge(int[] T1,int[] T2, int[] T){
        int i=0;
        int i1=0;
        int i2=0;
        while (i1<T1.length && i2<T2.length){
            if (T1[i1]<T2[i2]){
                T[i]=T1[i1];
                i++;
                i1++;
            }
            else{
                T[i]=T2[i2];
                i++;
                i2++;
            }
        }
        while (i1<T1.length){
            T[i]=T1[i1];
            i++;
            i1++;
        }
        while (i2<T2.length){
            T[i]=T2[i2];
            i++;
            i2++;
        }
    }
    
    
    
}
