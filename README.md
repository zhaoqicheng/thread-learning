## 线程学习备忘录：

#### 基础概念部分

------------

##### 1.java内存模型
`由于计算机的存储设备与处理器的运算能力之间有几个数量级的差距，所以现代计算机系统都不得不加入一层读写速度尽可能接近处理器运算速度的高速缓存（cache）来作为内存与处理器之间的缓冲：将运算需要使用到的数据复制到缓存中，让运算能快速进行，当运算结束后再从缓存同步回内存之中没这样处理器就无需等待缓慢的内存读写了。`

##### 2.线程基础概念
__`线程安全`__：`当多个线程访问同一个类时，无论出于何种环境，采用何种调度方式，或者多个线程将如何的调度执行，而代码中不需要额外的同步或者协同方式，这个类都可以表现出正常的行为得到预期相同的结果，那么就称这个类是线程安全的。`

__`线程安全主要变现在以下几个方面：`__
- __`a.原子性`__：`提供了互斥访问，同一时刻只允许一个线程来对它进行操作`