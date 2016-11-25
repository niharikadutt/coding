package com.practice.DS.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class SubarraysWithSumZero {

  public static void main(String[] args) {
    int[] arr={6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};
    findSubArrayWithZeroSum(arr);
  }
  
  private static void findSubArrayWithZeroSum(int[] arr){
     int sum=0;
     Vector<Range> ranges = new Vector<>();
     Map<Integer , List<Integer>> map = new HashMap<>();
     for(int i=0;i<arr.length;i++){
       sum = sum + arr[i];
       if(sum==0){
         Range range = new Range(0,i);
         ranges.add(range);
       }
       
       if(map.get(sum) != null){
          List<Integer> list=map.get(sum);
          Iterator<Integer> itr=list.iterator();
          while(itr.hasNext()){
             Range range = new Range(itr.next() + 1 ,i);
             ranges.add(range);
          }
         map.get(sum).add(i); 
       }else{
          List<Integer> list=new ArrayList<>();list.add(i);
          map.put(sum,list);
       }
     }
     print(ranges);
  }
  
  private static void print(Vector<Range> ranges) {
    Iterator<Range> itr = ranges.iterator();
    while(itr.hasNext()){
       Range range = itr.next();
       System.out.println(range.getFrom() + " " + range.getTo());
    }
  }

  public static class Range{
    private int from ;
    private int to;
    
    public Range(int from,int to){
      this.from = from;
      this.to = to;
    }
    
    public int getFrom() {
      return from;
    }
    public void setFrom(int from) {
      this.from = from;
    }
    public int getTo() {
      return to;
    }
    public void setTo(int to) {
      this.to = to;
    }
     
  }
}
