package com.codewithomar.project;

/**
 * This is the main class of the program.
 * Contains the main method and is in charge of executing the
 * "initializer" method which boots the program.
 */
public class Main {
    public static void main(String[] args) {
        //Process type object which contains the initializer method
        Process process = new Process();
        //Method containing the logic to start the program
        process.initializer();
    }
}
