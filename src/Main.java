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
        Function function = new Function("sin(x)+sin(2*x)");
        Function grad = new Function("cos(x)/x - sin(x)/(pow(x,2))");

        GlobalMinimum[] methods = new GlobalMinimum[] {
                new EvenBust(function),
                new ConsistentBust(function),
                new PiyavskyiLine(function),
                //new PiyavskyiParabola(function, grad)
        };

        for (GlobalMinimum minimum : methods) {
            test(minimum, 0, 6, 1E-2, 0.5);
        }

        for (GlobalMinimum minimum : methods) {
            test(minimum, 2, 13, 1E-4, 0.5);
        }
    }
}
