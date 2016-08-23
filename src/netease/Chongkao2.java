package netease;

import java.util.Scanner;

public class Chongkao2 {
	 public static void main(String[] args){
	        
	        
	        Scanner in = new Scanner(System.in);
	        
	        while(in.hasNext()){
	        	int n = in.nextInt();
	        	int[] balls = new int[n];
	        	int count  = 0;
	        	for(int i = 0; i < n; i++){
	        		balls[i] = in.nextInt();
	        		if(balls[i] == 1)
	        			count ++;
	        	}
	        	if(count < n)
	        		System.out.println(count);
	        	else
	        		System.out.println(n-1);
	        }
	        
	 }
}
