import java.util.ArrayList;
import java.util.stream.Stream;

public class ListOfProgressions {
    private ArrayList<ArithmeticProgression> list = new ArrayList<>();

    public void ListAdd (int a0, int d) {
        ArithmeticProgression tmp = new ArithmeticProgression(a0, d);
        list.add(tmp);
    }
    public void ListAdd (ArithmeticProgression progression) {
        list.add(progression);
    }
    public void ListRemove (int index) {
        list.remove(index);
    }

    public ArithmeticProgression ListGet (int index) {
        return list.get(index);
    }

    public int ListGetSize() {
        return list.size();
    }


    public ArithmeticProgression PowerTwoFinder(int n) {
        for (ArithmeticProgression t : list) {
            for (int i = 0; i <= n; i++) {
                int cur = t.a0 + t.d * i;
                if (isPowerOfTwo(cur))
                    return t;
            }
        }
        System.out.println("Нет таких последовательностей.");
        return list.get(0);
    }

    public static boolean isPowerOfTwo(int number) {
        if (number <= 1) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }


    public Stream<ArithmeticProgression> InitStream(int n, int t) {
        ArrayList<ArithmeticProgression> result = new ArrayList<>();
        list.stream()
                .filter(x -> x.calcProgressionSum(n) < t)
                .forEach(result::add);
        return result.stream();
    }



}
