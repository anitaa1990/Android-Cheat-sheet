package strings;

public class CheckIfAnagram {


    /*
     * Input: "Keep", "Peek"
     * Output: false
     * */
    public static boolean checkIfAnagram(String word1, String word2) {
        char[] cArr1 = word1.toCharArray();
        char[] cArr2 = word2.toCharArray();

        int n1 = cArr1.length;
        int n2 = cArr2.length;

        if(n1 != n2) return false;

        quickSort(cArr1, 0, n1-1);
        quickSort(cArr2, 0, n2-1);

        for(int i=0; i<cArr1.length; i++) {
            if(cArr1[i] != cArr2[i]) {
                return false;
            }
        }

        return true;
    }


    private static void quickSort(char[] arr, int lowerIndex, int upperIndex) {
        if(lowerIndex < upperIndex) {
            int partition = partition(arr, lowerIndex, upperIndex);
            quickSort(arr, lowerIndex, partition-1);
            quickSort(arr, partition+1, upperIndex);
        }
    }

    private static int partition(char[] arr, int lowerIndex, int upperIndex) {
        int pivot = arr[upperIndex];
        int i = lowerIndex-1;

        for(int j=lowerIndex; j< upperIndex; j++) {
            if(arr[j] <= pivot) {
                i++;
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        char temp = arr[upperIndex];
        arr[upperIndex] = arr[i+1];
        arr[i+1] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "ttew";
        System.out.println(checkIfAnagram(s1, s2));
    }
}
