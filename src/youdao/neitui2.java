package youdao;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class neitui2 {
	

			 
			// sort 
			public static void swap(int[] x, int n){
				Stack<Integer> left = new Stack<Integer>();
				Stack<Integer> right = new Stack<Integer>();
				
				for(int i = 0; i < n*2; i++){
					left.push(x[i]);
					right.push(x[i+1]);
				}
				for(int j = 0; j < n*2; j += 2){
					x[j] = right.pop();
					x[j+1] = left.pop();
				}
			}

		    public static void main(String[] args){
		        Scanner in = new Scanner(System.in);
		      while(in.hasNext()){
		        	int T = in.nextInt();
		            
		       		
		       		
		       		
		        	for(int i = 0; i < T; i++)
		        	{
		        		int n = in.nextInt();
		        		int k = in.nextInt();
		        		int[] cards = new int[n*2];
		        		
		        		for(int j = 0; j < n*2; j++)
		        			cards[j] = in.nextInt();
		        		for(int l = 0; l < k; l++)
		        			swap(cards,n);
		        		for(int x = n*2-1; x >= 0; x--)
		        			if(x == 0)
		        				System.out.print(cards[x]);
		        			else
		        				System.out.print(cards[x]+" ");
		        		
		        	}
	
		        }
		        in.close();
		    }
}



