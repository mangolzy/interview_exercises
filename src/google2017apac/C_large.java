package google2017apac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class C_large {
public static void main(String[] args){
		
		
		try{
			String path = "/Users/ryoushiken/Documents/workspace/leetcode/src/google2017apac/C-large.in";
			String output = "/Users/ryoushiken/Documents/workspace/leetcode/src/google2017apac/output_C2.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			String firstLine = br.readLine();
			int n = Integer.parseInt(firstLine);
			
			for(int i = 0; i < n; i ++){
				String b = br.readLine();
				
			
				bw.write("Case #"+(i+1)+": ");
				
				bw.write(" ");
				bw.flush();
				bw.newLine();
			}
			bw.close();
			br.close();

		}catch(Exception e){
					
		}
	}
}
