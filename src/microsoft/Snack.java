package microsoft;

import java.util.Scanner;

public class Snack {
    public static void main(String[] args){	
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int n = in.nextInt(); // num of tests
    		for(int i = 0; i < n; i ++){
    			int m  = in.nextInt();   // num of snacks
    			double[][] val = new double[m][2];
    			for(int j = 0; j < m; j ++){
    				val[j][0] = in.nextDouble();
    				val[j][1] = in.nextDouble();
    			}
    			System.out.println(maxHappy(val,m));
			
    		}
    	}
    	in.close();
    }
    
    public static int maxHappy(double[][] val, int m){
		
		int res = 0;
		
		double happy = 0;
		double cost = 0;
		int count = 0;
		for(int i = 0; i < m; i++){
			if(count < 3){
				happy += val[i][1];
				cost += val[i][0];
				count++;
				if((int)cost % 5 == 0){
					if(happy > res)
						res = (int)happy;
					else{
						;
					}
				}
				else{
					happy -= val[i][1];
					cost -= val[i][0];
					count --;
				}
				
			}
			
		}
		
		
		return res;
	}
	
	
}
