package com.practice.DS.matrix;

public class CommonElementsInMat {
	
	private static int ROW = 4;
	private static int COL = 5;

	public static void main(String[] args) {
		
		int[][] mat = { {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
              };
		
		System.out.println(commonElement(mat));
	}

	private static int commonElement(int[][] mat) {
		int[] columns = new int[ROW];

		for (int i = 0; i < ROW; i++) {
			columns[i] = COL - 1;
		}

		int currMin = Integer.MAX_VALUE;
		int minRow = 0;
	

		while (columns[minRow] >= 0) {
			for (int i = 0; i < ROW; i++) {
				if (mat[i][columns[i]] < currMin) {
					currMin = mat[i][columns[i]];
					minRow = i;
				}
			}
			
			int eq = 0;
			
			for(int i=0;i<ROW;i++){
				if(mat[i][columns[i]]>currMin){
					columns[i] = columns[i]-1;
				}
				else if(mat[i][columns[i]]==currMin)
					eq++;
				
				
			}
			
			if(eq==ROW){
				return currMin;
			}
		}

		
		return -1;
	}

}
