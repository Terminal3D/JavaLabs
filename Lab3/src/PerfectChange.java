import java.lang.Math;
import java.text.DecimalFormat;

public class PerfectChange implements Comparable<PerfectChange> {
    private final Money summa;
    private final int banknotes_num;
    private final int bills;
    private final int coins;
    public PerfectChange(double money) {

        DecimalFormat df = new DecimalFormat("#.00");
        String result = df.format(money);
        int fractionalPart = Integer.parseInt(result.split("\\.")[1]);
        this.summa = new Money((int)money, fractionalPart);
        this.bills = summa.getBills();
        this.coins = summa.getCents();
        this.banknotes_num = banknotesCalc(this.summa);

    }

    private int[] banknotes = new int[15];

    public int banknotesCalc(Money value) {
        int counter = 0;

        while (value.getBills() != 0 || value.getCents() != 0) {
            if (value.getBills() >= 5000) {
                value.addBills(-5000);
                banknotes[0]++;
                counter++;
            }
            else if (value.getBills() >= 2000) {
                value.addBills(-2000);
                banknotes[1]++;
                counter++;
            }
            else if (value.getBills() >= 1000) {
                value.addBills(-1000);
                banknotes[2]++;
                counter++;
            } else if (value.getBills() >= 500) {
                value.addBills(-500);
                banknotes[3]++;
                counter++;
            } else if (value.getBills() >= 200) {
                value.addBills(-200);
                banknotes[4]++;
                counter++;
            } else if (value.getBills() >= 100) {
                value.addBills(-100);
                banknotes[5]++;
                counter++;
            } else if (value.getBills() >= 50) {
                value.addBills(-50);
                banknotes[6]++;
                counter++;
            } else if (value.getBills() >= 10) {
                value.addBills(-10);
                banknotes[7]++;
                counter++;
            } else if (value.getBills() >= 5) {
                value.addBills(-5);
                banknotes[8]++;
                counter++;
            } else if (value.getBills() >= 2) {
                value.addBills(-2);
                banknotes[9]++;
                counter++;
            } else if (value.getBills() >= 1) {
                value.addBills(-1);
                banknotes[10]++;
                counter++;
            } else if (value.getCents() >= 50) {
                value.addCents(-50);
                banknotes[11]++;
                counter++;
            } else if (value.getCents() >= 10) {
                value.addCents(-10);
                banknotes[12]++;
                counter++;
            } else if (value.getCents() >= 5) {
                value.addCents(-5);
                banknotes[13]++;
                counter++;
            } else if (value.getCents() >= 1) {
                value.addCents(-1);
                banknotes[14]++;
                counter++;
            }
            else break;
        }
    return counter;
    }
    public String toString() {
        return
                ("Сумма " + bills + "." + coins + " разбивается на "  + banknotes_num + " купюр и монет. \nРазбиение:\n" +
                        "Купюр 5000: " + banknotes[0] +
                        "\nКупюр 2000: " + banknotes[1] +
                        "\nКупюр 1000: " + banknotes[2] +
                        "\nКупюр 500: " + banknotes[3] +
                        "\nКупюр 200: " + banknotes[4] +
                        "\nКупюр 100: " + banknotes[5] +
                        "\nКупюр 50: " + banknotes[6] +
                        "\nКупюр 10: " + banknotes[7] +
                        "\nМонет 5: " + banknotes[8] +
                        "\nМонет 2: " + banknotes[9] +
                        "\nМонет 1: " + banknotes[10] +
                        "\nМонет 0.5: " + banknotes[11] +
                        "\nМонет 0.1: " + banknotes[12] +
                        "\nМонет 0.05: " + banknotes[13] +
                        "\nМонет 0.01: " + banknotes[14]
                        );
    }

    public int compareTo(PerfectChange obj){
        if (this.banknotes_num == obj.banknotes_num) return 0;
        else return obj.banknotes_num - this.banknotes_num;
    }
}
