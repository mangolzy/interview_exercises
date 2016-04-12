package microsoft;

import java.util.Scanner;

public class Forbidden {
	
	 public static boolean allow(int[] rule, int[] req,int x){
		 for(int r = 0; r < x; r++)
			 if(rule[r] != req[r])
				 return false;
		 return true;
	 }
	 
	 public static boolean deny(int[] rule, int[] req, int x){
		 for(int r = 0; r < x; r++)
			 if(rule[r] != req[r])
				 return false;
		 return true;
	 }
	 
	 public static boolean check(int[][] rules, int[] req, int n, int[] flag, int[] m){
		 for(int i = 0; i < n; i++){
			 if(flag[i] == 1){
				 if(allow(rules[i],req,m[i])){
					 //System.out.println("allow");
					 return true;
				 }
					 
				 else
					 ;
				 
			 }
			 else{
				 if(deny(rules[i],req,m[i])){
					 //System.out.println("deny");
					 return false;
				 }
					 
				 else
					 ;
			 }		 
		 }
		 return true;
	 }
	 public static int[] binary(String s){
		 int[] myaddr = new int[32];
		 if(s.length() > 0){
			 String[] addr = s.split("\\.");
			// System.out.println(addr[0]);
			 // normally 4
			 for(int i = 0; i < addr.length; i++){
				 int c = Integer.parseInt(addr[i]);
				 //System.out.println(c);
				 String x = Integer.toBinaryString(c);
				 //System.out.println(x);
				 int l = x.length();
				 for(int j = 0; j < x.length(); j++){
					 myaddr[(i+1)*8 - 1-j] = x.charAt(l-1-j) -'0';
					 
				 } 
			 }
				 
		 }
		 return myaddr;
			 
	 }
	
	  public static void main(String[] args) {
		  
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext()) {
	        	int n = in.nextInt();
	        	int m = in.nextInt();
	        	int[][] rules = new int[n][32];
	        	int[] flag = new int[n];
	        	int[] mask = new int[n];
	        	int[][] req = new int[m][32];
	        	for(int i = 0; i < n; i++){
	        		String f = in.next();
	        		String r = in.next();
	        		if(f.equals("allow"))
	        			flag[i] = 1;  // allow
	        		else
	        			flag[i] = 0;  // deny
	        		
	        		String[] rs = r.split("/");
	        		if(rs.length == 1){
	        			rules[i] = binary(rs[0]);
	        			mask[i] = 32;
	        		}
	        		else{
	        			rules[i] = binary(rs[0]);
	        			mask[i] = Integer.parseInt(rs[1]);
	        			//int mask = Integer.parseInt(rs[0]);
	        			// we mask the bits after mask bit;
	        			//for(int k = 20; k < 32; k ++)
	        				//rules[i][k] = 1;
	        		}
	        				
	        	}
	        	
	        	for(int j = 0; j < m; j++){
	        		String re = in.next();
	        		req[j] = binary(re);
	        	}
	        	
	        	// check
	        	for(int t = 0; t < m; t ++){
	        		if(check(rules, req[t], n, flag,mask))
	        			System.out.println("YES");
	        		else
	        			System.out.println("NO");
	        	}
	        	
	        	
	        }
	        in.close();
	       
		  	//System.out.println(Integer.toBinaryString(128));
		    //int[] x = binary("128.127.8.125");
		  	//for(int i = 0; i < 32; i++)
		  	//	System.out.print(x[i]);
	    }
		  
}
