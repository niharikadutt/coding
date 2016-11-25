package com.practice.DS.arrays;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String input = sc.nextLine();
		String[] arString = input.split(" ");
		int[] ar = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(arString[i]);
		}

		reverseArray(ar, ar.length);
        
    }
    private static void reverseArray(int[] ar, int n){
        int i=0,j=n-1;
        while(i<j){
            int temp =  ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;j--;
        }
        
        for(int k=0;k<ar.length;k++){
            System.out.print(ar[k]+" ");
        }
    }
}
