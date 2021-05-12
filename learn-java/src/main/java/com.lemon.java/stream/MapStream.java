package com.lemon.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lemon
 * @since 2021-05-11
 */
public class MapStream {

    public static void main(String[] args) {
//        testMap();
//        testFloatMap();
        testFloatMap1();
        testFloatMap2();
    }

    private static void testFloatMap1() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<Stream<int[]>> pairs = numbers1.stream()
                .map(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.stream().forEach(pair -> pair.forEach(pp -> System.out.println(Arrays.toString(pp))));
        System.out.println("=========");
    }

    private static void testFloatMap2() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.stream().forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    private static void testFloatMap() {
        List<Dish> dishList = Dish.getMenu();
        List<String> nameList = dishList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    public static void testMap() {
        List<Dish> dishList = Dish.getMenu();
        List<Integer> nameList = dishList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

}
