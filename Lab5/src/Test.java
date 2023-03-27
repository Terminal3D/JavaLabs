import java.util.stream.*;

public class Test {
    public static void main(String[] args) {

        ListOfProgressions List = new ListOfProgressions();
        List.ListAdd(1, 2);
        List.ListAdd(30, 20);
        List.ListAdd(10, 5);
        List.ListAdd(0, 100);
        List.ListAdd(2, 2);

        System.out.println(List.PowerTwoFinder(10).getProgression());
        Stream<ArithmeticProgression> stream1 = List.InitStream(10, 1000);
        stream1.forEach(x -> System.out.println(x.getProgression()));
    }
}
