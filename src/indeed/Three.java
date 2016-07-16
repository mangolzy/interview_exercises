package indeed;

import java.util.Scanner;
import java.util.Stack;

public class Three {
	
	
	
	public static void main(String[] args) {
		
		Scanner in  = new Scanner(System.in);
	

		while(in.hasNext()){
			int N = in.nextInt();
			String s = in.next();
			int[] cost = new int[N+1];
			for(int i = 0; i < N+1; i++){
				cost[i] = in.nextInt();
			}
		
		    Stack<Integer> stack = new Stack<Integer>();
		        

		    int right = N - 1;
		    int max = 0;
		    int sum = 0;
		    for(int i = N-1; i >= 0; i --){
		        if(s.charAt(i) == ')'){
		            stack.push(i);  ///   store the ) index  !!!
		        }
		        else{
		            if(stack.isEmpty()){
		            	right = i;
		                sum += cost[i+1];
		            }
		            else{
		                stack.pop();
		                   
		                //sum += cost[0];
		            }
		                   
		         }
		     }
		     while(!stack.isEmpty()){
		    	 
		    	 if(cost[stack.peek()] < cost[0])
		    		 sum += cost[right];
		    	 else
		    		 sum += cost[0];
		    	 stack.pop();
		     }
		     System.out.println(sum);
		
		}
		in.close();
	}
}
