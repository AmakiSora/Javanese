package java_.io;

import java.io.*;

/**
 * ObjectInputStream和ObjectOutputStream的使用
 * 对象的反序列化与序列化流
 * 对象序列化流在输出的时候，输出的类如果没有继承Serializable，会抛出NotSerializableException异常。
 * 类通过实现Serializable接口以启用其序列化功能。
 *
 * 如果是内部类，则不仅要继承Serializable，还要将内部类设置为static，
 * 因为内部类对象持有外部类对象的引用，
 * 所以内部类对象序列化的时会对外部类对象以及其含有的成员行执序列化操作，
 * 从而导致错误(外部类没有实现Serializable，或其中有不能序列化的成员)。
 *
 * 另外，但JVM反序列化对象时，能找到class文件，但是class文件在序列化之后发生了修改，
 * 那么反序列化操作也会失败，抛出一个InvalidClassException异常。
 * 原理：
 *      在序列化运行时会使用一个serialVersionUID的版本号与每个可序列化的类相关联，
 *      该版本号在反序列化过程中用于验证是否与序列化的类兼容，如果版本号不同就会抛出InvalidClassException异常
 * 解决方法：
 *      在可序列化类里通过serialVersionUID字段(该字段必须为static和final的long型字段)显式的声明为该类的版本号
 */
public class ObjectIOStream {
    static class Person implements Serializable {//要继承Serializable
        String name;
        int age;
//        transient int age;//如果有transient关键字，则表示该属性不能被序列化
//        private static final long serialVersionUID = 1L;//定死序列化版本号，防止后续改动class文件后反序列化失败

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "name = "+ name + ",age = " + age;
        }
    }

    private void objectOutputStream(String path) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            Person person = new Person("张三", 18);
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void objectInputStream(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            Object obj = ois.readObject();//会抛出class文件找不到的异常
            System.out.println(obj.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        String path = "D:\\cosmos\\test\\obj";
        objectOutputStream(path);
        objectInputStream(path);
    }
}
