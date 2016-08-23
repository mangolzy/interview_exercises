package youdao;



import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String []args) throws IOException{
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/wangxiaoyi/codes/leetcode/src/main/resources/1.txt"))));
        while (in.hasNext()){

            int T = in.nextInt();
            for (int i = 0; i < T; ++ i){
                int n = in.nextInt();
                int k = in.nextInt();
                Stack<Long> data = new Stack<>();
                for (int j = 0; j < n; ++ j){
                    data.add(in.nextLong());
                }
                for (int j = 0; j < n; ++ j){
                    data.add(in.nextLong());
                }
                run(k, data, n);
            }

        }

    }

    public static void run(int k,  Stack<Long> data, int n){
        Stack<Long> left = new Stack<>();
        Stack<Long> right = new Stack<>();
        for (int i = 0; i < k; i ++){
            for (int j = 0; j < n; ++ j)
                left.push(data.pop());
            for (int j = 0; j < n; ++ j)
                right.push(data.pop());
            for (int j = 0; j < n; ++ j){
                data.push(right.pop());
                data.push(left.pop());
            }
        }
        int count = 0;
        while (!data.isEmpty()) left.add(data.pop());
        data = left;

        while (!data.isEmpty()){
            count ++;
            if(count == 2 * n){
                System.out.println(data.pop());
            }else {
                System.out.print(data.pop() + " ");
            }
        }
    }
}


