public class Main {
    public static void main(String[] args) {
        SDLinkedList list = new SDLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("\nИсходный односвязный список:");
        list.print();
        list.revert();
        System.out.println("\n*********\nРазвёрнутый односвязный список:");
        list.print();
        System.out.println("\n*********\n");
    }
}
