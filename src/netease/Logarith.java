package netease;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Logarith {
	static Random rand = new Random();
	//double x = rand.nextDouble();
	// bisection 
    public double mylog(double a, double b){
    	
    	
    	
    	long iter = 100000000;
    	double threshold = 0.0000001;
    	
    	//double err = Integer.MAX_VALUE;
    	int i = 0;
    	double start = -5000;
    	double end = 5000;
    	
    	double p;
    	double fa;
    	double fp;
    	fa = Math.pow(a, start) - b;
    	while(i < iter){
    		p = start + (end - start) / 2;
    		fp = Math.pow(a, p) - b;
    		if(fp == 0 || (end - start) / 2 < threshold)
    		{
    			System.out.println(i);
    			return p;
    		}
    		i++;
    		if(fa * fp > 0)
    		{
    			start = p;
    			fa = fp;
    		}
    		else
    			end = p;
    	}
    	
    	return -1;
    }
    
    // fixed-point solution: not suitable for this problem, it requires the domain of definition and range must be the same
    public static  double fplog(double a, double b){
    	double pn_;
    	double pn;
    	int i = 1;
    	int iteration = 10000000;
    	double threshold = 0.0000001;
    	pn_ = 5;
    	while(i < iteration){
    		pn = pn_ - Math.pow(a,pn_) + b;
    		if(Math.abs(pn - pn_) < threshold){
    			System.out.println(i);
    			return pn;
    		}
    		i++;
    		pn_ = pn;
    	}
    	return -1;
    }
    public static void main(String[] args){
    	System.out.print(Integer.toString(81, 3));
    	
    	//HashMap<String,Integer> hm = new HashMap<>();
    	
    	//TreeMap<Integer,String[]> tm = new TreeMap<>();
    }
	
}
