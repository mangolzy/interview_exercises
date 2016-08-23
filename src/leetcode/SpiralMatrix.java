package leetcode;

public class SpiralMatrix {

	    public int[] clockwisePrint(int[][] mat, int n, int m) {
	        // write code here
	        // the main point is we print a circle each time in general
	        // but we have to handle the special cases
	        // and there will be min(m, n) / 2 iteration
	        int[] res = new int[n*m];
	        int index = 0;
	        int iter =(int) Math.ceil(Math.min(m, n) / 2.0);
	        int start, endx, endy;
	        for(int j = 0; j < iter; j++){
	            start = j;
	            // et normally we do four action for an iteration ..
	            endx = mat[0].length - 1 - start;
	            
	            endy = mat.length - 1 - start;
	            
	            // ->
	            
	            for(int i = start; i <= endx; i++){
	                res[index++] = mat[start][i];
	            }
	            //  |
	            // \  /
	            //  \/
	           
	            if(start < endy){
	                for(int i = start + 1; i <= endy; i++)
	                	res[index++] = mat[i][endx];
	            }
	           
	            //  <-
	            if(endx > start && start < endy){
	                for(int i = endx - 1; i >= start; i--)
	                	res[index++] = mat[endy][i];
	            }
	            // ^
	            // |
	            if(endx > start && start < endy - 1){
	                for(int i = endy-1; i > start; i--)
	                	res[index++] = mat[i][start];
	            }
	            
	        }
	        return res;
	    }
	///
	///  generate an n*n matrix in spiral order  
	///
	    public int[][] generateMatrix(int n) {
	        int[][] res = new int[n][n];
	        int m = 1;
	        int i,j;
	        for(i = 0; i < n/2; i ++)
	            {
	                // from left to right, modify j 
	                for(j = i; j < n - i; j ++)
	                    res[i][j] = m++;
	                
	                // from top to down, modify i by j 
	                for(j = i+1; j < n - 1 - i; j ++)
	                    res[j][n - 1 - i] = m++;
	                
	                // from right to left, modify j by --
	                for(j = n - 1 - i; j > i; j --)
	                    res[n - 1 - i][j] = m++;
	            
	                // from down to top, modify i by j --
	                for(j = n - 1 - i; j > i; j --)
	                    res[j][i] = m++;
	            }
	            //the last element
	            if(n%2 == 1)
	                res[n/2][n/2] = m;
	            
	            return res;
	    }
}
