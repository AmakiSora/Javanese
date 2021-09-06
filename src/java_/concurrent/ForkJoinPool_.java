package java_.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支/合并框架
 * 分支框架的目的是以递归的方式将可以并行的任务拆分成更小的任务,然后将每个子任务的结果合并起来生成整体结果.
 */
public class ForkJoinPool_ {
    class Task extends RecursiveTask<Long>{
        private final long VALUE = 10_000_000L;
        private final long begin;//拆分起始值
        private final long end;//拆分结束值
        private long result;//返回结果
        public Task(long begin,long end){
            this.begin = begin;
            this.end = end;
        }
        @Override
        protected Long compute() {
            //判断两个数值是否大于10
            if((end-begin)<=VALUE){
                for (long i = begin; i <= end; i++) {
                    result = result + i;
                }
            }else {
                long middle = (begin+end)/2;
                Task task1 = new Task(begin,middle);
                Task task2 = new Task(middle+1,end);
                task1.fork();//分支
                task2.fork();
                result = task1.join() + task2.join();//合并
            }
            return result;
        }
    }
    public void test() throws ExecutionException, InterruptedException {
        long t1 = System.currentTimeMillis();
        Task task = new Task(0,2_000_000_000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(task);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1)+"ms");
        //简单的for循环计算
        t1 = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i <= 2_000_000_000L; i++) {
            a+=i;
        }
        System.out.println(a);
        t2 = System.currentTimeMillis();
        System.out.println((t2 - t1)+"ms");

    }
}
