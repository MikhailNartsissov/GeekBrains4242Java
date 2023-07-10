//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

public class SDLinkedList {
    private Node head;

    public void add(int nodeValue){
        if (head == null) {
            head = new Node(nodeValue);
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(nodeValue);
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }

    public void revert(){
        if (head != null && head.next != null){
            revert(head.next, head);
        }
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) head =currentNode;
        else revert(currentNode.next, currentNode);
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    private class Node {
        int value;
        Node next;
        Node() {

        }
        Node (int _value) {
            this.value = _value;
        }
    }
}

