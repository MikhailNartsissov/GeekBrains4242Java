// Разработать программу, имитирующую поведение коллекции HashSet. В программе содать метод add добавляющий элемент,
// метод toString возвращающий строку с элементами множества *и метод позволяющий читать элементы по индексу.
//        *Реализовать все методы из семинара.
//        Формат данных Integer.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Homework6 {
    public static void main(String[] args) {
        CustomHashSet<Integer> mySet = new CustomHashSet<>();
        System.out.println("\n*******");
        for (int i = 0; i <= getRandom(10); i++) {
            int value = getRandom(5);
            boolean result = mySet.add(value);
            System.out.println("mySet.add(" + value + ") = " + result);
        }
        System.out.println("*******");
        for (int i = 0; i <= getRandom(7); i++) {
            int value = getRandom(3);
            boolean result = mySet.remove(value);
            System.out.println("mySet.remove(" + value + ") = " + result);
        }
        System.out.println("*******\nCurrent state of mySet = " + mySet.toString() + "\n*******");
        Iterator<Integer> mySetIterator = mySet.iterator();
        while (mySetIterator.hasNext()) System.out.println("Iterator value = " + mySetIterator.next());
    }
public static int getRandom(int maxValue){
        return new Random().nextInt(maxValue);
    }

static class CustomHashSet<T> {
    private HashMap<T, Object> map = new HashMap<>();
    private static final Object DUMB = new Object();

    public boolean add(T item) { return map.put(item, DUMB) == null; }
    public boolean remove(T item) { return map.remove(item) == DUMB; }
    public String toString() { return map.keySet().toString(); }
    public Iterator<T> iterator() { return map.keySet().iterator(); }

    }
}
