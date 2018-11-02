public class SAP {
    private Digraph graph;
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph digraph) {
        this.graph = digraph;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        int shortestPath = 99999999;
        int j = 0;
        BreadthFirstDirectedPaths bfsForV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsForW = new BreadthFirstDirectedPaths(graph, w);
        for (int i = 0; i < graph.V(); i++) {
            if (bfsForV.hasPathTo(i) && bfsForW.hasPathTo(i)) {
                int distance = bfsForV.distTo(i) + bfsForW.distTo(i);
                if (distance > j && distance < shortestPath) {
                    shortestPath = distance;
                }
            }
        }
        if (shortestPath > 0) {
            return shortestPath;
        }
        return -1;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bfsForV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsForW = new BreadthFirstDirectedPaths(graph, w);
        int shortestPath = 99999999;
        int j = 0;
        int ancestor = 0;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsForV.hasPathTo(i) && bfsForW.hasPathTo(i)) {
                int distance = bfsForV.distTo(i) + bfsForW.distTo(i);
                if (distance > j && distance < shortestPath) {
                    shortestPath = distance;
                    ancestor = i;
                }
            }
        }
        if (ancestor > 0) {
            return ancestor;
        }
        return -1;
    }

    // do unit testing of this class
    //public static void main(String[] args)
}