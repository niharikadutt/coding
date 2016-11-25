package com.practice.DS.DP;

public class LongestIncresingSubsequence {

	public static void main(String[] args) {
		int ar[] = {3,2,4,6,8,5,1};
		int n = ar.length;
		//System.out.println(getLength(ar,n));
		
		System.out.println(getLengthNLogN(ar,n));
	}
	
	private static int getLengthNLogN(int[] ar, int n){
		int[] tailTable = new int[n];
		
		int len = 1;
		tailTable[0]=ar[0];
		for(int i=1;i<n;i++){
			if(ar[i]<tailTable[0]){
				tailTable[0] = ar[i];
			}
			
			else if(ar[i]>tailTable[len-1]){
				tailTable[len++]=ar[i];
			}
			else{
				tailTable[CeilIndex(ar, -1, len-1, ar[i])] = ar[i];
			}
		}
		
		return len;
	}
	
	private static int CeilIndex(int[] ar, int l, int r, int key){
		while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (ar[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
	}
	
	private static int getLength(int ar[], int n){
		int[] lis = new int[n];
		int max = 0;
		
		for(int i=0;i<n;i++){
			lis[i] = 1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(ar[i]>ar[j] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
				}
			}
		}
		
		for(int i =0;i<lis.length;i++){
			if(max<lis[i])
				max = lis[i];
		}
		
		return max;
	}

}
