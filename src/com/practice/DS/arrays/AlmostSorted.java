package com.practice.DS.arrays;

public class AlmostSorted {

	public static void main(String[] args) {
		int[] ar = {3, 2, 10, 4, 40};
		System.out.println(findElement(ar, 0, ar.length-1, 4));
	}
	
	private static int findElement(int[] ar, int l, int r ,int x){
		if(r>=l){
			int mid = l+r/2;
			
			if(x==ar[mid]) return mid;
			if(x==ar[mid+1]) return mid+1;
			if(x==ar[mid-1]) return mid-1;
			
			if(x>ar[mid]) 
				findElement(ar, mid+2, l, x);
			else
				findElement(ar, l, mid-2, x);
		}
		
		return -1;
	}

}
