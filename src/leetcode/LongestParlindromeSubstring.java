package leetcode;

public class LongestParlindromeSubstring {
	// naive N^3 solution
	public String naiveLPS(String s){
		int l = s.length();
		int maxlen = 0;
		int start = 0;
		for(int i = 0; i < l; i++){
			for(int j = i+1; j < l; j++){
				// try all possible substring, and test
				int tmp1,tmp2;
				for(tmp1 = i, tmp2 = j; tmp1 < tmp2; tmp1 ++, tmp2 --){
					if(s.charAt(tmp1) != s.charAt(tmp2))
						break;
				}
				if(tmp1 >= tmp2){
					if(j-i+1 > maxlen){
						maxlen = j-i+1;
						start = i;
					}
						
				}
			}
		}
		System.out.println(start);
		if(maxlen > 0)
			return s.substring(start, start + maxlen);
		else
			return null;
	}
	
	// n^2 space & n^2 time complexity : dynamic programming
	public String dpLPS(String s){
		int len = s.length();
		int[][] dp = new int[len][len];
		
		int maxlen = 0;
		int start = 0;
		
		// initialization for 1 step & 2 step:
		for(int i = 0; i < len; i++){
			// trivial case
			dp[i][i] = 1;
			if(i < len - 1 && s.charAt(i) == s.charAt(i+1)){
				dp[i][i+1] = 1;
				start = i;
				maxlen = 2;
			}
		}
		// deal with longer substring
		for(int j = 3; j < len; j ++){
			for(int k = 0; k <= len-j; k ++){
				int end = k + j - 1;
				if(dp[k+1][end-1] == 1 && s.charAt(k) == s.charAt(end)){
					dp[k][end] = dp[k+1][end-1];
						maxlen = j;
						start = k;
				}
				else
					dp[k][end] = 0;
			}
		}
		if(maxlen > 0)
			return s.substring(start, start+maxlen);
		else
			return null;
	}
	
	// expending construction: n^2
	int maxl = 0;
	int sp = 0;
	public String expLPS(String s){
		
		// treat odd length substring & even length substring differently
		for(int i = 0; i < s.length()-1; i++){
			construct(s,i,i);
			construct(s,i,i+1);
		}
		if(maxl > 0)
			return s.substring(sp, sp+maxl);
		else
			return null;
	}
	
	public void construct(String s, int m, int n){
		while(m >= 0 && n <= s.length() && s.charAt(m) == s.charAt(n)){
			m--;
			n++;
		}
		// update
		if(n-m-1 > maxl){
			maxl = n-m-1;
			sp = m+1;
		}
	}
	
	public static void main(String[] args){
		LongestParlindromeSubstring lps = new LongestParlindromeSubstring();
		System.out.println(lps.naiveLPS("ababbcbbab"));
		System.out.println(lps.dpLPS("abcabbcbbab"));
		System.out.println(lps.expLPS("absddssfa"));
	}
}
