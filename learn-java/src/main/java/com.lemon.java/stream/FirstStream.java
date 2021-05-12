package com.lemon.java.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lemon
 * @since 2021-05-11
 */
public class FirstStream {

    public static void main(String[] args) {
//        testOne();
        testTwo();
    }

    public static void testOne() {
        List<Dish> dishList = Dish.getMenu();
        List<String> nameList = dishList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    public static void testTwo() {
        List<Dish> dishList = Dish.getMenu();
        List<String> nameList = dishList.stream()
                .filter(dish -> {
                    System.out.println("filtering" + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

}
