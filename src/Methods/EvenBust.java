package Methods;

import CalculationFunction.Function;

public class EvenBust extends Bust{
    public EvenBust(Function function) {
        super(function);
    }

    @Override
    protected double nextPoint(double h, double x0, double f0, double f, double L) {
        return  x0 + h;
    }
}
