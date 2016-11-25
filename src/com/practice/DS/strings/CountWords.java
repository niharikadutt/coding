package com.practice.DS.strings;

public class CountWords {

	public static void main(String[] args) {
		String str = "One two          three\n  four\nfive  ";
		System.out.println(countWords(str));
	}
	
	private static int countWords(String str){
		int count=0;
		int state=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' ' || str.charAt(i)=='\n' || str.charAt(i)=='\t')
				state=0;
			
			else if(state==0){
				state=1;
				count++;
			}
		}
		
		return count;
	}

}
