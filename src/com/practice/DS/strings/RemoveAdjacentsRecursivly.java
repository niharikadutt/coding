package com.practice.DS.strings;

public class RemoveAdjacentsRecursivly {

	public static void main(String[] args) {
		char[] ar = "azxxxzy".toCharArray();
		removeAdjacent(ar, ar.length);
		
	}
	
	private static void removeAdjacent(char[] ar, int l){
		int j=0;
		for(int i=1;i<l;i++){
			while(ar[i]==ar[j] && j>=0){
				i++;
				j--;
			}
			ar[++j]=ar[i];
		}
		
		
		for(int i=0;i<=j;i++){
			System.out.println(ar[i]);
		}
		return;
	}

}
