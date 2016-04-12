package leetcode;

public class ZigzagConversion {
	
	public static void main(String[] args){
		
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	public static String convert(String s, int numRows){
	
		String res = "";
		if(numRows==1)
		    res = s;
		else if(numRows>=s.length())
		    res = s;
		else if(numRows==2)
		{
			//System.out.println("2");
		    for(int i = 0; i < s.length(); i++)
		        if(i%2 == 0)
		            res += s.charAt(i);
		    for(int i = 0; i < s.length(); i++)
		        if(i%2 == 1)
		            res += s.charAt(i);    
		}
		else{
		   for(int i = 0; i < numRows; i++){
		       if(i == 0)
		       {
		           int p = 0;
		           while(p < s.length())
		           {
		               res += s.charAt(p);
		               p += (numRows + numRows - 2);
		           }
		       }
		       else if (i != 0 && i != numRows-1)
		       {
		           int q = i;
		           int count = 2*numRows - 2;
		           //res += s.charAt(q);
		           
		           while(q < s.length())
		           {
		        	   res += s.charAt(q);
		        	   q += count;
		        	   if(q-2*i < s.length())
		        		   res += s.charAt(q-2*i);
		        	   
		        	   
		        	 /*  if(count % 2 == 0)
		               {
		        		   res += s.charAt(q-1);
		        		   q += (numRows - 1);
		               }
		        	   else
		        	   {
		        		   res += s.charAt(q)
		        	   }
		               count ++;*/
		           }
		       }
		       else
		       {
		           int n = numRows-1;
		           while(n < s.length())
		           {
		               res += s.charAt(n);
		               n += (numRows + numRows - 2);
		           }
		       }
		   }
		}
		return res;
		/*
		if(numRows==1)
		    res = s;
		else if(numRows>s.length())
		    res = s;
		else{
		   for(int i = 1; i < s.length(); i++){
			    if(i % (numRows + 1) == 1)
				    res = res+s.charAt(i-1);
		    }
		
		    for(int i = 1; i < s.length(); i++){
		    	if(i % (numRows + 1) == 0 || i % (numRows + 1) == numRows-1)
			    	res = res+s.charAt(i-1);
	    	}
		
	    	for(int i = 1; i < s.length(); i++){
			    if(i % (numRows + 1) == numRows)
				    res = res+s.charAt(i-1);
	    	}
		}
		*/
	}

}
