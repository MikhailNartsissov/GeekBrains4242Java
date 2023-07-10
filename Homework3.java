//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

public class Homework3 {
    public class BiDirectionalList {
        Node head;
        Node tail;

        public class Node {
            int value;
            Node next;
            Node previous;
        }

        public void revert() {
            Node currentNode = head;
            while (currentNode != null) {
                Node next = currentNode.next;
                Node previous = currentNode.previous;
                currentNode.previous = next;
                currentNode.next = previous;
                if (previous == null) {
                    tail = currentNode;
                }
                if (next == null) {
                    head = currentNode;
                }
                currentNode = next;
            }

        }
    }
}