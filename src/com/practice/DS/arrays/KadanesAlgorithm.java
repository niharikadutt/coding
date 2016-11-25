package com.practice.DS.arrays;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		int[] ar = {4, -3, 4, -1, -2, 5, -5, -3};
		System.out.println(max(ar));
	}
	
	private static int max(int[] ar){
		int max_so_far =ar[0]; int max_curr = ar[0];
		int startInt = 0;
		int[] result = new int[3];
		
		for(int i=1;i<ar.length;i++){	
			max_curr = Integer.max(ar[i], max_curr+ar[i]);
			max_so_far = Integer.max(max_curr, max_so_far);
			
		}
		
		return max_so_far;
	}

}
