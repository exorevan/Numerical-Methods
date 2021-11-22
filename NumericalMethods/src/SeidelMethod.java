public class SeidelMethod {
    public static double eps = 0.0001;

    public static void main(String[] args) {
        /**
         * Here we will solve the system of linear equations with Seidel's method
         * Lets rewrite the system in format (xi = fi(x1, x2, ..., x(i - 1), x(i + 1)))
         * x1 =           -0.33 * x2  + 0.33 * x3 + 1
         * x2 = 0.5 * x1              + 0.25 * x3 + 0.25
         * x3 = 0.25 * x1 + 0.25 * x2             +0.5
         */
        double x = 0;

        simpleIteration(x, x, x);
        methodSeidel(x, x, x);
    }

    public static void simpleIteration(double x01, double x02, double x03) {
        double x1 = x01 - 1;
        double x2 = x02 - 1;
        double x3 = x03 - 1;

        while (eps < Math.abs(x1 - x01) || eps < 10 * Math.abs(x2 - x02) || eps < 10 * Math.abs(x3 - x03)) {
            x01 = x1;
            x02 = x2;
            x03 = x3;

            x1 = fi1(x01, x02, x03);
            x2 = fi2(x01, x02, x03);
            x3 = fi3(x01, x02, x03);
        }

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3 + "\n");
    }

    private static void methodSeidel(double x01, double x02, double x03) {
        double x1 = x01 - 1;
        double x2 = x02 - 1;
        double x3 = x03 - 1;

        while (eps < Math.abs(x1 - x01) || eps < 10 * Math.abs(x2 - x02) || eps < 10 * Math.abs(x3 - x03)) {
            x01 = x1;
            x02 = x2;
            x03 = x3;

            x1 = fi1(x1, x2, x3);
            x2 = fi2(x1, x2, x3);
            x3 = fi3(x1, x2, x3);
        }

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
    }


    public static double fi1(double x1, double x2, double x3) {
        return -0.33 * x2 + 0.33 * x3 + 1;
    }

    public static double fi2(double x1, double x2, double x3) {
        return 0.5 * x1 + 0.25 * x3 + 0.25;
    }

    public static double fi3(double x1, double x2, double x3) {
        return 0.25 * x1 + 0.25 * x2 + 0.5;
    }
}