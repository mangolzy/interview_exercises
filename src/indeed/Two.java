package indeed;

import java.util.Scanner;

public class Two {
	
	public static int greatCommonDivider(int a, int b){
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int remainder = min;
		int res = 0;
		while(remainder > 0){
			res = remainder;
			remainder = max % min;
			max = min;
			min = remainder;
			
		}
		return res;
	}
	
	public static int leastCommonM(int a, int b){
		int gcd = greatCommonDivider(a, b);
		return a*b / gcd;
	}
	
	
	public static void main(String[] args) {
	
		Scanner in  = new Scanner(System.in);
	

		while(in.hasNext()){
			int A = in.nextInt();
			int B = in.nextInt();
			int K = in.nextInt();
			
			int lcm = leastCommonM(A, B);
			//  3 7 5 -> 21.5
			// 3 6 7.5 9 12 14.5 15 18 21 21.5  -> 7+3 = 10
			// 24 27 28.5 30 33 35.5 36 39 42 42.5
			 
			// 3 9 4  -> 9.5
			// 3 6 9 9.5   -> 3+1 = 4
			// 12 15 18 18.5
			
			// 5 4 6 -> 20.5
			// 4.5 5 8.5 10 12.5 15 16.5 20 20.5 -> 4 + 5 = 9
			// 24.5 25  
			
			
			int[] orders = new int[lcm/A+lcm/B];
			
			int a = 0;
			int b = 0;
			int ab = A > B? 1:0;
			if(ab == 0){
				orders[0] = 0;
				a = 1;
			}	
			else{
				orders[0] = 1;
				b = 1;
			}
		
			for(int i = 1; i < orders.length; i++){
				if((a+1) * A < (b+1) * B + 0.5){
					orders[i] = 0;
					a ++;
				}
				else{
					orders[i] = 1;
					b ++;
				}
				
			}
			int remain = K % orders.length;
			int index = 0;
			if(remain == 0)
				index = orders.length-1;
			else
				index = remain - 1;
			if(orders[index] == 0)
				System.out.println("Takahashi");
			else
				System.out.println("Akoi");
			
		}
		in.close();
	}
}
/*

int fast = Math.min(A,B);
int times = (int) (Math.max(A, B) / fast);
int each = times + 1;
for(int i = 1; i <= K; i++){
	int j = K-i;
	if(A < B){
		if( j < i  && i*A <= (j+1)*B + 0.5){
			System.out.println("Takahashi");
			break;
		}
		else if(j < i && (i+1)*A > j*B + 0.5){
			System.out.println("Aoki");
			break;
		}
	}
	else if(A > B && j >= i){
		if(i*A < j*B + 0.5){
			System.out.println("Takahashi");
			break;
		}
		else{
			System.out.println("Aoki");
			break;
		}
	}
		
}


}

*/