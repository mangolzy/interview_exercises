package hiho;

import java.util.Scanner;

public class EquationFill {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        
      
        String eq = in.next();
        
        String left = eq.split("=")[0];
        int res = Integer.parseInt(eq.split("=")[1]);
        
       
        
        String[] ops = left.split("\\+");
        int[] lens = new int[ops.length];
        for(int i = 0; i < ops.length; i++){
        	lens[i] = ops[i].length();
        }
        if(res == 0)
        	System.out.println(0);
        else
        	System.out.println(ops.length * 2);
	}
        
}
