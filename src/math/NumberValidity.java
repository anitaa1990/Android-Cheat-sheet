package math;

public class NumberValidity {


    /*
     * Given an input string, determine if it makes a valid number or not
     *
     * Eg: 4.325 is a valid number.
     * 1.1.1 is NOT a valid number.
     * 222 is a valid number.
     * 22. is a valid number.
     * 22.22. is NOT a valid number
     *
     * Runtime Complexity:
     * Linear, O(n)
     *
     * Memory Complexity:
     * Constant, O(1)
     *
     *
     * */

    enum STATE {START, INTEGER, DECIMAL, UNKNOWN}

    ;

    private static STATE getNextState(STATE current_state,
                                      char ch) {

        switch (current_state) {

            case START:
            case INTEGER:
                if (ch == '.') {
                    return STATE.DECIMAL;
                } else if (ch >= '0' && ch <= '9') {
                    return STATE.INTEGER;
                } else {
                    return STATE.UNKNOWN;
                }

            case DECIMAL:
                if (ch >= '0' && ch <= '9') {
                    return STATE.DECIMAL;
                } else {
                    return STATE.UNKNOWN;
                }
        }

        return STATE.UNKNOWN;
    }

    static boolean isNumberValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }

        STATE current_state = STATE.START;

        while (i < s.length()) {
            current_state = getNextState(current_state, s.charAt(i));

            if (current_state == STATE.UNKNOWN) {
                return false;
            }

            i = i + 1;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "4.325";

        boolean isValid = isNumberValid(s);
        if (isValid) {
            System.out.println(s + " is valid.");
        } else {
            System.out.println(s + " is not valid.");
        }
    }
}
