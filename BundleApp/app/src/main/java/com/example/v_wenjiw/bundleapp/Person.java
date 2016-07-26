package com.example.v_wenjiw.bundleapp;

import java.io.Serializable;

/**
 * Created by v-wenjiw on 7/25/2016.
 */
public class Person implements Serializable {
    public String name;
    public String psw;
    public String gender;

    public Person(String name, String psw, String gender) {
        this.name = name;
        this.psw = psw;
        this.gender = gender;
    }
}
