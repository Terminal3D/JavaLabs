import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        PerfectChange[] array = new PerfectChange[] {
                new PerfectChange(193000),
                new PerfectChange(33245.42),
                new PerfectChange(59043.2),

        };
        Arrays.sort(array);
        for (PerfectChange item : array) {
            System.out.println(item);
        }
    }
}