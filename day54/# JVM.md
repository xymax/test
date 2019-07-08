# JVM

JVM：java内存模型（关于并发程序的内存模型-逻辑模型）

1. JMM的工作流程

   - 工作内存：每个线程创建时分配的空间，线程私有。
   - 主内存：所有线程共享的内存区域，存放所有的共享变量（类的实例变量，静态变量，常量）

2. JMM三大特性

   - 只有以下三个特性同时满足，才是线程安全的代码
     - 原子性：基本数据类型的访问读写都属于原子性操作若需要更大范围的原子性，需要使用synchronized的Lock来保证。
       - 原子性是指一个操作是不可中断的。即使是在多个线程一起执行的时候，一个操作一旦开始就不会被其他线程干扰。 
     - 可见性：任意一个线程修改了共享变量的值，其他线程能够立即得知此修改，只有以下三种synchronized，volatile、final实现可见性
     - 有序性：逻辑上写在前面的代码优先发生于写在后面的代码

3. volatile变量的特殊规则

   3.1可见性

   volatile写操作优先发生于读操作

   ```java
   禁止指令重排
       int x=1；
       int y=2；
   --------volatile int z=3；-------
       x+=2；
       y+=2；
   ```

   * a.volatile代码既不会提前也不会滞后；
   * a.volatile代码



```java

```





深浅拷贝：对象

- 浅拷贝：牵一发而动全身。

- 拷贝对象的引用复用，并不会产生新对象

- 深拷贝：拷贝对象的内部的引用也会产生新对象。

  - 实现深拷贝：

  1. 递归使用Cloneable接口
  2. 使用序列化（推荐）





## JVM

1. ### 内存区域划分

- 线程私有（随着线程的创建而创建，随着线程销毁而回收，生命周期与线程相同，不同线程间隔离）
  - 程序计数器：记录当前所执行的字节码行号，唯一 一块不产生OOM。native方法在程序计数器中值为0.
  - 虚拟机栈：java方法的内存模型。--Xss设置栈的大小  StackOverflowError    OOM
  - 本地方法栈：本地方法的内存模型
    - HotSpot：本地得到栈与虚拟机栈合二为一

- 线程共享
  + 堆（GC堆）：所有对象以及数组实例   -Xms设置堆的最小值  -Xms设置堆的最大值
  + 方法区（JDK8之前的永久代）：静态变量，常量，加载的类信息
  + 运行时的常量池（方法区的一部分）：方法引用，字面量。
- 判断对象是否存活-->对象是否原地去世？（finalize（））去世》如何回收不在存活对象（GC算法）





2. 判断对象是否存活：

   1. 引用计数器（c++只能指针，pythonGC）
      - 无法解决循环引用问题（java没有采用）
   2. 可达性分析算法
      - GC Roots；
      - a.类中的静态变量，常量
      - b.栈中的局部变量

3. JDK1.2之后关于引用的扩充

   + 强：程序中普遍存在的，类似Test test=new Test（）；只要对象被强引用指向，GC无法回收此对象
   + 软：描述有用，但不必须对象（缓存对象），JDK1.2 SoftRerference来描述软引用。
     + 当对象仅被软引用指向，内存够用时不回收，即将发生OOM，一次回收掉仅被软引用指向的对象。
   + 弱：仅能存活在下一次GC之前，GC开始前，无论内存是否够用，都会回收掉仅被弱引用指向的对象
     + JDK1.2 WeakRerference来描述弱引用
   + 虚：与对象的生命周期无关，当对象被GC时，由JVM发出一个回收通知。JDK12PhatomRenference描述虚引用

4. 对象的自我拯救finalize()

   - final,finally,finalize区别

5. 如何进行垃圾回收

   答：java采用分代回收算法，将内存分为新生代与老年代，其中新生代采用复制算法，老年代采用标记--整理算法

   * 新生代（对象默认在新生代产生，对象存活率较低）：复制算法：（一块较大的Eden，survivor）
   * 老年代（对象存活率较高）：标记整理算法

面试题：请解释MinorGC与FullGC（Major GC）

## 类集

1. ArrayList、LinkList、vector的关系与区别（源码）？

   答：1. ArrayList基于数组实现List，采用懒加载策略，当第一次调用add方法时，数组才会初始化为10（默认值）ArrayList扩容为原先数组的1.5倍，ArrayList采用异步操作，线程不安全，性能较高。（在普通插入使用ArrayList比较快，因为它直接插在尾部，看源码add）

   ​        2.Vector（JDK1.0）基于数组实现List，当产生vector对象时，就初始化为大小为10的数组，扩容为原来数组的二倍。Vector采用同步方法保证线程安全，性能低（读读互斥）

   ​         3.LinkList基于双向链表实现的List，采用异步处理，线程不安全。（在任意位置插入或删除时考虑使用LinkList或需要使用队列的场合）

2. #### 请描述fail-fast（快速失败）策略?  ConcurrentModificationExcrption.

   - 在迭代输出的过程中修改了集合的结构，（remove，add）抛出此异常，为了保证多线程场景下取得数据正确性。
   - 如何产生：modCount记录当前被修改次数
   - expectedModCount迭代器内部记录当前集合修改次数，取得集合迭代器是赋值为modCount
   - modCount ！=expectedModCount
   - 如何解决
     - 迭代输出时尽量不要修改集合结构
     - 使用juc包下的线程安全集合去CopyOnWriteArrayList，concurrentHashMap(fail-fast集合)

   - 答：定义：优先考虑异常情况，直接抛出，程序终止。

3. set与Map有什么关系？

​      答：set实际就是Map,Set将元素储存到来Map的key

1. HashMap、Hashtable、TreeMap的关系与区别？
2. 为何在线程安全的场合要使用ConcurrentHashMap、ConcurrentHashMap如何高效实现线程安全？
3. ConcurrentHashMap在JDK1.7和1.8区别？







