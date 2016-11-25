package com.practice.DS.strings;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "geeksforgeeg";
		System.out.println(solve(str));
	}

	private static String solve(String str){
		  // Variable result will hold our solution.
		  StringBuilder result = new StringBuilder();
		  int i = 0;
		  while (i < str.length()) {
		    // Check wheter the character at position i is identical
		    // to the last character that we have seen.
		    if (result.length() > 0 &&
		        str.charAt(i) == result.charAt(result.length() - 1)) {
		      // We found a duplicate! Let's skip it.
		      i++;
		      // Are there more of that same character?
		      while (i < str.length() &&
		          str.charAt(i) == result.charAt(result.length() - 1)) {
		        // We skip them as well.
		        i++;
		      }
		      // There are no more characters identical to the last we
		      // have seen. We can now delete it.
		      result.deleteCharAt(result.length() - 1);
		    } else {
		      // This character is either the first, or is
		      // different from the previous one: we can add it
		      // to the result.
		      result.append(str.charAt(i));
		      i++;
		    }
		  }
		  return result.toString();
		}
}
