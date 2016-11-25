package com.practice.DS.strings;

public class IncreasingSequence {

	public static void main(String[] args) {
		printIncreasingSequence("", 1, 3, 2);

	}

	private static void printIncreasingSequence(String out, int start, int end, int k) {
		if(out.length()==k)
			System.out.println(out);
		
		else if(start<=end){
			for(int i=start; i<=end;i++){
				printIncreasingSequence(out+i, i+1, end, k);
			}
		}
		
	}

}
