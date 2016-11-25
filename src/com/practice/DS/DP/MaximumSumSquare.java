package com.practice.DS.DP;

public class MaximumSumSquare {

	public static void main(String[] args) {
		findMaxSubMatrix(new int[][] {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
            });
	}
	
	private static void findMaxSubMatrix(int[][] ar){
		int col = ar[0].length;
		int row = ar.length;
		int[] currentResult = new int[3];
		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int right =0;
		int top=0,bottom=0;
		
		for(int leftCol = 0;leftCol<col;leftCol++){
			int[] tmp = new int[row];
			for(int rightCol = 0;rightCol<col;rightCol++){
				for(int i=0;i<row;i++){
					tmp[i]+=ar[i][rightCol];
				}	
				currentResult = kadane(tmp);
				
				if(currentResult[0]>maxSum){
					maxSum = currentResult[0];
					left = leftCol;
					right = rightCol;
					top = currentResult[1];
					bottom = currentResult[2];
				}
			}
		}
		
		System.out.println("MaxSum: " + maxSum + 
                ", range: [(" + left + ", " + top + 
                  ")(" + right + ", " + bottom + ")]");
	}
	
	private static int[] kadane(int[] temp){
		int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
		int currentSum = 0;
		int localStart =0;
		
		for(int i=0;i<temp.length;i++){
			currentSum+=temp[i];
			if(currentSum<0){
				currentSum=0;
				localStart = i+1;
			}
			else if(currentSum>result[0]){
				result[0]=currentSum;
				result[1]=localStart;
				result[2]=i;
			}				
		}	
		if (result[2] == -1) {
            result[0] = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > result[0]) {
                    result[0] = temp[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
		
		return result;
	}

}
