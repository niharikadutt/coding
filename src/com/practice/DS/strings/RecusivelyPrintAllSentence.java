package com.practice.DS.strings;

public class RecusivelyPrintAllSentence {

	public static void main(String[] args) {
		String[][] ar = {{"you", "we", ""},
                {"have", "are", ""},
                {"sleep", "eat", "drink"}};
		
		formSentences(ar, ar.length, ar[0].length);
		
		
	}

	private static void formSentences(String[][] ar, int row, int col) {
		String[] output = new String[row];
		
		for(int i=0;i<col;i++){
			if(ar[0][i]!=null && ar[0][i]!=""){
				formSentenceUtil(ar, 0, i, output, row, col);
			}
		}
	}

	private static void formSentenceUtil(String[][] ar, int m, int n, String[] output, int row, int col) {
		output[m] = ar[m][n];
		
		if(m==row-1){
			for(int i=0;i<row;i++){
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<col;i++){
			if(ar[m+1][i]!=null && ar[m+1][i]!=""){
				formSentenceUtil(ar, m+1, i, output, row, col);
			}
		}
		
	}

}
