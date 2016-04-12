package microsoft;

import java.util.Scanner;

public class FrontSize {
	
	public static boolean suit(int p, int s, int w, int h, int[] ps){
		int count_line = 0;
		int nb_x = w/s;// each line we can put ?
		int nb_y = h/s;
 		for(int i = 0; i < ps.length; i++){
			
			// how many lines for each paragraph
			count_line += Math.ceil(ps[i]*1.0 / nb_x);
		}
 		int p_need = (int)Math.ceil((count_line * 1.0) / nb_y);
 		return p_need <= p;
	}
	public static int fs(int n, int p, int w, int h, int[] ps){
		int s = Math.min(w, h);
		if(suit(p,s,w,h,ps))
			return s;
		while(s-- > 0){
			if(suit(p,s,w,h,ps))
				return s;
		}
		return s;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int nb = in.nextInt();
        	for(int i = 0; i < nb; i ++){
        		int N = in.nextInt();
        		int P = in.nextInt();
        		int W = in.nextInt();
        		int H = in.nextInt();
        		int[] ps = new int[N];
        		for(int j = 0; j < N; j++){
        			ps[j] = in.nextInt();
        		}
        		System.out.println(fs(N,P,W,H,ps));
        	}
        }
        in.close();
    }
}
