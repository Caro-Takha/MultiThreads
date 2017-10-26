/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtribulle;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 *
 * @author Océane
 */
public class TestTriBulle {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int taille=10000;
        double[] T = new double[taille];
        for (int i = 0; i < taille; ++i){
            int randomInt = ThreadLocalRandom.current().nextInt(0,1000);
            T[i]=randomInt;
        }
        long start=System.nanoTime();
        double[] T1=tri_bulle_thread(T);
        long end=System.nanoTime();
        System.out.println("Avec 2 Threads:"+Arrays.toString(T1)+"\nTps: "+(end-start)/1e6+"ms");
        double[] T2 = new double[taille];
        for (int i = 0; i < taille; ++i){
            int randomInt = ThreadLocalRandom.current().nextInt(0,1000);
            T2[i]=randomInt;
        }
        long start2=System.nanoTime();
        double [] T3=tri_bulle_0thread(T2);
        long end2=System.nanoTime();
        System.out.println("sans Thread:"+Arrays.toString(T3)+"\nTps: "+(end2-start2)/1e6+"ms");
    }
    
    
    public static double[] tri_bulle_thread(double[] T){
        if (T.length<2){
            return T;
        }
        else{
            int l1=(int) Math.floor(T.length/2);
            double[] T1=new double[l1];
            double[] T2=new double[T.length-l1];
            for (int i=0; i<l1; i++){
                T1[i]=T[i];
            }
            for (int i=l1; i<T.length; i++){
                T2[i-l1]=T[i];
            }
            MyThread myThread1=new MyThread(T1);
            MyThread myThread2=new MyThread(T2);
            myThread1.start();
            myThread2.start();
            try {
                myThread1.join();
                myThread2.join();
            } catch (InterruptedException ex) {
            }
            merge(T1,T2,T);
            return T;
        }
    }
    
    public static void merge(double[] T1,double[] T2, double[] T){
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
    
    public static double[] tri_bulle_0thread(double[] T){
        if (T.length<2){
            return T;
        }
        else{
            int l1=(int) Math.floor(T.length/2);
            double[] T1=new double[l1];
            double[] T2=new double[T.length-l1];
            for (int i=0; i<l1; i++){
                T1[i]=T[i];
            }
            for (int i=l1; i<T.length; i++){
                T2[i-l1]=T[i];
            }
            tri_bulle(T1);
            tri_bulle(T2);
            merge(T1,T2,T);
            return T;
        }
    }
    
    public static void tri_bulle(double[] T){
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
