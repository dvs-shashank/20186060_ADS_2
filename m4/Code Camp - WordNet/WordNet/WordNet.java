import java.util.Arrays;
/**
 * Class for word net.
 */
public class WordNet {
    /**
     * Constructs the object.
     *
     * @param      synsets    The synsets
     * @param      hypernyms  The hypernyms
     */
    public WordNet(String synsets, String hypernyms) {
        parseMySynsetFile(synsets, hypernyms);
    }
    /**
     * parseMySynsetFile.
     *
     * @param      filename  The filename
     */
    void parseMySynsetFile(String filename, String hypernyms) {
        int id = 0;
        int numOfVertices = 0;
        try {
            In inObj = new In(filename);
            while (!inObj.isEmpty()) {
                numOfVertices++;
                String[] fileArray = inObj.readString().split(",");
                id = Integer.parseInt(fileArray[0]);
                String[] nounsArray = fileArray[1].split(" ");
            }
            Digraph digraphObj = new Digraph(numOfVertices);
            parseMyHypernymsFile(hypernyms, digraphObj, numOfVertices);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    void parseMyHypernymsFile(String hypernyms, Digraph tempObj, int numOfVertices) {
        try {
            In inObj = new In(hypernyms);
            while (!inObj.isEmpty()) {
                String[] fileArray = inObj.readString().split(",");
                int v = Integer.parseInt(fileArray[0]);
                for (int i = 1; i < fileArray.length; i++) {
                    //System.out.println(v+"\t"+i);
                    tempObj.addEdge(v, Integer.parseInt(fileArray[i]));
                }
                // int v = Integer.parseInt(fileArray[0]);
                // int w = Integer.parseInt(fileArray[1]);
                //tempObj.addEdge(v, w);
            }
            DirectedCycle dc = new DirectedCycle(tempObj);
            int count = 0;
            for (int i = 0; i < numOfVertices; i++) {
                if (tempObj.outdegree(i) == 0) {
                    count++;
                }
            } if (count >1) {
                System.out.println("Multiple roots");
                return;
            }
            //System.out.println(tempObj);
            if (dc.hasCycle()) {
                System.out.println("Cycle detected");
            } else {
                System.out.println(tempObj);
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }

    }

    // // returns all WordNet nouns
    // public Iterable<String> nouns()

    //is the word a WordNet noun?
    public boolean isNoun(String word) {
        return false;
    }

    // // distance between nounA and nounB (defined below)
    // public int distance(String nounA, String nounB)

    // // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // // in a shortest ancestral path (defined below)
    // public String sap(String nounA, String nounB)

    // // do unit testing of this class
    // public static void main(String[] args)
}
