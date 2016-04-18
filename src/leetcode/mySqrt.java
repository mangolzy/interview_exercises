package leetcode;

public class mySqrt {
	public static int mySqrt(int x) {
        int a = 0;
        int b = x;
        int iter = 100;
        double threshold = 0.0001;
        int i = 0;
        int half = 0;
        double y = 0;
        while(i < iter){
           half = (a + b)/2;
           y = Math.pow(half,2);
           if(Math.abs( y - x) < half)
                return half;
           if(y < x)
                a = half;
           else
                b = half;
        }
        return -1;
    }
	public static void main(String[] args){
		System.out.println(mySqrt(10));
		
	}
}
