package com.xy.Runable.demo04;

/*
* �߳����� :����ʱ��ʹ�ú�����Ϊ��λ��
*
* �߳����߻ύ��CPU����CPUȥִ�����������񡣵�����һ��Ҫ�ǳ�ע�⣬sleep���������ͷ�����
* Ҳ����˵�����ǰ�̳߳��ж�ĳ�������������ʹ����sleep�����������߳�Ҳ�޷������������
*
*ͨ������۲��������Ϊ�������߳���ͬʱ���ߵģ�����ǧ��Ҫ��ס��
*���еĴ��������ν��뵽run()�����е�.�������뵽�����Ķ�������Ƕ����
*Ҳ������һ������������˳������в��죬���������ִ���ǲ���ִ�С�
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread, "�߳�1").start();
        new Thread(myThread, "�߳�2").start();
        new Thread(myThread, "�߳�3").start();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
