package org.example.DesignPatterns.factory;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside square:draw() method");
    }
}
