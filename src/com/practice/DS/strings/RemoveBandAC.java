package com.practice.DS.strings;

import java.util.Scanner;

public class RemoveBandAC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(remove(str));
	}
	
	private static String remove(String str){
		int state=0;
		int j=0;
		char[] res = new char[str.length()];
		
		for(int i=0;i<str.length();i++){
			if(state==0 && !(str.charAt(i)=='a') && !(str.charAt(i)=='b')){
				res[j] = str.charAt(i);
				j++;
			}
			
			else if(state==1 && !(str.charAt(i)=='c')){
				res[j] = 'a';
				j++;
				
				if(!(str.charAt(i)=='a') && !(str.charAt(i)=='b')){
				res[j] = str.charAt(i);
				j++;
				}
			}
			state = str.charAt(i)=='a'?1:0;

		}
		
		if(state==1){
			res[j]='a';
		}
		
		return String.valueOf(res);
	}

}
