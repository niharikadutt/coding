package com.practice.DS.strings;

import java.util.HashMap;
import java.util.Map;

public class FormPalidrome {

	public static void main(String[] args) {
		char[] ch = "abbaccdedd".toCharArray();
		
		printPalindrome(ch);
		
				
	}
	
	private static void printPalindrome(char[] ch){
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<ch.length;i++){
			if(map.get(ch[i])!=null){
			map.put(ch[i], map.get(ch[i])+1);
			}
			else{
				map.put(ch[i], 1);
			}
			}
		
		String beg="";
		String mid="";
		String end="";
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
		if(entry.getValue()%2!=0){
			mid = String.valueOf(entry.getKey());
			int value = entry.getValue()-1;
			map.put(entry.getKey(), value);
			
		}
		else if(entry.getValue()%2==0){
			beg=beg+entry.getKey();
		}
		}
		
		String res = beg+mid+reverse(beg);
		
		System.out.println(res);
		}
	
	private static String reverse(String reverse){
		StringBuilder strBuld = new StringBuilder(reverse);
		strBuld.reverse();
		
		return strBuld.toString();
	}

}
