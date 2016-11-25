package com.practice.DS.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedJobProblem {

	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(3,10,20));
		jobs.add(new Job(1,2,50));
		jobs.add(new Job(6,19,100));
		jobs.add(new Job(2,100,200));
		
		Collections.sort(jobs, new Comparator<Job>(){
			public int compare(Job job1, Job job2){
				return job1.end-job2.end;
			}
		});
		
		System.out.println(findMaxProfitNlogn(jobs, jobs.size()));
		//System.out.println(findMaxProfit(jobs, jobs.size()));
	}
	
	private static int findMaxProfitNlogn(List<Job> jobs, int n){
		int[] table = new int[n];
		table[0] = jobs.get(0).value;
		for(int i=1;i<n;i++){
			int inclProfit = jobs.get(i).value;
			int l = latestNonConflict(jobs, i);
			if(l!=-1){
				inclProfit+=table[l];
			}
			
			table[i] = Integer.max(inclProfit, table[i-1]);
		}
		return table[n-1];
	}
	
	private static int findMaxProfit(List<Job> jobs, int n){
		if(n==1) return jobs.get(n-1).value;
		
		int includeProfit = jobs.get(n-1).value;
		int i = latestNonConflict(jobs, n);
		
		if(i!=-1){
			includeProfit+=findMaxProfit(jobs, i+1);
		}
		int excludeProfit = findMaxProfit(jobs, n-1);
		
		return Integer.max(includeProfit, excludeProfit);
	}
	
	private static int latestNonConflict(List<Job> jobs, int n){
		for(int j=n-1;j>=0;j--){
			if(jobs.get(j).end<=jobs.get(n-1).start)
				return j;
		}
		return -1;
	}

}

class Job{
	int start, end, value;
	
	Job(int start, int end, int value){
		this.start = start;
		this.end = end;
		this.value = value;
	}
}
