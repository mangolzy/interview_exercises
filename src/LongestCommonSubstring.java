
public class LongestCommonSubstring {
	public static int Solution(String s, String t){
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int M = s.length();
		int N = t.length();
		int[][] res = new int[M+1][N+1];
		int[][] res2 = new int[M+1][N+1];
		int longestContinousCommonSubstring = 0;
		for(int i = 0; i < M; i ++){
			for(int j = 0; j < N; j ++){
				if(sc[i] != tc[j]){
					res[i+1][j+1] = Math.max(res[i][j+1],res[i+1][j]);
					res2[i+1][j+1] = 0;
				}
					
				else{
					res[i+1][j+1] = res[i][j] + 1;
					res2[i+1][j+1] = res2[i][j] + 1;
				}
					
				if(res2[i+1][j+1] > longestContinousCommonSubstring)
					longestContinousCommonSubstring = res[i+1][j+1];
			}
		}
		for(int i = 0; i < M+1; i ++){
			for(int j = 0; j < N+1; j ++){
				System.out.print(res2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("longestContinousCommonSubstring "+ longestContinousCommonSubstring);
		return res[M][N];
		
		//StringBuffer s = new StringBuffer();
 	}
	
	public static void main(String[] args){
		System.out.println(Solution("abcdx","axcdab"));
		System.out.println(Solution("abcdxabcsdf","axcdabcdnds"));
	}
}
