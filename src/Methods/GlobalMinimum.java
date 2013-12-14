package Methods;

import CalculationFunction.Function;

public abstract class GlobalMinimum {
    protected Function function;
    protected int countIter = 0;
    protected int countCalc = 0;

    public double getValueFunction(double x) {
        return function.calculate(x);
    }

    public String getFunction() {
        return function.getFunct();
    }

    public int getCountCalc() {
        return countCalc;
    }

    public int getCountIter() {
        return countIter;
    }

    protected void resetCounter() {
        function.resetCounter();
    }

    protected GlobalMinimum(Function function) {
        this.function = function;
    }

    public abstract double findMin(double leftBound, double rightBound, double l, double  eps);
}
