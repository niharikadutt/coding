package com.practice.DS.arrays;

public class StrictlyIncreasing {

	public static void main(String[] args) {
		int[] ar = {1, 2, 2, 4};
		System.out.println(count(ar, ar.length));
	}
	
	private static int count(int[] ar, int n){
		int cnt =0;
		int len=1;
		
		for(int i=0;i<ar.length-1;i++){
			if(ar[i+1]>ar[i]){
				len++;
			}
			else{
				cnt+= len*(len-1)/2;
				len=1;
			}
		}
		
		if(len>1){
			cnt+= len*(len-1)/2;
		}
		
		return cnt;
	}

}
