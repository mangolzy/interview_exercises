package google2017apac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class C_small {
	
	
	public static double calculateIRR(BigInteger a, BigInteger b, BigInteger c){
		BigInteger four = new BigInteger("4");
		BigInteger x = b.multiply(b).subtract(a.negate().multiply(c).multiply(four));
		double delta = Math.sqrt(x.doubleValue());
		double x1 = (-b.intValue()+ delta) / (-2*a.intValue());
		double x2 = (-b.intValue() - delta) / (-2*a.intValue());
		if(Math.abs(x1 - 1.000000000000) < 0.000000001)
			x1 = 0.0000000001;
		if(Math.abs(x2 - 1.000000000000) < 0.000000001)
			x2 =  0.0000000001;
		if(x1 - 1> -1 && x1 -1 < 1)
			return x1;
		else
			return x2;
	}
	
	public static double calculateIRR(int a, int b){
		double x = (-a-b)/(a*1.0);
		if(x - 0.000000000000 < 0.000000001)
			x  = 0.0000000001;	
		return x;
	}
public static void main(String[] args){
		
		
		try{
			String path = "/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/C-small.in";
			String output = "/Users/ryoushiken/Documents/workspace/interview_exercises/src/google2017apac/result.out";
			BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(output));
			String firstLine = br.readLine();
			int n = Integer.parseInt(firstLine);
			//System.out.println(calculateIRR(-200,100,100));
			for(int i = 0; i < n; i ++){
				String q = br.readLine();
				int nb = Integer.parseInt(q);
				if(nb == 1){
					String bs = br.readLine();
					String[] bss = bs.split(" ");
					int a = - Integer.parseInt(bss[0]);
					int b = Integer.parseInt(bss[1]);
					double x = calculateIRR(a, b);
					bw.write("Case #"+(i+1)+": " + x);
				}
				else{
					String as = br.readLine();
					String[] ass = as.split(" ");
					int a = - Integer.parseInt(ass[0]);
					int b = Integer.parseInt(ass[1]);
					int c = Integer.parseInt(ass[2]);
					//System.out.println(new BigInteger(Integer.toString(a)));
					double x = calculateIRR(new BigInteger(ass[0]), new BigInteger(ass[1]), new BigInteger(ass[2]));
					//System.out.println("Case #" + i + ": " + Double.parseDouble(String.format("%.9f", rs)));
					bw.write("Case #"+(i+1)+": " + Double.parseDouble(String.format("%.9f", x)));
				}

				bw.flush();
				bw.newLine();
			}
			bw.close();
			br.close();

		}catch(Exception e){
					e.printStackTrace();
		}
	}
}
