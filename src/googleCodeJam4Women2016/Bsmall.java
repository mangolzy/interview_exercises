package googleCodeJam4Women2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Bsmall {
	public static void main(String[] args){
		//test
		/*
		
		//int[] get = dance(8,3,1);
		int[] get = dance(4,1,8);
		for(int i :get)
			System.out.println(i);
		*/
		//process
		
		try{
			String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/googleCodeJam4Women2016/B-small-attempt0.in";
			String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/googleCodeJam4Women2016/output_B.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			String firstLine = br.readLine();
			int n = Integer.parseInt(firstLine);	
			String cases = "";
			for(int i = 0; i < n; i++)
			{
				 String b = br.readLine();
				
				 String[] p = b.split(" ");
				 int D = Integer.parseInt(p[0]);
				 int K = Integer.parseInt(p[1]);
				 int N = Integer.parseInt(p[2]);
				 
				 int[] res = dance(D,K,N);
			
				bw.write("Case #"+(i+1)+": ");
				for(int k = 0; k < 2; k++)
					bw.write(res[k] + " ");
				bw.flush();
				bw.newLine();
			}
			bw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void clockwise(int[] x)
	{
		for(int i = 0; i < x.length - 1; i ++)
		{
			if(i % 2 == 0)
			{
				int temp = x[i];
				x[i] = x[i+1];
				x[i+1] = temp;
			}
		}
		
	}
	public static void anticlockwise(int[] x)
	{
		int temp = x[0];
		x[0] = x[x.length-1];
		x[x.length-1] = temp;
		for(int i = 1; i < x.length - 2; i ++)
		{
			if(i % 2 == 1)
			{
				temp = x[i];
				x[i] = x[i+1];
				x[i+1] = temp;
			}
		}
		
	}
	public static int[] dance(int D, int K, int N)
	{
		int[] res = new int[2];
		
		int[] d = new int[D];
		for(int i = 0; i < d.length; i++)
			d[i] = i+1;
		for(int j = 1; j <= N; j++)
			if(j % 2 == 1 )
				clockwise(d);
			else
				anticlockwise(d);
		int k;
		for( k = 0; k < d.length; k ++)
			if(d[k] == K)
				break;
		if(k != 0 && k != d.length-1)
		{
			res[1] = d[k-1];
			res[0] = d[k+1];
		}
		else if(k == 0)
		{
			res[1] = d[d.length-1];
			res[0] = d[k+1];
		}
		else
		{
			res[1] = d[k-1];
			res[0] = d[0];
		}
		return res;
	}
}
