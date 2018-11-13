import java.util.Scanner;
/**
 * client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //eval constructor.
    }
    /**
     * maim method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        //Your code goes here...
        TST<Integer> tst = new TST<Integer>();
        Scanner scan = new Scanner(System.in);
        String prefix = scan.nextLine();
        int j = 0;
        for (String each : words) {
            SuffixArray suffArray = new SuffixArray(each);
            for (int i = 0; i < each.length(); i++) {
                tst.put(suffArray.select(i), j++);
            }
        }
        for (String each : tst.keysWithPrefix(prefix)) {
            System.out.println(each);
        }
    }
    /**
     * Loads words.
     *
     * @return  words.
     */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        return in.readAllStrings();
    }
}
