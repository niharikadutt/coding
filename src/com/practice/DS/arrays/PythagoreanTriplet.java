package com.practice.DS.arrays;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		 int ar[] = {3, 1, 4, 6, 5};
		 System.out.println(findIfTripletExist(ar,ar.length));
		 
	}
	
	private static boolean findIfTripletExist(int[] ar, int n){
		//changa ar[i]=ar[i]*ar[i]
		for(int i=0;i<n;i++){
			ar[i] = ar[i]*ar[i];
		}
		
		Arrays.sort(ar);
		
		for(int i=0;i<n-2;i++){
			int a = ar[i];
			int b = ar[i+1];
			if(search(ar, a+b, i+2, n-1)){
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean search(int[] ar, int leftSide, int low, int high){
		while(low<high){
			int mid = (low+high)/2;
			if(leftSide==ar[mid]){
				return true;
			}
			else if(leftSide<ar[mid]){
				high = mid-1;
			}
			else{
				low = mid+1;
			}
			
		}
		
		return false;
	}

}
