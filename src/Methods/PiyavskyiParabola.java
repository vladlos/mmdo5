package Methods;

import CalculationFunction.Function;

public class PiyavskyiParabola extends Piyavskyi {
    Function grad;

    public PiyavskyiParabola(Function function, Function grad) {
        super(function);
        this.grad = grad;
    }

    @Override
    protected double minorantZ0(double y1, double y2, double L) {
        double t1 = 2 * firstSimple(y2, L) - 2 * firstSimple(y1, L) -
                L * secondSimple(y2, L) * secondSimple(y2, L) + L *
                secondSimple(y1, L) * secondSimple(y1, L);
        double t2 = 2 * L * secondSimple(y1, L) - 2 * L * secondSimple(y2, L);
        return t1 / t2;
    }

    @Override
    protected double minorantZF0(double z, double x, double L) {
        return firstSimple(x, L) - (L / 2) * (z - secondSimple(x, L)) *
                (z - secondSimple(x, L));
    }

    private double firstSimple(double x, double L) {
        return function.calculate(x) + (1 / (2 * L)) * Math.abs(grad.calculate(x));
    }

    private double secondSimple(double x, double L) {
        return x + (1 / L) * grad.calculate(x);
    }
}
