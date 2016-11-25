package com.practice.DS.arrays;

public class MagicSquare {

	public static void main(String[] args) {
		int n=7;
		printMagicSquare(n);
	}
	
	private static void printMagicSquare(int n){
		int[][] mat = new int[n][n];
		
		for(int k=0;k<n;k++){
			for(int j=0;j<n;j++){
				mat[k][j]=0;
			}
		}
		
		// Initialize position for 1
	    int i = n/2;
	    int j = n-1;
	 
	    // One by one put all values in magic square
	    for (int num=1; num <= n*n; )
	    {
	        if (i==-1 && j==n) //3rd condition
	        {
	            j = n-2;
	            i = 0;
	        }
	        else
	        {
	            //1st condition helper if next number goes to out of square's right side
	            if (j == n)
	                j = 0;
	            //1st condition helper if next number is goes to out of square's upper side
	            if (i < 0)
	                i=n-1;
	        }
	        if (mat[i][j]!=0) //2nd condition
	        {
	            j -= 2;
	            i++;
	            continue;
	        }
	        else
	            mat[i][j] = num++; //set number
	 
	        j++;  i--; //1st condition
	    }
		
		for(int k=0;k<n;k++){
			for(int x=0;x<n;x++){
				System.out.print(mat[k][x]+" ");
			}
			System.out.println();
		}
		
	}

}
