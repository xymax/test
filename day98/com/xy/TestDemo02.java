package com.xy;

public class TestDemo02 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int i = getElement(arr, 3);
        System.out.println(i);

    }


    public static int getElement(int[] arr,int index){
        int i=arr[index];
        return i;
    }

}
