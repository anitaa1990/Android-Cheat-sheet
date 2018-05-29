package strings;

import java.util.ArrayList;
import java.util.List;

public class PalindroneStrings {

    /*
     * Given a string find all substrings that are palindromes.
     * Input - "aabbbaa"
     * Output - aa, bb, bbb, abbba, aabbbaa, bb,aa
     * */


    /*
     * A naive solution of this problem is to find all substrings of a given string and check whether each substring
     * is a palindrome or not. This solution has a complexity of O(n3).
     *
     * We can reduce the runtime of this algorithm to O(n2) by using the following approach.
     * For each letter in the input string, start expanding to left and right while checking for even and
     * odd length palindromes. Move to the next letter if we know a palindrome doesn't exist.
     * We expand one character to the left and right and compare them. If both of them are equal,
     * we print out the palindrome substring.
     * */

    /*
     * Runtime Complexity - Polynomial, O(n2).
     * Memory Complexity - Constant, O(1).
     *
     * */
    public static List<String> findAllPalindromesInString(String input) {
        List<String> words = new ArrayList<>();
        for(int i=0; i<input.length(); ++i) {
            words.addAll(findPalindromeInSubString(input, i-1, i+1));
            words.addAll(findPalindromeInSubString(input, i, i+1));
        }
        return words;
    }

    private static List<String> findPalindromeInSubString(String input, int start, int end) {
        List<String> words = new ArrayList<>();
        for(;start >=0 && end<input.length(); --start, ++end) {
            if(input.charAt(start) != input.charAt(end)) {
                break;
            }
            words.add(input.substring(start, end+1));
        }

        return words;
    }


    public static void main(String[] args) {
        String input = "aabbbaa";
        System.out.println(findAllPalindromesInString(input));
    }
}
