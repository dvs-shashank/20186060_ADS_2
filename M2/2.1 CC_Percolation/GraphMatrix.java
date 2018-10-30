import java.util.Scanner;
/**
 * Class for graph matrix.
 */
class GraphMatrix {
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
    GraphMatrix(final Scanner scan) {
        int v = Integer.parseInt(scan.nextLine());
        matrix = new int[v + 2][v + 2];
        String[] inputs = scan.nextLine().split(" ");
        addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }

    /**
     * calculates number of vertices.
     *
     * @return    number of vertices.
     */
    public int numOfVertices() {
        return this.numOfVertices;
    }
    /**
     * calculates number of edges.
     *
     * @return     number of edges.
     */
    public int numOfEdges() {
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
    /**
     * adjacent.
     *
     * @param      v1    The v 1
     *
     * @return     { description_of_the_return_value }.
     */
    public int[] adj(final int v1) {
        return matrix[v1];
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
}