package com.practice.DS.arrays;

public class AtleastKElements {

	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 8, 10 };
		
		System.out.println(findMaximumNum(ar, ar.length));
	}
	
	static int findMaximumNum(int arr[], int n)
	{
	    // construct axillary array of size n + 1 and
	    // initialize the array with 0
	    int freq[] = new int[n+1];
	 
	    // store the frequency of elements of
	    // input array in the axillary array
	    for (int i = 0; i < n; i++)
	    {
	        // If element is smaller than n, update its
	        // frequency
	        if (arr[i] < n)
	            freq[arr[i]]++;
	 
	        // Else increment count of elements greater
	        // than n.
	        else
	            freq[n]++;
	    }
	 
	    // sum stores number of elements in input array
	    // that are greater than or equal to current
	    // index
	    int sum = 0;
	 
	    // scan auxillary array backwards
	    for (int i = n; i > 0; i--)
	    {
	        sum += freq[i];
	 
	        // if sum is greater than current index,
	        // current index is the answer
	        if (sum >= i)
	            return i;
	    }
	    
	    return -1;
	}

}
