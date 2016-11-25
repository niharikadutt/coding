package com.practice.DS.arrays;

import java.util.HashMap;

public class MappedDigit {
	 
	 
    private static void printCombinations(String[][] matrix, int pos, HashMap<Integer,Character> map,String input,String result) {
 
        if(pos==input.length()) {
            System.out.println(result);
            return;
        }
 
        int currentPosValue = Character.getNumericValue(input.charAt(pos));
 
        if(map.get(currentPosValue)!=null) {
 
            result += map.get(currentPosValue);
            printCombinations(matrix,pos+1,map,input,result);
 
        } else {
 
            for (int i=0;i<matrix[currentPosValue-1].length;i++) {
                map.put(currentPosValue,matrix[currentPosValue-1][i].charAt(0));
                result += map.get(currentPosValue);
                printCombinations(matrix,pos+1,map,input,result);
                //Clear map after one iteration
                map.remove(currentPosValue);
                result = result.substring(0,result.length()-1);
            }
 
        }
 
 
    }
 
 
 
 
    public static void main(String[] args) {
        String[][] matrix = new String[][]
                {
                        {"A","B","C"},
                        {"D","E","F"},
                        {"G","H","I"},
                        {"J","K","L"},
                        {"M","N","O"},
                        {"P","Q","R"},
                        {"S","T","U"},
                        {"V","W","X"},
                        {"Y","Z"}
                };
 
        Integer n = 121;
        String s = Integer.toString(n);
 
        printCombinations(matrix,0,new HashMap<>(),s, "");
    }
 
}
