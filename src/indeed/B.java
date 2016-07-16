package indeed;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		
		
		Scanner in  = new Scanner(System.in);
		while(in.hasNext()){
			int N = in.nextInt();
			int[] p = new int[N];   // permutation sequence
			int[] mark = new int[N]; // mark sequence
										// origin sequence is i ...
			for(int k = 0; k < N; k ++)
				p[k] = in.nextInt();
			int i = 0;
			int j = N-1;
			int count = 0;
			int current = 0;
			while(i <= j){
				/*while(i < N && p[i] == i+1 && mark[i] != 1){
					mark[i] = 1;
					i++;
					count ++;
				}
				
				while(i < j && p[j] == j+1 && mark[j] != 1){
					mark[j] = 1;
					j--;
					count ++;
				}*/
				mark[i] = 1;
				current = i+1;	
				//mark[i] = 1;
				while(i < N && p[i] != current && mark[p[i]-1] != 1){
					i = p[i] - 1;
					mark[i] = 1;
				}
				if(p[i] == current)
					count ++;
				i = current;
				//i++;
				//while(mark[i] == 1)
				//	i++;
					
			}
			
			System.out.println(count);
			
		}
		in.close();
	}
}
