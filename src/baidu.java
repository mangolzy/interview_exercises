import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class baidu {
   public static String aphabet2num(String a, String b){
	   StringBuilder s = new StringBuilder("");
	   Object o = new Object();
	   HashMap<String,String> hm = new HashMap<String, String>();
	   
	   ConcurrentHashMap<String, ArrayList<Integer>> chm = new ConcurrentHashMap<String, ArrayList<Integer>>();
	   char[] x = a.toCharArray();
	   int l = x.length;
	   int col = 0;
	   int t = 0;
	   for(int i = 0; i < l; i++){
		   t = x[i] - 'A'+1;
		   col = col * 26 + t;
	   }
	  // int row = Integer.parseInt(b);
	   s.append("R");
	   s.append(b);
	   s.append("C");
	   s.append(Integer.toString(col));
	   return s.toString();
   }
   
   
   public static String num2aphabet(int row, int col){
	   StringBuilder s = new StringBuilder("");
	   StringBuilder p = new StringBuilder("");
	   int t = 0;
	 
	   while(col > 0){
		   t = col % 26;
		   p.append((char)('A'+t-1));
		   col = col / 26;
	   }
	   p.reverse();
	   s.append(p);
	   s.append(Integer.toString(row));
	   
	   return s.toString();
   }
   
   public static void main(String[] args){
	  
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
       	int T = in.nextInt();
        String[] s = new String[T];
       	for(int i = 0; i < T; i++){
       		s[i] = in.next();
       	}
       	for(int i = 0; i < T; i++){
       		char[] x = s[i].toCharArray();
       		int flag = 0; // r...c...
       		int row = 0;
       		int col = 0;
       		int rc = 0;
       		String a = "";
       		String b = "";
       		int j = 0;
       		int r = s[i].indexOf('R');
       		int c = s[i].indexOf('C');
       		
       		if(r == -1 || c == -1)
       			flag = 1;
       		else if(c - r > 1)
       		{for(j = r; j < c; j++)
       			if(x[j] - '0' > 9 ||  x[j] - '0' < 0)
       			{
       				flag = 1;
       				break;
       			}
       		}
       		
       		for(j = 0; j < x.length; j ++){
       			
       			if(j == 0 && x[j] != 'R')
       			{
       				//System.out.println("1");
       				flag = 1;
       				break;
       			}
       			else if(j > 0 && x[j] != 'C' && rc == 0 && (x[j] - '0' > 9 ||  x[j] - '0' < 0)){
       				//System.out.println("2");
       				flag = 1;
       				break;
       			}
       			else if(x[j] == 'C'){
       				break;
       			}	
       			
       		}
       		
       		
       		//System.out.println(s[i].substring(1,j));
       		if(flag == 0){
       			row = Integer.parseInt(s[i].substring(1,c));
       			col = Integer.parseInt(s[i].substring(c+1,s[i].length()));
       			System.out.println(num2aphabet(row,col));
       		}
       		else{
       			for(j = 0; j < x.length; j ++){
           			if(x[j] - 'A' >= 0 && x[j] - 'Z' <= 0)
           				a += x[j];
           			else
           				break;
           		}
           		
           		b = s[i].substring(j,s[i].length());
       			//System.out.println(j);
       			//System.out.println(b);
       			System.out.println(aphabet2num(a ,b));
       		}
       			
       
       	}	
       
       }
   		in.close();
   }
}
   
