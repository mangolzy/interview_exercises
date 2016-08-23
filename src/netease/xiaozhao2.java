package netease;
/*
 * 
 * 3 3
...
...
...
0 0
4
1 0 
0 1
-1 0
0 -1
 */
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class xiaozhao2 {
	
	
	public static void main(String []args)throws IOException{
	      
    	
        
        Scanner in = new Scanner(System.in);
        //Robot rr = new Robot();
        int M, N;

        while (in.hasNext()){
            M = in.nextInt();
            N = in.nextInt();
            int [][] maze = new int[M][N];
            //int [][][] dp = new int[M][N][2];
            //dp[0][0][0] = 0; 
            for(int i = 0; i < M; i ++){
                String s = in.next();
                for(int j = 0; j < N; ++ j){
                	if(s.charAt(j) == '.')
                		maze[i][j] = 0;
                	else
                		maze[i][j] = 1;
                }
            }
            int starti = in.nextInt();
            int startj = in.nextInt();
            int step = in.nextInt();
            int[][] steps = new int[step][2];
            for(int j = 0; j < step; j++){
            	steps[j][0] = in.nextInt();
            	steps[j][1] = in.nextInt();
            }
            int maxStep = 0;
            List<Integer> max = new ArrayList<Integer>();
            forward(starti, startj, steps, 0, M-1,N-1, max, maze);
            for(int l : max){
            	if(l > maxStep)
            		maxStep = l;
            }
            System.out.println(maxStep);
        }


    }

  
    public static void forward(int x, int y, int[][] possible, int curCount, int m, int n, List<Integer> max, int[][] maze){ 
    	if(x == m && y == n){
    		max.add(curCount);
    	}
    	else{
    		int p = possible.length;
    		int newx, newy;
    		for(int i = 0; i < p; i++){
    			newx = x+possible[i][0];
    			newy = y+possible[i][1];
    			if(newx < 0 || newy < 0 || newx > m || newy > n || maze[newx][newy] > 1){
    				continue;
    			}
    			else
    				forward(newx, newy, possible, curCount+1, m, n, max, maze);
    		}
    	}
    } 
}
