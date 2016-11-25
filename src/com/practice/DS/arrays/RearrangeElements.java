package com.practice.DS.arrays;

public class RearrangeElements {

	public static void main(String[] args) {
		int arr[] = {2, 0, 1, 4, 5, 3};
        int n = arr.length;
       // printArray(arr, n);
        rearrangeTwo(arr, n);
	}
	
	private static void rearrangeTwo(int[] a, int n){
		 int i;
		for(i=0;i<n;i++)
			a[a[i]%n] = a[a[i]%n] + i*n;

			for(i=0;i<n;i++){
			a[i] = a[i]/n;
			System.out.println(a[i]);
			}
	}
	
	private static void printArray(int arr[], int n){
		 int i;
	        for (i = 0; i < n; i++)
	            arr[i]++; 
	        // Process all cycles
	        for (i = 0; i < n; i++)
	        {
	            // Process cycle starting at arr[i] if this cycle is
	            // not already processed
	            if (arr[i] > 0)
	                rearrangeUtil(arr, n, i);
	        }
	        // Change sign and values of arr[] to get the original
	        //  values back, i.e., values in range from 0 to n-1
	        for (i = 0; i < n; i++){
	            arr[i] = (-arr[i]) - 1;
	         System.out.println(arr[i]);   
	        }
	        
	        
	}
	
	private static void rearrangeUtil(int arr[], int n, int i){
		 int val = -(i + 1);
         
	        // The next index is determined
	        // using current value
	        i = arr[i] - 1;  
	 
	        // While all elements in cycle are not processed
	        while (arr[i] > 0) 
	        {
	            // Store value at index as it is going to be
	            // used as next index
	            int new_i = arr[i] - 1;
	 
	            // Update arr[]
	            arr[i] = val;
	 
	            // Update value and index for next iteration
	            val = -(i + 1);
	            i = new_i;
	        }
	}

}
