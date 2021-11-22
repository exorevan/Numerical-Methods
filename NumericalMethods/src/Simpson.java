public class Simpson {
    public static double N = 1;
    public static double i1;
    public static double i2;

    public static void main(String[] args) {
        // we'll find integral with 2 methods: trapezoid and Simpson's
        // 1.2  cos(0.07 * N + 0.5 * x)
        //  I   -------------========--  dx
        // 0.4        0.4 + Vx^2 + N
        double a = 0.4;
        double b = 1.2;
        double n, h;

        n = 6;
        h = (b - a)/n;

        trapezoid(a, b, h);
        simpson(a, b, h);

        System.out.println("\nThe difference between methods: " + Math.abs(i2 - i1));
    }

    public static void trapezoid(double a, double b, double h) {
        double x;
        double integral = 0;

        for (x = a + h; x < b; x += h) {
            integral += h * f(x);
        }

        integral += h * (f(a) + f(b)) / 2;
        i1 = integral;

        System.out.println("Trapezoid method: " + integral);
    }

    public static void simpson(double a, double b, double h) {
        double x;
        double integral = h/3 * (f(a) + f(b));
        int counter = 1;

        for (x = a + h; x < b; x += h) {
            if (counter % 2 == 0) {
                integral += h/3 * 2 * f(x);
            } else {
                integral += h/3 * 4 * f(x);
            }

            counter++;
        }

        i2 = integral;

        System.out.println("Simpson's method: " + integral);
    }

    public static double f(double x) {
        return (Math.cos(0.07 * N + 0.5 * x)) / (0.4 + Math.pow(Math.pow(x, 2) + N, 0.5));
    }
}
