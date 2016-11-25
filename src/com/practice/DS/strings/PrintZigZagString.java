package com.practice.DS.strings;

import java.util.Arrays;

public class PrintZigZagString {

	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		System.out.println(printZigZag(str, 3));
	}

	private static String printZigZag(String str, int n) {
		boolean down = true;
		int row=0;
		
		String finalResult = "";
		
		String[] res = new String[n];
		
		Arrays.fill(res, "");
		
		for(int i=0;i<str.length();i++){
			
			res[row].concat(Character.toString(str.charAt(i)));
			
			if(row==n-1){
				down = false;
			}
			else if(row==0){
				down = true;
			}
			
			if(down)
				row++;
			else
				row--;
			
		}
		
		for(int i=0;i<n;i++){
			finalResult.concat(res[i]);
		}
		
		return finalResult;
		
	}

}
