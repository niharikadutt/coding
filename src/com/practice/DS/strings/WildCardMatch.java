package com.practice.DS.strings;

public class WildCardMatch {

	public static void main(String[] args) {
		System.out.println(test("g*ks", "geeks", 0, 0));
	}
	
	
	private static boolean test(String str1, String str2, int i, int j){
			if (i==str1.length() || j==str2.length())
		        return true;
		 

		    if (str1.charAt(i) == '*' && str1.charAt(i+1) != '\0' && str2.charAt(j) == '\0')
		        return false;
		 

		    if (str1.charAt(i) == '?' || str1.charAt(i) == str2.charAt(j))
		        return test(str1, str2, i+1, j+1);
		 

		    if (str1.charAt(i) == '*')
		        return test(str1, str2, i+1, j) || test(str1, str2, i, j+1);
		    return false;
		}

}
