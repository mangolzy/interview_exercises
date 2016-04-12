package microsoft;


import java.util.Scanner;


public class MagicBox {
	
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int x = in.nextInt();
        	int y = in.nextInt();
        	int z = in.nextInt();
        	
        	
        	String balls = in.next();
        	int max = 0;
        	int len = balls.length();
        	int r = 0;
        	int b = 0;
        	int ye = 0;
        	int cur = 0;
        	
        	int o = 0;
        	int p = 0;
        	int q = 0;
        	
        	for(int i = 0; i < len; i ++){
        		cur ++;
        		switch(balls.charAt(i)){
        			case 'R': r++;break;
        			case 'B': b++;break;
        			case 'Y': ye++;break;
        			default: break;
        		}
        		o = Math.abs(r - b);
        		p = Math.abs(b -ye);
        		q = Math.abs(r - ye);
        		if((o == x && p == y && q == z) 
        				|| (o == x && p == z && q == y)
        				|| (o == y && p == x && q == z)
        				|| (o == y && p == z && q == x)
        				|| (o == z && p == x && q == y)
        				|| (o == z && p == y && q == x)){
        			
        			if(cur > max)
        				max = cur;
        			cur = 0;
        			r = 0;
        			b = 0;
        			ye = 0;
        		}	
        	}
        	if(cur > max)
				max = cur;
        	System.out.println(max);
        	
        }
        in.close();
        
    }
}
