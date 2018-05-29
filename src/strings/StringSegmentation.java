package strings;


import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {

    /*
     * Given a dictionary of words and an input string tell whether the input string can be completely
     * segmented into dictionary words
     * Eg:  Input - Set<String> dict = [hello, hell, on, now], String s = "hellonow"
     *      Output - Can "hellonow" be segmented into Hello & now? - true or false
     *
     *  Runtime Complexity - Polynomial, O(n2).
     *  Memory Complexity - Polynomial, O(n2). Memory Complexity is O(n2), because we create substring on each recursion
     *  call.
     *
     *  We are using memorization - remembering the already solved substrings, so we don't go about solving them again.
     *  This will reduce the runtime of the algorithm to O(n2)
     *
     * */
    public static boolean canBeSegmented(Set<String> firstDict,
                                         Set<String> secondDict,
                                         String s) {

        for(int i=1; i<s.length(); i++) {
            String first = s.substring(0, i);

            if(firstDict.contains(first)) {
                String second = s.substring(i);
                if(second == null || second.length() == 0 || firstDict.contains(second)) {
                    return true;
                }

                if(!secondDict.contains(second)) {
                    if(!canBeSegmented(firstDict, secondDict, second)) {
                        return false;
                    }
                    secondDict.add(second);
                }
            }
        }

        return false;
    }




    public static void main(String[] args) {
        Set<String> firstDict = new HashSet<>();
        firstDict.add("apple");
        firstDict.add("pear");
        firstDict.add("pier");
        firstDict.add("pie");

        Set<String> secondDict = new HashSet<>();
        String string = "pearpie";
        System.out.println(canBeSegmented(firstDict,secondDict, string));
    }
}
