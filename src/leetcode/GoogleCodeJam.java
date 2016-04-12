package leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class GoogleCodeJam {
	public static long color(int K,int V){
		long res = 0;
		if(K == 0 && V == 0)
			return 1;
		if(K == 1 && V == 0)
			return 2;
		else if(V <= K){
			long[][] m = new long[K+1][K+1];
			//m[0][0] = 1;
			//m[1][0] = 2;
			//m[1][1] = 8;
			for(int i = 0; i <= K; i++)
			{
				for(int j = 0; j <= i; j++)
				{
					if(j == 0)
						m[i][j] = i + 1;
					else if(j == i)
						m[i][j] = (i+1) * (i+1) * (i+1);
					else
						m[i][j] = m[i][j-1] + (3 + 3 + 6 * (j - 1)) * (i - j + 1);
					          //  0 1
						//	0// 1
						//	1// 2 8
						//	2// 3 15 27  i = 2, j = 1 6 * 2 = 12
					    //  3// 4 22 46 64
							             // i = 3, j = 3, 6 * 3 = 18  i = 3 j = 3 18* 1 = 18
						//(0, j, 1-(j-1)) (1, j+1, 2-j)  j <= i  0 -> i-j
						//(0,0,j)
						//(0,j,j)
						//IF WE CALCULATE ACCORDING TO column, CAN'T BE SIMPLE, BECAUSE WE HAVE TO INCLUDE ALL TRIPLES j < v but with at least one k;
						// according to row, we only have to consider all triples j == v, and it has to be with at least one 0 and one V.
					//	m[i][j] = m[i-1][j] + 1 + 3 + 3 + 6 * (j-1);
						//m[i][j] = 1 + (m[i-1][j] - i) / (i-1) + m[i-1][j];
					// (K,K-V, (K-1) - (K-V+1))
					// (K,K, (K-V))
					// (K,K-V,K-V)
					// (K,K,K)
						
				}
			}
			res = m[K][V];
			/*
			 * for(int i = 0; i <= K; i++)
			 
			{
				for(int j = 0; j <= i; j++)
				{
						System.out.print(m[i][j] + " ");
				}
				System.out.println();
			}
			*/
			
		}
		return res;
	}
	public static int color_iterative(int K,int V)
	{
		int count = 0;
		for(int i = 0;i < K+1; i++)
			for(int j = 0; j < K+1; j++)
				for(int k = 0; k < K+1; k++)
					if(Math.abs(i - j) <= V && Math.abs(i - k) <= V && Math.abs(j - k) <= V)
						count ++;
		return count;
	}
	
	public static long googlander(int R,int C)
	{
		//int path = 0;
		
		if(R==1 || C == 1)
			return 1;
		else
			return googlander(R-1,C)+googlander(R,C-1);
		
		//return path;
	}
	public static long googlander_iterative(int R,int C)
	{
		//int path = 0;
		long m[][] = new long[R][C];
		
		if(R==1 || C == 1)
			return 1;
		else
		{
			for(int i = 0; i < R; i ++)
				for(int j = 0; j < C; j++)
					if(i == 0 || j == 0)
						m[i][j] = 1;
					else
						m[i][j] = m[i-1][j] + m[i][j-1];
			return m[R-1][C-1];
		}
			//return googlander(R-1,C)+googlander(R,C-1);
		
		//return path;
	}
	public static void main(String[] args){
	/*
		try{
		 String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/A-small-practice.in";
		 String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/output.txt";
		 BufferedReader br = new BufferedReader(new FileReader(path));
		 BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		 String firstLine = br.readLine();
		 int n = Integer.parseInt(firstLine);	
		 String b = "";
		 String characters = "";
		 String oline = "";
		 for(int i = 0; i < n; i++)
		 {
			 b = br.readLine();
			 int len = Integer.parseInt(b);
			 //char[] characters = new char[len*8];
			 //br.read(characters, 0, len);
			 characters = br.readLine();
			 //System.out.println(i + " " +characters);
			 int sum = 0;
			 char p;
			 char in;
			 bw.write("Case #"+(i+1)+": ");
			 for(int j = 0; j < characters.length(); j++)
			 {
				 in = characters.charAt(j);
				// System.out.println(in);
				 if(in == 'O')
					 sum = sum * 2 + 0;
				 else
					 sum = sum * 2 + 1;
				 if((j + 1) % 8 == 0)
				 {
					 p = (char) (sum);
					 oline = oline+p;
					 bw.write(p);
					 System.out.println(sum + " " + p);
					sum  = 0;
				 }
				 else
				 {
					
				 }
			 }
			 //bw.write();
			 bw.flush();
			 bw.newLine();
		 }
		 br.close();
		 bw.close();
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 */
		/*
		try{
			 String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/B-large-practice-2.in";
			 String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/outputBsmall3.txt";
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			 String firstLine = br.readLine();
			 int n = Integer.parseInt(firstLine);	
			 String cases = "";
			 for(int i = 0; i < n; i++)
			 {
				 cases = br.readLine();
				 int K = Integer.parseInt(cases.split(" ")[0]);
				 int V = Integer.parseInt(cases.split(" ")[1]);
				 if(V == 0)
					 bw.write("Case #"+(i+1)+": "+(K+1));
				 else
				 {
					 //K = K+1;
					 //int res = 6 * K * 2*V * (2*V-1) + 3*K*2*V + K;
					 long res = color(K,V);
					 bw.write("Case #"+(i+1)+": "+res);
				 }
				 bw.flush();
				 bw.newLine();
			 }
			 bw.close();
			 br.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		/*
		try{
			 String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/D-large-practice.in";
			 String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/outputD2.txt";
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			 String firstLine = br.readLine();
			 int n = Integer.parseInt(firstLine);	
			 String cases = "";
			 for(int i = 0; i < n; i++)
			 {
				 cases = br.readLine();
				 int K = Integer.parseInt(cases.split(" ")[0]);
				 int V = Integer.parseInt(cases.split(" ")[1]);
				 if(V == 0)
					 bw.write("Case #"+(i+1)+": "+(K+1));
				 else
				 {
					 long res = googlander_iterative(K,V);
					 bw.write("Case #"+(i+1)+": "+res);
				 }
				 bw.flush();
				 bw.newLine();
			 }
			 bw.close();
			 br.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		try{
			 String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/A-large-practice_qr.in";
			 String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/leetcode/output_A_qr_2.txt";
			 BufferedReader br = new BufferedReader(new FileReader(path));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			 String firstLine = br.readLine();
			 int n = Integer.parseInt(firstLine);	
			 String cases = "";
			 for(int i = 0; i < n; i++)
			 {
				 cases = br.readLine();
				 int Si = Integer.parseInt(cases.split(" ")[0]);
				 String aud = cases.split(" ")[1];
				 //System.out.println(aud);
				 int need = 0;
				 int div = (int) Math.pow(10, Si);
				 int acc = 0;
				 for(int j = 0; j <= Si; j++)
				 {
					 int bit = Integer.parseInt(aud.charAt(j)+"");
					 //System.out.println(bit);
					 // you need to mark down how many people has stand up until now
					 // skip zeros
					 // what's the difference between acc and the current Sj.
					
						
					 if(bit == 0)
					 {
						 if(j == 0)
						 {
							 need = 1;
							 acc = 1;
						 }
						 continue;
					 }
					 else
					 {	
						 if(j == 0)
							 acc += bit;
						 else
						 {
							 if(acc >= j)
								 ;
							 else
							 {
								need += (j-acc);
								acc += (j-acc);
							 }
							 
							 acc += bit;
						 }
							
					 }
						 
						 
						 
				 }
					 
				 bw.write("Case #"+(i+1)+": "+need);
				 bw.flush();
				 bw.newLine();
			 }
			 bw.close();
			 br.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println(color_iterative(152,20));
	}
}
