package frozen00000;

import java.util.*;

public class BalancedBrackets {

    private static final Set<Character> OPENING_BRACKETS = new HashSet<>();
    private static final Map<Character, Character> BRACKETS_MAP = new HashMap<>();

    static {
        OPENING_BRACKETS.add('(');
        OPENING_BRACKETS.add('[');
        OPENING_BRACKETS.add('{');

        BRACKETS_MAP.put('(', ')');
        BRACKETS_MAP.put('{', '}');
        BRACKETS_MAP.put('[', ']');
    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (OPENING_BRACKETS.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char d = stack.pop();
                if (BRACKETS_MAP.get(d) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }

}
