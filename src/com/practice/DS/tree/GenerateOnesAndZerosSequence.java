package com.practice.DS.tree;

public class GenerateOnesAndZerosSequence {
	
	public static void main(String ar[]){
		String str = "";
	    generate(0, 0, str, 4);
	
	}	
	
	// len ---> desired length of every permutation
	static void generate(int ones, int zeroes, String str, int len)
	{
	    // If length of current string becomes same as desired length
	    if (len == str.length())
	    {
	        System.out.println(str);
	        return;
	    }
	 
	    // Append a 1 and recur
	    generate(ones+1, zeroes, str+"1", len);
	 
	    // If there are more 1's, append a 0 as well, and recur
	    if (ones > zeroes)
	        generate(ones, zeroes+1, str+"0", len);
	}

}
