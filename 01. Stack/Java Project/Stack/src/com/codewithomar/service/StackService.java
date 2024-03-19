package com.codewithomar.service;

import com.codewithomar.model.Stack;

/**
 * This class contains only the business logic regarding the methods
 * and actions specific to a Stack Data Structure.
 * @author Omar Montoya (@codewithomarm)
 */
public class StackService {
    /**
     * Stack type object. This object will be used in all methods
     * to execute basic Stack procedures.
     */
    private Stack stack;

    /**
     * Default Constructor
     */
    public StackService(){
    }

    /**
     * Constructor with parameters.
     * @param stack A Stack type object will be assigned to the "stack"
     *              dependency declared on the class.
     */
    public StackService(Stack stack) {
        this.stack = stack;
    }

    /**
     * This method is used to check if the stack is empty.
     * <br></br>
     * <br>When the stack is empty, the Top value will always equals -1.</br>
     * <br></br>
     * <br>This method compares if the "top" attribute current value equals -1</br>
     * @return "true" if the stack is empty. "false" if the stack is not empty.
     */
    public boolean isStackEmpty(){
        return (stack.getTop() == -1);
    }

    /**
     * This method is used to check if the stack is full.
     * <br></br>
     * <br>When the stack is full, the Top value will always
     * equals the length from the array minus 1.</br>
     * <br></br>
     * <br>This method compares if the current "top" attribute
     * value from "stack" object equals "arr" attribute´s length
     * minus 1.
     * @return true: if the stack is full.
     * <br>false: if the stack is not full.</br>
     */
    public boolean isStackFull(){
        return (stack.getTop() == (stack.getArr().length - 1));
    }

    /**
     * This method is used to add a new value to the stack.
     * <br></br>
     * <br>First, it checks if the stack is currently full.</br>
     * <br></br>
     * <br>If the stack is not full, the method will add 1 to the current "top" attribute
     * value from "stack" object.
     * Then it will pass the parameter integer "newValue" to the method .setArrValueAtIndex
     * so the new value can be added to the "arr" attribute at the "top" index position.</br>
     * <br></br>
     * <br>If the stack is full, the method will not add the given integer parameter to the
     * stack.</br>
     * @param newValue An integer value that will be added to the stack
     *                 at the current "top" position index if the stack
     *                 is not full.
     * @return 1: if the push process was done successfully.
     * <br>-1: if the stack is full and the value could not be added.</br>
     */
    public int pushStack(int newValue){
        int result = 0;
        if (!isStackFull()) {
            stack.setTop(stack.getTop() + 1);
            stack.setArrValueAtIndex(stack.getTop(), newValue);
            result = 1; //Push method executed successfully
        } else {
            result = -1; //Stack Overflow
        }
        return result;
    }

    /**
     * This method is used to remove the value at the Top of the Stack.
     * <br></br>
     * <br>First, it checks if the stack is currently empty.</br>
     * <br></br>
     * <br>If the stack is not empty, the method will assigned the integer value
     * at the "top" index position of the "stack" object to the local variable
     * "removedValue".</br>
     * <br>Then the method will replace the "arr" value at the "top" index position with 0.</br>
     * <br>Finally the method will reduce the "top" value from "stack" object by 1</br>
     * <br></br>
     * <br>If the stack if empty, the method will not remove any value.</br>
     * @return removedValue: if the stack is not empty it will return
     * the integer value that was removed at the Top of the stack.
     * <br>-1: if the stack is full and no value was removed.</br>
     */
    public int popStack(){
        int removedValue = 0;
        if (!isStackEmpty()) {
            removedValue = stack.getArrValueAtIndex(stack.getTop());
            stack.setArrValueAtIndex(stack.getTop(), 0);
            stack.setTop(stack.getTop()-1);
        } else {
            removedValue = -1; //Stack Underflow
        }
        return removedValue;
    }

    /**
     * This method is used to print the "top" index value from "stack" object
     * and each individual integer value from the stack.
     */
    public void printStack(){
        System.out.println("\tCURRENT STACK:");
        System.out.println("\tTop index: " + stack.getTop());
        for (int i= stack.getArr().length-1; i>=0; i--){
            System.out.printf("\t\tStack[%d]: %d\n", i, stack.getArrValueAtIndex(i));
        }
        System.out.println();
    }
}
