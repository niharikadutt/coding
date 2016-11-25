package com.practice.DS.arrays;

import java.util.Arrays;

public class CountTriangles
{
    // Function to count all possible triangles with arr[]
    // elements
    static int findNumberOfTriangles(int arr[])
    {
        int n = arr.length;
        // Sort the array elements in non-decreasing order
        Arrays.sort(arr);
 
        // Initialize count of triangles
        int count = 0;
        for (int i = 0; i < n-2; ++i)
        {
            // Initialize index of the rightmost third element
            int k = i + 2;
 
            // Fix the second element
            for (int j = i+1; j < n; ++j)
            {

                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;

                count += k - j - 1;
            }
        }
        return count;
    }
 
    public static void main (String[] args)
    {
        int arr[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Total number of triangles is " +
                            findNumberOfTriangles(arr));
    }
}