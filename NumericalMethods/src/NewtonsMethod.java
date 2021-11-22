public class NewtonsMethod {
    private static final double eps = 0.001;

    // in this program I found the root of the equation (lg(x) - 5 / (3*x + 2) = 0) with 2 different methods (simple iterations and Newton's method)
    public static void main(String[] args) {
        double x = 5;

        simpleIteration(x); // simple iterations method
        methodNewtons(x); // Newton's method
    }

    private static void simpleIteration(double x0) {
        /**
         * In the chart we can see that the root is in interval between 0.5 and 5
         * So that f(0,5) = -0.92 and f(2) = 1.375 there's 1 root in this interval
         * m = min f'(x) | 1, 0.5 = 0.45 (the minimum in this interval)
         * M = max f'(x) | 1, 0.5 = 2.09 (the maximum in this interval)
         * g(x) = x - 1/M * f(x) = x - (log10(x) - 5 / (3 * x + 2.0)) / 2.09
         * q = 1 - m/M = 0.78 > 0.5. It means we must increase the precision 10 times
         */

        double x = x0 - 1;

        while (eps < Math.abs(x - x0) * 10) {
            x0 = x;
            x = fi(x);
        }

        System.out.println(x);
    }

    private static void methodNewtons(double x0) {
        /**
         * Newton's method is a particular case of simple iterations method
         * so the calculations are the same
         */

        double x = x0 - 1;

        while (eps < Math.abs(x - x0) * 10) {
            x0 = x;
            x = x - f(x) / df(x);
        }

        System.out.println(x);
    }

    public static double f(double x) { // f(x)
        return Math.log10(x) - 5 / (3 * x + 2.0);
    }

    public static double df(double x) { // df(x)
        return 15 / Math.pow(3 * x + 2, 2) + 1 / (x * Math.log(10));
    }

    public static double fi(double x) { // g(x)
        return x - f(x) / 2.09;
    }
}
