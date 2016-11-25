package com.practice.DS.tree;

public class SunsetProblem{
    public static void main(String ar[]){
    	int arr[] = {12, 11, 15, 16, 9, 4, 6, 21, 18};
    	printAllSunsetBuildings(arr);
    }
    private static void printAllSunsetBuildings(int[] arr){
    	int n = arr.length;
    	int maxSoFar = arr[n-1];
    	int[] res = new int[n];
    	res[0] = maxSoFar;
    	int j=1;
    	for(int i=n-2;i>=0;i--){
    		if(arr[i]>=maxSoFar){
    			maxSoFar = arr[i];
    			res[j++]=arr[i];
    		}
    	}
    	
    	for(int i=0;i<res.length;i++){
    		System.out.println(res[i]);
    	}
    	
    }
	
}
