package googleCodeJam4Women2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Asmall {
	public static void main(String[] args){
		//test
		/*
		int[] test = {15,20,60,75,80,100};
		//int[] test = {9,9,12,12,12,15,16,20};
		int[] get = cody(3,test);
		for(int i :get)
			System.out.println(i);
		*/
		//process
		
		try{
			String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/googleCodeJam4Women2016/A-large.in";
			String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/googleCodeJam4Women2016/output_A1.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			String firstLine = br.readLine();
			int n = Integer.parseInt(firstLine);	
			String cases = "";
			for(int i = 0; i < n; i++)
			{
				 String b = br.readLine();
				 int len = Integer.parseInt(b);
				 //char[] characters = new char[len*8];
				 //br.read(characters, 0, len);
				 String[] p = br.readLine().split(" ");
				 int[] input = new int[len*2];
				 for(int j = 0; j < p.length; j++)
					 input[j] = Integer.parseInt(p[j]);
				 int[] res = cody(len,input);
			
				bw.write("Case #"+(i+1)+": ");
				for(int k = 0; k < len; k++)
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
	
	public static int[] cody(int len, int[] a)
	{
		int res[] = new int[len];
		res[0] = a[0];
		int i; // for original
		int j = 0; // for sale
		
		int current = res[0];
		for(i = 1; i < a.length && j < a.length; i++)
		{
			
			if(a[i] == (current /3 *4))
			{
				//System.out.println("cur" + current);
				a[i] = 0;
				j++;
				//while(a[j] == 0 && j < a.length)
					//j++;
				if(a[j] == 0)
				{
					while(j<a.length - 1&&a[j] == 0)
						j++;
				
					current = a[j];
					
				}
				else
				{	
				
					current = a[j];
				
				}
				
					
			}
			
		}
		int c = 0;
		for(int k = 0; k < a.length; k++)
		{
			
			
			if(a[k] == 0)
				continue;
			else
			{
				res[c] = a[k];
				c++;
			}
			
		}
	
		
				
		return res;
	}
}
