package com.practice.DS.strings;

public class SpecificPatter {

	public static void main(String[] args) {
		String input = "engineers rock";
		String pattern = "egr";
		System.out.println(checkIfPatternFollows(input, pattern));
	}
	
	private static boolean checkIfPatternFollows(String input, String pattern){
		for(int i=0;i<pattern.length()-1;i++){
			if(input.lastIndexOf(pattern.charAt(i))>input.indexOf(pattern.charAt(i+1))){
				return false;
		}
		}
		
		return true;
	}

}
