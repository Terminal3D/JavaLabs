public class Test {
    public static void main(String[] args) {
        Matrix D = Matrix.random(5, 5);
        D.show();
        System.out.println(D);

        double[][] matrixData = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix C = new Matrix(matrixData);
        C.show();
        System.out.println(C);
    }
}

