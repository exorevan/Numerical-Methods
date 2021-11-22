public class EulerRunge {
    public static void main(String[] args) {
        // find solving for differential equation (y' = (x + y) / x) where y(1) = 0 with Euler's method and Runge–Kutta method
        double a = 1;
        double b = 2;
        double h = 0.05;
        double n = (b - a) / h;
        double[] x = new double[(int) n + 1];
        double[] y = new double[(int) n + 1];
        double k1, k2, k3, k4;

        x[0] = a;
        y[0] = 0;
        x[(int) n] = b;

        for (int i = 0; i < n; i++) {
            x[i] = x[0] + i * h;
            y[i + 1] = y[i] + h * f(x[i], y[i]);
        }

        System.out.print("Euler's method solution\n\n");

        for (int i = 0; i <= n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i] + "\t\t" + "y" + (i + 1) + " = " + y[i]);
        }

        System.out.print("\n\nRunge–Kutta method:\n\n");

        for (int i = 0; i < n; i++) {
            k1 = f(x[i], y[i]);
            k2 = f(x[i] + h / 2, y[i] + h / 2 * k1);
            k3 = f(x[i] + h / 2, y[i] + h / 2 * k2);
            k4 = f(x[i] + h, y[i] + h * k3);

            y[i + 1] = y[i] + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
        }

        for (int i = 0; i <= n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i] + "\t\t" + "y" + (i + 1) + " = " + y[i]);
        }
    }

    static double f(double x, double y) {
        return (x + y) / x;
    }
}
