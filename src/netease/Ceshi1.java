package netease;

import java.util.Scanner;

public class Ceshi1 {
	
	    public static void main(String[] args){
	        
	        
	        Scanner in = new Scanner(System.in);
	        
	        while(in.hasNext()){
	            String input = in.nextLine();
	            System.out.println(input);
	            String[] ab = input.split(" ");
	            String a = ab[0];
	            int da = Integer.parseInt(ab[1]);
	            String b = ab[2];
	            int db = Integer.parseInt(ab[3]);
	            int A = 0, B = 0;
	            for(int i = 0; i < a.length(); i++){
	                if(a.charAt(i) - '0' == da)
	                	A = A*10 + da;
	            }
	             for(int j = 0; j < b.length(); j++){
	                if(b.charAt(j) - '0' == db)
	                	B = B*10 + db;
	            }
	            
	            System.out.println(A+B);
	            
	        }
	    }
	}
