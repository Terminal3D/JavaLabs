public class Matrix {
    private final int m;
    private final int n;
    private final double[][] array2d;

    public Matrix(int rows, int cols) {
        this.m = rows;
        this.n = cols;
        array2d = new double[rows][cols];
    }

    public Matrix(double[][] data) {
        m = data.length;
        n = data[0].length;
        this.array2d = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                array2d[i][j] = data[i][j];
    }



    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.array2d[i][j] = Math.random();
        return A;
    }

    public void show() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%9.5f ", array2d[i][j]);
            System.out.println();
        }
    }

    public boolean isSaddlePoint(int row, int col) {
        double element = array2d[row - 1][col - 1];
        for (int i = 0; i < m; i++) {
            if (array2d[i][col - 1] > element) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            if (array2d[row - 1][j] < element) {
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return "Result for element at pos (3;1): " + isSaddlePoint(3, 1);
    }


}