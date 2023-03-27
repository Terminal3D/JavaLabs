import java.util.ArrayList;
import java.lang.Math;

public class Universe {

    public static class Item {
        static int count = 0;
        private final String item_name;
        private final double mass, x, y, z;
        Item(String item_name, double mass, double x, double y, double z) {
            this.item_name = item_name;
            this.mass = mass;
            this.x = x;
            this.y = y;
            this.z = z;
            count++;
        }
        public double getX() { return this.x; }
        public double getY() { return this.y; }
        public double getZ() { return this.z; }

        public double getMass() { return this.mass; }
        public String getName() { return this.item_name; }

    }
    final static double g_const = 6.67 * Math.pow(10, -11);

    private static double getDistance(Item A, Item B) {
        return Math.sqrt(Math.pow((A.getX() - B.getX()), 2) +
                        Math.pow((A.getY() - B.getY()), 2) +
                        Math.pow((A.getZ() - B.getZ()), 2));
    }
    private static double getForce(Item A, Item B) {
        return g_const * A.getMass() * B.getMass() / getDistance(A, B);
    }

    public static void FindMin(ArrayList<Item> list) {
        double min_force = 0;
        int min_force_num = 0;
        for (int i = 0; i < Universe.Item.count; i++) {
            double cur_force = 0;
            for (int j = 0; j < Universe.Item.count; j++) {

                if (j != i) {
                    cur_force += getForce(list.get(i), list.get(j));
                }
            }

            if (cur_force < min_force || min_force == 0) {
                min_force = cur_force;
                min_force_num = i;
            }
        }

        System.out.println("На частицу " + list.get(min_force_num).getName() + " действует наименьшая сила, равная " + min_force);

    }

}