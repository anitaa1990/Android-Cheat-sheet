package strings;


public class RegularExpression {


    /*
     * Given a text and a pattern, determine if the pattern matches with text completely or not using regular
     * expression matching. For simplicity assume that the pattern may contain only two operators i.e. '.' and '*'.
     * Operator '*' in pattern means that the character preceding '*' may not appear or may appear any number of times
     * in text. Operator '.' matches with any character in text exactly once.
     * */

    /*
     * Runtime Complexity - Exponential
     * Memory Complexity - Exponential
     * */

    public static boolean isRegexMatch(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        if (!text.isEmpty() && pattern.isEmpty()) {
            return false;
        }

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {

            String remainingPattern = pattern.substring(2);
            String remainingText = text;

            for (int i = 0; i < text.length() + 1; ++i) {

                if (isRegexMatch(remainingText, remainingPattern)) {
                    return true;
                }

                if (remainingText.isEmpty()) {
                    return false;
                }

                if (pattern.charAt(0) != '.' && remainingText.charAt(0) != pattern.charAt(0)) {
                    return false;
                }

                remainingText = remainingText.substring(1);
            }
        }

        if(text.isEmpty() || pattern.isEmpty()) {
            return false;
        }

        if(pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
            String remainingText = "";
            if (text.length() >= 2) {
                remainingText = text.substring(1);
            }

            String remainingPattern = "";
            if (pattern.length() >= 2) {
                remainingPattern = pattern.substring(1);
            }

            return isRegexMatch(remainingText, remainingPattern);
        }

        return false;
    }


    static boolean regexMatch(String text, String pattern) {
        return isRegexMatch(text, pattern);
    }


    public static void main(String[] args) {
        String input = "aabbbbbcdda";
        String pattern = "a*bb*cdda"; // -> true
//        String pattern = "a*b*c*da";  // -> false
        System.out.println(regexMatch(input, pattern));
    }
}
