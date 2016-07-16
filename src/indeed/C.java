package indeed;

import java.util.Scanner;

public class C {
	
	 public static int solveNTable(char[][] table) {
	        int[] res = new int[1];
	   
	        
	        int[] col = new int[6];  // record counting
	        int[] row = new int[6];  // record counting
	        
	        int cur = 0;
	        // initializing from table 
	        for(int i = 0; i < 6; i++){
	        	for(int j = 0; j < 6; j++){
	        		if(table[i][j] == 'o'){
	        			row[i] ++;
	        			col[j] ++;
	        		}
	        	}
	        }
	        for(int i = 0; i < 6; i++){
	        	if(row[i] > 3)
	        		return 0;
	        	if(col[i] > 3)
	        		return 0;
	        }
	   
	        // the current row has cur...balls
	        
	        backtracking(res, 0, row, col, 6, table);
	        
	        return res[0];
	    }
	    
	    
	    public static void backtracking(int[] l,  int i, int[] row, int[] col, int n, char[][] table){
	    
	        if(i == n-1){
	            l[0] ++;
	            return;
	            
	        }
	         
	        else{
	        	/*for(int q = 0; q < n; q++){
	        		if(row[q] < 3 && col[k] < 3 && table[q][k] != 'o'){
	 	               
	        			row[q] ++;
	        			col[k] ++;
	                
	        			backtracking(l, i, k+1, row, col, n, table);
	                    row[q] --;
	                    col[k] --;// why this operation?
	        		}*/
	        	int rest = 3-row[i];
    			//for(int m = 1; m <= rest; m++){
    				/// 
    				if(rest == 1){
    					for(int j = 0; j < n; j ++){
	        			
	        				
    						if(row[i] < 3 && col[j] < 3 && table[i][j] != 'o'){
    							row[i] ++;
	        				
    							col[j] ++;
	        				
	                
	        				backtracking(l, i+1, row, col, n, table);
	        				row[i] --;
	        				col[j] --;// why this operation?
    						}
    					}
    				}
    					if(rest == 2){
    						for(int j = 0; j < n; j ++){
    		        			for(int x = 1; x < n-j; x++){
    	        				
        						if(row[i] < 3 && col[j] < 3 && col[j+x] < 3 && table[i][j] != 'o'){
        							row[i] += 2;
    	        				
        							col[j] ++;
        							
        							col[j+x] ++;
    	        				
    	                
    	        				backtracking(l, i+1, row, col, n, table);
    	        				row[i] -= 2;
    	        				col[j] --;// why this operation?
    	        				col[j+x] --;
        						}
    	        			}
    						
    						}
    					}
    					if(rest == 3){
    						
    						
    						for(int j = 0; j < n; j ++){
    		        			for(int x = 1; x < n-j; x++){
    		        				for(int y = 1; y < n-x-j;y++){
    		        					if(row[i] < 3 && col[j] < 3 && col[j+x+y] < 3 && table[i][j] != 'o'){
    		        						row[i] += 3;
    	        				
    		        						col[j] ++;
        							
    		        						col[j+x] ++;
    		        						col[j+x+y] ++;
    	        				
    	                
    		        						backtracking(l, i+1,  row, col, n, table);
    		        						row[i] -= 3;
    		        						col[j] --;// why this operation?
    		        						col[j+x] --;
    		        						col[j+x+y] --;
    	        				
    		        					}
    		        				}
    	        			}
    					}
    					
	        		}
	        		//}
	        	
	        }
	        
	    }
	    
	    public static void main(String[] args){
	    	
	    	

			Scanner in  = new Scanner(System.in);
			char[][] table = new char[6][6];
	    	while(in.hasNext()){
	    		for(int i = 0; i < 6; i ++){
	                String s = in.next();
	                for(int j = 0; j < 6; ++ j){
	                	//if(s.charAt(j) == '.')
	                		table[i][j] = s.charAt(j);
	                	//else
	                		///table[i][j] = ;
	                }
	            }
	    		
	    		System.out.println(solveNTable(table));
	    	}
	    	
	    	
	    }

}
