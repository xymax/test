# SE多线程

1. ## 进程与线程

* 进程是OS中资源分配的最小单元
* 进程是OS中任务分配的最小单元
* 创建于销毁一个线程的开销要比一个进程小的多，线程间通信也比进程间容易的多
* 线程间通信：join（）。wait/notify。yield。sleep

2. ## 多线程常用操作方法

* sleep：运行--->阻塞，当前线程立即交出CPU，进入阻塞态，不会释放对象锁
* yield：运行--->就绪，当系统调度交出CPU，进入就绪状态，不会释放对线锁，只会让相同优先级的线程获取CPU。
* join：运行--->阻塞，进入阻塞态，会释放对象锁。（join内部就是wait方法）
* wait：运行--->阻塞，会释放对象锁，必须与synchronized搭配使用
* notify：阻塞--->就绪，必须在同步方法或同步代码块中使用
*  创建          就绪        运行        终止





​    阻塞

* 守护线程与用户线程
* 默认创建的都是用户线程----主线程
* 守护线程：在后台执行，只要java中存在任意一个用户线程没有终止，守护线程就一直运行
* 当JVM中最后一个用户线程终止，守护线程会随着JVM一同停止，GC进程。



3. ## 线程同步

* 多线程三个特性（原子性、可见性、有序性）任意一个不满足，都存在线程安全问题.

  * synchronize实现线程安全

    - 同步代码块

      ​        synchronize（锁的对象）{}

      ​         -普通类

      ​         -类，class

    - 同步方法

    ​                 -成员同步方法：锁的是当前对象this

    ​                 -静态同步方法：锁的是类的反射对象

    * synchronize底层实现（对象的Monitor机制）
    * 任意一个对象都有Monitor，synchronized对象锁实际上就是获取对象的Moniter。
    * 当前线要想要获得该锁的Monitor的流程
    * 先判断锁对象得Monitor计数器是否为0；
      * 为0：表示此时Monitor还未被任何线程持有，当线程获取Monitor，并将线程置为自己，将Monitor的值+1；
      * 不为0：表示Monitor已经被线程持有，判断线程获取Monitor







4. ## JDK1.6关于synchronized优化

CAS：compare and swap

CAS（O, V, M ）O：当前线程认为主内存中的值       V：主内存中的实际值      M：希望更新的值

5. ## 自旋

   * 定义：处理器上跑无用指令，但是线程不阻塞。
   * eg：
     1. 踩刹车但不熄火。
     2. 停车熄火
   * jvm是自适应自旋：重量级锁的优化
     * JVM给一个时间段，在该时间段内，线程是自旋状态，若是在该段获取到了锁，下一次适当延长自旋时间，否则将线程阻塞，下一次自动缩短自旋时间。

​    随着锁竞争的竞争激烈程度不断升级，没有降级过程。

1. 偏向锁----->轻量级锁------->重量级锁（JDK1.6之前synchronized默认实现）——线程获取锁失败进入阻塞态（OS用户态------>内核态）

2. JDK1.6 默认先偏向锁

   * 偏向锁（乐观锁，锁是一个线程来回获取）：

     -当线程第一次获取锁时，将偏向锁线程置为当前线程，以后再次获取锁时，不会再有加锁和解锁过程，只是简单判断下获取锁线程是否为当前线程。

   * 轻量级锁：在不同时间段内有不同线程尝试获取锁。

     -每次锁的获取都需要加锁和解锁过程。

   * 重量级锁：在同一时刻有不同线程尝试获取锁。

   * 锁粗化：将连续的加减锁过程粗化为一次大的加减锁过程

   * 锁消除：在没有多线程访问的场景下，将锁直接消除。

   * 死锁：

     -死锁产生的原因：以下四个条件同时满足才会获得死锁（我有笔，你有纸例子）

     1. 互斥：共享资源X,Y只能被一个资源占用；
     2. 占有且等待：线程1已经取得共享资源X，同时在等待资源Y，并且不释放X；
     3. 不可抢占：其他线程无法抢占线程1已经占用的资源X；
     4. 循环等待：线程1等待线程2的资源，线程2等待线程1的资源。

     -死锁的现象：程序出现“假死”现象

     -死锁的解决：破坏任意的一个条件

3. JDK1.5 引入Lock体系来优雅的解决死锁问题

   1. Lock的使用格式

      ```java
      try(){
          lock.lock（）；  
      }catch(Exception e){
      }finally{
          lock.unlock
      } 
      ```

   2. Lock接口的重要方法

      * 相应中断

      ```java
      2.1  void LockInterruptibly() throws 
      ```

      * 非阻塞式线程若获取锁失败，线程继续进行，不在阻塞。

      ```java
      2.2  boolean tryLock();
      ```

      * 支持超时，获取锁失败的线程等待一段时间后还未获取到锁，线程退出。

      ```java
      2.3 boolean tryLock(long time,TimeUnit unit) throws InterruptedException;
      ```

   3.Lock锁常用的子类

   reentrantLock：可重入锁（Lock接口中常用的子类，语义和synchronized基本一致，也是独占锁的实现）

   面试题:synchromized和ReentrantLock的关系和区别？

   答：联系：synchronized和reentrantLock都属于独占锁的实现，都属于可重入锁。

   ​       区别：1. synchronized是关键字，JVM层面上的实现，ReentrantLock是java语言层面上的实现

   ​                    2.ReentrantLock具备一些synchronized不具备的特性，如相应中断，支持超时，支持非阻塞式获取锁，可以实现公平锁（默认非公平锁）

   ​                  3.synchronized只有一个等待队列，二Lock调用newCondition()产生多个等待队列。

   ​                

   读写锁：

   ReentrantReadWriteLock：可重入读写锁

   

   

   

   

   

   

   

   同步队列：所有获取锁失败的线程进去同步队列排队获取锁。

   等待队列：调用wait()的线程置入等待队列，等待notify唤醒。唤醒后放入同步队列的队尾。

   公平锁：等待时间最长的线程最先获取锁。（synchronized是一个非公平锁）

   

------

Juc:lock1.5

1. tryLock：非阻塞式获取锁
2. lockInterruptily：相应中断
3. tryLock（long time ，TimeUnit）：支持超时



synchronized与Lock的区别？

1. synchronized是JVM层面，关键字；Lock是Java语言层面实现的“管程”。
2. Lock具备一些synchronized不具备的特性， 如……，支持公平锁，支持多个等待队列，还支持读写锁。

- 读写锁：读者写者问题
- 读线程：读读异步，读写同步
- 写线程：写写同步

读写锁实现：ReentrantReadWriteLock（实现缓存HashMap+ReetrantReadWriteLock）

读锁：ReadLock多个线程在同一时刻可以共同取得该读锁

写锁：WriteLock，独占锁，多个线程在同一时刻只有一个线程可以获得该锁

共享锁：多个线程可以同时获得该锁  读锁 ReadLock，不等于无锁。

当写线程开始工作所有线程（包括读线程）全部进入阻塞态



JDK1.8  ：StampedLock  更加乐观的锁实现，性能比ReetrantReadWriteLock还高



------

juc包下的工具类：CAS+Lock

1. 闭锁CountDownLatch

   * ```java
     public CountDownLatch(int count)：count 表示需要等待的线程个数
     
     public void countDown():计数器-1（类似于运动员线程）
     
     public void await() throws Interrupte
     ```

     

   - CountDownLatch对象在计数器值减为0时不可恢复在，只会调用await方法的线程。

2. CyclicBarrier-循环栅栏

   * ```java
     public CyclicBarrier(int parties):parties表示需要多少个线程同时暂停已经恢复执行
     public int await() cyclicBarrier 计数器减1 ，当减为0时，所有阻塞态线程同时恢复执行
     
     public cyclicBarrier(int parties,Runable BarrierAction)多个线程挑选一个线程执行barrierAction任务后，再同时恢复执行
         
        
     ```

   * cyclicBarrier计时器可以恢复reset()，cyclicBarrier的对象可以重复使用

3. Exchange交换器

   - Exchange用于两个线程交换数据，当缓存区只有一个线程时，该线程会阻塞知道配对成功再交换数据恢复执行

4. Semaphore信号量

   8个工人   5台设备

   * ```java
     public Semaphore(int permits):表示许可的数量
     public Semaphore(int permits,boolean fair):等待时间最长的线程最先获得许可
     
     public void acquire（）：申请许可
     public 
     ```

     

   

   

常见队列阻塞

​    LinkedBLockQueue：基于链表的无界阻塞队列

​         -内置的固定大小线程池就采用此队列

  Synchronous





Executors ：线程池的工具类

* 单线程池

  * newSingleThreadExecutor（）

* 固定大小线程池

  * newCachedThreadPool（）

* 缓存池（服务器负载较轻适应与很多短期异步小任务）

  * 当提交任务速度>>任务处理速度，不断产生新线程；任务处理速度>提交任务速度

* 定时调度池

  * newScheduledThrePool（int corePoolSize）

* 核心池

* 最大线程池

* 阻塞队列

* 拒绝策略

* 线程池：为何推荐使用线程池来新建线程

  1. 线程池的工作流程
  2. 如何自定义线程池
     - 核心线程池类ThreadPoolExcutor参数配置
     - 线程池工作线程Worker，如何实现
  3. 在何种环境下选用何种线程池

  