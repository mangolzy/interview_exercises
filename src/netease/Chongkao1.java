package netease;


import java.io.IOException;

import java.util.Scanner;

public class Chongkao1 {
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
       
        //while (in.hasNext()) {
       
        //}
        int a = 0;
        int b = 1;
        int sum = 0;
        int i = 0;
        while(sum < 1000000){
        	sum = a+b;
        	a = b;
        	b = sum;
        	i++;
        }
        //System.out.println(i);
        //System.out.println(Integer.MAX_VALUE);
        
        int[] fibonacci = new int[35];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int j = 2; j < fibonacci.length; j++){
        	fibonacci[j] = fibonacci[j-1] + fibonacci[j-2];
        }
        int input = in.nextInt();
        /*
        int start = 0;
        int end = fibonacci.length - 1;
        int mid = 0;
        while(start < end){
        	mid = (start+end) / 2;
        	if(fibonacci[mid] == input)
        		System.out.println(0);
        	else if(fibonacci[mid] < input && fibonacci[mid] > )
        }
        */
        int k;
        for(k = 0; k < fibonacci.length; k++){
        	if(fibonacci[k] > input)
        		break;
        }
        if(k == 0)
        	System.out.println(input);
        else if(k == fibonacci.length - 1)
        	System.out.println(fibonacci[fibonacci.length - 1] - input);
        else{
        	int min = Math.min(input - fibonacci[k-1], fibonacci[k] - input);
        	System.out.println(min);
        }
	}
}
