/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//eval purpose constructor.
	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		In scan = new In();
		String synsetFileName = scan.readString();
		String hypernymFileName = scan.readString();
		String implementationType = scan.readString();
		if (implementationType.equals("Graph")) {
			WordNet wordNet = new WordNet(synsetFileName, hypernymFileName);
		} else {

		}
	}
}