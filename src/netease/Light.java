package netease;

import java.util.Scanner;
import java.text.DecimalFormat;  

public class Light {
	 
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
            int l = in.nextInt();
       		
       		int[] x = new int[n];
       		
        	for(int i = 0; i < n; i++)
        	{
        		x[i] = in.nextInt();  // mark
        		
        	}
        	sort(x);
        	int start = 0;
        	int end = 0;
        	if(x[0] != 0)
        		start = x[0];
        	if(x[n-1] != l)
        		end = l - x[n-1];
        	double res =  Math.max(start, end);
        	int max_dis = 0;
        	for(int j = 0; j < n-1; j++)
        	{
        		if(x[j+1] - x[j] > max_dis)
                    max_dis = x[j+1] - x[j];
        	}
        	res = Math.max(max_dis /2.0,res);
        	DecimalFormat    df   = new DecimalFormat("######0.00");
        	System.out.println(df.format(res));
            	
        	
        }
        in.close();
    }
}

