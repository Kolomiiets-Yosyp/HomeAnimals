public class Calculator {
    @FunctionalInterface
    interface MathOperation {
        int operation(int number1, int number2);
    }

    public int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    void addition() {
        MathOperation additionOp = (number1, number2) -> number1 + number2;
        System.out.println("5 cats + 10 cats = " + operate(5, 10, additionOp) + " cats");
    }

    public void subtraction() {
        MathOperation subtractionOp = (number1, number2) -> number1 - number2;
        System.out.println("20 dogs - 10 dogs = " + operate(20, 10, subtractionOp) + " dogs");
    }

    void multiplication() {
        MathOperation multiplicationOp = (number1, number2) -> number1 * number2;
        System.out.println("5 fish * 2 fish = " + operate(5, 2, multiplicationOp) + " fish");
    }

    public void division() {
        MathOperation divisionOp = (number1, number2) -> number1 / number2;
        System.out.println("10 guinea pigs / 2 cages = " + operate(10, 2, divisionOp) + " guinea pigs");
    }
}
