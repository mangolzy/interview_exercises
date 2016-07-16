package google2017apac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LazySpellingBee {
		public static int spelling(String b){
			int answer = 1;
			if(b.length() == 1)
					return answer;
				//bw.write("Case #"+(i+1) +": "+ answer);
			else if(b.length() == 2){
				if(b.charAt(1) != b.charAt(0))
					answer *= 2;
				if( b.charAt(b.length()-1) != b.charAt(b.length()-2))
					answer *= 2;
				//bw.write("Case #"+(i+1)  +": "+ answer);
				return answer;
			}
			
			else
			{
				for(int j = 0; j < b.length(); j++){
					if(j == 0 && b.charAt(1) != b.charAt(0))
						answer *= 2;
					if(j == b.length() - 1 && b.charAt(b.length()-1) != b.charAt(b.length()-2))
						answer *= 2;
					if( j > 0 && j < b.length() - 1){
						int count = 1;
						count += (b.charAt(j-1) == b.charAt(j))?0:1;
						count += (b.charAt(j) == b.charAt(j+1))?0:1;
						answer *= count;
					}
					
						
				}
				//bw.write("Case #"+(i+1)  +": "+ answer);
				return answer;
			}
		}

		public static void main(String[] args){
			
			
			
			try{
				String path = "/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/A-small_.in";
				String output = "/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/output_A1_.txt";
				BufferedReader br = new BufferedReader(new FileReader(path));
				BufferedWriter bw = new BufferedWriter(new FileWriter(output));
				String firstLine = br.readLine();
				int n = Integer.parseInt(firstLine);
				System.out.println(spelling("ag"));
				System.out.println(spelling("aa"));
				System.out.println(spelling("aade"));
				System.out.println(spelling("x"));
				for(int i = 0; i < n; i ++){
					String b = br.readLine();
					int answer = 1;
					if(b.length() == 1)
						bw.write("Case #"+(i+1) +": "+ answer);
					else if(b.length() == 2){
						if(b.charAt(1) != b.charAt(0))
							answer *= 2;
						if( b.charAt(b.length()-1) != b.charAt(b.length()-2))
							answer *= 2;
						bw.write("Case #"+(i+1)  +": "+ answer);
					}
					
					else
					{
						for(int j = 0; j < b.length(); j++){
							if(j == 0 && b.charAt(1) != b.charAt(0))
								answer *= 2;
							if(j == b.length() - 1 && b.charAt(b.length()-1) != b.charAt(b.length()-2))
								answer *= 2;
							if( j > 0 && j < b.length() - 1){
								int count = 1;
								count += (b.charAt(j-1) == b.charAt(j))?0:1;
								count += (b.charAt(j) == b.charAt(j+1))?0:1;
								answer *= count;
							}
							
								
						}
						bw.write("Case #"+(i+1)  +": "+ answer);
					}
				
					
					bw.flush();
					bw.newLine();
				}
				bw.close();
				br.close();
			}catch(Exception e){
				
			}
		}
}
