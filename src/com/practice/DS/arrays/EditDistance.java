package com.practice.DS.arrays;

public class EditDistance {

	public static void main(String[] args) {
		String str = "gfg";
		String str2 = "gfx";
		
		System.out.println(editDistance(str, str2));
	}
	
	private static boolean editDistance(String str, String str2){
		int count = 0;
		int i=0, j=0;
		int m=str.length(); int n=str2.length();
		
		while(i<m && j<n){
			if(Math.abs(m-n)>1){
				return false;
			}
			
			if(str.charAt(i)!= str2.charAt(j)){
				if(count>1){
					return false;
				}
				
				else if(n<m){
					i++;
				}
				else if(n>m){
					j++;
				}
				else{
					i++;
					j++;
				}
				
				count++;
			}
			else{
				i++;
				j++;
			}
		}
		
		if(i<m || j<n){
			return true;
		}
		
		return true;
	}

}
