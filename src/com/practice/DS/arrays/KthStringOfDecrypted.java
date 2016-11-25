package com.practice.DS.arrays;

import java.util.Arrays;

public class KthStringOfDecrypted {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(toUpper(str));
		
		
       // char set2[] = {'a', 'b', 'c', 'b', 'a', 'a'};
//		char[] str = {'a','a','b','b'};
//        
//        System.out.println(findLongestRepeatingSubSeq(str));
     //   printAllKLength(set2, k, "");
        
    //    printAllKLengthWithout(set2, k);
	}
	
	private static String toUpper(String str){
		char[] newString = str.toCharArray();
		for(int i=0;i<str.length();i++){
			if('a'<= str.charAt(i) && str.charAt(i)<='z'){
				newString[i] = (char) (str.charAt(i)-'a'+'A');
			}
		}
		return String.valueOf(newString);
	}
	
	static int findLongestRepeatingSubSeq(char[] str)
	{
	    int n = str.length;
	 
	    // Create and initialize DP table
	    int[][] dp = new int[n+1][n+1];
	    for (int i=0; i<=n; i++)
	        for (int j=0; j<=n; j++)
	            dp[i][j] = 0;
	 
	    // Fill dp table (similar to LCS loops)
	    for (int i=1; i<=n; i++)
	    {
	        for (int j=1; j<=n; j++)
	        {
	            // If characters match and indexes are not same
	            if (str[i-1] == str[j-1] && i!=j)
	                dp[i][j] =  1 + dp[i-1][j-1];                               
	            // If characters do not match
	            else
	                dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
	        }
	    }
	    return dp[n][n];
	}
	
	private static void printAllWithKDistinct(char[] set, int k){
		int[] count = new int[26];
		int res=0;
		for(int i=0;i<set.length-k;i++){
			Arrays.fill(count, 0);	
			int distinct = 0;
			for(int j=i;j<i+k;j++){
				if(count[set[j]-'a']==0){
					distinct++;
					count[set[j]-'a']++;
				}
				
				if(distinct == k){
					res++;
				}
			}
			
			
		}
		System.out.println("Result : "+res);
	} 
	
	private static void printAllKLengthWithout(char set[], int k){
		String str = String.valueOf(set);
		for(int i=0;i<str.length()-k;i++){
			System.out.println(str.substring(i, i+k));
		}
	}
	
	
	private static void printAllKLength(char set[], int k, String prefix){
		if(k==0){
			System.out.println(prefix);
			return;
		}
		
		for(int i=0;i<set.length;i++){
			String newPrefix = prefix+set[i];
			
			printAllKLength(set, k-1, newPrefix);
		}
	}
	
	

}
