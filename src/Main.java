public class Main {

    public static void main(String[] args) {
        TestItem item = new TestItem();
        Node temp = null;
        temp = new Node(5, null);
        temp = new Node(4,temp);
        temp = new Node(3,temp);
        temp = new Node(2,temp);
        Node header = new Node(1,temp);

        Node.print(header);
        System.out.print("\n");
        Node h = Node.reverse(header);
        Node.print(h);
        //item.testWeakHaskmap();
    }
}

class Node {
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int value;
    public Node next;

    public static  Node reverse(Node header) {
        if (header == null || header.next == null) {
            return header;
        }
        Node t = reverse(header.next);
        header.next.next = header;
        header.next = null;
        return t;
    }

    public static void print(Node header) {
        Node temp = header;
        while (temp != null) {
            System.out.print("" + temp.value + "--");
            temp = temp.next;
        }
    }
}
