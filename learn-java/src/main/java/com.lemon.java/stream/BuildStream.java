package com.lemon.java.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author lemon
 * @since 2021-05-12
 */
public class BuildStream {
    public static void main(String[] args) {
//        testIterate();
        testGenerate();
    }

    private static void testIterate() {
        Stream.iterate(new long[]{0, 1}, t -> {
                    long tmp = t[1];
                    t[1] = t[0] + t[1];
                    t[0] = tmp;
                    return t;
                })
                .limit(100)
                .map(t -> t[0])
                .forEach(System.out::println);
//                .forEach(t -> System.out.println(Arrays.toString(t)));
    }

    private static void testGenerate() {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        long[] t = new long[]{0, 1};
        Stream.generate(() -> {
                    long tmp = t[1];
                    t[1] = t[0] + t[1];
                    t[0] = tmp;
                    return t;
                })
                .limit(10)
                .map(x -> x[0])
                .forEach(System.out::println);


        Supplier fib = new Supplier<Integer>(){
            private int previous = 0;
            private int current = 1;
            @Override
            public Integer get(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            } };
        Stream.generate(fib).limit(10).forEach(System.out::println);
    }
}
