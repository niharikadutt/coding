package com.practice.DS.DP;

public class MaximumProfit {

	public static void main(String[] args) {
		int price[] = {2, 30, 15, 10, 8, 25, 80};
		System.out.println(getMaxProfit(price));
	}
	
	private static int getMaxProfit(int[] price){
		int profit[] = new int[price.length];
		for(int i=0;i<price.length;i++)
			profit[i]=0;
		
		int maxPrice = price[price.length-1];
		for(int i=price.length-2;i>=0;i--){
			if(price[i]>maxPrice)
				maxPrice=price[i];
			
			profit[i] = Integer.max(profit[i+1], maxPrice-price[i]);
		}
		
		int minPrice = price[0];
		for(int i=1;i<price.length;i++){
			if(price[i]<minPrice)
				minPrice=price[i];
			
			profit[i] = Integer.max(profit[i-1], profit[i] +(price[i]-minPrice));
		}
		
		return profit[price.length-1];
	}

}
