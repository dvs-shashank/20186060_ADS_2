import java.util.Scanner;
/**
 * class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //eval purpose.
    }

    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfVertices = Integer.parseInt(scan.nextLine());
        int numOfEdges = Integer.parseInt(scan.nextLine());
        Digraph dg = new Digraph(numOfVertices);
        while (numOfEdges > 0) {
            String[] connectedVertices = scan.nextLine().split(" ");
            dg.addEdge(Integer.parseInt(connectedVertices[0]),
                       Integer.parseInt(connectedVertices[1]));
            numOfEdges--;
        }
        DirectedCycle dc = new DirectedCycle(dg);
        if (dc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}

