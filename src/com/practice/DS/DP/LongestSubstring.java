package com.practice.DS.DP;

public class LongestSubstring {

	public static void main(String[] args) {
		String str = "123123";
		System.out.println(longestSubstring2(str));
		//System.out.println(longestSubstring(str));
	}
	
	private static int longestSubstring2(String str){
		int n=str.length();
		int ans=0;
		for(int i=0;i<str.length()-2;i++){
			int l=i, r=i+1;
			
			int lsum=0, rsum=0;
			
			while(l>=0&&r<n){
				lsum+=str.charAt(l)-'0';
				rsum+=str.charAt(r)-'0';
				if(lsum==rsum){
					ans = Integer.max(r-l+1, ans);
				}
				l--;
				r++;
			}
		}
		return ans;
	}
	
	
	
	private static int longestSubstring(String str){
		int n=str.length();
		int sum[] = new int[n+1];
		for(int i=1;i<n;i++){
			sum[i] = sum[i-1] + str.charAt(i-1)-'0';
		}
		
		int ans = 0;
		for(int len=2;len<=n;len+=2){
			for(int i=0;i<n-len;i++){
				if(sum[i+len/2]-sum[i]==sum[i+len]-sum[i+len/2]){
					ans = Integer.max(ans, len);
				}
			}
		}
		
		return ans;
	}

}
