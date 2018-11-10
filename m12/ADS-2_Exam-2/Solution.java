import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main method.
	 *
	 * @param      args  The arguments.
	 */
	public static void main(final String[] args) {
		// Self loops are not allowed...
		// Parallel numOfRoads are allowed...
		// Take the Graph input here...
		Scanner scan = new Scanner(System.in);
		int numOfCities = Integer.parseInt(scan.nextLine());
		int numOfRoads = Integer.parseInt(scan.nextLine());
		EdgeWeightedGraph ewgobj = new EdgeWeightedGraph(numOfCities);
		while (numOfCities > 0) {
			String[] tokens = scan.nextLine().split(" ");
			int v = Integer.parseInt(tokens[0]);
			int w = Integer.parseInt(tokens[1]);
			double distance = Double.parseDouble(tokens[2]);
			Edge edge = new Edge(v, w, distance);
			ewgobj.addEdge(edge);
			numOfCities--;
		}
		String caseToGo = scan.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(ewgobj.toString());
			break;

		case "DirectedPaths":
			String[] srcToDestination = scan.nextLine().split(" ");
			int source = Integer.parseInt(srcToDestination[0]);
			int destination = Integer.parseInt(srcToDestination[1]);
			DijkstraUndirectedSP dijkstrasObject = new DijkstraUndirectedSP(ewgobj, source);
			if (dijkstrasObject.hasPathTo(destination)) {
				System.out.println(dijkstrasObject.distTo(destination));
			} else {
				throw new IllegalArgumentException("No Path Found.");
			}
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}