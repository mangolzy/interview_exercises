package googleCodeJam4Women2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class Csmall {
	public static void main(String[] args){
		//test
		/*
		//int[] test = {15,20,60,75,80,100};
		//int[] test = {9,9,12,12,12,15,16,20};
		//int[] get = cody(3,test);
		//for(int i :get)
			System.out.println(ursula(1,1,4));
	    */
		//process
		
		try{
			String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/googleCodeJam4Women2016/C-small-2-attempt0.in";
			String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/googleCodeJam4Women2016/output_C3.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			String firstLine = br.readLine();
			int n = Integer.parseInt(firstLine);	
			String cases = "";
			for(int i = 0; i < n; i++)
			{
				 String b = br.readLine();
				
					
				 String[] p = b.split(" ");
				 int C =  Integer.parseInt(p[0]);
				 int V = Integer.parseInt(p[1]);
				 int L = Integer.parseInt(p[2]);
				 long res = ursula(C,V,L) ;
			
				bw.write("Case #"+(i+1)+": "+res);
				
				bw.flush();
				bw.newLine();
			}
			bw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static long ursula(int c,int v, int l)
	{
		
		long res = 0;
		if(l == 1)
			return v;
		/*
		else if(l % 2 == 1)
		{
			int pair = (l - 1) / 2;
			res = (int) (Math.pow((c+v)*v, pair) * v);
		}
		else
		{
			int pair = l / 2;
			res = (int) (Math.pow((c+v)*v, pair));
		}
		return res;
		*/
		res = c * bv(c, v, l - 1) + v * ba(c, v, l - 1);
		return res % 1000000007;
		
	}
	public static long bv(int c, int v, int l)
	{
		if(l == 1)
			return v;
		else
			return (v * ba(c, v, l-1) )% 1000000007;
			
	}
	
	public static long ba(int c, int v, int l)
	{
		if(l == 1)
			return ( c * v)% 1000000007;
		else
			return (c *  bv(c, v, l - 1) + v *  ba(c, v, l - 1)) % 1000000007;
	}
}
