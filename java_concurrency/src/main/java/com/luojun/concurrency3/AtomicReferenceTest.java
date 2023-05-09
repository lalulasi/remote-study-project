package com.luojun.concurrency3;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: java_concurrency
 * @description:
 * @author: jun.luo
 * @create: 2023-03-28 12:47
 **/
public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<Student> studentReference = new AtomicReference<>();
        Student student1 = new Student("a", 15);
        Student student2 = new Student("b", 15);
        studentReference.compareAndSet(student1, student2);

        Student student3 = studentReference.get();
        System.out.println(student3);
        System.out.println(student3.equals(student1));
    }

}
