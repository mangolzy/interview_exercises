package leetcode;

import java.util.Scanner;

public class Max1Square {
	public static int maximalRectangle(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0)
        	return 0;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i < m + 1; i ++)
        	for(int j = 1; j < n + 1; j++){
        		if(matrix[i-1][j-1] == 1){
        			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
        			max = Math.max(max, dp[i][j]);
        		}			
        	}
        
        for(int x = 0; x < dp.length; x++){
        	for(int y = 0; y < dp[0].length; y++)
        		System.out.print(dp[x][y] + " ");
        	System.out.println();
        }
        return max;
    }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n;
		int m;
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] matrix = new int[n][m];
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j ++)
				matrix[i][j] = sc.nextInt();
		
		sc.close();
		System.out.println(maximalRectangle(matrix));
	}
}
