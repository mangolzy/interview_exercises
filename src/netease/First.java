package netease;

import java.text.DecimalFormat;
import java.util.Scanner;



public class First{
	  public static void main(String[] args)
	  {
	    Scanner in = new Scanner(System.in);
	    while(in.hasNext()){
	      int n = in.nextInt();
	      String line = in.nextLine();
	      line = in.nextLine();
	      //System.out.println(line);
	      String[] nbs = line.split(" ");
	      int length = nbs.length;
	      int[][] matrix = new int[n][length];
	      for(int j = 0; j < length; j ++)
	      {
	        System.out.println(nbs[j]);
	        //matrix[0][j] = Integer.parseInt(nbs[j]);
	      }
	      for(int i = 1; i < n; i ++){
	      	 for(int k = 0; k < length; k++)
	           matrix[i][k] = in.nextInt();
	      }
	      int[] var = new int[length];
	      for(int m = 1; m < length; m++){
	        for(int l = 0; l < n; l++){
	          if(matrix[l][m] == 1)
	            var[m] ++;
	        }
	      }
	    }
	  }
	
}
