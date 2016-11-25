package com.practice.DS.arrays;

public class CalculateFrequency {

	public static void main(String[] args) {
		int arr[] = {2, 3, 3, 2, 5};
		printFrequency(arr);
	}
	
	private static void printFrequency(int arr[]){
		int n=arr.length;
		for(int i=0;i<arr.length;i++){
			arr[i]=arr[i]-1;
		}
		
		for(int i=0;i<arr.length;i++){
			arr[arr[i]%n] = arr[arr[i]%n]+n;
		}
		
		for(int i=0;i<n;i++){
			System.out.println(i+1+"->"+arr[i]/n);
		}
	}

}
