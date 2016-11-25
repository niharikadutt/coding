package com.practice.DS.strings;

public class ValidParenthesis {

	public static void main(String[] args) {
		print(6);
	}

	private static void print(int n) {
		printParenthesis(n/2,n/2, "");		
	}

	private static void printParenthesis(int open, int close, String str) {
		if(open==0 && close==0)
			System.out.println(str);
		
		if(open>close)
			return;
		
		if(open>0)
			printParenthesis(open-1, close, str+"(");
		
		if(close>0)
			printParenthesis(open, close-1, str+")");
	}
	

}
