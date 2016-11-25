package com.practice.DS.DP;

public class MaximumDifference {

	public static void main(String[] args) {
		int ar[] = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(findMaxDiff(ar));
	}
	
	private static int findMaxDiff(int ar[]){
		int min = ar[0];
		int maxDiff = ar[1]-ar[0];
		
		for(int i=1;i<ar.length;i++){
			if(ar[i]-min>maxDiff){
				maxDiff=ar[i]-min;
			}
			if(ar[i]<min)
				min=ar[i];
		}
		return maxDiff;
	}

}
