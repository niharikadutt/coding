package com.practice.DS.arrays;

public class MaximumProduct {

	public static void main(String[] args) {
		int[] ar = {2,3,-2,4};
		System.out.println(maxProduct(ar));
	}
	
	private static int maxProduct(int[] ar){
		int res = ar[0];
		int maxp = ar[0];
		int minp = ar[0];
		
		for(int i=1;i<ar.length;i++){
			int tempMaxp = maxp;
			int tempMinp = minp;
			
			maxp = Math.max(Math.max(tempMaxp*ar[i], tempMinp*ar[i]), ar[i]);
			minp = Math.min(Math.min(tempMaxp*ar[i], tempMinp*ar[i]), ar[i]);
			
			res = Math.max(maxp, res);
		}
		
		return res;
	}

}
