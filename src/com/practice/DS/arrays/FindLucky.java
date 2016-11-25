package com.practice.DS.arrays;

public class FindLucky {
	static int counter=2;

	public static void main(String[] args) {
		int x=7;
		System.out.println(isLuckyy(x));
	}
	
	private static boolean isLuckyy(int n)
	{
	int pos=n,i=2;
	while(i<=pos)
	{
	if(pos%i==0)
	{
	return false;
	}
	else
	{
	pos=pos-(pos/i);
	i++;
	}
	}
	return true;
	}
	
	private static boolean isLucky(int x){
		
		if(counter>x)
			return true;
		if(x%counter==0)
			return false;
		
		x-=x/counter;
		counter++;
		return isLucky(x);
		
	}

}
