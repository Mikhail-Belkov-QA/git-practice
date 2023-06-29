package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 13, 14, 15, 16, 17, 18, 19, 20};

        Set<Integer> uniqueElements = new HashSet<>(Arrays.stream(mas)
                .boxed().collect(Collectors.toList()));

        System.out.println(uniqueElements.size());


        }
    }
