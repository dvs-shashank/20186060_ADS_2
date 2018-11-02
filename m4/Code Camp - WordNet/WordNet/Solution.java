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
		try {
			if (implementationType.equals("Graph")) {
				WordNet wordNet = new WordNet(synsetFileName, hypernymFileName);
				wordNet.display();
				return;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//wordNet.display();
		}
		try {
			if (implementationType.equals("Queries")) {
				String[] queryNames = scan.readLine().split(" ");
				for (int i = 0; i < queryNames.length; i++) {
					if (queryNames[i].equals("null")) {
						throw new Exception("IllegalArgumentException");
						//return;
					}
					WordNet wordNetObject = new WordNet(synsetFileName, hypernymFileName);
					System.out.println("distance = " + wordNetObject.distance(queryNames[0], queryNames[1]) +
					                   ", ancestors = " + wordNetObject.sap(queryNames[0], queryNames[1]));
					//System.out.println("ancestors = " + wordNetObject.ancestor(queryNames[0],queryNames[1]));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//wordNet.display();
		}

	}
}