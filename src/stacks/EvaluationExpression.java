package stacks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class EvaluationExpression {


    public static void main(String[] args) {
        String expression = "3 + 6 * 5 - 1 / 2.5";
        System.out.println(evaluate(convertInfixToPostfix(expression)));
        System.out.println(evaluate(convertInfixToPostfix("100*(2+12)")));
    }


    /*
     * Given an arithmetic expression, evaluate it i.e. calculate its result.
     * Input: 2+3  Output: 5
     * Input: 6+4/2∗2  Output: 10
     * Input: 3+2.45/8  Output: 3.30625
     *
     *
     *
     * Explanation:
     * Arithmetic expressions can be written in the following three forms.
     * a) Infix: Operators are written between the operands, i.e. A + B
     * b) Prefix: Operators are written before the operands, i.e. + A B
     * c) Postfix: Operators are written after the operands, i.e. A B +
     *
     * Infix notation is the usual way of writing expressions which is easy to understand by humans.
     * However, they are harder for computers to evaluate because of the additional work needed to decide precedence.
     * So first we need to convert the infix expression to a postfix expression.
     *
     *
     * Basic algorithm to convert infix -> postfix:
     * Step 1: Initialize a new postfix expression
     * Step 2: Initialize a stack of operators
     * Step 3: Parse the string expression character by charcacter
     * Step 4:
     * while not end of expression
     *       if the current character is an operator
     *          while operators stack is not empty
     *          AND the operator at the top of stack has higher or equal precedence
     *              pop the operator at the top and add it to the postfix expression
     *              push the operator onto the stack
     *       otherwise if the current character is an operand
     *          add it to the postfix expression
     * while stack is not empty
     *      pop the operator from the top and add it to the postfix expression
     *
     * */
    public static double evaluate(List<EvalToken> tokens) {
        Stack<Double> operands = new Stack<>();

        for(EvalToken token : tokens) {
            if(token.isOperator()) {
                Double val2 = operands.peek();
                operands.pop();

                Double val1 = operands.peek();
                operands.pop();

                char op = ((EvalTokenOperator)token).getValue();
                switch (op) {
                    case '+':
                        operands.push(val1+val2);
                        break;

                    case '-':
                        operands.push(val1-val2);
                        break;

                    case '*':
                        operands.push(val1*val2);
                        break;

                    case '/':
                        operands.push(val1/val2);
                        break;
                }

            } else {
                double operand = ((EvalTokenOperand)token).getValue();
                operands.push(operand);
            }
        }

        if(operands.isEmpty()) {
            return 0;
        }

        return operands.peek();
    }



    public static List<EvalToken> convertInfixToPostfix(String expression) {
        List<EvalToken> postFix = new ArrayList<>();

        Stack<Character> operators = new Stack<>();
        int length = expression.length();

        for(int i=0; i<length;) {
            char ch = expression.charAt(i);
            if(ch == ' ' || ch == '\t') {
                ++i;
                continue;
            }

            if (isOperator(ch)) {
                while (!operators.isEmpty() && precede(operators.peek(), ch)) {
                    postFix.add(new EvalTokenOperator(operators.peek()));
                    operators.pop();
                }

                operators.push(ch);
                ++i;

            } else {
                Pair<Double, Integer> doubleIntegerPair = convertStringToDouble(expression, i);
                i = doubleIntegerPair.getValue();
                postFix.add(new EvalTokenOperand(doubleIntegerPair.getKey()));
            }
        }

        while (!operators.isEmpty()) {
            postFix.add(new EvalTokenOperator(operators.peek()));
            operators.pop();
        }

        return postFix;
    }


    /*
     * Method to check if the character is an operator
     * */
    public static boolean isOperator(char c) {
        return c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/';
    }


    /*
     * returns true if the first op1 takes precedence over op2
     *  */
    public static boolean precede(char op1, char op2) {
        if(op1 == '*' || op1 == '/') {
            return true;
        }

        if((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')) {
            return true;
        }

        return false;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c<='9';
    }


    public static Pair<Double, Integer> convertStringToDouble(String s, int i) {
        int len = s.length();
        if (i >= len){
            return null;
        }

        StringBuilder temp = new StringBuilder();
        while(i < len && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            ++i;
        }

        if (i >= len){
            return null;
        }

        if (s.charAt(i) == '-') {
            temp.append('-');
            ++i;
        }

        for (;i < len; ++i) {
            char ch = s.charAt(i);
            if (ch != '.' && !isDigit(ch)) {
                break;
            }

            temp.append(ch);
        }

        return new Pair(Double.parseDouble(temp.toString()), i);

    }
}


    interface EvalToken {
        boolean isOperator();
    };

    class EvalTokenOperator implements EvalToken {
        char value;

        public EvalTokenOperator() {
            value = 0;
        }

        public EvalTokenOperator(char d) {
            value = d;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isOperator() {
            return true;
        }
    }


    class EvalTokenOperand implements EvalToken {

        double value;

        public EvalTokenOperand() {
            value = 0;
        }

        public EvalTokenOperand(double d) {
            value = d;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public boolean isOperator() {
            return false;
        }
    }