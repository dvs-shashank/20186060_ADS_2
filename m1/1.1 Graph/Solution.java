import java.util.Scanner;
/**
 * Class for graph matrix.
 */
class GraphMatrix implements Graph {
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
	private int[][] matrix;
	/**
	 * variable declaration.
	 */
	private String[] tokens;

	/**
	 * Constructs the object.
	 */
	GraphMatrix() {
		this.numOfEdges = 0;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      scaan  The scaan
	 */
	GraphMatrix(final Scanner scaan) {
		this.numOfVertices = Integer.parseInt(scaan.nextLine());
		matrix =  new int[numOfVertices][numOfVertices];
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
	public void addEdge(final int v, final int w) {
		if (v != w) {
			if (!hasEdge(v, w)) {
				matrix[v][w] = 1;
				matrix[w][v] = 1;
				numOfEdges++;
			}
		} else {
			return;
		}
	}
	public Iterable<Integer> adj(final int v) {
		return null;
	}

	/**
	 * Determines if it has edge.
	 *
	 * @param      v     vertex1.
	 * @param      w     vertex2.
	 *
	 * @return     True if has edge, False otherwise.
	 */
	public boolean hasEdge(final int v, final int w) {
		if (matrix[v][w] == 1) {
			return true;
		}
		return false;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String output() {
		String str = "";
		str += numOfVertices + " vertices, " + numOfEdges + " edges" + "\n";
		if (numOfEdges > 0) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					str += matrix[i][j] + " ";
				}
				str += "\n";
			}
		} else {
			str += "No edges";
			return str;
		}
		return str;
	}
}
/**
 * List of graphs.
 */
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
	GraphList(final Scanner scaan) {
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
	public void addEdge(final int v, final int w) {
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
	public Iterable<Integer> adj(final int v) {
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
	public boolean hasEdge(final int v, final int w) {
		return false;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
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
			sb.append("No edges");
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
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String implementationType  = scan.nextLine();
		switch (implementationType) {
		case "List":
			GraphList listObj = new GraphList(scan);
			System.out.println(listObj);
			break;
		case "Matrix":
			GraphMatrix matObj = new GraphMatrix(scan);
			System.out.println(matObj.output());
			break;
		default:
			break;
		}
	}
}
