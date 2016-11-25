package com.practice.DS.arrays;

import java.util.HashSet;
import java.util.Set;

public class RottenEgg2 {

private static int[] xa = new int[] { 0, 0, -1, 1 };
private static int[] ya = new int[] { -1, 1, 0, 0 };

/*

    Time Complexity: O(n^2*m^2). Which is really bad and can be improved.
    */
    public static int getTime(int[][] a) {
    int count = 0;
    // Scope of improving time complexity here from O(nm).
    while (count < a.length * a[0].length) {
    if (allRotten(a))
    return count;
    count++;
    Set<Cell> s = rotNeighbors(a);
    for (Cell c : s) {
    a[c.x][c.y] = 2;
    }
    }
    return -1;
    }
 // Time Complexity: O(n*m)
    private static Set<Cell> rotNeighbors(int[][] a) {
    Set<Cell> list = new HashSet<>();
    for (int x = 0; x < a.length; x++) {
    for (int y = 0; y < a[0].length; y++) {
    if (a[x][y] == 2) {
    for (int k = 0; k < 4; k++) {
    int nextX = x + xa[k];
    int nextY = y + ya[k];
    if (isValid(a, nextX, nextY) && a[nextX][nextY] == 1) {
    list.add(new Cell(nextX, nextY));
    }
    }
    }
    }
    }
    return list;
    }

    private static boolean isValid(int[][] a, int x, int y) {
    return (x >= 0 && y >= 0 && x < a.length && y < a[0].length);
    }

    private static boolean allRotten(int[][] a) {
    for (int i = 0; i < a.length; i++) {
    for (int j = 0; j < a[0].length; j++) {
    if (a[i][j] == 1)
        return false;
        }
        }
        return true;
        }

        public static void main(String[] args) {
        int[][] a = new int[][] { { 1, 1, 2, 2 }, { 1, 2, 2, 2 }, { 2, 2, 0, 0 }, { 2, 2, 0, 1 } };
        System.out.println(getTime(a));
        }

    }

    class Cell {

    int x;
    int y;

    public Cell(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    }
