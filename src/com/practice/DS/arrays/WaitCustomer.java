package com.practice.DS.arrays;

public class WaitCustomer{
static int runCustomerSimulation(int capacity,String cust)
{
	char[] customer = cust.toCharArray();
    int arr[] = new int[26];
    int waitarr[] = new int[26];
    int i;


    for(int k=0;k<26;k++){arr[k]=0; waitarr[k]=0;}
    
    int seat_filled=0;
    int waiting_counter=0;
    int ans=0;
    for(i=0;i<customer.length;i++)
    {
    	
        if(waitarr[customer[i]-'A']==0 && arr[customer[i]-'A']==0 && seat_filled>=capacity)
        {
            waitarr[customer[i]-'A']++;
            waiting_counter++;
            ans++;
        }
            else if(waitarr[customer[i]-'A']==1 && seat_filled>=capacity)
        {
            waitarr[customer[i]-'A']--;
            waiting_counter--;
        }
            
            else if(arr[customer[i]-'A']==0 && seat_filled < capacity)
            {
                arr[customer[i]-'A']++;
                seat_filled++;
            }
                else if(arr[customer[i]-'A']==1)
            {
                arr[customer[i]-'A']--;
                seat_filled--;
            }
        
    }
    return ans;
}

public static void main(String[] ar) {

    System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ"));
    System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE"));
   
    
}

}