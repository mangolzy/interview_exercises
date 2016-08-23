package netease;

import java.util.HashMap;
import java.util.Scanner;

public class xiaozhao3 {
/*
 * 4 4
3 3 3 2
3 2 3 3
3 3 3 2
2 3 2 3

4
 */

	    static int maxSize = 0;
	    static int[] hengxiang= new int[4];
	    static int[] zhongxiang= new int[4];
	    public static void main(String args[])
	    {
	        int x= 3,y =3;
	    	int m = 0, n = 0;
	    	int[][] square ={ };
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext()){
	        	m = in.nextInt();
	        	n = in.nextInt();
	        	square = new int[m][n];
	        	//{};//待初始化
	        	
	        	for(int i = 0; i < m; i ++){
	        		for(int j = 0; j < n; j++){
	        			square[i][j] = in.nextInt();
	        		}
	        	}
	        	 divide(x,y,m,n,square);

	 	        System.out.println(maxSize);
	        }
	        

	       // divide(x,y,m,n,square);

	      //  System.out.println(maxSize);
	    }

	     /**
     *
     * @param n 横向剩下几刀
     * @param m 纵向剩下几刀
     * @param i 矩阵剩下的长度
     * @param j 矩阵剩下的宽度
     * @param square  田地
     */
    public static void divide(int n,int m,int i,int j,int [][]square){
        if(n<0 || m<0)
            return;

        if(n>0)
        {
            for(int k = 1;k<=i-n+1;k++)
            {
                hengxiang[n] = i-k;
                divide(n-1,m,i-k,j,square);
            }
        }
        else if(m>0)
        {
            for(int k = 1;k<=j-m+1;k++)
            {
                zhongxiang[m] = j-k;
                divide(n,m-1,i,j-k,square);
            }
        }else {
            if(maxSize<getMin(square))
                maxSize = getMin(square);
        }
    }

    /**
     * 得到土地最小值
     * @param square
     * @return
     */
    public static int getMin(int [][]square)
    {
        int minSize = 0;
        for(int i = 1;i<4;i++)
        {
            for(int j = 1;j<4;j++)
            {
                if(minSize>calcSquare(hengxiang[i-1],hengxiang[i],zhongxiang[j-1],zhongxiang[j],square))
                    minSize = calcSquare(hengxiang[i-1],hengxiang[i],zhongxiang[j-1],zhongxiang[j],square);
            }
        }
        return minSize;
    }

    /**
     * 得到指定范围土地价值
     * @param i_start
     * @param i_end
     * @param j_start
     * @param j_end
     * @param square
     * @return
     */
    public static int calcSquare(int i_start,int i_end,int j_start,int j_end,int [][]square)
    {
        int size = 0;
        for(int k = i_start;k<i_end;k++)
        {
            for(int z = j_start;z<j_end;z++)
            {
                size +=square[k][z];
            }
        }
        return size;
    }

	

	
}


