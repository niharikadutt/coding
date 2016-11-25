package com.practice.DS.strings;

public class RemoveExtraSpaces {

	public static void main(String[] args) {
		char[] str = " Hello    .I am      Niharika.     ".toCharArray();
		System.out.println(removeSpaces(str));
	}

	private static String removeSpaces(char[] str) {
		int n = str.length;
		
		int i=0, j=-1;
		boolean spaceFound = false;
		
		while(++j<n && str[j]==' ');
		
		while(j<n){
			if(str[j]!=' '){
				if(str[j]=='.' && i-1>=0 && str[i-1]==' '){
					str[i-1] = str[j++];
					spaceFound = false;
				}
				else{
					str[i++] = str[j++];
				}
			}
			else if(str[j++]==' '){
				if(!spaceFound){
					str[i++] = ' ';
					spaceFound = true;
				}
				
			}
		}
		
		return String.valueOf(str);
		
	}

}
