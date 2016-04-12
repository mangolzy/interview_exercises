package netease;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Third {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
            int l = in.nextInt();
       		
       		int[] x = new int[n];
       		
        	for(int i = 0; i < n; i++)
        	{
        		x[i] = in.nextInt();  // mark
        		
        	}
        	/*
        	res = Math.max(max_dis /2.0,res);
        	DecimalFormat    df   = new DecimalFormat("######0.00");
        	System.out.println(df.format(res));
           */ 	
        	
        }
        in.close();
    }
}
