import java.util.ArrayList;

public class Test {
    public static void main(String[] args){

        ArrayList<Universe.Item> list = new ArrayList<Universe.Item>();
        Universe.Item Earth = new Universe.Item("Earth", 3.4, 1, 3, 5);
        list.add(Earth);
        Universe.Item Mars = new Universe.Item("Mars", 4, 5, 7, 8);
        list.add(Mars);
        Universe.Item CentauraA = new Universe.Item("Centaura A", 4, 56, 7, 8);
        list.add(CentauraA);
        Universe.Item Andromeda = new Universe.Item("Andromeda", 87, 32, 4, 7);
        list.add(Andromeda);
        Universe.Item Pluto = new Universe.Item("Pluto", 1, 5, 7, 3);
        list.add(Pluto);
        Universe.FindMin(list);

    }
}
