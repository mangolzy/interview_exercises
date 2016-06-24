import java.util.Scanner;


// 1e12 = 1 trillion = 1 000 000 000 000 = 2^40

public class MaximumXor {

		static int SIZE = 2;
		
		static int count = 0;
		
		static int[][] root ;
		
		
		public static void insert(long l){
				
				// deal with the highest bit
				for(int i = 63, x = 0; i >= 0; i--){
					int nth = (((1 << i) & l) != 0)?1:0; // the nth bit val
					if(root[x+1][nth] == -1){
						root[count][0] = -1;
						root[count][1] = -1;
						root[x+1][nth] = count++;
						
					
					}
					x = root[x+1][nth];
				}
				
			
		}
		public static long find(long q){
			long res = 0;
			for(int i = 63, x = 0; i >= 0; i--){
				int nth = (((1 << i) & q) == 0)?1:0; // the nth bit generate a 1 for Xor
				if(root[x+1][nth] == -1)
					nth ^= 1;
				res = res * 2 + nth;
				x = root[x+1][nth];
				
			}
			return res;
		}
		public static void main(String[] args){
			
			Scanner in = new Scanner(System.in);
			while(in.hasNext()){
				int N = in.nextInt();
				root = new int[64*N][SIZE];
				
				
				for(int i = 0; i < 64*N; i++)
					for(int j = 0; j < SIZE; j++)
							root[i][j] = -1;
				
				count = 1;
				long temp = 0;
				long update = 0;
				long cur = 0;
				insert(0);
				long[] chain = new long[N];
				for(int i = 0; i < N; i++){
					long l = in.nextLong();
					temp ^= l;
					chain[i] = l;	
				}
				long all = temp;
				
				for(int i = 0; i < N; i ++){
					update ^= chain[i];
					cur ^= chain[i];
					insert(update);
					long get = find(cur);
					all = Math.max(all, get^cur);
				}
				
				
				System.out.println(all);
				
			}
			in.close();
		}
		
		
	
}
