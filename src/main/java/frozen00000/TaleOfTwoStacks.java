package frozen00000;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */

public class TaleOfTwoStacks {

    public static class MyQueue<T> {
        private Stack<T> stackNewestOnTop = new Stack<>();
        private Stack<T> stackOldestOnTop = new Stack<>();

        void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        T peek() {
            check();
            return stackOldestOnTop.peek();
        }

        T dequeue() {
            check();
            return stackOldestOnTop.pop();
        }

        void check() {
            if (stackOldestOnTop.isEmpty()) {
                int i = stackNewestOnTop.size();
                while (i-- > 0) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

}
