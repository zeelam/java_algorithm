package com.zeelam.util;

public class PersonWithCom extends Person implements Comparable<PersonWithCom> {

    public PersonWithCom(int age) {
        super(age);
    }

    @Override
    public int compareTo(PersonWithCom o) {
        return this.getAge() - o.getAge();
    }
}
