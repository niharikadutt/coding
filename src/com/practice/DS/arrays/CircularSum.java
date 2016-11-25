package com.practice.DS.arrays;

public class CircularSum {

	public static void main(String[] args) {
		int ar[] = {8, -8, 9, -9, 10, -11, 12};
		System.out.println(maxCircularSum(ar, ar.length));
	}

	private static int maxCircularSum(int[] ar, int n) {
		int maxKadane = max(ar);
		
		int maxWrap = 0;
		int total = 0;
		for(int i=0;i<n;i++){
			total+=ar[i];
			ar[i] = -ar[i];			
		}
		
		maxWrap = max(ar);
		return Math.max(maxKadane, total+maxWrap);
	}
	
	private static int max(int[] ar){
		int max_so_far =ar[0]; int max_curr = ar[0];
		
		for(int i=1;i<ar.length;i++){	
			max_curr = Integer.max(ar[i], max_curr+ar[i]);
			max_so_far = Integer.max(max_curr, max_so_far);
			
		}
		
		return max_so_far;
	}

}
