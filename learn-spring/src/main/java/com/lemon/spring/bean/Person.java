package com.lemon.spring.bean;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lemon
 * @since 2021-05-07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Component
//@Scope(value = "prototype")
public class Person implements Serializable {

    private static final long serialVersionUID = -477133720384720090L;

//    private static List<Person> personList = new ArrayList<>();

    private Integer id;
    private String name;
    private String thread;

    private ThreadLocal localId = new ThreadLocal();
    private ThreadLocal localName = new ThreadLocal();

    public void init(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void initLocal(Integer id, String name) {
        this.localId.set(id);
        this.localName.set(name);
        this.id = id;
        this.name = name;
        this.thread = Thread.currentThread().getName();
//        personList.add(this);
//        System.out.println(Thread.currentThread().getName() + "   " + personList.toString());
    }

    @Override
    public String toString() {
        return "Person{" + this.hashCode() +
                " id=" + id +
                ", name='" + name + '\'' +
                ", thread='" + thread + '\'' +
                ", localId=" + localId.get() +
                ", localName=" + localName.get() +
                '}';
    }
}
