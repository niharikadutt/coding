package com.practice.DS.arrays;

public class MaximumSumRectangle {

	public static void main(String[] args) {
		int[][] mat = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
                };
		
		System.out.println(maxSum(mat));
		
	}

	private static int maxSum(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int max = Integer.MIN_VALUE;
		
		int temp[] = new int[rows];
		
		for(int left=0;left<cols;left++){
			for(int i=0; i < rows; i++){
                temp[i] = 0;
            }
			for(int right=left;right<cols;right++){
				for(int i=0;i<rows;i++){
					temp[i]+= mat[i][right];
					
					int currMax = kadanes(temp);
					
					if(currMax>max){
						max = currMax;
					}
				}
			}
		}
		
		return max;
	}

	private static int kadanes(int[] temp) {
		int currMax = 0, maxSoFar=0;
		for(int i=0;i<temp.length;i++){
			currMax = Integer.max(temp[i], currMax+temp[i]);
			maxSoFar = Integer.max(maxSoFar, currMax);
		}
		
		return maxSoFar;
	}

}
