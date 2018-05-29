package strings;



public class RemoveWhiteSpaces {


    /*
     * Given a null terminated string, remove any white spaces (tabs or spaces).
     * Eg:  Input - "All greek  to me."
     *      Output - "Allgreektome"
     *
     * Runtime Complexity - Linear, O(n).
     * Memory Complexity - Constant, O(1).
     *
     * */
    public static String removeWhiteSpaces(String s) {
        char[] arr = s.toCharArray();
        int readIndex = 0;
        String result = "";

        while (readIndex < arr.length && arr[readIndex] != '\0') {
            if(arr[readIndex] != ' ' && arr[readIndex] != '\t') {
                result += arr[readIndex];
            }
            ++readIndex;
        }

        return result;
    }


    public static void main(String[] args) {
        String string = "    All greek  to    me.    \n";
        System.out.println(removeWhiteSpaces(string));
    }
}
