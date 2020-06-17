import java.util.EnumMap;
import java.util.EnumSet;

enum Pebble {
    Red,
    White,
    Blue
}
public class PebbleBuckets {
    public PebbleBuckets(int N) {
        pebbles = new Pebble[N];
        for(int i = 0; i < N; i++) {
            switch(i % 3) {
                case 0:
                    pebbles[i] = Pebble.Red;
                    break;
                case 1:
                    pebbles[i] = Pebble.White;
                    break;
                case 2:
                    pebbles[i] = Pebble.Blue;
                    break;
            }
        }
    }

    private Pebble[] pebbles;

    private Pebble color(int i) {
        return pebbles[i];
    }

    private int compare(Pebble b) {
        Pebble white = Pebble.White;
        return b.ordinal() - white.ordinal();
    }

    private void swap(int i, int j) {
        Pebble tmp = pebbles[i];
        pebbles[i] = pebbles[j];
        pebbles[j] = tmp;
    }

    public void sort() {
        assert pebbles.length > 0;
        int i = 0, len = pebbles.length - 1, r = 0;
        while (i <= len) {
            Pebble color = color(i);
            int cmp = compare(color);
            if(cmp < 0) {
                swap(i++, r++);
                System.out.println("i = " + i + ", r = " + r + ", len = " + len);
                printResult();
            }
            else if (cmp > 0) {
                swap(i, len--);
                System.out.println("i = " + i + ", r = " + r + ", len = " + len);
                printResult();
            }
            else {
                i++;
                System.out.println("i = " + i + ", r = " + r + ", len = " + len);
                printResult();
            }
        }
    }

    public void printResult() {
        for(int i = 0; i < pebbles.length; i++){
            System.out.print(pebbles[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        PebbleBuckets test = new PebbleBuckets(9);
        test.sort();
        test.printResult();
    }
}