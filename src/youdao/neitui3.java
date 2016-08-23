package youdao;

import java.text.DecimalFormat;
import java.util.Scanner;

public class neitui3 {
	// sort 
	public static void sort(int[] x){
		int n = x.length;
		
		for(int i = n - 1; i > 0; i--)
		{
			int tp1=0;
			
			for(int j = 0; j < i;j++)
			{
				if(x[j+1] < x[j])
				{
					tp1 = x[j+1];
				
					x[j+1] = x[j];
					
					x[j] = tp1;
					
				}
			}
		}
	}

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
            
       		
       		
        	for(int i = 0; i < n; i++)
        	{
        		//x[i] = in.nextInt();  // mark
        		
        	}
        	
        	
        
            	
        	
        }
        in.close();
    }
}
