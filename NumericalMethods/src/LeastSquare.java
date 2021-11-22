public class LeastSquare {
    public static void main(String[] args) {
        double k, b;
        double a2, b2, c2;
        double n = 10;

        double determinant, determinant1, determinant2, determinant3;

        double[] y = new double[(int) n];
        double[] x = new double[(int) n];

        double summaX = 0.0;
        double summaX2 = 0.0;
        double summaX3 = 0.0;
        double summaX4 = 0.0;
        double summaY = 0.0;
        double summaXY = 0.0;
        double summaX2Y1 = 0.0;

        x[0] = 3;

        for (int i = 1; i < 10; i++) {
            x[i] = x[i - 1] + 0.5;
        }

        y[0] = 25;
        y[1] = 28;
        y[2] = 30;
        y[3] = 32;
        y[4] = 36;
        y[5] = 39;
        y[6] = 41;
        y[7] = 44;
        y[8] = 46;
        y[9] = 47;

        for (int i = 0; i < n; i++) {
            summaX += x[i];
            summaX2 += (x[i] * x[i]);
            summaX3 += (x[i] * x[i] * x[i]);
            summaX4 += (x[i] * x[i] * x[i] * x[i]);

            summaY += y[i];
            summaXY += (x[i] * y[i]);
            summaX2Y1 += (x[i] * x[i] * y[i]);
        }

        // find k and b with Kramer's method
        determinant = summaX2 * n - summaX * summaX;

        determinant1 = summaXY * n - summaY * summaX;
        determinant2 = summaX2 * summaY - summaX * summaXY;

        k = determinant1 / determinant;
        b = determinant2 / determinant;

        System.out.println("Parameters of linear regression for this table function:");
        System.out.println("k = " + k);
        System.out.println("b = " + b);

        System.out.println("System 1");
        System.out.println(10 + " * b + " + summaX + " * k = " +  summaY);
        System.out.println(summaX + " * b + " + summaX2 + " * k = " +  summaXY + "\n");


        determinant = summaX4 * (summaX2 * n - summaX * summaX) - summaX3 * (summaX3 * n - summaX2 * summaX) + summaX2 * (summaX3 * summaX - summaX2 * summaX2);
        //determinant3 = a11 *   (a22    * a33 - a32   *      a23) - a21     * (a12     * a33 - a13   *     a32) + a31     * (a12     * a23     - a13     * a22);
        determinant1 = summaX2Y1 * (summaX2 * n - summaX *  summaX) - summaXY * (summaX3 * n - summaX2 * summaX) + summaY * (summaX3 * summaX - summaX2 * summaX2);
        determinant2 = summaX4 * (summaXY * n - summaY *  summaX) - summaX3 * (summaX2Y1 * n - summaX2 * summaY) + summaX2 * (summaX2Y1 * summaX - summaX2 * summaXY);
        determinant3 = summaX4 * (summaX2 * summaY - summaX *  summaXY) - summaX3 * (summaX3 * summaY - summaX2Y1 * summaX) + summaX2 * (summaX3 * summaXY - summaX2Y1 * summaX2);

        a2 = determinant1 / determinant;
        b2 = determinant2 / determinant;
        c2 = determinant3 / determinant;

        System.out.println("symaX" + summaX);
        System.out.println(summaX2);
        System.out.println(summaX3);
        System.out.println(summaX4);
        System.out.println(summaY);
        System.out.println(summaXY);
        System.out.println(summaX2Y1);
        System.out.println(determinant);
        System.out.println(determinant1);
        System.out.println(determinant2);
        System.out.println(determinant3);

        System.out.println("Parameters of square regression for this table function:");
        System.out.println("a = " + a2);
        System.out.println("b = " + b2);
        System.out.println("c = " + c2);

        System.out.println("System 2");
        System.out.println(summaX4 + " * a + " + summaX3 + " * b + " + summaX2 + " * c = " +  summaX2Y1);
        System.out.println(summaX3 + " * a + " + summaX2 + " * b + " + summaX + " * c = " +  summaXY);
        System.out.println(summaX2 + " * a + " + summaX + " * b + " + n + " * c = " +  summaY);
    }
}
