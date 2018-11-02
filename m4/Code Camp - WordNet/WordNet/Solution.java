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
		String synsetFileName = scan.readLine();
		String hypernymFileName = scan.readLine();
		String implementationType = scan.readLine();
		if (implementationType.equals("Graph")) {
			WordNet wordNet = new WordNet(synsetFileName, hypernymFileName);
		} else {
			WordNet wordNetObject = new WordNet(synsetFileName, hypernymFileName);
			String[] queryNames = scan.readLine().split(" ");
			for (int i = 0; i < queryNames.length; i++) {
				if (queryNames[i].equals("null")) {
					System.out.println("IllegalArgumentException");
					return;
				} else {
					System.out.println("distance = " + wordNetObject.distance(queryNames[0],queryNames[1]));
					//System.out.println("ancestors = " + wordNetObject.ancestor(queryNames[0],queryNames[1]));
				}
			}
		}
		//wordNet.display();
	}
}