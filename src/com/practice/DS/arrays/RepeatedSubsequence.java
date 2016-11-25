package com.practice.DS.arrays;

public class RepeatedSubsequence {

	static boolean isPalindrome(char str[], int l, int h)
	{
	    // l and h are leftmost and rightmost corners of str
	    // Keep comparing characters while they are same
	    while (h > l)
	        if (str[l++] != str[h--])
	            return false;
	 
	    return true;
	}
	 
	// The main function that checks if repeated
	// subsequence exists in the string
	static boolean check(char str[])
	{
	    // Find length of input string
	    int n = str.length;
	 
	    // Create an array to store all characters and their
	    // frequencies in str[]
	    int freq[] = new int[256];
	 
	    // Traverse the input string and store frequencies
	    // of all characters in freq[] array.
	    for (int i = 0; i < n; i++)
	    {
	        freq[str[i]]++;
	 
	        // If the character count is more than 3
	        // we found a repetition
	        if (freq[str[i]] > 3)
	            return true;
	    }
	 
	    // In-place remove non-repeating characters
	    // from the string
	    int k = 0;
	    
	    for (int i = 0; i < n; i++)
	        if (freq[str[i]] > 1)
	            str[k++] = str[i];
	    str[k] = '\0';
	 
	    // check if the resultant string is palindrome
	    if (isPalindrome(str, 0, k-1))
	    {
	        // special case - if length is odd
	        // return true if the middle characer is
	        // same as previous one
	        if (k%2==1)
	            return str[k/2] == str[k/2 - 1];
	 
	        // return false if string is a palindrome
	        return false;
	    }
	 
	    // return true if string is not a palindrome
	    return true;
	}
	 
	// Driver code
	public static void main(String[] ar)
	{
	    char str[] = "ABCACBD".toCharArray();
	 
	    if (check(str))
	        System.out.println("Repeated Subsequence Exists");
	    else
	        System.out.println("Repeated Subsequence Doesn't Exists");
	 
	}

}
