package org.hibernatetutorials.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    private int roll_no;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
