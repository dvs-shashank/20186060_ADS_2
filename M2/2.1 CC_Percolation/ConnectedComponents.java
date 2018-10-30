public class ConnectedComponents {
    /**
     * array declaration.
     */
    private boolean[] marked;
    /**
     * array declaration.
     */
    private int[] id;
    /**
     * array declaration.
     */
    private int[] size;
    /**
     * variable declaration.
     */
    private int count;

    /**
     * Computes the connected components of the undirected graph {@code G}.
     *
     * @param G the undirected graph.
     */
    public ConnectedComponents(GraphMatrix G) {
        marked = new boolean[G.numOfVertices()];
        id = new int[G.numOfVertices()];
        size = new int[G.numOfVertices()];
        for (int v = 0; v < G.numOfVertices(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /**
     * Computes the connected components of the edge-weighted graph {@code G}.
     *
     * @param G the edge-weighted graph
     */

    // depth-first search for a Graph
    private void dfs(GraphMatrix G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int id(int v) {

        return id[v];
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int size(int v) {
        return size[id[v]];
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public int count() {
        return count;
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }.
     * @param      w     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public boolean connected(int v, int w) {

        return id(v) == id(w);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public boolean connect() {
        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }
}