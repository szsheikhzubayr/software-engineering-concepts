package org.example.DesignPatterns.factory;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside circle:draw() method");
    }
}
