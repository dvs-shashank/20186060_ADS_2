import java.util.Scanner;
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
		while(numOfInputs > 0) {
			eachInput[numOfInputs] = rashmika.nextLine();
			numOfInputs--;
		}
		MSD msdObject = new MSD();
		msdObject.sort(eachInput);
		System.out.println(msdObject);
	}
}