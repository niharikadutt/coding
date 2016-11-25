package com.practice.DS.DP;

public class MaximumSum {

	public static void main(String[] args) {
		int ar[] = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(getMaximumSum(ar, ar.length));
	} 
	
	private static int getMaximumSum(int[] ar, int n){
		int sum[] = new int[n];
		
		for(int i=0;i<n;i++){
			sum[i] = ar[i];
		}
		
		int max = 0;
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(ar[i]>ar[j] && sum[i]<sum[j]+ar[i]){
					sum[i] = sum[j]+ar[i];
				}
			}
		}
		
		for(int i=0;i<n;i++){
			if(sum[i]>max){
			max = sum[i];
			}
		}
		
		return max;
	}

}
