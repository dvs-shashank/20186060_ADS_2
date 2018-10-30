import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
	public int V();
	public int E();
	public void addEdge(int v, int w);
	public Iterable<Integer> adj(int v);
	public boolean hasEdge(int v, int w);
}

class GraphList implements Graph {
	/**
	 * variable declaration.
	 */
	private int numOfVertices;
	/**
	 * variable declaration.
	 */
	private int numOfEdges;
	/**
	 * array declaration.
	 */
	private Bag<Integer>[] adjacent;
	/**
	 * variable declaration.
	 */
	private String[] tokens;

	/**
	 * Constructs the object.
	 */
	GraphList() {
		this.numOfEdges = 0;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      scaan  The scaan
	 */
	GraphList(Scanner scaan) {
		this.numOfVertices = Integer.parseInt(scaan.nextLine());
		adjacent = (Bag<Integer>[]) new Bag[numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			adjacent[i] = new Bag<Integer>();
		}
		int edge = Integer.parseInt(scaan.nextLine());
		tokens = scaan.nextLine().split(",");
		for (int i = 0; i < edge; i++) {
			String[] inputs = scaan.nextLine().split(" ");
			addEdge(Integer.parseInt(inputs[0]),
			        Integer.parseInt(inputs[1]));
		}
	}

	/**
	 * calculates number of vertices.
	 *
	 * @return    number of vertices.
	 */
	public int V() {
		return this.numOfVertices;
	}
	/**
	 * calculates number of edges.
	 *
	 * @return     number of edges.
	 */
	public int E() {
		return this.numOfEdges;
	}
	/**
	 * Adds an edge.
	 *
	 * @param      v     vertex 1.
	 * @param      w     vertex 2.
	 */
	public void addEdge(int v, int w) {
		if (v != w) {
			adjacent[v].add(w);
			adjacent[w].add(v);
			numOfEdges++;
		} else {
			return;
		}
	}
	/**
	 * traverse through the graph.
	 *
	 * @param      v     input vertex.
	 *
	 * @return     vertices.
	 */
	public Iterable<Integer> adj(int v) {
		return adjacent[v];
	}

	/**
	 * Determines if it has edge.
	 *
	 * @param      v     vertex1.
	 * @param      w     vertex2.
	 *
	 * @return     True if has edge, False otherwise.
	 */
	public boolean hasEdge(int v, int w) {
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(numOfVertices + " vertices, " + numOfEdges + " edges" + "\n");
		if (numOfEdges > 0) {
			for (int i = 0; i < numOfVertices; i++) {
				sb.append(tokens[i] + ": ");
				for (int j : adjacent[i]) {
					sb.append(tokens[j] + " ");
				}
				sb.append("\n");
			}
			return sb.toString();
		} else {
			sb.append("No Edges");
			return sb.toString();
		}
	}
}

/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * main method.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String implementationType  = scan.nextLine();
		// int numVertices = Integer.parseInt(scan.nextLine());
		// int numEdges  = Integer.parseInt(scan.nextLine());
		// String[] vertices = scan.nextLine().split(",");

		// while (numEdges > 0) {
		// 	String[] connectedVertices = scan.nextLine().split(" ");
		// 	numEdges--;
		// }
		switch (implementationType) {
		case "List":
			GraphList listObj = new GraphList(scan);
			System.out.println(listObj);
			break;
		case "Matrix":
			break;
		default:
			break;
		}
	}
}
