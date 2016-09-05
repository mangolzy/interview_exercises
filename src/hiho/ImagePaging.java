package hiho;
/*
import java.util.Scanner;

public class ImagePaging {

	public static int height(int[][] pics, int m){
		
		int tobedel = 0;
		int delta = 0;
		int n = pics.length;
		int acc = 0;
		int maxhigh = 0;
		int curhigh = 0;
		int tothigh = 0;
		int i = 0;
		while(i < n){
			while(i < n && acc + pics[i][0] <= m){
				acc += pics[i][0];
				if(pics[i][1] > maxhigh){
					if(maxhigh != 0)
						delta = pics[i][1] - maxhigh;
					maxhigh = pics[i][1];
				}
					
				i++;
			}
			if(i < n && acc < m){
				
				curhigh = (int) Math.ceil((m-acc) * 1.0 / pics[i][0] * pics[i][1]);
				if(curhigh > maxhigh){
					delta = curhigh - maxhigh;
					maxhigh = curhigh;
				}
				i++;
			}
			
			tothigh += maxhigh;
			//System.out.println(tothigh);
			acc = 0;
			curhigh = 0;
			if(delta > tobedel)
				tobedel = delta;
			delta = 0;
			maxhigh = 0;
		}
		//System.out.println(tothigh);
		return tothigh-tobedel;
	}
	
	
	public static int deleteOne(int[][] pics, int m){
		int minHight = Integer.MAX_VALUE;
		int[][] copy = new int[pics.length][2];
		for(int i = 0; i < pics.length; i++){
			copy[i][0] = pics[i][0];
			copy[i][1] = pics[i][1];
		}
	    
		for(int i = 0; i < pics.length; i++){
			
			copy[i][0] = 0;
			copy[i][1] = 0;
			int high = height(copy,m);
			if(high < minHight)
				minHight = high;
			copy[i][0] = pics[i][0];
			copy[i][1] = pics[i][1];
		}
		return minHight;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] pics = new int[N][2];
        for(int i = 0; i < N; i++){
        	pics[i][0] = in.nextInt();
        	pics[i][1] = in.nextInt();
        }
        System.out.println(height(pics,M));
        //System.out.println(deleteOne(pics,M));
        
	}
        
}
*/

/*
import java.util.Scanner;
import java.lang.Math;

public class ImagePaging {
    int m, n;
    int[] ws;
    int[] hs;


    public static void main(String[] args) {
        new ImagePaging().start();
    }

    void start() {
        Scanner  scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        ws = new int[n];
        hs = new int[n];
        for (int i = 0; i < n; i++) {
            ws[i] = scanner.nextInt();
            hs[i] = scanner.nextInt();
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            int tmp = compos(i);
            if (ans == -1) {
                ans = tmp;
            } else  {
                ans = Math.min(ans, tmp);
            }
        }
        System.out.println(ans);
    }

    int compos(int idx) {
        int tot = 0;
        int curH = 0;
        int remainW = m;
        for (int i = 0; i < n; i++) {
            if (i == idx) {
                if (i == n - 1) {
                    tot += curH;
                }
                continue;
            }
            if (ws[i] <= remainW) {
                remainW -= ws[i];
                curH = Math.max(curH, hs[i]);
            } else {
                int tmp = (int)Math.ceil((double)hs[i] * (double)remainW / (double)ws[i]);
                curH = Math.max(curH, tmp);
                remainW = 0;
            }

            if (remainW == 0 || i == n - 1) {
                tot += curH;
                curH = 0;
                remainW = m;
            }
        }
        return tot;
    }
}

*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author zkf
 *
 */

public class ImagePaging {
	private int m,n,minHeight;
	private int[][] whs;
	private Map<Integer, Integer> remHeightMap = new HashMap<>();

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				m = scanner.nextInt();
				n = scanner.nextInt();
				whs = new int[n][2];
				for (int i = 0; i < n; i++) {
					whs[i][0] = scanner.nextInt();
					whs[i][1] = scanner.nextInt();
				}

				solve();
			}
		}
	}

	private int[] solve1Line(int stN) {
		int curHgt = 0, remWid = m;
		int curN = stN;
		while (remWid > 0 && curN < n) {
			int w = whs[curN][0], h = whs[curN][1];
			if (w <= remWid) {
				remWid -= w;
			} else {
				h *= remWid;
				boolean carry = h % w != 0;
				h /= w;
				if (carry) h++;
				remWid = 0;
			}
			curHgt = Math.max(curHgt, h);
			curN++;
		}
		return new int[]{curHgt, curN};
	}

	private int solveRem(int stN) {
		if (stN >= n) return 0;
		Integer cache = remHeightMap.get(stN);
		if (cache != null) return cache;

		int[] hn = solve1Line(stN);
		int height = hn[0] + solveRem(hn[1]);
		remHeightMap.put(stN, height);
		return height;
	}

	private void solve() {
		remHeightMap.clear();
		minHeight = Integer.MAX_VALUE;

		int stN = 0, curHeight, aboveHeight = 0;
		while (stN < n) {
			int[] _1line = solve1Line(stN);
			int nextN = _1line[1];
			for (int i = stN; i < nextN; i++) {
				int w = whs[i][0], h = whs[i][1];
				whs[i][0] = whs[i][1] = 0;
				int[] curSol = solve1Line(stN);
				minHeight = Math.min(minHeight, aboveHeight + curSol[0] + solveRem(curSol[1]));
				whs[i][0] = w;
				whs[i][1] = h;
			}

			aboveHeight += _1line[0];
			stN = nextN;
		}

		System.out.println(minHeight);
	}

	public static void main(String[] args) {
		new ImagePaging().deal();
	}
}

