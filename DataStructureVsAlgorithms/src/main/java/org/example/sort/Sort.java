package org.example.sort;

import java.util.Arrays;
import java.util.ServiceLoader;

public class Sort {

    public static void Bubble(int[] a){
        int n = a.length;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n-i-1 ; j++){
                if(a[j] > a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
    }

    public static boolean isSortedBubble(int[] a){
        int n = a.length;
        boolean check = true;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n-i-1 ; j++){
                if(a[j] > a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    check = false;
                }
            }
        }
        return check;
    }

    public static void Insertion(int[] a){
        int n = a.length;
        for(int i=1 ; i<n ; i++){
            // chèn a[i] vào dãy 0 -> i-1;
            int ai = a[i];
            int j=i-1;
            while (j >= 0 && a[j] > ai){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
        }
    }

    public static void Selection(int[] a){
        int n = a.length;
        for(int i=0 ; i<n ; i++){
            int minIndex = i;
            for(int j=i+1 ; j<n ; j++){
                if(a[j] < a[minIndex]) minIndex = j;
            }
            if(minIndex != i){
                int t = a[i];
                a[i] = a[minIndex];
                a[minIndex] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,7,2,1,};
        Selection(a);
        Arrays.stream(a).forEach(t -> System.out.println(t));
    }
}
