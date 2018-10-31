/**
 * Class for digraph.
 */
class Digraph {
    /**
     * {number of vertices in  digraph}.
     */
    private final int V;
    /**
     * {number of edges in  digraph}.
     */
    private int E;
    /**
     * {adj[v] = adjacency list for vertex v}.
     */
    private Bag<Integer>[] adj;
    /**
     * {indegree[v] = indegree of vertex v}.
     */
    private int[] indegree;
    /**
     * Constructs the object.
     *
     * @param      V     { parameter_description }.
     */
    Digraph(final int V) {
        if (V < 0) {
            throw new IllegalArgumentException(
                "Number of vertices in a Digraph must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     *
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int V() {
        return V;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int E() {
        return E;
    }

    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }.
     * @param      w     { parameter_description }.
     */
    public void addEdge(final int v, final int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
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
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int outdegree(final int v) {
        return adj[v].size();
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int indegree(final int v) {
        return indegree[v];
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
}