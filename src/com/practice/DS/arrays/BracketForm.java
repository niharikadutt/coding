package com.practice.DS.arrays;

public class BracketForm {

	public static void main(String[] args) {
		String str = "abc";
		printAllBracket(str, 0, "");
	}
	
	private static void printAllBracket(String str, int index, String out){
		if(index==str.length()){
			System.out.println(out);
		}
		
		for(int i=index;i<str.length();i++){
			printAllBracket(str, i+1, out+"("+str.substring(index, index+1-i)+")");
		}
	}

}
