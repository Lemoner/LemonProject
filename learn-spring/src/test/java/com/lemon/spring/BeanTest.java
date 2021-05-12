package com.lemon.spring;

import com.lemon.common.Stdout;
import com.lemon.spring.bean.Person;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author lemon
 * @since 2021-05-07
 */
public class BeanTest extends BaseTest {

    @Autowired
    private ApplicationContext applicationContext;

    private static List<Person> personList = new ArrayList<>();

    private final ExecutorService executorService = new ThreadPoolExecutor(
            2,
            2,
            10,
            MILLISECONDS,
            new ArrayBlockingQueue<>(10));

    @Test
    public void test1() {
        List<String> list = Lists.newArrayList("aa", "bb", "cc");
        Stdout.printlnJson(list);
    }

    @Test
    public void BeanTest1() {
        List<Person> list = Lists.newArrayList();
        Person person1 = applicationContext.getBean(Person.class);
        person1.init(1, "AA");
        list.add(person1);
        Stdout.printlnJson(list);
        Person person2 = applicationContext.getBean(Person.class);
        person2.init(2, "BB");
        list.add(person2);
        Stdout.printlnJson(list);
    }

    @Test
    public void BeanTest2() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            executorService.execute(() -> {
                Person person = applicationContext.getBean(Person.class);
//                person.init(finalI, "A" + finalI);
                person.initLocal(finalI, "A" + finalI);
                personList.add(person);
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + "   " + person.toString() + "   " + personList.toString());
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(10000);
    }

}
