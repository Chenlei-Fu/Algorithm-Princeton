import java.util.Stack;
public class DijkstraTwoStack {
    public static Integer ArithmeticEvaluation(String s) {
        char[] input = s.toCharArray();
        Stack<Character> ops = new Stack<Character>();
        Stack<Integer> vals = new Stack<Integer>();
        for (char c : input) {
            if (c == '(')
                continue;
            else if (c == '+')
                ops.push(c);
            else if (c == '*')
                ops.push(c);
            else if (c == ')') {
                final char op = ops.pop();
                if (op == '+')
                    vals.push(vals.pop() + vals.pop());
                else if (op == '*')
                    vals.push(vals.pop() * vals.pop());
            } else
                vals.push((c - '0'));
        }

        return vals.pop();
    }

    public static void main(final String[] args) {
        final String input = "(1+((2+3)*(4*5)))";
        System.out.println(ArithmeticEvaluation(input));
    }
}
/* value: put onto the value stack
 * operator: put onto the operator stack
 * left parenthesis: ignore
 * right parenthesis: pop operator and two values: push the result of applying that operator the those values onto the operant stack
 */