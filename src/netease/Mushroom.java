package netease;

import java.util.Scanner;


public class Mushroom{
    
	public static void mushroom(int[][] matrix, int m, int n, int[] result){
        /*int res = 0;
        if(m <= 3 && n <= 3){
            for(int i = 0; i < m; i ++)
            	for(int j = 0; j < n; j ++)
            		res += matrix[i][j];
            System.out.println(res);
        }
        else{
        */
            int iter_x = m - 2;
            int iter_y = n - 2;
            //int temp[][] = new int[iter_x][iter_y];
            //System.out.println(n+" " +m);
            for(int k = 0; k < iter_x; k++){

                for(int l = 0; l < iter_y; l++){
                	
                	
                            //统计3*3格子中的蘑菇数，如果一个格子中有多个只算一个
                            int tmp = 0; //tmp:每个3*3区域中的蘑菇数
                            for(int p=k;p<k+3;++p){
                                for(int q=l;q<l+3;++q){
                                    if(matrix[p][q] > 0){
                                        ++tmp;
                                    }
                                }
                            }
                            if(result[0]<tmp){
                                result[0] = tmp;
                                result[1] = k;
                                result[2] = l;
                            }
                }
            }
       // }
            /*
                	temp[k][l] = matrix[k][l] + matrix[k][l+1] + matrix[k][l+2] 
                        + matrix[k+1][l] + matrix[k+1][l+1] + matrix[k+1][l+2] 
                        + matrix[k+2][l] + matrix[k+2][l+1] + matrix[k+2][l+2];  */
                	//System.out.print(temp[k][l]+" ");
       
        
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
            int m = in.nextInt();
            if(n < 3)
            	n = 3;
            if(m < 3)
            	m = 3;
            int k = in.nextInt();
       		int grass[][] = new int[n][m];
       		int x = 0;
            int y = 0; 
        	for(int i = 0; i < k; i++)
        	{
        		x = in.nextInt();
                y = in.nextInt();
                grass[x-1][y-1] ++;
            }	
        	int[] first = new int[3];
        	int[] second = new int[3];
        	mushroom(grass,n,m,first);
        	for(int i = 0; i < x; i++)
        		for(int j = 0; j < y; j++)
        			if(i == first[1] && j == first[2])
        				grass[i][j]--;
        	mushroom(grass,n,m,second);
        	
        	System.out.println(first[0]+second[0]);
        }
        in.close();
    }
}

/*
import java.util.Scanner;


public class Main{
    
	public static void mushroom(int[][] matrix, int m, int n, int[] result){
        
            int iter_x = m - 2;
            int iter_y = n - 2;
            
            for(int k = 0; k < iter_x; k++){

                for(int l = 0; l < iter_y; l++){
                	
                	
                            //统计3*3格子中的蘑菇数，如果一个格子中有多个只算一个
                            int tmp = 0; //tmp:每个3*3区域中的蘑菇数
                            for(int p=k;p<k+3;++p){
                                for(int q=l;q<l+3;++q){
                                    if(matrix[p][q] > 0){
                                        ++tmp;
                                    }
                                }
                            }
                            if(result[0]<tmp){
                                result[0] = tmp;
                                result[1] = k;
                                result[2] = l;
                            }
                }
            }
     
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = in.nextInt();
            int m = in.nextInt();
            if(n < 3)
            	n = 3;
            if(m < 3)
            	m = 3;
            int k = in.nextInt();
       		int grass[][] = new int[n][m];
       		int x = 0;
            int y = 0; 
        	for(int i = 0; i < k; i++)
        	{
        		x = in.nextInt();
                y = in.nextInt();
                grass[x-1][y-1] ++;
            }	
        	int[] first = new int[3];
        	int[] second = new int[3];
        	mushroom(grass,n,m,first);
        	for(int i=first[1];i<first[1]+3;++i){
            	for(int j=first[2];j<first[2]+3;++j){
               	 	if(grass[i][j]>0)
                   	 	--grass[i][j];
                }
        	}
        	mushroom(grass,n,m,second);
        	
        	System.out.println(first[0]+second[0]);
        }
        in.close();
    }
}



*/
