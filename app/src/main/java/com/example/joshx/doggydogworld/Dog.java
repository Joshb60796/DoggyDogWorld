package com.example.joshx.doggydogworld;

import android.util.Log;

/**
 * Created by JoshX on 1/4/2015.
 */
public class Dog {
    private String name;
    private int age;
    private int numberOfLegs = 4;
    private String breed;
//empty constructor
    Dog() {
        Log.d("Dog", "Constructing...");
    }
//another constructor that takes some info for the creation of the object
    Dog(String dogName){
        name = dogName;
    }

    public void bark(){
        String bark = name + " barked";
        Log.d("Dog", bark);
    }

    public void barkAt(String victim){
        String bark = name + " barked at "+victim;
        Log.d("Dog", bark);
    }
}
