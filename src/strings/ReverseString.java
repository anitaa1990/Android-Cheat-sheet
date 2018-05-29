package strings;

public class ReverseString {


    /*
     * Reverse characters in a sentence
     * Eg: "Hello World" -> "dlroW olleH"
     *
     * */

    public static String reverseString(String s) {
        String reverse = "";

        char[] charArr = s.toCharArray();
        for(int c = charArr.length-1; c>=0; c--) {
            reverse += charArr[c];
        }
        return reverse;
    }


    /*
     * Reverse words in a sentence
     * Eg: "Hello World" -> "World Hello"
     *
     * Linear, O(n) - Position of all the elements in the sentence is changed.
     * Memory Complexity - Constant, O(1). The solution reverses every word in-place i.e.
     * it does not require any extra space.
     *
     * */


    /*
     * This solution of using a String called 'reverse' would affect performance if the string is really long.
     * Since string is immutable, every word added to the reverse String creates a new object. So if we have a really
     * long sentence, and we split that sentence & store in an array, (size of array n = 1Million, then for each iteration
     * a new string object would be created.
     * In order to address this issue, StringBuilder/StringBuffer can be used. They are mutable.
     * Difference between StringBuilder & StringBuffer - StringBuilder is not thread safe whereas StringBuffer is
     * thread-safe.
     * http://www.techtamasha.com/difference-between-string-and-stringbufferstringbuilder-in-java/28
     * */
    public static String reverseWord(String s) {
        String reverse = "";

        String[] arr = s.split(" ");
        for(int i=arr.length-1; i>=0; i--) {
            reverse += arr[i] + " ";
        }

        return reverse;
    }


    public static void main(String[] args) {
        String string = "The quick brown fox jumped over the lazy dog.";
        System.out.println(reverseString(string));
        System.out.println(reverseWord(string));
    }
}
