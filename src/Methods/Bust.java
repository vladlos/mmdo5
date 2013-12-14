package Methods;

import CalculationFunction.Function;

public abstract class Bust extends GlobalMinimum{
    protected Bust(Function function) {
        super(function);
    }

    protected abstract double nextPoint(double h, double x0, double f0, double f, double L);

    @Override
    public double findMin(double leftBound, double rightBound, double L, double  eps) {
        resetCounter();
        double h = (2*eps) / L;
        double x0 = leftBound + h /2;
        double f0 = function.calculate(x0);
        double x = x0;
        double f = f0;
        do {
            x0 = nextPoint(h, x0, f0, f, L);
            if (x0 > rightBound) {
                x0 = rightBound;
            }
            f0 = function.calculate(x0);
            if (f > f0) {
                f = f0;
                x = x0;
            }
            countIter++;
        } while (x0 != rightBound);
        countCalc = function.getCountCalc();
        return x;
    }
}
