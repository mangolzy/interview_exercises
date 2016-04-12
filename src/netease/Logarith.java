package netease;

public class Logarith {
	
	// bisection 
    public static double mylog(double a, double b){
    	
    	
    	
    	long iter = 100000000;
    	double threshold = 0.0000001;
    	
    	double err = Integer.MAX_VALUE;
    	int i = 0;
    	double start = -5000;
    	double end = 5000;
    	double x = 0;
    	while(err > threshold && i < iter){
    		x = (end - start) / 2;
    		err = Math.pow(a, x) - b;
    		i++;
    		if(err > 0)
    			start += 1;
    		else
    			end -= 1;
    	}
    	System.out.println(i);
    	return x;
    }
    
    //
    public static void main(String[] args){
    	System.out.print(mylog(10,500));
    }
	
}
