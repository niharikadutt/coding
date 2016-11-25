package com.practice.DS.arrays;

public class ReverseInKSets {

	public static void main(String[] args) {
		int ar[] = {1, 2, 3, 4, 5, 6, 7, 8};
		ar = reverseInKSets(ar, 3);
		for(int i=0;i<ar.length;i++){
			System.out.println(ar[i]);
		}
		
	}
	
	private static int[] reverseInKSets(int[] ar, int k){
		for(int i=0;i<ar.length;i+=k){
			int left = i;
			int right = Integer.min(i+k-1, ar.length-1);
			
			while(left<right){
				int temp = ar[left];
				ar[left] = ar[right];
				ar[right] = temp;
				left++;right--;
			}
			
		}
		
		return ar;
	}
	
}
