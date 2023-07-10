//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

public class Homework3a {
    public class SingleDirectionalList {
        Node head;


        public class Node {
            int value;
            Node next;
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
    }
}