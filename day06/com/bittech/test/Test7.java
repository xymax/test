package com.bittech.test;

import java.util.stream.Stream;

/**
 * Author: secondriver
 * Created: 2019/5/15
 */
public class Test7 {
    public static void main(String[] args) {
        try (Stream stream = Stream.generate(Math::random).limit(10).onClose(() -> {
            System.out.println("Close");
        })) {
            stream.forEach(System.out::println);
        }
    }
}
