package com.lemon.java.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lemon
 * @since 2021-05-11
 */
public class ReduceStream {
    public static void main(String[] args) {
        testReduce();
    }

    private static void testReduce() {
        List<Dish> dishList = Dish.getMenu();
//        List<Dish> dishList = new ArrayList<>();
        System.out.println(dishList.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b));
        System.out.println(dishList.stream().map(Dish::getCalories).reduce(Integer::sum));
        System.out.println(dishList.stream().map(Dish::getCalories).reduce(Integer::max));
        System.out.println(dishList.stream().map(Dish::getCalories).max(Integer::compareTo));
        System.out.println(dishList.stream().map(Dish::getCalories).min(Integer::compareTo));

        System.out.println(dishList.stream().mapToInt(Dish::getCalories).sum());
        System.out.println(dishList.stream().mapToInt(Dish::getCalories).max());
        System.out.println(dishList.stream().mapToInt(Dish::getCalories).average());
    }
}
