package netease;


	import java.util.Scanner;


	public class Beat{
	    

		public static void beat(int r, int[] c){
	    	int res = 0;
	        double dis1 = Math.sqrt((c[0] - c[6]) * (c[0] - c[6]) + (c[1] - c[7]) * (c[1] - c[7]));
	    	double dis2 = Math.sqrt((c[2] - c[6]) * (c[2] - c[6]) + (c[3] - c[7]) * (c[3] - c[7]));
	        double dis3 = Math.sqrt((c[4] - c[6]) * (c[4] - c[6]) + (c[5] - c[7]) * (c[5] - c[7]));
	        
	        if(dis1 <= r)
	            res ++;
	        if(dis2 <= r)
	            res ++;
	        if(dis3 <= r)
	            res ++;
	    	System.out.println(res+"x");
		}
	    public static void main(String[] args){
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext()){
	        	int r = in.nextInt();
	        	
	            int n = 8;
	       		int bi[] = new int[n];
	        	for(int i = 0; i < n; i++)
	        		bi[i] = in.nextInt();
	        	beat(r,bi);
	        }
	        in.close();
	    }
	}