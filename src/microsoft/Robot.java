package microsoft;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;
import java.math.*;
import java.awt.Window;
public class Robot {

    Robot(int i){
    	;
    }
    

    private static int minSum = Integer.MAX_VALUE;

    public static void main(String []args)throws IOException{
      
    	//List<String> a = new LinkedList<String>();
        //Collections.sort(a);
        //Window.getWindows();
        //Bag bg = new Bag();
        //Insertion.sort();
        
        Scanner in = new Scanner(System.in);
        //Robot rr = new Robot();
        int M, N;

        while (in.hasNext()){
            M = in.nextInt();
            N = in.nextInt();
            int [][] maze = new int[M][N];
            int [][][] dp = new int[M][N][2];
            dp[0][0][0] = 0; 
            for(int i = 0; i < M; i ++){
                String s = in.next();
                for(int j = 0; j < N; ++ j){
                	if(s.charAt(j) == '.')
                		maze[i][j] = 0;
                	else
                		maze[i][j] = 1;
                }
            }

            int ans = minCost(maze, M, N, 0);
            for(int i = 0; i < M-1; i++)
            	for(int j = 0; j < N-1; j++){
            		update(dp[i][j][0], dp[i][j][1] + ((maze[i + 1][j] != 1)?1:0)); 
            		update(dp[i][j][1], dp[i][j][0] + ((maze[i][j + 1] != 1)?1:0)); 
            		update(dp[i][j + 1][0], dp[i][j][0] + ((maze[i][j + 1] != 0)?1:0));
            		update(dp[i + 1][j][1], dp[i][j][1] + ((maze[i + 1][j] != 0)?1:0));
            	}
            System.out.println(Math.min(dp[M-1][N-1][0],dp[M-1][N-1][1]));
            //String d = Locale.CHINA;  geographic zone setting
            // DecimalFormat df = DecimalFormat.;
        }


    }

  
    public static int update(int a,int b){ 
    	int v= Math.min(a, b);
    	return v;
    } // 0 right, 1 down 
    


    public static int minCost(int[][] maze, int M, int N, int cur){
    	
    	if(M == 1 || N == 1)
        	return 1000;
    	


    	return Math.min(minCost(maze, M-1, N-1, cur),minSum);
    }


}