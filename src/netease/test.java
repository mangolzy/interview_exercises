package netease;


public class test extends HelloA 
{
 public test()
 {
 }
 {
     System.out.println("I’m B class");
 }
 static
 {
     System.out.println("static B");
 }
 public static void main(String[] args)
 {
     new test();
 }
}
class HelloA
{
 public HelloA()
 {
 }
 {
     System.out.println("I’m A class");
 }
 static
 {
     System.out.println("static A");
 }
}
