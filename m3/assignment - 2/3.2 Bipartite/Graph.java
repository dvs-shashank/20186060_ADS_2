/**
 * Class for graph.
 */
public class Graph {
    /**
     * { var_description }.
     */
    private final int vertices;
    /**
     * { var_description }.
     */
    private int edges;
    /**
     * { var_description }
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      val     { parameter_description }.
     */
    public Graph(final int val) {
        if (val < 0) {
            throw new RuntimeException(
                "Number of vertices must be nonnegative");
        }
        this.vertices = val;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[val];
        for (int v = 0; v < val; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Constructs the object.
     *
     * @param      val     { parameter_description }.
     * @param      eeedge     { parameter_description }.
     */
    public Graph(final int val, final int eeedge) {
        this(val);
        if (eeedge < 0) {
            throw new RuntimeException(
                "Number of edges must be nonnegative");
        }
        for (int i = 0; i < eeedge; i++) {
            int v = (int) (Math.random() * val);
            int w = (int) (Math.random() * val);
            addEdge(v, w);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int numV() {
        return vertices;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int numE() {
        return edges;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        s.append(vertices + " vertices, " + edges + " edges " + newLine);
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(newLine);
        }
        return s.toString();
    }

}

