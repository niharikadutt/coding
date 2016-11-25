package com.practice.DS.strings;

public class MaximumOccuringChar {

	public static void main(String[] args) {
		String str = "abbabaaaacchabdaa";
		
		System.out.println(countChar(str));
	}

	private static int countChar(String str) {
		int max = Integer.MIN_VALUE;
		char[] count = new char[256];
		for(int i=0;i<str.length();i++){
			count[str.charAt(i)]++;
		}
		
		for(int i=0;i<str.length();i++){
			if(max<count[str.charAt(i)]){
				max = count[str.charAt(i)];
			}
				
		}
		
		return max;
	}

}
