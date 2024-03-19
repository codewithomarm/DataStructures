package com.codewithomar.model;

/**
 * This is a POJO class that represents the elements of a Stack Data Structure
 * @author Omar Montoya (@codewithomarm)
 */
public class Stack {
    /**
     * Attribute that will be used as the representation of the data structure.
     * The length of the array will always be provided during program runtime by the user.
     */
    private int[] arr;
    /**
     * Attribute that will be used as the representation of the index position
     * of the "Top" element of the Stack.
     */
    private int top;

    /**
     * Default constructor
     */
    public Stack() {
    }

    /**
     * Constructor with parameters.
     * "arr" attribute will be initialized with the size of param "size".
     * "top" attribute will be initialized with -1 as value since the Stack
     * will always start empty.
     * @param size An integer value providing the size of the array "arr".
     */
    public Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
    }

    /**
     * Get method for "arr" attribute
     * @return arr attribute
     */
    public int[] getArr() {
        return arr;
    }

    /**
     * Get method to return the value from "arr" at a specific index.
     * @param i An integer value which specifies the index position
     *          that wants to be returned from "arr" attribute.
     * @return Integer value from "arr" attribute at specific index.
     */
    public int getArrValueAtIndex(int i){
        return arr[i];
    }

    /**
     * Set method for "arr" attribute
     * @param arr An integer array
     */
    public void setArr(int[] arr) {
        this.arr = arr;
    }

    /**
     * Set method to assign an integer value at a specific index
     * on "arr" attribute.
     * @param i An integer value which specifies the index position
     *          where the new value will be assigned.
     * @param value The integer value that will be assigned at the given
     *              index position.
     */
    public void setArrValueAtIndex(int i, int value){
        this.arr[i] = value;
    }

    /**
     * Get method for "top" attribute
     * @return top integer value.
     */
    public int getTop() {
        return top;
    }

    /**
     * Set method for "top" attribute
     * @param top An integer that will be assigned as the new "top"
     *            attribute value.
     */
    public void setTop(int top) {
        this.top = top;
    }
}
