package com.practice.DS.matrix;

public class MatrixSpiralForm {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		printSpiralForm(mat);
	}

	private static void printSpiralForm(int[][] mat) {
		int k = 0, l = 0, n = mat.length, m = mat[0].length;

		while (k < n && l < m) {
			// print first row of all remaining rows
			for (int i = l; i < m; i++) {
				System.out.print(mat[k][i] + " ");
			}
			k++;

			for (int i = k; i < n; i++) {
				System.out.print(mat[i][m - 1] + " ");
			}
			m--;

			if (k < n) {
				for (int i = m - 1; i >= l; i--) {
					System.out.print(mat[n - 1][i] + " ");
				}
				n--;
			}

			if (l < m) {
				for (int i = n - 1; i >= k; i--) {
					System.out.print(mat[i][l] + " ");
				}
				l++;
			}
		}
	}

}
