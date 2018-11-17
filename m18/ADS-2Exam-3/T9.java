import java.util.HashMap;

/**
 * Class for t 9.
 */
public class T9 {
    /**
     * variable.
     */
    private TST tstObject;
    /**
     * Constructs the object.
     *
     * @param      st    { parameter_description }
     */
    public T9(final BinarySearchST<String, Integer> st) {
        // your code goes here
        tstObject = new TST<Integer>();
        for (String word : st.keys()) {
            tstObject.put(word, st.get(word));
        }
    }

    // get all the prefixes that match with given prefix.

    /**
     * Gets all words.
     *
     * @param      prefix  The prefix
     *
     * @return     All words.
     */
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        return tstObject.keysWithPrefix(prefix);
    }

    /**
     * { function_description }.
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */

    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here
        HashMap hm = new HashMap();
        // hm.put("d", 2);
        //System.out.println(hm.get(1));
        if (tstObject.contains(t9Signature)) {
            System.out.println(t9Signature);
        }
        return null;
    }

    // return all possibilities(words), find top k with highest frequency.

    /**
     * Gets the suggestions.
     *
     * @param      words  The words
     * @param      k      { parameter_description }
     *
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(final Iterable<String> words,
                                           final int k) {
        //Iterable<String> iterable = new Iterable<String>();
        // for (int i = 0; i < words.length(); i++) {
        //  int y = tstObject.get(words[i]);
        //  if (y == k) {
        //      suggestions[i] = words[i];
        //  }
        // }int x = (int)
        // tstObject.get("a");
        for (String each : words) {
            //System.out.println(each);
            System.out.println(tstObject.keysWithPrefix(each));
            //System.out.println(tstObject.get(each));;
            // if (x == k) {
            //  System.out.println(each);
            // }
        }
        // System.out.println(words[i]);
        return null;
    }

    // final output
    // Don't modify this method.

    /**
     * { function_description }.
     *
     * @param      t9Signature  The t 9 signature
     * @param      k            { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> t9(final String t9Signature,
                               final int k) {
        return getSuggestions(potentialWords(t9Signature),
                              k);
    }
}

