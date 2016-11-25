package com.practice.DS.arrays;


public class LexographicallyGreater {

	public static void main(String[] args) {
		String str = "ggaefxexx";
		System.out.println(nextPermutation(str));
	}
	
	private static String nextPermutation(String str){
		char[] s = str.toCharArray();
		int l = str.length(), i=l-2;
		while(i>=0 && s[i]>=s[i+1]){
			i--;
		}
		
		if(i<0)
			System.out.println("Doesn't exist!");
		
		else{
			int index = bSearch(s, i+1, l-1, s[i]);
			char temp = s[i];
			s[i] = s[index];
			s[index] = temp;
			String res = "";
			rev(s, i+1, l-1);
			for(int j=0;j<s.length;j++){
				res+=s[j];
			}
			return res;
		}
		
		return null;
	}
	
	static void rev(char[] s,int l,int r)
	{
	    while(l<r){
	    	l++;r--;
	    	char temp = s[l];
	    	s[l]=s[r];
	    	s[r] = temp;
	    	
	    }
	}
	
	
	private static int bSearch(char[] s, int l, int r, int key){
		int index = -1;
	    while(l<=r)
	    {
	        int mid = l+(r-l)/2;
	        if(s[mid]<=key)
	            r=mid-1;
	        else
	        {
	            l=mid+1;
	            if(index == -1 || s[index]<=s[mid])
	                index = mid;
	        }
	    }
	return index;
	}

}
