package microsoft;

import java.util.Scanner;

public class DemoDay {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        
        int M, N;

        while (in.hasNext()){
            M = in.nextInt();
            N = in.nextInt();
            int [][] maze = new int[M][N];
            int [][][] dp = new int[M][N][2];
            
            for(int i = 0; i < M; i ++){
                String s = in.next();
                for(int j = 0; j < N; ++ j){
                	if(s.charAt(j) == '.')
                		maze[i][j] = 0;
                	else
                		maze[i][j] = 1;
                }
            }
         
            int ans = 0;
            // 0 - right 
            // 1 - down 
            // 0 - ok
            // 1 - block
            dp[0][0][0] = maze[0][0] == 1?1:0;
            dp[0][0][1] = dp[0][0][0] + ((1 < N && maze[0][1] != 1)?1:0);
            
            // first row
            for(int i = 1; i < N; i ++)
            { 
            	// cost to go right by crossing the ij point  : the current block must be free
            	// =  from right || from up add the next row block 
            	dp[0][i][0] = (maze[0][i] == 1?1:0) + Math.min(dp[0][i-1][0], dp[0][i-1][1] + (1 < M && (maze[1][i-1]) != 1?1:0));
            	
            	dp[0][i][1] = dp[0][i][0] + (i+1 < N && maze[0][i+1] != 1?1:0);
            }
            // first column
            for(int j = 1; j < M; j ++)
            {
            	// cost up to (j,0) when it's coming from two different direction...
            	dp[j][0][1] = (maze[j][0] == 1?1:0) + Math.min(dp[j-1][0][1],dp[j-1][0][0] + (1 < N && maze[j-1][1] != 1?1:0));
            	dp[j][0][0] = dp[j][0][1] + (j+1 < M && maze[j+1][0] != 1?1:0);
            }
            
            for(int i = 1; i < M; i++){
            	for(int j = 1; j < N; j++){
            		dp[i][j][0] = (maze[i][j] == 1?1:0) + Math.min(dp[i][j-1][0], dp[i-1][j][1] + (i+1 < M && (maze[i+1][j]) != 1?1:0));
            				
            		dp[i][j][1] = (maze[i][j] == 1?1:0) + Math.min(dp[i-1][j][1], dp[i][j-1][0] + (j+1 < N && (maze[i][j+1]) != 1?1:0));
            	}
            }
            /*
            *
            for(int i = 0; i < M-1; i++)
            	for(int j = 0; j < N-1; j++){
            		update(dp[i][j][0], dp[i][j][1] + ((maze[i + 1][j] != 1)?1:0)); 
            		update(dp[i][j][1], dp[i][j][0] + ((maze[i][j + 1] != 1)?1:0)); 
            		update(dp[i][j + 1][0], dp[i][j][0] + ((maze[i][j + 1] != 0)?1:0));
            		update(dp[i + 1][j][1], dp[i][j][1] + ((maze[i + 1][j] != 0)?1:0));
            	}
            */
            for(int i = 0; i < M; i++){
            	for(int j = 0; j < N; j++){
            		System.out.print(dp[i][j][0]+","+dp[i][j][1]+" ");
            	}
            	System.out.println();
            }
            System.out.println(Math.min(dp[M-1][N-1][0],dp[M-1][N-1][1]));
        }
        
	}
}
