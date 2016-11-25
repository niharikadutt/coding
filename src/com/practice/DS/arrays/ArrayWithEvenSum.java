package com.practice.DS.arrays;

public class ArrayWithEvenSum {

	public static void main(String[] args) {
		int ar[] = {1, 2, 2, 3, 4, 1};
		System.out.println(countEvenSum(ar, ar.length));
	}
	
	private static int countEvenSum(int ar[], int n){
		int sum = 0, odd=0, even=1;
		for(int i=0;i<n;i++){
			sum=(sum+ar[i])%2;
		    if(sum==0)++even;
		    else ++odd;
		}
		
		return (even*(even-1)/2)+(odd*(odd-1)/2);
	}

}
