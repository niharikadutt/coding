package com.practice.DS.DP;

public class MaximumStrokes {

	public static void main(String[] args) {
		System.out.println(maximumNoOfA(20));
	}
	
	private static int maximumNoOfA(int n){
		if(n<7)
			return n;
		
		int As[] = new int[n];
		
		for(int i=0;i<7;i++){
			As[i] = i;
		}
		
		for(int i=7;i<=n;i++){
			As[i-1]=0;
			
			
			for(int b=i-3;b>=1;b--){
				int curr = (i-b-1)*As[b-1];
				if(curr>As[i-1]){
					As[i-1] = curr;
				}
			}
		}
		
		return As[n-1];
	}

}
