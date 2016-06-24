package indeed;

import java.util.ArrayList;
import java.util.Scanner;

public class Pwd {

	public static int distance(char[] s, char[] t){
		
		if(s.length != t.length)
			return -1;
		
		else{
			int[] store1 = new int[4];
			int[] store2 = new int[4];
			int res = 0;
			for(int i = 0; i < s.length; i ++)
				store1[s[i] - 'a'] ++;
			for(int j = 0; j < t.length; j ++)
				store2[t[j] - 'a'] ++;
			for(int k = 0 ; k < 4; k ++)
				if(store1[k] == store2[k])
					;
				else
					res += Math.abs(store1[k] - store2[k]);
			
			
			return res/2;
		}
	}
	
	public static void main(String[] args) {
		// this is the library and check method.
		// we still can try a generative method.
		String[] len1 = {"a", "b", "c", "d"};
		String[] len2 = {"aa","ab","ac","ad","ba","bb","bc","bd","ca","cb","cc","cd","da","db","dc","dd"};
		String[] len3 = {"aaa","aab","aac","aad","aba","abb","abc","abd","aca","acb","acc","acd","ada","adb","adc","add",
						"baa","bab","bac","bad","bba","bbb","bbc","bbd","bca","bcb","bcc","bcd","bda","bdb","bdc","bdd",
						"caa","cab","cac","cad","cba","cbb","cbc","cbd","cca","ccb","ccc","ccd","cda","cdb","cdc","cdd",
						"daa","dab","dac","dad","dba","dbb","dbc","dbd","dca","dcb","dcc","dcd","dda","ddb","ddc","ddd"};
		Scanner in  = new Scanner(System.in);
		while(in.hasNext()){
			String query = in.next();
			int len = query.length();
			if(len == 1){
				for(int i = 0; i < len1.length; i ++){
					System.out.println(len1[i]);
				}
			}
			else if(len == 2){
				for(int i = 0; i < len2.length; i ++){
					if(query.indexOf(len2[i].charAt(0)) == -1 && query.indexOf(len2[i].charAt(1)) == -1) 
						;
					else 
						System.out.println(len2[i]);
				}
			}
			else{
				for(int i = 0; i < len3.length; i ++){
					if(distance(query.toCharArray(), len3[i].toCharArray()) <= 1){
						System.out.println(len3[i]);
					}
				}
			}
		}
		in.close();
	}

}
