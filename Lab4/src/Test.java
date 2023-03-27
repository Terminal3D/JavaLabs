import java.util.Iterator;

public class Test  {
    public static void main(String[] args) {
        StringBuilder Str = new StringBuilder("abracadabra");
        MutableSubstringIterator St = new MutableSubstringIterator(Str, "abra");
        Iterator<Integer> iterator = St.iterator();
        System.out.println(St.getString());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        St.StringAppend("abra");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(St.getString());

    }
}
