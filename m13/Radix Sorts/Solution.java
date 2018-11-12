import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner rashmika = new Scanner(System.in);
        int numOfInputs = Integer.parseInt(rashmika.nextLine());
        String[] eachInput = new String[numOfInputs];
        for (int i = 0; i < eachInput.length; i++) {
            eachInput[i] = rashmika.nextLine();
        }
        //while(numOfInputs > 0) {
        //  eachInput[numOfInputs] = rashmika.nextLine();
        //  numOfInputs--;
        // }
        LSD lsdObj = new LSD();
        lsdObj.sort(eachInput, eachInput[0].length());
        System.out.println(Arrays.toString(eachInput));
        //System.out.println(msdObject);
    }
}