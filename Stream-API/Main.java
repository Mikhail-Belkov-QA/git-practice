package org.example;
import java.util.stream.Stream;
public class Main {

       public static void main(String[] args) {

  Stream.of("oneoneone", "two", "three","foor", "two")
            .filter(i -> i.length() < 6)
             .distinct()
            .map(i -> i.replace(String.valueOf(i.charAt(0)), "t"))
             .forEach(System.out::println);



    }
}