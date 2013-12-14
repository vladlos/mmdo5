package Methods;

import CalculationFunction.Function;

public class PiyavskyiLine extends Piyavskyi {
    public PiyavskyiLine(Function function) {
        super(function);
    }

    @Override
    protected double minorantZ0(double y1, double y2, double L) {
        return (y1 + y2 + (function.calculate(y1) - function.calculate(y2))/L)/2;
    }

    @Override
    protected double minorantZF0(double z, double x, double L) {
        return function.calculate(x) - L * (z-x);
    }
}
