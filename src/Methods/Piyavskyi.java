package Methods;

import CalculationFunction.Function;

import java.util.ArrayList;
import java.util.List;

public abstract class Piyavskyi extends GlobalMinimum{
    protected Piyavskyi(Function function) {
        super(function);
    }

    protected abstract double minorantZ0(double y1, double y2, double L);
    protected abstract double minorantZF0(double z, double y, double L);

    @Override
    public double findMin(double leftBound, double rightBound, double L, double epsilon) {
        resetCounter();
        List<Double> y = new ArrayList<>();
        int sizeY = 3;
        y.add(leftBound);
        y.add((leftBound + rightBound) / 2);
        y.add(rightBound);

        List<Double> z = new ArrayList<>();
        List<Double> fz = new ArrayList<>();

        z.add(minorantZ0(y.get(0), y.get(1), L));
        fz.add(minorantZF0(z.get(0), y.get(0), L));

        z.add(minorantZ0(y.get(1), y.get(2), L));
        fz.add(minorantZF0(z.get(1), y.get(1), L));

        int i;
        double min;

        do {
            min = fz.get(0);
            int iMin = 0;

            y.add(0.0);
            z.add(0.0);
            fz.add(0.0);

            for (int k = 1; k < sizeY; k++) {
                if (min > fz.get(k)) {
                    min = fz.get(k);
                    iMin = k;
                }
            }
            i = 0;
            while (y.get(i) < z.get(iMin)) {
                i++;
            }

            for (int k = sizeY -1; k >= i; k--) {
                y.set(k+1, y.get(k));
            }

            y.set(i, z.get(iMin));

            z.set(iMin, minorantZ0(y.get(i - 1), y.get(i), L));
            fz.set(iMin, minorantZF0(z.get(iMin), y.get(i - 1), L));

            z.set(sizeY - 1, minorantZ0(y.get(i), y.get(i + 1), L));
            fz.set(sizeY - 1, minorantZF0(z.get(sizeY - 1), y.get(i), L));

            countIter++;
            sizeY++;
        } while (function.calculate(y.get(i))- min >= epsilon);

        countCalc = function.getCountCalc();
        return y.get(i);
    }
}
