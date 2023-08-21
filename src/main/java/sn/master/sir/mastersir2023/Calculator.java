package sn.master.sir.mastersir2023;

public class Calculator {

    private int a;
    private int b;

    // Add two numbers
    public int add() {
        return a + b;
    }

    // Subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divide two numbers
    public int divide(int a, int b) {
        return a / b;
    }

    // Getters and Setters
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
