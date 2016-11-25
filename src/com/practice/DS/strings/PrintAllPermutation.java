package com.practice.DS.strings;

public class PrintAllPermutation {

	public static void main(String[] args) {
		String str = "1210";
		printAllPermutation(str, "");
	}

	private static void printAllPermutation(String str, String out) {
		if(str.length()==0)
			System.out.println(out);
		
		else{
		for(int i=0;i<str.length();i++){
			printAllPermutation(str.substring(0, i)+str.substring(i+1, str.length()), out+str.charAt(i));
		}
		}
		
	}

}
