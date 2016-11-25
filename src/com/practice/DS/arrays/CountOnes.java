package com.practice.DS.arrays;

public class CountOnes {

	public static void main(String[] args) {
			int ar[] = {1, 1, 1, 1, 1, 1, 0};
		    System.out.println(countOnes(ar,0,ar.length-1));
   }
	
	private static int countOnes(int[] ar, int l, int r){
		if(r>=l){
			int mid = l+(r-l)/2;
			if((mid==r || ar[mid+1]==0) && (ar[mid]==1))
				return mid+1;
			
			if(ar[mid]==1)
				countOnes(ar, mid+1, r);
			else
				countOnes(ar, l, mid-1);		
		}
		return -1;
		}
	}
