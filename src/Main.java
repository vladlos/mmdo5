import CalculationFunction.Function;
import Methods.*;

public class Main {
    public static void test(GlobalMinimum minimize, double leftBound, double rightBound, double eps, double L) {
        System.out.println("-------------- >>>> " + minimize.getClass() + " <<<< --------------------");
        double minPoint = minimize.findMin(leftBound, rightBound, L, eps);
        double valueMin = minimize.getValueFunction(minPoint);
        System.out.println("Function = " + minimize.getFunction());
        System.out.println("MinPoint = " + minPoint + "\t");
        System.out.println("Values function = " + valueMin);
        System.out.println("Count calc = " + minimize.getCountCalc());
        System.out.println("Count iter = " + minimize.getCountIter());
        System.out.println("Esp = " + eps);
    }

    public static void main(String[] args) {
        Function function = new Function("pow(x,6) - 6*pow(x,2)+4*x-1");
        Function grad = new Function("6*pow(x,5)-12*x+4");

        GlobalMinimum[] methods = new GlobalMinimum[] {
                //new EvenBust(function),
                new ConsistentBust(function),
                //new PiyavskyiLine(function),
                //new PiyavskyiParabola(function, grad)
        };

        for (GlobalMinimum minimum : methods) {
            test(minimum, -2, 2, 1E-2, 172);
        }

        for (GlobalMinimum minimum : methods) {
            test(minimum, -2, 2, 1E-4, 172);
        }
    }
}
