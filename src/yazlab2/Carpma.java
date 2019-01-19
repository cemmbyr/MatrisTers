
package yazlab2;

public class Carpma {

    public double[][] carpma(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalStateException("invalid dimensions");
        }

        double[][] matrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < a[i].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                matrix[i][j] = sum;
            }
        }

        return matrix;
    }
}
