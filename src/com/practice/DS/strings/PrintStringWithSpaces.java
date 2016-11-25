package com.practice.DS.strings;

public class PrintStringWithSpaces {

	public static void main(String[] args) {
		String str = "abc";
		printWithSpaces(str, 0, "");
		
	}
	
	private static void printWithSpaces(String str, int index, String out){
		if(index==str.length()){
			System.out.println(out.substring(1));
		}
		
		for(int i=index;i<str.length();i++){
			printWithSpaces(str, i+1, out+" "+str.substring(index, i+1));
		}
	}

}
