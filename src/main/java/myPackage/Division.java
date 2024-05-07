package myPackage;

public class Division {
    public double divide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return operand1 / operand2;
    }
}