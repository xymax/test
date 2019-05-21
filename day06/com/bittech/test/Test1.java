package com.bittech.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: secondriver
 * Created: 2019/5/15
 */
public class Test1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //输入人数
            int numPeople = scanner.nextInt();
            //排序策略
            int option = scanner.nextInt();
            
            //输入人员的姓名和成绩
            List<Student> stuList = new ArrayList<>();
            for (int i = 0; i < numPeople; i++) {
                stuList.add(new Student(scanner.next(), scanner.nextInt()));
            }
            
            //降序
            if (option == 0) {
                stuList.sort((o1, o2) -> o2.score - o1.score);
            } else if (option == 1)//升序
            {
                stuList.sort((o1, o2) -> o1.score - o2.score);
            }
            for (Student student : stuList) {
                System.out.println(student.name + " " + student.score);
            }
        }
    }
}

class Student {
    public String name;
    public int score;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
