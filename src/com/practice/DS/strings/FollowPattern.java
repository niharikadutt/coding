package com.practice.DS.strings;

import java.util.Arrays;

public class FollowPattern {

	public static void main(String[] args) {
		String str = "engineers rock";
		String pat = "er";
		
		System.out.println(followPattern(str, pat));
	}

	private static boolean followPattern(String str, String pat) {
		int[] label = new int[256];
		
		Arrays.fill(label, -1);
		
		int order = 1;
		for(int i=0;i<pat.length();i++){
			label[pat.charAt(i)] = order;
			order++;
		}
		
		int lastOrder = -1;
		
		for(int i=0;i<str.length();i++){
			if(label[str.charAt(i)]!=-1){
				if(label[str.charAt(i)]<lastOrder)
					return false;
				
				lastOrder = label[str.charAt(i)];
			}
		}
		
		return true;
	}

}
