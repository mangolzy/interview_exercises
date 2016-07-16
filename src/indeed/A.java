package indeed;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		
		
		Scanner in  = new Scanner(System.in);
		int s = 0;
		//String str = new StringBuilder();
	
		while(in.hasNext()){
			//for(int i = 0; i < s; i++){
				String str = in.next();
				//str.replace(',', '/n');
				String[] sx = str.split(",");
				for(int j = 0; j < sx.length; j++)
					System.out.println(sx[j]);
			//}
		}
		in.close();
	}
}
