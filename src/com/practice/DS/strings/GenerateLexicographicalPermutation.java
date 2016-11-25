package com.practice.DS.strings;

import java.util.Arrays;

public class GenerateLexicographicalPermutation {

	public static void main(String[] args) {
		char[] str = "ABC".toCharArray();
		generateStrings(str);
	}

	private static void generateStrings(char[] str) {
		int l = str.length;
		Arrays.sort(str);
		
		boolean finished = false;
		while(!finished){
			for(int i=0;i<str.length;i++){
				System.out.print(str[i]+" ");
			}
			System.out.println();
			
			int i;
			for(i=l-2;i>=0;i--){
				if(str[i]<str[i+1]){
					break;
				}
			}	
				if(i==-1){
					finished = true;
				}
				else{
					int ceilIndex = getCeilIndex(str, i+1, l-1, i);
					char temp = str[i];
					str[i] = str[ceilIndex];
					str[ceilIndex] = temp;
					
					str = reverse(str, i+1, l-1);
				}
		}
	}

	private static char[] reverse(char[] str, int i, int l) {
		while(i<l){
			char temp = str[i];
			str[i] = str[l];
			str[l] = temp;
			i++; l--;
		}
		return str;
	}

	private static int getCeilIndex(char[] str, int l, int h, int first) {
		int ceilIndex = l;
		
		for(int i=l+1;i<=h;i++){
			if(str[i]>first && str[i]<str[ceilIndex]){
				ceilIndex = i;
			}
		}
		
		return ceilIndex;
	}

}
