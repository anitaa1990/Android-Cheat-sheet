package dynamicprogramming;

public class LevenshteinDistance {

    /*
     * Compute Levenshtein distance between two strings.
     * Given two strings, compute the Levenshtein distance between them i.e.
     * the minimum number of edits required to convert one string into the other.
     *
     * For example, the Levenshtein distance between "kitten" and "sitting" is 3.
     * The minimum steps required to transform the former into latter are:
     *      kitten → sitten (substitution of "s" for "k")
     *      sitten → sittin (substitution of "i" for "e")
     *      sittin → sitting (insertion of "g" at the end)
     *
     * Runtime Complexity:
     * Quadratic, O(n2)
     *
     * Memory Complexity:
     * Quadratic, O(n2)
     *
     * Levenshtein distance 'LD' is  a measure of the difference between two strings s1 and s2.
     * It is the minimum number of deletions, insertions, or substitutions required to transform s1 into s2.
     *
     * if s1 is empty, return length of s2
     * if s2 is empty, return length of s1
     * if last characters of s1 and s2 match, initialize 'cost' to 0, otherwise initialize 'cost' to 1
     *      recursively compute 'd1' [(Levenshtein distance of s1 - 1 and s2) + 1 ]
     *      recursively compute 'd2' [(Levenshtein distance of s1 and s2 - 1) + 1]
     *      recursively compute 'd3' [(Levenshtein distance of s1 - 1 and s2 - 1) + cost]
     *      return minimum of d1, d2, d3
     * */

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(String str1,
                                                 String str2) {

        if (str1 == str2) return 0;

        if (str1.length() == 0)
            return str2.length();

        if (str2.length() == 0)
            return str1.length();


        int[][] d = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            d[i][0] = i;
        }

        for (int j = 1; j <= str2.length(); j++) {
            d[0][j] = j;
        }

        int cost;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    cost = 0;
                else
                    cost = 1;

                d[i][j] = minimum(
                        d[i - 1][j] + 1,
                        d[i][j - 1] + 1,
                        d[i - 1][j - 1] + cost);
            }
        }

        return d[str1.length()][str2.length()];
    }



    public static void main(String[] args) {

        System.out.println(computeLevenshteinDistance("", ""));
        System.out.println(computeLevenshteinDistance("kite", ""));
        System.out.println(computeLevenshteinDistance("", "kitten"));
        System.out.println(computeLevenshteinDistance("computer", "computer"));
        System.out.println(computeLevenshteinDistance("test", "text"));
        System.out.println(computeLevenshteinDistance("kitten", "sitting"));
        System.out.println(computeLevenshteinDistance("this is a string", "This is a string"));
        System.out.println(computeLevenshteinDistance("this is a string", "thisisastring"));
        System.out.println(computeLevenshteinDistance("appropriate meaning", "approximate matching"));
        System.out.println(computeLevenshteinDistance("intention", "execution"));
        System.out.println(computeLevenshteinDistance("min", "max"));
    }
}
