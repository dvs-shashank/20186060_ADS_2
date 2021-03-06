import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * { var_description }
	 */
	private Digraph gr;
	/**
	 * { var_description }
	 */
	private Digraph revdg;
	/**
	 * { var_description }
	 */
	private int vertices;
	/**
	 * { var_description }
	 */
	private Double[] pr;


	/**
	 * Constructs the object.
	 *
	 * @param      digraph  The digraph
	 */

	PageRank(final Digraph gr) {
		this.gr = gr;
		this.revdg = gr.reverse();
		this.vertices = gr.V();
		pr = new Double[vertices];
		int ver = gr.V();
		for (int i = 0; i < vertices; i++) {
			pr[i] = 1.0 / ver;
		}
		prCalculation();
	}

	public void prCalculation() {
		for (int i = 0; i < vertices; i++) {
			if (gr.outdegree(i) == 0) {
				for (int j = 0; j < vertices; j++) {
					if (i != j) {
						gr.addEdge(i, j);
					}
				}
			}
		}
		final int thousand = 1000;
		for (int k = 1; k < thousand; k++) {
			Double[] temppr = new Double[vertices];
			for (int i = 0; i < vertices; i++) {
				Double newpr = 0.0;
				for (int ele : gr.reverse().adj(i)) {
					newpr = newpr
					        + pr[ele] / gr.outdegree(ele);
				}
				temppr[i] = newpr;
			}
			pr = temppr;
		}
	}

	public Double getPageRank(final int v) {
		return pr[v];
	}
	/**.
	 * method to printer
	 */
	public void display() {
		for (int i = 0; i < vertices; i++) {
			System.out.println(i + " - " + pr[i]);
		}
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
		Scanner scan = new Scanner(System.in);
		// read the first line of the input to get the number of vertices
		int numOfVertices = Integer.parseInt(scan.nextLine());
		Digraph diobj = new Digraph(numOfVertices);
		for (int i = 0; i < numOfVertices; i++) {
			String[] tokens = scan.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				int v = Integer.parseInt(tokens[0]);
				int adj = Integer.parseInt(tokens[j]);
				diobj.addEdge(v, adj);
			}

			// iterate count of vertices times
			// to read the adjacency list from std input
			// and build the graph
		}
		System.out.println(diobj.toString());
		PageRank probj = new PageRank(diobj);

		// Create page rank object and pass the graph object to the constructor

		// print the page rank object
		probj.display();

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