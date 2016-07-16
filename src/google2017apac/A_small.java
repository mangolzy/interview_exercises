package google2017apac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class A_small {
	
	
	public static String leader(String[] names){
		 int nb = names.length;
		 int[] count = new int[nb];
		 Arrays.sort(names);
		 for(int i = 0; i < nb; i ++){
			 char[] name = names[i].replace(" ","").toCharArray();
			 int[] alphabet = new int[26];
			 for(int j = 0; j < name.length; j++){
				 alphabet[name[j] - 'A'] += 1;
			 }
			 for(int k = 0; k < 26; k++){
				 count[i] += (alphabet[k] == 0?0:1);
			 }
				 
		 }
		 int maxIndex = 0;
		 int max = -1;
		 for(int l = 0; l < nb; l ++){
			 if(count[l] > max){
				 max = count[l];
				 maxIndex = l;
			 }
		 }
		 return names[maxIndex];
	}
	public static void main(String[] args){
		
		
		try{
			String path = "/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/A-large.in";
			String output = "/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/result.out";
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			String firstLine = br.readLine();
			int n = Integer.parseInt(firstLine);
			//String[] names = {"ADAM","BOB","JOHNSON"};
			//String[] names = {"DEF","A AB C"};
			//System.out.println(leader(names));
			for(int i = 0; i < n; i ++){
				
				String b = br.readLine();
				int nb_line = Integer.parseInt(b);
				String[] names = new String[nb_line];
				for(int j = 0; j < nb_line; j++){
					names[j] = br.readLine();
				}
				String name = leader(names);
				bw.write("Case #"+(i+1)+": "+name);

				bw.flush();
				bw.newLine();
			}
			bw.close();
			br.close();

		}catch(Exception e){
			e.printStackTrace();		
		}
	}
}
