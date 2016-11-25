package com.practice.DS.strings;

public class LongestSubstringWithKUnique {

	public static void main(String[] args) {
		String str = "aabacbebebe";
		System.out.println(longestSubstring(str, str.length(), 3));
	}

	private static String longestSubstring(String str, int n, int k) {
		int maxLength = Integer.MIN_VALUE;
		int startIndex = -1;
		
		int count[] = new int[256];
		int i=0, j=0;
		int uniqueCount = 0;
		
		while(j<n){
			
			if(count[str.charAt(j)]==0){
				uniqueCount++;
			}
			
			if(uniqueCount>k){
				while((--count[str.charAt(++i)])!=0);
				uniqueCount--;
			}
			if(maxLength<(j-i)){
					maxLength = j-i+1;
					startIndex = i;
				}
				count[str.charAt(j)]++;
			
			j++;
		}
		
		return str.substring(startIndex, startIndex+maxLength);
	}

}
