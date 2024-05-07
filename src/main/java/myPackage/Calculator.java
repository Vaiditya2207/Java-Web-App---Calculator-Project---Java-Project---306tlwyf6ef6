package myPackage;

public class Calculator {
    private Addition addition;
    private Subtraction subtraction;
    private Multiplication multiplication;
    private Division division;

    public Calculator() {
        this.addition = new Addition();
        this.subtraction = new Subtraction();
        this.multiplication = new Multiplication();
        this.division = new Division();
    }

    public double performOperation(double operand1, double operand2, String operation) {
        switch (operation) {
            case "add":
                return addition.add(operand1, operand2);
            case "subtract":
                return subtraction.subtract(operand1, operand2);
            case "multiply":
                return multiplication.multiply(operand1, operand2);
            case "divide":
                return division.divide(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}