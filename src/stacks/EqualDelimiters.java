package stacks;


import java.util.Stack;

public class EqualDelimiters {


    public static boolean checkIfDelimiterIsEqual(String s) {
        char[] charArr = s.toCharArray();

        if(charArr.length <= 1) return true;

        Stack<Character> stack = new Stack<>();

        for(Character c : charArr) {
            if(c == '[' || c == '{' || c == '(') {
                stack.push(c);

            }

            if(c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                Character character = stack.peek();
                if (c == ')' && character == '(') {
                    stack.pop();
                }

                if (c == ']' && character == '[') {
                    stack.pop();
                }

                if (c == '}' && character == '{') {
                    stack.pop();
                }
            }
        }

        if(s.length() > 0 && stack.isEmpty()){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        String string = "{[]}";
        System.out.println(checkIfDelimiterIsEqual(string));
    }
}
