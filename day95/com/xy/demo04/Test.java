package com.xy.demo04;
/*
* 向上转型和向下转型
*
*
* */
public class Test {
    public static void main(String[] args) {
        Animal animal=new Dog();  //本来是一只猫  //向上转型
        animal.eat();
        //希望用子类的特有方法，可以使用instances来安全的向下转型
        if (animal instanceof Dog){
            Dog dog=(Dog) animal;
            dog.play();

        }
        if (animal instanceof Cat){
            Cat cat=(Cat) animal;
            cat.play();

        }








    }

}
