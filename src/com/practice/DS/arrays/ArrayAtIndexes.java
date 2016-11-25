package com.practice.DS.arrays;

public class ArrayAtIndexes {

	public static void main(String[] args) {
		int[] ar = {10, 11, 12};
		int[] indexes = {1, 0, 2};
		printNewArray(ar, indexes);
		
	}
	
	private static void printNewArray(int[] ar, int[] index){
		int n = ar.length;
		for(int i=0;i<n;i++){
			
			while(index[i]!=i){
			int oldTargetI = index[index[i]];
			int oldTargetE = ar[index[i]];
			
			ar[index[i]] = ar[i];
			index[index[i]] = index[i];
			
			index[i] = oldTargetI;
			ar[i] = oldTargetE;
			
			}
		}
		
		for(int i=0;i<n;i++){
			System.out.println(ar[i]);
		}
		
		
	}

}
