package com.codewithomar.project;

import com.codewithomar.model.Stack;
import com.codewithomar.service.StackService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class includes the implementation of the StackService and Stack
 * objects to test its usage in a simple console-based program
 * @author Omar Montoya (@codewithomarm)
 */
public class Process {
    /**
     * InputStreamReader type object declaration to read console input from user.
     */
    InputStreamReader isr = new InputStreamReader(System.in);
    /**
     * BufferedReader type object declaration to read console input from user.
     */
    BufferedReader br = new BufferedReader(isr);
    /**
     * StackService type object declaration to use the Stack data structure methods.
     */
    StackService stackService;
    /**
     * Stack type object declaration so the StackService object can be used.
     */
    Stack stack;

    /**
     * This method is used to ask the user the size of the Stack via console.
     * <br></br>
     * <br>The method will throw an error message and will ask for the size again if the input
     * provided is a negative or zero value.</br>
     * <br></br>
     * <br>If the size is valid, the size provided by the user will be used to initialize the
     * stack object.</br> <br>The stack object will then be passed as argument to the stackService object.</br>
     * <br>Once stackService object is initialized, the program main menu will be executed by
     * calling the local method .mainMenu().</br>
     * @exception IOException If Input/Output exception.
     * @exception NumberFormatException If the user input is different from an integer value.
     */
    public void initializer(){
        System.out.println("This is a program to test the usage and methods of a Stack Data Structure\n");
        boolean exitInitializer = false;
        do {
            System.out.println("Please provide a positive integer value for the size of the Stack you want to create: ");
            try{
                int stackSize = Integer.parseInt(br.readLine());
                if (stackSize <= 0) {
                    System.out.println("The size provided is not valid.\n");
                } else {
                    stack = new Stack(stackSize);
                    stackService = new StackService(stack);
                    System.out.println();
                    this.mainMenu();
                    exitInitializer = true;
                }
            } catch (IOException e) {
                System.out.println("Input/Output exception.");
                System.out.println("Please try again.\n");
            } catch (NumberFormatException e) {
                System.out.println("Input provided is not valid.");
                System.out.println("Please try again.\n");
            }
        } while (!exitInitializer);
    }

    /**
     * This method contains the logic to execute the program's main menu using a switch statement.
     * For each available option, a respective local method will be called.
     * The method will be executed until the user input a valid option.
     * @exception IOException If Input/Output exception.
     * @exception NumberFormatException If the user input is different from an integer value.
     */
    private void mainMenu(){
        boolean exitMainMenu = false;
        do {
            System.out.println("Stack Main Menu");
            System.out.println("Option 1: Print Stack");
            System.out.println("Option 2: Peek top element at the Stack");
            System.out.println("Option 3: Get Stack total elements");
            System.out.println("Option 4: Get Stack empty elements");
            System.out.println("Option 5: Add one item to Stack");
            System.out.println("Option 6: Delete one item from Stack");
            System.out.println("Option 7: Exit Program");
            System.out.println("Please input the integer value of the option you want:");
            try {
                int menuResponse = Integer.parseInt(br.readLine());
                switch (menuResponse) {
                    case 1: //Print Stack
                        System.out.println();
                        stackService.print();
                        System.out.println();
                        break;
                    case 2: //Peek Top element
                        System.out.println();
                        this.peekStackElement();
                        System.out.println();
                        break;
                    case 3: //Total Elements
                        System.out.println();
                        this.getStackSize();
                        System.out.println();
                        break;
                    case 4: //Empty Elements
                        System.out.println();
                        this.getStackEmptyElements();
                        System.out.println();
                        break;
                    case 5: //Push Stack
                        System.out.println();
                        this.pushStack();
                        System.out.println();
                        break;
                    case 6: //Pop Stack
                        System.out.println();
                        this.popStack();
                        System.out.println();
                        break;
                    case 7: //Exit Program
                        System.out.println();
                        boolean exitProgram = this.exitProgram();
                        if (exitProgram) {
                            exitMainMenu = true;
                        }
                        break;
                    default:
                        System.out.println("Option provided not valid.");
                        System.out.println("Please try again.\n");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Input/Output exception.");
                System.out.println("Please try again.\n");
            } catch (NumberFormatException e) {
                System.out.println("Input provided is not valid.");
                System.out.println("Please try again.\n");
            }
        } while (!exitMainMenu);
    }

    /**
     * This method contains the implementation of the PeekTop method from "stackService" object in the program.
     * If the stack is not empty, it will print the element at the Top index position.
     */
    private void peekStackElement(){
        int topElement = stackService.peek();
        if (topElement == -1) {
            System.out.println("Stack is currently empty.");
            System.out.println("No element at the Top of the Stack.");
        } else {
            System.out.println("Element at the Top of the Stack is: " + topElement);
        }
    }

    /**
     * This method contains the implementation of the "getStackTotalElements" method from "stackService object
     * in the program.
     */
    private void getStackSize(){
        System.out.println("Stack total elements: " + stackService.getSize());
    }

    /**
     * This method contains the implementation of the "getStackEmptyElements" method from "stackService" object
     * in the program
     */
    private void getStackEmptyElements(){
        System.out.println("Stack empty elements: " + stackService.getEmptyElements());
    }

    /**
     * This method contains the implementation of the Push method from "stackService" object in the program.
     * <br></br>
     * <br>The method will ask the user to input a positive integer to add it to the stack.</br>
     * <br></br>
     * <br>If the user inputs a negative or zero integer value, the method will show an error message
     * and will ask for a number again until a valid integer is provided.</br>
     * <br></br>
     * <br>If the user inputs a valid integer, the method will execute "pushStack()" method from
     * "stackService" object.</br>
     * @exception IOException If Input/Output exception.
     * @exception NumberFormatException If the user input is different from an integer value.
     * @see StackService
     * @see Stack
     */
    private void pushStack() {
        boolean exitPushStack = false;
        do {
            System.out.println("Please enter a positive integer value you want to add to the stack:");
            try {
                int pushValue = Integer.parseInt(br.readLine());
                if (pushValue <= 0) {
                    System.out.println("Integer value must be positive.");
                    System.out.println("Please try again.\n");
                } else {
                    int pushResult = stackService.push(pushValue);
                    if (pushResult == -1) {
                        System.out.println("Stack is currently full.");
                        System.out.println("Stack Overflow!");
                    } else {
                        System.out.println("New value added to Stack successfully!\n");
                    }
                    exitPushStack = true;
                }
            } catch (IOException e) {
                System.out.println("Input/Output exception.");
                System.out.println("Please try again.\n");
            } catch (NumberFormatException e) {
                System.out.println("Input provided is not valid.");
                System.out.println("Please try again.\n");
            }

        } while (!exitPushStack);
    }

    /**
     * This method contains the implementation of the Pop method from "stackService" object in the program.
     * @exception IOException If Input/Output exception.
     * @exception NumberFormatException If the user input is different from an integer value.
     * @see StackService
     * @see Stack
     */
    private void popStack() {
        int popValue = stackService.pop();
        if (popValue == -1) {
            System.out.println("Stack is currently empty.");
            System.out.println("Stack Underflow!\n");
        } else {
            System.out.println("Value at the top of the stack has been removed successfully!");
            System.out.println("Popped value: " + popValue + "\n");
        }
    }

    /**
     * This method contains the logic for exiting the main program.
     * The method will ask a confirmation before exiting the program.
     * If the client input 1, it will exit the program. If the client input 0
     * the program will go back to the main menu.
     * @return "true" if a client confirms, they want to exit the program by inputting "1"
     *         "false" if a client confirms they do not want to exit the program by inputting "0".
     */
    private boolean exitProgram() {
        boolean exitMethod = false;
        boolean exitProgram = false;
        do {
            System.out.println("Are you sure you want to exit the program?");
            System.out.println("1: Yes | 0: No");
            try {
                int exitResponse = Integer.parseInt(br.readLine());
                switch (exitResponse) {
                    case 0:
                        System.out.println();
                        exitMethod = true;
                        break;
                    case 1:
                        System.out.println();
                        exitProgram = true;
                        exitMethod = true;
                        break;
                    default:
                        System.out.println("Option provided not valid.");
                        System.out.println("Please only enter '1' or '0'.\n");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Input/Output exception.");
                System.out.println("Please try again.\n");
            } catch (NumberFormatException e) {
                System.out.println("Input provided is not valid.");
                System.out.println("Please try again.\n");
            }
        } while (!exitMethod);

        return exitProgram;
    }
}
