/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * { var_description }.
	 */
	Digraph tempDigraph;
	/**
	 * { var_description }.
	 */
	double[] initialPageRank;
	/**
	 * { var_description }.
	 */
	double[] updatedPageRanks;
	/**
	 * { var_description }.
	 */
	int[] inDegreeforVertex;

	/**
	 * Constructs the object.
	 *
	 * @param      digraph  The digraph
	 */
	PageRank(final Digraph digraph) {
		initialPageRank = new double[100];
		updatedPageRanks = new double[100];
		inDegreeforVertex = new int[100];
		this.tempDigraph = digraph;
		for (int i = 0; i < digraph.V(); i++) {
			initialPageRank[i] = 1.0 / tempDigraph.V();
			updatedPageRanks[i] = getPageRank(i);
			//System.out.println(updatedPageRanks[i]);
		}
		display();
	}
	/**
	 * { function_description }.
	 */
	public void display() {
		for (int i = 0; i < tempDigraph.V(); i++) {
			System.out.println(i  + " - " + updatedPageRanks[i]);
		}
	}
	/**
	 * Gets the page rank.
	 *
	 * @param      v     { parameter_description }.
	 *
	 * @return     The page rank.
	 */
	public double getPageRank(int v) {
		for (int i = 0; i < tempDigraph.V(); i++) {
			initialPageRank[i] = 1.0 / tempDigraph.V();
			inDegreeforVertex[i] = tempDigraph.indegree(v);
			if (inDegreeforVertex[i] == 0.0) {
				return 0.0;
				// } else if (tempDigraph.indegree(v) > 1) {
				// 	int k = tempDigraph.indegree(v);
				// 	for (int j = 0; j < k - 1; j++) {
				// 		double y = initialPageRank[j] / inDegreeforVertex[j] ;
				// 		return y;
				// 	}
			} else {
				double y = initialPageRank[i] / tempDigraph.outdegree(inDegreeforVertex[i]);
				return y;
			}
		}
		return -12.1;
	}

}
/**
 * Class for web search.
 */
class WebSearch {

}

/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		In scan = new In();
		// read the first line of the input to get the number of vertices
		int numOfVertices = Integer.parseInt(scan.readLine());
		Digraph digraphObj = new Digraph(numOfVertices);
		while (numOfVertices > 0) {
			String[] tokens = scan.readLine().split(" ");
			int v = Integer.parseInt(tokens[0]);
			for (int i = 1; i < tokens.length; i++) {
				//System.out.println(v+"\t"+i);
				digraphObj.addEdge(v, Integer.parseInt(tokens[i]));
			}
			numOfVertices--;
		}
		System.out.println(digraphObj);
		//System.out.println();
		PageRank pageRankObj = new PageRank(digraphObj);
		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
