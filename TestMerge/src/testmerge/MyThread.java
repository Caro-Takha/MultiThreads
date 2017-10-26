/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmerge;
import java.util.*;
import static testmerge.TestMerge.merge;


/**
 *
 * @author Océane
 */
public class MyThread extends Thread {
    private int[] T;
    public MyThread(int[] t){
        T=t;
    }

    @Override
    public void run() {
        if (T.length>=2){
            int l1=(int) Math.floor(T.length/2);
            int[] T1=new int[l1];
            int[] T2=new int[T.length-l1];
            for (int i=0; i<l1; i++){
                T1[i]=T[i];
            }
            for (int i=l1; i<T.length; i++){
                T2[i-l1]=T[i];
            }
            merge_sort(T1);
            merge_sort(T2);
            
            merge(T1,T2,T);
            
        }
    }
    
    
    public static int[] merge_sort(int[] t){
        if (t.length<2){
            return t;
        }
        else{
            int l1=(int) Math.floor(t.length/2);
            int[] T1=new int[l1];
            int[] T2=new int[t.length-l1];
            for (int i=0; i<l1; i++){
                T1[i]=t[i];
            }
            for (int i=l1; i<t.length; i++){
                T2[i-l1]=t[i];
            }
            merge_sort(T1);
            merge_sort(T2);
            
            merge(T1,T2,t);
            return t;
        }
    }
}

