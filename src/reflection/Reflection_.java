package reflection;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * Class也是类,因此也继承Object类
 * Class类对象不是new出来的,而是系统创建的
 * 对于某个类的Class类对象,在内存中只有一份,因此类只加载一次
 * 每个类的实例都会记得自己是由哪个Class类生成的(.getClass)
 * Class对象是存放在堆里的,而类的字节码二进制数据是放在方法区的
 * java.lang.Class:代表一个类,Class对象表示某个类加载后在堆中的对象
 * java.lang.reflect.Method:代表类的方法,Method对象表示某个类的方法
 * java.lang.reflect.Field:代表类的成员变量,Field对象表示某个类的成员变量
 * java.lang.reflect.Constructor:代表类的构造方法,Constructor表示构造器
 */
public class Reflection_ {
    public void test() throws Exception {
        String ClassPath = "reflection.Person";//一般在配置文件里读取全路径
        //知道类路径,通过反射得到加载的Class类
        Class<?> cls = Class.forName(ClassPath);//<?>表示不确定的java类型(可以不写)
        System.out.println(cls);//这个cls对象,是Person的Class类,并不是Person类,不能强转成Person类
        System.out.println(cls.getClass());//cls的本质是一个Class类
        System.out.println(cls.getPackage().getName());//获取包名
        System.out.println(cls.getName());//获取全路径类名
        //通过得到的加载类来创建o对象(调用无参构造)
        Object o = cls.getDeclaredConstructor().newInstance();//获得的是Person类对象
        Person person = (Person) o;//可以强转
        System.out.println(person.getClass());
        //获取方法
        Method sayHi = cls.getMethod("sayHi");
        //取消反射安全检查,可以提高效率
        sayHi.setAccessible(true);
        //调用方法
        sayHi.invoke(person);
        //获取构造器
        Constructor<?> constructor = cls.getConstructor(int.class, String.class);//括号中可以指定构造器参数类型
        System.out.println(constructor);
        //获取类里的成员变量(不能获得私有的变量)
        Field name = cls.getField("name");
        System.out.println(name.get(person));
        //通过反射给成员变量赋值
        name.set(person,"cosmos");
        System.out.println(name.get(person));
        //获取所有的成员变量
        Field[] fields = cls.getFields();//私有变量拿不到
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
    private void getClass_() throws Exception {//反射获取Class类的四种方式
        //1.Class.forName
        String classPath = "reflection.Person";//一般在配置文件里读取全路径
        Class<?> cls1 = Class.forName(classPath);
        System.out.println(cls1);

        //2.类名.class 多用于参数传递
        Class<?> cls2 = Person.class;
        System.out.println(cls2);

        //3.对象.getClass() 有实例对象的情况使用
        Person person = new Person();
        Class<?> cls3 = person.getClass();
        System.out.println(cls3);

        //4.通过类加载器来获取类的Class类
        ClassLoader classLoader = person.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classPath);
        System.out.println(cls4);
    }
    private void typesOfClass(){//不同类型的Class对象
        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Character> cls3 = char.class;//基本数据类型
        Class<int[]> cls4 = int[].class;//数组
        Class<Deprecated> cls5 = Deprecated.class;//注解
        Class<Thread.State> cls6 = Thread.State.class;//枚举
        Class<Void> cls7 = Void.class;//void
        Class<Class> cls8 = Class.class;//Class(自身也有)

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
    }
}
