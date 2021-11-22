import java.util.ArrayList;

public class HalfDivisionMethod {
    private static final double eps = 0.001;
    private static final ArrayList<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        // after we find 4 approximation intervals for the equation (x^4 - 18*x^2 + 6 = 0)
        // we'll look for a root with half division method in each of them
        find(-10, -3);
        find(-3, 0);
        find(0, 3);
        find(3, 10);

        list.forEach((k) -> System.out.println(String.format("%.3f", k) + " "));
    }

    // half division method
    public static void find(double a, double b) {
        double middle = (a + b) / 2.0;

        if (Math.abs(a - b) > eps) {
            if (function(a) * function(middle) < 0) {
                find(a, middle);
            }
            if (function(middle) * function(b) < 0) {
                find(middle, b);
            }
        } else {
            if (!list.contains(middle) && function(a) * function(b) < 0) {
                list.add(middle);
            }
        }
    }

    // function itself
    public static double function(double x) {
        return Math.pow(x, 4) - 18 * Math.pow(x, 2) + 6;
    }
}
