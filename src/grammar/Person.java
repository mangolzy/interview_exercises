package grammar;
import java.sql.*;
class Per {
    String name = "No name";
    public Per(String nm) {
        name = nm;
    }
     
}
class Employee extends Per {
    public Employee(String nm) {
        super(nm);  //  不指明时，子类默认会调用父类的无参构造函数；如果父类没有定义无参的，会报错
        			//  此时，必须使用super调用其某个定义过的构造函数
        // TODO Auto-generated constructor stub
    }
    public Employee(String nm, String id){
    	super(nm);
    	empID = id;
    }
    String empID = "0000";
    
}

abstract class mathUtil{
	 abstract   double hyperbolicCosine();
	// abstract method can only use public or protected modifier
	 // no private/final/.. 编译错误
	
}
public class Person {
    public static void main(String args[]) {
        Employee e = new Employee("123","0001");
        System.out.println(e.empID);
    }
}