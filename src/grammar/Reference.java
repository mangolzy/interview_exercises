package grammar;

public class Reference {
	
	String s = "abc"; // invariant 基本不会被改变的
	char[] x = {'x','y','z'};
	public void exch(String s, char[] ch){
		//s = new String("change");
		s = "test ok";
		ch[0] = 'q';
	}
	
	public void setS(String s){
		this.s = s;
	}
	
	public static void main(String[] args){
		Reference ref = new Reference();
		ref.exch(ref.s, ref.x);
		ref.setS("setter ok");
		System.out.print(ref.s + " and ");
		System.out.print(ref.x);
	}
	
	
	    
}
