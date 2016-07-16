package indeed;

import java.util.Scanner;

public class One {
	
	
	
	public static void main(String[] args) {
		
		
		Scanner in  = new Scanner(System.in);
		while(in.hasNext()){
			
			String s = in.next();
			String t = in.next();
			if(s.length() != t.length())
				System.out.println("Impossible");
			else{
				int[] diffa = new int[26];
				int[] diffb = new int[26];
				for(int i = 0; i < s.length(); i++){
					if(s.charAt(i) == t.charAt(i))
						continue;
					else{
						diffa[s.charAt(i) - 'a'] += 1;
						diffb[t.charAt(i) - 'a'] += 1;
					}
				}
				int a1 = 0, a2 = 0;
				
				int b1 = 0, b2 = 0;
				int suma1 = 0, suma2 = 0;
				int sumb1 = 0, sumb2 = 0;
				for(int j = 0; j < 26; j ++){
					if(diffa[j] != 0 && diffb[j] != 0)
					{	
						suma1 += (diffa[j] == 0? 0: diffa[j]);
						sumb1 += (diffb[j] == 0? 0: diffb[j]);
						break;
					}
					
					
				}
				for(int j = 25; j >= 0; j --){
					if(diffa[j] != 0 && diffb[j] != 0)
					{	
						suma2 += (diffa[j] == 0? 0: diffa[j]);
						sumb2 += (diffb[j] == 0? 0: diffb[j]);
						break;
					}
					
					
				}
				for(int j = 0; j < 26; j ++){
					if(diffa[j] != 0 || diffb[j] != 0)
					{	
						a2 += 1;
					}
					
					
				}
				if(a2 <= 2 && suma1 == sumb2 && suma2 == sumb1)
					System.out.println("Possible");
				else
					System.out.println("Impossible");
			}
			
		}
		in.close();
	}
}
