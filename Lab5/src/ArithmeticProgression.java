
public class ArithmeticProgression {
    int a0;
    int d;

    public ArithmeticProgression (int a0, int d) {
        this.a0 = a0;
        this.d = d;
    }

    public int calcProgressionSum (int n) {
        int sum = a0;
        for (int i = 1; i <= n; i++) {
            sum += i * this.d;
        }
        return sum;
    }

    public String getProgression() {
        return a0 + " " + d;
    }


}