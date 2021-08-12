package reflection;

/**
 * 用于反射测试的类
 */
public class Person {
    private final int id;
    public String name;
    public Person(){
        this.id = 0;
        this.name = "?";
    }
    public Person(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void getName(){
        System.out.println(name);
    }
    public void sayHi(){
        System.out.println("hi!");
    }
}
