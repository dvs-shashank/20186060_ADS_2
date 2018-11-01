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
			String[] queryNames = scan.readString().split(" ");
			for (int i = 0; i < queryNames.length; i++) {
				if (queryNames[i].equals("null")) {
					System.out.println("IllegalArgumentException");
				}
			}
		}
	}
}