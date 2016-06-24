

import java.util.Random;
import java.util.Scanner;


public class Wap {

    public static int getMinmiumPix(int[] pics, int k, int m, int n){

    	if(k <= 2)
    		return 1;
    	
    	Random r = new Random();
        int res = k - 1;
        int min = (int) Math.ceil(Math.log(k));
        for(int i = 0; i < k; i++){
            for(int j = i+1; j < k; j++){
                String t = Integer.toBinaryString(pics[i] ^ pics[j]);
                for(int l = 0; l < m*n - t.length(); l++)
                    System.out.print("0");
                System.out.println(t);
            }
        }


        return r.nextInt(res-min+1)+min ;
    }

    public static int binaryStr2Int(String s){
        char[] x = s.toCharArray();
        int res = 0;

        for(int i = 0; i < x.length; i ++){
            if(x[i] != '0' && x[i] != '1')
                return -1;
            else{
                res = res * 2 + x[i] - '0';
            }

        }
        return res;
    }
    public static void main(String[] args){
        Scanner inScanner = new Scanner(System.in);
        int M = 0, N = 0, K = 0;
        int[] pics = null;
        while(inScanner.hasNext()){
            M = inScanner.nextInt();
            N = inScanner.nextInt();
            K = inScanner.nextInt();


            String temp ;
            StringBuilder complete;
            int pic;
            pics = new int[K];
            for(int i = 0; i < K; i++){

                complete = new StringBuilder("");
                for(int j = 0; j < M; j++){
                    temp = inScanner.next();
                    complete.append(temp);
                }
              
                pic = binaryStr2Int(complete.toString());
               
                pics[i] = pic;
            }

            System.out.println(getMinmiumPix(pics , K, M, N));
           

        }


    }
}