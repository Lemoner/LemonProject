package com.lemon.java.stream;

import java.util.List;

/**
 * @author lemon
 * @since 2021-05-11
 */
public class MatchStream {

    public static void main(String[] args) {
//        testMatch();
        testFind();
    }

    private static void testFind() {
        List<Dish> dishList = Dish.getMenu();
        dishList.parallelStream().filter(Dish::isVegetarian).findFirst().ifPresent(System.out::println);
        System.out.println("============");
        dishList.parallelStream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);
    }

    private static void testMatch() {
        List<Dish> dishList = Dish.getMenu();
        System.out.println(dishList.stream().allMatch(dish -> dish.getCalories() > 100));
        System.out.println(dishList.stream().anyMatch(dish -> dish.getCalories() > 100));
        System.out.println(dishList.stream().noneMatch(dish -> dish.getCalories() > 100));
    }

}
