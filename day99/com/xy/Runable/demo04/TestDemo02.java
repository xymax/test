package com.xy.Runable.demo04;

/*
* ��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�
*
* ��˼���ǵ���yield�������õ�ǰ�߳̽���CPUȨ�ޣ���CPUȥִ���������̡߳�
* ����sleep�������ƣ�ͬ�������ͷ���������yield���ܿ��ƾ���Ľ���CPU��ʱ�䣬
* ���⣬yield����ֻ����ӵ����ͬ���ȼ����߳��л�ȡCPUִ��ʱ��Ļ���
*
* */
public class TestDemo02 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread, "�߳�1").start();
        new Thread(myThread, "�߳�2").start();
        new Thread(myThread, "�߳�3").start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
