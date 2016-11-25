package com.practice.DS.DP;

import java.util.Arrays;

public class SubsetSumProblem {

	    // Returns true if there is a subset of set[] with sum
	        // equal to given sum
	    static boolean isSubsetSum(int set[], int n, int sum, int[] result)
	    {
	       // Base Cases
	       if (sum == 0){
	    	 Arrays.stream(result).forEach(System.out::println);
	         return true;
	       }
	       if (n == 0 && sum != 0)
	         return false;
	      
	       // If last element is greater than sum, then ignore it
	       if (set[n-1] > sum)
	         return isSubsetSum(set, n-1, sum, result);
	      
	       /* else, check if sum can be obtained by any of the following
	          (a) including the last element
	          (b) excluding the last element   */
	       return isSubsetSum(set, n-1, sum, result) || 
	                                   isSubsetSum(set, n-1, sum-set[n-1], Arrays.stream(result).filter(x -> x!=set[n-1]).toArray());
	    }
	    
	    private static boolean isSubsetSumDP(int set[], int n, int sum){
	    	boolean subset[][] = new boolean[sum+1][n+1];
	    	for(int i=0;i<=n;i++)
	    		subset[0][i] = true;
	    	
	    	for(int i=0;i<=sum;i++)
	    		subset[i][0] = false;
	    	
	    	for(int i=1;i<=sum;i++){
	    		for(int j=1;j<=n;j++){
	    			subset[i][j] = subset[i][j-1];
	    			if(i>=set[j-1]){
	    				subset[i][j] = subset[i][j] || subset[i-set[j-1]][j-1];
	    			}
	    		}
	    	}
	    	
	    	return subset[sum][n];
	    }
	    /* Driver program to test above function */
	    public static void main (String args[])
	    {
	          int set[] = {3, 34, 4, 12, 5, 2, 7,1};
	          int sum = 10;
	          int n = set.length;
//	          if (isSubsetSum(set, n, sum, set) == true)
//	             System.out.println("Found a subset with given sum");
//	          else
//	             System.out.println("No subset with given sum");
	          
	          if (isSubsetSumDP(set, n, sum) == true)
		             System.out.println("Found a subset with given sum");
		          else
		             System.out.println("No subset with given sum");
	          
	          
	        
	    }

}
