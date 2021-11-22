public class IterationsToSystem {
    public static double eps = 0.0001;

    public static void main(String[] args) {
        // here we will solve the system of non-linear equations with simple iterations method
        double x = 5;

        simpleIteration(x, x);
    }

    private static void simpleIteration(double x0, double y0) {
        /**
         * to solve this system we must rewrite it to format xi = fi(x1, x2, ..., x(i - 1), x(i + 1))
         */

        double x = x0 - 1;
        double y = y0 - 1;

        while (eps < Math.abs(x - x0) || eps < 10 * Math.abs(y - y0)) {
            x0 = x;
            y0 = y;

            x = fi1(x0, y0);
            y = fi2(x0, y0);
        }

        System.out.println(x);
        System.out.println(y);
        System.out.println("\n");
    }

    public static double fi1(double x, double y) {
        return Math.cos(x) / 2;
    }

    public static double fi2(double x, double y) {
        return Math.sin(x + 1) - 1.2;
    }
}

