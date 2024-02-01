import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.add(-1);
        head.add(19);
        head.print();
        System.out.println(find(head, 19));
        System.out.println(find_it(head, 19));
    }

    static boolean find(Node node, int value) {
        if (node.value == value) {
            return true;

        }
        if (node.next == null) { //make sure that all the nodes were checked
            // before checking that the last is null and
            //none of the nodes had the value we were searching for.
            return false;
        }
        return (find(node.next, value));

    }

    //non-recursive method, faster and no stack overflow
    static boolean find_it(Node node, int value) {
        Node current = node;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;

        }
        return false;
    }
}

class Node {
    int value;
    Node next;

    Node(int v) {
        value = v;
        next = null;//null can be used to indicate that to node doesnt point to anything.

    }


    void add(int v) {
        if (next == null) {
            next = new Node(v);
        } else
            next.add(v);
    }

    void print() {
        System.out.print(value + " ");
        if (!next.equals(null))
            next.print();
    }

}