package strings;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {


    /*
     * Given a string that contains duplicate occurrences of characters, remove these duplicate occurrences
     * Eg.  Input: "abbabcddbabcdeedebc"
     *      Output: "abcde"
     *
     * Why to use LinkedHashSet instead of HashSet in this case?
     * A HashSet is unordered and unsorted Set. LinkedHashSet is the ordered version of HashSet.
     * The only difference between HashSet and LinkedHashSet is that LinkedHashSet maintains the insertion order.
     * When we iterate through a HashSet, the order is unpredictable while it is predictable in case of LinkedHashSet.
     * The reason why LinkedHashSet maintains insertion order is because the underlying data structure is a doubly-linked list.
     *
     * */
    public static String removeDuplicates(String s) {
        Set<Character> characterSet = new LinkedHashSet<>();
        char[] charArr = s.toCharArray();

        for(char c: charArr) {
            characterSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : characterSet) {
            sb.append(character);
        }
        return sb.toString();
    }


        // this solution uses extra memory
        // to keep all characters present in string.

        // Null terminating strings are not used in Java.
        // For this question, assume that you are passed a
        // null terminated string (array of characters).
    /*
     * Runtime Complexity - Linear O(n).
     * Memory Complexity - Linear, O(n).
     * */
    public static void removeDuplicates1(char[] str){
        Set<Character> hashSet = new LinkedHashSet<>();

        int write_index = 0;
        int read_index = 0;

        while (str[read_index] != '\0') {

            if(!hashSet.contains(str[read_index])) {

                hashSet.add(str[read_index]);
                str[write_index] = str[read_index];
                ++write_index;
            }

            ++read_index;
        }

        str[write_index] = '\0';
    }



    // this solution does not require any extra memory
    // but runs in O(n^2) time

    // Null terminating strings are not used in Java.
    // For this question, assume that you are passed a
    // null terminated string (array of characters).
    public static void removeDuplicates2(char[] str){
        if(str == null || str.length == 0) {
            return;
        }

        int write_index = 0;
        for(int i = 0; i < str.length; i++) {
            boolean found = false;

            for(int j = 0; j < write_index; j++) {
                if(str[i] == str[j]) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                str[write_index] = str[i];
                write_index++;
            }
        }

        str[write_index] = '\0';
    }


    public static void main(String[] args) {
        String string = "abbabcddbabcdeedebc";
        System.out.println(removeDuplicates(string));
    }
}
