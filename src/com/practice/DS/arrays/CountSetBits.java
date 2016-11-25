package com.practice.DS.arrays;

public class CountSetBits {

	public static void main(String[] args) {
		int n = 9;
		System.out.println(getCount(n));

	}
	
	private static int getCount(int n){
		int count=0;
		while(n>0){
			n&=(n-1);
			
			count++;
		}
		
		return count;
	}

}
