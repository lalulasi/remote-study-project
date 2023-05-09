package com.jun.luo.reflection;

import java.lang.reflect.Field;

/**
 * @program: jvm_study
 * @description:
 * @author: jun.luo
 * @create: 2023-04-19 14:10
 **/
@StuTbl("stu_tbl")
public class Student {
    @StuField(columnName = "_id", type = "int", length = 10)
    private int id;
    @StuField(columnName = "age", type = "int", length = 10)
    private int age;
    @StuField(columnName = "name", type = "varchar", length = 20)
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.jun.luo.reflection.Student");
        StuTbl stuTbl = c1.getAnnotation(StuTbl.class);
        System.out.println(stuTbl.value());

        Field f1 = c1.getDeclaredField("id");
        StuField fa1 = f1.getAnnotation(StuField.class);
        System.out.println(fa1.columnName());
        System.out.println(fa1.type());
        System.out.println(fa1.length());
    }
}
