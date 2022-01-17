package com.enigmacamp.oop.main;

import com.enigmacamp.oop.model.Robot;

public class Main {
    public static void main(String[] args) {
        try {
            Robot robo1 = new Robot();
            robo1.read();
            robo1.moves("RR");
            System.out.println(robo1);
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
