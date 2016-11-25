package com.practice.DS.DP;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		char[] ar = str.toCharArray();
		longestPalindrome(ar);
		
	}
	
	private static void longestPalindrome(char[] ar){
		int maxLen = 1;
		int start=0;
		int n = ar.length;
		int low, high;
		//for even length
		for(int i=1;i<n;i++){
			low=i-1;
			high=i;
			while(low>=0 && high<n && ar[low]==ar[high]){
				if(high-low+1>maxLen){
					start=low;
					maxLen = high-low+1;
				}
				low--;
				high++;
			}
		}
		//for odd length
		for(int i=1;i<n;i++){
			low=i-1;
			high=i+1;
			while(low>=0 && high<n && ar[low]==ar[high]){
				if(high-low+1>maxLen){
					start=low;
					maxLen = high-low+1;
				}
				low--;
				high++;
			}
		}
		
		System.out.println("Longest Palidromic subtring : "+ printSubstring(ar, start, maxLen));
	}

	private static String printSubstring(char[] ar, int start, int maxLen) {
		String str = "";
		for(int i=start;i<start+maxLen;i++){
			str+=ar[i];
		}
		
		return str;
	}

}
