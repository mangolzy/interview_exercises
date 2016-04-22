package leetcode;

public class Countandsay {
	public String countAndSay(int n){
		if(n == 0)
			return "";
		if(n == 1)
			return "1";
		StringBuilder s = new StringBuilder("1");
		for(int i = 2; i <= n; i++){
			s = say(s);
		}
		return s.toString();
	}
	
	public StringBuilder say(StringBuilder s){
		int count;
		StringBuilder t = new StringBuilder("");
		int j;
		for(int i = 0; i < s.length(); i++){
			count = 0;
			j = i+1;
			while(j < s.length() && s.charAt(i) == s.charAt(j)){
				count ++;
				j++;
			}
			i = j - 1; // go pass the duplicate
			t.append(count);
			t.append(s.charAt(i));
		}
		return t;
	}
}
