import java.util.ArrayList;
import java.util.List;



//  给定字典，和一个字符串，问如何加空格可以使得每个字串都是合法单词
//  DICT = {cat,and,an,done,one,cats,sand}
//  s = "catsandone";
//   cat sand one || cats and one || cats an done
public class Sohu {
	public ArrayList<Integer> returnFirst(String[] dict, String s){
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(String x: dict){
			if(x.charAt(0) ==  s.charAt(0))
			{
				int l = x.length();
				if(s.substring(0, l).equals(x));
					//r.add(x);
			}
			else
				continue;
		}
		return r;
	}
	
	public ArrayList<String> mySplits(String[] dict, String q){
		ArrayList<String> res = new ArrayList<String>();
		//ArrayList<String> res= returnFirst(dict,q);
		
		
		int size = res.size();
		int k = 0;
		while(k < size){
		//	String a = res.remove(0);
			
			
		}
		
		
		
		
		return res;
	}

}
