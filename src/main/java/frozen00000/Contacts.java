package frozen00000;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts/problem
 */
enum Operation {

    ADD, FIND

}

class ContactNode {

    private HashMap<Character, ContactNode> nodes = new HashMap<>();
    private int size = 0;

    void add(String name) {
        ContactNode contactNode = nodes.computeIfAbsent(name.charAt(0), c -> new ContactNode());
        if (name.length() > 1) {
            contactNode.add(name.substring(1));
        } else {
            contactNode.size = 1;
        }
        size++;
    }

    int find(String pref) {
        ContactNode contactNode = nodes.get(pref.charAt(0));
        if (contactNode == null) {
            return 0;
        } else if (pref.length() == 1) {
            return contactNode.size;
        }
        return contactNode.find(pref.substring(1));
    }

}

public class Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ContactNode root = new ContactNode();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            switch (Operation.valueOf(op.toUpperCase())) {
                case ADD: root.add(contact); break;
                case FIND: System.out.println(root.find(contact)); break;
            }
        }
    }

}
