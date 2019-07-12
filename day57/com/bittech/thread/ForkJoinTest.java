package com.bittech.thread;

import java.util.concurrent.*;

/**
 * @Author: yuisama
 * @Date: 2019-07-04 17:09
 * @Description:
 */
class Count extends RecursiveTask<Long> {
    private long start;
    private long end;
    private static final int THRESHOLD = 10000;

    public Count(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        boolean canWork = (end - start) <= THRESHOLD;
        long sum = 0;
        if (canWork) {
            for (long i = start;i <= end;i++) {
                sum += i;
            }
        }else {
            long middle = (end + start) / 2;
            Count childTask1 = new Count(start,middle);
            Count childTask2 = new Count(middle + 1,end);
            // 执行子任务
            invokeAll(childTask1,childTask2);
            long lResult = childTask1.join();
            long rResult = childTask2.join();
            sum = lResult + rResult;
        }
        return sum;
    }
}
public class ForkJoinTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Count count = new Count(1,100000000);
        Future<Long> result = forkJoinPool.submit(count);
        // 如果任务完成
        if (!((ForkJoinTask<Long>) result).isCompletedAbnormally()) {
            try {
                System.out.println("fork/join计算结果为:"+result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("fork/join共耗时:"+(System.currentTimeMillis()-start)+"ms");
        start = System.currentTimeMillis();
        long sum = 0;
        for(int i = 1; i <= 100000000 ; i++) {
            sum += i;
        }
        System.out.println("计算结果：" + sum);
        System.out.println("普通计算花费时间：" + (System.currentTimeMillis() - start) + "ms");

    }
}
