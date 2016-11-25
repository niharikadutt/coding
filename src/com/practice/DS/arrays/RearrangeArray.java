package com.practice.DS.arrays;

public class RearrangeArray {

	public static void main(String[] args) {
		int ar[] = {1, 3, 0, 2};
		rearrangeArray(ar, ar.length);
	}

	private static void rearrangeArray(int[] ar, int n) {
		for(int i=0;i<n;i++){
			int j = ar[i]%n;
			ar[j] = ar[j]+i*n;
		}
		
		for(int i=0;i<n;i++){
			System.out.println(ar[i]/n);
		}
	}
	
}
