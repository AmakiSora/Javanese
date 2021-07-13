package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁ReadWriteLock
 * 写锁为独占锁
 * 读锁为共享锁
 * 读锁不能升级为写锁
 * 写锁能降级为读锁
 */
public class ReadWriteLock {
    class Database{
        private final Map<String,String> map = new HashMap<>();
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        public void write(String key,String value){//写操作
            rwLock.writeLock().lock();//写锁上锁
            try {
                System.out.println(Thread.currentThread().getName()+"号线程，正在写入,key为"+key);
                TimeUnit.SECONDS.sleep(1);
                map.put(key,value);
                System.out.println(Thread.currentThread().getName()+"号线程写完了,key为"+key);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwLock.writeLock().unlock();//写锁解锁
            }
        }
        public String read(String key){//读操作
            rwLock.readLock().lock();//读锁上锁
            String value = null;
            try {
                System.out.println(Thread.currentThread().getName()+"号线程，正在读取,key为"+key);
                TimeUnit.SECONDS.sleep(1);
                value = map.get(key);
                System.out.println(Thread.currentThread().getName()+"号线程读完了,value为"+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwLock.readLock().unlock();//读锁解锁
            }
            return value;
        }

    }
    public void test(){
        Database database = new Database();
        for (int i = 0; i < 10; i++) {
            String I = String.valueOf(i);
            new Thread(()->{
                database.write(I,I);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 10; i++) {
            String I = String.valueOf(i);
            new Thread(()->{
                database.read(I);
            },String.valueOf(i)).start();
        }
    }
}
