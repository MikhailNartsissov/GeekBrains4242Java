//Задание
//        Пусть дан произвольный список целых чисел.
//
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение
//


import java.util.ArrayList;
import java.util.Random;

public class Homework3 {
    public static int getRandom(int maxValue){
        return new Random().nextInt(maxValue);
    }
    public static void doMyHomeworkPlease(ArrayList<Integer> initial) {
        ArrayList<Integer> result = new ArrayList<>();
        Double avgInitial = 0.0;
        Integer maxInitial = initial.get(0);
        Integer minInitial = initial.get(0);
        for (Integer element: initial
             ) {
            avgInitial += element;
            if (element % 2 != 0) result.add(element); // Отбираем только нечётные числа
            if (element < minInitial) minInitial = element;
            if (element > maxInitial) maxInitial = element;
        }
        avgInitial /= initial.size();
        System.out.println("\nСписок без чётных чисел: " + result);
        System.out.println("Минимальное значение исходного списка: " + minInitial);
        System.out.println("Максимальное значение исходного списка: " + maxInitial);
        System.out.println("Среднеее значение исходного списка: " + avgInitial);
    }

    public static void main(String[] args) {
        ArrayList<Integer> initialList = new ArrayList<>();
        int listSize = getRandom(20);
        for (int i = 0; i < listSize; i++){
            initialList.add(getRandom(100));
        }
        System.out.println("\nИсходный список: " + initialList);
        doMyHomeworkPlease(initialList);
    }
}
