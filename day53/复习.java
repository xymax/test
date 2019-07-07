juc:Lock 1.5

tryLock() : 非阻塞式获取锁
lockInterruptily() : 响应中断
tryLock(long time,TimeUnit) : 支持超时


synchronized与ReentrantLock区别:
1.

synchronized与Lock的区别:
1.synchronized是JVM层面,关键字;Lock是Java语言层面实现的"管程".
2.Lock具备了一些synchronized不具备的特性,如...，支持公平锁,支持多个等待队列,
还支持读写锁

读写锁:读者写者问题(美团)
读线程:读读异步，读写同步
写线程:写写同步

读写锁实现:ReentrantReadWriteLock(实现缓存HashMap + ReentrantReadWriteLock)
读锁:ReadLock，多个线程在同一时刻可以共同取得该读锁
写锁:WriteLock,独占锁，多个线程在同一时刻只有一个线程可以取得该锁

共享锁:多个线程可以同时取得该锁 读锁 ReadLock 共享锁 == 无锁?
当写线程开始工作，所有其他线程(包含读线程)全部进入阻塞态.

JDK1.8 StampedLock 更加乐观的锁实现，性能比ReentrantReadWriteLock还高.

juc包下工具类:CAS+Lock

1.闭锁CountDownLatch

public CountDownLatch(int count) : count表示需要等待的线程个数

public void countDown() : 计数器值-1(类似运动员线程)

public void await() throws InterruptedException : 等待线程调用该方法进入阻塞态，直到计数器减为0.

CountDownLatch对象在计数器值减为0时不可恢复。
只会阻塞调用await方法的线程

2.循环栅栏CyclicBarrier

public CyclicBarrier(int parties) : parties表示需要有多少个线程同时暂停以及恢复执行

public int await() : cyclicBarrier 计数器-1，当减为0时，所有阻塞线程同时恢复执行

 
public CyclicBarrier(int parties, Runnable barrierAction)
多个线程在恢复执行之前，任意挑选一个线程执行barrierAction任务后，再同时恢复执行。

CyclicBarrier计时器值可以恢复reset()，CyclicBarrier的对象可以重复使用。

3.Exchanger交换器
Exchanger用于两个线程交换数据，当缓冲区只有一个线程时，该线程会阻塞直到配对成功再交换数据恢复执行。

4.Semaphore信号量
8工人  5台设备
public Semaphore(int permits) : 表示许可的数量
public Semaphore(int permits, boolean fair) : 等待时间最长的线程最先获取到许可
public void acquire() : 申请许可，尝试获取许可
public void release() : 释放许可。

线程池
ExecutorService:普通调度池
	void execute(Runnable r)
	Future submit(Callable || Runnable)

ScheduledExecutorService:定时调度池
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit);
ThreadPoolExecutor:线程池核心类
public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler);

常见阻塞队列:
	LinkedBlockingQueue:基于链表的无界阻塞队列
		-内置的固定大小线程池就采用此队列
	SynchronousQueue:不存储元素的无界阻塞队列
		-内置的缓冲线程池就采用此队列

Executors:线程池的工具类
-单线程池
	newSingleThreadExecutor()
-固定大小线程池(系统资源紧张，适用于负载较重的服务器)
	newFixedThreadPool(int nThreads)
-缓存池(服务器负载较轻，适用于处理很多短期异步小任务
当提交任务速度>>任务处理速度,不断产生新线程;任务处理速度>提交任务速度,只有一个线程)
	newCachedThreadPool()
-定时调度池(需要执行定时任务场合)
	newScheduledThreadPool(int corePoolSize)
核心池

最大线程池

阻塞队列

拒绝策略

线程池:为何推荐使用线程池来新建线程
1.线程池的工作流程
2.如何自定义线程池
	-核心线程池类ThreadPoolExecutor参数配置
	-线程池工作线程Worker,如何实现
3.在何种场景下选用何种线程池

JMM:Java内存模型(关于并发程序的内存模型-逻辑模型)
1.JMM的工作流程
工作内存:每个线程创建时分配的空间，线程私有.所有变量的读写均在工作内存中进行。

主内存:所有线程共享的内存区域,存放所有共享变量(类的实例变量、静态变量、常量)。

2.JMM三大特性
只有以下三个特性同时满足，才是线程安全的代码。

原子性:基本数据类型的访问读写都属于原子性操作.
若需要更大范围的原子性，需要使用synchronized或lock来保证

可见性:任意一个线程修改了共享变量的值，其他线程能够立即得知此修改
synchronized、volatile、final实现可见性

有序性:逻辑上写在前面的代码优先发生于写在后面的代码。

3.volatile变量的特殊规则

3.1 可见性
volatile boolean shutdownRequested;
// 线程1
public void shutdown() {
    shutdownRequested = true;
}
// 线程2
public void work() {
    while(!shutdownRequested) {

    } 
}

3.2 禁止指令重排

