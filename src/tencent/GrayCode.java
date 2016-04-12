package tencent;
import java.util.*;

public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        
        if(n == 0)
            return null;
        if(n == 1){
        	String[] res = new String[2];
        	res[0] = "0";
        	res[1] = "1";
        	return res;
        }
        else{
        	String[] x = getGray(n-1);
        	int length = x.length;
        	String[] res = new String[length*2];
        	for(int i = 0; i < length; i++)
            {
                
                res[i] = "0".concat(x[i]);
                res[i+length] = "1"+x[length-1-i];
            }
            return res;
        }
    }
}