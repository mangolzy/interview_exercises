package netease;

import java.util.Scanner;


public class Main{
    
    public static int gcd(int a, int b){
		int r = a>b?a:b;
    	while(r != 0){
        	r = a % b;
        	a = b;
        	b = r;
    	}
    	return a;
	}

	public static void game(int n, int a, int[] bi){
    	int c = a;
    	for(int i = 0; i < n; i ++){
        	if(c >= bi[i])
           	 	c += bi[i];
        	else
            	c += gcd(bi[i],c);
    	}
    	System.out.println(c);
	}
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
            int a = in.nextInt();
       		int bi[] = new int[n];
        	for(int i = 0; i < n; i++)
        		bi[i] = in.nextInt();
        	game(n,a,bi);
        }
        in.close();
    }
}
