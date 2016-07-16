package indeed;

import java.util.Scanner;

public class D {
public static void main(String[] args) {
		
		
		Scanner in  = new Scanner(System.in);
		int k = 0;
		
		int[] ai;
		double sum = 0.0;
		double exp = 0.0;
		while(in.hasNext()){
			k = in.nextInt();
			ai = new int[k];
			for(int i = 0; i < k; i++){
				ai[i] = in.nextInt();
				sum += ai[i];
			}
			if(k == 2){
				//sum = ai[0] + ai[1];
				exp = ai[0]/sum * (1+sum/ai[1]) + ai[1]/sum * (1+sum/ai[0]);
				System.out.println(exp);
			}
			else{
				for(int j = 0; j < k; j ++){
					
				}
			}
		}
		
		in.close();
	}
}
