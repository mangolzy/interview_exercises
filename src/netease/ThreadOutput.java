package netease;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ThreadOutput {
	
	public static void main(String[] args){
		try{
			
			// construct the input for the multi-threads to treat
			PrintWriter pw = new PrintWriter(new FileWriter(new File("/Users/ryoushiken/Documents/workspace/leetcode/src/netease/input.txt"),true));
			Random random = new Random();
			for(int i = 0; i < 10000; i ++){
				pw.print(Math.abs(random.nextInt())%100 + " ");
			}
			pw.flush();
			pw.close();
			
			BufferedReader reader = new BufferedReader(new FileReader("/Users/ryoushiken/Documents/workspace/leetcode/src/netease/input.txt"));
			String str = reader.readLine();
			reader.close();
			
			String[] strs = str.split(" ");
			int j = 0;
			for(int i = 0; i < 5; i ++){
				int records[] = new int[2000];
				for(int k = 0; k < 2000; k++){
					records[k] = Integer.parseInt(strs[j]);
					j++;
				}
				PrintWriter writer = new PrintWriter(new FileWriter(new File("/Users/ryoushiken/Documents/workspace/leetcode/src/netease/output"+i+".txt")),true);
				ThreadGroup group = new ThreadGroup(records, writer);
				new Thread(group).start();
				new Thread(group).start();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	

}

class ThreadGroup implements Runnable{
	private static int count = 0;
	private static Object lock = new Object();
	public static final int EVEN = 0;
	public static final int ODD = 1;
	
	private int type;
	private int records[];
	private PrintWriter writer;
	private int oddPoint = 0;
	private int evenPoint = 0;
	
	public ThreadGroup(int[] records, PrintWriter writer){
		this.records = records;
		this.writer = writer;
		this.type = EVEN;
	}
	
	public void run(){
		while(print());
		
	}
	
	private synchronized boolean print(){
		for(int i = 0; i < 10; ){
			if(oddPoint >= records.length && evenPoint >= records.length){
				notifyAll();
				return false;
			}
			if((oddPoint >= records.length && type == ODD) 
					|| (evenPoint >= records.length && type ==EVEN))
				break;
			if(type == EVEN){
				if(records[evenPoint] % 2 == 0){
					i++;
					writer.print(records[evenPoint] + " ");
					writer.flush();
					synchronized (lock){
						count ++;
						if(count % 1000 == 0){
							System.out.println("currently finished: "+count);
							if(count == 10000)
								System.out.println("Done");
						}
					}
				
				}
				evenPoint++;
			}else{
				if(records[oddPoint] % 2 == 1){
					i++;
					writer.print(records[oddPoint] + " ");
					writer.flush();
					synchronized(lock){
						count++;
						if(count % 1000 == 0){
							System.out.println("currently finished: "+count);
							if(count == 10000)
								System.out.println("Done");
						}
					}
				}
				oddPoint++;
			}
		}
		type = Math.abs(1-type);
		notifyAll();
		try{
			wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return true;
		
	}
}
