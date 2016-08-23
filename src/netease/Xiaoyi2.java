package netease;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wangxiaoyi on 16/8/2.
 */
public class Xiaoyi2 {

    static class Step {
        int dx;
        int dy;
        Step(){}
        Step(int x, int y){
            dx = x;
            dy = y;
        }
    }

    static int count;
    static int max;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/wangxiaoyi/codes/leetcode/src/main/resources/1.txt"))));

        while (in.hasNext()) {
            count = 0;
            max = 0;
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] grid = new char[n][m];
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; ++i) {
                String str = in.next();
                for (int j = 0; j < m; ++j) {
                    grid[i][j] = str.charAt(j);
                    if (str.charAt(j) == '.') max++;
                }
            }
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            int k = in.nextInt();
            Step[] steps = new Step[k];
            for (int i = 0; i < k; i++) {
                Step step = new Step();
                step.dx = in.nextInt();
                step.dy = in.nextInt();
                steps[i] = step;
            }
            // deal
            System.out.println(go(steps, x0, y0, dp, n, m, grid));
        }

    }

    
/*
    public static int go(Step[] steps, int x, int y, int [][]dp, int n, int m, char[][] grid){
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(x, y));
        int max = -1;
        while (! queue.isEmpty()){
            Step position = queue.poll();
            for (int i = 0; i < steps.length; ++ i){
                int newx = position.dx + steps[i].dx;
                int newy = position.dy + steps[i].dy;
                if(newx >= 0 && newx < n && newy >=0 && newy < m && grid[newx][newy] == '.' && !(newx == x && newy == y)){
                    if(dp[newx][newy] == 0 || 1 + dp[position.dx][position.dy] <  dp[newx][newy]) {
                        dp[newx][newy] = 1 + dp[position.dx][position.dy];
                        queue.add(new Step(newx, newy));
                    }
                    max = Math.max(max, dp[newx][newy]);
                }
            }
        }
          for (int i = 0; i < n; ++ i){
            for (int j = 0; j < m; ++ j){
            	System.out.print(dp[i][j] + " ");
               // max = Math.max(dp[i][j], max);
            }
            System.out.println();
        }
        return max;
    }
    */
    
    public static int go(Step[] steps, int x, int y, int [][]dp, int n, int m, char[][] grid){
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(x, y));
        int max = 0;
        while (! queue.isEmpty()){
            Step position = queue.poll();
            for (int i = 0; i < steps.length; ++ i){
                int newx = position.dx + steps[i].dx;
                int newy = position.dy + steps[i].dy;
                if(newx >= 0 && newx < n && newy >=0 && newy < m && grid[newx][newy] == '.' && !(newx == x && newy == y)){
                    if(dp[newx][newy] == 0 || 1 + dp[position.dx][position.dy] <  dp[newx][newy]) {
                        dp[newx][newy] = 1 + dp[position.dx][position.dy];
                        queue.add(new Step(newx, newy));
                    }
                    //max = Math.max(max, dp[newx][newy]);
                }
            }
        }
        for (int i = 0; i < n; ++ i){
            for (int j = 0; j < m; ++ j){
            	//System.out.print(dp[i][j] + " ");
                max = Math.max(dp[i][j], max);
            }
            //System.out.println();
        }

        return max == 0 ? -1 : max;
    }
    

}