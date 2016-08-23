package youdao;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_ {



    public static void main(String [] args) throws IOException{
        Scanner in = new Scanner(System.in);
      
        while (in.hasNext()){
            int T = in.nextInt();
            for (int i = 0; i < T; ++i){
                int k = in.nextInt();
                myqueue(k);
            }
        }
    }


    public static void myqueue(int k){
        Stack<Integer> input = new Stack<Integer>();
        Queue<Integer> index = new LinkedList<Integer>();
        for (int i = 1; i <= k; ++ i){
            input.push(k - i + 1);
            index.offer(i);
        }
        int ans[] = new int[k + 2];
        while (!index.isEmpty() && !input.isEmpty()){
            int i = index.poll();
            if(index.isEmpty()){
                ans[i] = input.pop();
            }else {
                ans[index.poll()] = input.pop();
            }
            index.add(i);
        }
        for (int i = 0; i < k - 1; i++){
            System.out.print(ans[k - i] + " ");
        }
        System.out.println(ans[1]);

    }


}
